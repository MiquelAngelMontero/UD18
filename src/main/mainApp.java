package main;

import java.sql.Connection;

import metodos_mysql.Conexion;
import metodos_mysql.Metodos_BBDD;

public class mainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Antes de crear la base de datos la eliminamos si esta existe
		boolean borrardb = Metodos_BBDD.borrarBBDD("dir");
		boolean creardb = Metodos_BBDD.crearBBDD("dir");
		
		if(creardb) {		
			System.out.println("La base de datos se ha creado exitosamente");		
		}
		
		//Ejecutamos las sentencias de creacion de tablas
		boolean creart1 = Metodos_BBDD.ejecutarSentencia("dir",
				 "CREATE TABLE despachos ("
				 + "	numero int not null,"
				 + "    capacidad int,"
				 + "    primary key (numero)"
				 + ");"
				);
		
		boolean creart2 = Metodos_BBDD.ejecutarSentencia("dir", 
				"CREATE TABLE director ("
				+ "	dni varchar(9) not null,"
				+ "    nomApels nvarchar(255),"
				+ "    dniJefe varchar(9) not null,"
				+ "    despacho int not null,"
				+ "    primary key (dni),"
				+ "    constraint despacho"
				+ "		foreign key (despacho)"
				+ "        references despachos (numero)"
				+ "        on update cascade"
				+ "        on delete no action,"
				+ "	constraint dniJ"
				+ "		foreign key (dniJefe)"
				+ "        references director (dni)"
				+ "        on update cascade"
				+ "        on delete no action);");		
		
		
		//Insertamos datos
		boolean insert1 = Metodos_BBDD.ejecutarSentencia("dir", "INSERT INTO despachos VALUES (1, 5000);");
		boolean insert2 = Metodos_BBDD.ejecutarSentencia("dir", "INSERT INTO director VALUES (\"49874838M\", \"Miquel Angel Montero\", \"49874838M\", 1);");
		
		//Mostramos las tablas
		Metodos_BBDD.mostrarValores("dir", "despachos", 2);
		Metodos_BBDD.mostrarValores("dir", "director", 4);
	
	}

}
