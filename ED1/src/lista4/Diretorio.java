package lista4;

public class Diretorio {

	private Dir raiz;

	public Diretorio() {
		this.raiz = new Dir(null, "raiz");
		Dir jogos = new Dir(raiz, "Jogos");
		Arquivo campoMinado = new Arquivo(jogos, "Campo Minado");
		Arquivo paciencia = new Arquivo(jogos, "Paciência");
		Arquivo worldOfWarcraft = new Arquivo(jogos, "World of Warcraft");
		Dir faculdade = new Dir(raiz, "Faculdade");
		Arquivo edd1 = new Arquivo(faculdade, "EDD1");
		Arquivo edd2 = new Arquivo(faculdade, "EDD2");
		Arquivo aa = new Arquivo(faculdade, "AA");
		Dir aces = new Dir(faculdade, "ACEs");
		Arquivo tpd = new Arquivo(faculdade, "TPD");
		Dir filmes = new Dir(raiz, "Filmes");
		Dir superHeroicos = new Dir(filmes, "Super-heróicos");
		Dir marvel = new Dir(superHeroicos, "Marvel");
		Arquivo vingadores = new Arquivo(marvel, "Vingadores");
		Arquivo homemAranha = new Arquivo(marvel, "Homem-Aranha");
		Dir dc = new Dir(superHeroicos, "DC");
		Arquivo ace1 = new Arquivo(aces, "ACE1");
		Arquivo ace2 = new Arquivo(aces, "ACE2");
		Arquivo ace3 = new Arquivo(aces, "ACE3");
		Arquivo superman = new Arquivo(dc, "Superman");
		Dir drama = new Dir(filmes, "Drama");
		Arquivo beumsl = new Arquivo(drama, "Brilho Eterno de Uma Mente Sem Lembranças");
		Dir comediasRomanticas = new Dir(filmes, "Comédias Românticas");
	}
	
	public String toString() {
		if (this.raiz == null)
			return "Diretorio Vazio";
		return toString(this.raiz);
	}
	
	private String toString(ItemArmazenado item) {
		String retorno= item.toString();
		if (!item.fim()) {
			ItemArmazenado temp = item.getFilhoEsquerdo();
			while (temp != null) {
				retorno += toString(temp);
				temp = temp.getIrmaoDireito();
			}
		}
		return retorno;
	}

	public static void main(String[] args) {
		Diretorio diretorio = new Diretorio();
		System.out.println(diretorio);
	}
}
