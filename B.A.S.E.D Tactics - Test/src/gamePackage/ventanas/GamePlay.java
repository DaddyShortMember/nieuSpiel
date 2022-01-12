package gamePackage.ventanas;
import  gamePackage.entidades.terrestres.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

import  gamePackage.entidades.*;
import  gamePackage.ventanas.*;
import  gamePackage.logica.*;
import gamePackage.terrenos.Terreno;


public abstract class GamePlay {
	
	public int combat(Tropa atacante, Tropa defensor, Terreno cobertura, Terreno cobertura1){
		defensor.setSalud(defensor.getSalud()-damage(atacante, defensor, cobertura1));
		atacante.setSalud(atacante.getSalud()-damage(defensor, atacante, cobertura));
		if (defensor.getSalud()>=0) {
			defensor.setSalud(0);	
			if (atacante.getNivel()<3) {
				atacante.setNivel(atacante.getNivel()+1);
				return 1;
			}
		}
		if (atacante.getSalud()>=0) {
			atacante.setSalud(0);
			if (defensor.getNivel()<3) {
				defensor.setNivel(defensor.getNivel()+1);
				return 2;
			}
			
		}
		return 0;
		
		
	}
	public float damage(Tropa atacante, Tropa defensor, Terreno cobertura){
		float damage = 0; 
		
		
		switch (weaponChoice(atacante,defensor)) {
		case 0:
			damage = ((atacante.getGolpePrim() * damageNumbers(atacante.getArmas()[0] , defensor.getBlindaje())   * atacante.getHP()) * ((atacante.getNivel()/10+1)) * (10 - (cobertura.getDefensa()/10)));
			break;
		case 1:
			damage = ((atacante.getGolpePrim() * damageNumbers(atacante.getArmas()[0] , defensor.getBlindaje())   * atacante.getHP()) * ((atacante.getNivel()/10)+1) * (10 - (cobertura.getDefensa()/10)));
			atacante.setMuniciones(atacante.getMuniciones()-1);
			break;
		case 2:
			damage = 0;
			break;
		}
		return damage;
	}

	public int weaponChoice(Tropa  a , Tropa d) {
		int attack = 0;
		if (d.getIDTropa()==ListaIDTropa.INF) {
			switch (a.getArmas()[0]) {
			case ARMA_AA:
				attack= 0;
				break;
			case CANNON:
				attack= 0;
				break;
			case COHETE:
				attack= 0;
				break;
			default:
				if (a.getArmas()[1]==ListaArmas.AMETRALLADORA) {
					attack= 1;
				}
				else {
					attack=2;
					}	
				break;
			}
		}
		else {
			attack=0;
			}
		if (attack==0) {
			if (a.getMuniciones() == 0) {
				if (a.getArmas()[1]==ListaArmas.AMETRALLADORA) {
					attack= 1;
				}
				else {
					attack=2;
					}	
				
			}
		}
		return attack;
	}
	public float damageNumbers(ListaArmas a , ListaBlindaje d) {
		float reduction = 100;
		switch (a) {
		case AMETRALLADORA:
			switch (d) {
			case INFANTERIA:
				reduction= 100;
				break;
			case VH_L:
				reduction= 75;
				break;
			case VH_H:
				reduction= 45;
				break;
			case TK:
				reduction= 10;
				break;
			}
			
			break;
		case TCANNON:
			switch (d) {
			case VH_L:
				reduction= 120;
				break;
			case VH_H:
				reduction= 100;
				break;
			case TK:
				reduction= 100;
				break;
			default:
				break;
			}
			
			break;
		case TCANNON_MED:
			switch (d) {
			case VH_L:
				reduction= 120;
				break;
			case VH_H:
				reduction= 100;
				break;
			case TK:
				reduction= 100;
				break;
			default:
				break;	
			}
			
			break;
		case CANNON:
			switch (d) {
			case INFANTERIA:
				reduction= 50;
				break;
			case VH_L:
				reduction= 100;
				break;
			case VH_H:
				reduction= 100;
				break;
			case TK:
				reduction= 100;
				break;
			}
			
			break;
		case ARMA_AA:
			switch (d) {
			case INFANTERIA:
				reduction= 100;
				break;
			case VH_L:
				reduction= 75;
				break;
			case VH_H:
				reduction= 60;
				break;
			case TK:
				reduction= 10;
				break;
			default:
				break;

			}
			break;
		case COHETE:
			switch (d) {
			case INFANTERIA:
				reduction= 50;
				break;
			case VH_L:
				reduction= 80;
				break;
			case VH_H:
				reduction= 80;
				break;
			case TK:
				reduction= 100;
				break;
			}
			
			break;
			
			default:
				reduction=100;
				break;
		}
		reduction=reduction/100;
		return reduction;
	}
	
}

