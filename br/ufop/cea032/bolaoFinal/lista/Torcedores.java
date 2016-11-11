package br.ufop.cea032.bolaoFinal.lista;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ufop.cea032.bolaoFinal.torcedor.Torcedor;

/**
 * Classe que armazenará os torcedores, para serem manipulados no sistema.
 * @author Maycon Junior <mayconjr_@live.com>. Carlos Eduardo <carlosdudujunior@hotmail.com>.
 */
public class Torcedores implements ListaTorcida, Serializable{
	
	private static final long serialVersionUID = 554324115584898209L;

	/** Lista de torcedores do sistema. */
	private List<Torcedor> torcedores;
	/** Instancia do objeto, para o Singleton */
	private static Torcedores instance = null;
	
	/**
	 * Construtor privado, chamado apenas pelo Singleton getInstance 
	 */
	private Torcedores(){
		torcedores = new ArrayList<Torcedor>();
	}
	
	/**
	 * Singleton para permitir apenas uma instância do objeto.
	 * @return a instância do objeto.
	 */
	public static Torcedores getInstance(){
		if(instance == null){
			instance = new Torcedores();
		}
		return instance;
	}
	
//=== Métodos para controle da arraylist (remove, add, get, imprime) ===============================
	
	@Override
	/**
	 * Método que verifica se há um torcedor na posição especificada, e retorna se houver.
	 * @param pos Posição para buscar e retornar.
	 * @return o torcedor da posição, ou null.
	 */
	public Torcedor getTorcedor(int pos){
		if(pos < torcedores.size() && pos >= 0){
			return torcedores.get(pos);
		}
		return null;
	}

	/**
	 * Método para obter a lista de torcedores completa.
	 * @return A Lista de torcedores.
	 */
	public List<Torcedor> getAll(){
		List<Torcedor> lista = new ArrayList<Torcedor>();
		lista.addAll(torcedores);
		return lista;
	}
	
	@Override
	/**
	 * Adiciona o torcedor especificado na lista.
	 * @param time O torcedor que quer adicionar na lista.
	 */
	public void addTorcedor(Torcedor torcedor){
		torcedores.add(torcedor);
	}

	@Override
	/**
	 * Método que verifica se há um torcedor na posição especificada, e o remove da lista se houver.
	 * @param pos Posição para buscar e remover.
	 * @return Se o torcedor foi removido ou não.
	 */
	public boolean removeTorcedor(int pos){
		if(pos < torcedores.size() && pos >= 0){
			torcedores.remove(pos);
			return true;
		}
		return false;
	}
	
	/**
	 * método para carregar do arquivo.
	 * @param torcedores Lista de tocedores a ser carregada.
	 */
	public static void carregar(Torcedores torcedores){
		instance = torcedores;
	}
	
	/**
	 * Método imprime chamado pelo toString.
	 * @return uma String alinhada com os torcedores.
	 */
	public String imprime(){
		String imprime = new String();
		for(int x=0;x<torcedores.size();x++){
			imprime = imprime.concat("|ID: " +x+"\t"+ torcedores.get(x).toString() + "\n\n");
		}
		return imprime;
	}	

	/**
	 * Método toString para retornar uma String dos torcedores.
	 */
	public String toString(){
		if(torcedores.size() > 0){
			String imprime = imprime();
			return "Torcedores no sistema: " + "\n" + imprime;
		}
		else
			return "Não há torcedores no sistema.";
	}
}
