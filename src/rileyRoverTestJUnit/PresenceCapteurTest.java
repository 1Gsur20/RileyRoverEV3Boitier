package rileyRoverTestJUnit;

import static org.junit.Assert.*;
import lejos.robotics.SampleProvider;


import org.junit.Test;

import composantsEV3.PresenceCapteur;

public class PresenceCapteurTest {

	@Test
	public void testObstacleDetect() throws Exception{
		PresenceCapteur capteur = new PresenceCapteur(null);
		SampleProvider donneurDistance = capteur.unCapteur.getDistanceMode();
		float[] sample = new float[donneurDistance.sampleSize()]; 
		int offsetSample = 0;
		
		capteur.unCapteur.fetchSample(sample, offsetSample);
		float distanceObjet = (float)sample[0];
		
		if (distanceObjet >= capteur.DISTANCE_PRESENCE) {
			if (capteur.obstacleDetect()){
				fail("la distance est sup�rieur � 0,30m");
			}
		}
		
		if (distanceObjet < capteur.DISTANCE_PRESENCE) {
			if (!capteur.obstacleDetect()){
				fail("la distance est inf�rieure � 0,30m");
			}
		}
		
		
		
	}

}
