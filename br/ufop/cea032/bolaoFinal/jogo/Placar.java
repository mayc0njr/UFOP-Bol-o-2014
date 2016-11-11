package br.ufop.cea032.bolaoFinal.jogo;

import java.io.Serializable;

/**
 * Classe que representa o Placar, utilizados em Jogos, e Palpites.
 * @author Maycon Junior <mayconjr_@live.com>. Carlos Eduardo <carlosdudujunior@hotmail.com>.
 *
 */
public final class Placar implements Serializable{
	
	private static final long serialVersionUID = 5392768133439117106L;
	
	/** Gol para o time da casa. */
	private int golA = -1;
	/**Gol para o time visitante. */
	private int golB = -1;
	/**Resultado do jogo, Vit�ria, Derrota, ou Empate.*/
	private Resultado resultado;
	
	/**
	 * Construtor sem atribui��es.
	 */
	public Placar(){
	}
	/**
	 * Construtor com atribui��es dos gols.
	 */
	public Placar(int golA, int golB){
		this.golA = golA;
		this.golB = golB;
	}
//= Dar valores para o placar, e definir o resultado. =============================================
	

	/**
	 * M�todo para definir o resultado do placar.
	 * @param placar Placar com o resultado do jogo.
	 */
	public boolean resultado(Placar placar){
		if(placar.golA >= 0 && placar.golB >= 0){
			this.golA = placar.golA;
			this.golB = placar.golB;
			
			if(this.golA > this.golB) this.resultado = Resultado.VITORIA_A;
			else if(this.golA < this.golB) this.resultado = Resultado.VITORIA_B;
			else this.resultado = Resultado.EMPATE;
			return true; //retorna verdadeiro se o resultado for aceito.
		}
		return false; //retorna falso se o resultado n�o for aceito
		
	}
	
//= M�todos get para obter as v�riaveis e resultado.= =============================================
	
	/**
	 * M�todo para obter o n�mero de golsA.
	 * @return o inteiro golA.
	 */
	public int getGolA(){
		return golA;
	}
	
	/**
	 * M�todo para obter o n�mero de golsB.
	 * @return o inteiro golB.
	 */
	public int getGolB(){
		return golB;
	}
	
	/**
	 * M�todo para obter o resultado (V, D, E).
	 * @return o resultado do placar.
	 */
	public Resultado getResultado(){
		return this.resultado;
	}
	
	
	public String toString(){
		return "| " + golA + " x " + golB + " |";
	}
}
