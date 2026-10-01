package pe.edu.utp.repository;

import java.util.*;
import pe.edu.utp.model.Producto;

public interface ProductoRepository {
    List<Producto> listarTodos();
Optional<Producto> buscarPorId(Long id);
void guardar(Producto producto);
void eliminar(Long id);
boolean existeCodigo(String codigo);
List<Producto> buscarPorTermino(String termino);
}
