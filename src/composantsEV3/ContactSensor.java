package composantsEV3;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.SampleProvider;

public class ContactSensor {
	
	//Module correspondant au capteur de contact
	public EV3TouchSensor capteurContact;
	
	public ContactSensor(Port port) {
		this.capteurContact = new EV3TouchSensor(port);
	}
	
	/* True si objet touche
	   False sinon */
	
	public boolean contactDetected() {

		boolean contact = false;
		SampleProvider dataSensor = this.capteurContact.getTouchMode();
		int offsetSample = 0;
		float[] sample = new float[dataSensor.sampleSize()]; 
		
		this.capteurContact.fetchSample(sample, offsetSample);
		
		int valueDetection = (int)sample[0];
		
		if(valueDetection == 1) {
			contact = true;
		}
		
		return contact;
	}
}