package lista4;

public class Diretorio {
	
	private Dir raiz;
	
	public Diretorio() {
		this.raiz = new Dir(null,"raiz");
		Dir jogos = new Dir(raiz, "Jogos");
		Arquivo campoMinado = new Arquivo(jogos,"Campo Minado");
		Arquivo paciencia = new Arquivo(jogos,"Paci�ncia");
		Arquivo worldOfWarcraft = new Arquivo(jogos,"World of Warcraft");
		Dir faculdade = new Dir(raiz,"Faculdade");
		Arquivo edd1 = new Arquivo(faculdade,"EDD1");
		Arquivo edd2 = new Arquivo(faculdade,"EDD2");
		Arquivo aa = new Arquivo(faculdade,"AA");
		Dir aces = new Dir(faculdade,"ACEs");
		Arquivo tpd = new Arquivo(faculdade,"TPD");
		Dir filmes = new Dir(raiz,"Filmes");
		Dir superHeroicos = new Dir(filmes,"Super-her�icos");
		Dir marvel = new Dir(superHeroicos,"Marvel");
		Arquivo vingadores = new Arquivo(marvel,"Vingadores");
		Arquivo homemAranha = new Arquivo(marvel,"Homem-Aranha");
		Dir dc = new Dir(superHeroicos,"DC");
		Arquivo ace1 = new Arquivo(aces,"ACE1");
		Arquivo ace2 = new Arquivo(aces,"ACE2");
		Arquivo ace3 = new Arquivo(aces,"ACE3");
		Arquivo superman = new Arquivo(dc,"Superman");
		Dir drama = new Dir(filmes,"Drama");
		Arquivo beumsl = new Arquivo(drama,"Brilho Eterno de Uma Mente Sem Lembran�as");
		Dir comediasRomanticas = new Dir(filmes,"Com�dias Rom�nticas");
	}
	
	public static void imprime(ItemArmazenado i) {
		System.out.print(i.toString());
		if (!i.fim()) {
			ItemArmazenado temp = i.getFilhoEsquerdo();
			while (temp != null) {
				imprime(temp);
				temp = temp.getIrmaoDireito();
			}
		}
	}
	

	/*Em constru��o
	 * public String toString() { if (this.raiz == null) return "Diretorio Vazio";
	 * return toString(this.raiz,""); }
	 * 
	 * 
	 * private String toString(ItemArmazenado item, String s) { if (item == null)
	 * return s; s += item.toString(); if (!item.fim()) { return
	 * toString(item.getFilhoEsquerdo(),s); } return
	 * maisUm(item.getIrmaoDireito(),s); }
	 * 
	 * private String maisUm(ItemArmazenado item, String s) { if (item == null)
	 * return s; s+= item.toString(); return maisUm(item.getIrmaoDireito(),s); }
	 */	
	
	
	public static void main(String[] args) {
		Diretorio diretorio = new Diretorio();
		//System.out.println(diretorio);
		imprime(diretorio.raiz);
	}
}
