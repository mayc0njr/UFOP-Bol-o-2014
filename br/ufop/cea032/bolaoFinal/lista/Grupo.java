package br.ufop.cea032.bolaoFinal.lista;

import java.util.Collections;
import java.util.List;

import br.ufop.cea032.bolaoFinal.torcedor.Torcedor;

/**
 * Classe que armazenar� grupos de torcedores e ser�o os rankings.
 * @author Maycon Junior <mayconjr_@live.com>. Carlos Eduardo <carlosdudujunior@hotmail.com>.
 *
 */
public class Grupo extends RankingGeral{
	
	private static final long serialVersionUID = 4768645773320369469L;

	/**
	 * Construtor do objeto.
	 * @param titulo Par�metro que define qual o t�tulo do grupo de torcedores.
	 */
	public Grupo(String titulo) {
		super();
		this.titulo = titulo;
	}
	
	//=== M�todos para controle da arraylist (remove, add, get) ========================================
	
	/**
	 * M�todo para retornar o t�tulo do grupo em uma String.
	 * @return Uma String contendo o titulo do grupo.
	 */
	public String getTitulo(){
		return titulo;
	}
	
	/**
	 * M�todo que verifica se h� um torcedor na posi��o especificada, e retorna se houver.
	 * @param pos Posi��o para buscar e retornar.
	 * @return o torcedor da posi��o, ou null.
	 */
	public Torcedor getTorcedor(int pos){
		if(pos < ranking.size() && pos >= 0){
			return ranking.get(pos);
		}
		return null;
	}
	
	/**
	 * M�todo para conferir se um torcedor j� est� no grupo.
	 * @param torcedor Torcedor a ser testado se est� no grupo.
	 * @return True se encontrar o torcedor no grupo, False se n�o encontrar o torcedor no grupo.
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
	 * M�todo que verifica se h� um torcedor na posi��o especificada, e o remove da lista se houver.
	 * @param pos Posi��o para buscar e remover.
	 * @return Se o torcedor foi removido ou n�o.
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
	 * M�todo para ordenar os torcedores do grupo utilizando como refer�ncia sua pontua��o.
	 * Atualizado no fim de cada rodada.
	 */
	public void ordena(){
	    Collections.sort(ranking);
	}	
	
	/**
	 * M�todo para obter a lista completa de torcedores do grupo.
	 * @return O Ranking de torcedores.
	 */
	public List<Torcedor> getAll(){
		return ranking;
	}
	
}
