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
    public DronTransporte(String id,String nombreVehiculo){
        this.id = id;
        this.nombreVehiculo = nombreVehiculo;
    }
    public void setNombreVehiculo(String nombre){
        this.nombreVehiculo = nombre;
    }
    public String getNombreVehiculo(){
        return this.nombreVehiculo;
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
    //Contar Vehiculos
    public long contarVehiculos() {
        return dronTransporte.stream().count();
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
    //Mejora
    //Clasificación de vehículos agrupándolos por su patrón de movimiento
    public Map<String, List<DronTransporte>> clasificarVehiculosPorTipo() {
        return dronTransporte.stream()
            .collect(Collectors.groupingBy(DronTransporte::patronMovimiento));
    }
    //Busqueda Avanzada
    public List<DronTransporte> busquedaAvanzada(String inicialId, String tipo) {
        return dronTransporte.stream()
            .filter(dron -> dron.getId().startsWith(inicialId))
            .filter(dron -> dron.patronMovimiento().equalsIgnoreCase(tipo))
            .toList();
    }

    
}
