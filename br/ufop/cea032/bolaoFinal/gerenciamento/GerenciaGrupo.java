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
	 * M�todo principal, que gerenciar� o grupo, fornecendo os dados necess�rios,
	 * Removendo/Adicionando torcedores, e mostrando um ranking dos torcedores do grupo.
	 * @param grupo Grupo que ser� manipulado pelo m�todo.
	 */
	public static void gerenciador(Grupo grupo){
		int escolha=0, escolha2=0; //vari�veis que ser�o utilizadas para escolha das op��es do menu.
		while(true){ //Estrutura de repeti��o que s� � quebrada quando a op��o correta � escolhida no menu.
			System.out.println("\n\nGerenciador do Grupo \""+grupo.getTitulo()+"\"");
			System.out.println("O Que deseja fazer?");
			System.out.println("[1.]\tAdicionar torcedor ao Grupo.");
			System.out.println("[2.]\tRemover torcedor do Grupo.");
			System.out.println("[3.]\tVer Ranking do Grupo.");
			System.out.println("[4.]\tVer torcedores do Sistema.");
			System.out.println("[5.]\tVoltar");
			System.out.printf("Escolha:");
			
			try{ //Para evitar que exce��es interrompam o fluxo do aplicativo.
				escolha = in.nextInt();
			}catch(InputMismatchException e){ //Exce��o tratada para caracteres inv�lidos digitados no scanner.
				System.out.println("Digite um n�mero!");
			}
			
			in.nextLine();
			switch(escolha){
				case 1:
					System.out.println("Escolha a posi��o do Torcedor no sistema.");
					try{
						escolha2 = in.nextInt();
						if(escolha2 >= Torcedores.getInstance().getAll().size()){ //Verifica se a posi��o escolhida, est� na lista de torcedores.
							System.out.println("N�o existe um torcedor na posi��o ("+escolha2+") da lista do sistema.");
						}
						else if(grupo.verSeTem(Torcedores.getInstance().getTorcedor(escolha2))){ //Veriica se o torcedor escolhido j� est� no grupo.
							System.out.println("O Torcedor escolhido j� est� neste grupo.");
						}
						else{ //Adiciona o torcedor escolhido no grupo.
							grupo.addTorcedor(Torcedores.getInstance().getTorcedor(escolha2));
							

							System.out.println(Torcedores.getInstance().getTorcedor(escolha2)+"\nTorcedor Adicionado!");
						}
					}catch(InputMismatchException e){ //Impede que uma exce��o interrompa o fluxo caso sejam digitados caracteres que n�o s�o algarismos.
						System.out.println("Digite um n�mero!");
					}
					
					in.nextLine();
					break;
					
				case 2:
					System.out.println("Digite a posi�ao do torcedor a ser removido do grupo.");
					try{
						escolha2 = in.nextInt();
						if(escolha2 < grupo.getAll().size()){ //Verifica se existe um torcedor na posi��o escolhida.
							grupo.removeTorcedor(escolha2);
							System.out.println("Torcedor removido.");
						}
						else{
							System.out.println("Torcedor n�o removido.");
						}
					}catch(InputMismatchException e){ //Impede que ocorra uma exce��o que pode parar a aplica��o caso seja digitado caracteres impr�prios no scanner.
						System.out.println("Digite um n�mero!");
					}
					
					in.nextLine();
					break;
					
				case 3:
					System.out.println(grupo); //Imprime "grupo.toString" que retorna a lista alinhada de torcedores.
					break;
					
				case 4:
					System.out.println(Torcedores.getInstance()); //Imprime todos os torcedores do sistema.
					break;
					
				case 5: //Op��o para voltar ao menu anterior.
					break;
					
				default: //Caso n�o seja escolhida uma op��o v�lida.
					System.out.println("Escolha 1, 2, 3, 4, ou 5!");
				}
			if(escolha == 5) //Caso seja escolhido 5 (voltar ao menu anterior), � quebrado o ciclo de repeti��o.
				break;
		}
		
	}

}
