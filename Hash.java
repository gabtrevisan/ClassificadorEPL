// N�s (Gabriela de Campos Trevisan, Paula Adriana Knob, Matheus Buttner Esteves), garantimos que:
//
// - N�o utilizamos c�digo fonte obtidos de outros estudantes,
// ou fonte n�o autorizada, seja modificado ou c�pia literal.
// - Todo c�digo usado em nosso trabalho � resultado do nosso
// trabalho original, ou foi derivado de um
// c�digo publicado nos livros texto desta disciplina.
// - Temos total ci�ncia das consequ�ncias em caso de violarmos estes termos.

public class Hash {
	Time[] times;

	/*
	 * Construtor. Se n�o for passado nenhum par�metro, a tabela hash ter� por padr�o
	 * 20 slots
	 */
	public Hash() {
		this.times = new Time[20];
	}

	/*
	 * Construtor. N�mero de slots n
	 */
	public Hash(int n) {
		this.times = new Time[n];
	}

	/* Retorna o n�mero de slots da tabela hash */
	public int getTamanho() {
		return this.times.length;
	}

	/* Retorna o array de times */
	public Time[] getTimes() {
		return this.times;
	}

	/* Retorna o objeto Time armazenado no �ndice chave */
	public Time getTime(int chave) {
		return this.times[chave];
	}

	/* Retorna a hash para a String s */
	public int getHash(String s) {
		int hash;

		/*
		 * Obtemos o valor da hash passando a representa��o num�rica da string
		 * para o m�todo de multiplica��o
		 */
		hash = this.metodoMultiplicacao(this.getChave(s));

		return hash;
	}

	/* Representa��o num�rica da String s */
	private int getChave(String s) {
		int soma = 0;

		/*
		 * Soma o valor do c�digo ASCII do caracter para representar o nome do
		 * time em um n�mero inteiro
		 */
		for (int i = 0; i < s.length(); i++) {
			soma += s.charAt(i);
		}

		return soma;
	}

	/* M�todo de multiplica��o Cormen 11.3.2 */
	private int metodoMultiplicacao(int chave) {
		double A = (Math.sqrt(5) - 1) / 2; // Bom valor de A segundo Knuth
		return (int) Math.floor(this.getTamanho() * this.getParteFracionaria(chave * A));
	}

	/* Retorna a parte fracion�ria de um n�mero */
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
		if (this.times[chave] == null) { // Posi��o v�lida
			this.times[chave] = time;
		} else { // Posi��o ocupada
			/*
			 * Sondagem linear: Percorre a tabela hash a partir da posi��o seguinte a
			 * chave ocupada de maneira circular buscando uma posi��o livre
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
	 * Retorna o objeto com informa��es do time na tabela hash a partir do seu nome, se
	 * houver. Se n�o for encontrado retorna null
	 */
	public Time buscaTime(String nome) {
		int chave = this.getHash(nome);
		if (this.times[chave] == null) { // Time n�o est� na hash
			return null;
		}
		if (this.times[chave].getNome().equals(nome)) { // Time est� na hash
			return this.times[chave];
		}
		/*
		 * Sondagem linear: Percorre a tabela hash a partir da posi��o seguinte a chave
		 * ocupada de maneira circular at� encontrar o time ou garantir que o
		 * time n�o est� na tabela hash (encontrando uma posi��o vazia ou voltando a
		 * posi��o inicial)
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

	/* Visualiza��o da tabela hash em mem�ria */
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
