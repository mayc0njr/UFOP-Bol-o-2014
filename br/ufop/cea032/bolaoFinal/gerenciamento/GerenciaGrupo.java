package br.ufop.cea032.bolaoFinal.gerenciamento;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.ufop.cea032.bolaoFinal.lista.Grupo;
import br.ufop.cea032.bolaoFinal.lista.Torcedores;

/**
 * Classe destinada a funcionar como "Gerenciador de Grupo (individual)", manipulando a lista, adicionar/remover torcedores do grupo.
 * @author Maycon Junior <mayconjr_@live.com>. Carlos Eduardo <carlosdudujunior@hotmail.com>.
 *
 */
public class GerenciaGrupo {
	/** Scanner, para permitir entrada de dados pelo terminal. */
	private static Scanner in=new Scanner(System.in);
	
	/**
	 * Método principal, que gerenciará o grupo, fornecendo os dados necessários,
	 * Removendo/Adicionando torcedores, e mostrando um ranking dos torcedores do grupo.
	 * @param grupo Grupo que será manipulado pelo método.
	 */
	public static void gerenciador(Grupo grupo){
		int escolha=0, escolha2=0; //variáveis que serão utilizadas para escolha das opções do menu.
		while(true){ //Estrutura de repetição que só é quebrada quando a opção correta é escolhida no menu.
			System.out.println("\n\nGerenciador do Grupo \""+grupo.getTitulo()+"\"");
			System.out.println("O Que deseja fazer?");
			System.out.println("[1.]\tAdicionar torcedor ao Grupo.");
			System.out.println("[2.]\tRemover torcedor do Grupo.");
			System.out.println("[3.]\tVer Ranking do Grupo.");
			System.out.println("[4.]\tVer torcedores do Sistema.");
			System.out.println("[5.]\tVoltar");
			System.out.printf("Escolha:");
			
			try{ //Para evitar que exceções interrompam o fluxo do aplicativo.
				escolha = in.nextInt();
			}catch(InputMismatchException e){ //Exceção tratada para caracteres inválidos digitados no scanner.
				System.out.println("Digite um número!");
			}
			
			in.nextLine();
			switch(escolha){
				case 1:
					System.out.println("Escolha a posição do Torcedor no sistema.");
					try{
						escolha2 = in.nextInt();
						if(escolha2 >= Torcedores.getInstance().getAll().size()){ //Verifica se a posição escolhida, está na lista de torcedores.
							System.out.println("Não existe um torcedor na posição ("+escolha2+") da lista do sistema.");
						}
						else if(grupo.verSeTem(Torcedores.getInstance().getTorcedor(escolha2))){ //Veriica se o torcedor escolhido já está no grupo.
							System.out.println("O Torcedor escolhido já está neste grupo.");
						}
						else{ //Adiciona o torcedor escolhido no grupo.
							grupo.addTorcedor(Torcedores.getInstance().getTorcedor(escolha2));
							

							System.out.println(Torcedores.getInstance().getTorcedor(escolha2)+"\nTorcedor Adicionado!");
						}
					}catch(InputMismatchException e){ //Impede que uma exceção interrompa o fluxo caso sejam digitados caracteres que não são algarismos.
						System.out.println("Digite um número!");
					}
					
					in.nextLine();
					break;
					
				case 2:
					System.out.println("Digite a posiçao do torcedor a ser removido do grupo.");
					try{
						escolha2 = in.nextInt();
						if(escolha2 < grupo.getAll().size()){ //Verifica se existe um torcedor na posição escolhida.
							grupo.removeTorcedor(escolha2);
							System.out.println("Torcedor removido.");
						}
						else{
							System.out.println("Torcedor não removido.");
						}
					}catch(InputMismatchException e){ //Impede que ocorra uma exceção que pode parar a aplicação caso seja digitado caracteres impróprios no scanner.
						System.out.println("Digite um número!");
					}
					
					in.nextLine();
					break;
					
				case 3:
					System.out.println(grupo); //Imprime "grupo.toString" que retorna a lista alinhada de torcedores.
					break;
					
				case 4:
					System.out.println(Torcedores.getInstance()); //Imprime todos os torcedores do sistema.
					break;
					
				case 5: //Opção para voltar ao menu anterior.
					break;
					
				default: //Caso não seja escolhida uma opção válida.
					System.out.println("Escolha 1, 2, 3, 4, ou 5!");
				}
			if(escolha == 5) //Caso seja escolhido 5 (voltar ao menu anterior), é quebrado o ciclo de repetição.
				break;
		}
		
	}

}
