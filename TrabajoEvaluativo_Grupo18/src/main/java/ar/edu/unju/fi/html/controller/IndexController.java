package ar.edu.unju.fi.html.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inicio")
public class IndexController {

	    @GetMapping("/menu")
	    public String getIndexPage(Model model){
	    	return "index";
	    }
	    	
	
}
