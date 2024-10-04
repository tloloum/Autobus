package clc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class CollecteFichier implements Collecte{
    private File file;
    private int nb_entrees;
    private int nb_sorties;
    private int num_arret;

    public CollecteFichier(String nom_fichier) {
        try {
            file = new File(nom_fichier);
            file.createNewFile();
            FileWriter writer = new FileWriter(file, false);
            writer.close();
            nb_entrees = 0;
            nb_sorties = 0;
            num_arret = 1;
        } catch (Exception e) {
            System.out.println("Erreur lors de la création du fichier de collecte");
        }
    }

    private void Write(String str){
        try {
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(str);
            bw.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void uneEntree(){
        nb_entrees +=1;
    }

    public void uneSortie(){
        nb_sorties +=1;
    }

    public void changerArret(){
        Write("Arret " + num_arret + ": Entrées: " + nb_entrees + " Sorties: " + nb_sorties + "\n");
        nb_entrees = 0;
        nb_sorties = 0;
        num_arret += 1;
    }    
}
