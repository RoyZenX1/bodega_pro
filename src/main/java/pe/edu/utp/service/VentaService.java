package pe.edu.utp.service;
import java.time.LocalDateTime;
import java.util.*;
import org.springframework.stereotype.Service;
import pe.edu.utp.model.*;
import pe.edu.utp.repository.VentaRepository;
@Service
public class VentaService {
 private final VentaRepository repository;
 private final ProductoService productoService;
 private final ClienteService clienteService;
 public VentaService(VentaRepository repository, ProductoService productoService, ClienteService clienteService){
   this.repository=repository; this.productoService=productoService; this.clienteService=clienteService;
 }
 public List<Venta> listarTodos(){return repository.listarTodos();}
 public Optional<Venta> buscar(Long id){return repository.buscarPorId(id);}
 public double totalVendido(){return repository.listarTodos().stream().mapToDouble(Venta::getTotal).sum();}
 public void registrar(Long clienteId, Long productoId, int cantidad){
   Cliente cliente=clienteService.buscar(clienteId).orElseThrow();
   Producto producto=productoService.buscar(productoId).orElseThrow();
   if(cantidad<=0 || producto.getStock()<cantidad) throw new IllegalArgumentException("Stock insuficiente.");
   Venta venta=new Venta(null,cliente,LocalDateTime.now());
   venta.getDetalles().add(new DetalleVenta(producto,cantidad,producto.getVenta()));
   producto.setStock(producto.getStock()-cantidad);
   productoService.guardar(producto);
   repository.guardar(venta);
 }
}
