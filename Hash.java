// Nós (Gabriela de Campos Trevisan, Paula Adriana Knob, Matheus Buttner Esteves), garantimos que:
//
// - Não utilizamos código fonte obtidos de outros estudantes,
// ou fonte não autorizada, seja modificado ou cópia literal.
// - Todo código usado em nosso trabalho é resultado do nosso
// trabalho original, ou foi derivado de um
// código publicado nos livros texto desta disciplina.
// - Temos total ciência das consequências em caso de violarmos estes termos.

public class Hash {
	Time[] times;

	/*
	 * Construtor. Se não for passado nenhum parâmetro, a tabela hash terá por padrão
	 * 20 slots
	 */
	public Hash() {
		this.times = new Time[20];
	}

	/*
	 * Construtor. Número de slots n
	 */
	public Hash(int n) {
		this.times = new Time[n];
	}

	/* Retorna o número de slots da tabela hash */
	public int getTamanho() {
		return this.times.length;
	}

	/* Retorna o array de times */
	public Time[] getTimes() {
		return this.times;
	}

	/* Retorna o objeto Time armazenado no índice chave */
	public Time getTime(int chave) {
		return this.times[chave];
	}

	/* Retorna a hash para a String s */
	public int getHash(String s) {
		int hash;

		/*
		 * Obtemos o valor da hash passando a representação numérica da string
		 * para o método de multiplicação
		 */
		hash = this.metodoMultiplicacao(this.getChave(s));

		return hash;
	}

	/* Representação numérica da String s */
	private int getChave(String s) {
		int soma = 0;

		/*
		 * Soma o valor do código ASCII do caracter para representar o nome do
		 * time em um número inteiro
		 */
		for (int i = 0; i < s.length(); i++) {
			soma += s.charAt(i);
		}

		return soma;
	}

	/* Método de multiplicação Cormen 11.3.2 */
	private int metodoMultiplicacao(int chave) {
		double A = (Math.sqrt(5) - 1) / 2; // Bom valor de A segundo Knuth
		return (int) Math.floor(this.getTamanho() * this.getParteFracionaria(chave * A));
	}

	/* Retorna a parte fracionária de um número */
	private double getParteFracionaria(double num) {
		long parteInteira;
		double parteFracionaria;

		parteInteira = (long) num;
		parteFracionaria = num - parteInteira;
		return parteFracionaria;
	}

	/* Insere o time na tabela Hash */
	public void insere(Time time) {
		String nome = time.getNome();
		int chave = this.getHash(nome); // Chave para o nome do time
		if (this.times[chave] == null) { // Posição válida
			this.times[chave] = time;
		} else { // Posição ocupada
			/*
			 * Sondagem linear: Percorre a tabela hash a partir da posição seguinte a
			 * chave ocupada de maneira circular buscando uma posição livre
			 */
			int i = (chave + 1) % this.getTamanho();
			while (i != chave) {
				if (this.times[i] == null) {
					this.times[i] = time;
					break;
				}
				i = (i + 1) % this.getTamanho();
			}
		}
	}

	/*
	 * Retorna o objeto com informações do time na tabela hash a partir do seu nome, se
	 * houver. Se não for encontrado retorna null
	 */
	public Time buscaTime(String nome) {
		int chave = this.getHash(nome);
		if (this.times[chave] == null) { // Time não está na hash
			return null;
		}
		if (this.times[chave].getNome().equals(nome)) { // Time está na hash
			return this.times[chave];
		}
		/*
		 * Sondagem linear: Percorre a tabela hash a partir da posição seguinte a chave
		 * ocupada de maneira circular até encontrar o time ou garantir que o
		 * time não está na tabela hash (encontrando uma posição vazia ou voltando a
		 * posição inicial)
		 */
		int i = (chave + 1) % this.getTamanho();
		while (i != chave) {
			if (this.times[i] == null) {
				return null;
			}
			if (this.times[i].getNome().equals(nome)) {
				return this.times[i];
			}
			i = (i + 1) % this.getTamanho();
		}
		return null;
	}

	/* Visualização da tabela hash em memória */
	public String toString() {
		String s = "";
		for (int i = 0; i < times.length; i++) {
			String nome = "-";
			if (times[i] != null)
				nome = times[i].getNome();

			s += i + "[" + nome + "]\n";
		}
		return s;
	}

}
