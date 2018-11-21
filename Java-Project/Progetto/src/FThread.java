package src;

//devo sistemare questo metodo 
/*
 * in questo modo posso fare il trasferimento di un solo file dopo di che il thread muore
 * e non solo... sembrerebbe che manda in crash tutti i flussi in out creati dei socket,
 * devo sistemare.
 * ps la classe del client referente a questa è Clientftthread
 */

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class FThread extends Thread {
	
	static int len ;
	static BufferedOutputStream fos;
	static byte[] read;
	static int current = 0;
	
		public void getDownload() {
			
			 try {
				 
					do {
						
					
						len=ServerFTThread.FTin.read(read,current, (read.length-current));

						if(len >= 0) { current += len;
						
						}
						
					}
					while(len < -1 );
					
			      fos =new BufferedOutputStream (new FileOutputStream("filedumped"));
					//i parametri dopo la virgola servono per non far scrivere piu byte del dovuto!

			    
			      fos.flush();
			      
			      fos.write(read,0, current);
			  
					 }catch(Exception e) {
						 System.out.println(e);
					 }
					 
					try {
			
						fos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			             	
		}

	
	public void run() {
	
		 try {
	
	    read = new byte[6022386];

		len = ServerFTThread.FTin.read(read) ;

		current = len;	
	
		 } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		 
	}     	
	
}

