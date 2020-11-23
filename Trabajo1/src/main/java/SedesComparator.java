import java.util.Comparator;

public class SedesComparator implements Comparator<Sede> {

    @Override
    public int compare(Sede sede1, Sede sede2) {
        return sede1.centros_logisticos.size()-sede2.centros_logisticos.size();
    }

}
