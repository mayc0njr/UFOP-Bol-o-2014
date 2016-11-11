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
 * Classe destinada a funcionar como "Gerenciador de tabela", manipulando a lista, permitindo gerando rodadas automáticas, e manipulando-as.
 * @author Maycon Junior <mayconjr_@live.com>. Carlos Eduardo <carlosdudujunior@hotmail.com>.
 *
 */
public class GerenciaTabela {
	
	/**
	 * Método para criar automaticamente a tabela de acordo com os times.
	 * @throws TimesException Lançada caso o número de times seja ímpar, ou menor que 1.
	 * @throws CampeonatoException Lançada caso o campeonato já tenha sido iniciado.
	 */
	public static void gerador() throws TimesException, CampeonatoException{
		if(Principal.getInstance().getComecou() == false){ //Verifica se o Campeonato já começou
			if(Times.getInstance().getAll().size() % 2 == 0 && Times.getInstance().getAll().size() > 0){ //Verifica se o número de times é par.
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
				throw new TimesException("O Número de Times dever ser par e maior que 0."); //Exceção lançada caso a quantidade de times seja incorreta.
			}
				
		}
		else{
			throw new CampeonatoException("Impossível gerar rodadas após o início do campeonato."); //Exceção lançada caso tente gerar rodadas após o inicio do campeonato.
		}
	}
	
	/**
	 * Método que cria uma nova lista de jogos para ser adicionada à rodada seguindo o arranjo de times.
	 * Impede que as rodadas sejam geradas de forma que no final falte rodadas que possam receber os jogos.
	 * @return Uma Lista de "Jogo".
	 */
	public static List <Jogo> novaRodada() { //Cria uma rodada seguindo o arranjo de times.
		List<Jogo> rodada = new ArrayList<Jogo>(); //Instancia uma nova Lista de Jogos que irá receber os jogos gerados.
		List<Time> times = Times.getInstance().getAll(); //Recebe a lista de times para inserí-los nos jogos correspondentes.
		// Recebe dois times da lista de times, o primeiro, e o último.
		// Cria um novo jogo com esses times, e adiciona-o na rodada que será retornada.
		for (int i = 0; i < (times.size()/2) ; i++) {
			Time t1 = times.get(i);
			Time t2 = times.get(times.size() - i - 1);
			
			Jogo jogo = new Jogo(t1, t2);
			rodada.add(jogo);
		}

		return rodada;
	}

	/**
	 * Gera a próxima combinação da tabela, retirando o último valor, e adicionando o no começo (como uma fila invertida).
	 */
	static void proximaRodada() { //Define o novo arranjo de times para a próxima rodada.
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
	 * Gera resultados aleatórios para todos os jogos da rodada.
	 * @param rodada Rodada a ser manipulada.
	 * @throws RodadaException Lançada caso a rodada anterior não tenha sido finalizada.
	 */
	public static void preencherJogos(Rodada rodada) throws RodadaException{
		//Percorre todos os jogos da rodada,
		//Atribuindo resultados aleatórios aos jogos que nao estão finalizados.
		try{
			if(rodada.getFinalized() == false){ //Verifica se a rodada já foi finalizada.
					for(int y=0;y< rodada.getAll().size();y++){
						try{ //Encerra os jogos, com exceção dos que já foram finalizados.
							rodada.getJogo(y).resultadoAleatorio();
						}catch(IllegalStateException e){
						}
					}
			}
			else{ //Exceção lançada caso a rodada já tenha sido finalizada.
				throw new IllegalStateException("Impossível finalizar a rodada, ela já foi finalizada");
			}
		}catch(RodadaException e){ //Exceção lançada caso a rodada anterior ainda não tenha sido finalizada.
			throw new RodadaException("Impossível finalizar a rodada, a rodada anterior ainda não foi terminada.");
		}
	}
	

}
