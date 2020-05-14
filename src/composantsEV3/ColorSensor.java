package composantsEV3;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;

public class ColorSensor {
	
	//Module correspondant au capteur de contact
	public EV3ColorSensor capteurCouleur;
		
	public ColorSensor(Port port) {
		this.capteurCouleur = new EV3ColorSensor(port);
	}
	
	/* True si objet touche
	   False sinon */
	
	public float contactDetected() {
		
		SampleProvider dataSensor = this.capteurCouleur.getAmbientMode();
		int offsetSample = 0;
		float[] sample = new float[dataSensor.sampleSize()]; 
		
		this.capteurCouleur.fetchSample(sample, offsetSample);	
		
		float luminosity = (float)sample[0];
		
		return luminosity;
		
	}
}