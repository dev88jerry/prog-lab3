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

        try {
            Scanner sc = new Scanner(new File("C:/Users/Admin/Documents/NetBeansProjects/CalculerNoteFinale/notes.txt"));

            while (sc.hasNextLine()) {
                inp.add(sc.nextLine());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CalculerNoteFinale.class.getName()).log(Level.SEVERE, null, ex);
        }

        inp.add("New line");
        
        String newS = "Next line";
        inp.add(newS);
        
        for (String st : inp) {
            System.out.println(st);
        }

    }

}
