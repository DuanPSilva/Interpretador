package mypackage;

import java.io.BufferedReader;  
import java.io.FileInputStream;  

import java.io.IOException;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
import java.io.FileReader;

 
public class Lerarq{  
      
    FileReader fileR;
    BufferedReader buff;

    public Lerarq()
    {
            try {
                fileR = new FileReader("arq.duan");
                buff = new BufferedReader(fileR);
                while (buff.ready())
                {
                    System.out.println(buff.readLine());
                }
                buff.close();
            }
            catch(IOException e){
            
            }
            
    }
}

  