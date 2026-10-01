package pe.edu.utp.repository;

import java.util.*;
import pe.edu.utp.model.Categoria;

public interface CategoriaRepository {
    List<Categoria> listarTodos();
Optional<Categoria> buscarPorId(Long id);
void guardar(Categoria categoria);
void eliminar(Long id);
boolean existeNombre(String nombre);
List<Categoria> buscarPorTermino(String termino);
}
