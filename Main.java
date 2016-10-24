// Nós (Gabriela de Campos Trevisan, Paula Adriana Knob, Matheus Buttner Esteves), garantimos que:
//
// - Não utilizamos código fonte obtidos de outros estudantes,
// ou fonte não autorizada, seja modificado ou cópia literal.
// - Todo código usado em nosso trabalho é resultado do nosso
// trabalho original, ou foi derivado de um
// código publicado nos livros texto desta disciplina.
// - Temos total ciência das consequências em caso de violarmos estes termos.

public class Main {

	public static void main(String[] args) {

		/*
		 * Passa o caminho do arquivo .csv do formato Complexo e o número de
		 * times participantes da temporada para a classe Estatisticas carregar
		 * as informações
		 */
		Estatisticas estatisticas = new Estatisticas("E0.csv", 20);
		estatisticas.carregaEstatisticas();

		Hash h = estatisticas.getTabelaHash();
		Time[] times = h.getTimes();

		/*
		 * Busca times na hash a partir do seu nome e imprime suas
		 * estatítisticas na tela
		 */
		for (int i = 0; i < times.length; i++) {
			System.out.println("\nBusca pelo nome do time " + times[i].getNome() + ":");
			Time time = h.buscaTime(times[i].getNome());
			System.out.print(Estatisticas.getCabecalho());
			System.out.println(time.getEstatisticas());
		}

		/*
		 * Imprime na tela as estatísticas geradas também em arquivo
		 */

		System.out.println("\nTimes ordenados pelo total de pontos:\n");
		System.out.println(estatisticas.geraRanking());

		System.out.println("\nTimes ordenados pelo total de pontos se apenas o primeiro tempo fosse considerado:\n");
		System.out.println(estatisticas.geraRankingPrimeiroTempo());

		System.out.println("\nClube que mais fez gols na temporada:\n");
		System.out.println(estatisticas.melhorAtaque());

		System.out.println("\nClube que menos perdeu na temporada:\n");
		System.out.println(estatisticas.menosDerrotas());

		System.out.println("\nRanking por aproveitamento de gols/chutes:\n");
		System.out.println(estatisticas.melhorAproveitamentoChutes());
	}

}
