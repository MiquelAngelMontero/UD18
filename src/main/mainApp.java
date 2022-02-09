package main;

import java.sql.Connection;

import metodos_mysql.Conexion;
import metodos_mysql.Metodos_BBDD;

public class mainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Antes de crear la base de datos la eliminamos si esta existe
		boolean borrardb = Metodos_BBDD.borrarBBDD("g_alm");
		boolean creardb = Metodos_BBDD.crearBBDD("g_alm");
		
		if(creardb) {		
			System.out.println("La base de datos se ha creado exitosamente");		
		}
		
		//Ejecutamos las sentencias de creacion de tablas
		boolean creart1 = Metodos_BBDD.ejecutarSentencia("g_alm",
				 "CREATE TABLE productos ("
				 + "	codigo int not null,"
				 + "    nombre nvarchar(100),"
				 + "    precio int,"
				 + "    primary key (codigo)"
				 + ");"
				);
		
		boolean creart2 = Metodos_BBDD.ejecutarSentencia("g_alm", 
				"CREATE TABLE cajeros ("
				+ "	codigo int not null,"
				+ "    nomApels nvarchar(255),"
				+ "    primary key (codigo)"
				+ ");");		
		
		boolean creart3 = Metodos_BBDD.ejecutarSentencia("g_alm", 
				"CREATE TABLE maquinas_registradoras ("
				+ "	codigo int not null,"
				+ "    piso int,"
				+ "    primary key (codigo)"
				+ ");");
		
		boolean creart4 = Metodos_BBDD.ejecutarSentencia("g_alm", 
				"CREATE TABLE venta ("
				+ "	cajero int not null,"
				+ "    maquina int not null,"
				+ "    producto int not null,"
				+ "    primary key (cajero),"
				+ "    constraint cajero"
				+ "		foreign key (cajero)"
				+ "        references cajeros (codigo)"
				+ "        on update cascade "
				+ "        on delete no action,"
				+ "	constraint maquina"
				+ "		foreign key (maquina)"
				+ "        references maquinas_registradoras (codigo)"
				+ "        on update cascade"
				+ "        on delete no action,"
				+ "	constraint producto"
				+ "		foreign key (producto)"
				+ "        references productos (codigo)"
				+ "        on update cascade"
				+ "        on delete no action"
				+ ");");
		
		
		//Insertamos datos
		boolean insert1 = Metodos_BBDD.ejecutarSentencia("g_alm", "INSERT INTO productos VALUES (1, \"producto1\", 40);");
		boolean insert2 = Metodos_BBDD.ejecutarSentencia("g_alm", "INSERT INTO cajeros VALUES (1, \"Miquel Angel Montero\");");
		boolean insert3 = Metodos_BBDD.ejecutarSentencia("g_alm", "INSERT INTO maquinas_registradoras VALUES (1, 2);");
		boolean insert4 = Metodos_BBDD.ejecutarSentencia("g_alm", "INSERT INTO venta VALUES (1, 1, 1);");
		
		//Mostramos las tablas
		Metodos_BBDD.mostrarValores("g_alm", "productos", 3);
		Metodos_BBDD.mostrarValores("g_alm", "cajeros", 2);
		Metodos_BBDD.mostrarValores("g_alm", "maquinas_registradoras", 2);
		Metodos_BBDD.mostrarValores("g_alm", "venta", 3);
	
	}

}
