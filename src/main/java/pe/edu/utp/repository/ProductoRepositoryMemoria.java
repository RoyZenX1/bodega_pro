package pe.edu.utp.repository;

import java.util.*;
import org.springframework.stereotype.Repository;
import pe.edu.utp.model.Producto;

@Repository
public class ProductoRepositoryMemoria implements ProductoRepository {
    private final List<Producto> productos = new ArrayList<>();
    private long siguienteId = 1L;

    public ProductoRepositoryMemoria() {
        productos.add(new Producto(1L,"P001","Leche Gloria","Lácteos",3.20,4.50,25,10));
productos.add(new Producto(2L,"P002","Arroz Costeño","Abarrotes",3.50,4.20,40,10));
productos.add(new Producto(3L,"P003","Gaseosa Inca Kola","Bebidas",3.00,4.50,8,10));
siguienteId=4;
    }

    @Override
    public List<Producto> listarTodos() {
        return productos.stream().sorted(Comparator.comparing(Producto::getId)).toList();
    }
    @Override
    public Optional<Producto> buscarPorId(Long id) {
        return productos.stream().filter(p -> p.getId().equals(id)).findFirst();
    }
    @Override
    public void guardar(Producto producto) {
        if (producto.getId() == null) producto.setId(siguienteId++);
        productos.removeIf(p -> p.getId().equals(producto.getId()));
        productos.add(producto);
    }
    public void eliminar(Long id) {
        productos.removeIf(p -> p.getId().equals(id));
    }
    public boolean existeCodigo(String codigo) {
        return productos.stream().anyMatch(p -> p.getCodigo().equalsIgnoreCase(codigo));
    }

    private static String norm(String x) { return x == null ? "" : x.toLowerCase(); }

    @Override
    public List<Producto> buscarPorTermino(String termino) {
        String t = termino == null ? "" : termino.trim().toLowerCase();
        return productos.stream()
                .filter(p -> norm(p.getCodigo()).contains(t)
                      || norm(p.getNombre()).contains(t)
                      || norm(p.getCategoria()).contains(t))
                .toList();
    }
}
