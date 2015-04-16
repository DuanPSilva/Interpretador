

  /*Verifica se contem somente numeros em uma String      
             public boolean containsOnlyNumbers(String str) {  
                      
                    //verifica se é vazio ou nulo  
                    if (str == null || str.length() == 0)  
                        return false;  
                      
                    for (int i = 0; i < str.length(); i++) {  
  
                        //Se o caracter for diferente de um digito, retorna falso.  
                        if (!Character.isDigit(str.charAt(i)))  
                            return false;  
                    }  
                     return true;  
                }  */
                


  /* String character = in.next();
char c = character.charAt(0);
...
if (Character.isDigit(c)) { 
    ... 
} else if (Character.isLetter(c)) {
    ...
}
...
*/

  import java.util.Scanner;

  public class lervar{
  	public static void main(String[]args){
  		Scanner entrada = new Scanner(System.in);
  		String nome;

  		System.out.println("Digite um nome: ");
  		nome = entrada.nextLine();

  		char [] c= nome.toCharArray();
  		boolean nomeValido = false;

  		for (int i = 0; i < c.length; i++){
  		  /*
       	if (c[i] >= '0' && c [i] <='9'){
  				temNumero = true;
  				break;
  			}
        */

        if(!Character.isDigit(c[i])){
          nomeValido = true;
          break;
        }



  		}

  		if (nomeValido){
  			System.out.println("Variável válida: " + nome);
  		}else{
  			System.out.println("Variável inválida: " + nome);
  		}	

  	}

  }