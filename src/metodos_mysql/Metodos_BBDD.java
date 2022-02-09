package metodos_mysql;

import java.sql.Connection;
import java.sql.SQLException;

public class Metodos_BBDD {

	//Metodo para ejecutar create en la base de datos
	public static boolean crearBBDD(String nombre) {
		
		boolean crear = false;
		java.sql.Statement stm= null;
		Connection con=null;
		
		String sql="CREATE DATABASE "+ nombre;
		
		try {	
			con=Conexion.conectar();
			System.out.println("Ejecutando: " +sql+ "...");
			stm= con.createStatement();
			stm.execute(sql);
			crear=true;
			stm.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("No se ha podido crear la BBDD");
			e.printStackTrace();
		}
		return crear;
		
	}
	
	//metodo para ejecutar cualquier sentencia sql
	public static boolean ejecutarSentencia(String bbdd, String sql) {
		
		boolean exito = false;
		java.sql.Statement stm= null;
		Connection con=null;
		
		
		
		try {			
			con=Conexion.conectar();
			System.out.println("Ejecutando: " +sql+ "...");
			stm= con.createStatement();
			stm.execute("USE "+bbdd+";");
			exito=true;
			java.sql.Statement stm2= con.createStatement();
			stm2.execute(sql);
			con.close();
			
		} catch (SQLException e) {
			System.out.println("No se ha podido ejecutar la sentencia");
			e.printStackTrace();
		}
		return exito;
		
	}
	
	//Metodo para borrar una base de datos
	public static boolean borrarBBDD(String nombre) {
		
		boolean borrar = false;
		java.sql.Statement stm= null;
		Connection con=null;
		
		String sql="DROP DATABASE "+ nombre;
		
		try {	
			con=Conexion.conectar();
			System.out.println("Ejecutando: " +sql+ "...");
			stm= con.createStatement();
			stm.execute(sql);
			borrar=true;
			stm.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("No se ha podido borrar la BBDD");
			e.printStackTrace();
		}
		return borrar;
		
	}
	
	//Muestra los valores de la tabla indicada por parametro
	public static void mostrarValores(String bbdd, String tabla, int col) {
		
		System.out.println("VALORES DE LA TABLA "+ tabla.toUpperCase());
		
		java.sql.Statement stmsql= null;
		Connection con=null;
		java.sql.Statement stm= null;
		
		String sql="USE "+ bbdd;
		String query = "SELECT * FROM "+ tabla;
		
		try {	
			con=Conexion.conectar();
			stm= con.createStatement();
			stm.executeUpdate(sql);
			java.sql.Statement stm2= con.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = stm2.executeQuery(query);
			
			String resultat = "";
			
			while (resultSet.next()) {
				
				for(int i=1; i<col+1; i++) {
					resultat = resultat +" "+resultSet.getString(i);
				}
				
			}
			
			System.out.println(resultat);
			
			con.close();
			
		} catch (SQLException e) {
			System.out.println("No se ha podido crear la BBDD");
			e.printStackTrace();
		}
		
	}
	
}
