package negocio;

import entidad.Artefacto;

public class ArtefactoNegocio {
    Artefacto artefacto;
    Artefacto[] artefactos;
    private final float IGV = 0.18f;
    
    private float[][] precios = {
        //SONY
        {39.90f, 99.99f, 50.00f},
        //PANASONIC
        {44.50f, 110.00f, 66.99f},
        //SAMSUMG
        {54.90f, 109.99f, 69.00f},
        //LG
        {40.00f, 100.50f, 70.99f}  
    };

    public ArtefactoNegocio() {
        artefactos = new Artefacto[10];
    }
    
    public float precioEncontrado(int marca,int tipo){
        float precio = 0.00f;
        try {
            precio = precios[marca-1][tipo-1];
        } catch(Exception e){
            precio = 0.00f;
        }    
        return precio;
    }
    
    public boolean agregar(String nombre, String descripcion, String marca, String tipo, float precio, short cantidad){
        artefacto = new Artefacto(nombre, descripcion, marca, tipo, precio, cantidad);
        for (int i = 0; i < artefactos.length; i++) {
            if(artefactos[i] == null){
                artefactos[i] = artefacto;
                return true;
            }
        }
        return false;
    }
    
    public boolean actualizar(String idNombre, String nombre, String descripcion, String marca, String tipo, float precio, short cantidad){
        artefacto = new Artefacto(nombre, descripcion, marca, tipo, precio, cantidad);
        for (int i = 0; i < artefactos.length; i++) {
            if(artefactos[i] != null && artefactos[i].getNombre()==idNombre){
                artefactos[i] = artefacto;
                return true;
            }
        }
        return false;
    }
    
    public boolean eliminar(String idNombre){
        for (int i = 0; i < artefactos.length; i++) {
            if(artefactos[i] != null && artefactos[i].getNombre()==idNombre){
                artefactos[i] = null;
                return true;
            }
        }
        return false;
    }
    
    public Artefacto[] listarArtefactos(){
        return artefactos;
    }
    
    public int totalArtefactos(){
        int count =0;
        for (int i = 0; i < artefactos.length; i++) {
            if(artefactos[i] != null){
                count++; //Cantidad de artefactos ingresados por nombre
//                count+=artefactos[i].getCantidad(); //en caso sera por cantidad de ingresados productos 
            }
        }
        return count;
    }
    
//    public String artefactoMayorPrecio(){
//        String artefactoMayorPrecio="";
//        float precio = 0.0f;
//        float mayor = 0.0f;
//        int count = 0;
//        for (int i = 0; i < artefactos.length; i++) {
//            if(artefactos[i] != null){
//                precio = artefactos[i].getPrecio();
//                if(count == 0){
//                    mayor = precio;
//                    artefactoMayorPrecio = artefactos[i].getNombre();
//                } else {
//                    if(precio > mayor){
//                        mayor = precio;
//                        artefactoMayorPrecio = artefactos[i].getNombre();
//                    }
//                }
//                count++;
//            }
//        }
//        return artefactoMayorPrecio;
//    }
    
    public float artefactoMayorPrecio(){
        float precio = 0.00f;
        float mayor = 0.0f;
        int count = 0;
        for (int i = 0; i < artefactos.length; i++) {
            if(artefactos[i] != null){
                precio = artefactos[i].getPrecio();
                if(count == 0){
                    mayor = precio;
                } else {
                    if(precio > mayor){
                        mayor = precio;
                    }
                }
                count++;
            }
        }
        return mayor;
    }
    
    public float calcularSubTotal(){
        float subTotal = 0.00f;
        for (int i = 0; i < artefactos.length; i++) {
            if(artefactos[i] != null){
                subTotal += artefactos[i].getPrecio() * artefactos[i].getCantidad();
            }
        }
        return subTotal;
    }
    
    public float calcularIgv(){
        return (float) (calcularSubTotal() - calcularSubTotal()/(1 + IGV));
    }
    
    public float calcularTotal(){
        return (float) (calcularSubTotal() - calcularIgv());
    }
    
    public String obtenerDescripcion(String idNombre){
        String descripcion ="";
        for (int i = 0; i < artefactos.length; i++) {
            if(artefactos[i]!= null && artefactos[i].getNombre() == idNombre){
                descripcion = artefactos[i].getDescripcion();
                break;
            }
        }
        return descripcion;
    }
    
    public String obtenerTipo(String idNombre){
        String tipo = "";
        for (int i = 0; i < artefactos.length; i++) {
            if(artefactos[i]!= null && artefactos[i].getNombre() == idNombre){
                tipo = artefactos[i].getTipo();
                break;
            }
        }
        return tipo;
    }
    
}
