import java.util.*;
/*
* Clase que hereda de la clase vehiculo, represe-
* ta un dron de transporte
*/
public class DronTransporte extends Vehiculo<String> {
    private static List<DronTransporte> dronTransporte = new ArrayList<>();
    @Override
    String patronMovimiento() {
        return "Vuelo";
    }
    @Override
    public List<DronTransporte> crearVehiculo(DronTransporte v){
        dronTransporte.add(v);
        return dronTransporte;
    }
    @Override
    public void listarVehiculo(){
        if(dronTransporte.isEmpty()){
            System.out.print("No hay drones de transporte");
        }
        dronTransporte.forEach(System.out::println);
    }
    @Override
    public DronTransporte buscarVehiculo(String id){
       return dronTransporte.stream()
        .filter(dron -> dron.getId().equals(id))
        .findFirst()
        .orElse(null);
    }
    @Override
    public DronTransporte modificarVehiculo(String id, String nuevoId){
       DronTransporte existeDron = buscarVehiculo(id);

       Optional.ofNullable(existeDron)
       .ifPresent(dron -> dron.setId(nuevoId));
       return existeDron;
    }
    @Override
    public List<DronTransporte>eliminarVehiculo(String id){
        DronTransporte dron = buscarVehiculo(id);
        Optional.ofNullable(dron)
        .ifPresent(dronT -> dronTransporte.remove(dronT.getId()));
        return dronTransporte;
    }
    public void filtrarVehiculos(String inicial){
        dronTransporte.stream()
        .filter(v -> v.getId().startsWith(inicial))
        .forEach(System.out::println);
    }
    public List<String> obtenerListaId(){
        return dronTransporte.stream()
            .map(DronTransporte::getId)
            .toList();

    }
    public List<DronTransporte> buscarVehiculosPorTipo(String tipo){
        return dronTransporte.stream()
        .filter(v -> v.patronMovimiento().equalsIgnoreCase(tipo))
        .toList();
    }

    //Ordenamiento
    public void ordenarVehiculosPorId(){
        dronTransporte.stream()
        .sorted(Comparator.comparing(DronTransporte::getId))
        .forEach(System.out::println);
    }
    public void ordenarVehiculosPorTipo(){
        dronTransporte.stream()
        .sorted(Comparator.comparing(DronTransporte::patronMovimiento))
        .forEach(System.out::println);
    }

    
}
