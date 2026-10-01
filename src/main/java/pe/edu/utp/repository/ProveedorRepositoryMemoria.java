package pe.edu.utp.repository;

import java.util.*;
import org.springframework.stereotype.Repository;
import pe.edu.utp.model.Proveedor;

@Repository
public class ProveedorRepositoryMemoria implements ProveedorRepository {
    private final List<Proveedor> proveedores = new ArrayList<>();
    private long siguienteId = 1L;

    public ProveedorRepositoryMemoria() {
        proveedores.add(new Proveedor(1L,"Distribuciones Lima SAC","20123456789","987111222","Av. Argentina 100"));
proveedores.add(new Proveedor(2L,"Alimentos del Norte SAC","20456789123","986222333","Jr. Comercio 250"));
siguienteId=3;
    }

    @Override
    public List<Proveedor> listarTodos() { return List.copyOf(proveedores); }
    @Override
    public Optional<Proveedor> buscarPorId(Long id) { return proveedores.stream().filter(p -> p.getId().equals(id)).findFirst(); }
    @Override
    public void guardar(Proveedor proveedor) { if(proveedor.getId()==null) proveedor.setId(siguienteId++); proveedores.removeIf(p->p.getId().equals(proveedor.getId())); proveedores.add(proveedor); }
    public void eliminar(Long id) { proveedores.removeIf(p->p.getId().equals(id)); }
    public boolean existeRuc(String ruc) { return proveedores.stream().anyMatch(p->p.getRuc().equalsIgnoreCase(ruc)); }

    private static String norm(String x) { return x == null ? "" : x.toLowerCase(); }

    @Override
    public List<Proveedor> buscarPorTermino(String termino) {
        String t = termino == null ? "" : termino.trim().toLowerCase();
        return proveedores.stream()
                .filter(p -> norm(p.getNombre()).contains(t)
                      || norm(p.getRuc()).contains(t))
                .toList();
    }
}
