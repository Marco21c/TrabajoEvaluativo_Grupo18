package ar.edu.unju.fi.html.service;

import ar.edu.unju.fi.html.model.Candidato;
import ar.edu.unju.fi.html.util.ListaCandidato;

public interface ICandidatoService {
	
	public Candidato getCandidado();
	public Boolean guardarCandidato(Candidato candidato);
	public void modificarCandidato(Candidato candidato);
	public void eliminarCandidato(int codigo);
	public ListaCandidato getListaCandidatos();
	public Candidato buscarCandidato(int codigo);
	public int sumarvotos(ListaCandidato listaCandidato);
}
