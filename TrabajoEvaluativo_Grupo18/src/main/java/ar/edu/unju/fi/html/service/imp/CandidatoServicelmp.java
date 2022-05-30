package ar.edu.unju.fi.html.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.fi.html.model.Candidato;
import ar.edu.unju.fi.html.service.ICandidatoService;
import ar.edu.unju.fi.html.util.ListaCandidato;

public class CandidatoServicelmp implements ICandidatoService {
	
	@Autowired
	private ListaCandidato listaCandidato;

	@Override
	public Candidato getCandidado() {
		// TODO Auto-generated method stub
		return new Candidato();
	}

	@Override
	public Boolean guardarCandidato(Candidato candidato) {
		// TODO Auto-generated method stub
		return listaCandidato.getCandidatos().add(candidato);
	}

	@Override
	public void modificarCandidato(Candidato candidato) {
		// TODO Auto-generated method stub
		for(Candidato can: listaCandidato.getCandidatos()) {
			if(can.getCodigo() == candidato.getCodigo()) {
				can.setNombre(candidato.getNombre());
				can.setGenero_music(candidato.getGenero_music());
				can.setDescripcion(candidato.getDescripcion());
				can.setCant_votos(candidato.getCant_votos());
			}
		}

	}

	@Override
	public void eliminarCandidato(int codigo) {
		// TODO Auto-generated method stub
		Optional<Candidato> candidato = listaCandidato.getCandidatos().stream().filter(c -> c.getCodigo() == codigo).findFirst();
		listaCandidato.getCandidatos().remove(candidato.get());

	}

	@Override
	public ListaCandidato getListaCandidatos() {
		// TODO Auto-generated method stub
		return listaCandidato;
	}

	@Override
	public Candidato buscarCandidato(int codigo) {
		// TODO Auto-generated method stub
		Optional<Candidato> candidato = listaCandidato.getCandidatos().stream().filter(c -> c.getCodigo() == codigo).findFirst();
		return candidato.get();
	}

}
