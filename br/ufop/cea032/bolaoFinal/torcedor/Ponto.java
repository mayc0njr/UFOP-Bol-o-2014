package br.ufop.cea032.bolaoFinal.torcedor;

import java.io.Serializable;

/**
 * Classe para encapsular os pontos do sistema.
 * @author Maycon Junior <mayconjr_@live.com>. Carlos Eduardo <carlosdudujunior@hotmail.com>.
 *
 */
public class Ponto implements Pontos, Serializable{
	
	private static final long serialVersionUID = -5446218010407266170L;

	/** atributo �nico da classe, ponto. */
	private int ponto=0;
	
	/**
	 * Construtor sem modificador, que impede que o objeto seja instanciado por classes fora do pacote.
	 */
	Ponto(){
		
	}
	
	/**
	 * Passa um objeto do tipo pontuacao(uma constante enum), e calcula os pontos com base no par�metro passado, porem n�o permite que o usu�rio tenha pontos negativos.
	 */
	public void resultado(Pontuacao pontos){
		this.ponto+=pontos.getPontos();
		if(this.ponto < 0) this.ponto = 0;
	}
	

	@Override
	/**
	 * M�todo usado para obter a quantidade de pontos.
	 */
	public int getPontos(){
		return ponto;
	}
	
	

}
