package main;

import java.sql.Connection;

import metodos_mysql.Conexion;
import metodos_mysql.Metodos_BBDD;

public class mainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Antes de crear la base de datos la eliminamos si esta existe
		boolean borrardb = Metodos_BBDD.borrarBBDD("PiPro");
		boolean creardb = Metodos_BBDD.crearBBDD("PiPro");
		
		if(creardb) {		
			System.out.println("La base de datos se ha creado exitosamente");		
		}
		
		//Ejecutamos las sentencias de creacion de tablas
		boolean creart1 = Metodos_BBDD.ejecutarSentencia("PiPro",
				 "CREATE TABLE proveedores ("
				 + "	id char(4) not null,"
				 + "    nombre nvarchar(100),"
				 + "    primary key (id)"
				 + ");;"
				);
		
		boolean creart2 = Metodos_BBDD.ejecutarSentencia("PiPro", 
				"CREATE TABLE piezas ("
				+ "	codigo int not null,"
				+ "    nombre nvarchar(100),"
				+ "    primary key (codigo)"
				+ ");");		
		
		boolean creart3 = Metodos_BBDD.ejecutarSentencia("PiPro", 
				"CREATE TABLE suministra ("
				+ "	codigoPieza int not null,"
				+ "    idProveedor char(4) not null primary key,"
				+ "    precio int,"
				+ "    constraint codP"
				+ "		foreign key (codigoPieza)"
				+ "        references piezas (codigo)"
				+ "        on update cascade "
				+ "        on delete no action,"
				+ "	constraint idProv"
				+ "		foreign key (idProveedor)"
				+ "        references proveedores (id)"
				+ "        on update cascade"
				+ "        on delete no action"
				+ ");");	
		
		
		//Insertamos datos
		boolean insert1 = Metodos_BBDD.ejecutarSentencia("PiPro", "INSERT INTO proveedores VALUES (\"ABCD\", \"proveedor1\");");
		boolean insert2 = Metodos_BBDD.ejecutarSentencia("PiPro", "INSERT INTO piezas VALUES (1, \"pieza1\");");
		boolean insert3 = Metodos_BBDD.ejecutarSentencia("PiPro", "INSERT INTO suministra VALUES (1, \"ABCD\", 70);");
		
		//Mostramos las tablas
		Metodos_BBDD.mostrarValores("PiPro", "proveedores", 2);
		Metodos_BBDD.mostrarValores("PiPro", "piezas", 2);
		Metodos_BBDD.mostrarValores("PiPro", "suministra", 3);
	
	}

}
