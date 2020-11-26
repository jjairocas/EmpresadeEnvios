package app;

public class Empresa {


    public int codigoEmpresa;
    public String nombreDelaEmpresa;
    public int numeroTelefonico;

    public Empresa(int codigoEmpresa, String nombreDelaEmpresa, int numeroTelefonico ) {


        this.codigoEmpresa = codigoEmpresa;
        this.nombreDelaEmpresa = nombreDelaEmpresa;
        this.numeroTelefonico = numeroTelefonico;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Empresa)) {
            return false;
        }
        Empresa otraEmpresa = (Empresa) obj;

        if (this.codigoEmpresa == otraEmpresa.codigoEmpresa) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "codigoEmpresa=" + codigoEmpresa +
                ", nombreDelaEmpresa='" + nombreDelaEmpresa + '\'' +
                ", numeroTelefonico=" + numeroTelefonico +
                '}';
    }
}
