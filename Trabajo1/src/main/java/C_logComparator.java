import java.util.Comparator;

    public class C_logComparator implements Comparator<C_logistico> {
        public  String criterio = null;


        public C_logComparator(String criterio) {
            this.criterio = criterio;
        }



        @Override
        public int compare(C_logistico cLogistico1, C_logistico cLogistico2) {
            if(criterio.equalsIgnoreCase("Cantidad de empleados")){
                return cLogistico1.empleados.size()-cLogistico2.empleados.size();
            }
            else if(criterio.equalsIgnoreCase("Cantidad de puntos de atencion")){
                return  cLogistico1.puntos_atencion.size()-cLogistico2.puntos_atencion.size();
            }
            return 0;
        }
    }
