package ar.edu.unju.fi.html.controller;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Autowired;
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
import ar.edu.unju.fi.html.service.IUsuarioService;
import ar.edu.unju.fi.html.util.ListaCandidato;
//import ar.edu.unju.fi.html.service.IUsuarioService;
import ar.edu.unju.fi.html.util.ListaUsuarios;



@Controller
@RequestMapping("/usuario")
public class VotarController {
	
	@Autowired
	@Qualifier("UsuarioServiceImp")
	private IUsuarioService usuarioService;
	 
	private static final Log LOGGER = LogFactory.getLog(VotarController.class);
	
	@GetMapping("/nuevo")
	public String GetUsuarioPage(Model model) {
		model.addAttribute("usuario",usuarioService.getUsuario());
		model.addAttribute("candidato", usuarioService.getCandidato());
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
		ModelAndView mav = new ModelAndView("redirect:/usuario/votar");
		if(usuarioService.guardarUsuario(us)) {
			LOGGER.info("Se agrego Nuevo usuario a la lista");
		}
		return mav;
	}
	
	@GetMapping("/votar")
	public ModelAndView getListaDocentesPage() {
		ModelAndView mav = new ModelAndView("votar");
		ListaCandidato listC = new ListaCandidato();
		mav.addObject("candidato", listC.getCandidatos());
		return mav;
	}
	
	@GetMapping("/guardarvoto")
	public ModelAndView guardarvoto(@RequestParam(name = "id") int id) {
		ModelAndView model = new ModelAndView("mensaje");
		ListaCandidato listC = new ListaCandidato();
		Optional<Candidato> cand = listC.getCandidatos().stream().filter(c -> id ==c.getCodigo()).findFirst();
        model.addObject("candidato", cand);  
		return model;
		
	}
}
