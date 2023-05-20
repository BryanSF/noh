package noh;

public class No {
	
	private int valor;
	private No NohEsq;
	private No NohDir;
	
	public No(int v){
		this.valor = v;
		this.NohEsq = null;
		this.NohDir = null;
	}
	public No(int v, No esq, No dir){
		this.valor = v;
		this.NohEsq = esq;
		this.NohDir = dir;
	}
		
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public No getNohEsq() {
		return NohEsq;
	}
	public void setNohEsq(No nohEsq) {
		NohEsq = nohEsq;
	}
	public No getNohDir() {
		return NohDir;
	}
	public void setNohDir(No nohDir) {
		NohDir = nohDir;
	}
	public void imprimeNoh(){
		System.out.print(" {" + this.valor + "}");
	}
}