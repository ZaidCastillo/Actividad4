import javax.swing.*;

public class ArbolBinario {
    Nodo raiz = null;
    private int numElementos = 0;

    // Constructor para inicializar un árbol desde cero
    public ArbolBinario() {
    }

    // Método para insertar Empleados al árbol dependiendo de la organización (tomando en cuenta el ID del empleado)
    public void insertarElemento(Empleado empleado){
        Nodo nuevoNodo = new Nodo(empleado);
        if (this.raiz == null) {
           this.raiz = nuevoNodo;
            JOptionPane.showMessageDialog(null, "Se puso la raíz como: " + empleado, "Localización de empleado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Nodo temp = raiz;
            while(temp != null) {
                if (temp.getHijoDerecho() == null && temp.getHijoIzquierdo() == null) {
                    if (empleado.compareTo(temp.getEmpleado()) == 1) {
                        JOptionPane.showMessageDialog(null, empleado + " insertado como hijo derecho de: " + temp, "Localización de empleado", JOptionPane.INFORMATION_MESSAGE);
                        temp.setHijoDerecho(nuevoNodo);
                        temp = null;
                    } else {
                        JOptionPane.showMessageDialog(null, empleado + " insertado como hijo izquierdo de: " + temp, "Localización de empleado", JOptionPane.INFORMATION_MESSAGE);
                        temp.setHijoIzquierdo(nuevoNodo);
                        temp = null;
                    }
                } else if (empleado.compareTo(temp.getEmpleado()) == 1 && temp.getHijoDerecho() == null) {
                    JOptionPane.showMessageDialog(null, empleado + " insertado como hijo derecho de: " + temp, "Localización de empleado", JOptionPane.INFORMATION_MESSAGE);
                    temp.setHijoDerecho(nuevoNodo);
                    temp = null;
                } else if (empleado.compareTo(temp.getEmpleado()) == -1 && temp.getHijoIzquierdo() == null) {
                    JOptionPane.showMessageDialog(null, empleado + " insertado como hijo izquierdo de: " + temp, "Localización de empleado", JOptionPane.INFORMATION_MESSAGE);
                    temp.setHijoIzquierdo(nuevoNodo);
                    temp = null;
                } else {
                    if (empleado.compareTo(temp.getEmpleado()) == 1) {
                        temp = temp.getHijoDerecho();
                    } else {
                        temp = temp.getHijoIzquierdo();
                    }
                }
            }
        }
        numElementos++;
    }

    // Método para insertar Empleados dentro del método para eliminar Empleados (se requiere clase Nodo en vez de Empleado)
    public void insertarElemento(Nodo nuevoNodo){
        if (this.raiz == null) {
            this.raiz = nuevoNodo;
        } else {
            Nodo temp = raiz;
            while(temp != null) {
                if (temp.getHijoDerecho() == null && temp.getHijoIzquierdo() == null) {
                    if (nuevoNodo.getEmpleado().compareTo(temp.getEmpleado()) == 1) {
                        temp.setHijoDerecho(nuevoNodo);
                        temp = null;
                    } else {
                        temp.setHijoIzquierdo(nuevoNodo);
                        temp = null;
                    }
                } else if (nuevoNodo.getEmpleado().compareTo(temp.getEmpleado()) == 1 && temp.getHijoDerecho() == null) {
                    temp.setHijoDerecho(nuevoNodo);
                    temp = null;
                } else if (nuevoNodo.getEmpleado().compareTo(temp.getEmpleado()) == -1 && temp.getHijoIzquierdo() == null) {
                    temp.setHijoIzquierdo(nuevoNodo);
                    temp = null;
                } else {
                    if (nuevoNodo.getEmpleado().compareTo(temp.getEmpleado()) == 1) {
                        temp = temp.getHijoDerecho();
                    } else {
                        temp = temp.getHijoIzquierdo();
                    }
                }
            }
        }
    }

    // Método para buscar Empleados basándose en su ID.
    public Empleado buscarEmpleado (int id) {
        Empleado valor = new Empleado(id);
        Nodo temp = raiz;
        Nodo encontrado = null;

        while (temp!=null){
            if (valor.compareTo(temp.getEmpleado())==0){
                encontrado = temp;
                temp = null;
            } else if(temp.getHijoDerecho() == null && temp.getHijoIzquierdo() == null) {
                temp = null;
            } else if(valor.compareTo(temp.getEmpleado()) == 1 && temp.getHijoDerecho() != null) {
                temp = temp.getHijoDerecho();
            } else if(valor.compareTo(temp.getEmpleado()) == -1 && temp.getHijoIzquierdo() != null) {
                temp = temp.getHijoIzquierdo();
            } else {
                temp = null;
            }
        }
        if (encontrado != null) {
            return encontrado.getEmpleado();
        } else {
            return null;
        }
    }

    // Método para recorrer el árbol en manera Inorden
    public void inorden(){
        String recorrido = "Recorrido Inorden (Izquierdo - Raíz - Derecho):\n";
        recorrido += inorden(this.raiz);
        recorrido += "Número de empleados registrados: " +this.size();
        JOptionPane.showMessageDialog(null, recorrido, "Recorrido Inorden", JOptionPane.INFORMATION_MESSAGE);
    }
    public String inorden (Nodo r) {
        if (r == null) {
            return "";
        }
        return inorden(r.getHijoIzquierdo()) +
                r + "\n" +
                inorden(r.getHijoDerecho());
    }

    // Método para recorrer el árbol en manera Preorden
    public void preorden(){
        String recorrido = "Recorrido Preorden (Raíz - Izquierdo - Derecho):\n";
        recorrido += preorden(this.raiz);
        recorrido += "Número de empleados registrados: " +this.size();
        JOptionPane.showMessageDialog(null, recorrido, "Recorrido Preorden", JOptionPane.INFORMATION_MESSAGE);
    }
    public String preorden (Nodo r) {
        if (r== null) {
            return "";
        }
        return r + "\n" +
                preorden(r.getHijoIzquierdo()) +
                preorden(r.getHijoDerecho());
        }

    // Método para recorrer el árbol en manera Postorden
    public void postorden() {
        String recorrido = "Recorrido Postorden (Izquierdo - Derecho - Raíz):\n";
        recorrido += postorden(this.raiz);
        recorrido += "Número de empleados registrados: " +this.size();
        JOptionPane.showMessageDialog(null, recorrido, "Recorrido Postorden", JOptionPane.INFORMATION_MESSAGE);
    }
    public String postorden (Nodo r) {
        if (r == null) {
            return "";
        }
        return postorden(r.getHijoIzquierdo()) +
                postorden(r.getHijoDerecho()) +
                r + "\n";
    }

    // Método para eliminar Empleados considerando su posición para así asignar la nueva estructura del árbol
    public boolean eliminarElemento(Empleado empleado) {
        if (raiz == null) return false;
        raiz = eliminarElemento(raiz, empleado);
        numElementos--;
        return true;
    }
    private Nodo eliminarElemento(Nodo actual, Empleado empleado) {
        if (actual == null) return null;
        int cmp = empleado.compareTo(actual.getEmpleado());
        if (cmp < 0) {
            actual.setHijoIzquierdo(eliminarElemento(actual.getHijoIzquierdo(), empleado));
        } else if (cmp > 0) {
            actual.setHijoDerecho(eliminarElemento(actual.getHijoDerecho(), empleado));
        } else {
            // Caso 1: sin hijos
            if (actual.getHijoIzquierdo() == null && actual.getHijoDerecho() == null) {
                return null;
            }
            // Caso 2: una hoja
            if (actual.getHijoIzquierdo() == null) {
                return actual.getHijoDerecho();
            } else if (actual.getHijoDerecho() == null) {
                return actual.getHijoIzquierdo();
            }
            // Caso 3: dos hojas
            Nodo sucesor = encontrarMin(actual.getHijoDerecho());
            actual.setEmpleado(sucesor.getEmpleado());
            actual.setHijoDerecho(eliminarElemento(actual.getHijoDerecho(), sucesor.getEmpleado()));
        }
        return actual;
    }
    private Nodo encontrarMin(Nodo nodo) {
        while (nodo.getHijoIzquierdo() != null) {
            nodo = nodo.getHijoIzquierdo();
        }
        return nodo;
    }

    // Método para indicar el número de Empleados añadidos al árbol
    public int size() {
        return this.numElementos;
    }

    // Método para indicar si el árbol no tiene ningún elemento
    public boolean isEmpty(){
        return raiz == null;
    }

}