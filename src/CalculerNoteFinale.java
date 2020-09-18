/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculernotefinale;

import java.io.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 * @author Jerry
 */
public class CalculerNoteFinale {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here       
        ArrayList<String> inp = new ArrayList<String>();
        ArrayList<Etudiant> groupe = new ArrayList<Etudiant>();
        String str[] = null;

        double moy = 0.0;
        int failE = 0;
        int eOverAvg = 0;

        //String oFile = "C:/Users/Admin/Documents/NetBeansProjects/CalculerNoteFinale/notes.txt";
        String oFile = "notes.txt";
        try {
            Scanner sc = new Scanner(new File(oFile));

            while (sc.hasNextLine()) {
                Etudiant e = new Etudiant();
                inp.add(sc.nextLine());
                for (String st : inp) {
                    str = st.split(" ");
                }
                for (String st : str) {
                    if (st.matches("[a-zA-Z]+")) {
                        e.setNom(st);
                    } else {
                        double d = Double.parseDouble(st);
                        e.ajouteNote(d);
                    }
                }
                e.passEtu();
                groupe.add(e);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CalculerNoteFinale.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*
        Collections.sort(groupe, new Comparator(){
            @Override
            public int compare(Object e1, Object e2){
                return ((Etudiant)e1).getNom().compareTo(((Etudiant)e2).getNom());                
            }        
        });
         */
        //sort alphabetical
        Collections.sort(groupe, (Object e1, Object e2) -> ((Etudiant) e1).getNom().compareTo(((Etudiant) e2).getNom()));

        /**
         * print all students & grades w/pass-fail
         */
        for (Etudiant e : groupe) {
            System.out.print("Nom: " + e.getNom());
            System.out.printf("\tNote: %.0f", e.getNotes());
            if (e.isFail()) {
                System.out.println(" EC");
                failE++;
            } else {
                System.out.println("");
            }
            moy += e.getNotes();
        }

        System.out.println("");
        System.out.println("Nombre total d'etudiants: " + groupe.size());
        System.out.println("Nombre d'echecs: " + failE);
        moy = moy / groupe.size();
        System.out.printf("Moyenne du groupe: %.2f%n", moy);

        double tGrade = 0.0;
        double bGrade = 0.0;
        int i = 0;
        int loc = 0;
        for (Etudiant e : groupe) {
            if (e.getNotes() > moy) {
                eOverAvg++;
            }

            tGrade = e.getNotes();
            if (tGrade > bGrade) {
                bGrade = tGrade;
                loc = i;
            }
            i++;
        }

        System.out.println("Meilleur(e) etudiant(e): " + groupe.get(loc).getNom());
        System.out.println("Nb. d'etudiant supp. a la moyenne: " + eOverAvg);
    }

}
