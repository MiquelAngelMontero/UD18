package main;

import java.sql.Connection;

import metodos_mysql.Conexion;
import metodos_mysql.Metodos_BBDD;

public class mainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Antes de crear la base de datos la eliminamos si esta existe
		boolean borrardb = Metodos_BBDD.borrarBBDD("alm");
		boolean creardb = Metodos_BBDD.crearBBDD("alm");
		
		if(creardb) {		
			System.out.println("La base de datos se ha creado exitosamente");		
		}
		
		//Ejecutamos las sentencias de creacion de tablas
		boolean creart1 = Metodos_BBDD.ejecutarSentencia("alm",
				 "CREATE TABLE almacen ("
				 + "  codigo int NOT NULL,"
				 + "  lugar varchar(100) NOT NULL,"
				 + "  capacidad int DEFAULT NULL,"
				 + "  PRIMARY KEY (codigo)"
				 + ");"
				);
		
		boolean creart2 = Metodos_BBDD.ejecutarSentencia("alm", 
				"CREATE TABLE cajas ("
				+ "  numReferencia char(5) NOT NULL,"
				+ "  contenido varchar(100) NOT NULL,"
				+ "  valor int DEFAULT NULL,"
				+ "  almacen int NOT NULL,"
				+ "  PRIMARY KEY (numReferencia),"
				+ "  KEY almacen_idx (almacen),"
				+ "  CONSTRAINT almacen FOREIGN KEY (almacen) REFERENCES almacen (codigo)"
				+ ");");		
		
		
		//Insertamos datos
		boolean insert1 = Metodos_BBDD.ejecutarSentencia("alm", "INSERT INTO almacen VALUES (1, \"Reus\", 30000);");
		boolean insert2 = Metodos_BBDD.ejecutarSentencia("alm", "INSERT INTO cajas VALUES (\"ABCDE\", \"contenido\", 300, 1);");
		
		//Mostramos las tablas
		Metodos_BBDD.mostrarValores("alm", "almacen", 3);
		Metodos_BBDD.mostrarValores("alm", "cajas", 4);
	
	}

}
