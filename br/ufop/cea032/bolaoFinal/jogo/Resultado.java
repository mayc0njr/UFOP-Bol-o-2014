package br.ufop.cea032.bolaoFinal.jogo;

/**
 * Enum para trabalhar com as constantes de resultado dos jogos.
 * @author Maycon Junior <mayconjr_@live.com>. Carlos Eduardo <carlosdudujunior@hotmail.com>.
 *
 */
public enum Resultado {
	/** Constante caso o TimeA tenha vencido a partida. */
	VITORIA_A(1),
	/** Constante caso o TimeB tenha vencido a partida. */
	VITORIA_B(-1),
	/** Constante caso a partida tenha terminado em empate.*/
	EMPATE(0);
	
	/** Constante resultado. */
	private final int resultado;
	
	/**
	 * Construtor para o enum, atribuindo a constante resultado.
	 * @param resultado Constante do enum
	 */
	private Resultado(int resultado){
		this.resultado = resultado;
	}
	

	/**
	 * método para obter o o valor da constante.
	 * @return o valor constante do objeto.
	 */
	public int getResultado(){
		return resultado;
	}
	
	/**
	 * Método toString para impressão do objeto.
	 * @return O valor da constante ponto.
	 */
	public String toString(){
		return ""+resultado;
	}

}
