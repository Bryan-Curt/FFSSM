/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Moniteur extends Personne {

    public int numeroDiplome;
    
    public ArrayList<Embauche> embauches =new ArrayList();

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance, int numeroDiplome) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.numeroDiplome = numeroDiplome;
    }

    public Club employeur() {
        for(Embauche e:embauches){
            if (e.estTerminee()==false){
                return(e.getEmployeur());
            }
        }
        throw new IllegalArgumentException("Ce moniteur n'a pas d'employeur");
    }
    
    public void nouvelleEmbauche(Club employeur, Calendar debutNouvelle) {   
         embauches.add(new Embauche(debutNouvelle,this,employeur)); 
    }

    public ArrayList<Embauche> emplois() {
        return embauches;
    }

}
