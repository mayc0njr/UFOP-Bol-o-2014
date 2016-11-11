package br.ufop.cea032.bolaoFinal.gerenciamento;

import java.util.Scanner;

import br.ufop.cea032.bolaoFinal.exceptions.RodadaException;
import br.ufop.cea032.bolaoFinal.tabela.Principal;
import br.ufop.cea032.bolaoFinal.tabela.Rodada;
import br.ufop.cea032.bolaoFinal.tabela.Tabela;

/**
 * Classe destinada a funcionar como "Gerenciador de Rodadas e Jogos", manipulando a lista, definindo resultado dos jogos.
 * @author Maycon Junior <mayconjr_@live.com>. Carlos Eduardo <carlosdudujunior@hotmail.com>.
 *
 */
public class GerenciaRodada {
	/**Scanner para entrada de dados no console.*/
	private static Scanner in=new Scanner(System.in);
	
	/**
	 * Gerenciador da rodada/Tabela, permite a manipula��o individual de jogos, ou de rodadas, assim como visualizar o estado de cada rodada.
	 */
	public static void gerenciador(){
		int escolha=0, escolha2=0;
		Rodada rodada;
		
		while(Principal.getInstance().getTerminou() == false){
			System.out.println("Gerenciador da Tabela");
			System.out.println("O Que deseja fazer?");
			System.out.println("[1.]\tFinalizar um jogo. (Atribuir resultado aleat�rio)");
			System.out.println("[2.]\tFinalizar uma rodada.(idem item 1, para uma rodada completa)");
			System.out.println("[3.]\tVer jogos de uma rodada.");
			System.out.println("[4.]\tVer tabela completa.");
			System.out.println("[5.]\tVoltar.");
			System.out.printf("Escolha:");
			try{
				escolha = in.nextInt();
				in.nextLine();
				switch(escolha){
					case 1:
						System.out.println("De qual rodada � o jogo?");
						escolha2 = in.nextInt();
						
						if(escolha2 < Tabela.getInstance().getAll().size()){ //Verifica se a rodada escolhida est� dentro da tabela.
							rodada = Tabela.getInstance().getRodada(escolha2);
							System.out.println("Qual jogo deseja finalizar?");
							in.nextLine(); //Recolhe o "/n" que sobrou do scanner anterior.
							escolha2 = in.nextInt();
							
							if(escolha2 < rodada.getAll().size()){ //Verifica se o jogo escolhido est� dentro da rodada.
								try{
									rodada.getJogo(escolha2).resultadoAleatorio(); //Chama o m�todo para dar um resultado ao jogo.
									System.out.println("Jogo Finalizado.");
									System.out.println(rodada.getJogo(escolha2));
								}catch(IllegalStateException e){ //Tratada exce��o caso jogo j� tenha sido finalizado.
									 System.out.println("Imposs�vel finalizar o jogo, ele j� tem resultado definido.");
								}catch(RodadaException e){ //Tratada exce��o caso a rodada anterior ainda n�o tenha sido finalizada.
									System.out.println("Imposs�vel finalizar o jogo, a rodada anterior ainda n�o foi terminada.");
								}
							}
							else{ //Caso o jogo escolhido, seja um n�mero maior que a quantidade de jogos da rodada.
								System.out.println("N�o existem (" + escolha2 + ") jogos!");
							}
							
						}
						else{ //Caso a rodada escolhida, seja um n�mero maior que a quantidade de rodadas do campeonato.
							System.out.println("N�o existem (" + escolha2 + ") rodadas!");
						}
						
						in.nextLine(); //Recolhe o "/n" que sobrou do scanner anterior.
						break;
						
					case 2:
						System.out.println("Qual rodada deseja finalizar?");
						escolha2 = in.nextInt();
						
						if(escolha2 < Tabela.getInstance().getAll().size()){ //Verifica se a rodada escolhida est� dentro da tabela.
							rodada = Tabela.getInstance().getRodada(escolha2);
							try{
								GerenciaTabela.preencherJogos(rodada);
								System.out.println("Rodada Finalizada.");
							}catch(RodadaException e){
								System.out.println("Imposs�vel finalizar a rodada, a rodada anterior ainda n�o foi terminada.");
							}catch(IllegalStateException e){
								System.out.println("Imposs�vel finalizar a rodada, ela j� foi finalizada");
							}
						}
						else{ //Caso a rodada escolhida, seja um n�mero maior que a quantidade de rodadas do campeonato.
							System.out.println("N�o existem (" + escolha2 + ") rodadas!");
						}
						break;
						
					case 3:
						System.out.println("Qual rodada deseja ver os jogos?");
						escolha2 = in.nextInt();
						if(escolha2 < Tabela.getInstance().getAll().size()){ //Verifica se a rodada escolhida est� dentro da tabela.
							System.out.println(Tabela.getInstance().getRodada(escolha2)); //Imprime todos os jogos da rodada.
						}
						in.nextLine();
						break;
						
					case 4:
						System.out.println(Tabela.getInstance()); //Imprime todos os jogos da tabela.
						break;
						
					case 5: //Op��o voltar.
						break;
						
					default:
						System.out.println("Escolha 1, 2, 3, 4 ou 5!");
				}
				if(escolha == 5){ //Se escolhe a op��o voltar, encerra o loop;
					break;
				}
			}catch(java.util.InputMismatchException e){ //Exce��o tratada caso seja digitado algum caractere inv�lido no scanner.
				System.out.println("Digite um n�mero!");
				in.nextLine();
			}
		
		}
	}

}
