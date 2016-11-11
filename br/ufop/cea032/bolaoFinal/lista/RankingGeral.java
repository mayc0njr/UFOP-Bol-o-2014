package br.ufop.cea032.bolaoFinal.lista;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.ufop.cea032.bolaoFinal.torcedor.Torcedor;

/**
 * Classe que armazenará grupos de torcedores e serão os rankings.
 * @author Maycon Junior <mayconjr_@live.com>. Carlos Eduardo <carlosdudujunior@hotmail.com>.
 *
 */
public class RankingGeral implements Serializable{

	private static final long serialVersionUID = 3849208371432972959L;
	
	protected String titulo = "Ranking Geral";
	protected List<Torcedor> ranking;
	private static RankingGeral instance;
	
	/**
	 * Construtor do objeto.
	 * @param titulo Parâmetro que define qual o título do grupo de torcedores.
	 */
	protected RankingGeral() {
		ranking = new ArrayList<Torcedor>();
	}
	
	/**
	 * Método Singleton que permitirá apenas um Ranking Geral de torcedores.
	 * @return A instância única do objeto.
	 */
	public static RankingGeral getInstance(){
		if(instance == null){
			instance = new RankingGeral();
		}
		return instance;
	}
	
	/**
	 * Método para retornar o título do ranking em uma String.
	 * @return Uma String contendo o titulo do grupo.
	 */
	public String getTitulo(){
		return titulo;
	}
	
	/**
	 * Método para retornar uma lista de torcedores semelhante a lista do ranking.
	 */
	public List<Torcedor> getAll(){
		List<Torcedor> lista = new ArrayList<Torcedor>();
		lista.addAll(ranking);
		return lista;
	}	
	
	
	/**
	 * Método para ordenar os torcedores do grupo utilizando como referência sua pontuação.
	 * Atualizado no fim de cada rodada.
	 */
	public void ordena(){
		List<Torcedor> ranking2 = Torcedores.getInstance().getAll();
		this.ranking.clear();
		this.ranking.addAll(ranking2);
	    Collections.sort(ranking);
	    while(ranking.size() > 100){
	    	ranking.remove(101);
	    }
	}	
	
	/**
	 * Método imprime chamado pelo toString.
	 * @return uma String alinhada com os torcedores.
	 */
	public String imprime(){
		String imprime = new String();
		for(int x=0;x<ranking.size();x++){
			imprime = imprime.concat("|ID: " +x+"\t"+ ranking.get(x).toString() + "\n\n");
		}
		return imprime;
	}
	
	/**
	 * Método toString para retornar uma String dos torcedores.
	 */
	public String toString(){
		if(ranking.size() > 0){
			String imprime = imprime();
			return titulo + "\n" + imprime;
		}
		else
			return "Grupo: "+ titulo +"\nNão há torcedores.";
	}
}
