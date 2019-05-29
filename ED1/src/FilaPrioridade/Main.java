package FilaPrioridade;


public class Main
{
	public static void main(String args[])
	{
		int tamanho = 6;
		int vetor[] = {1, 5, 6, 3, 7, 2};
		
		BinMinHeap heap = new BinMinHeap(tamanho, vetor);
		
		heap.imprime();
		
		heap.insere(4);
		
		System.out.println(heap.min());
		
		heap.removeMin();
		
		System.out.println(heap.min());
	}
}