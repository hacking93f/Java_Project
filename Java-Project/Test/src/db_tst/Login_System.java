
/*
 * Simple log in system coded by Neo0Hacker 
 * all rights reserved
 * 
 * prendere spunto da questo login system, per poi poterlo implementare nei veri progetti! 
 * comunque credo che la teoria di base per un sistema di login sia questa
 */


package db_tst;


import java.sql.*;


public class Login_System {
	
	static String username = "ciao1";
	static String password = "ciao1";
	
	


	static Connection connection;

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
			Class.forName("org.postgresql.Driver");
			
			
			String url = "jdbc:postgresql://localhost:5432/usr_lgn";
			String usrname= "db";
			String pswrd="falsarone";
			connection = DriverManager.getConnection(url,usrname,pswrd);
			
			Statement s = connection.createStatement();

			Statement ps = connection.createStatement();
			
			Statement st = connection.createStatement();
			
			String send = "INSERT INTO usr_lgn VALUES("+"'"+username+"'"+","+"'"+password+"'"+")" ;
			
			st.execute(send);
			
			String getnmsql = "select username from usr_lgn";
			String getpwsql = "select passwo from usr_lgn";
			ResultSet rs =s.executeQuery(getnmsql);
		    ResultSet pwr= ps.executeQuery(getpwsql);
		    
		    
		    while(rs.next() & pwr.next()) {
		    	String nome = rs.getString("username");
		    	String pws = pwr.getString("passwo");
		    	
		    	if(nome.contentEquals(username) & pws.contentEquals(password)) {
		    		System.out.println("logged");
		    		
		    		
		    		break;
		    	}
		    	
		    }System.out.println("no username and password found ");



}
	}
