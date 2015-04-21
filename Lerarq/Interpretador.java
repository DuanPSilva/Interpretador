import java.util.Scanner;// só feito isso
import mypackage.Lerarq;
import java.util.StringTokenizer;
class Interpretador{
	Mem m= new Mem();
	Verifica verifica = new Verifica();
	Loop loop = new Loop();
	public void comandos(Lerarq cm){
		
		String fac, aux;
		Variavel var;
		String op;
		String ig[]=new String[2];
		Double vlr, vlr1;
		int i=0,pool=0;
		while(cm.ordem[i]!=null){// && !cm.ordem[i].equals(""))
			
			fac=cm.ordem[i];
			
			switch(fac){
				case("num"):{// no caso da criação das variaveis
					i++;
					while(!(cm.ordem[i].equals(";"))){
						fac = cm.ordem[i];
						aux = cm.ordem[i+1];
						var = m.getVariavel(aux);
						if(var != null){
							vlr=var.getValor();
							i++;
						}
						else{
							try{
								vlr= Double.parseDouble(aux);
								i++;
							}catch(NumberFormatException errou){
								vlr=0.0;

							}

						}
						m.criaVariavel(fac,vlr);
					i++;

					}
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
						
						i++;
						fac=cm.ordem[i];
					vlr=verifica.operacao(vlr,vlr1,op);
					//var=m.getVariavel(fac);
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
							System.out.print(var.getValor());
						else if(fac.equals("#")){							
							System.out.print(cm.ordem[i]);
							i++;
						}
						else if(fac.equals("||")){
							System.out.print("\n");
						}
						else if(fac.equals(":"))
							System.out.print("");
						else
							System.out.print(fac+" ");
					}

					fac=cm.ordem[i];
					if(!fac.equals("|")){
						Scanner s = new Scanner(System.in);
						vlr=s.nextDouble();
						m.criaVariavel(fac,vlr);
					}
					break;
				}
				case("loop"):{
					pool=i;
					int a=1, c=i;
					while(a>0){
						c++;
						if(cm.ordem[c].equals("loop"))
							a++;
						if(cm.ordem[c].equals("pool")){
							a=a-1;
						}
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

					if(verifica.vdd(vlr,vlr1,op)){
						loop.add(i);
						
					}else{
						i=c;
					}
					break;
				}	
				case ("pool"):{
					if(loop.v_loop() == true){
						i =loop.rem()-4;
					}

					
					break;
				}
				case ("se"):{
					int a=1, c=i;
					while(a>0){
						c++;
						if(cm.ordem[c].equals("se"))
							a++;
						if(cm.ordem[c].equals("fimse")){
							a=a-1;
						}
						
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

					if(!(verifica.vdd(vlr,vlr1,op)))
						i=c;




					//if(aqui.)
					break;
				}
				case ("="):{
					op=cm.ordem[i+1];
					var=(m.getVariavel(op));
					if(var!=null)
						vlr=var.getValor();	
					else
						vlr=Double.parseDouble(op);

					op=cm.ordem[i-1];
					m.criaVariavel(op,vlr);

				}
	//				System.out.println("ge"+cm.ordem[i]);
				
			}

			i++;

		}
		//m.exibe();
	}
}	


/*
	int a=0, b=3;
	while (a<10) {
		int b =0;
		b=3;
		System.out.println(b);
	}
	System.out.prinln(b);
	b++;
	System.out.prinln(b);
	
*/