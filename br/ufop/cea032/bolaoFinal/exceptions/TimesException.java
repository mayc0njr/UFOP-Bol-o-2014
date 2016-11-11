package br.ufop.cea032.bolaoFinal.exceptions;

/**
 * Exceção para exceções causadas pelos times.
 * @author Maycon Junior <mayconjr_@live.com>. Carlos Eduardo <carlosdudujunior@hotmail.com>.
 *
 */
public class TimesException extends Exception {
	
	/** ID da exceção. */
	private static final long serialVersionUID = -8145475758952063936L;
	
	/**
	 * Construtor para a exceção.
	 * @param msg String mensagem do erro.
	 */
	public TimesException(String msg){
		super(msg);
		
	}

}
