package pe.edu.utp.repository;

import java.util.*;
import pe.edu.utp.model.Proveedor;

public interface ProveedorRepository {
    List<Proveedor> listarTodos();
Optional<Proveedor> buscarPorId(Long id);
void guardar(Proveedor proveedor);
void eliminar(Long id);
boolean existeRuc(String ruc);
List<Proveedor> buscarPorTermino(String termino);
}
