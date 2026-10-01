package pe.edu.utp.controller;
import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.web.bind.annotation.*; import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.edu.utp.model.Proveedor; import pe.edu.utp.service.ProveedorService;
@Controller @RequestMapping("/proveedores")
public class ProveedorController {
 private final ProveedorService service; public ProveedorController(ProveedorService service){this.service=service;}
 @GetMapping public String lista(Model model){model.addAttribute("proveedores",service.listarTodos());model.addAttribute("proveedor",new Proveedor());return "pages/proveedores";}
 @GetMapping("/lista") public String legacy(){return "redirect:/proveedores";}
 @GetMapping("/nuevo") public String nuevo(Model model){model.addAttribute("proveedor",new Proveedor());return "pages/proveedores";}
 @GetMapping("/editar/{id}") public String editar(@PathVariable Long id,Model model){model.addAttribute("proveedor",service.buscar(id).orElse(new Proveedor()));return "pages/proveedores";}
 @PostMapping("/guardar") public String guardar(@ModelAttribute Proveedor p,RedirectAttributes ra){if(p.getId()==null&&service.existe(p.getRuc())){ra.addFlashAttribute("error","Ya existe un proveedor con ese RUC.");return "redirect:/proveedores";}service.guardar(p);ra.addFlashAttribute("mensaje","Proveedor guardado exitosamente.");return "redirect:/proveedores";}
 @PostMapping("/eliminar/{id}") public String eliminar(@PathVariable Long id,RedirectAttributes ra){service.eliminar(id);ra.addFlashAttribute("mensaje","Proveedor eliminado.");return "redirect:/proveedores";}
 @GetMapping("/buscar")
 public String buscar(@RequestParam String termino, Model model){
   model.addAttribute("proveedores", service.buscar(termino));
   model.addAttribute("proveedor", new Proveedor());
   model.addAttribute("termino", termino);
   return "pages/proveedores";
 }
}
