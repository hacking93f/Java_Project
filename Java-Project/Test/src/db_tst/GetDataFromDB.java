package db_tst;


import java.sql.*;


public class GetDataFromDB {
	
	static String username = "ciao2";
	
	


	static Connection connection;

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
			Class.forName("org.postgresql.Driver");
			
			
			String url = "jdbc:postgresql://localhost:5432/usr_lgn";
			String usrname= "db";
			String pswrd="falsarone";
			connection = DriverManager.getConnection(url,usrname,pswrd);
			
			Statement s = connection.createStatement();
			
			Statement ss =connection.createStatement();

			String inv = "SELECT username FROM public.dati";
			String inv2 = "SELECT dato FROM public.dati";
			
			ResultSet rs = s.executeQuery(inv);
			ResultSet rss = ss.executeQuery(inv2);
			
			while(rs.next() & rss.next() ) {
				String nm = rs.getString("username");
				String v = rss.getString("dato");
				
				Integer w = Integer.parseInt(v);
				
				
				if(username.contentEquals(nm)) {
					System.out.print(v);
				}break;
			}
			
		
	}
}
