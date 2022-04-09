import java.time.ZoneId;
import java.util.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import com.google.guava;

public class Paciente {

    private int id;
    private String nombre;
    private String apellido;
    private String domicilio;
    private int dni;
    private String clave;
    private Date fechaNac;

    public void paciente() {

    }

    public void paciente(String nombre, String apellido, String domicilio, int dni, Date fechaNac) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.dni = dni;
        this.fechaNac = fechaNac;
    }

    // get y set Nombre del Paciente
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    // get y set Apellido del Paciente
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    // get y set Domicilio del Paciente
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getDomicilio() {
        return domicilio;
    }

    // get y set Fecha de Nacimiento del Paciente
    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    // calcula edad actual del Paciente
    public int getEdad() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate nacimiento = fechaNac.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(nacimiento, ahora);
        return periodo.getYears();
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getDni() {
        return dni;
    }

    public void setClave(String clave) {
        this.hashedClave = String sha256hex = Hashing.sha256().hashString(clave, StandardCharsets.UTF_8).toString();

    /*
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    String bCryptedPassword = bCryptPasswordEncoder.encode("password");
    boolean passwordIsValid = bCryptPasswordEncoder.matches("password", bCryptedPassword)
    */
    }
}
