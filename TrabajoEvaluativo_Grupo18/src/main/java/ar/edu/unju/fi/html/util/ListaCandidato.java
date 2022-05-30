package ar.edu.unju.fi.html.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.html.model.Candidato;
@Component
public class ListaCandidato {
	ArrayList<Candidato> candidatos;
	
	public ArrayList<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(ArrayList<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

	public ListaCandidato() {
		candidatos = new ArrayList<Candidato>();
		candidatos.add(new Candidato(1, "ninguno", "-", "-", 0,0));
		candidatos.add(new Candidato(2, "metallica", "thrash metal", "banda de rock metal", 1,0));
		candidatos.add(new Candidato(3, "Los Redondos", "rock alternativo", "banda de rock", 0,0));
		
	}
}
