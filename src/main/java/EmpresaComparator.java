import java.util.Comparator;

public class EmpresaComparator implements Comparator<EmpresaEnvio> {
    public  String criterio = null;

    public EmpresaComparator(String criterio) {
        this.criterio = criterio;
    }

    @Override
    public int compare(EmpresaEnvio empresa1, EmpresaEnvio empresa2) {
        if(criterio.equalsIgnoreCase("sedes")){
            return  empresa1.sedes.size() - empresa2.sedes.size();
        }else if(criterio.equalsIgnoreCase("centros logisticos")){
            int cant_centros1=0;
            int cant_centros2=0;
            for(Sede sede: empresa1.sedes){
                cant_centros1 += sede.centros_logisticos.size();
            }
            for(Sede sede: empresa2.sedes){
                cant_centros2 += sede.centros_logisticos.size();
            }
            return cant_centros1-cant_centros2;
        }else if(criterio.equalsIgnoreCase("puntos atencion")){
            int cant_puntos1=0;
            int cant_puntos2=0;
            for(Sede sede: empresa1.sedes){
                for(C_logistico centro : sede.centros_logisticos){
                    cant_puntos1+= centro.puntos_atencion.size();
                }
            }
            for(Sede sede: empresa2.sedes){
                for(C_logistico centro : sede.centros_logisticos){
                    cant_puntos2+= centro.puntos_atencion.size();
                }
            }
            return cant_puntos1-cant_puntos2;
        }else if(criterio.equalsIgnoreCase("empleados")){
            int cant_empleados1 = 0;
            int cant_empleados2 = 0;
            for(Sede sede: empresa1.sedes){
                for(C_logistico centro : sede.centros_logisticos){
                    cant_empleados1 += centro.empleados.size();
                }
            }
            for(Sede sede: empresa2.sedes){
                for(C_logistico centro : sede.centros_logisticos){
                    cant_empleados2 += centro.empleados.size();
                }
            }
            return cant_empleados1-cant_empleados2;
        }else if(criterio.equalsIgnoreCase("clientes")){
            int cant_clientes1 = 0;
            int cant_clientes2 = 0;
            for(Sede sede: empresa1.sedes){
                for(C_logistico centro : sede.centros_logisticos){
                    for(P_atencion punto : centro.puntos_atencion){
                        cant_clientes1 += punto.clientes.size();
                    }
                }
            }
            for(Sede sede: empresa2.sedes){
                for(C_logistico centro : sede.centros_logisticos){
                    for(P_atencion punto : centro.puntos_atencion){
                        cant_clientes2 += punto.clientes.size();
                    }
                }
            }
            return cant_clientes1-cant_clientes2;
        }else if(criterio.equalsIgnoreCase("paquetes")){
            int cant_paquetes1 = 0;
            int cant_paquetes2 = 0;
            for(Sede sede: empresa1.sedes){
                for(C_logistico centro : sede.centros_logisticos){
                    cant_paquetes1+= centro.paquetes.size();
                }
            }
            for(Sede sede: empresa2.sedes){
                for(C_logistico centro : sede.centros_logisticos){
                    cant_paquetes2 += centro.paquetes.size();
                }
            }
            return cant_paquetes1-cant_paquetes2;
        }

        return 0;
    }


}