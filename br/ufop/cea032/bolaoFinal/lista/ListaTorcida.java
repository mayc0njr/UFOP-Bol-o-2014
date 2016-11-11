package br.ufop.cea032.bolaoFinal.lista;

import java.util.List;

import br.ufop.cea032.bolaoFinal.torcedor.Torcedor;

/**
 * Interface para gerenciamento de torcedores como Listas, e Grupos de torcedores.
 * @author Maycon Junior <mayconjr_@live.com>. Carlos Eduardo <carlosdudujunior@hotmail.com>.
 *
 */
public interface ListaTorcida{
	/**
	 * Método para adicionar torcedor.
	 * @param torcedor Torcedor para ser adicionado.
	 */
	public void addTorcedor(Torcedor torcedor);
	
	/**
	 * Método para remover torcedor.
	 * @param pos Posição a ser removida.
	 * @return Um boolean confirmando se o torcedor foi removido ou não.
	 */
	public boolean removeTorcedor(int pos);
	

	/**
	 * Método para obter um torcedor.
	 * @param pos Posição da lista a ser retornada.
	 * @return um Torcedor da posição 'pos'.
	 */
	public Torcedor getTorcedor(int pos);
	
	/**
	 * Método para obter uma lista com todos os componentes.
	 * @return Uma lista semelhante à lista original.
	 */
	public List<?> getAll();
}
