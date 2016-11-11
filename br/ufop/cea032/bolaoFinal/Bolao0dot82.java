package br.ufop.cea032.bolaoFinal;

import br.ufop.cea032.bolaoFinal.gerenciamento.GerenciaPrincipal;
import br.ufop.cea032.bolaoFinal.lista.Times;
import br.ufop.cea032.bolaoFinal.time.Time;

/**
 * Classe inicial, que chamar� o menu, para dar inicio � aplica��o.
 * Times podem ser inseridos diretamente no c�digo, anulando assim o gerenciador de Times, caso seja poss�vel iniciar o campeonato com a quantidade inserida.
 * @author Maycon Junior <mayconjr_@live.com>. Carlos Eduardo <carlosdudujunior@hotmail.com>.
 *
 */
public class Bolao0dot82 {
	
	/**
	 * M�todo principal, onde o aplicativo se inicia.
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length > 0){
			for(int x=0; x < args.length ; x++){
				Times.getInstance().add(new Time(args[x]));
			}
		}
		
		/*==============================================================//
		 * Aten��o, para poder carregar arquivos, 						*
		 * inicie o aplicativo sem times adicionados. 					*
		 //=============================================================*/
		
//		Times.getInstance().add(new Time("Time A"));
//		Times.getInstance().add(new Time("Time B"));
//		Times.getInstance().add(new Time("Time C"));
//		Times.getInstance().add(new Time("Time D"));
//		Times.getInstance().add(new Time("Time E"));
//		Times.getInstance().add(new Time("Time F"));
//		Times.getInstance().add(new Time("Time G"));
//		Times.getInstance().add(new Time("Time H"));
//		Times.getInstance().add(new Time("Time I"));
//		Times.getInstance().add(new Time("Time J"));
//		Times.getInstance().add(new Time("Time K"));
//		Times.getInstance().add(new Time("Time L"));
//		Times.getInstance().add(new Time("Time M"));
//		Times.getInstance().add(new Time("Time N"));
//		Times.getInstance().add(new Time("Time O"));
//		Times.getInstance().add(new Time("Time P"));
//		Times.getInstance().add(new Time("Time Q"));
//		Times.getInstance().add(new Time("Time R"));
//		Times.getInstance().add(new Time("Time S"));
//		Times.getInstance().add(new Time("Time T"));

		GerenciaPrincipal.menuInicial();
		
	}
}
