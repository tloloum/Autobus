package tec;

class MonteeFatigue extends PassagerAbstrait{
    public MonteeFatigue(String nom, int destination, Arret arret) {
        super(nom, destination, arret);
    }

    protected void choixPlaceMontee(Vehicule v) {
        if (v.aPlaceAssise()){
            v.monteeDemanderAssis(this);
        }
    }   
}
