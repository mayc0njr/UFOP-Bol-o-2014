package br.ufop.cea032.bolaoFinal.gerenciamento;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.ufop.cea032.bolaoFinal.lista.Grupo;
import br.ufop.cea032.bolaoFinal.lista.Grupos;

/**
 * Classe destinada a funcionar como "Gerenciador de Grupos", manipulando a lista, Adicionando, removendo, e modificando um grupo.
 * @author Maycon Junior <mayconjr_@live.com>. Carlos Eduardo <carlosdudujunior@hotmail.com>.
 *
 */
public class GerenciaGrupos {
	/**Scanner para entrada de dados no console.*/
	private static Scanner in=new Scanner(System.in);
	
	/**
	 * M�todo principal, que gerenciar� os grupos, fornecendo os dados necess�rios,
	 *  e recebendo os dados para "direcionar" para os m�todos que realizar�o a tarefa.
	 */
	public static void gerenciador(){
		int escolha=0, escolha2=0;
		String nome;
		System.out.println("Gerenciador de grupos.");
		while(true){
			System.out.println("O Que deseja fazer?");
			System.out.println("[1.]\tAdicionar Grupo.");
			System.out.println("[2.]\tRemover Grupo.");
			System.out.println("[3.]\tManipular Grupo.");
			System.out.println("[4.]\tVer Grupos.");
			System.out.println("[5.]\tVoltar");
			System.out.printf("Escolha:");
			try{
				escolha = in.nextInt();
			}catch(InputMismatchException e){
				System.out.println("Digite um n�mero!");
			}
			
			in.nextLine(); //Pega o "\n" que passou pelo scanner de inteiros.
			
			switch(escolha){
				case 1: //Adiciona um novo grupo no sistema.
					System.out.println("Digite o T�tulo do grupo:");
					nome = in.nextLine();
					Grupos.getInstance().addGrupo(new Grupo(nome));
					break;
					
				case 2: //Remove um grupo.
					System.out.println("Qual posi��o do grupo a ser removido?");
					try{
						escolha2=in.nextInt();
						if(escolha2 < Grupos.getInstance().getAll().size()){
							Grupos.getInstance().removeGrupo(escolha2);
							System.out.println("Grupo removido.");
						}
						else{ //Caso n�o possa ser removido o grupo.
							System.out.println("Grupo n�o removido.");
						}
					}catch(InputMismatchException e){ //Exce��o tratada para caracteres inv�lidos digitados no scanner.
						System.out.println("Escolha um n�mero inteiro.");
					}
					
					in.nextLine(); //Pega o "\n" que passou pelo scanner de inteiros.
					break;
					
				case 3:
					System.out.println("Qual grupo deseja manipular?");
					try{
						escolha2 = in.nextInt();
						if(escolha2 < Grupos.getInstance().getAll().size()){
							GerenciaGrupo.gerenciador(Grupos.getInstance().getGrupo(escolha2));
						}
						else{//Caso a lista de grupos seja menor que a posi��o escolhida.
							System.out.println("N�o existe um grupo na posi��o ("+escolha2+") da lista.");
						}
						
					}catch(InputMismatchException e){ //Exce��o tratada para caracteres inv�lidos digitados no scanner.
						System.out.println("Digite um numero inteiro!");
					}
					
					in.nextLine(); //Pega o "\n" que passou pelo scanner de inteiros.
					break;
					
				case 4:
					System.out.println(Grupos.getInstance().imprimeTitulos()); //Imprime o t�tulo dos grupos.
					break;
					
				case 5: //Op��o para voltar ao menu anterior.
					break;
					
				default:
					System.out.println("Escolha 1, 2, 3, 4, ou 5!");
				}
			if(escolha==5){ //Caso seja escolhido 5 (voltar ao menu anterior), � quebrado o ciclo de repeti��o.
				break;
			}
			
		}
	}

}
