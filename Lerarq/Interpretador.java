import java.util.Scanner;// só feito isso
import mypackage.Lerarq;
import java.util.StringTokenizer;
class Interpretador{
	Mem m= new Mem();
	//int vetor_de_if[]= new int[100];
	//Numero n=new Numero();
	public void comandos(Lerarq cm){
		
		String fac, aux;
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
					while(!(cm.ordem[i].equals(";"))){
						fac = cm.ordem[i];System.out.println("FAC = "+fac);
						aux = cm.ordem[i+1];System.out.println("AUX = "+aux);
						var = m.getVariavel(aux);
						if(var != null){
							vlr=var.getValor();
							i++;
						}
						else{
							try{
								vlr= Double.parseDouble(aux);	
								System.out.println(vlr);
								i++;
							}catch(NumberFormatException errou){
								vlr=0.0;

							}

						}
						m.criaVariavel(fac,vlr);
					i++;

					}//System.out.println("Fim: "+var.getNome()+" "+var.getValor());
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
						i++;
						fac=cm.ordem[i];
					
					var=m.getVariavel(fac);
					m.criaVariavel(fac,vlr);
					break;
				}
				case("ler"):{// ler sua frase aqui será escrita até o caracter ":" abc;
					i++;
					
					while(!fac.equals(":")){
						fac=cm.ordem[i];
						i++;
						//System.out.println("FAC + "+fac);
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
				case ("se"):{
					//Mem aqui= new Mem();
					int a=1, c=i+1;
					System.out.println("SE\n");
					while(a>0){
						if(cm.ordem[c].equals("se"))
							a++;
						if(cm.ordem[c].equals("fimse")){
				System.out.println("ACHOU PORRA"+a);
							a=a-1;
	//						System.out.println(a);
						}
	//					System.out.println(cm.ordem[c]);
	//					System.out.println(a);
						c++;
					}
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
								i=c;
								break;
						}
						case("="):{
							if(!(vlr==vlr1))
								i=c;
								break;
						}
						case("<="):{
							if(!(vlr<=vlr1))
								i=c++;
								break;
						}
						case(">"):{
							if(vlr<vlr1)
								i=c;
								break;
						}
						case("<"):{
							if(!(vlr<vlr1)){
								i=c++;
								//System.out.println(cm.ordem[c]);
							}
								break;
						}

					}


					//if(aqui.)
					break;
				}
				default:
	//				System.out.println("ge"+cm.ordem[i]);
				
			}

			i++;

		}
		//m.exibe();
	}
}	