   package com.iesvirgendelcarmen.jdbc.teoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class LibroDAOImp implements LibroDAO {

	
	private static Connection conexion = Conexion.getConexion();
	@Override
	public List<LibroDTO> listarTodosLibros() {
		List<LibroDTO> listaLibros = new ArrayList<>();
		// Crear objeto Statement
		String sql = "SELECT * FROM libro;";
		try (Statement statement = conexion.createStatement();){
			// Crear objeto ResultSet
			ResultSet resulset = statement.executeQuery(sql);
			while (resulset.next()) {
				LibroDTO libro = new LibroDTO(resulset.getString(2),
						resulset.getString(3),
						resulset.getString(4),
						resulset.getString(5));
				listaLibros.add(libro);
				

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaLibros;
	}

	@Override
	public List<LibroDTO> listarLibrosDisponibles() {
		List<LibroDTO> listaLibrosNoPrestados = new ArrayList<>();
		String sql1 = "SELECT * FROM libro_no_prestado;";
		try (Statement st = conexion.createStatement();){
			ResultSet rst = st.executeQuery(sql1);
			while(rst.next()) {
				LibroDTO libroNoPrestado = new LibroDTO(rst.getString(1), rst.getString(2),null,null);
				listaLibrosNoPrestados.add(libroNoPrestado);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaLibrosNoPrestados;
	}

	@Override
	public boolean borrarLibro(String nombreLibro, String nombreAutor) {

		String sql2 = "DELETE FROM libro where nombre = ? AND autor = ?;";
		try (PreparedStatement pst = conexion.prepareStatement(sql2);){
			pst.setString(1, nombreLibro);
			pst.setString(2, nombreAutor);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}

	@Override
	public boolean actualizarCategoriaLibro(LibroDTO libroDTO, String nombreCategoria) {
		int updates = 0;
		//UPDATE libro SET categoria = 'Programacion' WHERE nombre = 'WebOS';
		//System.out.println(libroDTO + "--" + nombreCategoria);
		String sql3 = "UPDATE libro SET categoria = ? WHERE nombre = ?;";
		try (PreparedStatement pst1 = conexion.prepareStatement(sql3);) {
			pst1.setString(1, nombreCategoria);
			pst1.setString(2, libroDTO.getNombreLibro()); 
			updates = pst1.executeUpdate();
			//System.out.println(updates);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return updates != 0;
	}

	@Override
	public boolean insertarLibro(LibroDTO libro) {
	//INSERT into libro (nombre, autor, editorial, categoria) VALUES ('Quijote', 'Pepe', 'Santillana', 'Perl');
		int updates2 = 0;
		//System.out.println(libro);
		String sql4 = "INSERT into libro (nombre, autor, editorial, categoria) VALUES (?, ?, ?, ?);";
		try (PreparedStatement pst2 = conexion.prepareStatement(sql4);){
			pst2.setString(1,libro.getNombreLibro());
			pst2.setString(2, libro.getNombreAutor());
			pst2.setString(3, libro.getEditorial());
			pst2.setString(4, libro.getNombreCategoria());
			updates2 = pst2.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return updates2 != 0;
	}

	@Override
	public boolean insertarListaLibros(List<LibroDTO> listaLibros) {
		
		return false;
	}

}
