package br.ufop.cea032.bolaoFinal.jogo;

import java.io.Serializable;
import java.util.Random;

import br.ufop.cea032.bolaoFinal.exceptions.RodadaException;
import br.ufop.cea032.bolaoFinal.tabela.Rodada;
import br.ufop.cea032.bolaoFinal.tabela.Tabela;
import br.ufop.cea032.bolaoFinal.time.Time;


/**
 * Classe que representa um jogo, para ser usado no sistema.
 * @author Maycon Junior <mayconjr_@live.com>. Carlos Eduardo <carlosdudujunior@hotmail.com>.
 */
public class Jogo implements Serializable{

	private static final long serialVersionUID = -2178041975953124947L;
	
	/** Random para gerar placares aleatórios */
	private static Random rand = new Random();
	/** Primeiro time do jogo. */
	private Time timeA;
	/** Segundo time do jogo. */
	private Time timeB;
	/** resultado do jogo. */
	private Placar placar;
	/** define se o jogo já terminou. */
	private boolean finalized = false;
	/** Qual rodada o jogo pertence.*/
	private Rodada rodada;
	
	/**
	 * Construtor do objeto contendo os Times.
	 * @param timeA Primeiro time do jogo.
	 * @param timeB Segundo time do jogo.
	 */
	public Jogo(Time timeA,Time timeB){
		this.timeA = timeA;
		this.timeB = timeB;
		placar = new Placar();
	}
	
	/**
	 * Método para obter o primeiro time do jogo.
	 * @return o TimeA
	 */
	public Time getTimeA(){
		return timeA;
	}
	
	/**
	 * Método para obter o segundo time do jogo.
	 * @return o TimeB
	 */
	public Time getTimeB(){
		return timeB;
	}
	
	/**
	 * Método para obter o placar do jogo.
	 * @return o placar.
	 */
	public Placar getPlacar(){
		return placar;
	}
	
	/**
	 * Define para o jogo, qual rodada ele pertence.
	 * @param rodada à rodada à qual o jogo pertence.
	 */
	public void setRodada(Rodada rodada){
			this.rodada = rodada;		
	}
	
	/**
	 * Método para obter à qual rodada o jogo pertence.
	 * @return rodada à rodada à qual o jogo pertence.
	 */
	public Rodada getRodada(){
		return rodada;
	}
	
	/**
	 * Método para inserir o resultado do jogo. (Este não poderá ser alterado.)
	 * Caso o placar seja inserido, o boolean finalized é marcado como true, impedindo novas mudanças no placar.
	 * 
	 * @param placar2 O placar a ser inserido.
	 */
	public void resultado (Placar placar2) throws RodadaException{
		int z=0;
		if(rodada.getID() > 0 ){
			z = (rodada.getID() - 1); //Caso esta não seja a primeira rodada, verifica se a rodada anterior foi finalizada.
		}
		
		if(rodada.getID() == 0 || Tabela.getInstance().getRodada(z).getFinalized() == true){
			int y=0; //verifica se esta é a primeira rodada, ou se a rodada anterior já foi finalizada.
			
			if(finalized == false){ //Verifica se a rodada atual foi finalizada.
				finalized = this.placar.resultado(placar2);
				
				for(int x=0 ; x<rodada.getAll().size() ; x++){ //Verifica se todos os jogos da rodada já foram finalizados.
					if(rodada.getJogo(x).getFinalized() == true){ //Acrescentando 1 em "y" para cada jogo finalizado.
						y++;
					}
					
				}
				if(y == rodada.getAll().size()){ //Se a quantidade de jogos finalizados, for igual a quantidade de jogos da rodada,
					rodada.finalizar();			 //A rodada é finalizada automaticamente.
				}
			}
			else{
				throw new IllegalStateException("Impossível finalizar o jogo, ele já tem resultado definido."); //Caso o jogo já tenha resultado, lança esta exceção.
			}
			
		
		
		}
		else{
			throw new RodadaException("Impossível finalizar o jogo, a rodada anterior ainda não foi terminada."); //Caso a rodada anterior não esteja finalizada, lança esta exceção.
		}
		
	}
	
	/**
	 * Método para gerar um placar aleatório.
	 * O3 placar gerado tem um limite máximo de gols de 4 para cada lado.
	 * Caso o jogo já tenha encerrado, é retornado o placar atual do jogo.
	 */
	public void resultadoAleatorio() throws RodadaException{
			int x = rand.nextInt(5);
			int y = rand.nextInt(5);
			resultado(new Placar(x, y));
	}
	
	/**
	 * Método para saber se o jogo já foi jogado.
	 * @return Boolean finalized.
	 */
	public boolean getFinalized(){
		return finalized;
	}

	
	/**
	 * Método que retorna uma String do jogo com o placar.
	 * Se finalized for verdadeiro, o placar do jogo é incluindo na String.
	 * Caso contrário, é emitido espaços em branco na posição correspondente aos gols.
	 */
	public String toString(){
		if(finalized){
			return "" + timeA + placar + timeB+"\n";
			
		}
		return timeA + "|   x   |" + timeB+"\n";
	}

}
