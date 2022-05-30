package ar.edu.unju.fi.html.service;

import ar.edu.unju.fi.html.model.Candidato;
import ar.edu.unju.fi.html.util.ListaCandidatos;

public interface ICandidatoService {
	
	public Candidato getCandidado();
	public Boolean guardarCandidato(Candidato candidato);
	public void modificarCandidato(Candidato candidato);
	public void eliminarCandidato(int codigo);
	public ListaCandidatos getListaCandidatos();
	public Candidato buscarCandidato(int codigo);

}
