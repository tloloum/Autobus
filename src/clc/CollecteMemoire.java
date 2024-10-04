package clc;

import java.util.LinkedList;

public class CollecteMemoire implements Collecte{
    private Maillon maillon;
    private LinkedList<Maillon> data;

    public CollecteMemoire(){
        this.maillon = new Maillon(0,0,1);
        this.data = new LinkedList<Maillon>();
    }
    public void uneEntree(){
        maillon.entree+=1;
    }

    public void uneSortie(){
        maillon.sortie+=1;
    }

    public void changerArret(){
        Maillon copie= new Maillon(maillon);
        data.add(copie);
        maillon.entree=0;
        maillon.sortie=0;
        maillon.arret++;
    }

    public int nbEntreeMaillon(){
        return maillon.entree;
    }

    public int nbSortieMaillon(){
        return maillon.sortie;
    }

    public int arretMaillon(){
        return maillon.arret;
    }

    public Maillon getMaillon(int i){
        return data.get(i);
    }
}