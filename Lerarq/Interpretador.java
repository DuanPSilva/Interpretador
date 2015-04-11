import mypackage.Lerarq;
import java.util.StringTokenizer;
class Interpretador{
	Mem m= new Mem();
	public void comandos(Lerarq cm){
		String fac;
		Variavel var;
		String op;
		Double vlr=0.0;
		int i=0;
		while(cm.ordem[i]!=null){// && !cm.ordem[i].equals(""))

			fac=cm.ordem[i];
			
			switch(fac){
				case("int"):{
					i++;					
					op=cm.ordem[i];
					i++;
					
					if(cm.ordem[i].equals("=")){
						i++;
						fac=cm.ordem[i];
						if(fac.indexOf(';')!=-1){//fim de linha
							StringTokenizer tokens = new StringTokenizer(fac,";");
							fac=tokens.nextToken();
							vlr=Double.parseDouble(fac);
						}else{
							vlr=Double.parseDouble(fac);
						}
			
					}else{
						StringTokenizer tokens = new StringTokenizer(op,";");
						if(tokens.hasMoreTokens()){
							op=tokens.nextToken();
						}
					}
					m.criaVariavel(op,vlr);			

					var=m.getVariavel(op);
					System.out.println(var.getNome()+" "+var.getValor());
				}default:
					System.out.println("\t"+i+"\n");	
			}
			i++;

		}
	}
}