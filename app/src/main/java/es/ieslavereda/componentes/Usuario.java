package es.ieslavereda.componentes;

public class Usuario {
    private String nombre;
    private String apellidos;

    public Usuario(String nombre, String apellidos){
        this.apellidos=apellidos;
        this.nombre=nombre;
    }

    @Override
    public String toString(){
        return nombre + ", " + apellidos;
    }

}
