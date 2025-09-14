public class Nodo {
    // El valor que tendrá el nodo será tipo Empleado
    private Empleado empleado;
    // Punteros que indican la posición de los nodos
    private Nodo hijoIzquierdo;
    private Nodo hijoDerecho;

    // Constructor que crea el nodo "base"
    public Nodo (Empleado empleado) {
        this.empleado = empleado;
        this.hijoIzquierdo=null;
        this.hijoDerecho=null;
    }

    // Getters y setters para sus atributos
    public Empleado getEmpleado() {
        return this.empleado;
    }
    public Nodo getHijoDerecho() {
        return hijoDerecho;
    }
    public Nodo getHijoIzquierdo() {
        return hijoIzquierdo;
    }
    public void setHijoDerecho(Nodo hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }
    public void setHijoIzquierdo(Nodo hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    // Método para devolver los datos albergados en la clase
    @Override
    public String toString() {
        return "Empleado{" +
                "ID=" + this.empleado.getID() +
                ", nombre='" + this.empleado.getNombre() + '\'' +
                '}';
    }
}
