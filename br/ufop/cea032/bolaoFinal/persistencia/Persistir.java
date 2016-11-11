package br.ufop.cea032.bolaoFinal.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import br.ufop.cea032.bolaoFinal.exceptions.CampeonatoException;
import br.ufop.cea032.bolaoFinal.lista.Grupos;
import br.ufop.cea032.bolaoFinal.lista.Times;
import br.ufop.cea032.bolaoFinal.lista.Torcedores;
import br.ufop.cea032.bolaoFinal.tabela.Principal;
import br.ufop.cea032.bolaoFinal.tabela.Tabela;

/**
 * Classe usada para persistência, ou seja, para ler, ou carregar arquivos.
 * O método "lerArquivos" só pode ser chamado caso o campeonato não tenha sido iniciado.
 * O método "lerArquivos" tambem não aparecerá no menu caso já hajam times adicionados (mesmo que o campeonato não tenha sido iniciado).
 * O método "escreveArquivos" só aparece no menu após o inicio do campeonato.
 * @author Maycon Junior <mayconjr_@live.com>. 
 *
 */
public class Persistir {
	/** String referente ao formato de arquivos utilizados para salvaguardar e carregar. */
	static private String formato = ".cfg"; //defina aqui o formato dos arquivos a serem salvos/carregados.
	/** Diretorio onde ficarão os arquivos utilizados na persistência. */
	static private String diretorio = "SavedFiles\\"; //Diretorio dos arquivos.
	/** Nome do arquivo (sem formato e sem diretorio) para ser carregado. */
	static private String arquivo = ""; //Arquivo a ser carregado/editado, não mexer aqui.
	
	//Caso queira alterar o diretorio do arquivo, alterar na String diretorio, não precisando alterar em qualquer outra parte do arquivo.
	//Caso queira alterar o formato do arquivo, alterar na String formato, não precisando alterar em qualquer outra parte do arquivo.
	
	/** Nome padrão para o arquivo com os Times. */
	static private String times = "Times"; //Arquivo com os dados sobre os times.
	/** Nome padrão para o arquivo com os Torcedores. */
	static private String torcedores = "Torcedores"; //Arquivo com os dados sobre os torcedores.
	/** Nome padrão para o arquivo com os Jogos. */
	static private String tabela = "Jogos"; //Arquivo com os dados sobre os torcedores.
	/** Nome padrão para o arquivo com os Grupos. */
	static private String grupos = "Grupos"; //Arquivo com os dados sobre os grupos.
	/** Nome padrão para o arquivo da classe Principal. */
	static private String principal = "Main"; //Arquivo com os dados da classe Principal.
	
//= area de testes.
	
	
	
//= Métodos para saber em qual arquivo salvar. =====================================================
	/**
	 * Método para procurar o arquivo com os dados dos Times, que será escrito.
	 * @return o arquivo a ser escrito.
	 * @throws FileNotFoundException Caso o arquivo não seja encontrado.
	 * @throws IOException Caso o arquivo não possa ser aberto ou fechado.
	 */
	private static FileOutputStream escreveTimes() throws FileNotFoundException, IOException{
		arquivo = diretorio + times; //Nao alterar aqui!
		arquivo+=formato; //Nao alterar aqui!
		FileOutputStream fos = new FileOutputStream(arquivo);
        return fos;
	}

	/**
	 * Método para procurar o arquivo com os dados dos Torcedores, que será escrito.
	 * @return o arquivo a ser escrito.
	 * @throws FileNotFoundException Caso o arquivo não seja encontrado.
	 * @throws IOException Caso o arquivo não possa ser aberto ou fechado.
	 */
	private static FileOutputStream escreveTorcedores() throws FileNotFoundException, IOException{
		arquivo = diretorio + torcedores; //Nao alterar aqui!
		arquivo+=formato; //Nao alterar aqui!
		FileOutputStream fos = new FileOutputStream(arquivo);
        return fos;
	}

	/**
	 * Método para procurar o arquivo com os dados dos Jogos, que será escrito.
	 * @return o arquivo a ser escrito.
	 * @throws FileNotFoundException Caso o arquivo não seja encontrado.
	 * @throws IOException Caso o arquivo não possa ser aberto ou fechado.
	 */
	private static FileOutputStream escreveTabela() throws FileNotFoundException, IOException{
		arquivo = diretorio + tabela; //Nao alterar aqui!
		arquivo+=formato; //Nao alterar aqui!
		FileOutputStream fos = new FileOutputStream(arquivo);
        return fos;
	}

	/**
	 * Método para procurar o arquivo com os dados dos Grupos, que será escrito.
	 * @return o arquivo a ser escrito.
	 * @throws FileNotFoundException Caso o arquivo não seja encontrado.
	 * @throws IOException Caso o arquivo não possa ser aberto ou fechado.
	 */
	private static FileOutputStream escreveGrupos() throws FileNotFoundException, IOException{
		arquivo = diretorio + grupos; //Nao alterar aqui!
		arquivo+=formato; //Nao alterar aqui!
		FileOutputStream fos = new FileOutputStream(arquivo);
        return fos;
	}

	/**
	 * Método para procurar o arquivo com os dados Principais, que será escrito.
	 * @return o arquivo a ser escrito.
	 * @throws FileNotFoundException Caso o arquivo não seja encontrado.
	 * @throws IOException Caso o arquivo não possa ser aberto ou fechado.
	 */
	private static FileOutputStream escrevePrincipal() throws FileNotFoundException, IOException{
		arquivo = diretorio + principal; //Nao alterar aqui!
		arquivo+=formato; //Nao alterar aqui!
		FileOutputStream fos = new FileOutputStream(arquivo);
        return fos;
	}
	
//= Método para retornar o ObjectOutputStream. =====================================================
	
	/**
	 * Método para abrir um arquivo a ser escrito.
	 * @param file Arquivo a ser aberto para ser escrito.
	 * @return Arquivo Aberto para ser escrito.
	 * @throws IOException Caso o arquivo não possa ser aberto ou fechado.
	 */
	private static ObjectOutputStream escreveArquivo(FileOutputStream file) throws IOException{
		return new ObjectOutputStream(file);
	}
	
//= Métodos para escrever em todos arquivos. (1 por 1). ============================================	
	
	/**
	 * Método que escreve em todos os arquivos, um de cada vez, os dados referente ao Bolão.
	 */
	public static void salvarArquivos(){
		try{
			ObjectOutputStream arquivoAberto;
			// Salvando times.
           FileOutputStream arquivo = escreveTimes(); //Salvar no arquivo de times.
            arquivoAberto = escreveArquivo(arquivo); //Abrindo o arquivo que quero salvar.
            arquivoAberto.writeObject(Times.getInstance()); //Escrevendo  o objeto times no arquivo.
            arquivoAberto.close(); //fechando arquivo.
            
            //Salvando torcedores.
            arquivo = escreveTorcedores();
            arquivoAberto = escreveArquivo(arquivo);
            arquivoAberto.writeObject(Torcedores.getInstance());
            arquivoAberto.close();
            
            //Salvando tabela.
            arquivo = escreveTabela();
            arquivoAberto = escreveArquivo(arquivo);
            arquivoAberto.writeObject(Tabela.getInstance());
            arquivoAberto.close();
            
            //Salvando grupos.
            arquivo = escreveGrupos();
            arquivoAberto = escreveArquivo(arquivo);
            arquivoAberto.writeObject(Grupos.getInstance());
            arquivoAberto.close();
            //Salvando principal.
            arquivo = escrevePrincipal();
            arquivoAberto = escreveArquivo(arquivo);
            arquivoAberto.writeObject(Principal.getInstance());
            arquivoAberto.close();
            
            
		}catch(IOException e){
			e.printStackTrace(); //Permite visualizar na tela (imprime) a pilha de métodos chamados para identificar onde está o "erro".
		}
	}
	
//= Métodos para saber qual arquivo carregar. ======================================================

	/**
	 * Método para procurar o arquivo com os dados dos Times, que será lido.
	 * @return o arquivo a ser lido.
	 * @throws FileNotFoundException Caso o arquivo não seja encontrado.
	 * @throws IOException Caso o arquivo não possa ser aberto ou fechado.
	 */
	private static FileInputStream lerTimes() throws FileNotFoundException, IOException{
		arquivo = diretorio + times; //Nao alterar aqui!
		arquivo+=formato;  //Nao alterar aqui!
		FileInputStream fis = new FileInputStream(arquivo); //define qual arquivo vai ser carregado.
        return fis;
	}
	
	/**
	 * Método para procurar o arquivo com os dados dos Torcedores, que será lido.
	 * @return o arquivo a ser lido.
	 * @throws FileNotFoundException Caso o arquivo não seja encontrado.
	 * @throws IOException Caso o arquivo não possa ser aberto ou fechado.
	 */
	private static FileInputStream lerTorcedores() throws FileNotFoundException, IOException{
		arquivo = diretorio + torcedores; //Nao alterar aqui!
		arquivo+=formato; //Nao alterar aqui!
		FileInputStream fis = new FileInputStream(arquivo);
        return fis;
	}


	/**
	 * Método para procurar o arquivo com os dados dos Jogos, que será lido.
	 * @return o arquivo a ser lido.
	 * @throws FileNotFoundException Caso o arquivo não seja encontrado.
	 * @throws IOException Caso o arquivo não possa ser aberto ou fechado.
	 */
	private static FileInputStream lerTabela() throws FileNotFoundException, IOException{
		arquivo = diretorio + tabela; //Nao alterar aqui!
		arquivo+=formato; //Nao alterar aqui!
		FileInputStream fis = new FileInputStream(arquivo);
        return fis;
	}

	/**
	 * Método para procurar o arquivo com os dados dos Grupos, que será lido.
	 * @return o arquivo a ser lido.
	 * @throws FileNotFoundException Caso o arquivo não seja encontrado.
	 * @throws IOException Caso o arquivo não possa ser aberto ou fechado.
	 */
	private static FileInputStream lerGrupos() throws FileNotFoundException, IOException{
		arquivo = diretorio + grupos; //Nao alterar aqui!
		arquivo+=formato; //Nao alterar aqui!
		FileInputStream fis = new FileInputStream(arquivo);
        return fis;
	}

	/**
	 * Método para procurar o arquivo com os dados Principais, que será lido.
	 * @return o arquivo a ser lido.
	 * @throws FileNotFoundException Caso o arquivo não seja encontrado.
	 * @throws IOException Caso o arquivo não possa ser aberto ou fechado.
	 */
	private static FileInputStream lerPrincipal() throws FileNotFoundException, IOException{
		arquivo = diretorio + principal; //Nao alterar aqui!
		arquivo+=formato; //Nao alterar aqui!
		FileInputStream fis = new FileInputStream(arquivo);
        return fis;
	}
//= Método para retornar o ObjectOutputStream. =====================================================
	
	/**
	 * Método para abrir um arquivo a ser lido.
	 * @param file Arquivo a ser aberto que deve ser lido.
	 * @return Arquivo Aberto para ser lido.
	 * @throws IOException Caso o arquivo não possa ser aberto ou fechado.
	 */
	private static ObjectInputStream lerArquivo(FileInputStream file) throws IOException{
		return new ObjectInputStream(file);
	}
//= Métodos para ler todos os arquivos (1 por 1). ==================================================	
		
	/**
	 * Método que lê todos os arquivos, um de cada vez, os dados referente ao Bolão.
	 */
	public static void lerArquivos(boolean comecou) throws CampeonatoException, IOException{
		ObjectInputStream arquivoAberto;
        FileInputStream arquivo;
		if(comecou == false){
	        try {
	        	// Carregando times.
	            arquivo = lerTimes(); //Carregar do arquivo de times.
	            arquivoAberto = lerArquivo(arquivo); //Abrindo o arquivo que quero carregar.
	            //Lendo o objeto times do arquivo.
	            Times timesLidos = (Times)arquivoAberto.readObject();
	            Times.carregar(timesLidos);
	             
				// Carregando torcedores.
	            arquivo = lerTorcedores(); //Carregar do arquivo de torcedores.
	            arquivoAberto = lerArquivo(arquivo); //Abrindo o arquivo que quero carregar.
	            //Lendo o objeto torcedores do arquivo.
	            Torcedores torcedoresLidos = (Torcedores)arquivoAberto.readObject();
	             
	            Torcedores.carregar(torcedoresLidos);
	             
				// Carregando tabela.
	            arquivo = lerTabela(); //Carregar do arquivo de tabela.
	            arquivoAberto = lerArquivo(arquivo); //Abrindo o arquivo que quero carregar.
	            //Lendo o objeto tabela do arquivo.
	            Tabela tabelaLida = (Tabela)arquivoAberto.readObject();
	            
	            Tabela.carregar(tabelaLida);
	            
				// Carregando grupos.
	            arquivo = lerGrupos(); //Carregar do arquivo de grupos.
	            arquivoAberto = lerArquivo(arquivo); //Abrindo o arquivo que quero carregar.
	            //Lendo o objeto tabela do arquivo.
	            Grupos gruposLidos = (Grupos)arquivoAberto.readObject();
	            
	            Grupos.carregar(gruposLidos);
	            
				// Carregando principal.
	            arquivo = lerPrincipal(); //Carregar do arquivo de principal.
	            arquivoAberto = lerArquivo(arquivo); //Abrindo o arquivo que quero carregar.
	            //Lendo o objeto tabela do arquivo.
	            Principal principalLido = (Principal)arquivoAberto.readObject();
	            
	            Principal.carregar(principalLido);
	            Principal.iniciar();
	        } catch (ClassNotFoundException e) {
	        }
		}
		else{
			throw new CampeonatoException("Impossível Carregar dados após o inicio do campeonato.");
		}
	}

}
