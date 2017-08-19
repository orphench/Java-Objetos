package nocheclase06;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NocheClase06 {

    public static void main(String[] args){
        //System.out.println(10/0);
        //System.out.println("Esta linea no se ejecuta");
        /*
        try{
            //Colocar aca las lineas que pueden lanzar exception.
            //las lineas de este bloque tienen mas costo de hardware.
        }catch(Exception e){
            //Estas lineas se van a ejecutar si ocurre un error.
            //Se recibe un objeto de Exception.
        }(finally){
            //Estas lineas se ejecutan siempre.
        }
        //Estas lineas tambien se ejecutan siempre.
        */
//        try{
//            System.out.println(10/0);
//            System.out.println("Esta linea no se ejecuta.");
//        }catch(Exception e){
//            System.out.println("No se puede hacer eso vithe!");
//            System.out.println(e);
//        }
//        finally{
//            System.out.println("programa terminado normalmente");
//        }
//        
//        System.out.println("programa terminado normalmente");
          
        try {
            TestException.generarException(false);
        } catch (Exception e) {
              System.out.println(e);
        }
        
        //Captura personalizada de Exceptions.
        try {
            TestException.generarException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Indice fuera de rango.");
        }catch(ArithmeticException e){
            System.out.println("Division por 0."); 
        }catch(NumberFormatException e){
            System.out.println("Formato numerico incorrecto.");
        }catch(Exception e){
            System.out.println("Ocurrio un error no esperado.");
        }
        
        //Venta de pasajes
        System.out.println("---VUELOS---");
        Vuelo v1 = new Vuelo("aer123",100);
        Vuelo v2 = new Vuelo("Lan111",100);
        
        try {
            v1.venderPasajes(25);
            v2.venderPasajes(10);
            v1.venderPasajes(50);
            v2.venderPasajes(20);
            v1.venderPasajes(30);       //Lanzar Exception
            v2.venderPasajes(30);       //Esta venta no se se realiza
            
        } catch (NoHayMasPasajesException ex) {
            //Logger.getLogger(NocheClase06.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        
        //Api Reflect
        Class clazz = v1.getClass();
        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getSuperclass()); //para obtener la clase padre
        
        System.out.println("----------------------------");
        //obtiene los metodos de la clase (No me muestra metodos heredados)
        Method[] metodos = clazz.getDeclaredMethods();       
        for (Method m:metodos) System.out.println(m.getName());
        
        System.out.println("----------------------------");
        //obtiene los metodos de la clase (No me muestra metodos heredados)
        metodos = clazz.getMethods();       
        for (Method m:metodos) System.out.println(m.getName());
        
        String metodo = "metodo";
        //invocacion dinamica
        try {
            clazz.getMethod(metodo,null).invoke(v1, null);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        System.out.println("-------------------------");
        Constructor[] constructores = clazz.getConstructors();
        for(Constructor c:constructores) System.out.println(c);
        
        System.out.println("--------------------------");
        Field[] campos = clazz.getDeclaredFields();
        for(Field f:campos) System.out.println(f.getName());
        
        System.out.println("--------------------------");
        campos = clazz.getFields();
        for(Field f:campos) System.out.println(f);
        //NO CONFIAR EN LOS LOS PROFESORES
        
        
    }//main end
    
}//class end
