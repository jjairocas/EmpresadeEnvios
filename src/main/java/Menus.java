import java.util.Scanner;

public class Menus {
    public static Scanner input = new Scanner(System.in);
    public static String menuAutenticacion(){
        String opcion;
        System.out.println();
        System.out.println("_____________________________________________________________");
        System.out.println(" LOGIN");
        System.out.println("_____________________________________________________________");
        System.out.println("1. Iniciar Sesión");
        System.out.println("2. Registrarse");
        System.out.println("0. Salir");
        System.out.println("_______________________________________________________________");
        System.out.print("opcion: ");
        opcion = input.next();
        return opcion;
    }

    public static String menuTipoUsuarioIngreso(){
        String opcion;
        System.out.println("SELECCIONE EL TIPO DE USUARIO:");
        System.out.println("1.Administrador");
        System.out.println("2.Cliente");
        System.out.println("3.Empleado");
        System.out.println("0.Atras");
        opcion = input.next();
        return opcion;
    }
    public static String menuAdminstrador(){
        String opcion;
        System.out.println("___________________________________________");
        System.out.println("SELECCIONE LO QUE DESEA REALIZAR :");
        System.out.println("1.Administración");
        System.out.println("2.Búsqueda");
        System.out.println("3.Diagnóstico de inconsistencias");
        System.out.println("4.Guardar");
        System.out.println("0.Cerrar sesion y no guardar");
        opcion = input.next();
        return opcion;
    }

    public static String menuAdminstracion(){
        String opcion;
        System.out.println("___________________________________________");
        System.out.println("SELECCIONE  :");
        System.out.println("1.Empresas");
        System.out.println("2.Sedes");
        System.out.println("3.Centros log+isticos");
        System.out.println("4.Puntos de atención");
        System.out.println("5.Empleados");
        System.out.println("6.Clientes");
        System.out.println("7.Paquetes");
        System.out.println("0. Atrás");
        opcion = input.next();
        return opcion;
    }

    public static String menuCrudEmpresas(){
        String opcion;
        System.out.println("___________________________________________");
        System.out.println("SELECCIONE LO QUE DESEA REALIZAR :");
        System.out.println("1.Ver empresas");
        System.out.println("2.Crear empresa");
        System.out.println("3.Editar empresa");
        System.out.println("4.Eliminar empresa");
        System.out.println("0.Atrás");
        opcion = input.next();
        return opcion;
    }

    public static String menuAtributoTexto(){
        String opcion;
        System.out.println("1.Valor exacto");
        System.out.println("2.Sin considerar mayúsculas");
        System.out.println("0 Atras");
        opcion = input.next();
        return opcion;
    }

    public static String menuOrdenEmpresas(){
        String opcion;
        System.out.println("___________________________________________");
        System.out.println("SELECCIONE El CRITERIO PARA ORDENAR :");
        System.out.println("1.Alfabeticamente");
        System.out.println("2.Por cantidad de sedes");
        System.out.println("3.Por cantidad de centros logísticos");
        System.out.println("4.Por cantidad de Puntos de atencion");
        System.out.println("5.Por cantidad de Empleados");
        System.out.println("6.Por cantidad de Clientes");
        System.out.println("7.Por cantidad de Paquetes registrados");
        System.out.println("0.Atrás");
        opcion = input.next();
        return opcion;
    }
    public static String menuCrudSedes(){
        String opcion;
        System.out.println("___________________________________________");
        System.out.println("SELECCIONE LO QUE DESEA REALIZAR :");
        System.out.println("1.Ver sedes");
        System.out.println("2.Crear sede");
        System.out.println("3.Editar sede");
        System.out.println("4.Eliminar sede");
        System.out.println("0.Atrás");
        opcion = input.next();
        return opcion;
    }
    public static String menuCrudCentrosLog(){
        String opcion;
        System.out.println("___________________________________________");
        System.out.println("SELECCIONE LO QUE DESEA REALIZAR :");
        System.out.println("1.Ver centro logistico");
        System.out.println("2.Crear centro logistico");
        System.out.println("3.Editar centro logístico");
        System.out.println("4.Eliminar centro logístico");
        System.out.println("0.Atrás");
        opcion = input.next();
        return opcion;
    }

    public static String menuCrudPuntosAtencion(){
        String opcion;
        System.out.println("___________________________________________");
        System.out.println("SELECCIONE LO QUE DESEA REALIZAR :");
        System.out.println("1.Ver Puntos Atencion");
        System.out.println("2.Crear Punto Atencion");
        System.out.println("3.Editar Punto de Atencion");
        System.out.println("4.Eliminar Punto de Atencion");
        System.out.println("0.Atrás");
        opcion = input.next();
        return opcion;
    }

    public static String menuCrudEmpleados(){
        String opcion;
        System.out.println("___________________________________________");
        System.out.println("SELECCIONE LO QUE DESEA REALIZAR :");
        System.out.println("1.Ver lista Empleados");
        System.out.println("2.Crear Empleado");
        System.out.println("3.Editar Empleado");
        System.out.println("4.Eliminar Empleado");
        System.out.println("0.Atrás");
        opcion = input.next();
        return opcion;
    }
    public static String menuCrudClientes(){
        String opcion;
        System.out.println("___________________________________________");
        System.out.println("SELECCIONE LO QUE DESEA REALIZAR :");
        System.out.println("1.Ver lista clientes");
        System.out.println("2.Crear cliente");
        System.out.println("3.Editar cliente");
        System.out.println("4.Eliminar cliente");
        System.out.println("0.Atrás");
        opcion = input.next();
        return opcion;
    }

    public static String menuCrudPaquetes(){
        String opcion;
        System.out.println("___________________________________________");
        System.out.println("SELECCIONE LO QUE DESEA REALIZAR :");
        System.out.println("1.Ver paquetes");
        System.out.println("2.Crear paquete");
        System.out.println("3.Editar paquete");
        System.out.println("4.Eliminar paquete");
        System.out.println("0.Atrás");
        opcion = input.next();
        return opcion;
    }
}
