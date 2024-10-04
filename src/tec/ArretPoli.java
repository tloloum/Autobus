package tec;

class ArretPoli implements Arret{
    public void choixPlaceArret(Passager p, Vehicule v, int distanceDestination){
        if (distanceDestination == 0){
            v.arretDemanderSortie(p);
        } else if (!v.aPlaceAssise() && v.aPlaceDebout()){
            v.arretDemanderDebout(p);
        }
    }
}