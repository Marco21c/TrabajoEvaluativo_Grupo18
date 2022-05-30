package ar.edu.unju.fi.html.service;

import ar.edu.unju.fi.html.model.Candidato;
import ar.edu.unju.fi.html.model.Usuario;
import ar.edu.unju.fi.html.util.ListaCandidato;
import ar.edu.unju.fi.html.util.ListaUsuarios;

public interface IUsuarioService {
	public Usuario getUsuario();
	public boolean guardarUsuario(Usuario usuario);
	public ListaUsuarios getListaUsuarios();
	public Candidato getCandidato();
	public ListaCandidato getListaCandidatos();
	public int calcularEdad(Usuario usuario);
}
