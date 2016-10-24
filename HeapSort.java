// N�s (Gabriela de Campos Trevisan, Paula Adriana Knob, Matheus Buttner Esteves), garantimos que:
//
// - N�o utilizamos c�digo fonte obtidos de outros estudantes,
// ou fonte n�o autorizada, seja modificado ou c�pia literal.
// - Todo c�digo usado em nosso trabalho � resultado do nosso
// trabalho original, ou foi derivado de um
// c�digo publicado nos livros texto desta disciplina.
// - Temos total ci�ncia das consequ�ncias em caso de violarmos estes termos.

public class HeapSort {

	/*
	 * EXPLICA��O:
	 * 
	 * int posInicial = posi��o no array onde come�ar� a verifica��o;
	 * 
	 * 2*posInicial + 1 e 2*posInicial + 2 = filhos da posi��o no array;
	 * 
	 * (posInicial-1)/2 = posi��o do pai dessa pos no array;
	 * 
	 * comparador = atributo por qual deve ser feita a compara��o de valores (g:
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

	/* MinHeap calculada pelo n�mero de derrotas */
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
	 * Troca a posi��o do pai com a posi��o do filho
	 */
	public static void troca(Time[] array, int posInicial, int filho) {
		Time troca = array[posInicial];

		array[posInicial] = array[filho];
		array[filho] = troca;

	}

}
