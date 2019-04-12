package listaEncadeada;
import java.util.Scanner;

public class Main
{
	public static int menu()
	{
		int escolha;

		Scanner scanner = new Scanner(System.in);

		System.out.println("--------------------------\n");
		System.out.println("Selecione uma opcao:\n");
		System.out.println("1. Insere elemento (no. inteiro) na lista\n");
		System.out.println("2. Remove elemento (no. inteiro) da lista\n");
		System.out.println("3. Imprime elementos da lista.\n");
		System.out.println("0. Fim.\n");
		System.out.println("Sua opcao: ");

		escolha = scanner.nextInt();

		return escolha;
	}

	public static void main(String[] args)
	{
		Lista lista = new Lista();
		int escolha, elem, n;

		Scanner scanner = new Scanner(System.in);

		do
		{
			escolha = Main.menu();

			switch(escolha)
			{
			case 0: /* Não faz nada. */
				break;
			case 1:
				System.out.println("Entre com elemento para inserir: ");
				elem = scanner.nextInt();
				lista.insere(elem);
				break;
			case 2:
				System.out.println("Entre com elemento para remover: ");
				elem = scanner.nextInt();
				if (lista.remove(elem))
					System.out.println("Elemento " + elem + " removido.\n");
				else
					System.out.println("Elemento não existe!\n");
				break;
			case 3:
				System.out.println("Conteúdo da lista:\n");
				lista.imprimeRecursivo();
				break;
			}

		}while(escolha != 0);
				
		scanner.close();
	}
}