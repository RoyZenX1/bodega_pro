package pe.edu.utp.service;
import java.util.*;
import org.springframework.stereotype.Service;
import pe.edu.utp.model.Cliente;
import pe.edu.utp.repository.ClienteRepository;
@Service
public class ClienteService {
 private final ClienteRepository repository;
 public ClienteService(ClienteRepository repository){this.repository=repository;}
 public List<Cliente> listarTodos(){return repository.listarTodos();}
 public Optional<Cliente> buscar(Long id){return repository.buscarPorId(id);}
 public boolean existe(String documento){return repository.existeDocumento(documento);}
 public void guardar(Cliente c){repository.guardar(c);}
 public void eliminar(Long id){repository.eliminar(id);}
 public List<Cliente> buscar(String termino){return repository.buscarPorTermino(termino);}
}
