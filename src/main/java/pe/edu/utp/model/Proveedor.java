package pe.edu.utp.model;

public class Proveedor {
    private Long id;
    private String nombre;
    private String ruc;
    private String telefono;
    private String direccion;

    public Proveedor() {}
    public Proveedor(Long id,String nombre,String ruc,String telefono,String direccion){
        this.id=id;this.nombre=nombre;this.ruc=ruc;this.telefono=telefono;this.direccion=direccion;
    }
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getNombre(){return nombre;} public void setNombre(String nombre){this.nombre=nombre;}
    public String getRuc(){return ruc;} public void setRuc(String ruc){this.ruc=ruc;}
    public String getTelefono(){return telefono;} public void setTelefono(String telefono){this.telefono=telefono;}
    public String getDireccion(){return direccion;} public void setDireccion(String direccion){this.direccion=direccion;}
}