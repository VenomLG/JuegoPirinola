/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Profesor
 */
public class Cara {
    private String accion;

    public Cara(String accion) {
        this.accion = accion;
    }

    public String getAccion() {
        return accion;
    }
    
    @Override
    public String toString() {
        return "Cara = " + accion;
    }
}
