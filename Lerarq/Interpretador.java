import mypackage.Lerarq;
import java.util.StringTokenizer;
class Interpretador{
	Mem m= new Mem();
	//Numero n=new Numero();
	public void comandos(Lerarq cm){
		String fac;
		Variavel var;
		String op;
		String ig[]=new String[2];
		Double vlr;
		int i=0;
		while(cm.ordem[i]!=null){// && !cm.ordem[i].equals(""))
			System.out.println(cm.ordem[i]);
			i++;
		}
		i=0;
		while(cm.ordem[i]!=null){// && !cm.ordem[i].equals(""))
			System.out.println(cm.ordem[i]);
			vlr=0.0;

			op=cm.ordem[i];
			System.out.println(op);

			fac=cm.ordem[i];
			i++;
			switch(fac){

				case("int"):{// no caso da criação das variaveis
					fac=cm.ordem[i];

					if(fac.indexOf(";")!=-1){
						StringTokenizer tokens = new StringTokenizer(fac,";");
						if(tokens.hasMoreTokens()){
							op=tokens.nextToken();
							m.criaVariavel(op,0.0);			
						}
					}else {
						op=cm.ordem[i];
						i++;
						fac=cm.ordem[i];
						if(fac.indexOf(";")!=-1){
							StringTokenizer tokens = new StringTokenizer(fac,";");
							if(tokens.hasMoreTokens()){
								fac=tokens.nextToken();
								//System.out.println(fac);
								vlr=Double.parseDouble(fac);// converte a string em double
								//System.out.println(vlr);
								m.criaVariavel(op,vlr);			
							}
						}
					}
						

						var=m.getVariavel(op);
						System.out.println("Fim: "+var.getNome()+" "+var.getValor());
					

					
					//i++;
					break;
				}default:
					//System.out.println(cm.ordem[i]);
				/*
				case("func"){// caso de Criação de um escopo de função.
					break;
				}
				case("endfunc"){
					break;
				}
				case("if"){//controle de fluxo if
					break;
				}
				case("endif"){
					break;
				}
				case("loop"){
					break;
				}
				case("endloop"){
					break;
				}*/
			}

			i++;

		}
	}
}	
