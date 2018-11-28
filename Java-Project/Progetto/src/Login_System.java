
/*
 * Simple log in system coded by Neo0Hacker 
 * all rights reserved
 * 
 * prendere spunto da questo login system, per poi poterlo implementare nei veri progetti! 
 * comunque credo che la teoria di base per un sistema di login sia questa
 */


package src;


import java.io.IOException;
import java.sql.*;


public class Login_System extends Thread {
	
	static String username = "ciao1";
	static String password = "ciao1";
	
	
	static Connection connection;
	
	
	static void checkUsernamePassword() throws SQLException, ClassNotFoundException{
		Class.forName("org.postgresql.Driver");
		
		
		String url = "jdbc:postgresql://localhost:5432/usr_lgn";
		String usrname= "db";
		String pswrd="falsarone";
		connection = DriverManager.getConnection(url,usrname,pswrd);
		
		
		//nel caso in cui l'auto commit è settato su false 

		//connection.setAutoCommit(false); <--------
		
		//devo usare il connection.commit(); per inviare le istruzioni 
		//e inserire il tutto in un blocco try catch 
		//successivamente inserire nel blocco catch il connection.rollback();
		// cosi che in caso di errori il database 
		//torna alle impostazioni iniziali 
		// principio dell atomicita 
		// del paradigma ACID
	
		
		
		//da la possibilità di inviare e riceveredati dal server postgre
		Statement s = connection.createStatement();

		Statement ps = connection.createStatement();
		String getnmsql = "select username from usr_lgn";
		String getpwsql = "select passwo from usr_lgn";
		ResultSet rs =s.executeQuery(getnmsql);
	    ResultSet pwr= ps.executeQuery(getpwsql);
	    
	    while(rs.next() & pwr.next()) {
	    	String nome = rs.getString("username");
	    	String pws = pwr.getString("passwo");
	    	
	    	if(nome.contentEquals(username) & pws.contentEquals(password)) {
	    		System.out.println("logged in");
	    		
	    		ServerFrame window = new ServerFrame();
				window.frame.setVisible(true);

				
				try {
					window.serverStart();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		
	    		break;
	    	}
	    	
	    	//a fine ciclo se non trova user e pass
	    }System.out.println("Incorrect Username or Password : contact hacking93f@gmail.com for more info");
	    

		
	}

	public void run() {
		// TODO Auto-generated method stub
		
		
		try {
			Login_System.checkUsernamePassword();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
	}
