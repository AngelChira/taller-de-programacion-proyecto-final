package entidad;

public class Artefacto {
    private String nombre;
    private String descripcion;
    private String marca;
    private String tipo;
    private float precio;
    private short cantidad;

    public Artefacto() {
        
    }

    public Artefacto(String nombre, String descripcion, String marca, String tipo, float precio, short cantidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.marca = marca;
        this.tipo = tipo;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public short getCantidad() {
        return cantidad;
    }

    public void setCantidad(short cantidad) {
        this.cantidad = cantidad;
    }
    
}