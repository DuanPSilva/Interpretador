/* Universidade Federal da Fronteira Sul
   Ciência da Computação
   Disciplina: Programação I
   Professor: Fernando Bevilacqua
   Acadêmicos:  Duan Pedroso da Silva
				Jardel Anton

   ** Interpretador **
*/


class Variavel{
	private String name;
	private Double value;


	public void setNome(String name){
		this.name=name;
	}

	public void setValor(Double value){
		this.value = value;
	}

	public String getNome(){
		return this.name;
	}

	public Double getValor(){
		return this.value;
	}

	public void operacao(double vlr, double vlr1, String opr){
		switch(opr){
			case("+"):{
				this.setValor(vlr+vlr1);	
				break;
			}
			case("-"):{
				this.setValor(vlr-vlr1);
				break;
			}
			case("*"):{
				this.setValor(vlr*vlr1);
				break;
			}
			case("/"):{
				this.setValor(vlr/vlr1);
				break;
			}
			case("%"):{
				this.setValor(vlr%vlr1);
				break;
			}
		}
	}



}