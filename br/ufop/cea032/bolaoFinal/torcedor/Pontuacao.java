package br.ufop.cea032.bolaoFinal.torcedor;

/**
 * Enum para trabalhar com as constantes de pontos.
 * @author Maycon Junior <mayconjr_@live.com>. Carlos Eduardo <carlosdudujunior@hotmail.com>.
 *
 */
public enum Pontuacao implements Pontos{
	/** Pontuação referente a um acerto de placar de um jogo do Time do coração. */
	PLACAR_C(5), 
	/** Pontuação referente a um acerto de resultado(V, D, E) de um jogo do Time do coração. */
	RESULT_C(2), 
	/** Pontuação referente a um erro de resultado(V, D, E) de um jogo do Time do coração. */
	ERRO_C(-2), 
	/** Pontuação referente a um acerto de placar de um jogo sem o Time do coração. */
	PLACAR(3), 
	/** Pontuação referente a um acerto de resultado(V, D, E) de um jogo sem o Time do coração. */
	RESULT(1), 
	/** Pontuação referente a um erro de resultado(V, D, E) de um jogo sem o Time do coração. */
	ERRO(-1);
	
	/** Constante ponto */
	private final int ponto;
	
	/**
	 * Construtor para o enum, atribuindo a constante ponto.
	 * @param ponto Constante do enum
	 */
	private Pontuacao(int ponto){
		this.ponto = ponto;
	}

	@Override
	/**
	 * método para obter o o valor da constante.
	 * @return o valor constante do objeto.
	 */
	public int getPontos(){
		return ponto;
	}
	
	/**
	 * Método toString para impressão do objeto.
	 * @return O valor da constante ponto.
	 */
	public String toString(){
		return ""+ponto;
	}

}
