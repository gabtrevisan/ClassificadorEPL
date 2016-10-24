// Nós (Gabriela de Campos Trevisan, Paula Adriana Knob, Matheus Buttner Esteves), garantimos que:
//
// - Não utilizamos código fonte obtidos de outros estudantes,
// ou fonte não autorizada, seja modificado ou cópia literal.
// - Todo código usado em nosso trabalho é resultado do nosso
// trabalho original, ou foi derivado de um
// código publicado nos livros texto desta disciplina.
// - Temos total ciência das consequências em caso de violarmos estes termos.

public class Time {

	private String nome;
	private int partidasCasa = 0;
	private int vitoriasCasa = 0;
	private int empatesCasa = 0;
	private int derrotasCasa = 0;
	private int golsProCasa = 0;
	private int golsContraCasa = 0;
	private int chutesGolCasa = 0;
	private int partidasFora = 0;
	private int vitoriasFora = 0;
	private int empatesFora = 0;
	private int derrotasFora = 0;
	private int golsProFora = 0;
	private int golsContraFora = 0;
	private int chutesGolFora = 0;
	private int pontos = 0;

	/*
	 * Construtor. Inicializa o objeto com o nome do time e todas as
	 * estatísticas zeradas
	 */
	public Time(String nome) {
		this.setNome(nome);
	}

	/* Retorna o nome do time */
	public String getNome() {
		return nome;
	}

	/* Altera o nome do time */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/* Retorna o número de partidas jogadas pelo time em casa (PLD) */
	public int getPartidasCasa() {
		return partidasCasa;
	}

	/* Altera o número de partidas jogadas pelo time em casa (PLD) */
	public void setPartidasCasa(int partidas) {
		this.partidasCasa = partidas;
	}

	/* Retorna o número de vitórias em casa (W) */
	public int getVitoriasCasa() {
		return vitoriasCasa;
	}

	/* Altera o número de vitórias em casa (W) */
	public void setVitoriasCasa(int vitorias) {
		this.vitoriasCasa = vitorias;
	}

	/* Retorna o número de empates em casa (D) */
	public int getEmpatesCasa() {
		return empatesCasa;
	}

	/* Altera o número de empates em casa (D) */
	public void setEmpatesCasa(int empates) {
		this.empatesCasa = empates;
	}

	/* Retorna o número de derrotas em casa (L) */
	public int getDerrotasCasa() {
		return derrotasCasa;
	}

	/* Altera o número de derrotas em casa (L) */
	public void setDerrotasCasa(int derrotas) {
		this.derrotasCasa = derrotas;
	}

	/* Retorna o número de gols pró em casa (F) */
	public int getGolsProCasa() {
		return golsProCasa;
	}

	/* Altera o número de gols pró em casa (F) */
	public void setGolsProCasa(int golsPro) {
		this.golsProCasa = golsPro;
	}

	/* Retorna o número de gols contra em casa (A) */
	public int getGolsContraCasa() {
		return golsContraCasa;
	}

	/* Altera o número de gols contra em casa (A) */
	public void setGolsContraCasa(int golsContra) {
		this.golsContraCasa = golsContra;
	}

	/* Retorna o número de chutes a gol em casa (HST) */
	public int getChutesGolCasa() {
		return chutesGolCasa;
	}

	/* Altera o número de chutes a gol em casa (HST) */
	public void setChutesGolCasa(int chutesGol) {
		this.chutesGolCasa = chutesGol;
	}

	/* Retorna o número de partidas jogadas pelo time fora de casa */
	public int getPartidasFora() {
		return partidasFora;
	}

	/* Altera o número de partidas jogadas pelo time fora de casa */
	public void setPartidasFora(int partidas) {
		this.partidasFora = partidas;
	}

	/* Retorna o número de partidas jogadas pelo time (PLD) */
	public int getPartidas() {
		return this.getPartidasCasa() + this.getPartidasFora();
	}

	/* Retorna o número de vitórias fora de casa(W) */
	public int getVitoriasFora() {
		return vitoriasFora;
	}

	/* Altera o número de vitórias fora de casa(W) */
	public void setVitoriasFora(int vitorias) {
		this.vitoriasFora = vitorias;
	}

	/* Retorna o número de empates fora de casa(D) */
	public int getEmpatesFora() {
		return empatesFora;
	}

	/* Altera o número de empates fora de casa(D) */
	public void setEmpatesFora(int empates) {
		this.empatesFora = empates;
	}

	/* Retorna o número de derrotas fora de casa(L) */
	public int getDerrotasFora() {
		return derrotasFora;
	}

	/* Altera o número de derrotas fora de casa(L) */
	public void setDerrotasFora(int derrotas) {
		this.derrotasFora = derrotas;
	}

	/* Retorna o número de gols pró fora de casa(F) */
	public int getGolsProFora() {
		return golsProFora;
	}

	/* Altera o número de gols pró fora de casa(F) */
	public void setGolsProFora(int golsPro) {
		this.golsProFora = golsPro;
	}

	/* Retorna o número de gols contra fora de casa(A) */
	public int getGolsContraFora() {
		return golsContraFora;
	}

	/* Altera o número de gols contra fora de casa(A) */
	public void setGolsContraFora(int golsContra) {
		this.golsContraFora = golsContra;
	}

	/* Retorna o número de chutes a gol fora de casa (AST) */
	public int getChutesGolFora() {
		return chutesGolFora;
	}

	/* Altera o número de chutes a gol fora de casa (AST) */
	public void setChutesGolFora(int chutesGol) {
		this.chutesGolFora = chutesGol;
	}

	/* Retorna a soma de gols pro dentro e fora de casa */
	public int getTotalGolsPro() {
		return this.getGolsProCasa() + this.getGolsProFora();
	}

	/* Retorna a soma de gols contra dentro e fora de casa */
	public int getTotalGolsContra() {
		return this.getGolsContraCasa() + this.getGolsContraFora();
	}

	/* Retorna a soma de chutes a gol dentro e fora de casa */
	public int getTotalChutesGol() {
		return this.getChutesGolCasa() + this.getChutesGolFora();
	}

	/* Retorna o aproveitamento de gols/chutes */
	public int getAproveitamento() {
		return this.getTotalChutesGol() / this.getTotalGolsPro();
	}

	/* Retorna a soma de derrotas dentro e fora de casa */
	public int getTotalDerrotas() {
		return this.getDerrotasCasa() + this.getDerrotasFora();
	}

	/* Retorna o saldo de gols */
	public int getSaldo() {
		return this.getTotalGolsPro() - this.getTotalGolsContra();
	}

	/*
	 * Retorna a soma dos pontos feitos pelo time. Cada vitória vale 3 pontos,
	 * cada empate 1 ponto e cada derrota 0 pontos.
	 */
	public int checkPontos() {
		int pontos = 0;
		pontos += this.getVitoriasCasa() * 3;
		pontos += this.getVitoriasFora() * 3;
		pontos += this.getEmpatesCasa();
		pontos += this.getEmpatesFora();
		setPontos(pontos);
		return pontos;
	}
	
	/* Retorna o número de pontos feitos pelo time */
	public int getPontos() {
		return this.pontos;
	}
	
	/* Altera o número de pontos feitos pelo time */
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	/* Visualização das estatísticas do time formatadas */
	public String getEstatisticas() {
		StringBuilder stringBuilder = new StringBuilder();
		String formatDynamic;
		
		formatDynamic = "%-20s";
		stringBuilder.append(String.format(formatDynamic, this.getNome()));

		formatDynamic = "%3d";
		stringBuilder.append(String.format(formatDynamic, this.getPartidas()));

		formatDynamic = "%4d";
		stringBuilder.append(String.format(formatDynamic, this.getVitoriasCasa()));
		
		formatDynamic = "%3d";
		stringBuilder.append(String.format(formatDynamic, this.getEmpatesCasa()));
		
		formatDynamic = "%3d";
		stringBuilder.append(String.format(formatDynamic, this.getDerrotasCasa()));
		
		formatDynamic = "%4d:%-2d";
		stringBuilder.append(String.format(formatDynamic, this.getGolsProCasa(), this.getGolsContraCasa()));
		
		formatDynamic = "%8d";
		stringBuilder.append(String.format(formatDynamic, this.getVitoriasFora()));
		
		formatDynamic = "%3d";
		stringBuilder.append(String.format(formatDynamic, this.getEmpatesFora()));
		
		formatDynamic = "%3d";
		stringBuilder.append(String.format(formatDynamic, this.getDerrotasFora()));
		
		formatDynamic = "%4d:%-2d";
		stringBuilder.append(String.format(formatDynamic, this.getGolsProFora(), this.getGolsContraFora()));
		
		formatDynamic = "%8d:%-3d";
		stringBuilder.append(String.format(formatDynamic, this.getTotalGolsPro(), this.getTotalGolsContra()));
		
		formatDynamic = "%5s";
		stringBuilder.append(String.format(formatDynamic, this.getSaldo() > 0 ? "+" + this.getSaldo() : this.getSaldo()));
		
		formatDynamic = "%6d";
		stringBuilder.append(String.format(formatDynamic, this.getPontos()));
		
		stringBuilder.append("\r\n");

		return stringBuilder.toString();
	}

}
