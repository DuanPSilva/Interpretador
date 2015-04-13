/*import java.util.StringTokenizer;
class Numero{
	public int aplica(Lerarq cm,Mem m,int i, int y){
		String op;
		Double vlr;
		while(i<=y){
			if(cm.ordem[i+1].equals("=")){ // o codigo está escrito com espaços. ex: int abc = 3;
				op=cm.ordem[i];
				i++;
				fac=cm.ordem[i];
				if(fac.indexOf(';')!=-1){//fim de linha
					StringTokenizer tokens = new StringTokenizer(fac,";");
					fac=tokens.nextToken();
					vlr=Double.parseDouble(fac);// converte a string em double
				}else{
					vlr=Double.parseDouble(fac);
				}
			}

			i++;
		}
		m.criaVariavel(op,vlr);

		return y+1;
	}
}
*/