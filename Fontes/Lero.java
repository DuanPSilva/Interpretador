/* Universidade Federal da Fronteira Sul
   Ciência da Computação
   Disciplina: Programação I
   Professor: Fernando Bevilacqua
   Acadêmicos:  Duan Pedroso da Silva
				Jardel Anton

   ** Interpretador **
*/



import java.io.File;

public class Lero{
	public static void main(String args[]){
		
		String arquivo = args[0];
		if(arquivo.indexOf(".lero")!=-1){
			Interpretador inter= new Interpretador();
			File file = new File(arquivo);
			Lerarq leia = new Lerarq(file);
			leia.separa();
			inter.comandos(leia);
		}else{
			System.out.println("Arquivo nao eh .lero");
		}

	}	
}