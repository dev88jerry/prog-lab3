/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculernotefinale;

import java.util.Comparator;

/**
 *
 * @author Jerry
 */
public class Etudiant {

    private String nom;
    private double notes;
    private boolean fail; 
   
    /**
     * 
     * @param nNote
     */
    public void ajouteNote(double nNote) {
        double n = this.notes;
        n += nNote;
        setNotes(n);        
    }
    
    public void passEtu(){
        if(this.notes > 60.0){
            this.fail = false;
        }
        else{
            this.fail = true;
        }
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nNom the nom to set
     */
    public void setNom(String nNom) {
        this.nom = nNom;
    }

    /**
     * @return the notes
     */
    public double getNotes() {
        return notes;
    }

    /**
     * @param nNotes the notes to set
     */
    public void setNotes(double nNotes) {
        this.notes = nNotes;
    }

    /**
     * @return the fail
     */
    public boolean isFail() {
        return fail;
    }

    /**
     * @param f the fail to set
     */
    public void setFail(boolean f) {
        this.fail = f;
    }
    
}
