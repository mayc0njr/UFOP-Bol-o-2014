package br.ufop.cea032.bolaoFinal.exceptions;

/**
 * Exce��o para exce��es causadas pelos times.
 * @author Maycon Junior <mayconjr_@live.com>. Carlos Eduardo <carlosdudujunior@hotmail.com>.
 *
 */
public class TimesException extends Exception {
	
	/** ID da exce��o. */
	private static final long serialVersionUID = -8145475758952063936L;
	
	/**
	 * Construtor para a exce��o.
	 * @param msg String mensagem do erro.
	 */
	public TimesException(String msg){
		super(msg);
		
	}

}
