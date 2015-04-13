class Mem{
	private Variavel[] vetor= new Variavel[100];

	public Variavel getVariavel(String name){
		Variavel var= new Variavel();
		int c=0;
		 while(vetor[c]!=null){
		 	if(vetor[c].getNome().equals(name)){
		 		return vetor[c];
		 	}
		 	c++;
		 }
		return null;// não existe a variavel
	}	
	public void criaVariavel(String nome,Double vlr){
		 int y=0;
		 while(vetor[y]!=null){
		 	if(vetor[y].getNome().equals(nome)){
		 //		System.out.println("\n\t\tVariavel ja Existe");
		 		break;
		 	}
		 	y++;
		 }
		 vetor[y]=new Variavel();
		 //System.out.println(vetor[y].getNome() + vetor[y].getValor());
		 vetor[y].setNome(nome);
		 vetor[y].setValor(vlr);
		//System.out.println(vetor[y].getNome()+" " + vetor[y].getValor()+"\n");
	}	
	public void exibe(){
		Variavel var= new Variavel();
		int c=0;
		 while(vetor[c]!=null){
		 	//System.out.println(vetor[c].getNome()+" "+vetor[c].getValor());
		 	
		 	c++;
		 }
	}
}