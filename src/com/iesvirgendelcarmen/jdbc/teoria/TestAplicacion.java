package com.iesvirgendelcarmen.jdbc.teoria;

import java.util.List;

public class TestAplicacion {

	public static void main(String[] args) {
		LibroDAO manipulacionLibros = new LibroDAOImp();
		List<LibroDTO> listaTotal = manipulacionLibros.listarTodosLibros();
		
		List<LibroDTO> listaTotalLibrosDisponibles = manipulacionLibros.listarLibrosDisponibles();
		
		System.out.println("Nº total de libros: " + listaTotal.size());
		System.out.println("numero de libros disponibles: " + listaTotalLibrosDisponibles.size());
		
		manipulacionLibros.borrarLibro("Santa Tecla", "Pepito");
		System.out.println("Nº total de libros: " + listaTotal.size());
		
		manipulacionLibros.actualizarCategoriaLibro("Aplicaciones web", "WebOS");
		System.out.println("");
		
		
	}

}
