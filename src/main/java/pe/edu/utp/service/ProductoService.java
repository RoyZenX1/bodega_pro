package pe.edu.utp.service;
import java.util.*;
import org.springframework.stereotype.Service;
import pe.edu.utp.model.Producto;
import pe.edu.utp.repository.ProductoRepository;

@Service
public class ProductoService {
 private final ProductoRepository repository;
 public ProductoService(ProductoRepository repository){this.repository=repository;}
 public List<Producto> listarTodos(){return repository.listarTodos();}
 public Optional<Producto> buscar(Long id){return repository.buscarPorId(id);}
 public boolean existe(String codigo){return repository.existeCodigo(codigo);}
 public void guardar(Producto producto){repository.guardar(producto);}
 public void eliminar(Long id){repository.eliminar(id);}
 public long contar(){return repository.listarTodos().size();}
 public long stockBajo(){return repository.listarTodos().stream().filter(p->p.getStock()<=p.getStockMinimo()).count();}
 public List<Producto> buscar(String termino){return repository.buscarPorTermino(termino);}
 public List<Producto> stockBajoList(){
   return repository.listarTodos().stream()
           .filter(p -> p.getStock() <= p.getStockMinimo()).toList();
 }
}
