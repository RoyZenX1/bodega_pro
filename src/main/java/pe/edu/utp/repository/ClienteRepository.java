package pe.edu.utp.repository;

import java.util.*;
import pe.edu.utp.model.Cliente;

public interface ClienteRepository {
    List<Cliente> listarTodos();
Optional<Cliente> buscarPorId(Long id);
void guardar(Cliente cliente);
void eliminar(Long id);
boolean existeDocumento(String documento);
List<Cliente> buscarPorTermino(String termino);
}
