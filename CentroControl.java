import java.util.ArrayList;

public class CentroControl {
    private ArrayList<Vehiculo> vehiculos;
    public void registrarUnidad(Vehiculo v){
        vehiculos.add(v);
    }
    public void monitorearFlota(){
        for(Vehiculo v : vehiculos){
            v.patronMovimiento();
        }
    }
}
