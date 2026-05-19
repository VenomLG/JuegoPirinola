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
            setFrijol(10);
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
            setFrijol(10);
            return aux;
        }
        return 0;
    }
    
    public int ponTodo(){
        int aux=frijol;
        frijol=0;
        setFrijol(10);
        return aux;
    }

    @Override
    public String toString() {
        return "Mesa con " + frijol + " frijoles";
    }  
}
