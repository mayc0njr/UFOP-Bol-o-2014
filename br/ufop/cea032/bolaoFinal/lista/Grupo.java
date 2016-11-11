package br.ufop.cea032.bolaoFinal.lista;

import java.util.Collections;
import java.util.List;

import br.ufop.cea032.bolaoFinal.torcedor.Torcedor;

/**
 * Classe que armazenará grupos de torcedores e serão os rankings.
 * @author Maycon Junior <mayconjr_@live.com>. Carlos Eduardo <carlosdudujunior@hotmail.com>.
 *
 */
public class Grupo extends RankingGeral{
	
	private static final long serialVersionUID = 4768645773320369469L;

	/**
	 * Construtor do objeto.
	 * @param titulo Parâmetro que define qual o título do grupo de torcedores.
	 */
	public Grupo(String titulo) {
		super();
		this.titulo = titulo;
	}
	
	//=== Métodos para controle da arraylist (remove, add, get) ========================================
	
	/**
	 * Método para retornar o título do grupo em uma String.
	 * @return Uma String contendo o titulo do grupo.
	 */
	public String getTitulo(){
		return titulo;
	}
	
	/**
	 * Método que verifica se há um torcedor na posição especificada, e retorna se houver.
	 * @param pos Posição para buscar e retornar.
	 * @return o torcedor da posição, ou null.
	 */
	public Torcedor getTorcedor(int pos){
		if(pos < ranking.size() && pos >= 0){
			return ranking.get(pos);
		}
		return null;
	}
	
	/**
	 * Método para conferir se um torcedor já está no grupo.
	 * @param torcedor Torcedor a ser testado se está no grupo.
	 * @return True se encontrar o torcedor no grupo, False se não encontrar o torcedor no grupo.
	 */
	public boolean verSeTem(Torcedor torcedor){
		return ranking.contains(torcedor);
	}
	
	/**
	 * Adiciona o torcedor especificado na lista.
	 * @param torcedor O torcedor que quer adicionar na lista.
	 */
	public void addTorcedor(Torcedor torcedor){
		if(!this.verSeTem(torcedor)){
			ranking.add(torcedor);
			
		}
	}

	/**
	 * Método que verifica se há um torcedor na posição especificada, e o remove da lista se houver.
	 * @param pos Posição para buscar e remover.
	 * @return Se o torcedor foi removido ou não.
	 */
	public boolean removeTorcedor(int pos){
		if(pos < ranking.size() && pos >= 0){
			ranking.remove(pos);
			return true;
		}
		return false;
	}
			
	@Override
	/**
	 * Método para ordenar os torcedores do grupo utilizando como referência sua pontuação.
	 * Atualizado no fim de cada rodada.
	 */
	public void ordena(){
	    Collections.sort(ranking);
	}	
	
	/**
	 * Método para obter a lista completa de torcedores do grupo.
	 * @return O Ranking de torcedores.
	 */
	public List<Torcedor> getAll(){
		return ranking;
	}
	
}
