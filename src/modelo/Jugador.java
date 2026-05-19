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

    public void toma(int val){
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

    public int pon(int val){
        if(frijol>val){
            frijol-=val;
            return val;
        }
        else if(frijol<=val){
            int aux=frijol;
            frijol=0;
            estado=false;
            return aux;
        }
        return 0;
    }
    
    @Override
    public String toString() {
        return "Jugador: " + nombre + ", frijol= " + frijol + ", estado= " + estado;
    }
    
    
    
    
}
