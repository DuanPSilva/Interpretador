import mypackage.Lerarq;	


public class Main
{
	

	public static void main(String args[])
	{
		Interpretador inter= new Interpretador();
		Lerarq leia = new Lerarq();
		leia.separa();
		inter.comandos(leia);
	}
	
}