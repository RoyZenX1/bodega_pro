package pe.edu.utp.repository;

import java.util.*;
import org.springframework.stereotype.Repository;
import pe.edu.utp.model.Categoria;

@Repository
public class CategoriaRepositoryMemoria implements CategoriaRepository {
    private final List<Categoria> categorias = new ArrayList<>();
    private long siguienteId = 1L;

    public CategoriaRepositoryMemoria() {
        categorias.add(new Categoria(1L,"Lácteos","Leche, yogurt y derivados"));
categorias.add(new Categoria(2L,"Abarrotes","Arroz, azúcar y productos básicos"));
categorias.add(new Categoria(3L,"Bebidas","Gaseosas, agua y jugos"));
siguienteId=4;
    }

    @Override
    public List<Categoria> listarTodos() { return List.copyOf(categorias); }
    @Override
    public Optional<Categoria> buscarPorId(Long id) { return categorias.stream().filter(c -> c.getId().equals(id)).findFirst(); }
    @Override
    public void guardar(Categoria categoria) { if(categoria.getId()==null) categoria.setId(siguienteId++); categorias.removeIf(c->c.getId().equals(categoria.getId())); categorias.add(categoria); }
    public void eliminar(Long id) { categorias.removeIf(c->c.getId().equals(id)); }
    public boolean existeNombre(String nombre) { return categorias.stream().anyMatch(c->c.getNombre().equalsIgnoreCase(nombre)); }

    private static String norm(String x) { return x == null ? "" : x.toLowerCase(); }

    @Override
    public List<Categoria> buscarPorTermino(String termino) {
        String t = termino == null ? "" : termino.trim().toLowerCase();
        return categorias.stream()
                .filter(p -> norm(p.getNombre()).contains(t)
                      || norm(p.getDescripcion()).contains(t))
                .toList();
    }
}
