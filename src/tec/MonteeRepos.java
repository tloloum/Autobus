package tec;

class MonteeRepos extends PassagerAbstrait{
    public MonteeRepos(String nom, int destination, Arret arret) {
        super(nom, destination, arret);
    }

    protected void choixPlaceMontee(Vehicule v) {
        if (v.aPlaceAssise()){
            v.monteeDemanderAssis(this);
        } else if (v.aPlaceDebout()){
            v.monteeDemanderDebout(this);
        }
    }   
}
