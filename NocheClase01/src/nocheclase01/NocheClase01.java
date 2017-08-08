package nocheclase01;

import javax.swing.JOptionPane;

/**
 * Clase principal del proyecto Clase01 del curso Objetos
 *
 * @author Lenovo
 */
public class NocheClase01 {

    /**
     * Punto de entrada del proyecto
     *
     * @param args parametros ingresados desde consola.
     */
    public static void main(String[] args) {

        /*
        Curso: Programacion Orientado a Objetos
        Duracion: 150 hs
        Dias: Lunes Miercoles Viernes 19:00 a 22:20 hs
        Prefesor: Carlos Rios lawlercarlospatricio@gmail.com
        Materiales: Google Docs.
        
        Software: JDK 8.X         www.Oracle.com
                  Netbeans IDE    netbeans.org
        
        JDK Java Development Kit
        JDK Alternativo: OpenJDK
        
        IDE: Integrated Development Enviroment
        
        IDEs Alternativos: JDeveloper Eclipse Intellij
        
        Gestores de Proyectos: Maven o Gradle
         */
        //Comentarios de una sola linea
        /* Bloque de comentarios */
        /**
         * Comentarios Java Doc debe colocarse antes de la declaracion de clases
         * o antes de la declaracion de metodos.
         */
        //Java C++ C# Visual Basic son lenguajes tipados fuertes.
        //php Python JavaScrip son lenguajes tipados deviles.
        /*
        Lenguaje NO tipado
        var a = 2;
        a = "hola";
        a = 3.45;
        a = new Object();
         */
        {
            int g = 2;
            //String g = "hola";
        }

        String g = "hola";

        //Tipo de datos primitivos
        //Tipo de dato boolean      1 byte
        boolean bo = true;
        //sout TAB atajo para System.out.println();
        System.out.println(bo);
        bo = false;
        System.out.println(bo);

        //Tipo de dato byte         1 byte signed
        byte by = 125;
        System.out.println(by);

        //Tipo de datos short       2 bytes signed
        short sh = 2000;
        System.out.println(sh);

        //Tipo de dato int          4 bytes signed
        int i = 200000000;
        System.out.println(i);

        //Tipo de dato long         8 bytes signed
        long lo = 2000000000;
        System.out.println(lo);

        lo = 3000000000L;
        System.out.println(lo);

        //Tipo de dato char         2 bytes unsigned
        char ch = 65;
        System.out.println(ch);
        ch += 32;
        System.out.println(ch);

        //Tipos de datos primitivos decimales
        //tipo de datos double      32 bits
        float fl = 5.32f;
        System.out.println(fl);

        //tipo de dato double       64 bits
        double dl = 5.32;
        System.out.println(dl);

        fl = 10;
        dl = 10;
        System.out.println(fl / 3);
        System.out.println(dl / 3);

        fl = 100;
        dl = 100;
        System.out.println(fl / 3);
        System.out.println(dl / 3);

        //Clase String
        String text = "hola soy una cadena de caracteres";
        System.out.println(text);

        //Imprimir todo en mayusculas.
        for (int j = 0; j < text.length(); j++) {
            char letra = text.charAt(j);
            if (letra >= 97 && letra <= 122) {
                letra -= 32;
            }

            System.out.println((char) letra);
        }
        System.out.println(text.toLowerCase());
        System.out.println(text.toUpperCase());

        boolean log1 = true;

        if (log1) {
            System.out.println("verdad1");
        } else {
            System.out.println("falso1");
        }

        if (log1) {
            System.out.println("verdad2");
        } else {
            System.out.println("falso2");
        }

        // ? operador ternario dada la condicion evalua true o false
        System.out.println((log1) ? "verdad3" : "falso3");

        JOptionPane.showMessageDialog(null, text);
    }
}