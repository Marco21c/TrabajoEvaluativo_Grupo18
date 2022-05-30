package ar.edu.unju.fi.html.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.html.model.Candidato;
import ar.edu.unju.fi.html.model.Usuario;
import ar.edu.unju.fi.html.service.IUsuarioService;
import ar.edu.unju.fi.html.util.ListaCandidato;
import ar.edu.unju.fi.html.util.ListaUsuarios;

@Service("UsuarioServiceImp")
public class UsuarioServicelmp implements IUsuarioService {
	@Autowired
	private ListaUsuarios listaUsuarios;
    private ListaCandidato listaCandidatos;
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

	@Override
	public ListaCandidato getListaCandidatos() {
		// TODO Auto-generated method stub
		return listaCandidatos;
	}

	@Override
	public int calcularEdad(Usuario usuario) {
		// TODO Auto-generated method stub
		usuario.setEdad(usuario.calcularEdad(usuario.getFecha_nac()));
		return usuario.getEdad();
	}

	

}
