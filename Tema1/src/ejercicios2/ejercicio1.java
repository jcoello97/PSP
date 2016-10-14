package ejercicios2;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

/*Ejercicio 1: Escribe un programa Aleatorios que haga lo siguiente:
- Cree un proceso hijo que esté encargado de generar números aleatorios.
Este proceso hijo escribirá en su salida estándar un número aleatorio del 0 al 10 cada vez
que reciba una petición de ejecución por parte del padre.
- El proceso padre lee líneas de la entrada estándar y por cada línea que lea solicitará al hijo
que le envíe un número aleatorio, lo leerá y lo imprimirá en pantalla.
- Cuando el proceso padre reciba la palabra “fin”, finalizará la ejecución del hijo y procederá
a finalizar su ejecución.*/

public class ejercicio1 
{

	public static void main(String[] args) throws IOException
	{
		if (args.length < 0) {
			System.out.println("Necesitamos argumentos");
		}
		try 
		{
			//CREAMOS EL HIJO
			Process process = new ProcessBuilder(args).start();
			
			//LEEMOS LA SALIDA ESTANDAR DEL HIJO
			InputStream is = process.getInputStream();
			
			//LEEMOS LA ENTRADA ESTANDAR DEL HIJO
			InputStreamReader isr = new InputStreamReader(is);
			
			//GUARDAMOS LA INFORMACION DE LA ENTRADA ESTANDAR EN UN BUFFER
			BufferedReader br = new BufferedReader(isr);
			
			
			PrintStream ps = new PrintStream(process.getOutputStream());
			
			BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
			
			
			String line;
			
			while ((line = br2.readLine()).compareTo("fin") != 0) 
			{
				ps.println(line);
				ps.flush();
				if ((line = br.readLine()) != null) 
				{
					System.out.println(line);
				}
			}
			System.out.println("ACABO");

			
			
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

	}

}
