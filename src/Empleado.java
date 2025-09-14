public class Empleado implements Comparable<Empleado> {
    // Atributo de identificación del empleado
    private int ID;
    // Atributo de nombre completo del empleado
    private String nombre;

    // Constructor para siempre contar con ambos atributos
    public Empleado(int ID, String nombre){
        this.ID= ID;
        this.nombre= nombre;
    }

    // Constructor usado solamente al momento de buscar/eliminar algún empleado
    public Empleado(int ID){
        this.ID= ID;
    }

    // Getters y setters para los atributos
    public int getID() {
        return ID;
    }
    public String getNombre() {
        return nombre;
    }


    // Metodo para comparar los IDs de los Empleados que se instancien
    @Override
    public int compareTo(Empleado o) {
        if(this.ID>o.getID()) {
            return 1;
        } else if (this.ID<o.getID()) {
            return -1;
        }
        return 0;
    }

    // Método para devolver los datos albergados en la clase
    @Override
    public String toString() {
        return "Empleado{" +
                "ID=" + ID +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
