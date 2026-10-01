package pe.edu.utp.service;
import java.util.*;
import org.springframework.stereotype.Service;
import pe.edu.utp.model.Categoria;
import pe.edu.utp.repository.CategoriaRepository;
@Service
public class CategoriaService {
 private final CategoriaRepository repository;
 public CategoriaService(CategoriaRepository repository){this.repository=repository;}
 public List<Categoria> listarTodos(){return repository.listarTodos();}
 public Optional<Categoria> buscar(Long id){return repository.buscarPorId(id);}
 public boolean existe(String nombre){return repository.existeNombre(nombre);}
 public void guardar(Categoria c){repository.guardar(c);}
 public void eliminar(Long id){repository.eliminar(id);}
 public List<Categoria> buscar(String termino){return repository.buscarPorTermino(termino);}
}
