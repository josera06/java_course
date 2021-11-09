package gob.isem.eic.cei.web;

import gob.isem.eic.cei.dao.PersonaDao;
import gob.isem.eic.cei.domain.Persona;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorInicio {

    @Value("${index.saludo}")
    private String saludo;

    @Autowired
    private PersonaDao personaDao;
    
    @GetMapping("/")
    public String inicio(Model model) {
        String mensaje = "Mensaje con Spring y thymeleaf";

        var personas = personaDao.findAll();
        //List<Persona> personas = new ArrayList<>();

        //model.addAttribute("persona", persona2);
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);
        model.addAttribute("personas", personas);
        log.info(personas.toString());
        log.info("Ejecutando el controlador Spring MVC desde PostgreSQL");
        return "index";
    }

}
