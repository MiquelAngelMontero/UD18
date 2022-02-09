package main;

import java.sql.Connection;

import metodos_mysql.Conexion;
import metodos_mysql.Metodos_BBDD;

public class mainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Antes de crear la base de datos la eliminamos si esta existe
		boolean borrardb = Metodos_BBDD.borrarBBDD("inv");
		boolean creardb = Metodos_BBDD.crearBBDD("inv");
		
		if(creardb) {		
			System.out.println("La base de datos se ha creado exitosamente");		
		}
		
		//Ejecutamos las sentencias de creacion de tablas
		boolean creart1 = Metodos_BBDD.ejecutarSentencia("inv",
				 "CREATE TABLE facultad ("
				 + "  CODIGO int NOT NULL,"
				 + "  NOMBRE varchar(100) DEFAULT NULL,"
				 + "  PRIMARY KEY (CODIGO)"
				 + ");"
				);
		
		boolean creart2 = Metodos_BBDD.ejecutarSentencia("inv", 
				"CREATE TABLE investigadores ("
				+ "  DNI varchar(9) NOT NULL,"
				+ "  facultad int DEFAULT NULL,"
				+ "  nomapels varchar(45) DEFAULT NULL,"
				+ "  PRIMARY KEY (DNI),"
				+ "  KEY facultad_idx (facultad)"
				+ ");");		
		boolean creart3 = Metodos_BBDD.ejecutarSentencia("inv",
				 "CREATE TABLE equipos ("
				 + "  numserie char(4) NOT NULL,"
				 + "  nombre_facultad varchar(45) DEFAULT NULL,"
				 + "  facultad int DEFAULT NULL,"
				 + "  PRIMARY KEY (numserie),"
				 + "  KEY id_idx (facultad),"
				 + "  CONSTRAINT id FOREIGN KEY (facultad) REFERENCES facultad (CODIGO)"
				 + ");"
				);
		
		boolean creart4 = Metodos_BBDD.ejecutarSentencia("inv", 
				"CREATE TABLE reserva ("
				+ "  dni varchar(9) NOT NULL,"
				+ "  numserie char(4) NOT NULL,"
				+ "  comienzo date DEFAULT NULL,"
				+ "  fin date DEFAULT NULL,"
				+ "  PRIMARY KEY (dni,numserie),"
				+ "  KEY serie_idx (numserie),"
				+ "  CONSTRAINT dni FOREIGN KEY (dni) REFERENCES investigadores (DNI),"
				+ "  CONSTRAINT serie FOREIGN KEY (numserie) REFERENCES equipos (numserie)"
				+ ");");	
		
		
		//Insertamos datos
		boolean insert1 = Metodos_BBDD.ejecutarSentencia("inv", "INSERT INTO facultad VALUES (1, \"facultad1\");");
		boolean insert2 = Metodos_BBDD.ejecutarSentencia("inv", "INSERT INTO investigadores VALUES (\"49874838M\", 1, \"Miquel Angel Montero\");");
		boolean insert3 = Metodos_BBDD.ejecutarSentencia("inv", "INSERT INTO equipos VALUES (\"ABCD\", \"facultad1\", 1);");
		boolean insert4 = Metodos_BBDD.ejecutarSentencia("inv", "INSERT INTO reserva VALUES (\"49874838M\", \"ABCD\", \"17/12/2015\", \"17/12/2020\");");
		
		//Mostramos las tablas
		Metodos_BBDD.mostrarValores("inv", "facultad", 2);
		Metodos_BBDD.mostrarValores("inv", "investigadores", 3);
		Metodos_BBDD.mostrarValores("inv", "equipos", 3);
		Metodos_BBDD.mostrarValores("inv", "reserva", 4);
	
	}

}
