import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
//import com.opencsv.*;
import java.time.*;

public class Main {


    public static void main(String[] args) throws IOException {
        System.out.println("Hola, bienvenido/a al Sistema de Gestión de Turnos.");
        bienvenida();
    }

    private static void bienvenida() {
        System.out.println("Para continuar, elija una de las siguientes opciones:");
        System.out.println("1. Sacar Turno");
        System.out.println("2. Crear nuevo Usuario");
        System.out.println("3. Gestionar Pacientes");
        Scanner scanner = new Scanner(System.in);
        int seleccion = scanner.nextInt();
        switch (seleccion) {
            case 1 -> loguearPaciente();
            case 2 -> crearUsuario();
            default -> {
                System.out.println("Opción no encontrada.");
                bienvenida();
            }
        }
    }

    private static void loguearPaciente() {
        try {
            int numDigitos = 0;
            int dni = 0;
            int clave = 0;
            while (numDigitos != 8) { //Corrobora que sean 8 dígitos.
                System.out.print("Por favor, ingrese los 8 números de su DNI para ingresar:");
                Scanner scanner = new Scanner(System.in);
                dni = scanner.nextInt();
                numDigitos = String.valueOf(dni).length();
                if (numDigitos != 8) {
                    System.out.println("Su DNI debe tener 8 dígitos.");
                }
            }
            while (numDigitos != 4) { //Corrobora que sean 4 dígitos.
                System.out.print("Ahora, ingrese los 4 números de su Clave San Camilo:");
                Scanner scanner = new Scanner(System.in);
                clave = scanner.nextInt();
                numDigitos = String.valueOf(clave).length();
                if (numDigitos != 4) {
                    System.out.println("Su Clave debe tener 4 dígitos. Inténtelo nuevamente.");
                }
            }

            String[] usuario = leerCSV(dni, clave);
            System.out.println(Arrays.toString(usuario));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String[] leerCSV(int dni, int clave) throws IOException {
        // Opens the file for reading
        try (BufferedReader br = new BufferedReader(new FileReader("usuarios.csv"))) {
            String s;
            // Reads it line by line
            while ((s = br.readLine()) != null) {
                // splits the string line using semicolons
                String[] values = s.split(";");
                String id = values[0];
                String nombre = values[1];
                String apellido = values[2];
                int dniGuardado = Integer.parseInt(values[3]);
                int claveGuardada = Integer.parseInt(values[4]);
                LocalDate registered = LocalDate.parse(values[5]);
                if (dni == dniGuardado) {
                    return values;
                }
            }
            return null;
        }
    }

    private static void crearUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su/s Nombre/s de pila: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese su/s Apellido/s: ");
        String apellido = scanner.nextLine();
        System.out.print("Ahora, " + nombre + ", ingresá los 8 dígitos de tu DNI: ");
        int dni = scanner.nextInt();
        System.out.println("Ingrese su domicilio:");
        String domicilio = scanner.nextLine();
        System.out.println("Genial, falta menos. Ingrese su fecha de nacimiento. Usa 2 dígitos para el día,");
        System.out.println("2 dígitos para el mes y cuatro para el año. Por ejemplo, 2 de marzo de 1973 sería: ");
        System.out.println("02031973");
        CharSequence fecha = scanner.nextInt();
        LocalDate fechaNac = new LocalDate();
        fechaNac.of(fecha.subSequence(4, 8), fecha.subSequence((2, 4), fecha.subSequence(0, 2)));

        Paciente paciente = new Paciente(nombre, apellido, domicilio, dni, fechaNac);

    }
}
