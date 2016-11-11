package br.ufop.cea032.bolaoFinal.tabela;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ufop.cea032.bolaoFinal.jogo.Jogo;
import br.ufop.cea032.bolaoFinal.lista.Grupos;
import br.ufop.cea032.bolaoFinal.lista.RankingGeral;
import br.ufop.cea032.bolaoFinal.lista.Torcedores;
import br.ufop.cea032.bolaoFinal.time.Time;
import br.ufop.cea032.bolaoFinal.torcedor.Palpite;
import br.ufop.cea032.bolaoFinal.torcedor.Pontuacao;
import br.ufop.cea032.bolaoFinal.torcedor.Torcedor;

/**
 * Classe destinada a funcionar como "Rodada", armazenando a lista de jogos referente a uma rodada do campeonato.
 * @author Maycon Junior <mayconjr_@live.com>. Carlos Eduardo <carlosdudujunior@hotmail.com>.
 *
 */
public class Rodada implements Serializable{

	private static final long serialVersionUID = -8578520699323286217L;
	
	private final int ID;
	private static int IDMestre=0;
	private List<Jogo> jogos = new ArrayList<Jogo>();
	private boolean finalized;
	
	/**
	 * Construtor da Rodada. Atribuindo um ID diferente pra cada rodada.
	 */
	public Rodada(){
		ID = IDMestre;
		IDMestre++;
	}
	
	/**
	 * Adiciona um jogo na lista.
	 * @param jogo Jogo a ser adicionado.
	 */
	public void addJogo(Jogo jogo){
		jogos.add(jogo);
	}
	
	/**
	 * Método para obter um jogo da lista.
	 * @param jogo Posição do jogo a ser obtido.
	 * @return O jogo da posição se for encontrado.
	 */
	public Jogo getJogo(int jogo){
		if(jogo < jogos.size()){
			return jogos.get(jogo);
		}
		return null;
	}
	
	/**
	 * Método para obter a lista de jogos.
	 * @return a lista de jogos.
	 */
	public List<Jogo> getAll(){
		return jogos;
	}
	
	/**
	 * Método para saber se a rodada está ou não finalizada.
	 * @return O boolean finalized.
	 */
	public boolean getFinalized(){
		return finalized;
	}
	
	/**
	 * Método para obter qual o ID da rodada.
	 * @return O ID da rodada.
	 */
	public int getID(){
		return ID;
	}
	
	/**
	 * Método para finalizar a rodada.
	 * A rodada só é finalizada se todos os jogos tiverem resultado definido.
	 */
	public void finalizar(){
		finalized = true;
		for(int x=0 ; x<jogos.size() ; x++){
			if(jogos.get(x).getFinalized() == false){
				finalized = false;
			}
		}
		if(finalized == true){
			
			for(int x=0 ; x<jogos.size() ; x++){ //Percorre a lista de jogos.
				for(int y=0;y<Torcedores.getInstance().getAll().size();y++){ //Percorre a lista de times.
					if(jogos.get(x).getFinalized())
						resultado(jogos.get(x), Torcedores.getInstance().getTorcedor(y)); //Chama o método que atribui pontos.
				}
				
			}
			for(int x=0 ; x<Grupos.getInstance().getAll().size() ; x++){
				Grupos.getInstance().getGrupo(x).ordena();
			}
			RankingGeral.getInstance().ordena();
			
			if(this == (Tabela.getInstance().getRodada(Tabela.getInstance().getAll().size()-1))){
				Tabela.getInstance().finalizar(true); //se a rodada for a última, finaliza o torneio.
			}
		}
	}
	
	/**
	 * Método que atribui automaticamente através de condições, a quantidade de pontos correta, após o fim da rodada.
	 * @param jogo Jogo a ser comparado.
	 * @param torcedor Torcedor a receber os pontos.
	 */
	private void resultado(Jogo jogo, Torcedor torcedor){
		boolean timeCoracao = false;
		boolean placar = false;
		boolean resultado = false;
		Palpite palpite;
		for(int x=0 ; x<torcedor.getAllPalpite().size() ; x++){
			palpite = torcedor.getPalpite(x);
			
			if(jogo.getTimeA() == torcedor.getTime() || jogo.getTimeB() == torcedor.getTime()){
				timeCoracao = true;
			}
			else timeCoracao = false;
			
			if(jogo.getPlacar().getResultado() == palpite.getPlacar().getResultado()){
				resultado = true;
			}
			else resultado = false;
			
			if(jogo.getPlacar().getGolA() == palpite.getPlacar().getGolA() && jogo.getPlacar().getGolB() == palpite.getPlacar().getGolB()){
				placar = true;
			}
			else placar = false;
			
			//=====================================================================================================================
			if(palpite.getJogo() == jogo){
				if(timeCoracao == true  &&    placar == true){
					torcedor.resultado(Pontuacao.PLACAR_C);
				}
				else if(timeCoracao == true  && resultado == true){
					torcedor.resultado(Pontuacao.RESULT_C);
				}
				else if(timeCoracao == true  && resultado == false){
					torcedor.resultado(Pontuacao.ERRO_C);
				}
				else if(timeCoracao == false &&    placar == true){
					torcedor.resultado(Pontuacao.PLACAR);
				}
				else if(timeCoracao == false && resultado == true){
					torcedor.resultado(Pontuacao.RESULT);
				}
				else if(timeCoracao == false && resultado == false){
					torcedor.resultado(Pontuacao.ERRO);
				}
			}

		}
		
	}
	
	/**
	 * Verifica se a rodada pode receber um jogo desses 2 times.
	 * @param t1 Time 1 a ser comparado.
	 * @param t2 Time 2 a ser comparado.
	 * @return Se pode ou não receber um jogo entre os 2 times.
	 */
	public boolean livreParaTimes(Time t1, Time t2) {
		for (Jogo j : jogos) {
			if (j.getTimeA() == t1 || j.getTimeA() == t2 ||
				j.getTimeB() == t1 || j.getTimeB() == t2)
				return false;
		}

		return true;
	}
	
	/**
	 * Método imprime chamado pelo toString.
	 * @return uma String ordenada com os jogos.
	 */
	public String imprime(){
		String imprime = new String();
		for(int x=0;x<jogos.size();x++){
			imprime = imprime.concat(""+jogos.get(x).toString());
		}
		return imprime;
	}	
	/**
	 * Método toString para retornar uma String dos jogos da rodada.
	 */
	public String toString(){
		String imprime = imprime();
		return "Rodada: "+ ID + "\n" + imprime;
	}
}
