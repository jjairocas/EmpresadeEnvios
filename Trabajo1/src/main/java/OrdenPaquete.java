import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class OrdenPaquete {
    public static Scanner input = new Scanner(System.in);

    public static void ordenarAlfabeticamente(ArrayList<Paquete> Paquetes) {
        label:
        while (true) {
            System.out.println("1. Ascender numericamente");
            System.out.println("2. Descender numericamente");
            System.out.println("0. Atrás");
            String eleccion = input.next();
            ArrayList<String> codigos = new ArrayList<>();
            for (Paquete paquete : Paquetes) {
                codigos.add(paquete.codigo_paquete);
            }
            switch (eleccion) {
                case "1":
                    Collections.sort(codigos);
                    for (String nombre : codigos) {
                        for(Paquete paquete: Paquetes){
                            if(paquete.codigo_paquete.equalsIgnoreCase(nombre)){
                                System.out.println(paquete);
                            }
                        }
                    }
                    break;
                case "2":
                    Collections.sort(codigos, Collections.<String>reverseOrder());
                    for (String nombre : codigos) {
                        for(Paquete paquete: Paquetes){
                            if(paquete.codigo_paquete.equalsIgnoreCase(nombre)){
                                System.out.println(paquete);
                            }
                        }
                    }
                    break;
                case "0":
                    break label;
            }

        }

    }

}

