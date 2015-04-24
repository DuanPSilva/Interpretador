import mypackage.Lerarq;	
import java.io.File;

public class Lero{
	public static void main(String args[]){
		Interpretador inter= new Interpretador();
		String arquivo = args[0];
		File file = new File(arquivo);
		Lerarq leia = new Lerarq(file);
		leia.separa();
		inter.comandos(leia);
	}	
}