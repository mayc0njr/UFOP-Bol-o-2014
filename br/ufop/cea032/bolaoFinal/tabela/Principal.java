package br.ufop.cea032.bolaoFinal.tabela;

import java.io.Serializable;


/**
 * Classe que guarda o "status" do campeonato (iniciado/terminado)
 * @author Maycon Junior <mayconjr_@live.com>. Carlos Eduardo <carlosdudujunior@hotmail.com>.
 *
 */
public class Principal implements Serializable{
	
	private static final long serialVersionUID = -4022221687846536882L;

	/** instancia do campeonato, usada pelo singleton para não permitir que outra seja instanciada. */
	private static Principal instance;
	/** boolean que específica se o campeonato começou ou não */
	private static boolean comecou=false;
	/** boolean que específica se o campeonato começou ou não */
	private static boolean terminou=false;
	
	/**
	 * Construtor do campeonato, recebendo o ranking geral de torcedores.
	 */
	private Principal(){
	}
	
	/**
	 * Método Singleton, para nao permitir mais de uma instância deste objeto.
	 * Caso não haja nenhuma instância, é chamado o construtor.
	 * @return A instância do objeto.
	 */
	public static Principal getInstance(){
		if(instance == null){
			instance = new Principal();
		}
		return instance;
	}
	
	/**
	 * Método para finalizar o campeonato.
	 * Este método só pode ser chamado pelas classes do pacote.
	 * É chamado automaticamente quando a última rodada é finalizada
	 * @param finalized Boolean a ser passado para finalizar o campeonato.
	 */
	protected static void finalizar(boolean finalized){
		terminou = finalized;
	}
	
	/**
	 * Método que declara o campeonato como iniciado.
	 */
	public static void iniciar(){
		comecou = true;
	}
	
	/**
	 * Método para retornar se o campeonato iniciou ou não.
	 * @return Boolean comecou, que indica o status do campeonato (iniciado ou não).
	 */
	public boolean getComecou(){
		return comecou;
	}
	
	/**
	 * Método para retornar se o campeonato está ou não terminado.
	 * @return Boolean terminou, que indica o status do campeonato (terminado ou não).
	 */
	public boolean getTerminou(){
		return terminou;
	}
	
	/**
	 * método para carregar do arquivo.
	 * @param principal Atributos da classe a serem carregados.
	 */
	public static void carregar(Principal principal){
		instance = principal;
	}

}
