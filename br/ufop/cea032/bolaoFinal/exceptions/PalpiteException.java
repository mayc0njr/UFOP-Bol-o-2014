package br.ufop.cea032.bolaoFinal.exceptions;

/**
 * Exceção para exceções relacionadas aos Palpites.
 * @author Maycon Junior <mayconjr_@live.com>. Carlos Eduardo <carlosdudujunior@hotmail.com>.
 *
 */
public class PalpiteException extends Exception {
	
	/**	ID da exceção */
	private static final long serialVersionUID = 8099088110739809351L;
	
	/**
	 * Construtor para a exceção.
	 * @param msg String mensagem do erro.
	 */
	public PalpiteException(String msg){
		super(msg);
	}
}
