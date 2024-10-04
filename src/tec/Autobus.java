package tec;

import java.util.LinkedList;

class Autobus implements Vehicule, Transport{


    private int numeroArret;

    private int nbPlaceAssise;
    private int nbPlaceDebout;

    private Jauge jaugeAssis;
    private Jauge jaugeDebout;

    private LinkedList<Passager> passagers;


    public Autobus(int nbPlaceAssise, int nbPlaceDebout){

        if(nbPlaceAssise<0 || nbPlaceDebout<0){
            throw(new IllegalArgumentException("nombre place négatif"));
        }

        this.nbPlaceAssise = nbPlaceAssise;
        this.nbPlaceDebout = nbPlaceDebout;

        jaugeAssis = new Jauge(nbPlaceAssise,0);
        jaugeDebout = new Jauge(nbPlaceDebout,0);

        this.numeroArret = 0;
        this.passagers = new LinkedList<Passager>();

    }

    /*  Retourne l'index du premier emplacement 
        vide trouvé dans le tableau passagers,
        retourne -1 si aucun emplacement vide.
        Obsolète avec les collections.
    */
   /*
    private int chercherEmplacementVide() {

        for(int i = 0; i<passagers.length; i++){
            if(passagers[i]==null){
                return i;
            }
        }

        return -1;

    }
*/
    /*  Retourne l'index de l'emplacement 
        du passager p, retourne -1 si non trouvé.
    */
    private int chercherPassager(Passager p){
        int id=passagers.size();
        for(int i=0; i<id; i++){
            if(p.equals(passagers.get(i))){
                return i;
            }
        }

        return -1;
    }

    public void allerArretSuivant(){

        numeroArret++;

        for(Passager p: new LinkedList<Passager>(passagers)){
            
            Passager tmp = p;

            if (tmp!=null){

                p.nouvelArret(this, numeroArret);

            }

        }

    }

    public boolean aPlaceAssise(){
        return jaugeAssis.estVert();
    }

    public boolean aPlaceDebout(){
        return jaugeDebout.estVert();
    }

    public void monteeDemanderAssis(Passager passager){

        if(chercherPassager(passager)!=-1){
            throw(new IllegalStateException("Déjà dans le transport (demande assis)"));
        }

        if(aPlaceAssise() && passager.estDehors()){
            passager.changerEnAssis();
            jaugeAssis.incrementer();
            nbPlaceAssise --;
            passagers.add(passager);
        }
    }

    public void monteeDemanderDebout(Passager passager){

        if(chercherPassager(passager)!=-1){
           throw(new IllegalStateException("Déjà dans le transport (demande debout)"));
        }
        
        if(aPlaceDebout() && passager.estDehors()){
            passager.changerEnDebout();
            jaugeDebout.incrementer();
            nbPlaceDebout --;
            passagers.add(passager);
        }
    }

    public void arretDemanderAssis(Passager passager){

        if(aPlaceAssise() && passager.estDebout()){
            passager.changerEnAssis();
            jaugeDebout.decrementer();
            nbPlaceAssise --;
            nbPlaceDebout ++;
            jaugeAssis.incrementer();
        }
    }

    public void arretDemanderDebout(Passager passager){

        if(aPlaceDebout() && passager.estAssis()){
            passager.changerEnDebout();
            jaugeDebout.incrementer();
            nbPlaceDebout --;
            nbPlaceAssise ++;
            jaugeAssis.decrementer();
        }
    }


    public void arretDemanderSortie(Passager p){

        passagers.remove(p);

        if(p.estDebout()){
            jaugeDebout.decrementer();;
            nbPlaceDebout ++;
        }

        else{
            jaugeAssis.decrementer();
            nbPlaceAssise ++;
        }

        p.changerEnDehors();

    }

    @Override
    public String toString(){

        return "Arret : " + numeroArret + "\n nbPlaceAssise : " 
        + nbPlaceAssise + "\n nbPlaceDebout : " + nbPlaceDebout ;

    }
    
}