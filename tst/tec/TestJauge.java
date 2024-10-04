package tec;

class TestJauge{

    public void testExceptionCasLimite(){

        Jauge inverse = null;

        try{
            inverse = new Jauge(-42, 10);
        }
        catch(IllegalArgumentException exception){
            System.out.println("\n " + exception.getMessage());
            return;
        }

        System.out.println("\n Exception manquante");

    }

    public void testDansIntervalle() {
        System.out.println("\n Début test dans Intervalle");
        Jauge maJauge = new Jauge(67899, 100);
        try {
            assert maJauge.estVert() : " Erreur vert"; 
            assert !maJauge.estRouge() : " Erreur rouge"; 
        }  catch (AssertionError e) {
            System.out.println(e.getMessage());
        } 
    }

    public void testDepartSup() {
        System.out.println("\n Début test Départ supérieur au Max");
        Jauge maJauge = new Jauge(100, 200);
        try {
            assert !maJauge.estVert() : " Erreur vert"; 
            assert maJauge.estRouge() : " Erreur rouge"; 
        }  catch (AssertionError e) {
            System.out.println(e.getMessage());
        } 
    }

    public void testDepartEg() {
        System.out.println("\n Début test Départ egal au Max");
        Jauge maJauge = new Jauge(100, 100);
        try {
            assert !maJauge.estVert() : " Erreur vert"; 
            assert maJauge.estRouge() : " Erreur rouge"; 
        }  catch (AssertionError e) {
            System.out.println(e.getMessage());
        } 
    }

    public void testDepartNeg() {
        System.out.println("\n Début test Départ negatif");
        Jauge maJauge = new Jauge(100, -100);
        try {
            assert !maJauge.estVert() : " Erreur vert"; 
            assert maJauge.estRouge() : " Erreur rouge"; 
        }  catch (AssertionError e) {
            System.out.println(e.getMessage());
        } 
    }

    public void testDepartZero() {
        System.out.println("\n Début test Départ nul");
        Jauge maJauge = new Jauge(100, 0);
        try {
            assert maJauge.estVert() : " Erreur vert"; 
            assert !maJauge.estRouge() : " Erreur rouge"; 
        }  catch (AssertionError e) {
            System.out.println(e.getMessage());
        } 
    }

    public void testIncrementer() {
        System.out.println("\n Début test Départ Incrementer");
        Jauge maJauge = new Jauge(100, 99);
        maJauge.incrementer();
        try {
            assert !maJauge.estVert() : " Erreur vert"; 
            assert maJauge.estRouge() : " Erreur rouge"; 
        }  catch (AssertionError e) {
            System.out.println(e.getMessage());
        } 
    }

    public void testDecrementer() {
        System.out.println("\n Début test Départ Decrementer");
        Jauge maJauge = new Jauge(100, 0);
        maJauge.decrementer();
        try {
            assert !maJauge.estVert() : " Erreur vert"; 
            assert maJauge.estRouge() : " Erreur rouge"; 
        }  catch (AssertionError e) {
            System.out.println(e.getMessage());
        } 
    }

    public static void main(String[] args) {
        boolean estMisAssertion = false;
        assert estMisAssertion = true;

        if (!estMisAssertion) {
            System.out.println("Execution impossible sans l'option -ea");
            return;
        }

        TestJauge test = new TestJauge();
        test.testDansIntervalle();
        test.testDepartSup();
        test.testDepartEg();
        test.testDepartNeg();
        test.testDepartZero();
        test.testIncrementer();
        test.testDecrementer();
        test.testExceptionCasLimite();

    }
    
}

