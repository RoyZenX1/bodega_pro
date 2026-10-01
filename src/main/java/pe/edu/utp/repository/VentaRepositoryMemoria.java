package pe.edu.utp.repository;

import java.util.*;
import org.springframework.stereotype.Repository;
import pe.edu.utp.model.Venta;

@Repository
public class VentaRepositoryMemoria implements VentaRepository {
    private final List<Venta> ventas = new ArrayList<>();
    private long siguienteId = 1L;

    public VentaRepositoryMemoria() {
        
    }

    @Override
    public List<Venta> listarTodos() { return List.copyOf(ventas); }
    @Override
    public Optional<Venta> buscarPorId(Long id) { return ventas.stream().filter(v -> v.getId().equals(id)).findFirst(); }
    @Override
    public void guardar(Venta venta) { if(venta.getId()==null) venta.setId(siguienteId++); ventas.removeIf(v->v.getId().equals(venta.getId())); ventas.add(venta); }
    
    
}
