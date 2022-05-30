package ar.edu.unju.fi.html.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import ar.edu.unju.fi.html.model.Usuario;
import ar.edu.unju.fi.html.service.IUsuarioService;



@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	private static final Log LOGGER = LogFactory.getLog(UsuarioController.class);
	
	@GetMapping("/nuevo")
	public String GetUsuarioPage(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute(usuario);
		return "registro_usuario";
	}
	
	@PostMapping("/guardarUsuario")
	public ModelAndView BottonAgregar(@Validated @ModelAttribute("usuario") Usuario us, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("registro_usuario");
			mav.addObject("docente", us);
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/usuario/listaUsuario");
		if(usuarioService.guardarUsuario(us)) {
			LOGGER.info("Se agrego Nuevo usuario a la lista");
		}
		
		return mav;
	}
	
	@GetMapping("/listaUsuario")
	public ModelAndView getListaDocentesPage() {
		ModelAndView mav = new ModelAndView("lista_usuarios");
		mav.addObject("usuarios", usuarioService.getListaUsuarios().getUsuarios());
		return mav;
	}
}
