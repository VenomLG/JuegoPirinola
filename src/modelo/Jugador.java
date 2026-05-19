/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Profesor
 */
public class Jugador {
    private String nombre;
    private int frijol;
    private boolean estado;

    public Jugador(String nombre, int frijol) {
        this.nombre = nombre;
        this.frijol = frijol;
        this.estado = true;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFrijol() {
        return frijol;
    }

    public boolean getEstado() {
        return estado;
    }

    public void tomaUno(int val){
        frijol+=val;
    }
    
    public void tomaDos(int val){
        frijol+=val;
    }
    
    public void tomaTodo(int val){
        frijol+=val;
    }
    
    public int ponUno(){
        if(frijol>1){
            frijol-=1;
            return 1;
        }
        else if(frijol==1){
            frijol-=1;
            estado=false;
            return 1;
        }
        return 0;
    }

    public int ponDos(){
        if(frijol>2){
            frijol-=2;
            return 2;
        }
        else if(frijol<=2){
            int aux=frijol;
            frijol=0;
            estado=false;
            return aux;
        }
        return 0;
    }
    
    public int ponTodo(){
        int aux=frijol;
        frijol=0;
        estado=false;
        return aux;
    }
    
    @Override
    public String toString() {
        return "Jugador:" + "nombre=" + nombre + ", frijol=" + frijol + ", estado=" + estado;
    }
    
    
    
    
}
