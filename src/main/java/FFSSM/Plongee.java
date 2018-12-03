/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Plongee {

    public Site lieu;

    public Moniteur chefDePalanquee;

    public Calendar date;

    public int profondeur;

    public int duree;

    public HashSet<Plongeur> plongeurs;

    public Plongee(Site lieu, Moniteur chefDePalanquee, Calendar date, int profondeur, int duree) {
        this.lieu = lieu;
        this.chefDePalanquee = chefDePalanquee;
        this.date = date;
        this.profondeur = profondeur;
        this.duree = duree;
        this.plongeurs = new HashSet();
    }

    public void ajouteParticipant(Plongeur participant) {
        plongeurs.add(participant);
    }

    public Calendar getDate() {
        return date;
    }

    public boolean estConforme() {
        for (Plongeur p : plongeurs) {
            if (p.getLicence().estValide(date) == false) {
                return false;
            }
        }
        return true;
    }
    
    public String toString(){
        String chaine="";
        for (Plongeur p : plongeurs){
            chaine+=p.getNiveau();
        }
        return chaine;
    }
    
}

