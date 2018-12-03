package FFSSM;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Calendar;
import java.util.HashSet;

/**
 *
 * @author bryancurt
 */
public class FFSSMJUnitTest {
    
    Club michelPlongee;
    Moniteur michel;
    Plongeur cailloux;
    Plongeur plongeurSansLicence;
    Plongee plongation;
    Site site;
    Licence licenceMichel;
    
    
    
    public FFSSMJUnitTest() {
    }
    
    
    @Before
    public void setUp() {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        Calendar cal3 = Calendar.getInstance();
        Calendar cal4 = Calendar.getInstance();  
        cal1.set(1987,9,2);
        cal2.set(2019,3,11);
        cal3.set(2018,11,11);
        cal4.set(2012,11,11);
        michel=new Moniteur("12345678","Michel","Michel","rue du boulevard","0606060606",cal1,1248);
        michelPlongee=new Club(michel,"michelPlongee","0767025729");
        michel.nouvelleEmbauche(michelPlongee, cal1);
        cailloux = new Plongeur(2);
        plongeurSansLicence = new Plongeur(1);
        site= new Site("épave de tyrolienne","37cm de profondeur");
        plongation=new Plongee(site,michel,cal2,37,10);
        cailloux.ajouteLicence(michel,"1248", cal3, 2, michelPlongee);
        plongation.ajouteParticipant(cailloux);
        
        plongeurSansLicence.ajouteLicence(michel,"1248", cal4, 2, michelPlongee);
        plongation.ajouteParticipant(plongeurSansLicence);


    }
    

    @Test
    public void testPlongeesConformes() {
        assertFalse(plongation.estConforme());
    }
    
    @Test
    public void testCollectionPlongeesNonConformes(){
        //System.out.println(plongation);
        michelPlongee.organisePlongee(plongation);
        HashSet<Plongee> plongeesNC = new HashSet();
        plongeesNC.add(plongation);
        assertEquals(plongeesNC,michelPlongee.plongeesNonConformes());
    }
    
    @Test
    public void testLicenceValide(){
        Calendar cal5 = Calendar.getInstance();
        cal5.set(2018,12,12);
        assertTrue(cailloux.getLicence().estValide(cal5));
        assertFalse(plongeurSansLicence.getLicence().estValide(cal5));

    }
    
    @Test
    public void testEmployeur(){
        Calendar cal = Calendar.getInstance();
        cal.set(2018,12,12);
        assertEquals(michelPlongee,michel.employeur());
        michel.emplois().get(michel.emplois().size()-1).terminer(cal);
    }
    
    
    
}
