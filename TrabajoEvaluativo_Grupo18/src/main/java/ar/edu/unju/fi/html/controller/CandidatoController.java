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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.html.model.Candidato;
import ar.edu.unju.fi.html.service.ICandidatoService;
import ar.edu.unju.fi.html.util.ListaCandidato;

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
	public ModelAndView getListaCandidatoPage() {
		ModelAndView mav = new ModelAndView("lista_votosArtistas");
		int c = candidatoService.sumarvotos(candidatoService.getListaCandidatos());
		mav.addObject("candidato", candidatoService.getListaCandidatos().getCandidatos());
		mav.addObject("cantidad", c);
		return mav;
	}
	@GetMapping("/votar")
	public ModelAndView getListaVotacionPage() {
		ModelAndView mav = new ModelAndView("votar");
		
		mav.addObject("candidato", candidatoService.getListaCandidatos().getCandidatos());
		return mav;
}
	@GetMapping("/guardarvoto")
	public ModelAndView guardarvoto(@RequestParam(name = "id") int id) {
		//busqueda del candidato para a??adir el voto
		Candidato cand = candidatoService.buscarCandidato(id);
		cand.setCant_votos(cand.getCant_votos()+1);
		 
		ModelAndView model = new ModelAndView("mensaje");
		
				
		model.addObject("candidato", cand);  
		return model;
	}
	@GetMapping("/editar/{codigo}")
	public ModelAndView getEditarDocentePage(@PathVariable(value="codigo")int cod){
		ModelAndView mav = new ModelAndView("edicion_candidato");
		Candidato candidato = candidatoService.buscarCandidato(cod);
		mav.addObject("candidato", candidato );
		return mav;
	}
	
	@PostMapping("/modificar")
	public ModelAndView editarDatosDocente(@Validated @ModelAttribute("candidato") Candidato candidato, BindingResult bindingResult) {
	if(bindingResult.hasErrors()) {
		LOGGER.info("ocurrio un error "+candidato);
		ModelAndView mav = new ModelAndView("edicion_candidato");
		mav.addObject("candidato", candidato);
		return mav;
	}
	ModelAndView mav = new ModelAndView("redirect:/candidato/listaCandidato");
	LOGGER.info("Se modofico correctamente.");
	candidatoService.modificarCandidato(candidato);
	return mav;
	}
	@GetMapping("/eliminar/{codigo}")
	public ModelAndView eliminarDocente(@PathVariable("codigo")int codigo) {
		candidatoService.eliminarCandidato(codigo);
		LOGGER.info("Se elimino correctamente.");
		ModelAndView mav = new ModelAndView("redirect:/candidato/listaCandidato");
				return mav;
	}
}