/*
* Esta clase es utilizada para el control de todos
* los vehiculos, posee una lista que almacena cualquier
* tipo de vehiculo, almacena a traves de un metodo que lo agrega
* a la lista primeramente,y posteriormente posee un metodo que 
* monitorea todos los vehiculos.
*/
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
