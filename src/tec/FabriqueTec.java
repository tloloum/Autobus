package tec;

import clc.Collecte;

public final class FabriqueTec {

    public static Usager faireMonteeSportif(String nom, int dest, Arret arret) {

        return new MonteeSportif(nom, dest, arret);

    }

    private FabriqueTec() {}

    public static Usager fairePassagerIndecis(String nom, int dest) {

        return new PassagerIndecis(nom, dest);

    }

    public static Usager fairePassagerStresse(String nom, int dest) {

        return new PassagerStresse(nom, dest);

    }

    public static Usager fairePassagerStandard(String nom, int dest){
        return new PassagerStandard(nom, dest);
    }

    public static Transport faireAutobus(int nbPlaceAssise, int nbPlaceDebout) {

        return new Autobus(nbPlaceAssise, nbPlaceDebout);

    }

    public static Transport faireGreffonAUn(Collecte collecte, Transport transport) {

        return new GreffonAUn(collecte, transport);

    }   
    
    public static Transport faireGreffonEstUn(int nbPlaceAssise, int nbPlaceDebout, Collecte collecte) {

        return new GreffonEstUn(nbPlaceAssise, nbPlaceDebout, collecte);

    }



}