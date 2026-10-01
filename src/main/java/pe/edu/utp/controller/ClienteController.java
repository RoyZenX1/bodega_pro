package pe.edu.utp.controller;
import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.web.bind.annotation.*; import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.edu.utp.model.Cliente; import pe.edu.utp.service.ClienteService;
@Controller @RequestMapping("/clientes")
public class ClienteController {
 private final ClienteService service; public ClienteController(ClienteService service){this.service=service;}
 @GetMapping public String lista(Model model){model.addAttribute("clientes",service.listarTodos());model.addAttribute("cliente",new Cliente());return "pages/clientes";}
 @GetMapping("/lista") public String legacy(){return "redirect:/clientes";}
 @GetMapping("/nuevo") public String nuevo(Model model){model.addAttribute("cliente",new Cliente());return "pages/clientes";}
 @GetMapping("/editar/{id}") public String editar(@PathVariable Long id,Model model){model.addAttribute("cliente",service.buscar(id).orElse(new Cliente()));return "pages/clientes";}
 @PostMapping("/guardar") public String guardar(@ModelAttribute Cliente c,RedirectAttributes ra){if(c.getId()==null&&service.existe(c.getDocumento())){ra.addFlashAttribute("error","Ya existe un cliente con ese documento.");return "redirect:/clientes";}service.guardar(c);ra.addFlashAttribute("mensaje","Cliente guardado exitosamente.");return "redirect:/clientes";}
 @PostMapping("/eliminar/{id}") public String eliminar(@PathVariable Long id,RedirectAttributes ra){service.eliminar(id);ra.addFlashAttribute("mensaje","Cliente eliminado.");return "redirect:/clientes";}
 @GetMapping("/buscar")
 public String buscar(@RequestParam String termino, Model model){
   model.addAttribute("clientes", service.buscar(termino));
   model.addAttribute("cliente", new Cliente());
   model.addAttribute("termino", termino);
   return "pages/clientes";
 }
}
