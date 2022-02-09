package metodos_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	//metodo de conexión
	public static Connection conectar() {
		Connection con = null;
		
		String password = "G@rba123";
		String usuario = "remote";
		String url = "jdbc:mysql://192.168.42.135:3306?user=" + usuario
				+ "&password=" + password;
		try {
			con = DriverManager.getConnection(url);
			if (con != null) {
				System.out.println("Conectado");
			}
		} catch (SQLException e) {
			System.out.println("No se pudo conectar a la base de datos");
			e.printStackTrace();
		}
		return con;
	}
	
}
