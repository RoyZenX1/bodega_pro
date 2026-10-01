package pe.edu.utp.controller;
import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.web.bind.annotation.*; import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.edu.utp.model.Configuracion; import pe.edu.utp.service.ConfiguracionService;
@Controller @RequestMapping("/configuracion")
public class ConfiguracionController {
 private final ConfiguracionService service; public ConfiguracionController(ConfiguracionService service){this.service=service;}
 @GetMapping public String configuracion(Model model){model.addAttribute("configuracion",service.obtener());return "pages/configuracion";}
 @PostMapping("/guardar") public String guardar(@ModelAttribute Configuracion c,RedirectAttributes ra){service.guardar(c);ra.addFlashAttribute("mensaje","Configuración actualizada.");return "redirect:/configuracion";}
}
