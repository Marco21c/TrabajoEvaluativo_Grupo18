package ar.edu.unju.fi.html.model;

import java.time.LocalDate;
import java.time.Period;

public class Usuario {
private String nombre;
private String email;
private LocalDate fecha_nac;

public Usuario() {
	
}

public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public LocalDate getFecha_nac() {
	return fecha_nac;
}
public void setFecha_nac(LocalDate fecha_nac) {
	this.fecha_nac = fecha_nac;
}
public int calcularEdad(LocalDate fecha_na) {
	  Period transcurrido = Period.between(fecha_na,  LocalDate.now());
	  int edad = transcurrido.getYears(); 
	return edad ;
}


}
