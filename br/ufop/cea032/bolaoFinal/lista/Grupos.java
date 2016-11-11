package br.ufop.cea032.bolaoFinal.lista;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Grupos implements Serializable{

	private static final long serialVersionUID = -1556987515858970802L;
	
	/**Lista de Grupos.*/
	private List<Grupo> grupos = new ArrayList<Grupo>();
	/** Instancia única do objeto.*/
	private static Grupos instance;
	
	/**
	 * Construtor privado chamado pelo Singleton getInstance().
	 */
	private Grupos(){
		
	}
	
	/**
	 * Método Singleton para permitir apenas uma instância do objeto.
	 * @return A instância única do objeto.
	 */
	public static Grupos getInstance(){
		if(instance == null){
			instance = new Grupos();
		}
		return instance;
	}
	
	/**
	 * Método para adicionar um grupo à lista de grupos.
	 * @param grupo Grupo a ser adicionado na lista de grupos.
	 */
	public void addGrupo(Grupo grupo){
		grupos.add(grupo);
	}
	
	/**
	 * Método que permite a remoção de um grupo da lista de grupos.
	 * @param pos Posição do grupo a ser removida.
	 * @return True se o grupo for removido. False se o grupo não for removido.
	 */
	public boolean removeGrupo(int pos){
		if(pos < grupos.size()){
			grupos.remove(pos);
			return true;
		}
		return false;
	}
	
	/**
	 * Método para obter um Grupo de uma posição específica na lista de grupos.
	 * @param pos Posição do ou grupo a ser obtida.
	 * @return o Grupo da posição escolhida.
	 */
	public Grupo getGrupo(int pos){
		if(pos < grupos.size()){
			return grupos.get(pos);
		}
		return null;
	}
	
	/**
	 * Método para obter a lista de grupos completa.
	 * @return Lista de grupos completa.
	 */
	public List<Grupo> getAll(){
		List<Grupo> lista = new ArrayList<Grupo>();
		lista.addAll(grupos);
		return lista;
	}
	
	/**
	 * Método para gerar uma String com os Grupos.
	 * @return Uma String ordenada e alinhada com os grupos.
	 */
	public String imprimeTitulos(){
		String imprime = new String();
		for(int x=0; x<grupos.size();x++){
			imprime = imprime.concat("ID: "+ x +"\t|Título: "+grupos.get(x).getTitulo()+"\n");
		}
		return imprime;
	}
	
	/**
	 * método para carregar do arquivo.
	 * @param grupos Lista de grupos a ser carregada.
	 */
	public static void carregar(Grupos grupos){
		instance = grupos;
	}	
	/**
	 * Método imprime chamado pelo toString.
	 * @return uma String alinhada com os grupos.
	 */
	public String imprime(){
		String imprime = new String();
		for(int x=0; x<grupos.size();x++){
			imprime = imprime.concat(grupos.get(x).toString()+"\n");
		}
		return imprime;
	}
	
	/**
	 * Método toString para retornar uma String alinhada dos grupos e os torcedores neles incluídos.
	 */
	public String toString(){
		return "Grupos: \n"+imprime();
	}
}
