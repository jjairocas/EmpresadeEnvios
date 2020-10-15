import java.util.Comparator;

public class PuntoAtencionComparator implements Comparator<P_atencion> {
    public  String criterio = null;


    public PuntoAtencionComparator(String criterio) {
        this.criterio = criterio;
    }


    @Override
    public int compare(P_atencion p1, P_atencion p2) {
        if(criterio.equalsIgnoreCase("Cantidad de clientes")){
            return p1.clientes.size()-p2.clientes.size();
        }
        else if(criterio.equalsIgnoreCase("Cantidad de paquetes por enviar")){
            return  p1.clientes.size()-p2.clientes.size();
        }
        return 0;
    }
}