import tec.FabriqueTec;
import tec.TecException;
import tec.Transport;
import tec.Usager;

import clc.Collecte;
import clc.CollecteMemoire;

class SimpleGreffonAUnMemoire {

  /*
   * Affiche l'etat des deux instances passees en parametre.
   * La methode println(Object x) de la classe PrintWriter 
   * declenche la methode toString() sur l'objet passe 
   * en parametre (x.toString()) et affiche la chaine 
   * de caracteres obtenue..
   */
  static private void deboguerEtat (Transport t, Usager u) {
    System.out.println(u);
    System.out.println(t);
  }

  static public void main (String[] args) throws TecException{
    // Vehicule serenity = new Autobus(1, 2);
    
    Collecte collecte = new CollecteMemoire();
    Transport transport = FabriqueTec.faireAutobus(1, 2);
    Transport serenity = FabriqueTec.faireGreffonAUn(collecte, transport);

    /* 
    Passager kaylee = new PassagerIndecis("Kaylee", 4);
    Passager jayne = new PassagerIndecis("Jayne", 4);
    Passager inara = new PassagerIndecis("Inara", 5); */

    Usager kaylee = FabriqueTec.fairePassagerIndecis("Kaylee", 4);
    Usager jayne = FabriqueTec.fairePassagerIndecis("Jayne", 4);
    Usager inara = FabriqueTec.fairePassagerIndecis("Inara", 5);

    //0
    System.out.println(serenity);

    serenity.allerArretSuivant();
    //1
    kaylee.monterDans(serenity);

    System.out.println(serenity);
    System.out.println(kaylee);

    serenity.allerArretSuivant();
    //2
    jayne.monterDans(serenity);

    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println(jayne);

    serenity.allerArretSuivant();
    //3
    inara.monterDans(serenity);

    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println(jayne);
    System.out.println(inara);

    serenity.allerArretSuivant();
    //4
    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println(jayne);
    System.out.println(inara);

    serenity.allerArretSuivant();
    //5
    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println(jayne);
    System.out.println(inara);
  }

}
