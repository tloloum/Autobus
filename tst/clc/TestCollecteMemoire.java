package clc;

class TestCollecteMemoire{

    public void testResetMaillon(){
        CollecteMemoire c=new CollecteMemoire();
        c.uneEntree();
        assert 1==c.nbEntreeMaillon();
        c.uneSortie();
        c.uneSortie();
        assert 2==c.nbSortieMaillon();
        c.changerArret();
        assert 0==c.nbEntreeMaillon();
        assert 0==c.nbSortieMaillon();
        assert 2==c.arretMaillon();
    }

    public void testInsererMaillon(){
        CollecteMemoire c=new CollecteMemoire();
        c.uneEntree();
        c.uneSortie();
        c.uneSortie();
        c.changerArret();
        assert 1==c.getMaillon(0).entree;
        assert 2==c.getMaillon(0).sortie;
        assert 1==c.getMaillon(0).arret;
        c.uneEntree();
        c.uneEntree();
        c.uneEntree();
        c.uneSortie();
        c.uneSortie();
        c.uneSortie();
        c.uneSortie();
        c.changerArret();
        assert 3==c.getMaillon(1).entree;
        assert 4==c.getMaillon(1).sortie;
        assert 2==c.getMaillon(1).arret;
        
        }


    public static void main(String[] args){
        int nbTest=0;
        new TestCollecteMemoire().testResetMaillon();
        System.out.print('.'); nbTest++;
        new TestCollecteMemoire().testInsererMaillon();
        System.out.print('.'); nbTest++;
        System.out.println("(" + nbTest + "):OK: " + "clc.PassagerAbstrait"); 
    }
}