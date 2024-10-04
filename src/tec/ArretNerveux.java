package tec;

class ArretNerveux implements Arret{
    public void choixPlaceArret(Passager p, Vehicule v, int distanceDestination){
        if (distanceDestination == 0){
            v.arretDemanderSortie(p);
        } else if (p.estDebout()){
            if (v.aPlaceAssise())
                v.arretDemanderAssis(p);
        } else if (p.estAssis()){
            if (v.aPlaceDebout())
                v.arretDemanderDebout(p);
        }
    }
}