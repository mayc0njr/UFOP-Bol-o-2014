package br.ufop.cea032.bolaoFinal.gerenciamento;

import java.io.IOException;
import java.util.Scanner;

import br.ufop.cea032.bolaoFinal.exceptions.CampeonatoException;
import br.ufop.cea032.bolaoFinal.exceptions.TimesException;
import br.ufop.cea032.bolaoFinal.lista.Grupos;
import br.ufop.cea032.bolaoFinal.lista.RankingGeral;
import br.ufop.cea032.bolaoFinal.lista.Times;
import br.ufop.cea032.bolaoFinal.persistencia.Persistir;
import br.ufop.cea032.bolaoFinal.tabela.Principal;
import br.ufop.cea032.bolaoFinal.tabela.Tabela;

/**
 * Classe destinada a funcionar como "Gerenciador Principal", apresentando o menu inicial, e direcionando aos "sub-menus" de acordo com a escolha do usu�rio.
 * @author Maycon Junior <mayconjr_@live.com>. Carlos Eduardo <carlosdudujunior@hotmail.com>.
 *
 */
public class GerenciaPrincipal {
	/**Scanner para entrada de dados no console.*/
	private static Scanner in=new Scanner(System.in);
	
	/**
	 * Menu inicial do aplicativo, exibindo as informa��es iniciais, fornecendo as op��es para se dirigir aos sub-menus.
	 * Inicia o campeonato automaticamente caso ainda n�o tenha sido feito.
	 * Algumas op��es s�o restritas, caso a quantidade de times seja inv�lida, ou o campeonato ainda n�o tenha sido iniciado.
	 * � automaticamente finalizado ap�s o t�rmino do campeonato.
	 */
	public static void menuInicial(){ //M�todo "menu" inicial, que ser� o primeiro menu exibido na tela, afim de redirecionar para o menu adequado ap�s a escolha dos usu�rios.
		int escolha = 0;
		
		for(int x=0;x<25;x++){
			System.out.println();
		}
		
		try{ //Chama o m�todo gerador de tabela.
			GerenciaTabela.gerador();
		}catch(TimesException e){
		}catch(CampeonatoException e){
		}
		
		try{
			try{
				
				if(Times.getInstance().getAll().size() == 0 || (Times.getInstance().getAll().size() % 2) != 0 ){ //Verifica se a quantidade de times � correta
					System.out.println("A Quantidade de times � incorreta para gerar um campeonato automaticamente.\n");
				}
				
				while( Principal.getInstance().getComecou() == false){
					//Menu caso o campeonato n�o tenha sido iniciado.
					//Este menu s� � iniciado, caso n�o tenha sido adicionado nenhum time (ou uma quantidade �mpar de times) em tempo de compila��o.
					//Apenas neste caso, � permitido o acesso ao gerenciador de times.
					//Caso haja times suficientes para iniciar o campeonato, este menu n�o � acessado.
					//Este menu tambem n�o pode ser acessado ap�s iniciar o campeonato manualmente (Gerar Rodadas).

					System.out.println("\n\tMenu pr�-campeonato.");
					System.out.println("[1.]\tGerenciador de Times.");
					System.out.println("[2.]\tGerar Rodadas.");
					System.out.println("[3.]\tCarregar Dados.");
					System.out.printf("Escolha:");
					escolha = in.nextInt();
					in.nextLine();
					switch(escolha){
						case 1:
							GerenciaTimes.gerenciador(Principal.getInstance().getComecou()); //Chama o gerenciador de times.
							break;
							
						case 2:
							if(Times.getInstance().getAll().size() > 0 && Times.getInstance().getAll().size() % 2 == 0){ //Verifica se o numero de times � par e maior que 0.
								GerenciaTabela.gerador(); //Chama o Gerador de Rodadas.
								System.out.println("Gerou rodadas com sucesso!");
							}
							else{
								System.out.println("O N�mero de Times dever ser par e maior que 0.");
							}
							break;
							
						case 3:
							try{
								Persistir.lerArquivos(Principal.getInstance().getComecou());
							}catch(CampeonatoException e){
								System.out.println("Imposs�vel carregar dados ap�s o inicio do campeonato.");
							}catch(IOException e){
								System.out.println("Arquivos n�o encontrados, ou n�o podem ser abertos no momento.");
							}
							break;
						default:
					}
				}
			}catch(CampeonatoException e){
				System.out.println("Campeonato j� iniciado.");
			}catch(TimesException e){
				System.out.println("Imposs�vel gerenciar o campeonato com " + Times.getInstance().getAll().size() + " times.");
			}
			
			while(Principal.getInstance().getComecou() == true && Principal.getInstance().getTerminou() == false){
				//Menu inicial, � exibido automaticamente ap�s o inicio do campeonato.
				//Fornece as op��es principais, e o direcionameto para os sub-menus.
				//Caso o campeonato seja finalizado, ele � automaticamente encerrado.
				//Ap�s seu encerramento o menuFinal � exibido, permitindo apenas impress�o dos dados do torneio.
				
				try{
					System.out.println();
					System.out.println("Menu Principal");
					System.out.println("\n\tGerenciamento/Manipula��o de dados:");
					System.out.println("[1.]\tMenu Torcedores.");
					System.out.println("[2.]\tMenu Grupos.");
					System.out.println("[3.]\tMenu Palpites.");
					System.out.println("[4.]\tMenu Rodadas.");
					System.out.println("\n\tAcesso r�pido:");
					System.out.println("[5.]\tVer Ranking Geral de Torcedores.");
					System.out.println("[6.]\tVer Tabela de jogos.");
					System.out.println("[7.]\tVer todos os times.");
					System.out.println("[8.]\tSalvar Dados.");
					System.out.printf("Escolha:");
					escolha = in.nextInt();
					in.nextLine();
					switch(escolha){
						case 1: //Chama o gerenciador de torcedores.
							GerenciaTorcedores.gerenciador();
							break;
							
						case 2: //Chama o gerenciador de grupos, que d� acesso a um gerenciador geral, e a um gerenciador individual por grupo.
							GerenciaGrupos.gerenciador();
							break;
							
						case 3: //Chama o gerenciador de palpites
							GerenciaPalpite.gerenciador();
							break;
							
						case 4: //Chama o gerenciador de rodadas, que d� acesso a uma rodada por completo, assim como para jogos individualmente.
							GerenciaRodada.gerenciador();
							break;
							
						case 5:
							System.out.println(RankingGeral.getInstance());
							System.out.println("Pressione Enter para voltar ao menu.");
							in.nextLine();
							break;
							
						case 6:
							System.out.println(Tabela.getInstance());
							System.out.println("Pressione Enter para voltar ao menu.");
							in.nextLine();
							break;
							
						case 7:
							System.out.println(Times.getInstance());
							System.out.println("Pressione Enter para voltar ao menu.");
							in.nextLine();
							break;

						case 8:
								Persistir.salvarArquivos();
							break;
							
						default:
							System.out.println("Escolha 1, 2, 3, 4, 5, 6, 7 ou 8.");
					}
					
				}catch(java.util.InputMismatchException e){ //Captura a exce��o lan�ada caso caracteres inv�lidos sejam digitados no scanner.
					in.nextLine();
					System.out.println("Digite um numero!");
				}catch(TimesException e){
					System.out.println("Quantidade de times inv�lida.");
					break;
				}
			}
			System.out.println("O Campeonato Terminou!");
			while(Principal.getInstance().getTerminou() == true){
				//Menu inicial, � exibido automaticamente ap�s o inicio do campeonato.
				//Fornece as op��es principais, e o direcionameto para os sub-menus.
				//Caso o campeonato seja finalizado, ele � automaticamente encerrado.
				//Ap�s seu encerramento o menuFinal � exibido, permitindo apenas impress�o dos dados do torneio.
				
				try{
					System.out.println();
					System.out.println("Menu Final");
					System.out.println("[1.]\tVer Ranking Geral de Torcedores.");
					System.out.println("[2.]\tVer Tabela de jogos.");
					System.out.println("[3.]\tVer todos os times.");
					System.out.println("[4.]\tVer Grupos.");
					System.out.println("[5.]\tVer Ranking por grupo.");
					System.out.println("[6.]\tVer Palpites por torcedor.");
					System.out.printf("Escolha:");
					escolha = in.nextInt();
					in.nextLine();
					switch(escolha){
						case 1:
							System.out.println(RankingGeral.getInstance());
							System.out.println("Pressione uma Tecla para voltar ao menu.");
							in.nextLine();
							break;
							
						case 2:
							System.out.println(Tabela.getInstance());
							System.out.println("Pressione uma Tecla para voltar ao menu.");
							in.nextLine();
							break;
							
						case 3:
							System.out.println(Times.getInstance());
							System.out.println("Pressione uma Tecla para voltar ao menu.");
							in.nextLine();
							break;

						case 4:
							System.out.println(Grupos.getInstance().imprimeTitulos());
							System.out.println("Pressione uma Tecla para voltar ao menu.");
							in.nextLine();
							break;

						case 5:
							System.out.println("Qual grupo deseja visualizar?");
							escolha = in.nextInt();
							
							if(escolha < Grupos.getInstance().getAll().size()){
								System.out.println(Grupos.getInstance().getGrupo(escolha));
							}
							else{
								System.out.println("N�o existem (" + escolha + ") grupos!");
							}
							break;

						case 6:
							break;
							
							
						default:
							System.out.println("Escolha 1, 2, 3, 4, 5, 6, ou 7.");
					}
					
				}catch(java.util.InputMismatchException e){ //Captura a exce��o lan�ada caso caracteres inv�lidos sejam digitados no scanner.
					in.nextLine();
					System.out.println("Digite um numero!");
				}
				
			}
		}catch(java.util.InputMismatchException e){ //Captura a exce��o lan�ada caso caracteres inv�lidos sejam digitados no scanner.
			in.nextLine();
			System.out.println("Digite um numero!");
		}
	}

}
