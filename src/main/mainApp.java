package main;

import metodos_mysql.Metodos_BBDD;

public class mainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Antes de crear la base de datos la eliminamos si esta existe
		boolean borrardb = Metodos_BBDD.borrarBBDD("emp");
		boolean creardb = Metodos_BBDD.crearBBDD("emp");
		
		if(creardb) {		
			System.out.println("La base de datos se ha creado exitosamente");		
		}
		
		//Ejecutamos las sentencias de creacion de tablas
		boolean creart1 = Metodos_BBDD.ejecutarSentencia("emp",
				"CREATE TABLE departamentos ("
				+ "  codigo int NOT NULL,"
				+ "  nombre varchar(100) NOT NULL,"
				+ "  presupuesto int NOT NULL,"
				+ "  PRIMARY KEY (codigo)"
				+ ");"
				);
		
		boolean creart2 = Metodos_BBDD.ejecutarSentencia("emp", 
				"CREATE TABLE empleados ("
				+ "  DNI varchar(9) NOT NULL,"
				+ "  nombre varchar(100) NOT NULL,"
				+ "  apellidos varchar(255) NOT NULL,"
				+ "  departamento int NOT NULL,"
				+ "  PRIMARY KEY (DNI),"
				+ "  KEY departamento_idx (departamento),"
				+ "  CONSTRAINT departamento FOREIGN KEY (departamento) REFERENCES departamentos (codigo)"
				+ ");");		
		
		
		//Insertamos datos
		boolean insert1 = Metodos_BBDD.ejecutarSentencia("emp", "INSERT INTO departamentos VALUES (1, \"nombre1\", 12000);");
		boolean insert2 = Metodos_BBDD.ejecutarSentencia("emp", "INSERT INTO empleados VALUES (\"49874838M\", \"Miquel Angel\", \"Montero\", 1);");
		
		//Mostramos las tablas
		Metodos_BBDD.mostrarValores("emp", "departamentos", 3);
		Metodos_BBDD.mostrarValores("emp", "empleados", 4);
		
	}

}
