package br.ufop.cea032.bolaoFinal.lista;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ufop.cea032.bolaoFinal.time.Time;

/**
 * Classe que armazenar� os times, para ser usado no sistema.
 * @author Maycon Junior <mayconjr_@live.com>. Carlos Eduardo <carlosdudujunior@hotmail.com>.
 */
public class Times implements Serializable{
	
	private static final long serialVersionUID = -287801724444234123L;

	/** Lista de times do sistema. */
	private List<Time> times;
	/** Instancia do objeto, para o Singleton */
	private static Times instance = null;
	
	/**
	 * Construtor vazio. Chamado apenas pelo Singleton getInstance.
	 */
	private Times(){
		times = new ArrayList<Time>();
	}
	
	/**
	 * Singleton para permitir apenas uma inst�ncia do objeto.
	 * @return a inst�ncia do objeto.
	 */
	public static Times getInstance(){
		if(instance == null){
			instance = new Times();
		}
		return instance;
	}
	
//=== M�todos para controle da arraylist (remove, add, get) ========================================
	
	/**
	 * M�todo que verifica se h� um time na posi��o especificada, e retorna se houver.
	 * @param pos posi��o para buscar e retornar.
	 * @return o Time da posi��o, ou null.
	 */
	public Time getTime(int pos){
		if(pos < times.size() && pos >=0){
			return times.get(pos);
		}
			return null;
	}
	
	/**
	 * M�todo que verifica se h� um time na posi��o especificada, e altera-o pelo Time passado no parametro.
	 * @param pos posi��o para buscar e modificar o time.
	 * @param time Time a ser colocado no lugar do antigo.
	 */
	public void setTime(int pos, Time time){
		if(pos < times.size() && pos >=0){
			times.set(pos, time);
		}
	}
	
	/**
	 * M�todo para obter uma lista similar a List<Time>.
	 * @return A Lista de times.
	 */
	public List<Time> getAll(){
		List<Time> lista = new ArrayList<Time>();
		lista.addAll(times);
		return lista;
	}
	
	/**
	 * Adiciona o time especificado na lista.
	 * @param time O time que quer adicionar na lista.
	 */
	public void add(Time time){
		times.add(time);
	}
	
	/**
	 * M�todo que verifica se h� um time na posi��o especificada, e o remove da lista se houver.
	 * @param pos Posi��o para buscar e remover.
	 * @return se o time foi removido ou n�o.
	 */
	public boolean remove(int pos){
		if(pos < times.size() && pos >=0){ //Verifica se a posi��o informada est� na lista de times.
			Time time = times.get(pos); //Verifica qual time ser� removido (se estiver na lista)
			for(int x=0; x < Torcedores.getInstance().getAll().size(); x++){ //for para percorrer a lista de torcedores
				if(Torcedores.getInstance().getTorcedor(x).getTime().equals(time) == true){ //Verifica se algum torcedor torce para o time que ser� removido.
					Torcedores.getInstance().getTorcedor(x).setTime(null); // O Time � removido do torcedor.
				}
			}
			times.remove(pos); //O time � removido da lista de times.
			return true; //Retorna true, o time foi removido.
		}
		return false; //Retorna false, o time n�o foi removido.
	}
	
	/**
	 * m�todo para carregar do arquivo.
	 * @param times Lista de times a ser carregada.
	 */
	public static void carregar(Times times){
		instance = times;
	}
	/**
	 * M�todo usado para imprimir a lista de times.
	 */
	public String imprime(){
		String imprime = new String();
		if(times.size()>0){
			for(int x=0; x < times.size(); x++){
				imprime = imprime.concat("ID: " +x+ "\t Time: " + times.get(x).getTime() + "\n");
			}
		return imprime;	
		}
		return "lista de times vazia!";
	}
	
	/**
	 * M�todo toString para retornar uma String dos times.
	 */
	public String toString(){
		return imprime();
	}

}
