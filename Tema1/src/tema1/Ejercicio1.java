package tema1;

import java.io.IOException;

public class Ejercicio1 {

	public static void main(String[] args) 
	{
		
		String comando = "ifconfig";
		try
		{
			Process hijo = Runtime.getRuntime().exec(comando);
			
		}catch(IOException e)
		{
			
		}
		
		
	}
}
