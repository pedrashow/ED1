package Trabalho;

public class Main
{
	public static void main(String args[])
	{
		OrdenacaoTopologica ord = new OrdenacaoTopologica();
		
		String nomeEntrada = "teste.txt";
		
		ord.realizaLeitura(nomeEntrada);

		if(!ord.executa())
			System.out.println("O conjunto nao � parcialmente ordenado.");
		else
			System.out.println("O conjunto � parcialmente ordenado.");
	}
}
