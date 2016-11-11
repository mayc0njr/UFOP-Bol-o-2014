package br.ufop.cea032.bolaoFinal.tabela;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * Classe destinada a funcionar como "Tabela", armazenando uma lista de rodadas, e fornecendo m�todos para manipul�-la.
 * @author Maycon Junior <mayconjr_@live.com>. Carlos Eduardo <carlosdudujunior@hotmail.com>.
 *
 */
public class Tabela implements Serializable{
	
	private static final long serialVersionUID = 3413491012132535327L;

	private List<Rodada> rodadas = new ArrayList<Rodada>();
	private static Tabela instance;
	
	/**
	 * Construtor privado, chamado apenas pelo m�todo Singleton.
	 */
	private Tabela(){
		
	}
	
	/**
	 * Singleton para permitir apenas uma inst�ncia do objeto.
	 * @return a inst�ncia do objeto.
	 */
	public static Tabela getInstance(){
		if(instance == null){
			instance = new Tabela();
		}
		return instance;
	}
	
	/**
	 * M�todo que permite a adi��o de uma rodada na tabela.
	 * @param rodada Rodada a ser adicionada.
	 */
	public void addRodada(Rodada rodada){
		rodadas.add(rodada);
	}
	
	/**
	 * M�todo que permite obter uma rodada.
	 * @param x Posi��o da rodada a ser obtida.
	 * @return A rodada obtida, ou null, se n�o houver uma rodada na posi��o especificada.
	 */
	public Rodada getRodada(int x){
		if(x < rodadas.size()){
			return rodadas.get(x);
		}
		return null;
	}
	
	/**
	 * Retorna a lista de rodadas.
	 * @return Uma lista semelhante a lista de rodadas.
	 */
	public List<Rodada> getAll(){
		List<Rodada> lista = new ArrayList<Rodada>();
		lista.addAll(rodadas);
		return lista;
	}
	
	/**
	 * M�todo imprime chamado pelo toString.
	 * @return uma String ordenada com as rodadas.
	 */
	public String imprime(){
		String imprime = new String();
		for(int x=0;x<rodadas.size();x++){
			imprime = imprime.concat(""+getRodada(x)+"\n");
		}
		return imprime;
	}
	
	protected void finalizar(boolean finalized){
		Principal.finalizar(finalized);
	}
	
	/**
	 * m�todo para carregar do arquivo.
	 * @param tabela Lista de rodadas a ser carregada.
	 */
	public static void carregar(Tabela tabela){
		instance = tabela;
	}
	/**
	 * M�todo toString para retornar uma String das rodadas e jogos.
	 */
	public String toString(){
		String imprime = imprime();
		return imprime;
	}
}
