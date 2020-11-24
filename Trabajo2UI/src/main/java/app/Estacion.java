public class Estacion {
    public String nombre;

    public Estacion(String nombre) {
        this.nombre = nombre;
    }



    @Override
    public String toString() {
        return "Estacion{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Estacion)) {
            return false;
        }
        Estacion estacion = (Estacion) obj;

        return estacion.nombre.toLowerCase().equals(this.nombre.toLowerCase());
    }
}