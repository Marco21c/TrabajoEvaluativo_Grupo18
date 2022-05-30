package ar.edu.unju.fi.html.service.imp;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.fi.html.model.Candidato;
import ar.edu.unju.fi.html.service.ICandidatoService;
import ar.edu.unju.fi.html.util.ListaCandidato;

public class CandidatoServicelmp implements ICandidatoService {
	
	@Autowired
	private ListaCandidato listacandidatos;

	@Override
	public Candidato getCandidado() {
		// TODO Auto-generated method stub
		return new Candidato();
	}

	@Override
	public Boolean guardarCandidato(Candidato candidato) {
		// TODO Auto-generated method stub
		return listacandidatos.getCandidatos().add(candidato);
	}

	@Override
	public void modificarCandidato(Candidato candidato) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarCandidato(int codigo) {
		// TODO Auto-generated method stub

	}

	@Override
	public ListaCandidato getListaCandidatos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Candidato buscarCandidato(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

}
