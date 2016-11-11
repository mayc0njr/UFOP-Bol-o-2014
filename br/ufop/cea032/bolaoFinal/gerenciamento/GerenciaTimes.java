package br.ufop.cea032.bolaoFinal.gerenciamento;
//Classe desativada.
import java.util.Scanner;

import br.ufop.cea032.bolaoFinal.exceptions.CampeonatoException;
import br.ufop.cea032.bolaoFinal.lista.Times;
import br.ufop.cea032.bolaoFinal.time.Time;

/**
 * Classe destinada a funcionar como "Gerenciador de times", manipulando a lista, e permitindo aos torcedores escolher seu time.
 * @author Maycon Junior <mayconjr_@live.com>. Carlos Eduardo <carlosdudujunior@hotmail.com>.
 *
 */
public class GerenciaTimes {
	/**
	 * Scanner para receber dados teclado
	 */
	private static Scanner in=new Scanner(System.in);
	
	/**
	 * 
	 * @param comecou Se o campeonato come�ou ou n�o.
	 * @throws CampeonatoException Se o campeonato j� tiver sido iniciado, essa � exce��o � lan�ada.
	 */
	public static void gerenciador(boolean comecou) throws CampeonatoException{
		String nome;
		int escolha=0, escolha2=0;
		

		
		if(comecou == false){
			System.out.println("Bem vindo ao gerenciador de times!");
				while(true){
					if(Times.getInstance().getAll().size() == 0) System.out.println("\nN�o h� times no campeonato.");
					System.out.println("O Que deseja fazer?");
					System.out.printf("[1.]\tAdicionar time.\n[2.]\tRemover Time.\n[3.]\tVer Times.\n[4.]\tVoltar\nEscolha: ");
					
					try{ //Try/Catch para evitar erros no scanner.
						escolha=in.nextInt();
					}
					catch(java.util.InputMismatchException e){
						System.out.println("Digite um n�mero inteiro!");
						escolha=0;
					}
//					//Fim do Try Catch
					in.nextLine();

					switch(escolha){
						case 1:
							System.out.println("Digite o nome do time.");
							nome = in.nextLine();
							Times.getInstance().add(new Time(nome));
							break;
							
						case 2:
							System.out.println("Digite a posi��o do time que deseja remover.");
							try{ //Try/Catch para evitar erros no scanner.
								escolha2=in.nextInt();
								if(escolha2 < Times.getInstance().getAll().size()){ //Se a posi��o escolhida estiver dentro da Lista de Times.
									Times.getInstance().remove(escolha2);
									System.out.println("Time removido.");
								}
								else{//Se a posi��o escolhida n�o estiver dentro da Lista de Times.
									System.out.println("Time n�o removido");
								}
							}
							catch(java.util.InputMismatchException e){
								System.out.println("Digite um n�mero inteiro!");
								break;
							}
							
							//Impress�o do resultado.
							break;
							
						case 3: //Imprime Lista de Times.
							
							System.out.println(Times.getInstance());
							break;
							
						case 4://Op��o voltar.
							break;
						default:
							if(escolha < 1 || escolha > 4){
								System.out.println("Escolha 1, 2, 3 ou 4!");
								escolha = 0;
							}
						}
					if(escolha == 4){ //Caso escolha a op��o 4, quebra o loop e volta ao menu anterior.
						break;
					}
				}
//				//Fim While(true)
				
			}
		else throw new CampeonatoException("Campeonato j� iniciado."); //Exce��o Lan�ada caso o campeonato j� tenha sido iniciado.
	}

}
