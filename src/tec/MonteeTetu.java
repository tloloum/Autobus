package tec;

class MonteeTetu extends PassagerAbstrait{
    public MonteeTetu(String nom, int destination, Arret arret) {
        super(nom, destination, arret);
    }

    protected void choixPlaceMontee(Vehicule v) {
        v.monteeDemanderDebout(this);
    }   
}
