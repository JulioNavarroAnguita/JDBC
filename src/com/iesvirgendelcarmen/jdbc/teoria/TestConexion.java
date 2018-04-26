package com.iesvirgendelcarmen.jdbc.teoria;

import java.sql.Connection;

public class TestConexion {

	public static void main(String[] args) {
		
		Connection conexion0 = Conexion.getConexion();
		Connection conexion1 = Conexion.getConexion();
		//debemos obtener la misma referencia
		System.out.println(conexion0);
		System.out.println(conexion1);
		//cierra conexion


	}

}
