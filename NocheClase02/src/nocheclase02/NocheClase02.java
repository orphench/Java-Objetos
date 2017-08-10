package nocheclase02;

import javax.swing.JOptionPane;

public class NocheClase02 {

    public static void main(String[] args) {
        //Declaracion de clase interna
        class Auto{
            //Atributos
            String marca;
            String modelo;
            String color;
            int velocidad;
                    
            //El constructor vacio se agrega en tiempo de ejecucion           
            //Metodo constructor
            /**
             * Metodo deprecado por CH el 9/08/2017 pro ser inseguro
             * Usar en su remplazo:
             * Auto(Strig marca, String modelo, String color).
             * @deprecated
             */
            @Deprecated
            public Auto(){}//Constructor vacio explicito
            public Auto(String marca, String modelo, String color){
                this.marca = marca;
                this.modelo = modelo;
                this.color = color;
                this.velocidad = 0;
            }
            
            //Metodos
            public void acelerar(){ 
                //velocidad += 10;
                //velocidad=(velocidad+10>100)?velocidad = 100:velocidad + 10;
                acelerar(10);
            }
            //Metodo acelerar sobrecargado
            /**
             * Acelera el auto la velocidad que el usuario quiera.
             * @param kms 
             */
            public void acelerar(int kms){
                velocidad += kms;
                if (velocidad > 100) velocidad = 100;                 
                
            }
            public void frenar(){ velocidad -= 10;}
            
            public void velocidad(){System.out.println(velocidad);}
            public int getVelocidad(){return velocidad;}
            
            @Override //Indica que el metodo existe y esta sobre escrito
            public String toString(){
                return marca+" "+modelo+" "+color+" "+velocidad;
            }
            
        }//end class Auto
        
        System.out.println("--Auto--");
        Auto auto1 = new Auto();
        
        auto1.marca = "Ford";
        auto1.modelo = "Focus";
        auto1.color = "Verde";
        
        auto1.acelerar();
        auto1.acelerar();
        auto1.frenar();
        
        System.out.println(auto1.marca + " " +auto1.modelo+ " "
            +auto1.color+ " "+auto1.velocidad);
        
        System.out.println("--Auto2");
        Auto auto2 = new Auto();
        auto2.marca = "Fiat";
        auto2.modelo = "Idea";
        auto2.color = "Rojo";
        
        for (int i = 0; i <= 60; i++) auto2.acelerar();
                        
        System.out.println(auto2.marca + " " +auto2.modelo+ " "
            +auto2.color+ " "+auto2.velocidad);
        
        System.out.println("--Auto3--");
        Auto auto3 = new Auto("Ford", "Fiesta", "Blanco");
        auto3.acelerar();
        auto3.acelerar(25);
        auto3.velocidad();
        System.out.println(auto3.getVelocidad());
        
        //JOptionPane.showMessageDialog(null, auto3.getVelocidad());
        
        //Metodo toString() existe en la clase padre
        System.out.println(auto3.toString());
        System.out.println(auto3);
        
        //System.out.println(auto3.marca + " " +auto3.modelo+ " "
        //    +auto3.color+ " "+auto3.velocidad);
        
        int x;
        //System.out.println(x);
        //Error no se puede imprimir una variable no inicializada
        
    }//end Main
    
}//end class
