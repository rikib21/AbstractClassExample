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
