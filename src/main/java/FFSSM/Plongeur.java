package FFSSM;
import java.util.Calendar;
import java.util.ArrayList;

public class Plongeur {
    
    public int niveau;
    
    public ArrayList<Licence> licences;
    
    public Plongeur(int niveau){
        this.niveau=niveau;
        this.licences = new ArrayList();
    }
	
    
    public void ajouteLicence(Personne possesseur, String numero, Calendar delivrance, int niveau, Club club){
        Licence licence = new Licence(possesseur,numero,delivrance,niveau,club);
        licences.add(licence);
    }
    
    public Licence getLicence(){
        return licences.get(licences.size()-1);
    }
    
    public int getNiveau(){
        return niveau;
    }
}
