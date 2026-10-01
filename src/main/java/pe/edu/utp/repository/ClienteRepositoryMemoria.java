package pe.edu.utp.repository;

import java.util.*;
import org.springframework.stereotype.Repository;
import pe.edu.utp.model.Cliente;

@Repository
public class ClienteRepositoryMemoria implements ClienteRepository {
    private final List<Cliente> clientes = new ArrayList<>();
    private long siguienteId = 1L;

    public ClienteRepositoryMemoria() {
        clientes.add(new Cliente(1L,"Juan Pérez","74859632","987654321","Av. Lima 123"));
clientes.add(new Cliente(2L,"María López","70654321","986123456","Jr. Sol 456"));
siguienteId=3;
    }

    @Override
    public List<Cliente> listarTodos() { return List.copyOf(clientes); }
    @Override
    public Optional<Cliente> buscarPorId(Long id) { return clientes.stream().filter(c -> c.getId().equals(id)).findFirst(); }
    @Override
    public void guardar(Cliente cliente) { if(cliente.getId()==null) cliente.setId(siguienteId++); clientes.removeIf(c->c.getId().equals(cliente.getId())); clientes.add(cliente); }
    public void eliminar(Long id) { clientes.removeIf(c->c.getId().equals(id)); }
    public boolean existeDocumento(String documento) { return clientes.stream().anyMatch(c->c.getDocumento().equalsIgnoreCase(documento)); }

    private static String norm(String x) { return x == null ? "" : x.toLowerCase(); }

    @Override
    public List<Cliente> buscarPorTermino(String termino) {
        String t = termino == null ? "" : termino.trim().toLowerCase();
        return clientes.stream()
                .filter(p -> norm(p.getNombre()).contains(t)
                      || norm(p.getDocumento()).contains(t))
                .toList();
    }
}
