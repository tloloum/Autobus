package tec;

abstract class PassagerAbstrait implements Passager, Usager {
  
  private java.lang.String nom;
  private final int destination;
  private Position status;
  private Arret arret;
  
  public PassagerAbstrait(java.lang.String nom, int destination, Arret arret) {

    if(destination<0){
      throw(new IllegalArgumentException("Destination négative"));
    }


    this.nom = nom;
    this.destination = destination;
    this.arret = arret;
    this.status = Position.init();
    changerEnDehors();
  }

  /**
   * fournit le nom de du passager.
   */
  public String nom() {
    return this.nom;
  }

  /**
   * Le passager est-il en dehors d'un véhicule ?
   * @return vrai si la position du passager est dehors.
   */
  public boolean estDehors() {
    return this.status.estDehors();
  }
  
  /**
   * Le passager est-il assis dans un véhicule ?
   * @return vrai si la position du passager est assis.
   */
  public boolean estAssis() {
    return this.status.estAssis();
  }
  
  /**
   * Le passager est-il debout dans un véhicule?
   * @return vrai si la position du passager est debout.
   */
  public boolean estDebout() {
    return this.status.estDebout();
  }
  
  /**
   * Change la position du passager en dehors.
   * Cette méthode est appélee par un véhicule.
   */
  public void changerEnDehors() {
    status = status.dehors();
  }
  
  /**
   * Change la position du passager en assis. 
   * Cette méthode est appélee par un véhicule.
   */
  public void changerEnAssis() {
    this.status = this.status.assis();
  }
  
  /**
   * Change la position du passager en debout.
   * Cette méthode est appélee par un véhicule.
   */
  public void changerEnDebout() {
    status = this.status.debout();
  }

  /**
   * Cette méthode réalise le caractère à la montée du passager.
   * Elle est appelée par le client.
   *
   * @param v le véhicule dans lequel va monter le passager.
   */  
  public void monterDans(Transport t) throws TecException {

    Vehicule v = (Vehicule) t;

    if(! (v instanceof Vehicule)){
      throw new TecException("Echec du cast Transport vers Vehicule");
    }

    try{
      choixPlaceMontee(v);
    }
    catch(IllegalStateException e){
      throw new TecException(e);
    }

  }

  /**
   * Cette méthode réalise le caractère à un arrêt du passager. 
   * Elle est appelée par le véhicule dans lequel est monté le passager. 
   *
   * @param v le vehicule dans lequel se trouve le passager.
   * @param numeroArret numéro de l'arrêt courant.
   */
  public void nouvelArret(Vehicule v, int numeroArret){
    //if (distanceDestination(numeroArret) <= 0) {
    //  v.arretDemanderSortie(this);
    
    arret.choixPlaceArret(this, v, distanceDestination(numeroArret));
  }

  final protected int distanceDestination(int numeroArret){
    return this.destination - numeroArret;
  }

  protected abstract void choixPlaceMontee(Vehicule v);

  @Override
  public String toString(){
    return nom() + " " + status.toString();
  }
  
}
