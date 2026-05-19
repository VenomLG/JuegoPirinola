/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Profesor
 */
public class Mesa {
    private int frijol;

    public Mesa(int frijol) {
        this.frijol = frijol;
    }

    public void setFrijol(int frijol) {
        this.frijol = frijol;
    }
    
    public void toma(int val){
        frijol+=val;
    }
     
    public int pon(int val){
        if(frijol>val){
            frijol-=val;
            return val;
        }
        else if(frijol<=val){
            int aux=frijol;
            frijol=0;
            setFrijol(10);
            return aux;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Mesa con " + frijol + " frijoles";
    }

    public int getFrijol() {
        return frijol;
    }  
}
