package gob.isem.eic.cei;

import gob.isem.eic.cei.domain.Persona;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorInicio {

    @Value("${index.saludo}")
    private String saludo;

    @GetMapping("/")
    public String inicio(Model model) {
        String mensaje = "Mensaje con Spring y thymeleaf";
        Persona persona = new Persona();
        persona.setNombre("Juan");
        persona.setApellido("Perez");
        persona.setEmail("jperez@email.com");
        persona.setTelefono("654981222");

        Persona persona2 = new Persona();
        persona2.setNombre("Karla");
        persona2.setApellido("Gomez");
        persona2.setEmail("kgomez@email.com");
        persona2.setTelefono("65432155");
        
        List<Persona> personas = Arrays.asList(persona,persona2);
        //var personas = Arrays.asList(persona,persona2);
        //List<Persona> personas = new ArrayList<>();

        //model.addAttribute("persona", persona2);
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);
        model.addAttribute("personas", personas);
        log.info("Ejecutando el controlador Spring MVC");
        return "index";
    }

}
