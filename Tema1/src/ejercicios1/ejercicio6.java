package ejercicios1;

import java.io.IOException;

public class ejercicio6 
{

	public static void main(String[] args) throws IOException
	{
		if(args.length < 0)
		{
			
		}			
		try
		{
			int appsIniciadas = 0;
			Process[] process = new Process[args.length];
			
			for(String cmd:args)
			{
				process[appsIniciadas] = new ProcessBuilder(cmd).start();
				appsIniciadas++;
				System.out.println("Aplicacion: "+cmd+" turno: "+appsIniciadas);
				
				
			}
			for (int i = 0; i < process.length; i++) 
			{
				process[i].waitFor();			
			}
			
			System.out.println("Las aplicaciones se han cerrado todas.");
			
		} catch (Exception e)
		{
						
		}

	}
}
