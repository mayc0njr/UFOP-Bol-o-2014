package br.ufop.cea032.bolaoFinal.torcedor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ufop.cea032.bolaoFinal.exceptions.PalpiteException;
import br.ufop.cea032.bolaoFinal.time.Time;

/**
 * Classe que representa um torcedor, para ser usado no sistema.
 * @author Maycon Junior <mayconjr_@live.com>. Carlos Eduardo <carlosdudujunior@hotmail.com>.
 *
 */
public class Torcedor implements Comparable<Torcedor>, Serializable{
	
	private static final long serialVersionUID = -834328517518110445L;

	/** Nome do torcedor. */
	private final String nome;
	/** Time do cora��o do torcedor. */
	private Time time;
	/** Pontua��o do Torcedor. */
	private Ponto ponto;	
	/** Palpites do Torcedor. */
	private List<Palpite> palpites;
	
	/**
	 * Construtor para o torcedor.
	 * @param nome Nome do torcedor.
	 * @param time Time do cora��o do torcedor.
	 */
	public Torcedor(String nome, Time time){
		this.nome = nome;
		this.time = time;
		ponto = new Ponto();
		palpites = new ArrayList<Palpite>();
	}
	
	/**
	 * M�todo para obter o nome do torcedor.
	 * @return o nome do torcedor.
	 */
	public String getNome(){
		return nome;
	}
	
	/**
	 * M�todo para obter o time do cora��o do torcedor.
	 * @return o time do torcedor.
	 */
	public Time getTime(){
		return time;
	}
	
	/**
	 * M�todo para obter a quantidade de pontos do torcedor
	 */
	public int getPontos(){
		return ponto.getPontos();
	}
	
	/**
	 * M�todo implementado da interface Comparable, para ordenar os torcedores em um ranking.
	 * @param torcedor Torcedor para comparar.
	 * @return um inteiro para representar qual dos torcedores tem mais pontos, ou se possuem a mesma quantidade.
	 */
	public int compareTo(Torcedor torcedor){
		if(this.getPontos() < torcedor.getPontos()) return 1;
		else if(this.getPontos() == torcedor.getPontos()) return 0;
		else return -1;
	}
	
	/**
	 * M�todo usado para alterar o time do torcedor.
	 * @param time
	 */
	public void setTime(Time time){
		this.time = time;
	}
	
	/**
	 * calcula/soma a pontua��o do torcedor.
	 */
	public void resultado(Pontuacao pontos){
		ponto.resultado(pontos);
	}
	
	/**
	 * M�todo que permite ao torcedor, adicionar um palpite a um jogo.
	 * O Palpite s� ser� adicionado caso o torcedor n�o tenha dado um palpite a esse jogo,
	 * e o jogo ainda n�o tenha resultado definido.
	 * @param palpite O palpite a ser adicionado sobre o jogo.
	 */
	public void addPalpite(Palpite palpite) throws PalpiteException{
		boolean jaPalpitou = false;
		for(int x=0;x<palpites.size();x++){
			if(palpites.get(x).getJogo() == palpite.getJogo()){
				jaPalpitou = true;
				break;
			}
		}
		if(palpite.getJogo().getFinalized() == true){
			throw new IllegalStateException("Este jogo n�o pode receber um palpite pois j� foi finalizado.");
		}
		else if(jaPalpitou == true){
			throw new PalpiteException("Este torcedor j� deu um palpite para este jogo.");
		}
		else{
			palpites.add(palpite);
			}
	}
	
	/**
	 *
	 * M�todo que permite ao torcedor, alterar um palpite cadastrado anteriormente.
	 * O Palpite s� sera alterado, caso o palpite escolhido seja referente ao mesmo jogo do novo palpite,
	 * e caso o jogo referenciado ainda n�o tenha sido finalizado.
	 * @param pos Posi��o do palpite a ser alterado.
	 * @param palpite O novo palpite a ser colocado.
	 * @throws PalpiteException Caso o palpite n�o possa ser alterado.
	 */
	public void setPalpite(int pos, Palpite palpite) throws PalpiteException{
		if(pos >= palpites.size()){
			throw new PalpiteException("N�o existe um palpite nessa posi��o.");
		}
		
		else if(palpites.get(pos).getJogo().getFinalized() == true){
			throw new IllegalStateException("N�o � poss�vel mudar um palpite cujo jogo j� tem resultado definido.");
		}
		
		else if(palpites.get(pos).getJogo() != palpite.getJogo()){
			throw new IllegalArgumentException("O Jogo do palpite existente, � diferente do jogo novo palpite.");
		}
		
		else
			palpites.set(pos, palpite);
		
	}
	
	/**
	 * Permite ao torcedor, remover um palpite cadastrado anteriormente.
	 * O palpite so poder� ser removido caso o jogo referente a ele n�o tiver sido finalizado.
	 * @param pos Posi��o do palpite a ser removido.
	 * @throws PalpiteException Caso o palpite n�o possa ser removido.
	 */
	public void removePalpite(int pos) throws PalpiteException{
		if(pos >= palpites.size()){
			throw new PalpiteException("N�o existe um palpite nessa posi��o.");
		}
		else if(palpites.get(pos).getJogo().getFinalized() == true){
			throw new IllegalStateException("N�o � poss�vel remover um palpite cujo jogo j� tem resultado definido.");
		}
		
		else
			palpites.remove(pos);
	}
	
	/**
	 * M�todo que permite ao torcedor obter um palpite da lista.
	 * @param pos Posi��o do palpite a ser recebido.
	 * @return O Palpite da posi��o escohida, ou null, caso n�o possa ser obtido algum Palpite.
	 */
	public Palpite getPalpite(int pos){
		if(pos < palpites.size()){
			return palpites.get(pos);
		}
		return null;
	}
	
	/**
	 * M�todo que permite ao torcedor obter uma lista de palpites, similar a que ele possui.
	 * @return Uma lista secund�ria que contem os mesmos palpites.
	 */
	public List<Palpite> getAllPalpite(){
		List<Palpite> lista = new ArrayList<Palpite>();
		lista.addAll(palpites);
		return lista;
	}
	
	/**
	 * M�todo para obter a lista de palpites do torcedor de forma ordenada.
	 * @return Uma string ordenada contendo todos os palpites do torcedor.
	 */
	public String ImprimePalpite(){
		String imprime = new String();
		if(palpites.size() > 0){
			for(int x=0 ; x<palpites.size() ; x++){
				imprime = imprime.concat("ID: " + x + "\t" + palpites.get(x) + "\n");
			}
		}
		else{
			imprime = "N�o h� palpites para este torcedor.";
		}
		return imprime;
	}
	
	/**
	 * M�todo toString para imprimir o objeto.
	 * @return uma String com o nome e o time do cora��o do torcedor.
	 */
	public String toString(){
		return "|Pts:"+ponto.getPontos()+"\t|Nome: " + nome +"\t|Time: " + time;
	}
	
}
