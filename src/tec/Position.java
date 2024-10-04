package tec;


/**
 * Cette classe représente la position d'un passager par rapport à un transport.
 * Une position a trois états possibles : assis dans un transport, 
 * debout dans un transport et dehors d'un transport.
 *
 * Les instances de cette classe sont des objets constants.
 *
 * @author Georgy
 * @since 2007-2019
 **/



public final class Position {

  private static final Position posAssis=new Position();
  private static final Position posDebout=new Position();
  private static final Position posDehors=new Position();

  private Position(){}

  public static Position init() {
    return posDehors;
  }

  /**
   * La position est-elle dehors ?
   *
   * @return vrai si l'état de l'instance est dehors;
   */
  public boolean estDehors() {
    return this == posDehors;
  }

  /**
   * La position est-elle assis ?
   *
   * @return vrai si l'état de l'instance est assis;
   */
  public boolean estAssis() {
    return this == posAssis;
  }

  /**
   * La position est-elle debout ?
   *
   * @return vrai si l'état de l'instance est debout;
   */
  public boolean estDebout() {
    return this == posDebout;
  }

  /**
   * La position est-elle assis ou debout ?
   *
   * @return vrai la position est assis ou debout.
   */
  public boolean estInterieur() {
    return !(this ==posDehors) ;
  }


  /**
   * Retourne une instance de Position assis.
   *
   * @return instance dans l'état assis.
   */
  public Position assis() {
    return posAssis; 
  }

  /**
   * Retourne une instance de Position debout.
   *
   * @return instance dans l'état debout.
   */
  public Position debout() {
    return posDebout;
  }

  /**
   * Retourne une instance de Position dehors.
   *
   * @return instance dans l'état dehors.
   */
  public Position dehors() {
    return posDehors;
  }

  /**
   * Cette méthode est héritée de la classe {@link java.lang.Object}.
   * Très utile pour le débogage, elle permet de fournir une 
   * chaîne de caractères correspondant à l'état d'un objet.
   * Mais, il faut adapter son code à chaque classe.
   */
  @Override
  public String toString() {
      String nom = null;
  
      if (this == posDehors) {
          nom = "endehors";
      } else if (this == posAssis) {
          nom = "assis";
      } else if (this == posDebout) {
          nom = "debout";
      } else {
          nom = "état inconnu";
      }
  
      return "<" + nom + ">";
  }

}


