package gals;

import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

public class Semantico implements Constants
{

    Stack<Integer> stack = new Stack<>();
    Map<String, Integer> memoria_variaveis = new HashMap<>();
    String variavel_atual = "";

    public int getResult()
    {
    return ((Integer)stack.peek()).intValue();
    }

    public void executeAction(int action, Token token) throws SemanticError
    {
        Integer a, b, valor, resultado_expressao;

        switch (action) {

        case 1: // número binário
            stack.push(new Integer(Integer.parseInt(token.getLexeme(), 2)));
            // valor = Integer.parseInt(token.getLexeme(), 2);
            // stack.push(valor);
            break;
            
        case 2: // imprimir
            String nome_var = token.getLexeme();
            if (!memoriaVariaveis.containsKey(nome_var)) {
                throw new SemanticError("A variável '" + nome_var + "' não foi declarada.", token.getPosition());
            }
            valor = (Integer) memoriaVariaveis.get(nome_var);
            String valor_bin = Integer.toBinaryString(valor.intValue());
            System.out.println(valor_bin);

            
            // String nome_var = token.getLexeme();

            // if (!memoria_variaveis.containsKey(nome_var)) {
            //     throw new SemanticError("A variável '" + nome_var + "' não foi declarada.",token.getPosition());
            // }

            // valor = memoria_variaveis.get(nome_var);
            // String valor_bin = Integer.toBinaryString(valor);
            // System.out.println("Resultado: " + valor_bin + " (decimal: " + valor + ")");

            break;
            
        case 3: // soma
            b = (Integer) stack.pop();
            a = (Integer) stack.pop();
            stack.push(new Integer(a.intValue() + b.intValue()));

            // b = stack.pop();
            // a = stack.pop();
            // stack.push(a + b);

            break;
            
        case 4: // subtração
            b = (Integer) stack.pop();
            a = (Integer) stack.pop();
            stack.push(new Integer(a.intValue() - b.intValue()));


            // b = stack.pop();
            // a = stack.pop();

            // stack.push(a - b);

            break;
            
        case 5: // multiplicação
            b = (Integer) stack.pop();
            a = (Integer) stack.pop();
            stack.push(new Integer(a.intValue() * b.intValue()));


            // b = stack.pop();
            // a = stack.pop();

            // stack.push(a * b);

            break;
            
        case 6:
            b = (Integer) stack.pop();
            a = (Integer) stack.pop();
            if (b.intValue() == 0) {
                throw new SemanticError("Erro: Divisão por zero não é permitida.", token.getPosition());
            }
            stack.push(new Integer(a.intValue() / b.intValue()));


            // b = stack.pop();
            // a = stack.pop();

            // if (b == 0) {
            //     throw new SemanticError("Erro: divisão por zero não é permitida.", token.getPosition());
            // }

            // stack.push(a / b);

            break;
            
        case 7: // potência
            b = (Integer) stack.pop();
            a = (Integer) stack.pop();
            stack.push(new Integer((int) Math.pow(a.intValue(), b.intValue())));

            
            // b = stack.pop();
            // a = stack.pop();

            // stack.push((int) Math.pow(a, b));

            break;
            
        case 8: // log na base 2
            valor = (Integer) stack.pop();
            if (valor.intValue() <= 0) {
                throw new SemanticError("O valor para o cálculo do logaritmo deve ser positivo.", token.getPosition());
            }
            stack.push(new Integer((int) (Math.log(valor.intValue()) / Math.log(2))));


            // valor = stack.pop();

            // if (valor <= 0) {
            //     throw new SemanticError("O valor para o cálculo do logaritmo deve ser positivo.", token.getPosition());
            // }

            // stack.push((int) (Math.log(valor) / Math.log(2)));

            break;
            
        case 9: // atribuir
            resultado_expressao = (Integer) stack.pop();
            memoriaVariaveis.put(variavel_atual, resultado_expressao);

    
            // resultado_expressao = stack.pop();
            // memoria_variaveis.put(variavel_atual, resultado_expressao);

            break;
            
        //  case 11: // guarda o nome da variável da atribuição
        //     variavel_atual = token.getLexeme();
        //     break;

        // case 12: // variável usada dentro de uma expressão
        //     String nome_var_uso = token.getLexeme();

        //     if (!memoria_variaveis.containsKey(nome_var_uso)) {
        //         throw new SemanticError("A variável '" + nome_var_uso + "' não foi declarada.", token.getPosition());
        //     }

        //     valor = memoria_variaveis.get(nome_var_uso);

        //     stack.push(valor);
        //     break;

        // default:
        //     throw new SemanticError("Ação semântica desconhecida: #" + action, token.getPosition());
        // }

        case 10:
            variavel_atual = token.getLexeme();
            break;
            
        case 11:
            String nome_var_uso = token.getLexeme();
            if (!memoriaVariaveis.containsKey(nome_var_uso)) {
                throw new SemanticError("A variável '" + nome_var_uso + "' não foi declarada.", token.getPosition());
            }
            valor = (Integer) memoriaVariaveis.get(nome_var_uso);
            stack.push(valor);
            break;      
        }
    }
}
