package pe.edu.utp.controller;
import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.web.bind.annotation.*; import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.edu.utp.model.Categoria; import pe.edu.utp.service.CategoriaService;
@Controller @RequestMapping("/categorias")
public class CategoriaController {
 private final CategoriaService service; public CategoriaController(CategoriaService service){this.service=service;}
 @GetMapping public String lista(Model model){model.addAttribute("categorias",service.listarTodos());model.addAttribute("categoria",new Categoria());return "pages/categorias";}
 @GetMapping("/lista") public String legacy(){return "redirect:/categorias";}
 @GetMapping("/nuevo") public String nuevo(Model model){model.addAttribute("categoria",new Categoria());return "pages/categorias";}
 @GetMapping("/editar/{id}") public String editar(@PathVariable Long id,Model model){model.addAttribute("categoria",service.buscar(id).orElse(new Categoria()));return "pages/categorias";}
 @PostMapping("/guardar") public String guardar(@ModelAttribute Categoria c,RedirectAttributes ra){if(c.getId()==null&&service.existe(c.getNombre())){ra.addFlashAttribute("error","Ya existe esa categoría.");return "redirect:/categorias";}service.guardar(c);ra.addFlashAttribute("mensaje","Categoría guardada exitosamente.");return "redirect:/categorias";}
 @PostMapping("/eliminar/{id}") public String eliminar(@PathVariable Long id,RedirectAttributes ra){service.eliminar(id);ra.addFlashAttribute("mensaje","Categoría eliminada.");return "redirect:/categorias";}
 @GetMapping("/buscar")
 public String buscar(@RequestParam String termino, Model model){
   model.addAttribute("categorias", service.buscar(termino));
   model.addAttribute("categoria", new Categoria());
   model.addAttribute("termino", termino);
   return "pages/categorias";
 }
}
