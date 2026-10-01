package pe.edu.utp.service;
import java.util.*;
import org.springframework.stereotype.Service;
import pe.edu.utp.model.Proveedor;
import pe.edu.utp.repository.ProveedorRepository;
@Service
public class ProveedorService {
 private final ProveedorRepository repository;
 public ProveedorService(ProveedorRepository repository){this.repository=repository;}
 public List<Proveedor> listarTodos(){return repository.listarTodos();}
 public Optional<Proveedor> buscar(Long id){return repository.buscarPorId(id);}
 public boolean existe(String ruc){return repository.existeRuc(ruc);}
 public void guardar(Proveedor p){repository.guardar(p);}
 public void eliminar(Long id){repository.eliminar(id);}
 public List<Proveedor> buscar(String termino){return repository.buscarPorTermino(termino);}
}
