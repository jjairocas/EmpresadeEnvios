public class CentroLogistico {


    public int codigoCentroLogistico;
    public String nombreCentroLogistico;
    public String direccionCentroLogistico; //ID (contador)

    public CentroLogistico( int codigoCentroLogistico, String nombreCentroLogistico, String direccionCentroLogistico) {

        this.codigoCentroLogistico = codigoCentroLogistico;
        this.nombreCentroLogistico = nombreCentroLogistico;
        this.direccionCentroLogistico = direccionCentroLogistico;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CentroLogistico)) {
            return false;
        }
        CentroLogistico otroCentroLogistico = (CentroLogistico) obj;

        if( this.codigoCentroLogistico == otroCentroLogistico.codigoCentroLogistico &&
                this.direccionCentroLogistico.toLowerCase().equals(otroCentroLogistico.direccionCentroLogistico.toLowerCase())){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "CentroLogistico{" +
                "codigoCentroLogistico=" + codigoCentroLogistico +
                ", nombreCentroLogistico='" + nombreCentroLogistico + '\'' +
                ", direccionCentroLogistico='" + direccionCentroLogistico + '\'' +
                '}';
    }
}
