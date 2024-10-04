package tec;

class TestPassagerStresse {
    public static void main (String[] args) throws TecException {
        boolean estMisAssertion = false;
        assert estMisAssertion = true;
    
        if (!estMisAssertion) {
          System.out.println("Execution impossible sans l'option -ea");
          return;
        }

        int nbTest = 0;

        System.out.print('.'); nbTest++;
        new TestPassagerStresse().testChoixPlaceMontee();
    
        System.out.print('.'); nbTest++;
        new TestPassagerStresse().testChoixPlaceArret();

        System.out.println("(" + nbTest + "):OK: " + "tec.TestPassagerStresse"); 

      }

    public void testChoixPlaceMontee() throws TecException {
        Usager u = FabriqueTec.fairePassagerStresse("Toto le heros",5);
        PassagerStresse p = (PassagerStresse) u;
        FauxVehicule faux;

        faux = new FauxVehicule(FauxVehicule.VIDE);
        p.monterDans(faux);
        assert "monteeDemanderAssis" == getLastLog(faux) : "assis";

        faux = new FauxVehicule(FauxVehicule.DEBOUT);
        p.monterDans(faux);
        assert 0 == faux.logs.size() : "pas de place assise";

        faux = new FauxVehicule(FauxVehicule.PLEIN);
        p.monterDans(faux);

        assert 0 == faux.logs.size() : "pas de place";
    }

    public void testChoixPlaceArret() {
        /* Premier cas : le passager est assis et loin de la destination
         */
        {
            Usager u = FabriqueTec.fairePassagerStresse("Toto le zero", 5);
            PassagerStresse p = (PassagerStresse) u;
            FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);

            p.changerEnAssis();
            p.nouvelArret(faux, 1);

            assert 0 == faux.logs.size() : "loin de la destination";
            

            
        }

        /* Deuxieme cas : le passager est assis et arrive a 3 arrets de la destination
         * (test de borne)
         */
        {
            Usager u = FabriqueTec.fairePassagerStresse("Toto le zero", 5);
            PassagerStresse p = (PassagerStresse) u;
            FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);

            p.changerEnAssis();
            p.nouvelArret(faux, 2);

            assert "arretDemanderDebout" == getLastLog(faux) : "demande debout";
        }

        /* Troisieme cas : le passager est assis et arrive a 1 arret de la destination
         * (test dans l'intervalle)
         */
        {
            Usager u = FabriqueTec.fairePassagerStresse("Toto le zero", 5);
            PassagerStresse p = (PassagerStresse) u;
            FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);

            p.changerEnAssis();
            p.nouvelArret(faux, 4);

            assert "arretDemanderDebout" == getLastLog(faux) : "demande debout";
        }

        /* Quatrieme cas : le passager est assis, arrive proche de la destination
         * mais il n'y a plus de place debout
         */
        {
            Usager u = FabriqueTec.fairePassagerStresse("Antoine Chartron", 5);
            PassagerStresse p = (PassagerStresse) u;
            FauxVehicule faux = new FauxVehicule(FauxVehicule.ASSIS);

            p.changerEnAssis();
            p.nouvelArret(faux, 3);

            assert faux.logs.size() == 0 : "ne peut pas se lever";
        }

        /* Cinquieme cas : le passager est deja debout et arrive proche de la destination
         */
        {
            Usager u = FabriqueTec.fairePassagerStresse("Jean Bombeur", 5);
            PassagerStresse p = (PassagerStresse) u;
            FauxVehicule faux = new FauxVehicule(FauxVehicule.DEBOUT);

            p.changerEnDebout();
            p.nouvelArret(faux, 3);

            assert faux.logs.size() == 0 : "deja debout";
        }
    }

    private String getLastLog(FauxVehicule f) {
        return f.logs.get(f.logs.size() -1);
    }
}