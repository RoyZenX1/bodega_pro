package pe.edu.utp.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Venta {
    private Long id;
    private Cliente cliente;
    private LocalDateTime fecha;
    private List<DetalleVenta> detalles = new ArrayList<>();

    public Venta() {}
    public Venta(Long id,Cliente cliente,LocalDateTime fecha){this.id=id;this.cliente=cliente;this.fecha=fecha;}
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public Cliente getCliente(){return cliente;} public void setCliente(Cliente cliente){this.cliente=cliente;}
    public LocalDateTime getFecha(){return fecha;} public void setFecha(LocalDateTime fecha){this.fecha=fecha;}
    public List<DetalleVenta> getDetalles(){return detalles;} public void setDetalles(List<DetalleVenta> detalles){this.detalles=detalles;}
    public double getTotal(){return detalles.stream().mapToDouble(DetalleVenta::getSubtotal).sum();}
}