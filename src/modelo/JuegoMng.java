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
        System.out.println(cara.getAccion());
        if(cara.getAccion() == "Pon uno")
            mesa.tomaUno(jugador.ponUno());
        else if(cara.getAccion() == "Pon dos")
            mesa.tomaDos(jugador.ponDos());
        else if(cara.getAccion() == "Pon todo")
            mesa.tomaTodo(jugador.ponTodo());
        else if(cara.getAccion() == "Toma uno")
            jugador.tomaUno(mesa.ponUno());
        else if(cara.getAccion() == "Toma dos")
            jugador.tomaDos(mesa.ponDos());
        else if(cara.getAccion() == "Toma todo")
            jugador.tomaTodo(mesa.ponTodo());
        else{
            int total=0;
            for (Jugador jdr : jugadores) {
                if(jdr.getEstado()==true)
                    total+=jdr.ponUno();
            }
            mesa.tomaTodo(total);
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
        while(hayGanador()==0){
            partida++;
            System.out.println("-----Partida "+ partida + " -------");
            partida();
        }
        if(hayGanador()==1){
            System.out.println("El ganador es: ");
            System.out.println(ganador().toString());
        }
        else
            System.out.println("\nNo hubo ganador...");
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
     * @return 1-Ganador 0 - jugadores activos -1-perdedores
     */
    public int hayGanador(){
        int cont=4;
        for (Jugador jdr : jugadores) {
            if(jdr.getEstado()==false)
                cont--;
        }
        if(cont>1){
            estadoJugadores();
            return 0;
        }
        else if(cont==1)
            return 1;
        else
            return -1;
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
