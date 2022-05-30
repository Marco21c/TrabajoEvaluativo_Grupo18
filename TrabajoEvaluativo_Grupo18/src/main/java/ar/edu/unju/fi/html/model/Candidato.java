package ar.edu.unju.fi.html.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

public class Candidato {
@Positive(message="Debe ser un valor mayor a 0.")	
private int codigo;
@NotEmpty(message="No debe estar vacio.")
private String nombre;
@NotEmpty(message="No debe estar vacio.")
private String genero_music;
@NotEmpty(message="No debe estar vacio.")
private String descripcion;
//este valor no se debe modificar
private int cant_votos;

public Candidato(){
	
}

public Candidato(int codigo, String nombre, String genero_music, String descripcion, int cant_votos) {
	super();
	this.codigo = codigo;
	this.nombre = nombre;
	this.genero_music = genero_music;
	this.descripcion = descripcion;
	this.cant_votos = cant_votos;
}
public int getCodigo() {
	return codigo;
}
public void setCodigo(int codigo) {
	this.codigo = codigo;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getGenero_music() {
	return genero_music;
}
public void setGenero_music(String genero_music) {
	this.genero_music = genero_music;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public int getCant_votos() {
	return cant_votos;
}
public void setCant_votos(int cant_votos) {
	this.cant_votos = cant_votos;
}

}
