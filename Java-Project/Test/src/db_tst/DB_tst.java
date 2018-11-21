package db_tst;


import java.sql.*;


public class DB_tst {
	static String username = "ciao";
	static String password = "ciao";
	
	
	static Connection connection;

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
			Class.forName("org.postgresql.Driver");
			
			
			String url = "jdbc:postgresql://localhost:5432/usr_lgn";
			String usrname= "db";
			String pswrd="falsarone";
			connection = DriverManager.getConnection(url,usrname,pswrd);
			
			Statement s = connection.createStatement();
			String sql = "select * from usr_lgn";
			ResultSet ss =s.executeQuery(sql);
			while(ss.next()) {
				
				String nu = ss.getString("username");
				System.out.print(nu);
				
			}
			ResultSet rs = s.executeQuery(sql);

		
		

	}

}
