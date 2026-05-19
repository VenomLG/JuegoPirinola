/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package juegopirinola;

import java.util.ArrayList;
import modelo.Cara;
import modelo.JuegoMng;
import modelo.Jugador;
import modelo.Mesa;
import modelo.Pirinola;

/**
 *
 * @author Profesor
 */
public class JuegoPirinola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cara c1=new Cara("Toma uno");
        Cara c2=new Cara("Toma dos");
        Cara c3=new Cara("Toma todo");
        Cara c4=new Cara("Pon uno");
        Cara c5=new Cara("Pon dos");
        Cara c6=new Cara("Pon todo");
        Cara c7=new Cara("Todos ponen");

        ArrayList<Cara> caras=new ArrayList<Cara>();
        caras.add(c1);
        caras.add(c2);
        caras.add(c3);
        caras.add(c4);        
        caras.add(c5);
        caras.add(c6);
        caras.add(c7);
        
        Pirinola p=new Pirinola(caras);
        System.out.println(p.toString());
        
        ArrayList<Jugador> jugadores=new ArrayList<Jugador>();
        
        jugadores.add(new Jugador("Luis",10));
        jugadores.add(new Jugador("Aron",10));
        jugadores.add(new Jugador("Jose",10));
        jugadores.add(new Jugador("Juan",10));
        
        Mesa mesa=new Mesa(10);
        
        JuegoMng mng=new JuegoMng(p,mesa,jugadores);
        mng.jugar();
        
        
    }
    
}
