package tec;

import clc.Collecte;

class GreffonEstUn extends Autobus {
    private Collecte collecte;

    public GreffonEstUn(int nbPlaceAssise, int nbPlaceDebout, Collecte collecte){
        super(nbPlaceAssise, nbPlaceDebout);
        this.collecte = collecte;
    }


    public void monteeDemanderAssis(Passager passager){
        super.monteeDemanderAssis(passager);
        collecte.uneEntree();
    }

    public void monteeDemanderDebout(Passager passager){
        super.monteeDemanderDebout(passager);
        collecte.uneEntree();
    }

    public void arretDemanderSortie(Passager p){
        super.arretDemanderSortie(p);
        collecte.uneSortie();
    }
     public void arretDemanderAssis(Passager p){
        super.arretDemanderAssis(p);
    }

    public void arretDemanderDebout(Passager p){
        super.arretDemanderDebout(p);
    }

    public void allerArretSuivant() {
        super.allerArretSuivant();
        collecte.changerArret();
    }

    public boolean aPlaceAssise(){
        return super.aPlaceAssise();
    }

    public boolean aPlaceDebout(){
        return super.aPlaceDebout();
    }
}
