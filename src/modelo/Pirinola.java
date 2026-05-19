/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Profesor
 */
public class Pirinola {
    private ArrayList<Cara> caras;

    public Pirinola(ArrayList<Cara> caras) {
        this.caras = caras;
    }
    
    public Cara girar(){
        Random r=new Random();
        int pos=r.nextInt(7);
        return caras.get(pos);
    }
    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Cara cara : caras) {
            str.append(cara.toString());
            str.append("\n");
        }
        return str.toString();
    } 
}
