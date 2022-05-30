package ar.edu.unju.fi.html.controller;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.html.model.Candidato;
import ar.edu.unju.fi.html.model.Usuario;
import ar.edu.unju.fi.html.service.ICandidatoService;
import ar.edu.unju.fi.html.service.IUsuarioService;
import ar.edu.unju.fi.html.util.ListaCandidato;



@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	
	@Qualifier("UsuarioServiceImp")
	private IUsuarioService usuarioService;
	private static final Log LOGGER = LogFactory.getLog(UsuarioController.class);
	
	@GetMapping("/nuevo")
	public String GetUsuarioPage(Model model) {
		model.addAttribute("usuario",usuarioService.getUsuario());
		return "registro_usuario";
	}
	
	@PostMapping("/guardarUsuario")
	public ModelAndView BottonAgregar(@Validated @ModelAttribute("usuario") Usuario us, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			LOGGER.error("Ocurrio un error en la validacion.");
			ModelAndView mav = new ModelAndView("registro_usuario");
			mav.addObject("usuario", us);
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/candidato/votar");
		//generar edad
		us.setEdad(us.calcularEdad(us.getFecha_nac()));
		
		if(usuarioService.guardarUsuario(us)) {
			LOGGER.info("Se agrego Nuevo usuario");
		}
		return mav;
	}
	@GetMapping("/listausuarios")
	public ModelAndView getListaUsuarioPage() {
		ModelAndView mav = new ModelAndView("lista_usuarios");
		mav.addObject("usuario", usuarioService.getListaUsuarios().getUsuarios());
		return mav;
	}
	
}
