/*
*La clase representa un camion autonomo, que hereda
* de vehiculo y tambien implementa la interfaz
* Iconectable, implementa el movimiento de un camion
* e implementa el metodo de interfaz que permite
* sincronizar el GPS
*/

package POO.ABS;

public class CamionAutonomo extends Vehiculo implements IConectable {
    @Override
    public String patronMovimiento(){
        return "Desplazamiento";
    }

    @Override
    public void sincronizarGPS() {
        System.out.println("Sincronizando GPS del Camion Autonomo...");
    }   
}
