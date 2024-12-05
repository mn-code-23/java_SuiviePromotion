package promosrt;

import java.sql.*;

public class ConnecBase {
	Connection con;
	String user = "root";
	String passwd = "";
	String url = "jdbc:mysql://localhost/promotionsrt";
	
	public ConnecBase() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection(url,user,passwd);
			 System.out.println("Connection reussi");
		}catch (Exception e) {
			System.out.println("Connection echoue");
		}
	}
}