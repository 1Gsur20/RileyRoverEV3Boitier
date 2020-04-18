package rileyRoverTestJUnit;

import static org.junit.Assert.*;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;

import org.junit.Test;

import composantsEV3.Moteur;


public class MoteurTest {

	@Test
	public void testMarche() throws Exception{
		Moteur mot = new Moteur(MotorPort.B);
		mot.marche(true);
		
		if (mot.getSpeed() == 0){
			fail("Le moteur devrait avoir de la vitesse");
		}
		
		if (!mot.isMoving()){
			fail("Le moteur devrait avancer");
		}
		
		if (mot.isStalled()){
			fail("Le moteur devrait avancer");
		}
		
	}
	
	@Test
	public void testAccelere() throws Exception{
		Moteur mot = new Moteur(MotorPort.B);
		mot.accelere(0);
		
		if (mot.getSpeed()!= 0){
			fail("La vitesse devrait �tre nulle");
		}
		
		mot.accelere(5);
		if (mot.getSpeed() != 1800){
				fail("La vitesse devrait �tre �gale � 1800");
		}
	}
	
	@Test
	public void testArret() throws Exception{
		Moteur mot = new Moteur(MotorPort.B);
		mot.arret();
		if (mot.getSpeed() != 0){
			fail("La vitesse devrait etre nulle");
		}
		
		if (mot.isMoving()){
			fail("Le moteur devrait �tre arr�t�");
		}
		
		if (!mot.isStalled()){
			fail("Le moteur devrait �tre arr�t�");
		}
	}
	
	

}
