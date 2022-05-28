package ar.edu.unju.fi.html.model;

public class Candidato {
private int codigo;
private String nombre;
private String genero_music;
private String descripcion;
private int cant_votos;

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
