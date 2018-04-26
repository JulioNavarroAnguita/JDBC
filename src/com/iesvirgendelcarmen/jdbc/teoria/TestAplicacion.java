package com.iesvirgendelcarmen.jdbc.teoria;

import java.util.List;

public class TestAplicacion {

	public static void main(String[] args) {
		LibroDAO manipulacionLibros = new LibroDAOImp();
		List<LibroDTO> listaTotal = manipulacionLibros.listarTodosLibros();
		
		List<LibroDTO> listaTotalLibrosDisponibles = manipulacionLibros.listarLibrosDisponibles();
		
		System.out.println("Numero total de libros: " + listaTotal.size());
		System.out.println(listaTotalLibrosDisponibles);
		System.out.println("numero de libros disponibles: " + listaTotalLibrosDisponibles.size());

		
		manipulacionLibros.borrarLibro("Terminator", "Paquito");
		System.out.println("N total de libros: " + listaTotal.size());
		
		LibroDTO libroDTO = new LibroDTO("WebOS", null, null, null);
		System.out.println(manipulacionLibros.actualizarCategoriaLibro(libroDTO, "Programacion"));
		
		LibroDTO libroDTO2 = new LibroDTO("Quijote", "Malote", "Feo", "Programacion");
		System.out.println(manipulacionLibros.insertarLibro(libroDTO2));
		
		
		
		
	}

}
