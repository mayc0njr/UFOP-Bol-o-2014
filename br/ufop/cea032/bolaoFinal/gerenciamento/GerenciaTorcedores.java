package br.ufop.cea032.bolaoFinal.gerenciamento;

import java.util.Scanner;

import br.ufop.cea032.bolaoFinal.exceptions.TimesException;
import br.ufop.cea032.bolaoFinal.lista.Times;
import br.ufop.cea032.bolaoFinal.lista.Torcedores;
import br.ufop.cea032.bolaoFinal.torcedor.Torcedor;

/**
 * Classe destinada a funcionar como "Gerenciador de torcedores", manipulando a lista, permitindo adicionar torcedores, remover, etc.
 * @author Maycon Junior <mayconjr_@live.com>. Carlos Eduardo <carlosdudujunior@hotmail.com>.
 *
 */
public class GerenciaTorcedores {
	/** Scanner para receber parâmetros do console. */
	private static Scanner in=new Scanner(System.in);
	/**
	 * Método gerenciador de Torcedores.
	 * @throws TimesException Exceção lançada se não houver times cadastrados.
	 */
	public static void gerenciador() throws TimesException{
		int escolha, escolha2;
		
		if(Times.getInstance().getAll().size() > 0){ //Verifica se há times no campeonato, para o torcedor escolher.
			System.out.println("Bem vindo ao gerenciador de torcedores!");
			while(true){ //Mantém um loop constante do menu até que seja chamado a opção para cancelar.
				System.out.println("O Que deseja fazer?");
				System.out.println("[1.]\tAdicionar torcedor.");
				System.out.println("[2.]\tRemover torcedor.");
				System.out.println("[3.]\tAlterar time do coração.");
				System.out.println("[4.]\tVer torcedores.");
				System.out.println("[5.]\tVoltar.");
				System.out.printf("Escolha:");
			
				try{
					escolha = in.nextInt();
					in.nextLine();
				}catch(java.util.InputMismatchException e){
					System.out.println("Digite um número!");
					in.nextLine();
					escolha = 0;
				}
				
				switch(escolha){
					case 1: //Adiciona um torcedor, com Nome, e Time do coração.
						System.out.println("Digite o nome do torcedor.");
						String nome = in.nextLine();
						System.out.println(Times.getInstance()); //Imprime a lista de times.
						System.out.println("Escolha o time do torcedor.");
						try{
							escolha = in.nextInt();
							in.nextLine();
							if(escolha < Times.getInstance().getAll().size()){
							Torcedores.getInstance().addTorcedor(new Torcedor(nome, Times.getInstance().getTime(escolha)));
							}
							else{
								System.out.println("Não existe um time na posição (" + escolha + ")!");
							}
						}catch(java.util.InputMismatchException e){
							System.out.println("Digite um número!");
							in.nextLine();
						}
						escolha = 0;
						
						break;
					case 2:
						System.out.println("Digite a posição do torcedor que deseja remover.");
						System.out.printf("Escolha: ");
						try{
							escolha = in.nextInt();
							if(escolha < Torcedores.getInstance().getAll().size()){
								Torcedores.getInstance().removeTorcedor(escolha);
								System.out.println("Torcedor removido.");
							}
							else{
								System.out.println("Não ha um torcedor na posição (" +escolha+") da lista.");
							}
						}catch(java.util.InputMismatchException e){
							System.out.println("Digite um número inteiro!");
							in.nextLine();
						}
						escolha = 0;
						
						break;
					case 3:
						System.out.println("Qual Torcedor deve ser alterado?");
						System.out.printf("Escolha: ");
						try{
							escolha = in.nextInt();
							if(escolha < Torcedores.getInstance().getAll().size()){ //Verifica se o torcedor escolhido está na lista de torcedores.
								System.out.println(Times.getInstance()); //Imprime lista de times.
								System.out.printf("Escolha o novo time do coração: ");
								try{
									escolha2 = in.nextInt();
									in.nextLine();
									if(escolha2 < Times.getInstance().getAll().size()){ //Verifica se o time escolhido está na lista de times,
										Torcedores.getInstance().getTorcedor(escolha).setTime(Times.getInstance().getTime(escolha2)); //Altera o time.
									}
									else{
										System.out.println("Não ha um time na posição (" +escolha2+") da lista.");
									}
								}catch(java.util.InputMismatchException e){
									System.out.println("Digite um número inteiro!");
								}
							}
							else{
								System.out.println("Não ha um torcedor na posição (" +escolha+") da lista.");
							}
						}catch(java.util.InputMismatchException e){
							
						}
						
						break;
					case 4:
						System.out.println(Torcedores.getInstance());
						break;
					case 5:
						break;
					default:
						System.out.println("Escolha 1, 2, 3, 4 ou 5!");
				}
				if(escolha == 5) break; //Se for escolhido 5 no menu, sai do loop.
			}
		}
		else throw new TimesException("Adicione Times antes de gerenciar os torcedores.");
	}
	
}
