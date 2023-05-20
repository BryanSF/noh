package noh;

public class ArvoreB {
	
	private No raiz;

	public ArvoreB() {
		raiz = null;
	}
	public ArvoreB(int valor) {
		raiz = new No(valor);
	}	
	
	public No getRaiz() {
		return raiz;
	}
	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}
	
	public void inserir(No node, int valor) {
		if(raiz == null) {
			raiz = new No(valor);
		}else {
			
			if(valor < node.getValor()) {
				
				if (node.getNohEsq() != null) {
					inserir(node.getNohEsq(), valor);
				} else {
					
					System.out.println("\n\nInserindo " + valor + " a esqueda de " + node.getValor());
					
					node.setNohEsq(new No(valor));
				}
			
			}else if (valor > node.getValor()) {
				
				if (node.getNohDir() != null) {
					inserir(node.getNohDir(), valor);
				} else {
					
					System.out.println("\n\nInserindo " + valor + " a direita de " + node.getValor());
					
					node.setNohDir(new No(valor));
				}			
			}
		}
	}
	
	public No remover(No node, int valor) {
		if (node == null) {
			System.out.println("Árvore vazia ");
			return null;
		}
		System.out.println("Remover: Corendo No " + node.getValor());
		if (valor < node.getValor()) {
			node.setNohEsq(remover(node.getNohEsq(), valor));
		} else if (valor > node.getValor()) {
			node.setNohDir(remover(node.getNohDir(), valor));
		} else if (node.getNohEsq() != null && node.getNohDir() != null) 
		{
			System.out.println("Removeu No " + node.getValor());
			node.setValor(encontraMin(node.getNohDir()).getValor());
			node.setNohDir(removeMin(node.getNohDir()));
		} else {
			System.out.println("  Removeu No " + node.getValor());
			if(node.getNohEsq() == null) {
				node = node.getNohEsq();
			}else {
				node = node.getNohDir();
			}
		}
		return node;
	}
	
	public No encontraMin(No node) {
		if (node != null) {
			while (node.getNohEsq() != null) {
				node = node.getNohEsq();
			}
		}
		return node;
	}

	public No removeMin(No node) {
		if (node == null) {
			System.out.println("  ERRO ");
		} else if (node.getNohEsq() != null) {
			
			node.setNohEsq(removeMin(node.getNohEsq()));
			return node;
		} else {
			return node.getNohDir();
		}
		return null;
	}	
	
	public int soma(No node) {
		if(node == null) {
			return 0;
		}else {
			return node.getValor() + 
			soma(node.getNohEsq()) + 
			soma(node.getNohDir()); 
		}
	}
	
	public void preOrdem(No no) {
		if(no != null){
			System.out.print(no.getValor() + " ");
			preOrdem(no.getNohEsq());
			preOrdem(no.getNohDir());
		}
	}
	
	public void emOrdem(No no) {
		if(no != null){
			emOrdem(no.getNohEsq());
			System.out.print(no.getValor() + " ");
			emOrdem(no.getNohDir());
		}
	}
	
	public void posOrdem(No no) {
		if(no != null){
			posOrdem(no.getNohEsq());	        
			posOrdem(no.getNohDir());
			System.out.print(no.getValor() + " ");
		}
	}
	
	public void imprime(No inicial, int vezes) {
		if(inicial != null) {
			No aux = inicial;
			
			if(inicial.getNohDir() != null) {
				aux = inicial.getNohDir();
				imprime(aux, ++vezes);
				System.out.println("");
				vezes--;
			}
			
			if(inicial.getNohDir() == null && inicial.getNohEsq() != null) {
				for(int i = 0; i < vezes*5; i++)
					System.out.print(" ");
				inicial.imprimeNoh();
			}
			
			if(inicial.getNohDir() != null && inicial.getNohEsq() == null) {
				for(int i = 0; i < vezes*5; i++)
					System.out.print(" ");
				inicial.imprimeNoh();
			}
			
			if(inicial.getNohDir() != null && inicial.getNohEsq() != null) {
				for(int i = 0; i < vezes*5; i++)
					System.out.print(" ");
				inicial.imprimeNoh();
			}
			
			if(inicial.getNohEsq() != null) {
				System.out.println("");
				aux = inicial.getNohEsq();
				imprime(aux, ++vezes);
				vezes--;
			}
			
			if(inicial.getNohDir() == null && inicial.getNohEsq() == null) {
				for(int i = 0; i < vezes*5; i++)
					System.out.print(" ");
				inicial.imprimeNoh();
			}
		}else {
			System.out.println("A árvore está vazia!");
		}
	}
}