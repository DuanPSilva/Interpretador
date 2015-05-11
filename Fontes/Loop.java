/* Universidade Federal da Fronteira Sul
   Ciência da Computação
   Disciplina: Programação I
   Professor: Fernando Bevilacqua
   Acadêmicos:  Duan Pedroso da Silva
				Jardel Anton

   ** Interpretador **
*/



class Loop{
	private int p_ini_loop[];
	private int ult;

	public Loop(){// inicia o vetor de loops com 100 posições, e usaremos o vetor como uma pilha
		p_ini_loop = new int[100];
		ult = -1;
	}

	public void add(int t){
		this.ult++;
		this.p_ini_loop[this.ult] = t;
	}

	public int rem(){
		if(this.ult != -1){
			this.ult--;
			//System.out.print(this.ult);
			return (p_ini_loop[this.ult + 1]);
		}else{
			return 0;
		}
	}
	
	public boolean v_loop(){// verifica se loop está vazio	
		return (!(this.ult == -1));
	}
}