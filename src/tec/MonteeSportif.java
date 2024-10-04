package tec;

class MonteeSportif extends PassagerAbstrait{
    public MonteeSportif(String nom, int destination, Arret arret) {
        super(nom, destination, arret);
    }

    protected void choixPlaceMontee(Vehicule v) {
        if (v.aPlaceDebout()){
            v.monteeDemanderDebout(this);
        }
    }   
}
