/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Profesor
 */
public class JuegoMng {
    private Pirinola pirinola;
    private Mesa mesa;
    private ArrayList<Jugador> jugadores;

    public JuegoMng(Pirinola pirinola, Mesa mesa, ArrayList<Jugador> jugadores) {
        this.pirinola = pirinola;
        this.mesa = mesa;
        this.jugadores = jugadores;
    }
    
    /**
     * Recibe un jugador para el cual se lanza la pirinola y realiza la acción correspondiente
     * @param jugador 
     */
    public void turno(Jugador jugador){
        System.out.println(jugador.getNombre());
        Cara cara = pirinola.girar();
        String accion=cara.getAccion();
        System.out.println("Pirinola: " + accion);
        switch (accion) {
            case "Toma uno":
                jugador.toma(mesa.pon(1));                 
                break;
            case "Toma dos":
                jugador.toma(mesa.pon(2));
                break;
            case "Toma todo":
                jugador.toma(mesa.pon(mesa.getFrijol()));
                break;
            case "Pon uno":
                mesa.toma(jugador.pon(1));
                break;
            case "Pon dos":
                mesa.toma(jugador.pon(2));
                break;
            case "Pon todo":
                mesa.toma(jugador.pon(jugador.getFrijol()));
                break;
            default:
                int total=0;
                for (Jugador jdr : jugadores) {
                    if(jdr.getEstado()==true)
                        total+=jdr.pon(1);
                }
                mesa.toma(total);   
                break;
        }
    }
    
    /**
     * Asigna a cada jugador un turno
     */
    public void partida(){
        for (Jugador jdr : jugadores) {
            if(jdr.getEstado()!=false){
                turno(jdr);
                System.out.println(jdr.toString());
                System.out.println(mesa.toString());
            }
        }
    }
    
    /**
     * Mientras no haya ganador, lanza una nueva partida
     */
    public void jugar(){
        int partida=0;
        while(jugadorActivo()==0){
            partida++;
            System.out.println("-----Partida "+ partida + " -------");
            partida();
        }
        if(jugadorActivo()==1){
            partida++;
            System.out.println("-----Partida "+ partida + " -------");
            partida();
            if(jugadorActivo()==1){
                System.out.println("El ganador es: ");
                System.out.println(ganador().toString());
            }
            else{
                System.out.println("No hay ganador");
            }
        }
    }
    
     private Jugador ganador() {
         for (Jugador jdr : jugadores) {
             if(jdr.getEstado()==true)
                 return jdr;
         }
         return null;
     }
    
    /**
     * Metodo que indica si hay un ganador o no
     * @return 1 - un solo jugador activo, 0 - varios jugadores activos, -1-cero jugadores activos
     */
    public int jugadorActivo(){
        int cont=4;
        for (Jugador jdr : jugadores) {
            if(jdr.getEstado()==false)
                cont--;
        }
        estadoJugadores();
        if(cont>1) return 0;
        else if(cont==1) return 1;
        else return -1;
    }

    /**
     * Para cada jugador manda a imprimir su estado actual
     */
    private void estadoJugadores() {
        System.out.println("\n****Estado actual de los jugadores ");
        for (Jugador jdr : jugadores)
            System.out.println(jdr.toString());
        System.out.println("\n");
        
    }
}
