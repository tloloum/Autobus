package clc;

class Maillon{
    int entree;
    int sortie;
    int arret;
    public Maillon(int entree,int sortie,int arret){
        this.entree=entree;
        this.sortie=sortie;
        this.arret=arret;
    }
    
    public Maillon(Maillon m){
        this.entree=m.entree;
        this.sortie=m.sortie;
        this.arret=m.arret;
    }
    
}