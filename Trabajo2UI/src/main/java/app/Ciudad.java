package app;

public class Ciudad {
    public String nombre;
    public int poblacion;


    public Ciudad(String nombre, int poblacion) {
        this.nombre = nombre;
        this.poblacion = poblacion;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Ciudad)) {
            return false;
        }
        Ciudad otraCiudad = (Ciudad) obj;

        if(this.nombre.toLowerCase().equals(otraCiudad.nombre.toLowerCase()) &&
                this.poblacion == otraCiudad.poblacion
        ){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "Ciudad{" +
                "nombre='" + nombre + '\'' +
                ", poblacion=" + poblacion +
                '}';
    }
}