/* Universidade Federal da Fronteira Sul
   Ciência da Computação
   Disciplina: Programação I
   Professor: Fernando Bevilacqua
   Acadêmicos:  Duan Pedroso da Silva
				Jardel Anton
   ** Interpretador **
*/


import java.util.Scanner;
import java.util.StringTokenizer;
class Interpretador{
	Mem m= new Mem();
	Loop loop = new Loop();
	int i;
	String fac, aux,op;
	Double vlr, vlr1;
	Variavel var;
	String ig[]=new String[2];
	public void comandos(Lerarq comando){		
		while(comando.ordem[i]!=null){// && !comando.ordem[i].equals(""))			
			fac=comando.ordem[i];			
			switch(fac){
				case("num"):{// no caso da criação das variaveis
					i++;
					while(!(comando.ordem[i].equals(";"))){
						fac = comando.ordem[i];
						aux = comando.ordem[i+1];						
						
						if(aux.equals("=")){ // se existir o "=" a nova variavel vai receber o valor  que vier depois do "=", não admite expressão.
							aux=comando.ordem[i+2];
							i=i+2;
							var = m.getVariavel(aux);
							if(var != null)
								vlr=var.getValor();
							else{
								try{	
									vlr1=Double.parseDouble(aux);
								}catch(NumberFormatException nFe){
									break;
								}
							}
						
						}else{
							vlr = 0.0;
						}
						m.criaVariavel(fac,vlr);
						i++;

					}
					break;
				}
				case("ler"):{// ler sua frase aqui será escrita até o caracter ":" abc;
					i++;
					while(!fac.equals(":")){
						fac=comando.ordem[i];
						i++;
						
						if(fac.equals("#")){							
							var=m.getVariavel(comando.ordem[i]);
							if(var!=null)
							System.out.print(var.getValor()+" ");
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

					fac=comando.ordem[i];
					// para fazer uma pausa,(ficar esperando o usuario precionar um numero e enter). mas o numero não tem importancia alguma, basta deixar o espaço entre o : e ; vazio.
					//ex: ler para prosseguir digite um numero e aperte enter:;
					// para fazer apenas impressão, sem leitura, colocar "|" entre : e ; 
					if(!fac.equals("|")){// para fazer uma leitura para dentro de uma variavel, basta coloca-la entre : e ; . ex: ler insira peso : xpeso;
						Scanner s = new Scanner(System.in);
						vlr=s.nextDouble();
						if(!fac.equals(";"))
							m.criaVariavel(fac,vlr);
					}
					break;
				}
				case("loop"):{// para fazer um laço a palavra loop deve ser seguida de uma expressão com no maximo duas variaveis e sem possibilidade de operação.
					int a=1, c=i;
					while(a>0){
						c++;
						if(comando.ordem[c].equals("loop"))
							a++;
						if(comando.ordem[c].equals("pool")){
							a=a-1;
						}
					}
					if(verifica(comando)){
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
						if(comando.ordem[c].equals("se"))
							a++;
						if(comando.ordem[c].equals("fimse")){
							a=a-1;
						}						
					}
					if(!verifica(comando))
						i=c;
					break;
				}
				case ("="):{ 
					fac=comando.ordem[i-1];
					i++;
					ig[0]=comando.ordem[i];
					i++;
					op =comando.ordem[i];
						i++;
						ig[1]=comando.ordem[i];
						var=(m.getVariavel(ig[0]));
						if(var!=null)
							vlr=var.getValor();	
						else{
							try{
								vlr=Double.parseDouble(ig[0]);
							}catch(NumberFormatException nFe){
								break;
							}
						}
					if(!(op.equals(";"))){
						var=(m.getVariavel(ig[1]));
						if(var!=null)
							vlr1=var.getValor();	
						else{
							try{	
								vlr1=Double.parseDouble(ig[1]);
							}catch(NumberFormatException nFe){
								break;
							}
						}
						vlr=m.operacao(vlr,vlr1,op);
					}else{
						i--;
						vlr=m.operacao(vlr,0,"+");
					}
					m.criaVariavel(fac,vlr);
					break;					
				}				
			}

			i++;

		}
	}

	public boolean verifica(Lerarq comando){
		i++;
		ig[0]=comando.ordem[i];
		i++;
		op=comando.ordem[i];
		i++;
		ig[1]=comando.ordem[i];

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

		return m.vdd(vlr,vlr1,op);
	}

}
