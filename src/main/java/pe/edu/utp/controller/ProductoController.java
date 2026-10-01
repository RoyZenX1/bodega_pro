package pe.edu.utp.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.edu.utp.model.Producto;
import pe.edu.utp.service.*;
@Controller
@RequestMapping("/productos")
public class ProductoController {
 private final ProductoService productoService; private final CategoriaService categoriaService;
 public ProductoController(ProductoService p,CategoriaService c){this.productoService=p;this.categoriaService=c;}
 @GetMapping public String lista(Model model){model.addAttribute("productos",productoService.listarTodos());model.addAttribute("producto",new Producto());model.addAttribute("categorias",categoriaService.listarTodos());return "pages/productos";}
 @GetMapping("/lista") public String listaLegacy(){return "redirect:/productos";}
 @GetMapping("/nuevo") public String nuevo(Model model){model.addAttribute("producto",new Producto());model.addAttribute("categorias",categoriaService.listarTodos());return "pages/productos";}
 @GetMapping("/editar/{id}") public String editar(@PathVariable Long id,Model model){model.addAttribute("producto",productoService.buscar(id).orElse(new Producto()));model.addAttribute("categorias",categoriaService.listarTodos());return "pages/productos";}
 @PostMapping("/guardar") public String guardar(@ModelAttribute Producto producto,RedirectAttributes ra){
   String url = producto.getImagenUrl() == null ? null : producto.getImagenUrl().trim();
   if(url != null && url.isEmpty()) url = null;
   if(url != null && !(url.startsWith("http://") || url.startsWith("https://"))){
     ra.addFlashAttribute("error","La URL de la imagen debe comenzar con http:// o https://");return "redirect:/productos";
   }
   producto.setImagenUrl(url);
   if(producto.getId()==null && productoService.existe(producto.getCodigo())){ra.addFlashAttribute("error","Ya existe un producto con ese código.");return "redirect:/productos";}
   productoService.guardar(producto);ra.addFlashAttribute("mensaje","Producto guardado exitosamente.");return "redirect:/productos";
 }
 @PostMapping("/eliminar/{id}") public String eliminar(@PathVariable Long id,RedirectAttributes ra){productoService.eliminar(id);ra.addFlashAttribute("mensaje","Producto eliminado.");return "redirect:/productos";}
 @GetMapping("/buscar")
 public String buscar(@RequestParam String termino, Model model){
   model.addAttribute("productos", productoService.buscar(termino));
   model.addAttribute("producto", new Producto());
   model.addAttribute("categorias", categoriaService.listarTodos());
   model.addAttribute("termino", termino);
   return "pages/productos";
 }
}
