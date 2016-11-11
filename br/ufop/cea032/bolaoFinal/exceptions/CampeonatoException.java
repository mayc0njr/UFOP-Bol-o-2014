package br.ufop.cea032.bolaoFinal.exceptions;

/**
 * Exceção para exceções causadas pelo campeonato.
 * @author Maycon Junior <mayconjr_@live.com>. Carlos Eduardo <carlosdudujunior@hotmail.com>.
 *
 */
public class CampeonatoException extends Exception {
	
	/**	ID da exceção. */
	private static final long serialVersionUID = 2304421270088687560L;

	/**
	 * Construtor para a exceção.
	 * @param msg String mensagem do erro.
	 */
	public CampeonatoException(String msg){
		super(msg);
		
	}

}
