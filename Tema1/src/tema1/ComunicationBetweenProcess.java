package tema1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class ComunicationBetweenProcess 
{
	public  static void main (String[] args) throws IOException
	{
		Process proceso1, proceso2;
		InputStream isPr1;
		InputStreamReader isr1;
		BufferedReader br1,br2;
		OutputStream osPr2;
		String comando1 = "ls -la";
		String comando2 = "grep w";
		PrintStream ps ;
		
		try 
		{
			proceso1 = Runtime.getRuntime().exec(comando1);
			isPr1 = proceso1.getInputStream();
			isr1 = new InputStreamReader(isPr1);
			br1 = new BufferedReader(isr1);
			
			
			proceso2 = Runtime.getRuntime().exec(comando2);
			osPr2 = proceso1.getOutputStream();
			ps = new PrintStream(osPr2);
			br2 = new BufferedReader();
			System.out.println("Salida del proceso:"+Arrays.toString(args)+": ");
			
			String line;
			
			while((line = br1.readLine()) != null)
			{
				System.out.println(line);
				ps.flush();
				
			}
			while((line = br2.readLine()) != null)
			{
				System.out.println(line);
				
			}
			
			isPr1.close();
			isPr2.close();
			
		} catch (InterruptedException e) 
		{
			// TODO: handle exception
		}
		
		
	}

}