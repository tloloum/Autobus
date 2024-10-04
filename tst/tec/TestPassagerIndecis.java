package tec;

class TestPassagerIndecis {
    public static void main (String[] args) throws TecException {
        boolean estMisAssertion = false;
        assert estMisAssertion = true;
    
        if (!estMisAssertion) {
          System.out.println("Execution impossible sans l'option -ea");
          return;
        }

        int nbTest = 0;

        System.out.print('.'); nbTest++;
        new TestPassagerIndecis().testChoixPlaceMontee();
    
        System.out.print('.'); nbTest++;
        new TestPassagerIndecis().testChoixPlaceArret();

        System.out.println("(" + nbTest + "):OK: " + "tec.TestPassagerIndecis"); 

      }

    public void testChoixPlaceMontee() throws TecException{

      Usager u = FabriqueTec.fairePassagerIndecis("a",4);
      PassagerIndecis p = (PassagerIndecis) u;

      /* Premier cas : le véhicule a des places debout */
      FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);

      p.monterDans(faux);

      assert "monteeDemanderDebout" == getLastLog(faux) : "debout";

      /* Deuxième cas : le véhicule n'a plus de place debout */
      faux = new FauxVehicule(FauxVehicule.ASSIS);
      Usager u_bis = FabriqueTec.fairePassagerIndecis("b",5);
      PassagerIndecis p_bis = (PassagerIndecis) u_bis;


      p_bis.monterDans(faux);

      assert 0 == faux.logs.size() : "pas de place";

      /* Troisième cas : le véhicule n'a plus de place */
      faux = new FauxVehicule(FauxVehicule.PLEIN);
      Usager u_ter = FabriqueTec.fairePassagerIndecis("b",5);
      PassagerIndecis p_ter = (PassagerIndecis) u_ter;

      p_ter.monterDans(faux);

      assert 0 == faux.logs.size() : "pas de place";
    }


    public void testChoixPlaceArret() throws TecException {
      Usager u = FabriqueTec.fairePassagerIndecis("a",4);
      PassagerIndecis p = (PassagerIndecis) u;

      /* Premier cas : le passager est assis, demande une place debout et
      * de la place est disponible
      */
      FauxVehicule faux = new FauxVehicule(FauxVehicule.DEBOUT);
      p.changerEnAssis();

      p.nouvelArret(faux,2);

      assert "arretDemanderDebout" == getLastLog(faux) : "debout";

      /* Deuxième cas : le passager est assis, demande une place debout mais
      * il n'y a pas de place
      */
      faux = new FauxVehicule(FauxVehicule.ASSIS);
      p.changerEnAssis();

      p.nouvelArret(faux,2);

      assert 0 == faux.logs.size() : "pas de place debout";

      /* Troisième cas : le passager est debout, demande une place assise et
      * de la place est disponible
      */
      faux = new FauxVehicule(FauxVehicule.ASSIS);
      p.changerEnDebout();

      p.nouvelArret(faux,2);

      assert "arretDemanderAssis" == getLastLog(faux) : "assis";

      /* Quatrième cas : le passager est debout, demande une place assise mais
      * il n'y a pas de place
      */
      faux = new FauxVehicule(FauxVehicule.PLEIN);
      p.changerEnDebout();

      p.nouvelArret(faux,2);

      assert 0 == faux.logs.size() : "pas de place";
    }

    private String getLastLog(FauxVehicule f) {
        return f.logs.get(f.logs.size() -1);
    }
}