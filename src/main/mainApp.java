package main;

import java.sql.Connection;

import metodos_mysql.Conexion;
import metodos_mysql.Metodos_BBDD;

public class mainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Antes de crear la base de datos la eliminamos si esta existe
		boolean borrardb = Metodos_BBDD.borrarBBDD("PelSal");
		boolean creardb = Metodos_BBDD.crearBBDD("PelSal");
		
		if(creardb) {		
			System.out.println("La base de datos se ha creado exitosamente");		
		}
		
		//Ejecutamos las sentencias de creacion de tablas
		boolean creart1 = Metodos_BBDD.ejecutarSentencia("PelSal",
				 "CREATE TABLE peliculas ("
				 + "codigo int not null,"
				 + "nombre nvarchar(100),"
				 + "calificacionEdad int,"
				 + "primary key (codigo));"
				);
		
		boolean creart2 = Metodos_BBDD.ejecutarSentencia("PelSal", 
				"CREATE TABLE salas ("
				+ "codigo int not null,"
				+ "nombre nvarchar(100),"
				+ "pelicula int not null,"
				+ "primary key (codigo),"
				+ "CONSTRAINT id_pel FOREIGN KEY (pelicula) REFERENCES peliculas (codigo));");		
		
		
		//Insertamos datos
		boolean insert1 = Metodos_BBDD.ejecutarSentencia("PelSal", "INSERT INTO peliculas VALUES (1, \"pelicula1\", 1);");
		boolean insert2 = Metodos_BBDD.ejecutarSentencia("PelSal", "INSERT INTO salas VALUES (1, \"sala1\", 1);");
		
		//Mostramos las tablas
		Metodos_BBDD.mostrarValores("PelSal", "peliculas", 3);
		Metodos_BBDD.mostrarValores("PelSal", "salas", 3);
	
	}

}
