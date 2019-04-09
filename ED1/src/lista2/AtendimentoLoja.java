package lista2;

import filaGenerica.FilaGenerica;

/**
 * 
 * Fila unica para atendimento
 * Idoso sempre entra na frente de adulto normal
 * 
 * O programa usa duas filas, uma para idosos e outra para o resto
 * 
 * Na hora de remover, sai primeiro o da fila de idoso. Apenas sairá da
 * fila de adultos quando a fila de idoso estiver vazia
 * 
 * Não é necessário definir o tamanho das filas no construtor
 * 
 * @author Beto
 *
 */

public class AtendimentoLoja {
	
	private int TAMANHO = 100; //maximo de pessoas que podem entrar na loja em um dado momento
	
	private enum Pessoa {
		Idoso, Adulto;
	}
	
	private FilaGenerica<Pessoa> filaPrioritaria;
	
	private FilaGenerica<Pessoa> filaPadrao;
	
	public AtendimentoLoja() {
		this.filaPrioritaria = new FilaGenerica<>(this.TAMANHO);
		this.filaPadrao = new FilaGenerica<>(this.TAMANHO);
	}
	
	public Pessoa getProximoCliente() {
		if (!filaPrioritaria.vazia())
			return filaPrioritaria.remove();
		if (!filaPadrao.vazia())
			return filaPadrao.remove();
		return null;
	}
	
	public void entrarNaFila (Pessoa p) {
		if (p == Pessoa.Idoso)
			if (!filaPrioritaria.insere(p))
				System.out.println("Fila Cheia, aguarde vagar um espaço");
		else if (!filaPadrao.insere(p))
				System.out.println("Fila Cheia, aguarde vagar um espaço");
		
	}

}
