package ar.edu.unju.fi.html.util;

import java.util.ArrayList;

import ar.edu.unju.fi.html.model.Candidato;

public class ListaCandidatos {
	ArrayList<Candidato> candidatos;
	
	public ListaCandidatos() {
		candidatos = new ArrayList<Candidato>();
		candidatos.add(new Candidato(1, "ninguno", "-", "-", 0));
		candidatos.add(new Candidato(1, "metallica", "thrash metal", "banda de rock metal", 0));
		
	}
}
