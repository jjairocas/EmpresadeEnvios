public class Sedes {

    public int codigoSede;
    public String nombreSede;
    public String correoSede;

    public Sedes( int codigoSedes, String nombreSedes, String correoSede) {

        this.codigoSede = codigoSedes;
        this.nombreSede = nombreSedes;
        this.correoSede = correoSede;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Sedes)) {
            return false;
        }
        Sedes otraSede = (Sedes) obj;

        if( this.codigoSede == otraSede.codigoSede){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "Sedes{" +
                "codigoSede=" + codigoSede +
                ", nombreSede='" + nombreSede + '\'' +
                ", correoSede='" + correoSede + '\'' +
                '}';
    }
}
