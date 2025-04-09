package Actividad_01;

public class TorresDeHanoi {
    static int movimientos=0;  //Contar movimientos
    
    public static void torresHanoi(int discos, int torre1, int torre2, int torre3){
    //Caso base: mover un solo disco
        if(discos == 1){
            System.out.println("Mover disco de torre"+" a torre " + torre3);
            movimientos++ ; // Incremento de cantidad de movimientos
        } else  {
            //Mover n-1 discos de la torre 1 a la torre 2, se usa torre 3 como auxiliar 
            torresHanoi(discos-1, torre1, torre3, torre2);
        
            //Mover disco más grande de la torre 1 a torre 3
            System.out.println("Moviendo disco de torre"+ torre1+"a torre"+ torre3);
            movimientos++ ; // Incremento de cantidad de movimientos

            //Mover n-1 discos de la torre 2 a la torre 3, se usa torre 1 cmo auxiliar
            torresHanoi(discos-1, torre2, torre1, torre3);
        }
    }
   
    public static int obtenerMovimientos(){
        return movimientos;
    }

    public  static void resetearMovimientos(){
        movimientos=0;
    }
}

