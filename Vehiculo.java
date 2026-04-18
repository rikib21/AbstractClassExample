/**
 * Clase base abstracta que centraliza la identidad de cualquier vehículo.
 *  Define un ID privado con su respectivo acceso (getter)
 *  y establece un contrato obligatorio mediante un 
 * método abstracto para que cada tipo de vehículo tenga su propio 
 * patrón de movimiento.
 */

abstract class Vehiculo {
    private int id;

    public int getId(){
        return id;
    }
    abstract String patronMovimiento();
    
}
