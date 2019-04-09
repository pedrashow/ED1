package pilha;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author beto
 */
public class InversaoLetras {
    
    /**
     * Separar cada palavra da frase
     * Criar uma pilha dos caracteres de cada palavra, para que possam ser invertidos ao sair
     * Inserir a pilha dos caracteres de cada palavra em uma outra pilha de palavras da frase
     * Reverter a pilha de palavas para que na hora de sair da pilha, elas mantenham a
     * ordem original
     */
    
    public static PilhaGenerica<Character> populaPilhaChar (String s) {
        PilhaGenerica<Character> pilhaChar = new PilhaGenerica<>(s.length());
        for (int i=0;i<s.length();i++) {
            pilhaChar.push(s.charAt(i));
        }
        return pilhaChar;
    }
    
    public static PilhaGenerica<PilhaGenerica<Character>> populaPilhaPalavras (String s) {
        String[] palavras = s.split(" ");
        PilhaGenerica<PilhaGenerica<Character>> pilhaPalavras = new PilhaGenerica<>(palavras.length);
        for (String palavra : palavras) {
            pilhaPalavras.push(populaPilhaChar(palavra));
        }
        pilhaPalavras.revertePilha(); //para que as palavras mantenham a ordem original da frase ao sair
        return pilhaPalavras;
    }
    
    public static String inverteLetras(String frase) {
        
        String letrasInvertidas = "";
        PilhaGenerica<PilhaGenerica<Character>> pilhaFrase = populaPilhaPalavras(frase);
        while (!pilhaFrase.vazia()) {
            PilhaGenerica<Character> elementoPilhaFrase = pilhaFrase.pop();
	            while (!elementoPilhaFrase.vazia())
	                letrasInvertidas += elementoPilhaFrase.pop();
            letrasInvertidas += " ";
        }

        return letrasInvertidas;
    }
    
    public static void main(String[] args) {
        String frase = "A maça está podre";
        System.out.println(inverteLetras(frase));
    }    
}
