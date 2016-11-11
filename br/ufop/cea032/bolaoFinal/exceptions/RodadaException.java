package br.ufop.cea032.bolaoFinal.exceptions;

/**
 * Exceção para exceções causadas pela(s) Rodada(s).
 * @author Maycon Junior <mayconjr_@live.com>. Carlos Eduardo <carlosdudujunior@hotmail.com>.
 *
 */
public class RodadaException extends Exception {
	
	/**	ID da exceção. */
	private static final long serialVersionUID = 7315544097883926869L;

	/**
	 * Construtor para a exceção.
	 * @param msg String mensagem do erro.
	 */
	public RodadaException(String msg){
		super(msg);
		
	}

}
