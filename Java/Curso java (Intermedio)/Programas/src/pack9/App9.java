package pack9;

public class App9 {

    private int KilosDeRopa=0, TipoDeRopa=0, LlenadoDeAgua=0, ProcesoDeLavado=0, ProcesoDeSecado=0;
    /*
     * Kilos de ropa: 1 - 12 max
     * Tipo de ropa: 0 = blanca y 1 = color
     * Llenado de agua; 0 = no llenado y 1 = llenado
     * Proceso de lavado: 0 = no lavado y 1 = lavado
     * Proceso de secado: 0 = no secado y 1 = secado
     */

     public App9(int KilosDeRopa, int TipoDeRopa){
        this.KilosDeRopa = KilosDeRopa;
        this.TipoDeRopa = TipoDeRopa;
     }

    private void KilosDeRopa(){

        if(KilosDeRopa > 0 && KilosDeRopa < 13 ){
            System.out.println("\nLos kilos de ropa son: " + KilosDeRopa);
            System.out.println("Kilos de ropas válidos. Estamos listos para el siguiente proceso (Tipo de ropa)");
            KilosDeRopa = 1;
        }
        else{
            System.out.println("Los kilos de ropan son 0 o superan los 12 kilos.");
            System.out.println("No estamos listos para el siguiente proceso (Tipo de ropa)");
            KilosDeRopa = 0;
        }
    }

    private void TipoDeRopa(){
        KilosDeRopa();
        if(KilosDeRopa == 1){
            if(TipoDeRopa == 0){
                System.out.println("\nEl tipo de ropa es: Blanca / Lavado suave");
                System.out.println("Tipo de ropa clasificada. Estamos listos para el siguiente proceso (Llenado de agua)");
                TipoDeRopa = 1;
            }
            else if(TipoDeRopa == 1){
                System.out.println("\nEl tipo de ropa es: Color / Lavado intenso");
                System.out.println("Tipo de ropa clasificada. Estamos listos para el siguiente proceso (Llenado de agua)");
                TipoDeRopa = 1;
            }
            else{
                System.out.println("\nEl tipo de ropa no está especificado correctamente");
                System.out.println("Por este error, procederemos de la siguiente forma:\n");
                System.out.println("\nEl tipo de ropa es: Color / Lavado intenso");
                System.out.println("Tipo de ropa clasificada. Estamos listos para el siguiente proceso (Llenado de agua)");
                TipoDeRopa = 1;
            }
        }
    }

    private void LlenadoDeAgua(){
        TipoDeRopa();
        if(TipoDeRopa == 1){
            System.out.println("\nEstamos llenando la lavadora con agua. Esto puede tardar varios minutos...");
            System.out.println("Llenado de agua completado. Estamos listos para el siguiente proceso (Lavado)");
            LlenadoDeAgua = 1;
        }
        else{
            System.out.println("\nEl proceso anterior (Tipo de ropa) no se ejecutó o tuvo algún fallo.");
            System.out.println("No se puede continuar con el siguiente proceso (Llenado)");
            LlenadoDeAgua = 0;
        }
    }

    private void ProcesoDeLavado(){
        LlenadoDeAgua();
        if(LlenadoDeAgua == 1){
            System.out.println("\nEstamos lavando tus prendas. Esto tardará unas horas, se paciente.");
            System.out.println("Prendas lavadas. Estamos listos para el siguiente proceso (Secado)");
            ProcesoDeLavado = 1;
        }
        else{
            System.out.println("\nEl proceso anterior (Llenado) no se ejecutó o tuvo algún fallo.");
            System.out.println("No se puede continuar con el siguiente proceso (Lavado)");
            ProcesoDeLavado = 0;
       }
    }

    private void ProcesoDeSecado(){
        ProcesoDeLavado();
        if(ProcesoDeLavado == 1){
            System.out.println("\nEstamos secando tus prendas. Esto tardará unos minutos, se paciente");
            System.out.println("Prendas secadas. Puedes retirar las prendas de la lavadora");
            ProcesoDeSecado = 1;
        }
        else{
            System.out.println("\nEl proceso anterior (Lavado) no se ejecutó o tuvo algún fallo.");
            System.out.println("No se puede continuar con el siguiente proceso (Secado)");
            ProcesoDeSecado = 0;
        }
    }

    public void CicloFinalizado(){
        ProcesoDeSecado();
        if(ProcesoDeSecado == 1){
            System.out.println("\n\nTodos los procesos han sido ejecutados con éxito. Fin de procesos");
        }
        else{
            System.out.println("\n\nAlgún proceso de los anteriores no se ejecutó o tuvo algún fallo.");
            System.out.println("Llegamos al final de los procesos. (uno o mas procesos tuvieron algún fallo)\n\n");
        }
    }

    public int getTipoDeRopa(){
        return TipoDeRopa;
    }
    public void setTipoDeRopa(int TipoDeRopa){
        this.TipoDeRopa = TipoDeRopa;
    }

    
}
