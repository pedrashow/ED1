package ArvoreBinaria;


public class Main
{
	public static void main(String[] args)
	{
		Arvbin<Integer> a1 = new Arvbin<Integer>(1),
				a2 = new Arvbin<Integer>(2),
				a3 = new Arvbin<Integer>(3,a1,a2),
				a4 = new Arvbin<Integer>(4),
				a5 = new Arvbin<Integer>(5),
				a6 = new Arvbin<Integer>(6),
				a7 = new Arvbin<Integer>(7,a5,a6),
				a8 = new Arvbin<Integer>(8),
				a9 = new Arvbin<Integer>(9),
				a10 = new Arvbin<Integer>(10,a8,a9);

		a4.defineEsq(a3);
		a4.defineDir(a7);
		a4.mostra();
		System.out.println();
		
		System.out.println("Número de nós: " + a10.contaNos());
		
		System.out.println("Altura da árvore: " + a4.calculaAltura());
		
		a4.mostra();
		System.out.println(Arvbin.soma(a4));
				
		Arvbin<Integer> p1 = new Arvbin<>(6),
				p2 = new Arvbin<>(4),
				p3 = new Arvbin<>(3),
				p4 = new Arvbin<>(9),
				p5 = new Arvbin<>(10,p1,p2),
				p6 = new Arvbin<>(12,p3,p4),
				p7 = new Arvbin<>(44,p5,p6);
		
		System.out.println(Arvbin.soma(p7));
		System.out.println(Arvbin.arvoreSoma(p7));
				
	}
}
