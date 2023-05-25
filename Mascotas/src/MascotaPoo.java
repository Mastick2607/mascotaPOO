import java.util.ArrayList;
import java.util.HashMap;


import javax.swing.JOptionPane;

public class MascotaPoo {
    private String identificacion;
    private String nombre;
    private String especie;
    private int edad;

    public MascotaPoo() {
    }

    public MascotaPoo(String identificacion, String nombre, String especie, int edad) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }

    public void mostrarInformacion() {
    	System.out.println("------------Informacion----------");
        System.out.println("Identificación: " + identificacion);
        System.out.println("Nombre: " + nombre);
        System.out.println("Especie: " + especie);
        System.out.println("Edad: " + edad + " años");
        System.out.println("---------------------------------");
        hacerSonido();
        comida();
        }

    public void hacerSonido() {
        if (especie.equalsIgnoreCase("perro")) {
            System.out.println("¡Guau guau!");
        } else if (especie.equalsIgnoreCase("gato")) {
            System.out.println("¡Miau miau!");
        } else {
            System.out.println("La mascota no hace sonidos conocidos.");
        }
    }
    
    public void comida() {
        if (especie.equalsIgnoreCase("perro")) {
            System.out.println("¡come carne y pollo!");
        } else if (especie.equalsIgnoreCase("gato")) {
            System.out.println("¡come pescado!");
        } else {
            System.out.println("La mascota no tiene hambre.");
        }
    }


    public void ingresarDatos() {
    
        identificacion = JOptionPane.showInputDialog("Ingrese la identificación: ");
       
        nombre =JOptionPane.showInputDialog("Ingrese el nombre:");
     ;
        especie = JOptionPane.showInputDialog("Ingrese especie:");
      
         edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad:"));
    }

    public static void main(String[] args) {
        ArrayList<MascotaPoo> listaMascotas = new ArrayList<>();
        HashMap<String, MascotaPoo> mapaMascotas = new HashMap<>();
      
        int opcion;
          String menu="";
        do {
        	
        	menu="MENU\n";
        	menu+="1. Crear mascota\n";
          	menu+="2. Consultar mascota individual\n";
        	menu+="3. Consultar lista de mascotas\n";
        	menu+="4. Modificar una mascota\n";
        	menu+="5. Salir\n";
          	menu+="Ingrese una opción:\n ";
    
        
           opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcion) {
                case 1:
                	MascotaPoo mascota = new MascotaPoo();
                    mascota.ingresarDatos();
                    listaMascotas.add(mascota);
                    mapaMascotas.put(mascota.getIdentificacion(), mascota);
                    break;
                case 2:
              
                    String identificacion = JOptionPane.showInputDialog("Ingrese la identificación de la mascota a consultar: ") ;
                    if (mapaMascotas.containsKey(identificacion)) {
                    	MascotaPoo mascotaConsultada = mapaMascotas.get(identificacion);
                        mascotaConsultada.mostrarInformacion();
                    } else {
                        System.out.println("No se encontró ninguna mascota con la identificación ingresada.");
                    }
                    break;
                case 3:
                    System.out.println("Lista de mascotas:");
                    for (MascotaPoo mascotaLista : listaMascotas) {
                        mascotaLista.mostrarInformacion();
                    }
                    break;
                case 4:
                  
                    identificacion =JOptionPane.showInputDialog("Ingrese la identificación de la mascota a modificar: ") ;
                    if (mapaMascotas.containsKey(identificacion)) {
                    	MascotaPoo mascotaModificar = mapaMascotas.get(identificacion);
                        mascotaModificar.ingresarDatos();
                    } else {
                        System.out.println("No se encontró ninguna mascota con la identificación ingresada.");
                    }
                    break;
                case 5:
                    System.out.println("*************Saliendo del sistema***********");
                    System.out.println("**********************************************");
                    System.out.println("***¡Gracias por utilizar el sistema, hasta luego!****");
                    System.out.println("********************************************************");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }

    // Getter y Setter para los atributos

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}