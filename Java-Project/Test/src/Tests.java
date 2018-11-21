import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;

public class Tests {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		
		try {
			File file = File.createTempFile("ciao",".java");
			File files = new File("src");
			File Subdir = new File(files.getPath() + files.separator + "newcart");
			Subdir.mkdir();
			File filess = new File(Subdir.getPath() + Subdir.separator +  "newfile.txt");
			filess.createNewFile();
			file.deleteOnExit();
			FileWriter fw = new FileWriter(file);
			String writing = "ciao";
			fw.write(writing);
			byte[] bufread = new byte[1024];
			FileInputStream fiss = new FileInputStream(file.getName());
			fiss.read(bufread);
			
		
			Socket sock = new Socket ("127.0.0.1",5000);
			
			sock.getOutputStream().write(bufread);
			
			
			
			byte[]read = new byte[1024];
			sock.getInputStream().read(read);
			FileOutputStream foos = new FileOutputStream("out.java");
			foos.write(read);
			
			
			
//			--------------------------------------------------------------------
			
			
			DataInputStream dis = new DataInputStream(sock.getInputStream());
			DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
			FileInputStream fis = new FileInputStream("inputStream.txt");
			FileOutputStream fos = new FileOutputStream("out");
			byte[] buffer = new byte[1024];
			
			int len = fis.read(buffer);
		
			if (len>0) {
				
				dos.write(buffer);
			
		 	    dis.read(buffer);
				fos.write(buffer);
				
				
			}
			
			File fifi = new File("src");
			File fififi = new File(fifi.getPath() + fifi.separator + "new file.txt");
			fififi.createNewFile();
			File newdir = new File(fifi.getPath() + fifi.separator + "new cart");
			newdir.mkdir();
			FileWriter fiw = new FileWriter(fififi);
			String towrite = "salve";
			fiw.write(towrite);
			
			FileInputStream fisss = new FileInputStream(fififi.getPath()+ fififi.separator + "new file.txt");
			byte[] readin = new byte[1024];
			fisss.read(readin);
			
			dos.write(readin);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
  
	}

}
