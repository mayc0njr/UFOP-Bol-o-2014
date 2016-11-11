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
	 * Gerenciador da rodada/Tabela, permite a manipulação individual de jogos, ou de rodadas, assim como visualizar o estado de cada rodada.
	 */
	public static void gerenciador(){
		int escolha=0, escolha2=0;
		Rodada rodada;
		
		while(Principal.getInstance().getTerminou() == false){
			System.out.println("Gerenciador da Tabela");
			System.out.println("O Que deseja fazer?");
			System.out.println("[1.]\tFinalizar um jogo. (Atribuir resultado aleatório)");
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
						System.out.println("De qual rodada é o jogo?");
						escolha2 = in.nextInt();
						
						if(escolha2 < Tabela.getInstance().getAll().size()){ //Verifica se a rodada escolhida está dentro da tabela.
							rodada = Tabela.getInstance().getRodada(escolha2);
							System.out.println("Qual jogo deseja finalizar?");
							in.nextLine(); //Recolhe o "/n" que sobrou do scanner anterior.
							escolha2 = in.nextInt();
							
							if(escolha2 < rodada.getAll().size()){ //Verifica se o jogo escolhido está dentro da rodada.
								try{
									rodada.getJogo(escolha2).resultadoAleatorio(); //Chama o método para dar um resultado ao jogo.
									System.out.println("Jogo Finalizado.");
									System.out.println(rodada.getJogo(escolha2));
								}catch(IllegalStateException e){ //Tratada exceção caso jogo já tenha sido finalizado.
									 System.out.println("Impossível finalizar o jogo, ele já tem resultado definido.");
								}catch(RodadaException e){ //Tratada exceção caso a rodada anterior ainda não tenha sido finalizada.
									System.out.println("Impossível finalizar o jogo, a rodada anterior ainda não foi terminada.");
								}
							}
							else{ //Caso o jogo escolhido, seja um número maior que a quantidade de jogos da rodada.
								System.out.println("Não existem (" + escolha2 + ") jogos!");
							}
							
						}
						else{ //Caso a rodada escolhida, seja um número maior que a quantidade de rodadas do campeonato.
							System.out.println("Não existem (" + escolha2 + ") rodadas!");
						}
						
						in.nextLine(); //Recolhe o "/n" que sobrou do scanner anterior.
						break;
						
					case 2:
						System.out.println("Qual rodada deseja finalizar?");
						escolha2 = in.nextInt();
						
						if(escolha2 < Tabela.getInstance().getAll().size()){ //Verifica se a rodada escolhida está dentro da tabela.
							rodada = Tabela.getInstance().getRodada(escolha2);
							try{
								GerenciaTabela.preencherJogos(rodada);
								System.out.println("Rodada Finalizada.");
							}catch(RodadaException e){
								System.out.println("Impossível finalizar a rodada, a rodada anterior ainda não foi terminada.");
							}catch(IllegalStateException e){
								System.out.println("Impossível finalizar a rodada, ela já foi finalizada");
							}
						}
						else{ //Caso a rodada escolhida, seja um número maior que a quantidade de rodadas do campeonato.
							System.out.println("Não existem (" + escolha2 + ") rodadas!");
						}
						break;
						
					case 3:
						System.out.println("Qual rodada deseja ver os jogos?");
						escolha2 = in.nextInt();
						if(escolha2 < Tabela.getInstance().getAll().size()){ //Verifica se a rodada escolhida está dentro da tabela.
							System.out.println(Tabela.getInstance().getRodada(escolha2)); //Imprime todos os jogos da rodada.
						}
						in.nextLine();
						break;
						
					case 4:
						System.out.println(Tabela.getInstance()); //Imprime todos os jogos da tabela.
						break;
						
					case 5: //Opção voltar.
						break;
						
					default:
						System.out.println("Escolha 1, 2, 3, 4 ou 5!");
				}
				if(escolha == 5){ //Se escolhe a opção voltar, encerra o loop;
					break;
				}
			}catch(java.util.InputMismatchException e){ //Exceção tratada caso seja digitado algum caractere inválido no scanner.
				System.out.println("Digite um número!");
				in.nextLine();
			}
		
		}
	}

}
