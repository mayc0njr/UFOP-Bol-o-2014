package br.ufop.cea032.bolaoFinal.lista;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Grupos implements Serializable{

	private static final long serialVersionUID = -1556987515858970802L;
	
	/**Lista de Grupos.*/
	private List<Grupo> grupos = new ArrayList<Grupo>();
	/** Instancia �nica do objeto.*/
	private static Grupos instance;
	
	/**
	 * Construtor privado chamado pelo Singleton getInstance().
	 */
	private Grupos(){
		
	}
	
	/**
	 * M�todo Singleton para permitir apenas uma inst�ncia do objeto.
	 * @return A inst�ncia �nica do objeto.
	 */
	public static Grupos getInstance(){
		if(instance == null){
			instance = new Grupos();
		}
		return instance;
	}
	
	/**
	 * M�todo para adicionar um grupo � lista de grupos.
	 * @param grupo Grupo a ser adicionado na lista de grupos.
	 */
	public void addGrupo(Grupo grupo){
		grupos.add(grupo);
	}
	
	/**
	 * M�todo que permite a remo��o de um grupo da lista de grupos.
	 * @param pos Posi��o do grupo a ser removida.
	 * @return True se o grupo for removido. False se o grupo n�o for removido.
	 */
	public boolean removeGrupo(int pos){
		if(pos < grupos.size()){
			grupos.remove(pos);
			return true;
		}
		return false;
	}
	
	/**
	 * M�todo para obter um Grupo de uma posi��o espec�fica na lista de grupos.
	 * @param pos Posi��o do ou grupo a ser obtida.
	 * @return o Grupo da posi��o escolhida.
	 */
	public Grupo getGrupo(int pos){
		if(pos < grupos.size()){
			return grupos.get(pos);
		}
		return null;
	}
	
	/**
	 * M�todo para obter a lista de grupos completa.
	 * @return Lista de grupos completa.
	 */
	public List<Grupo> getAll(){
		List<Grupo> lista = new ArrayList<Grupo>();
		lista.addAll(grupos);
		return lista;
	}
	
	/**
	 * M�todo para gerar uma String com os Grupos.
	 * @return Uma String ordenada e alinhada com os grupos.
	 */
	public String imprimeTitulos(){
		String imprime = new String();
		for(int x=0; x<grupos.size();x++){
			imprime = imprime.concat("ID: "+ x +"\t|T�tulo: "+grupos.get(x).getTitulo()+"\n");
		}
		return imprime;
	}
	
	/**
	 * m�todo para carregar do arquivo.
	 * @param grupos Lista de grupos a ser carregada.
	 */
	public static void carregar(Grupos grupos){
		instance = grupos;
	}	
	/**
	 * M�todo imprime chamado pelo toString.
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
	 * M�todo toString para retornar uma String alinhada dos grupos e os torcedores neles inclu�dos.
	 */
	public String toString(){
		return "Grupos: \n"+imprime();
	}
}
