package lista2;

/**
 * Classe abstrata pai para smartphone e tablet
 * @author Beto
 *
 */

public abstract class Portatil {
	
	private String modelo;
	
	private double preco;
	
	public Portatil (String modelo, double preco) {
		this.modelo = modelo;
		this.preco = preco;
	}
	
	public String getModelo() {
		return this.modelo;
	}
	
	public double getPreco() {
		return this.preco;
	}
	
	public String getTipo() { //retorna o nome da sub classe
		return this.getClass().getSimpleName();
	}
	
	public String toString() {
		return this.getTipo() + " - " + this.modelo + "(" + this.preco + ")";
	}

}
