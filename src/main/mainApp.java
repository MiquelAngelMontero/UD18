package main;

import java.sql.Connection;

import metodos_mysql.Conexion;
import metodos_mysql.Metodos_BBDD;

public class mainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Antes de crear la base de datos la eliminamos si esta existe
		boolean borrardb = Metodos_BBDD.borrarBBDD("cient");
		boolean creardb = Metodos_BBDD.crearBBDD("cient");
		
		if(creardb) {		
			System.out.println("La base de datos se ha creado exitosamente");		
		}
		
		//Ejecutamos las sentencias de creacion de tablas
		boolean creart1 = Metodos_BBDD.ejecutarSentencia("cient",
				 "CREATE TABLE cientifico ("
				 + "	dni varchar(9) not null,"
				 + "    nomApels nvarchar(255),"
				 + "    primary key (dni)"
				 + ");"
				);
		
		boolean creart2 = Metodos_BBDD.ejecutarSentencia("cient", 
				"CREATE TABLE proyecto ("
				+ "	id char(4) not null,"
				+ "    nombre nvarchar(255),"
				+ "    horas int,"
				+ "    primary key (id)"
				+ ");");		
		
		boolean creart3 = Metodos_BBDD.ejecutarSentencia("cient", 
				"CREATE TABLE asignado_a ("
				+ "	cientifico varchar(9) not null,"
				+ "    proyecto char(4) not null,"
				+ "    primary key (cientifico),"
				+ "    constraint cient"
				+ "		foreign key (cientifico)"
				+ "        references cientifico (dni)"
				+ "        on update cascade"
				+ "        on delete no action,"
				+ "	constraint proy"
				+ "		foreign key (proyecto)"
				+ "		references proyecto (id)"
				+ "        on update cascade"
				+ "        on delete no action"
				+ ");");	
		
		//Insertamos datos
		boolean insert1 = Metodos_BBDD.ejecutarSentencia("cient", "INSERT INTO cientifico VALUES (\"49874838M\", \"Miquel Angel Montero\");");
		boolean insert2 = Metodos_BBDD.ejecutarSentencia("cient", "INSERT INTO proyecto VALUES (\"ABCD\", \"Pau Robuste\", 30);");
		boolean insert3 = Metodos_BBDD.ejecutarSentencia("cient", "INSERT INTO asignado_a VALUES (\"49874838M\", \"ABCD\");");
		
		//Mostramos las tablas
		Metodos_BBDD.mostrarValores("cient", "cientifico", 2);
		Metodos_BBDD.mostrarValores("cient", "proyecto", 3);
		Metodos_BBDD.mostrarValores("cient", "asignado_a", 2);
	
	}

}
