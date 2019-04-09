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

public class Parenteses {
    
    public static boolean checaParenteses (String s) {
        /**
         * Empilhar os caracteres
         * Se a pilha está vazia, inserir o próximo caractere
         * A cada novo caractere, checar se ele fecha o item anterior.
         *      caso positivo, esses elementos saem da pilha
         *      caso negativo, 
         *          checar se o novo caractere pode entrar na pilha.
         *              caso positivo, inserí-lo na pilha
         *              caso negativo, os parenteses não estão balanceados
         * Se no final, a pilha estiver vazia, a linha está balanceada
         */
        
        PilhaGenerica<Character> pilha = new PilhaGenerica<>(3);        
        int i = 0;
        while ( i < s.length()) {
            if (pilha.vazia())
                pilha.push(s.charAt(i));
            else {
                char topo = pilha.pop();
                char proximo = s.charAt(i);
                if (!checaFechamento(topo,proximo)) {
                    if (podeEntrar(topo,proximo)) {
                        pilha.push(topo);
                        pilha.push(proximo);
                    }
                    else return false;
                }
            }
            i++;
            System.out.println(pilha.imprimePilha());
        }
        return (pilha.vazia());
    }
    
    public static boolean checaFechamento (char a, char b) {
        if (a == '{' && b == '}') return true;
        if (a == '[' && b == ']') return true;
        if (a == '(' && b == ')') return true;
        return false;
    }
    
    public static boolean podeEntrar (char a, char b) {
        if (a == '{' && b == '[') return true;
        if (a == '{' && b == '(') return true;
        if (a == '[' && b == '(') return true;
        return false;
    }

    public static void main(String[] args) {
        String linha1 = "[()]{}{[()()]}";
        String linha2 = "[(])";
        String linha3 = "{[()]()}";
        System.out.println(checaParenteses(linha1));
        System.out.println(checaParenteses(linha2));
    }
}
