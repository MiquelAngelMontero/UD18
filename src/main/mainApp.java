package main;

import java.sql.Connection;

import metodos_mysql.Conexion;
import metodos_mysql.Metodos_BBDD;

public class mainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean borrardb = Metodos_BBDD.borrarBBDD("tienda_i");
		boolean creardb = Metodos_BBDD.crearBBDD("tienda_i");
		
		if(creardb) {		
			System.out.println("La base de datos se ha creado exitosamente");		
		}
		
		boolean creart1 = Metodos_BBDD.ejecutarSentencia("tienda_i",
				 " CREATE TABLE fabricantes ("
				+ "  codigo int NOT NULL,"
				+ "  nombre varchar(100) NOT NULL,"
				+ "  PRIMARY KEY (codigo)"
				+ ");"
				);
		
		boolean creart2 = Metodos_BBDD.ejecutarSentencia("tienda_i", 
				"CREATE TABLE articulos ("
				+ "  codigo int NOT NULL,"
				+ "  nombre varchar(100) NOT NULL,"
				+ "  precio int NOT NULL,"
				+ "  fabricante int NOT NULL,"
				+ "  PRIMARY KEY (codigo),"
				+ "  KEY fabricante_idx (fabricante),"
				+ "  CONSTRAINT fabricante FOREIGN KEY (fabricante) REFERENCES fabricantes (codigo));");		
	
		boolean insert1 = Metodos_BBDD.ejecutarSentencia("tienda_i", "INSERT INTO fabricantes VALUES (1, \"nombre2\");");
		boolean insert2 = Metodos_BBDD.ejecutarSentencia("tienda_i", "INSERT INTO articulos VALUES (1, \"nombre1\", 30, 1);");
		
		//Metodos_BBDD.mostrarValores("tienda_i", "fabricantes");
		Metodos_BBDD.mostrarValores("tienda_i", "articulos");
	
	}

}
