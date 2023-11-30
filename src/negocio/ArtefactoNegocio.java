package negocio;

import entidad.Artefacto;

public class ArtefactoNegocio {
    Artefacto artefacto;
    Artefacto[] artefactos;

    public ArtefactoNegocio() {
        artefactos = new Artefacto[10];
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
                artefactos[i] = artefacto;
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
                count++;
            }
        }
        return count;
    }
    
    public String artefactoMayorPrecio(){
        String artefactoMayorPrecio="";
        float precio = 0.0f;
        float mayor = 0.0f;
        int count = 0;
        for (int i = 0; i < artefactos.length; i++) {
            if(artefactos[i] != null){
                precio = artefactos[i].getPrecio();
                if(count == 0){
                    mayor = precio;
                    artefactoMayorPrecio = artefactos[i].getNombre();
                } else {
                    if(precio > mayor){
                        mayor = precio;
                        artefactoMayorPrecio = artefactos[i].getNombre();
                    }
                }
                count++;
            }
        }
        return artefactoMayorPrecio;
    }
    
}
