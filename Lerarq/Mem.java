class Mem{
	private Variavel[] vetor= new Variavel[100000];
	
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
		 if(index0Var(nome)){
			 while(vetor[y]!=null){
			 	if(vetor[y].getNome().equals(nome)){
			 		break;
			 	}
			 	y++;
			 }
			 vetor[y]=new Variavel();
			 vetor[y].setNome(nome);
			 vetor[y].setValor(vlr);
			 //System.out.print("\n"+vetor[y].getNome()+"\n"+vetor[y].getValor());
		}
	}

	

	public static boolean vdd(double a,double b, String opr){
		int x=0;
		switch(opr){
			case("="):{
				if(a==b)
					x=1;break;
			}
			case("<"):{
				if(a<b)
					x=1;break;
			}
			case(">"):{
				if(a>b)
					x=1;break;
			}
			case("!"):{
				if(a!=b)
					x=1;break;
			}
		}
		return x==1;
	}
	public double operacao(double vlr, double vlr1, String opr){
		switch(opr){
			case("+"):{
				vlr=vlr+vlr1;	
				break;
			}
			case("-"):{
				vlr=vlr-vlr1;
				break;
			}
			case("*"):{
				vlr=vlr*vlr1;
				break;
			}
			case("/"):{
				vlr=vlr/vlr1;
				break;
			}
			case("%"):{
				vlr=vlr%vlr1;
				break;
			}
		}
		return vlr;
	}

	public boolean index0Var(String aha){
		int i=0;
		while(i<10){
			try{
				if(Integer.parseInt(Character.toString(aha.charAt(0)))==i)
					return false;
				
				i++;
			}catch(NumberFormatException errou){
				i++;
			}			
		}
		return true;

	}

}