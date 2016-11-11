package br.ufop.cea032.bolaoFinal.exceptions;

/**
 * Exce��o para exce��es causadas pelo campeonato.
 * @author Maycon Junior <mayconjr_@live.com>. Carlos Eduardo <carlosdudujunior@hotmail.com>.
 *
 */
public class CampeonatoException extends Exception {
	
	/**	ID da exce��o. */
	private static final long serialVersionUID = 2304421270088687560L;

	/**
	 * Construtor para a exce��o.
	 * @param msg String mensagem do erro.
	 */
	public CampeonatoException(String msg){
		super(msg);
		
	}

}
