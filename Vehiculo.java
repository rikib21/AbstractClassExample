/**
 * Clase base abstracta que centraliza la identidad de cualquier vehículo.
 *  Define un ID privado con su respectivo acceso (getter)
 *  y establece un contrato obligatorio mediante un 
 * método abstracto para que cada tipo de vehículo tenga su propio 
 * patrón de movimiento.
 */

abstract class Vehiculo {
    private String id;

    public String getId(){
        return id;
    }
    abstract String patronMovimiento();
    abstract String patronMovimiento();

    abstract List<M> crearVehiculo(M m);
    abstract void listarVehiculo();
    abstract M buscarVehiculo(String id);
    abstract M modificarVehiculo(String id, String nuevoId);
    abstract List<M> eliminarVehiculo(String id);
    
}
