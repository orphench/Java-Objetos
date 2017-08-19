package nocheclase06;

public class TestException {
    
    public static void generarException(){
        int[] vector = new int[10];
        vector[20] = 30;
    }
    
    public static void generarException(boolean x){
        if(x) System.out.println(10/0);
    }
}
