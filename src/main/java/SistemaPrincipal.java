import java.util.Scanner;

public class SistemaPrincipal {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args){

        String option1;
        label:
        while(true) {
            option1 = Menus.menuAutenticacion();
            switch (option1) {
                case "1": // Iniciar Sesión
                    Autenticacion.iniciarSesion();
                    if (Autenticacion.getAdmin_logeado() != null) {
                        // acciones de administrador
                        label1:
                        while (true) {
                            String opcion_admin = Menus.menuAdminstrador();
                            switch (opcion_admin) {
                                case "1":
                                    // adminstracion
                                    CRUD.crudClases();
                                    break;
                                case "2":
                                    //busqueda
                                    Busqueda.busqueda();
                                    break;
                                case "3":
                                    //Diagnostico de inconsistencias
                                    Diagnostico.diagnosticarInconsistencias();
                                    break;
                                case "4":
                                    // guardar la información
                                    GuardaCambio.guardar();
                                    break;
                                case "0":
                                    //Cerrar sesion y no guardar
                                    break label1;
                            }
                        }

                    } else if (Autenticacion.getEmpleado_logeado() != null) {
                        //acciones de empleado
                    } else if (Autenticacion.getCliente_logeado() != null) {
                        //acciones de cliente
                    }
                    break;
                case "2": // Registrarse
                    Registro.registrarse();
                    break;
                case "0": // Salir del programa
                    System.out.println("¡Adios!");
                    break label;
            }
        }
    }
}
