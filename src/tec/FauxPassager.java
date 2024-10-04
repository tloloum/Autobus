package tec;
/**
 * Classe faussaire pour le test unitaire fonctionnel
 * d'Autobus. 
 *
 * Ce faussaire ne declenche pas d'appel aux methodes
 * d'Autobus.
 *
 * Il ne change pas son etat (la variable d'instance status). 
 * C'est le test qui change directement la valeur de cette variable. 
 *
 * Il enregistre l'appel aux méthodes qui doivent modifier son etat.
 * 
 * NB : Cette classe est obsolète pour le moment, les tests ne sont plus d'actualité
 * depuis la création de la fabrique.
 */
class FauxPassager implements Passager, Usager {
  public static final byte DEHORS = 0;
  public static final byte ASSIS  = 1;
  public static final byte DEBOUT = 2;
  public byte status = DEHORS;

  public final java.util.List<String> logs = new java.util.LinkedList<String>();

  public FauxPassager() {
    this(DEHORS);
  }

  FauxPassager(byte init) {
    status = init;
  }

  public String nom() {
    return null;
  }

  public boolean estDehors() {
    return status == DEHORS;
  }
  
  public boolean estAssis() {
    return status == ASSIS;
  }
  
  public boolean estDebout() {
    return status == DEBOUT;
  }

  // Enregistrements des appels effectues par Autobus.
  public void changerEnDehors() {
    logs.add("changerEnDehors");
  }

  public void changerEnAssis() {
    logs.add("changerEnAssis");
  }

  public void changerEnDebout() {
    logs.add("changerEnDebout");
  }

  public void nouvelArret(Vehicule bus, int numeroArret) {
    logs.add("nouvelArret");
  }

  // Autobus n'utilise pas cette méthode.
  public void monterDans(Transport t) { 
  }
}
