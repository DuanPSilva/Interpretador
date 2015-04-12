import mypackage.Lerarq;
import java.util.StringTokenizer;
class Interpretador{
	Mem m= new Mem();
	public void comandos(Lerarq cm){
		String fac;
		Variavel var;
		String op;
		String ig[]=new String[2];
		Double vlr;
		int i=0;
		while(cm.ordem[i]!=null){// && !cm.ordem[i].equals(""))
		vlr=0.0;
			fac=cm.ordem[i];
			switch(fac){
				case("int"):{// no caso da criação das variaveis
					i++;					
					op=cm.ordem[i];
					i++;
					
					if(cm.ordem[i].equals("=")){ // o codigo está escrito com espaços. ex: int abc = 3;
						i++;
						fac=cm.ordem[i];
						if(fac.indexOf(';')!=-1){//fim de linha
							StringTokenizer tokens = new StringTokenizer(fac,";");
							fac=tokens.nextToken();
							vlr=Double.parseDouble(fac);// converte a string em double
						}else{
							vlr=Double.parseDouble(fac);
						}
					}/*else if(op.indexOf("=")!=-1){// verifica se o igual está na string ex: int abc=3;  
						fac=cm.ordem[i-1];
						StringTokenizer tokens = new StringTokenizer(fac,"=");
						int x=0;
						while(tokens.hasMoreTokens()){
							ig[x]=tokens.nextToken();
							x++;
						}
						op=ig[0];
						System.out.println(ig[0]+ig[1]+cm.ordem[i-1]+cm.ordem[i]);
						fac=ig[1];
						if(fac.indexOf(';')!=-1){//fim de linha
							StringTokenizer tok = new StringTokenizer(fac,";");
							fac=tok.nextToken();
							vlr=Double.parseDouble(fac);// converte a string em double
						}else{
							vlr=Double.parseDouble(fac);
						}
						//vlr=Double.parseDouble(ig[1]);


					}*/
					else{ // é o caso onde não há atribuição. ex: int abc; o valor da var = 0.0
						StringTokenizer tokens = new StringTokenizer(op,";");
						if(tokens.hasMoreTokens()){
							op=tokens.nextToken();
						}
					}
					m.criaVariavel(op,vlr);			

					var=m.getVariavel(op);
					System.out.println(var.getNome()+" "+var.getValor());
					break;
				}default:
					System.out.println(cm.ordem[i]);
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