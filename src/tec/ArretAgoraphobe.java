package tec;

class ArretAgoraphobe implements Arret{
    public void choixPlaceArret(Passager p, Vehicule v, int distanceDestination){
        if (distanceDestination == 0){
            v.arretDemanderSortie(p);
        } else if (!v.aPlaceAssise() && !v.aPlaceDebout()){
            v.arretDemanderSortie(p);
        }
    }
}