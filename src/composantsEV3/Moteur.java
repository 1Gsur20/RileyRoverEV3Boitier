package composantsEV3;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.*;


public class Moteur {
	
	//Module correspondant au moteur connecté à la voiture
	private EV3LargeRegulatedMotor unMoteur;
	
	/*
	 * Constructeur de la classe moteur
	 * @param port : le port de la brique EV3
	 */
	public Moteur(Port port) {
		this.unMoteur = new EV3LargeRegulatedMotor(port);
	}
	
	/*
	 * Fait tourner le moteur dans un sens ou dans l'autre
	 * @param avance : true pour aller vers l'avant, false pour aller vers l'arrière
	 */
	public void marche(boolean avance) {
		if(avance) {
			this.unMoteur.forward();
		}
		else {
			this.unMoteur.backward();
		}
	}
	
	
	/*
	 * Permet au moteur d'accélérer 
	 * @param intensite : Vitesse choisi pour le moteur
	 */
	public void accelere(int intensite) {
		this.unMoteur.setSpeed(intensite*360);
	}
	
	/*
	 * Arrête le moteur
	 */
	public void arret() {
		this.unMoteur.stop();
	}
	
	/*
	 * Retourne la vitesse du moteur
	 * @return la vitesse actuelle du moteur
	 */
	public int getSpeed(){
		return this.unMoteur.getSpeed();
	}
	
	/*
	 * @return true si le moteur avance
	 */
	public boolean isMoving(){
		return this.unMoteur.isMoving();
	}
	
	/*
	 * @return true si le moteur est arrêté
	 */
	public boolean isStalled(){
		return this.unMoteur.isStalled();
	}

	public EV3LargeRegulatedMotor getUnMoteur() {
		return unMoteur;
	}
	
	
}
