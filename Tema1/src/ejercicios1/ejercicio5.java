package ejercicios1;

import java.io.IOException;

public class ejercicio5 
{
	/*
	  5.- Modificar el programa anterior para que admita como parámetros 
	  de entrada más de una aplicación y espere a que todas terminen 
	  para mostrar el mensaje por pantalla “Aplicaciones finalizadas.”.
	 
	 */

	
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
			
		}catch (Exception e) {
			// TODO: handle exception
		}

	}

}
