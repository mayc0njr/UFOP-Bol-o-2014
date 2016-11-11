package br.ufop.cea032.bolaoFinal.exceptions;

/**
 * Exce��o para exce��es causadas pela(s) Rodada(s).
 * @author Maycon Junior <mayconjr_@live.com>. Carlos Eduardo <carlosdudujunior@hotmail.com>.
 *
 */
public class RodadaException extends Exception {
	
	/**	ID da exce��o. */
	private static final long serialVersionUID = 7315544097883926869L;

	/**
	 * Construtor para a exce��o.
	 * @param msg String mensagem do erro.
	 */
	public RodadaException(String msg){
		super(msg);
		
	}

}
