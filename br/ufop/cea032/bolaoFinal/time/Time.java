package br.ufop.cea032.bolaoFinal.time;

import java.io.Serializable;

/**
 * Classe que representa um time, para ser usado no sistema.
 * @author Maycon Junior <mayconjr_@live.com>. Carlos Eduardo <carlosdudujunior@hotmail.com>.
 */
public class Time implements Serializable{
	
	private static final long serialVersionUID = -5434378525388689768L;
	
	/** Representa o nome do time. */
	private final String time;
	
	/**
	 * Construtor com o nome do time.
	 * @param time nome do time.
	 */
	public Time(String time){
		this.time = time;
	}
	
	/**
	 * Método para receber o nome do time
	 * @return o nome do time
	 */
	public String getTime(){
		return time;
	}
	
	
	/**
	 * Método para imprimir a String com o nome do time
	 */
	public String toString(){
		return time;
	}

}
