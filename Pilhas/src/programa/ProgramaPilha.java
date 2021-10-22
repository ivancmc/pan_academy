package programa;

import java.util.Stack;

public class ProgramaPilha extends PilhaRepo {

	public static void main(String[] args) {
		Stack<String> pilha = new Stack<>();
		System.out.println("stack: " + pilha);
		inserindoPush(pilha, "Caixa acústica 110");
		inserindoPush(pilha, "Caixa acústica 120");
		inserindoPush(pilha, "note");
		deletandoPop(pilha);
		deletandoPop(pilha);
	}
}
