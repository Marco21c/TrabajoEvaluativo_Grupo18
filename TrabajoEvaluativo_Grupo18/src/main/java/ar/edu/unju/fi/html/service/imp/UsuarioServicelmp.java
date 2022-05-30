package ar.edu.unju.fi.html.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.html.model.Candidato;
import ar.edu.unju.fi.html.model.Usuario;
import ar.edu.unju.fi.html.service.IUsuarioService;
import ar.edu.unju.fi.html.util.ListaUsuarios;

@Service("UsuarioServiceImp")
public class UsuarioServicelmp implements IUsuarioService {
	@Autowired
	private ListaUsuarios listaUsuarios;

	@Override
	public Usuario getUsuario() {
		// retorna objeto de la clase Usuario
		return new Usuario();
	}

	@Override
	public boolean guardarUsuario(Usuario usuario) {
		// guarda un objeto usuario en la lista de usuario
		return listaUsuarios.getUsuarios().add(usuario);
	}

	@Override
	public ListaUsuarios getListaUsuarios() {
		// retorna el objeto que accede a la lista de usuario
		return listaUsuarios;
	}

	@Override
	public Candidato getCandidato() {
		// TODO Auto-generated method stub
		return new Candidato();
	}

}
