/*
*La clase representa un camion autonomo, que hereda
* de vehiculo y tambien implementa la interfaz
* Iconectable, implementa el movimiento de un camion
* y asi mismo el metodo de interfaz que permite
* sincronizar el GPS
*/

package POO.ABS;

public class CamionAutonomo extends Vehiculo<CamionAutonomo> implements IConectable {
    private static List<CamionAutonomo> camionAutonomo;
    @Override
    public String patronMovimiento(){
        return "Desplazamiento";
    }

    @Override
    public void sincronizarGPS() {
        System.out.println("Sincronizando GPS del Camion Autonomo...");
    }   
    @Override 
    public List<CamionAutonomo> crearVehiculo(CamionAutonomo v){
        camionAutonomo.add(v);
        return camionAutonomo;
    }
    @Override
    public void listarVehiculo(){
        if(camionAutonomo.isEmpty()){
            System.out.println("No hay camiones de transporte");
        }
        camionAutonomo.forEach(System.out::println);
    }
    @Override
    public CamionAutonomom buscarVehiculo(String id){
        return camionAutonomo.stream();
        .filter(camion-> camion.getId().equals(id))
        .findFirst()
        .orseElse(null);
    }
    @Override
    public CamionAutonomo modificarVehiculo(String id, String nuevoId){
        CamionAutonomo existeCamion= buscarVehiculo(id);
         Optional.ofNullable(existeCamion)
        .ifPresent(camion-> camion.setId(nuevoId));
        return existeCamion;
    }
    @Override 
    public List<CamionAutonomo> eliminarVehiculo(String id){
        CamionAutonomo camion = buscarVehiculo(id);
        Optional.ofNullable(camion)
        .ifPresent(camionT-> camionAutonomo.remove(camionT.getId()));
        return dronTransporte;
    }
    public void filtrarVehiculos(String inicial){
        camionAutonomo.stream()
        .filter(v -> v.getId().startsWith(inicial))
        .forEach(System.out::println);
    }
    public List<String> obtenerListaId(){
        return camionAutonomo.stream()
            .map(CamionAutonomo::getId)
            .toList();
    }
    public List<DronTransporte> buscarVehiculosPorTipo(String tipo){
        return camionAutonomo.stream()
        .filter(v-> v.patronMovimiento().equalsIgnoreCase(tipo))
        .toList();
    }
    public void ordenarVehiculosPorId(){
        dronTransporte.stream()
        .sorted(Comparator.comparing(CamionAutonomo::getId))
        .forEach(System.out::println)
    }

    public void ordenarVehiculosPorTipo(){
        camionAutonomo.stream()
        .sorted(Comparator.comparing(CamionAutonomo::patronMovimiento))
        .forEach(System.out::println)
            
    }
}
    public Map<String, List<DronTransporte>> clasificarVehiculosPorTipo() {
        return dronTransporte.stream()
            .collect(Collectors.groupingBy(DronTransporte::patronMovimiento));
    }
    public List<DronTransporte> busquedaAvanzada(String inicialId, String tipo) {
        return dronTransporte.stream()
            .filter(dron -> dron.getId().startsWith(inicialId))
            .filter(dron -> dron.patronMovimiento().equalsIgnoreCase(tipo))
            .toList();
    }
    
    
    
        
}
