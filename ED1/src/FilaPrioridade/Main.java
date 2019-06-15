package FilaPrioridade;

import ArvoreBinaria.Arvbin;

public class Main {
	public static void q1() {
		BinMaxHeapGenerica<String> questao1 = new BinMaxHeapGenerica<>(20);
		questao1.insere("P");
		questao1.insere("R");
		questao1.insere("I");
		questao1.insere("O");
		System.out.println(questao1.remove());
		questao1.insere("R");
		System.out.println(questao1.remove());
		System.out.println(questao1.remove());
		questao1.insere("I");
		System.out.println(questao1.remove());
		questao1.insere("T");
		System.out.println(questao1.remove());
		questao1.insere("Y");
		System.out.println(questao1.remove());
		System.out.println(questao1.remove());
		System.out.println(questao1.remove());
		questao1.insere("Q");
		questao1.insere("U");
		questao1.insere("E");
		System.out.println(questao1.remove());
		System.out.println(questao1.remove());
		System.out.println(questao1.remove());
		questao1.insere("U");
		System.out.println(questao1.remove());
		questao1.insere("E");
	}
	
	public static void q4() {
		BinMaxHeapGenerica<SistemaOperacional> windows = new BinMaxHeapGenerica<>(15);
		Aplicacao virus = new Aplicacao(100,"virus");
		SistemaOperacional boot = new SistemaOperacional(100,"boot");
		SistemaOperacional spool = new SistemaOperacional(70,"spool");
		SistemaOperacional serviceShell = new SistemaOperacional(80,"Service Shell");
		Aplicacao eclipse = new Aplicacao(50,"eclipse");
		
		windows.insere(spool);
		windows.insere(eclipse);
		windows.insere(serviceShell);
		windows.insere(boot);
		windows.insere(virus);
		for(int i = 0; i < 5; i++)
			System.out.println(windows.remove());
	}
	
	public static void q2() {
		Arvbin<Integer> a1 = new Arvbin<>(3),
				a2 = new Arvbin<>(9),
				a3 = new Arvbin<>(4, a1,a2),
				a4 = new Arvbin<>(8),
				arvore = new Arvbin<>(6,a3,a4);
		BinMaxHeap teste = BinMaxHeap.importaArvoreBinaria(arvore);
		teste.imprime();
	}
	
	public static void main(String args[]) {
		//q1();
		//q4();
		
		//q2();
		

	}
}