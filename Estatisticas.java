// Nós (Gabriela de Campos Trevisan, Paula Adriana Knob, Matheus Buttner Esteves), garantimos que:
//
// - Não utilizamos código fonte obtidos de outros estudantes,
// ou fonte não autorizada, seja modificado ou cópia literal.
// - Todo código usado em nosso trabalho é resultado do nosso
// trabalho original, ou foi derivado de um
// código publicado nos livros texto desta disciplina.
// - Temos total ciência das consequências em caso de violarmos estes termos.

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Estatisticas {
	String arquivo; // Caminho do arquivo CSV
	Hash epl; // Estatísticas do campeonato
	Hash eplPT; // Estatísticas apenas do primeiro tempo

	/*
	 * Construtor. Recebe um arquivo no formato .csv no mesmo padrão do arquivo
	 * encontrado em: http://www.football-data.co.uk/mmz4281/1314/E0.csv
	 */
	public Estatisticas(String csvFile, int numTimes) {
		this.arquivo = csvFile;
		this.epl = new Hash(numTimes);
		this.eplPT = new Hash(numTimes);
	}

	/*
	 * Carrega estatísticas a partir do arquivo no formato .csv no mesmo padrão
	 * do arquivo encontrado em:
	 * http://www.football-data.co.uk/mmz4281/1314/E0.csv
	 */

	public void carregaEstatisticas() {
		BufferedReader buffer = null;
		String separador = ",";
		String linha = "";

		try {
			FileReader file = new FileReader(this.getArquivo());
			buffer = new BufferedReader(file);
			buffer.readLine(); // Cabeçalho do arquivo é ignorado
			while ((linha = buffer.readLine()) != null) {
				// Cada linha representa as estatísticas de uma partida
				String[] estatistica = linha.split(separador);

				// Busca time de casa na hash
				Time timeCasa = epl.buscaTime(estatistica[2]);
				Time timeCasaPT = eplPT.buscaTime(estatistica[2]); // Primeiro
																	// tempo

				if (timeCasa == null) { // Se não encontrou insere
					timeCasa = new Time(estatistica[2]);
					epl.insere(timeCasa);
				}

				if (timeCasaPT == null) { // Se não encontrou insere
					timeCasaPT = new Time(estatistica[2]);
					eplPT.insere(timeCasaPT);
				}

				// Busca time visitante na hash
				Time timeVisitante = epl.buscaTime(estatistica[3]);
				Time timeVisitantePT = eplPT.buscaTime(estatistica[3]); // Primeiro
																		// tempo

				if (timeVisitante == null) { // Se não encontrou insere
					timeVisitante = new Time(estatistica[3]);
					epl.insere(timeVisitante);
				}

				if (timeVisitantePT == null) { // Se não encontrou insere
					timeVisitantePT = new Time(estatistica[3]);
					eplPT.insere(timeVisitantePT);
				}

				// Incrementa o número de partidas de cada um dos times
				timeCasa.setPartidasCasa(timeCasa.getPartidasCasa() + 1);
				timeVisitante.setPartidasFora(timeVisitante.getPartidasFora() + 1);
				timeCasaPT.setPartidasCasa(timeCasaPT.getPartidasCasa() + 1);
				timeVisitantePT.setPartidasFora(timeVisitantePT.getPartidasFora() + 1);

				// Transforma o número de gols do arquivo de String para inteiro
				int golsTimeCasa = Integer.parseInt(estatistica[4]);
				int golsTimeVisitante = Integer.parseInt(estatistica[5]);
				int golsTimeCasaPT = Integer.parseInt(estatistica[7]);
				int golsTimeVisitantePT = Integer.parseInt(estatistica[8]);

				// Incrementa o número de gols pro de cada um dos times
				timeCasa.setGolsProCasa(timeCasa.getGolsProCasa() + golsTimeCasa);
				timeVisitante.setGolsProFora(timeVisitante.getGolsProFora() + golsTimeVisitante);
				timeCasaPT.setGolsProCasa(timeCasaPT.getGolsProCasa() + golsTimeCasaPT);
				timeVisitantePT.setGolsProFora(timeVisitantePT.getGolsProFora() + golsTimeVisitantePT);

				// Incrementa o número de gols contra de cada um dos times
				timeCasa.setGolsContraCasa(timeCasa.getGolsContraCasa() + golsTimeVisitante);
				timeVisitante.setGolsContraFora(timeVisitante.getGolsContraFora() + golsTimeCasa);
				timeCasaPT.setGolsContraCasa(timeCasaPT.getGolsContraCasa() + golsTimeVisitantePT);
				timeVisitantePT.setGolsContraFora(timeVisitantePT.getGolsContraFora() + golsTimeCasaPT);

				// Transforma o número de gols do arquivo de String para inteiro
				int chutesGolTimeCasa = Integer.parseInt(estatistica[13]);
				int chutesGolTimeVisitante = Integer.parseInt(estatistica[14]);

				// Incrementa o número de gols contra de cada um dos times
				timeCasa.setChutesGolCasa(timeCasa.getChutesGolCasa() + chutesGolTimeCasa);
				timeVisitante.setChutesGolFora(timeVisitante.getChutesGolFora() + chutesGolTimeVisitante);

				// Incrementa o número de vitórias, derrotas e empates
				if (estatistica[6].equals("H")) { // Time de casa vencedor
					timeCasa.setVitoriasCasa(timeCasa.getVitoriasCasa() + 1);
					timeVisitante.setDerrotasFora(timeVisitante.getDerrotasFora() + 1);
				} else if (estatistica[6].equals("A")) { // Visitante vencedor
					timeCasa.setDerrotasCasa(timeCasa.getDerrotasCasa() + 1);
					timeVisitante.setVitoriasFora(timeVisitante.getVitoriasFora() + 1);
				} else { // Empate
					timeCasa.setEmpatesCasa(timeCasa.getEmpatesCasa() + 1);
					timeVisitante.setEmpatesFora(timeVisitante.getEmpatesFora() + 1);
				}

				// Incrementa o número de vitórias, derrotas e empates no
				// primeiro tempo
				if (estatistica[9].equals("H")) { // Time de casa vencedor
					timeCasaPT.setVitoriasCasa(timeCasaPT.getVitoriasCasa() + 1);
					timeVisitantePT.setDerrotasFora(timeVisitantePT.getDerrotasFora() + 1);
				} else if (estatistica[9].equals("A")) { // Visitante vencedor
					timeCasaPT.setDerrotasCasa(timeCasaPT.getDerrotasCasa() + 1);
					timeVisitantePT.setVitoriasFora(timeVisitantePT.getVitoriasFora() + 1);
				} else { // Empate
					timeCasaPT.setEmpatesCasa(timeCasaPT.getEmpatesCasa() + 1);
					timeVisitantePT.setEmpatesFora(timeVisitantePT.getEmpatesFora() + 1);
				}

				timeCasa.checkPontos();
				timeVisitante.checkPontos();
				timeCasaPT.checkPontos();
				timeVisitantePT.checkPontos();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				buffer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Gera um arquivo com o ranking por pontos do campeonato e retorna o
	 * conteúdo do arquivo
	 */
	public String geraRanking() {
		StringBuilder stringBuilder = new StringBuilder();
		// Ordenação do array de times por pontos
		Time[] timesOrdenados = HeapSort.heapSort(this.getTabelaHash().getTimes(), 'p');

		stringBuilder.append(getCabecalho());
		for (int i = 0; i < timesOrdenados.length; i++) {
			stringBuilder.append(timesOrdenados[i].getEstatisticas());
		}

		return this.geraArquivo("fixture.txt", stringBuilder.toString());
	}

	/*
	 * Gera um arquivo com o ranking por pontos do campeonato se apenas o
	 * primeiro tempo fosse considerado e retorna o conteúdo do arquivo
	 */

	public String geraRankingPrimeiroTempo() {
		StringBuilder stringBuilder = new StringBuilder();
		// Ordenação do array de times por pontos
		Time[] timesOrdenados = HeapSort.heapSort(this.getTabelaHashPT().getTimes(), 'p');

		stringBuilder.append(getCabecalho());
		for (int i = 0; i < timesOrdenados.length; i++) {
			stringBuilder.append(timesOrdenados[i].getEstatisticas());
		}

		return this.geraArquivo("fixture_ht.txt", stringBuilder.toString());
	}

	/*
	 * Gera um arquivo com o nome do clube e total de gols do clube que mais fez
	 * gols na temporada e retorna o conteúdo do arquivo
	 */
	public String melhorAtaque() {
		StringBuilder stringBuilder = new StringBuilder();
		HeapSort.maxHeap(this.getTabelaHash().getTimes(), 'g');

		stringBuilder.append(this.getTabelaHash().getTimes()[0].getNome() + ", "
				+ this.getTabelaHash().getTimes()[0].getTotalGolsPro() + "\r\n");

		return this.geraArquivo("top_scorer.txt", stringBuilder.toString());
	}

	/*
	 * Gera um arquivo com o nome do clube e total de derrotas do clube que
	 * menos perdeu na temporada e retorna o conteúdo do arquivo
	 */
	public String menosDerrotas() {

		StringBuilder stringBuilder = new StringBuilder();
		HeapSort.minHeap(this.getTabelaHash().getTimes());

		stringBuilder.append(this.getTabelaHash().getTimes()[0].getNome() + ", "
				+ this.getTabelaHash().getTimes()[0].getTotalDerrotas() + "\r\n");

		return this.geraArquivo("less_defeats.txt", stringBuilder.toString());
	}

	/*
	 * Gera um arquivo com o ranking dos clubes por melhor aproveitamento de
	 * gols/chutes e retorna o conteúdo do arquivo
	 */
	public String melhorAproveitamentoChutes() {
		StringBuilder stringBuilder = new StringBuilder();
		Time[] aproveitamento = HeapSort.heapSort(this.getTabelaHash().getTimes(), 'a');

		int p = 1;
		for (int j = aproveitamento.length - 1; j >= 0; j--) {
			stringBuilder.append(p + ". " + aproveitamento[j].getNome() + ", " + aproveitamento[j].getAproveitamento()
					+ " chutes a gol para cada gol\r\n");
			p++;
		}

		return this.geraArquivo("best_strikers.txt", stringBuilder.toString());

	}

	/* Retorna o caminho do arquivo de entrada */
	public String getArquivo() {
		return this.arquivo;
	}

	/* Retorna a tabela Hash criada */
	public Hash getTabelaHash() {
		return this.epl;
	}

	/*
	 * Retorna a tabela Hash criada se apenas os jogos do primeiro tempo fossem
	 * considerados
	 */
	public Hash getTabelaHashPT() {
		return this.eplPT;
	}

	/* Cabeçalho do ranking formatado */
	public static String getCabecalho() {
		StringBuilder stringBuilder = new StringBuilder();
		String formatHomeAwayTotal = "%35s %20s %20s";
		String formatHeader = "%25s %5s %20s %27s";

		stringBuilder.append(String.format(formatHomeAwayTotal, "- Home -", "- Away -", "- Total - \r\n"));
		stringBuilder.append(
				String.format(formatHeader, "Pld  ", "W  D  L   F:A", "W  D  L   F:A", "F:A    +/-    Pts \r\n"));
		return stringBuilder.toString();
	}

	/* Gera arquivo a partir de nome e conteúdo recebidos */
	private String geraArquivo(String nomeArquivo, String conteudo) {
		try {
			File file = new File(nomeArquivo);
			PrintWriter out = new PrintWriter(file);
			out.println(conteudo);
			out.flush();
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return conteudo;
	}

}
