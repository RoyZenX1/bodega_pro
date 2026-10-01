package pe.edu.utp.model;

public class Producto {
    private Long id;
    private String codigo;
    private String nombre;
    private String categoria;
    private double compra;
    private double venta;
    private int stock;
    private int stockMinimo;
    private String imagenUrl;

    public Producto() {}

    public Producto(Long id, String codigo, String nombre, String categoria, double compra, double venta, int stock, int stockMinimo, String imagenUrl) {
        this(id, codigo, nombre, categoria, compra, venta, stock, stockMinimo);
        this.imagenUrl = imagenUrl;
    }

    public Producto(Long id, String codigo, String nombre, String categoria, double compra, double venta, int stock, int stockMinimo) {
        this.id=id; this.codigo=codigo; this.nombre=nombre; this.categoria=categoria;
        this.compra=compra; this.venta=venta; this.stock=stock; this.stockMinimo=stockMinimo;
    }
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getCodigo(){return codigo;} public void setCodigo(String codigo){this.codigo=codigo;}
    public String getNombre(){return nombre;} public void setNombre(String nombre){this.nombre=nombre;}
    public String getCategoria(){return categoria;} public void setCategoria(String categoria){this.categoria=categoria;}
    public double getCompra(){return compra;} public void setCompra(double compra){this.compra=compra;}
    public double getVenta(){return venta;} public void setVenta(double venta){this.venta=venta;}
    public int getStock(){return stock;} public void setStock(int stock){this.stock=stock;}
    public int getStockMinimo(){return stockMinimo;} public void setStockMinimo(int stockMinimo){this.stockMinimo=stockMinimo;}
    public String getImagenUrl(){return imagenUrl;} public void setImagenUrl(String imagenUrl){this.imagenUrl=imagenUrl;}
}