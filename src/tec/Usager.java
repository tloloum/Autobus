package tec;

public interface Usager {

    /**
   * Cette méthode réalise le caractère à la montée du passager.
   * Elle est appelée par le client.
   *
   * @param t le véhicule dans lequel va monter le passager.
   */
  public void monterDans(Transport t) throws TecException;

}
