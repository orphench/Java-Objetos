package ar.org.centro8.curso.java.ejemplo;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapaCollections {
    //se puede usar sin crear un objeto de la clase
    public static Map<String, String> getMap(){
        Map<String, String>mapa = new LinkedHashMap();
        String ruta="java.util.";
        mapa.put("Lista con duplicados",ruta+"ArrayList");
        mapa.put("Lista sin duplicados", ruta+"HashSet");
        mapa.put("Lista sin duplicados ordenada", ruta+"TreeSet");
        mapa.put("Lista sin duplicados enlazada", ruta+"LinkedHashSet");
        
        return mapa;
    }
}
