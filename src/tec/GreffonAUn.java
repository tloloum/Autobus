package tec;

import java.util.LinkedList;

import clc.Collecte;

class GreffonAUn implements Vehicule, Transport{
    private Vehicule vehicule;
    private Transport transport;
    private Collecte collecte;

    private LinkedList<Passager> passagers;

    public GreffonAUn(Collecte collecte, Transport transport){
        this.transport = transport;
        this.vehicule = (Vehicule) transport;
        this.collecte = collecte;
        this.passagers = new LinkedList<Passager>();
    }

    public void arretDemanderAssis(Passager passager){
        return;
    }

    public void arretDemanderDebout(Passager passager){
        return;
    }

    public void arretDemanderSortie(Passager passager){
        return;
    }

    public void monteeDemanderAssis(Passager passager){
        vehicule.monteeDemanderAssis(passager);

        passagers.add(passager);

        collecte.uneEntree();
    }

    public void monteeDemanderDebout(Passager passager){
        vehicule.monteeDemanderDebout(passager);

        passagers.add(passager);

        collecte.uneEntree();
    }

    public void testerSorties(){
        
        LinkedList<Passager> toRemove = new LinkedList<Passager>();

        for (Passager passager : passagers) {
            if (passager.estDehors()) {
                collecte.uneSortie();
                toRemove.add(passager);
            }
        }

        for (Passager passager : toRemove) {
            passagers.remove(passager);
        }
    }

    public void allerArretSuivant() {
        transport.allerArretSuivant();

        testerSorties();

        collecte.changerArret();
    }

    public boolean aPlaceAssise(){
        return vehicule.aPlaceAssise();
    }

    public boolean aPlaceDebout(){
        return vehicule.aPlaceDebout();
    }

    @Override
    public String toString(){
        return vehicule.toString();
    }
}
