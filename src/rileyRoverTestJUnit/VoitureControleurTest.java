package rileyRoverTestJUnit;

import static org.junit.Assert.*;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import rileyRoverApp.VoitureControleur;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import composantsEV3.Moteur;
import composantsEV3.PresenceCapteur;


public class VoitureControleurTest extends Thread{
	
	
	@Test
	public void testAvance() throws Exception {
		Moteur moteurDroit = new Moteur(MotorPort.C);
		Moteur moteurGauche = new Moteur(MotorPort.B);
		PresenceCapteur capteurPresence = new PresenceCapteur(SensorPort.S1);
		
		VoitureControleur.avance();
		
		if ((moteurDroit.getSpeed()==0 || moteurGauche.getSpeed()==0) &&  !capteurPresence.obstacleDetect()){
			fail("Les moteurs devraient avancer");
		}
	}
	
	@Test
	public void testRecul() throws Exception {
		Moteur moteurDroit = new Moteur(MotorPort.C);
		Moteur moteurGauche = new Moteur(MotorPort.B);
		
		
	}
	
	@Test
	public void testArretMoteur() throws Exception {
		fail("Not yet implemented");
	}
	
	@Test
	public void testChangementVitesse() throws Exception {
		fail("Not yet implemented");
	}
	
	@Test
	public void testAppliPreteAMarcher() throws Exception {
		fail("Not yet implemented");
	}
	
	@Test
	public void testTourneDroite() throws Exception {
		fail("Not yet implemented");
	}
	
	@Test
	public void testTourneGauche() throws Exception {
		fail("Not yet implemented");
	}
	
	@Test
	public void testKlaxonne() throws Exception {
		fail("Not yet implemented");
	}
	

}
