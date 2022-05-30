package ar.edu.unju.fi.html.controller;

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
import org.springframework.web.servlet.ModelAndView;


import ar.edu.unju.fi.html.model.Candidato;
import ar.edu.unju.fi.html.service.ICandidatoService;

@Controller
@RequestMapping("/candidato")

public class CandidatoController {
	
	@Autowired
	@Qualifier("CandidatoServiceImp")
	private ICandidatoService candidatoService;
	
	private static final Log LOGGER = LogFactory.getLog(CandidatoController.class);
	
	@GetMapping("/nuevo")
	public String GetCandidatoPage(Model model){	
	model.addAttribute("candidato", candidatoService.getCandidado());
    return "registro_candidatos";
    }
	
	@PostMapping("/guardarCandidato")
	public ModelAndView BottonAgregar(@Validated @ModelAttribute("candidato") Candidato can, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("nuevo_candidato");
			mav.addObject("candidato", can);
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/candidato/listaCandidato");
		if(candidatoService.guardarCandidato(can)) {
			LOGGER.info("Se agrego nuevo candidato a la lista de candidatos");
		}
		
		return mav;
	}
	@GetMapping("/listaCandidato")
	public ModelAndView getListaUsuarioPage() {
		ModelAndView mav = new ModelAndView("lista_votosArtistas");
		mav.addObject("candidato", candidatoService.getListaCandidatos().getCandidatos());
		return mav;
	}
}
