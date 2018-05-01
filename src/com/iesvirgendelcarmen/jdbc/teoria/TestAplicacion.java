package com.iesvirgendelcarmen.jdbc.teoria;

import java.util.List;
import java.util.Scanner;

public class TestAplicacion {

	public static void main(String[] args) {
		
		LibroDAO manipulacionLibros = new LibroDAOImp();
		List<LibroDTO> listaTotal = manipulacionLibros.listarTodosLibros();
		List<LibroDTO> listaTotalLibrosDisponibles = manipulacionLibros.listarLibrosDisponibles();
		
		System.out.println("Numero total de libros: " + listaTotal.size());
		System.out.println(listaTotal);
	
		System.out.println("--------------------------------------------");
	
		System.out.println("Numero total de libros disponibles: " + listaTotalLibrosDisponibles.size());
		System.out.println(listaTotalLibrosDisponibles);
		
		System.out.println("--------------------------------------------");
		
		Scanner in = new Scanner(System.in);
		System.out.println("Introduce el nombre y el autor del libro que deseas borrar.");
		String borrarLibroNombre = in.nextLine();
		String borrarLibroAutor  = in.nextLine();
		manipulacionLibros.borrarLibro(borrarLibroNombre, borrarLibroAutor);
		
		System.out.println("Introduce el nombre del libro que quieres actualizar");
		String actualizarNombreLibro = in.nextLine();
		System.out.println("Ahora cambia el nombre de categoria entre los nombres posibles: \n"
				+ "-Programacion \n -Sistemas operativos \n -Bases de datos \n -Seguridad");
		String actualizarCategoriaLibro = in.nextLine();
		LibroDTO libroDTO = new LibroDTO(actualizarNombreLibro, null, null, null);
		System.out.println(manipulacionLibros.actualizarCategoriaLibro(libroDTO, actualizarCategoriaLibro));
		
		System.out.println("Introduce los datos del nuevo libro");
		System.out.println("Nombre");
		String nombreLibro = in.nextLine();
		System.out.println("Autor");
		String nombreAutor = in.nextLine();
		System.out.println("Editorial");
		String editorialLibro = in.nextLine();
		System.out.println("Categoria");
		System.out.println("Para el nombre de categoria hay que establecer nombres de las categorias "
				+ "existentes: \n"
				+ "-Programacion \n -Sistemas operativos \n -Bases de datos \n -Seguridad");
		String categoriaLibro = in.nextLine();
		LibroDTO libroDTO2 = new LibroDTO(nombreLibro, nombreAutor, editorialLibro, categoriaLibro);
		System.out.println(manipulacionLibros.insertarLibro(libroDTO2));
		
		
		
		
	}

}
