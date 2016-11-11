package br.ufop.cea032.bolaoFinal.torcedor;

/**
 * Enum para trabalhar com as constantes de pontos.
 * @author Maycon Junior <mayconjr_@live.com>. Carlos Eduardo <carlosdudujunior@hotmail.com>.
 *
 */
public enum Pontuacao implements Pontos{
	/** Pontua��o referente a um acerto de placar de um jogo do Time do cora��o. */
	PLACAR_C(5), 
	/** Pontua��o referente a um acerto de resultado(V, D, E) de um jogo do Time do cora��o. */
	RESULT_C(2), 
	/** Pontua��o referente a um erro de resultado(V, D, E) de um jogo do Time do cora��o. */
	ERRO_C(-2), 
	/** Pontua��o referente a um acerto de placar de um jogo sem o Time do cora��o. */
	PLACAR(3), 
	/** Pontua��o referente a um acerto de resultado(V, D, E) de um jogo sem o Time do cora��o. */
	RESULT(1), 
	/** Pontua��o referente a um erro de resultado(V, D, E) de um jogo sem o Time do cora��o. */
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
	 * m�todo para obter o o valor da constante.
	 * @return o valor constante do objeto.
	 */
	public int getPontos(){
		return ponto;
	}
	
	/**
	 * M�todo toString para impress�o do objeto.
	 * @return O valor da constante ponto.
	 */
	public String toString(){
		return ""+ponto;
	}

}
