package ar.edu.unju.fi.html.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.html.model.Usuario;



@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	private static final Log LOGGER = LogFactory.getLog(UsuarioController.class);
	
	@GetMapping("/nuevo")
	public String GetUsuarioPage(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute(usuario);
		return "registro_usuario";
	}
	
}
