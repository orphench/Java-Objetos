package ar.org.centro8.curso.java.test;

import ar.org.centro8.curso.java.entities.Cuenta;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TestCollection {
    public static void main(String[] args) {
        //Interfaz List
        
        //Lista no tipada
        List lista1;
        
        lista1 = new ArrayList(10);
        //lista1 = new LinkedList(10);
        
        //ArrayList: veloz para ingreso de datos y para recuperar
        //           datos aleatorios
        
        //LinkedList: veloz para recorrer la lista.
        
        lista1.add(new Cuenta(1, "arg$"));
        lista1.add(new Cuenta(2, "arg$"));
        lista1.add(new Cuenta(3, "arg$"));
        lista1.add(new Cuenta(4, "arg$"));
        lista1.add("Hola");
        lista1.add(23);
        
        for (int i = 0; i < lista1.size(); i++) {
            System.out.println(lista1.get(i));
        }
        
        System.out.println("----------------------");
        for(Object obj: lista1){
        //Al no ser tipada puede contener cualquier cosa 
        //por eso es tipo Object
            System.out.println(obj);
        }
        System.out.println("-----------------------");
        //java 8
        lista1.forEach(item->System.out.println(item));
        
        System.out.println("------------------------");
        lista1.forEach(item->{
            System.out.println(item);
        });
        System.out.println("------------------------");
        lista1.forEach(System.out::println);//forma implisita 
        //operador que dice que el item va ser parametro del que le sigue
        
        //lista tipada
        List<Cuenta>lista2 = new ArrayList();
        //<Cuenta> significa Generics 
        lista2.add(new Cuenta(5, "arg$"));
        lista2.add(new Cuenta(6, "arg$"));
        lista2.add(new Cuenta(7, "arg$"));
        lista2.add(new Cuenta(8, "arg$"));
        //lista2.add("hola");
        
        lista2.forEach(System.out::println);
        
        Cuenta cuenta1 = (Cuenta)lista1.get(0);
        Cuenta cuenta2 = lista2.get(0);
        
        //copiara las cuentas de lista1 a lista2
        lista1.forEach(item->{
            if (item instanceof Cuenta) lista2.add((Cuenta)item);   
            });
        System.out.println("-----------------------------");
        lista2.forEach(System.out::println);
        
        //Interfaz Set
        Set<String> set;
        
        //HashSet: es la mas veloz de todas 
        //         y no garantiza el orden de los elementos
        set = new HashSet();
        set.add("Lunes");
        set.add("Martes");
        set.add("Luenes");
        set.add("Miercoles");
        set.add("Jueves");
        set.add("Viernes");       
        set.forEach(System.out::println);
        System.out.println("------------------------");
        //Theeset: almacena todo ordenado en un arbol
        set = new TreeSet();
        set.add("Lunes");
        set.add("Martes");
        set.add("Luenes");
        set.add("Miercoles");
        set.add("Jueves");
        set.add("Viernes");       
        set.forEach(System.out::println);
        System.out.println("-------------------------");
        //LinkedHashSet: almacena todos por orden de ingreso
        set = new LinkedHashSet();
        set.add("Lunes");
        set.add("Martes");
        set.add("Luenes");
        set.add("Miercoles");
        set.add("Jueves");
        set.add("Viernes");       
        set.forEach(System.out::println);
        
        Set<Cuenta>cuentas = new LinkedHashSet();
        cuentas.add(new Cuenta(10,"arg$"));
        cuentas.add(new Cuenta(10,"arg$"));
        cuentas.add(new Cuenta(10,"arg$"));
        cuentas.add(new Cuenta(10,"arg$"));
        /*
        cuentas.forEach(System.out::println);
        Cuenta c = new Cuenta(11, "arg$");
        cuentas.add(c);
        cuentas.add(c);
        cuentas.add(c);
        cuentas.add(c);
        */
        cuentas.forEach(System.out::println);
        cuentas.forEach(item->
                System.out.println(item.hashCode()));
        
    }
}
