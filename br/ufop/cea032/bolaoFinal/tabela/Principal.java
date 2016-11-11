package br.ufop.cea032.bolaoFinal.tabela;

import java.io.Serializable;


/**
 * Classe que guarda o "status" do campeonato (iniciado/terminado)
 * @author Maycon Junior <mayconjr_@live.com>. Carlos Eduardo <carlosdudujunior@hotmail.com>.
 *
 */
public class Principal implements Serializable{
	
	private static final long serialVersionUID = -4022221687846536882L;

	/** instancia do campeonato, usada pelo singleton para n�o permitir que outra seja instanciada. */
	private static Principal instance;
	/** boolean que espec�fica se o campeonato come�ou ou n�o */
	private static boolean comecou=false;
	/** boolean que espec�fica se o campeonato come�ou ou n�o */
	private static boolean terminou=false;
	
	/**
	 * Construtor do campeonato, recebendo o ranking geral de torcedores.
	 */
	private Principal(){
	}
	
	/**
	 * M�todo Singleton, para nao permitir mais de uma inst�ncia deste objeto.
	 * Caso n�o haja nenhuma inst�ncia, � chamado o construtor.
	 * @return A inst�ncia do objeto.
	 */
	public static Principal getInstance(){
		if(instance == null){
			instance = new Principal();
		}
		return instance;
	}
	
	/**
	 * M�todo para finalizar o campeonato.
	 * Este m�todo s� pode ser chamado pelas classes do pacote.
	 * � chamado automaticamente quando a �ltima rodada � finalizada
	 * @param finalized Boolean a ser passado para finalizar o campeonato.
	 */
	protected static void finalizar(boolean finalized){
		terminou = finalized;
	}
	
	/**
	 * M�todo que declara o campeonato como iniciado.
	 */
	public static void iniciar(){
		comecou = true;
	}
	
	/**
	 * M�todo para retornar se o campeonato iniciou ou n�o.
	 * @return Boolean comecou, que indica o status do campeonato (iniciado ou n�o).
	 */
	public boolean getComecou(){
		return comecou;
	}
	
	/**
	 * M�todo para retornar se o campeonato est� ou n�o terminado.
	 * @return Boolean terminou, que indica o status do campeonato (terminado ou n�o).
	 */
	public boolean getTerminou(){
		return terminou;
	}
	
	/**
	 * m�todo para carregar do arquivo.
	 * @param principal Atributos da classe a serem carregados.
	 */
	public static void carregar(Principal principal){
		instance = principal;
	}

}
