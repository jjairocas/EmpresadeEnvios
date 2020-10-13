import java.util.ArrayList;
import java.util.Scanner;

public class CRUDPaquetes {

    public static ArrayList<Paquete> paquetes = CargarDatos.cargarPaquetes();
    public static Scanner input = new Scanner(System.in);

    public static void verPaquetes(){
        System.out.println("LISTADO DE PAQUETES: ");
        for(Paquete paquete : paquetes){
            System.out.println(paquete);
        }
    }

    //.... Falta el crear, editar y eliminar , es muy parecido a los otros CRUDS
}
