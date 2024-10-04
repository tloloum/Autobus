package tec;

class ArretPrudent implements Arret{
    public void choixPlaceArret(Passager p, Vehicule v, int distanceDestination){
        if (distanceDestination == 0){
            v.arretDemanderSortie(p);
        } else if (distanceDestination <= 3){
            if (v.aPlaceDebout() && p.estAssis())
                v.arretDemanderDebout(p);
        } else if (distanceDestination >= 5){
            if (v.aPlaceAssise() && p.estDebout())
                v.arretDemanderAssis(p);
        }  else {}
    }    
}
