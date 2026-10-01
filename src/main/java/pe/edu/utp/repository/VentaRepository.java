package pe.edu.utp.repository;

import java.util.*;
import pe.edu.utp.model.Venta;

public interface VentaRepository {
    List<Venta> listarTodos();
Optional<Venta> buscarPorId(Long id);
void guardar(Venta venta);
}
