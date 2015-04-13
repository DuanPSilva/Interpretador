import java.util.Scanner;
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
		Double vlr, vlr1;
		int i=0;
		while(cm.ordem[i]!=null){// && !cm.ordem[i].equals(""))
			
			fac=cm.ordem[i];
			
			switch(fac){
				case("num"):{// no caso da criação das variaveis
					i++;
					vlr=0.0;
					fac=cm.ordem[i];
					op=fac;
					if(fac.indexOf(";")!=-1){// verifica se a variavel não é setada (cria var=0.0). int abc;
						StringTokenizer tokens = new StringTokenizer(fac,";");
						if(tokens.hasMoreTokens()){
							op=tokens.nextToken();
							m.criaVariavel(op,0.0);			
						}
					}else {// a variavel é criada e setada
						op=cm.ordem[i];
						i++;
						fac=cm.ordem[i];
						if(fac.indexOf(";")!=-1){
							StringTokenizer tokens = new StringTokenizer(fac,";");
							if(tokens.hasMoreTokens()){
								fac=tokens.nextToken();
								vlr=Double.parseDouble(fac);// converte a string em double
								m.criaVariavel(op,vlr);			
							}
						}
					}
					var=m.getVariavel(op);
					//System.out.println("Fim: "+var.getNome()+" "+var.getValor());
					break;
				}
				case("op"):{
					i++;
					vlr=0.0;
					ig[0]=cm.ordem[i];
					i++;
					op=cm.ordem[i];
					i++;
					ig[1]=cm.ordem[i];
					i++;
					fac=cm.ordem[i];

					var=(m.getVariavel(ig[0]));
					if(var!=null)
						vlr=var.getValor();	
					else
						vlr=Double.parseDouble(ig[0]);
					var=(m.getVariavel(ig[1]));
					if(var!=null)
						vlr1=var.getValor();	
					else
						vlr1=Double.parseDouble(ig[1]);
					switch(op){
						case("+"):{
							vlr=vlr+vlr1;	
							break;
						}
						case("-"):{
							vlr=vlr-vlr1;
							break;
						}
						case("x"):{
							vlr=vlr*vlr1;
							break;
						}
						case("÷"):{
							vlr=vlr/vlr1;
							break;
						}
						case("%"):{
							vlr=vlr%vlr1;
							break;
						}
					}
					if(fac.equals(":")){
						i++;
						fac=cm.ordem[i];
						StringTokenizer tokens = new StringTokenizer(fac,";");
						while(tokens.hasMoreTokens()){
							fac=tokens.nextToken();
						}
					}else{
						StringTokenizer tokens = new StringTokenizer(fac,";:");
						while(tokens.hasMoreTokens()){
							fac=tokens.nextToken();
						}
					}
					var=m.getVariavel(fac);
					m.criaVariavel(fac,vlr);
					break;
				}
				case("ler"):{// ler sua frase aqui será escrita até o caracter ":" abc;
					i++;
					
					while(!fac.equals(":")){
						fac=cm.ordem[i];
						i++;
						var=m.getVariavel(fac);
						if(var!=null)
							System.out.println(var.getValor());
						else if(fac.equals("||")){
							System.out.printf("\n");
						}
						else if(fac.equals(":"))
							System.out.printf("");
						else
							System.out.printf(fac+" ");
					}

					fac=cm.ordem[i];
					if(fac.indexOf(";")!=-1){	
							StringTokenizer tokens = new StringTokenizer(fac,";");
							while(tokens.hasMoreTokens())
								fac=tokens.nextToken();
					}else{
						fac=cm.ordem[i];
					}	
					if(!fac.equals("|")){
						Scanner s = new Scanner(System.in);
						vlr=s.nextDouble();
						m.criaVariavel(fac,vlr);
					}
					break;
				}
				case("func"):{

					break;
				}
				case ("loop"):{
					//Mem aqui= new Mem();
					i++;
					ig[0]=cm.ordem[i];
					i++;
					op=cm.ordem[i];
					i++;
					ig[1]=cm.ordem[i];

					var=(m.getVariavel(ig[0]));
					if(var!=null)
						vlr=var.getValor();	
					else
						vlr=Double.parseDouble(ig[0]);
					var=(m.getVariavel(ig[1]));
					if(var!=null)
						vlr1=var.getValor();	
					else
						vlr1=Double.parseDouble(ig[1]);

					switch(op){
						case(">="):{
							if(!(vlr>=vlr1))
								break;
							else{
								while(!op.equals("pool")){}
									i++;
									op=cm.ordem[i];
								}
							break;
						}
						case("=="):{
							if(!(vlr==vlr1))
								break;
							else{
								while(!op.equals("pool")){}
									i++;
									op=cm.ordem[i];
								}
							break;
						}
						case("<="):{
							if(!(vlr<=vlr1))
								break;
							else{
								while(!op.equals("pool")){}
									i++;
									op=cm.ordem[i];
								}
							break;
						}
						case(">"):{
							if(!(vlr>vlr1))
								break;
							else{
								while(!op.equals("pool")){}
									i++;
									op=cm.ordem[i];
								}
							break;
						}
						case("<"):{
							if(!(vlr<vlr1))
								break;
							else{
								while(!op.equals("pool")){}
									i++;
									op=cm.ordem[i];
								}
							break;
						}

					}


					//if(aqui.)
					break;
				}
				default:
					//System.out.println("ge"+cm.ordem[i]);
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
		m.exibe();
	}
}	
