package com.iesvirgendelcarmen.jdbc.teoria;

import java.util.List;

public interface LibroDAO {
	
	List<LibroDTO> listarTodosLibros();
	List<LibroDTO> listarLibrosDisponibles();
	boolean borrarLibro(String nombreLibro, String nombreAutor);
	boolean actualizarCategoriaLibro(String nombreCategoria, String nombreLibro);
	boolean insertarLibro(LibroDTO libro);
	boolean insertarListaLibros(List<LibroDTO> listaLibros);
	
	// **********************
}
