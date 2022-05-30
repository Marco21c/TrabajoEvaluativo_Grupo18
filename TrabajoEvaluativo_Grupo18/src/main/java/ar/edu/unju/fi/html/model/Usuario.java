package ar.edu.unju.fi.html.model;

import java.time.LocalDate;
import java.time.Period;

import javax.validation.constraints.Email;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

public class Usuario {
@NotEmpty(message="No debe estar vacio.")	
private String nombre;
@NotEmpty(message="No debe estar vacio.") @Email(message="Debe ser un email.")
private String email;
@Past(message="La fecha debe ser anterior a la actual.") 
@DateTimeFormat(pattern= "yyyy-MM-dd")
private LocalDate fecha_nac;

public Usuario() {
	
}


public Usuario(String nombre, String email, LocalDate fecha_nac) {
	super();
	this.nombre = nombre;
	this.email = email;
	this.fecha_nac = fecha_nac;
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
