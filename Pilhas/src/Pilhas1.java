import java.util.Stack;

public class Pilhas1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> pilha = new Stack<>();
		
		boolean result = pilha.empty();
		
		System.out.println("A pilha está vazia? " + result);
		
		pilha.push(68);
		pilha.push(118);
		pilha.push(90);
		pilha.push(720);
		pilha.pop();
		
		System.out.println("Pilha: " + pilha);
		result = pilha.empty();
		System.out.println("Vazia? " + result);
	}

}
