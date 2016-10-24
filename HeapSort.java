// Nós (Gabriela de Campos Trevisan, Paula Adriana Knob, Matheus Buttner Esteves), garantimos que:
//
// - Não utilizamos código fonte obtidos de outros estudantes,
// ou fonte não autorizada, seja modificado ou cópia literal.
// - Todo código usado em nosso trabalho é resultado do nosso
// trabalho original, ou foi derivado de um
// código publicado nos livros texto desta disciplina.
// - Temos total ciência das consequências em caso de violarmos estes termos.

public class HeapSort {

	/*
	 * EXPLICAÇÃO:
	 * 
	 * int posInicial = posição no array onde começará a verificação;
	 * 
	 * 2*posInicial + 1 e 2*posInicial + 2 = filhos da posição no array;
	 * 
	 * (posInicial-1)/2 = posição do pai dessa pos no array;
	 * 
	 * comparador = atributo por qual deve ser feita a comparação de valores (g:
	 * total de gols feitos na temporada, p: total de pontos, a: aproveitamento
	 * de gols/clutes)
	 * 
	 */
	public static void maxHeap(Time[] array, char comparador) {

		int posInicial = array.length / 2;
		boolean trocou = false;
		int esquerda = -1;
		int direita = -1;

		while (posInicial >= 0) {

			if ((2 * posInicial + 1) <= (array.length - 1)) {
				if (comparador == 'g')
					esquerda = array[2 * posInicial + 1].getTotalGolsPro();
				else if (comparador == 'a')
					esquerda = array[2 * posInicial + 1].getAproveitamento();
				else
					esquerda = array[2 * posInicial + 1].getPontos();
			}

			if ((2 * posInicial + 2) <= (array.length - 1)) {
				if (comparador == 'g')
					direita = array[2 * posInicial + 2].getTotalGolsPro();
				else if (comparador == 'a')
					direita = array[2 * posInicial + 2].getAproveitamento();
				else
					direita = array[2 * posInicial + 2].getPontos();
			}

			int valor;
			if (comparador == 'g')
				valor = array[posInicial].getTotalGolsPro();
			else if (comparador == 'a')
				valor = array[posInicial].getAproveitamento();
			else
				valor = array[posInicial].getPontos();

			if (esquerda > direita) {

				if (esquerda > valor) {
					troca(array, posInicial, 2 * posInicial + 1);
					trocou = true;
				}

			} else {

				if (direita > valor) {
					troca(array, posInicial, 2 * posInicial + 2);
					trocou = true;
				}

			}

			posInicial--;
		}

		if (trocou) {
			maxHeap(array, comparador);
		}
	}

	/*
	 * Ordena o array por ordem decrescente e retorna o array ordenado
	 */
	public static Time[] heapSort(Time[] times, char atributoOrdenacao) {

		Time[] array = new Time[times.length];
		System.arraycopy(times, 0, array, 0, array.length);

		maxHeap(array, atributoOrdenacao);
		Time[] arrayOrdenado = new Time[array.length];
		int cont = 0;

		while (array.length > 1) {

			arrayOrdenado[cont] = array[0];
			array[0] = array[array.length - 1];

			Time[] novoArray = new Time[array.length - 1];
			for (int i = 0; i < array.length - 1; i++) {
				novoArray[i] = array[i];
			}

			array = novoArray;
			cont++;
			maxHeap(array, atributoOrdenacao);

		}

		arrayOrdenado[arrayOrdenado.length - 1] = array[0];
		return arrayOrdenado;

	}

	/* MinHeap calculada pelo número de derrotas */
	public static void minHeap(Time[] array) {
		int posInicial = array.length / 2;
		boolean trocou = false;
		int esquerda = 99;
		int direita = 99;

		while (posInicial >= 0) {
			if ((2 * posInicial + 1) <= (array.length - 1)) {
				esquerda = array[2 * posInicial + 1].getTotalDerrotas();
			}

			if ((2 * posInicial + 2) <= (array.length - 1)) {
				direita = array[2 * posInicial + 2].getTotalDerrotas();
			}

			int valor = array[posInicial].getTotalDerrotas();

			if (esquerda < direita) {
				if (esquerda < valor) {
					troca(array, posInicial, 2 * posInicial + 1);
					trocou = true;
				}
			} else {
				if (direita < valor) {
					troca(array, posInicial, 2 * posInicial + 2);
					trocou = true;
				}
			}

			posInicial--;
		}

		if (trocou) {
			minHeap(array);
		}
	}

	/*
	 * Troca a posição do pai com a posição do filho
	 */
	public static void troca(Time[] array, int posInicial, int filho) {
		Time troca = array[posInicial];

		array[posInicial] = array[filho];
		array[filho] = troca;

	}

}
