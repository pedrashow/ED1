package FilaPrioridade;

public class SistemaOperacional implements Comparable<SistemaOperacional> {
	
	private int prioridade;
	private String acao;
	
	SistemaOperacional(int i, String s) {
		this.prioridade = i;
		this.acao = s;
	}
	

	public int compareTo(SistemaOperacional so) {
		if (!(so instanceof SistemaOperacional))
			return 1;
		
		if(this.prioridade > so.getPrioridade())
			return 1;
		
		if (this.prioridade == so.getPrioridade())
			return 0;
		
		return 1;
	}
	
	public String toString() {
		return this.acao;
	}
	
	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}



}
