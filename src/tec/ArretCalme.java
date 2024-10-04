package tec;

class ArretCalme implements Arret{
    public void choixPlaceArret(Passager p, Vehicule v, int distanceDestination){
        if (distanceDestination == 0){
            v.arretDemanderSortie(p);
        }
    }
}
