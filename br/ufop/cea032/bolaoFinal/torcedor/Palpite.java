package br.ufop.cea032.bolaoFinal.torcedor;

import java.io.Serializable;

import br.ufop.cea032.bolaoFinal.jogo.Jogo;
import br.ufop.cea032.bolaoFinal.jogo.Placar;

/**
 * Classe destinada a funcionar como "Palpite", permitindo aos Torcedores dar palpites sobre os jogos.
 * @author Maycon Junior <mayconjr_@live.com>. Carlos Eduardo <carlosdudujunior@hotmail.com>.
 *
 */
public class Palpite implements Serializable{

	private static final long serialVersionUID = -5636315898032628354L;

	private Placar placar;
	private Jogo jogo;
	
	/**
	 * Construtor do palpite.
	 * @param placar Placar do jogo (Qual acha que será o resultado).
	 * @param jogo Jogo ao qual o placar se refere.
	 */
	public Palpite(Placar placar, Jogo jogo){
		this.placar = placar;
		this.jogo = jogo;
		placar.resultado(placar);
	}
	
	/**
	 * Método para obter o placar do palpite.
	 * @return O Placar o palpite.
	 */
	public Placar getPlacar(){
		return placar;
	}
	
	/**
	 * Método para obter o jogo ao qual o palpite se refere.
	 * @return O jogo do palpite.
	 */
	public Jogo getJogo(){
		return jogo;
	}
	
	/**
	 * Método toString para imprimir o objeto.
	 */
	public String toString(){
		return "Palpite: " + jogo.getTimeA() + " " + placar.getGolA() + " x " + placar.getGolB() + " " + jogo.getTimeB() + "  |Rodada: " + jogo.getRodada().getID();
	}

}
