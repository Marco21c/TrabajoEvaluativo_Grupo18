package ar.edu.unju.fi.html.util;

import java.util.ArrayList;

import ar.edu.unju.fi.html.model.Usuario;
import java.time.LocalDate;

public class ListaUsuarios {
	ArrayList<Usuario> usuarios;
	
	public ListaUsuarios() {
		usuarios = new ArrayList<Usuario>();
		usuarios.add(new Usuario("pepe", "arg@mail", LocalDate.of(24, 03, 1999)));
	}
}
