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
	
	/** Random para gerar placares aleat�rios */
	private static Random rand = new Random();
	/** Primeiro time do jogo. */
	private Time timeA;
	/** Segundo time do jogo. */
	private Time timeB;
	/** resultado do jogo. */
	private Placar placar;
	/** define se o jogo j� terminou. */
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
	 * M�todo para obter o primeiro time do jogo.
	 * @return o TimeA
	 */
	public Time getTimeA(){
		return timeA;
	}
	
	/**
	 * M�todo para obter o segundo time do jogo.
	 * @return o TimeB
	 */
	public Time getTimeB(){
		return timeB;
	}
	
	/**
	 * M�todo para obter o placar do jogo.
	 * @return o placar.
	 */
	public Placar getPlacar(){
		return placar;
	}
	
	/**
	 * Define para o jogo, qual rodada ele pertence.
	 * @param rodada � rodada � qual o jogo pertence.
	 */
	public void setRodada(Rodada rodada){
			this.rodada = rodada;		
	}
	
	/**
	 * M�todo para obter � qual rodada o jogo pertence.
	 * @return rodada � rodada � qual o jogo pertence.
	 */
	public Rodada getRodada(){
		return rodada;
	}
	
	/**
	 * M�todo para inserir o resultado do jogo. (Este n�o poder� ser alterado.)
	 * Caso o placar seja inserido, o boolean finalized � marcado como true, impedindo novas mudan�as no placar.
	 * 
	 * @param placar2 O placar a ser inserido.
	 */
	public void resultado (Placar placar2) throws RodadaException{
		int z=0;
		if(rodada.getID() > 0 ){
			z = (rodada.getID() - 1); //Caso esta n�o seja a primeira rodada, verifica se a rodada anterior foi finalizada.
		}
		
		if(rodada.getID() == 0 || Tabela.getInstance().getRodada(z).getFinalized() == true){
			int y=0; //verifica se esta � a primeira rodada, ou se a rodada anterior j� foi finalizada.
			
			if(finalized == false){ //Verifica se a rodada atual foi finalizada.
				finalized = this.placar.resultado(placar2);
				
				for(int x=0 ; x<rodada.getAll().size() ; x++){ //Verifica se todos os jogos da rodada j� foram finalizados.
					if(rodada.getJogo(x).getFinalized() == true){ //Acrescentando 1 em "y" para cada jogo finalizado.
						y++;
					}
					
				}
				if(y == rodada.getAll().size()){ //Se a quantidade de jogos finalizados, for igual a quantidade de jogos da rodada,
					rodada.finalizar();			 //A rodada � finalizada automaticamente.
				}
			}
			else{
				throw new IllegalStateException("Imposs�vel finalizar o jogo, ele j� tem resultado definido."); //Caso o jogo j� tenha resultado, lan�a esta exce��o.
			}
			
		
		
		}
		else{
			throw new RodadaException("Imposs�vel finalizar o jogo, a rodada anterior ainda n�o foi terminada."); //Caso a rodada anterior n�o esteja finalizada, lan�a esta exce��o.
		}
		
	}
	
	/**
	 * M�todo para gerar um placar aleat�rio.
	 * O3 placar gerado tem um limite m�ximo de gols de 4 para cada lado.
	 * Caso o jogo j� tenha encerrado, � retornado o placar atual do jogo.
	 */
	public void resultadoAleatorio() throws RodadaException{
			int x = rand.nextInt(5);
			int y = rand.nextInt(5);
			resultado(new Placar(x, y));
	}
	
	/**
	 * M�todo para saber se o jogo j� foi jogado.
	 * @return Boolean finalized.
	 */
	public boolean getFinalized(){
		return finalized;
	}

	
	/**
	 * M�todo que retorna uma String do jogo com o placar.
	 * Se finalized for verdadeiro, o placar do jogo � incluindo na String.
	 * Caso contr�rio, � emitido espa�os em branco na posi��o correspondente aos gols.
	 */
	public String toString(){
		if(finalized){
			return "" + timeA + placar + timeB+"\n";
			
		}
		return timeA + "|   x   |" + timeB+"\n";
	}

}
