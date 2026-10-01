package pe.edu.utp.controller;
import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.web.bind.annotation.*; import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.edu.utp.service.*; 
@Controller @RequestMapping("/ventas")
public class VentaController {
 private final VentaService ventaService; private final ClienteService clienteService; private final ProductoService productoService;
 public VentaController(VentaService v,ClienteService c,ProductoService p){ventaService=v;clienteService=c;productoService=p;}
 @GetMapping public String lista(Model model){model.addAttribute("ventas",ventaService.listarTodos());model.addAttribute("clientes",clienteService.listarTodos());model.addAttribute("productos",productoService.listarTodos());model.addAttribute("totalVentas",ventaService.totalVendido());return "pages/ventas";}
 @GetMapping("/lista") public String legacy(){return "redirect:/ventas";}
 @PostMapping("/guardar") public String guardar(@RequestParam Long clienteId,@RequestParam Long productoId,@RequestParam int cantidad,RedirectAttributes ra){
  try{ventaService.registrar(clienteId,productoId,cantidad);ra.addFlashAttribute("mensaje","Venta registrada exitosamente.");}
  catch(Exception e){ra.addFlashAttribute("error",e.getMessage());}
  return "redirect:/ventas";
 }
}
