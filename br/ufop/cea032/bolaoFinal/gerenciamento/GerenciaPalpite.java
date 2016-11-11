package br.ufop.cea032.bolaoFinal.gerenciamento;

import java.util.Scanner;

import br.ufop.cea032.bolaoFinal.exceptions.PalpiteException;
import br.ufop.cea032.bolaoFinal.jogo.Jogo;
import br.ufop.cea032.bolaoFinal.jogo.Placar;
import br.ufop.cea032.bolaoFinal.lista.Torcedores;
import br.ufop.cea032.bolaoFinal.tabela.Rodada;
import br.ufop.cea032.bolaoFinal.tabela.Tabela;
import br.ufop.cea032.bolaoFinal.torcedor.Palpite;
import br.ufop.cea032.bolaoFinal.torcedor.Torcedor;


public class GerenciaPalpite {
	/** Scanner para entrada de dados do console. */
	private static Scanner in=new Scanner(System.in);
	
	/**
	 * M�todo principal que gerenciar� os palpites, permitindo a adi��o, remo��o, e altera��o de palpites.
	 * Op��es extras como visualizar os palpites, e os torcedores tamb�m est�o presentes.
	 */
	public static void gerenciador(){
		int escolha=0, escolha2=0, escolha3 = 0, escolha4 = 0, escolha5=0; //Vari�veis para escolha de op��es.
		Rodada rodada;; //Rodada � qual o palpite ser� manipulado.
		Torcedor torcedor; //Torcedor que manipualar� o palpite.
		Placar placar; //Placar usado em algumas op��es do palpite.
		Jogo jogo; //Jogo usado no "addPalpite".
		
		// For para definir qual � a pr�xima rodada.
		// Verificando qual � a primeira rodada n�o finalizada.
		for(int x=0 ; x<Tabela.getInstance().getAll().size() ; x++){
			if(Tabela.getInstance().getRodada(x).getFinalized() == false){
				rodada = Tabela.getInstance().getRodada(x);
				break;
			}
		}

		System.out.println("Bem vindo ao gerenciador de palpites!");
		
		while(true){
			System.out.println("O Que deseja fazer?");
			System.out.println("[1.]\tAdicionar Palpite.");
			System.out.println("[2.]\tRemover Palpite.");
			System.out.println("[3.]\tModificar Palpite.");
			System.out.println("[4.]\tVer Palpites (por torcedor).");
			System.out.println("[5.]\tVer torcedores do Sistema.");
			System.out.println("[6.]\tVer lista de jogos de uma rodada.");
			System.out.println("[7.]\tVoltar");
			System.out.printf("Escolha:");
			
			try{
				escolha = in.nextInt();
	
				in.nextLine();
				switch(escolha){
					case 1:
						System.out.println("Qual torcedor � o dono do palpite?");
						
							escolha2 = in.nextInt();
							in.nextLine();
							
							//Verifica se a posi��o escolhida est� dentro da lista de torcedores.
							//Caso positivo, o objeto torcedor aponta para este torcedor para ser usado no no m�todo addPalpite mais tarde.
							if(escolha2 < Torcedores.getInstance().getAll().size()){
								torcedor = Torcedores.getInstance().getTorcedor(escolha2);
								System.out.println("Para qual Rodada � o Palpite?");
								escolha5 = in.nextInt();
								if(escolha5 < Tabela.getInstance().getAll().size()){
									rodada = Tabela.getInstance().getRodada(escolha5);
								
									System.out.println("Para qual Jogo � o Palpite?");
									escolha2 = in.nextInt();
									in.nextLine();
								
									//Verifica se a posi��o do jogo escolhida est� dentro da lista de jogos.
									//Caso positivo, o objeto jogo aponta para este jogo para ser usado no m�todo addPalpite mais tarde.
									if(escolha2 < rodada.getAll().size()){
										jogo = rodada.getJogo(escolha2);
										System.out.println("Qual a quantidade de gols do primeiro time?");
										escolha2 = in.nextInt();
										in.nextLine();
										System.out.println("Qual a quantidade de gols do segundo time?");
										escolha3 = in.nextInt();
										placar = new Placar(escolha2, escolha3);
										
										//Tenta adicionar o palpite, caso n�o seja poss�vel, imprime uma mensagem na tela
										// de acordo com as exce��es lan�adas pelo m�todo.
										// caso seja poss�vel, imprime uma mensagem dizendo que o metodo foi bem sucedido.
										try{
										torcedor.addPalpite(new Palpite(placar, jogo));
										System.out.println("Palpite Adicionado!");
										}catch(IllegalStateException e){
										System.out.println("Este jogo j� foi finalizado, o palpite n�o foi lan�ado.");
										}catch(PalpiteException e){
										System.out.println("Este torcedor j� possui um palpite para este jogo.");
									}
									}
									else{
									System.out.println("N�o existe um jogo na posi��o (" + escolha2 + ") !");
									}
								}
								else{
									System.out.println("N�o existe uma rodada na posi��o (" + escolha5 + ") !");
								} 
									
							}
							else{
								System.out.println("Nao existe um torcedor na posi��o (" + escolha2 + ") !");
							}
						
						in.nextLine();					
						break;
						
					case 2:
						System.out.println("Qual torcedor � o dono do palpite?");				
					
						escolha2 = in.nextInt();
						in.nextLine();
						
						//Verifica se a posi��o escolhida est� dentro da lista de torcedores.
						//Caso positivo, o objeto torcedor aponta para este torcedor para ser usado no no m�todo removePalpite mais tarde.
						if(escolha2 < Torcedores.getInstance().getAll().size()){
							torcedor = Torcedores.getInstance().getTorcedor(escolha2);
							System.out.println("Qual palpite deseja remover?");
							escolha2 = in.nextInt();
							in.nextLine();
								try{
									torcedor.removePalpite(escolha2);
									System.out.println("Palpite Removido!");
								}catch(PalpiteException e){
									System.out.println("N�o existe um palpite nessa posi��o.");
								}catch(IllegalStateException e){
									System.out.println("N�o � poss�vel remover um palpite cujo jogo j� tem resultado definido.");
								}
						}
						else{
							System.out.println("N�o existe um torcedor nessa posi��o!");
						}
						
						break;
						
					case 3:
						System.out.println("Qual torcedor � o dono do palpite?");				
					
						escolha2 = in.nextInt();
						in.nextLine();
						
						//Verifica se a posi��o escolhida est� dentro da lista de torcedores.
						//Caso positivo, o objeto torcedor aponta para este torcedor para ser usado no no m�todo setPalpite mais tarde.
						if(escolha2 < Torcedores.getInstance().getAll().size()){
							torcedor = Torcedores.getInstance().getTorcedor(escolha2);
							System.out.println("Qual palpite deseja modificar?");
							escolha2 = in.nextInt();
							in.nextLine();
							
							if(escolha2 < torcedor.getAllPalpite().size()){
								jogo = torcedor.getPalpite(escolha2).getJogo();
								System.out.println("Qual o resultado do novo palpite?\nGols do Time 1..");
								escolha3 = in.nextInt();
								in.nextLine();
								System.out.println("Gols do Time 2..");
								escolha4 = in.nextInt();
								
								if(escolha3 >= 0 && escolha4 >=0){
									placar = new Placar(escolha3, escolha4);
									
									try{
										torcedor.setPalpite(escolha2, new Palpite(placar, jogo));
										System.out.println("Palpite Alterado!");
									}catch(PalpiteException e){
										System.out.println("N�o existe um palpite nessa posi��o.");
									}catch(IllegalStateException e){
										System.out.println("N�o � poss�vel remover um palpite cujo jogo j� tem resultado definido.");
									}
								}
								else{
									System.out.println("Escolha n�mero de gols positivos.");
								}
								
							}
							else{
								System.out.println("N�o existe um palpite nessa posi��o!");
							}
							
						}
						else{
							System.out.println("N�o existe um torcedor nessa posi��o!");
						}
						
						
						break;
						
					case 4:
						System.out.println("Escolha um torcedor para visualizar a lista.");
							escolha2 = in.nextInt();
							//Verifica se a posi��o escolhida est� dentro da lista de torcedores.
							//Caso positivo, imprime a lista de palpites deste torcedor.						
							if(escolha2 < Torcedores.getInstance().getAll().size()){
								System.out.println(Torcedores.getInstance().getTorcedor(escolha2).ImprimePalpite());
							}
						
						in.nextLine();
						break;
						
						
					case 5:
						System.out.println(Torcedores.getInstance());
						
						break;
						
					case 6: //Imprime a lista de jogos de uma rodada espec�fica.
						System.out.println("Qual rodada deseja consultar os jogos?");
						escolha2 = in.nextInt();
						in.nextLine();
						if(escolha2 < Tabela.getInstance().getAll().size()){ //Verifica se a rodada escolhida, est� na tabela.
							rodada = Tabela.getInstance().getRodada(escolha2);
							System.out.println(rodada);
						}
						else{
							System.out.println("N�o existem (" + escolha2 + ") rodadas!");
						}
						break;
						
					case 7: //Op��o voltar.
						break;
						
					default: //Caso n�o seja escolhida op��o v�lida.
						System.out.println("Escolha um n�mero de 1 a 7!");
				}
				if(escolha == 7){ //Quebra o loop caso seja escolhido a op��o 7.
					break;
				}
			}catch(java.util.InputMismatchException e){ //Exce��o tratada para caracteres inv�lidos digitados no scanner.
				System.out.println("Digite um n�mero!");
				in.nextLine();
			}
		}
	
	}

}
