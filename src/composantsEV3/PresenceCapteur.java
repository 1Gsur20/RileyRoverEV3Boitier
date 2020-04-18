package composantsEV3;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;

public class PresenceCapteur {
	
	//Module correspondant au capteur de présence
	public EV3UltrasonicSensor unCapteur;
	
	//Distance choisie (en mètres) pour la détection d'un obstacle
	public final double DISTANCE_PRESENCE=0.30;
	
	/*
	 * Constructeur de la classe presenceCapteur
	 * @param port : le port de la brique EV3
	 */
	public PresenceCapteur(Port port) {
		this.unCapteur = new EV3UltrasonicSensor(port);
	}
	
	/*
	 * Renvoi true si un obstacle est détecté à la distance donnée par DISTANCE_PRESENCE
	 */
	public boolean obstacleDetect() {
		boolean unObstacle = false;
		SampleProvider donneurDistance = this.unCapteur.getDistanceMode();
	
		float[] sample = new float[donneurDistance.sampleSize()]; 
		int offsetSample = 0;
		
		this.unCapteur.fetchSample(sample, offsetSample);
		float distanceObjet = (float)sample[0];
		
		if(distanceObjet<DISTANCE_PRESENCE) {
			unObstacle = true;
		}
		
		return unObstacle;
	}
}
