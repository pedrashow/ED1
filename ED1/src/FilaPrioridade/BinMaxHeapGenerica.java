package FilaPrioridade;

import java.util.Vector;

public class BinMaxHeapGenerica<T extends Comparable<T>> {
	private int n;
	private int tamanho;
	private Vector<T> vetor;

	public BinMaxHeapGenerica(int tamanho) {
		this.n = 0;
		this.tamanho = tamanho;
		vetor = new Vector<T>(tamanho+1);
		for (int i = 0; i <= tamanho; i++)
			vetor.add(null);
	}

	public BinMaxHeapGenerica(int tamanho, T[] v) {
		this(tamanho);
		n = v.length;
		for (int i = 0; i < v.length; i++) {
			vetor.set(i+1, v[i]);
		}

		constroiHeap();
	}
	
	public boolean vazia() {
		return this.n == 0;
	}
	
	public void esvaziar() {
		this.n = 0;
	}

	private void constroiHeap() {
		for (int i = n / 2; i > 0; i--)
			refaz(i);
	}
	
	private void refaz(int x) {
		T temp = vetor.get(x);
		
		while (2*x <= n) {
			int filhoEsq, filhoDir, maiorFilho;
			
			filhoEsq = 2*x;
			filhoDir = 2*x + 1;
			maiorFilho = filhoEsq;
			
			if ((filhoEsq != n) && (vetor.get(filhoEsq).compareTo(vetor.get(filhoDir)) < 0))
				maiorFilho = filhoDir;
			
			if (vetor.get(maiorFilho).compareTo(temp) > 0)
				vetor.set(x, vetor.get(maiorFilho));
			else
				break;
			
			x = maiorFilho;
		}
		vetor.set(x, temp);
	}
	
	public void insere(T objeto) {
		if (n == tamanho) {
			System.out.println("Fila cheia, impossível inserir");
			return;
		}
		
		n++;
		int pos = n;
		vetor.set(0, objeto);

		
		while (objeto.compareTo(vetor.get(pos/2)) > 0) {
			vetor.set(pos, vetor.get(pos/2));
			pos /= 2;
		}
		
		vetor.set(pos, objeto);

	}
	
	public T remove() {
		if (this.vazia()) {
			System.out.println("Fila vazia");
			return null;
		}
		
		T saida = vetor.get(1);
		vetor.set(1, vetor.get(n));
		n--;
		refaz(1);
		
		return saida;
	}
	
	public void imprime() {
		for (int i = 1; i <= n; i++)
			System.out.print(vetor.get(i)+ " ");
		System.out.println();
	}
}
