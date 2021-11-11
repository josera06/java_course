package gob.isem.eic.cei.web;

import gob.isem.eic.cei.domain.Persona;
import gob.isem.eic.cei.servicio.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {

    @Value("${index.saludo}")
    private String saludo;

    @Autowired
    private PersonaService personaService;

    @GetMapping("/")
    public String inicio(Model model) {
        String mensaje = "Mensaje con Spring y thymeleaf";

        var personas = personaService.listarPersonas();
        //List<Persona> personas = new ArrayList<>();

        //model.addAttribute("persona", persona2);
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);
        model.addAttribute("personas", personas);
        log.info(personas.toString());
        log.info("Ejecutando el controlador Spring MVC desde PostgreSQL");
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Persona persona) {
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(Persona persona) {
        personaService.guardar(persona);
        return "redirect:/";
    }

    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model) {
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }

    @GetMapping("/eliminar")
    public String eliminar(Persona persona) {
        personaService.eliminar(persona);
        return "redirect:/";
    }
}
