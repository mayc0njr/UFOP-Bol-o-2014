package br.ufop.cea032.bolaoFinal.gerenciamento;

import java.util.ArrayList;
import java.util.List;

import br.ufop.cea032.bolaoFinal.exceptions.CampeonatoException;
import br.ufop.cea032.bolaoFinal.exceptions.RodadaException;
import br.ufop.cea032.bolaoFinal.exceptions.TimesException;
import br.ufop.cea032.bolaoFinal.jogo.Jogo;
import br.ufop.cea032.bolaoFinal.lista.Times;
import br.ufop.cea032.bolaoFinal.tabela.Principal;
import br.ufop.cea032.bolaoFinal.tabela.Rodada;
import br.ufop.cea032.bolaoFinal.tabela.Tabela;
import br.ufop.cea032.bolaoFinal.time.Time;

/**
 * Classe destinada a funcionar como "Gerenciador de tabela", manipulando a lista, permitindo gerando rodadas autom�ticas, e manipulando-as.
 * @author Maycon Junior <mayconjr_@live.com>. Carlos Eduardo <carlosdudujunior@hotmail.com>.
 *
 */
public class GerenciaTabela {
	
	/**
	 * M�todo para criar automaticamente a tabela de acordo com os times.
	 * @throws TimesException Lan�ada caso o n�mero de times seja �mpar, ou menor que 1.
	 * @throws CampeonatoException Lan�ada caso o campeonato j� tenha sido iniciado.
	 */
	public static void gerador() throws TimesException, CampeonatoException{
		if(Principal.getInstance().getComecou() == false){ //Verifica se o Campeonato j� come�ou
			if(Times.getInstance().getAll().size() % 2 == 0 && Times.getInstance().getAll().size() > 0){ //Verifica se o n�mero de times � par.
				Tabela tabela = Tabela.getInstance(); //Instancia uma tabela vazia.
				int w, x, y; //Variaveis utilizadas nos "for".	
				for(w=1;w<Times.getInstance().getAll().size();w++){//Cria rodadas de acordo com a quantidade de times.
					tabela.addRodada(new Rodada());
				}
				for(x=0 ; x<(Tabela.getInstance().getAll().size()) ; x++){ //Percorre Lista de rodadas
					for(y=0;y<Times.getInstance().getAll().size()/2;y++){ //Percorre a quantidade de jogos por rodada
						List<Jogo> jogos = novaRodada();
						if(tabela.getRodada(x).livreParaTimes(jogos.get(y).getTimeA(), jogos.get(y).getTimeB())){
							Tabela.getInstance().getRodada(x).addJogo(jogos.get(y)); //Adiciona os jogos da rodada gerada na rodada.
						}
					}
					proximaRodada();
				}
				for(x=0 ; x<(Tabela.getInstance().getAll().size()) ; x++){ //Percorre Lista de rodadas
					for(y=0 ; y < Tabela.getInstance().getRodada(x).getAll().size() ; y++){ //Percorre Lista de jogos da rodada.
					Tabela.getInstance().getRodada(x).getJogo(y).setRodada(Tabela.getInstance().getRodada(x)); //Atribui "rodadas" aos jogos, permitindo a ele saber a qual rodada pertence.
					}
				}
			Principal.iniciar();
			}	
			else{
				throw new TimesException("O N�mero de Times dever ser par e maior que 0."); //Exce��o lan�ada caso a quantidade de times seja incorreta.
			}
				
		}
		else{
			throw new CampeonatoException("Imposs�vel gerar rodadas ap�s o in�cio do campeonato."); //Exce��o lan�ada caso tente gerar rodadas ap�s o inicio do campeonato.
		}
	}
	
	/**
	 * M�todo que cria uma nova lista de jogos para ser adicionada � rodada seguindo o arranjo de times.
	 * Impede que as rodadas sejam geradas de forma que no final falte rodadas que possam receber os jogos.
	 * @return Uma Lista de "Jogo".
	 */
	public static List <Jogo> novaRodada() { //Cria uma rodada seguindo o arranjo de times.
		List<Jogo> rodada = new ArrayList<Jogo>(); //Instancia uma nova Lista de Jogos que ir� receber os jogos gerados.
		List<Time> times = Times.getInstance().getAll(); //Recebe a lista de times para inser�-los nos jogos correspondentes.
		// Recebe dois times da lista de times, o primeiro, e o �ltimo.
		// Cria um novo jogo com esses times, e adiciona-o na rodada que ser� retornada.
		for (int i = 0; i < (times.size()/2) ; i++) {
			Time t1 = times.get(i);
			Time t2 = times.get(times.size() - i - 1);
			
			Jogo jogo = new Jogo(t1, t2);
			rodada.add(jogo);
		}

		return rodada;
	}

	/**
	 * Gera a pr�xima combina��o da tabela, retirando o �ltimo valor, e adicionando o no come�o (como uma fila invertida).
	 */
	static void proximaRodada() { //Define o novo arranjo de times para a pr�xima rodada.
		// Obter o ultimo.
		Time last = Times.getInstance().getTime(Times.getInstance().getAll().size()-1);
		
		// Trocar os pares de elementos um a um.
		// Colocando o ultimo valor no indice 1,
		// o valor do indice 3 no 2, do 4 no 3 e 
		// assim por diante.
		for (int i = 1; i < Times.getInstance().getAll().size(); i++) {
			Time current = Times.getInstance().getTime(i);
			Times.getInstance().setTime(i, last);
			last = current;
		}
	}
	
	/**
	 * Gera resultados aleat�rios para todos os jogos da rodada.
	 * @param rodada Rodada a ser manipulada.
	 * @throws RodadaException Lan�ada caso a rodada anterior n�o tenha sido finalizada.
	 */
	public static void preencherJogos(Rodada rodada) throws RodadaException{
		//Percorre todos os jogos da rodada,
		//Atribuindo resultados aleat�rios aos jogos que nao est�o finalizados.
		try{
			if(rodada.getFinalized() == false){ //Verifica se a rodada j� foi finalizada.
					for(int y=0;y< rodada.getAll().size();y++){
						try{ //Encerra os jogos, com exce��o dos que j� foram finalizados.
							rodada.getJogo(y).resultadoAleatorio();
						}catch(IllegalStateException e){
						}
					}
			}
			else{ //Exce��o lan�ada caso a rodada j� tenha sido finalizada.
				throw new IllegalStateException("Imposs�vel finalizar a rodada, ela j� foi finalizada");
			}
		}catch(RodadaException e){ //Exce��o lan�ada caso a rodada anterior ainda n�o tenha sido finalizada.
			throw new RodadaException("Imposs�vel finalizar a rodada, a rodada anterior ainda n�o foi terminada.");
		}
	}
	

}
