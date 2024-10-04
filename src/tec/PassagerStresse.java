package tec;

class PassagerStresse extends MonteeFatigue {

    public PassagerStresse(java.lang.String nom, int destination) {
        super(nom, destination, new ArretPrudent());
    }
}
