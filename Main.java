import java.io.*;
//import java.util.HashSet;
import java.util.Scanner;
import java.util.List;
import com.opencsv.*;

public class Main {

    String nombre;
    String apellido;
    int fechaNac;
    int id;
    static int dni;
    static int clave;
    static String[] usuario;

    public static void main(String[] args) throws IOException {
        System.out.println("Hola, bienvenido/a al Sistema de Gestión de la Clínica San Camilo.");
        System.out.println("Para continuar, elija una opción:");
        System.out.println("1. Ingresar con DNI");
        System.out.println("2. Soy usuario nuevo");
        Scanner elije = new Scanner(System.in);
        int elejido = elije.nextInt();
        if (elejido == 1) {
            int numDigitos = 0;
            while (numDigitos != 8) { //Corrobora que sean 8 dígitos.
                System.out.print("Por favor, ingrese los 8 números de su DNI para ingresar:");
                Scanner ident = new Scanner(System.in);
                dni = ident.nextInt();
                numDigitos = String.valueOf(dni).length();
                if (numDigitos != 8) {
                    System.out.println("Su DNI debe tener 8 dígitos.");
                }
            }
            while (numDigitos != 4) { //Corrobora que sean 4 dígitos.
                System.out.print("Ahora, ingrese los 4 números de su Clave San Camilo:");
                Scanner ident = new Scanner(System.in);
                clave = ident.nextInt();
                numDigitos = String.valueOf(clave).length();
                if (numDigitos != 4) {
                    System.out.println("Su Clave debe tener 4 dígitos. Inténtelo nuevamente.");
                }
            }
            String[] usuario = buscarUsuario(dni, clave);
        } else {
            crearUsuario();
        }
    }

    private static String[] buscarUsuario(int a, int b) {
        /* Busca el DNI del usuario en la Base de Datos USUARIOS (.csv).
         * Si la búsqueda arroja resultado, devuelve los datos del usuario.
         * Si la busqueda resulta negativa, invita al usuario a registrarse. */
        try {
            CSVReader csvFile = new CSVReader(new FileReader("usuarios.csv"));
            List<String[]> allData = csvFile.readAll();

//            while (allData.hasNext() != null) {
//                usuario = allData.next();
//                usuario.split(",");
//                System.out.print(usuario);
//            }

            for (String[] fila : allData) {
//                for (String dato : fila) {
//                    System.out.print(dato + "\t");
//                }
                System.out.println();
            }
            return usuario;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    static compararClave(clave) {
//        /* Compara el hash de la clave ingresada con el hash almacenado. */
//    }
    private static void crearUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su/s Nombre/s de pila: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese su/s Apellido/s: ");
        String apellido = scanner.nextLine();
        System.out.print("Ahora, " + nombre + ", ingresá los 8 dígitos de tu DNI: ");
        int dni = scanner.nextInt();
        System.out.println("Genial, falta menos. Ingresá tu fecha de nacimiento. Usa 2 dígitos para el día,");
        System.out.println("2 dígitos para el mes y cuatro para el año. Por ejemplo, 2 de marzo de 1973 sería: ");
        System.out.println("02031973");
        int fechaNac = scanner.nextInt();
        Usuario user = new Usuario();
        Console console = System.console();
        char[] password = console.readPassword();
        System.out.println("Password entered by user: " + new String(password));

/*
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String bCryptedPassword = bCryptPasswordEncoder.encode("password");
        boolean passwordIsValid = bCryptPasswordEncoder.matches("password", bCryptedPassword)
*/

    }
}
