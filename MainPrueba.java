public class MainPrueba {
    public static void main(String[] args){
        // Instancia auxiliar que usaremos como gestor de la lista estática
        DronTransporte gestor = new DronTransporte("GESTOR","Dron Gestor");

        // 1. CREATE 
        System.out.println("\n--- 1. Ejecutando CREATE (Crear vehículos) ---");
        DronTransporte d1 = new DronTransporte("DRON-01","Dron de Carga Pesada");
        
        DronTransporte d2 = new DronTransporte("DRON-02","Dron de Mensajería Rápida");
        DronTransporte d3 = new DronTransporte("DRON-03","Dron de Monitoreo");

        gestor.crearVehiculo(d1);
        gestor.crearVehiculo(d2);
        gestor.crearVehiculo(d3);

        // 2. READ 
        gestor.listarVehiculo();


        // 4. UPDATE 
        DronTransporte modificado = gestor.modificarVehiculo("DRON-01", "DRON-100");
        if (modificado != null) {
            System.out.println("Modificación aplicada correctamente.");
        }
        System.out.println("Lista actualizada después de la modificación:");
        gestor.listarVehiculo();

        // 5. DELETE 
        gestor.eliminarVehiculo("DRON-02");
        
        System.out.println("Lista final de vehículos en el sistema:");
        gestor.listarVehiculo();
    }
}
