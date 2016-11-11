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
	 * M�todo para adicionar torcedor.
	 * @param torcedor Torcedor para ser adicionado.
	 */
	public void addTorcedor(Torcedor torcedor);
	
	/**
	 * M�todo para remover torcedor.
	 * @param pos Posi��o a ser removida.
	 * @return Um boolean confirmando se o torcedor foi removido ou n�o.
	 */
	public boolean removeTorcedor(int pos);
	

	/**
	 * M�todo para obter um torcedor.
	 * @param pos Posi��o da lista a ser retornada.
	 * @return um Torcedor da posi��o 'pos'.
	 */
	public Torcedor getTorcedor(int pos);
	
	/**
	 * M�todo para obter uma lista com todos os componentes.
	 * @return Uma lista semelhante � lista original.
	 */
	public List<?> getAll();
}
