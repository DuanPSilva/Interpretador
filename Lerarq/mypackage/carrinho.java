package mypackage;

import java.io.BufferedReader;  
import java.io.FileInputStream;  

import java.io.IOException;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
import java.io.FileReader;

import java.util.StringTokenizer;
 
public class Lerarq{  
      
    FileReader fileR;
    BufferedReader buff;
    String linha;
    String arquivo;



    public Lerarq()
    {
            try {
                fileR = new FileReader("arq.duan"); //IMPRIME POR LINHA
                buff = new BufferedReader(fileR);
                System.out.println("\nPOR LINHAS!\n");
                while (buff.ready())
                {
                    linha = buff.readLine();
                    arquivo += linha;
                    
                    System.out.println(linha);
                }
                buff.close();
            }
            catch(IOException e){
            
            }

        System.out.println("\nAGORA TUDOXUNTO!\n"); //IMPRIME TUDOXUNTO
        System.out.println(arquivo);



        StringTokenizer tokens = new StringTokenizer(arquivo," "); // IMPRIME POR TOKENS
        System.out.println("\nAGORA POR TOOKENS!\n");     
        while(tokens.hasMoreTokens())
        {
            System.out.println(tokens.nextToken());
        }
            
    }





}

  