package ar.edu.unju.fi.html.util;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import ar.edu.unju.fi.html.model.Usuario;
import java.time.LocalDate;
@Component
public class ListaUsuarios {
	ArrayList<Usuario> usuarios;
	
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public ListaUsuarios() {
		usuarios = new ArrayList<Usuario>();
		usuarios.add(new Usuario("pepe", "arg@mail", LocalDate.of(2001, 4, 10),24));
	}
	
	
}
