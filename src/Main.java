import javax.swing.JOptionPane;
public class Main {
    public static void main(String[] args) {
        // Variable para usar en menú
        int opcion = 0;
        // Se instancia un árbol automáticamente
        ArbolBinario arbol = new ArbolBinario();

        do {
            try {
                // Menú principal mostrando las funcionalidades del sistema para la gestión de empleados
                String input = JOptionPane.showInputDialog(
                        null,
                        "1. Agregar un Empleado\n"
                                + "2. Recorrer el árbol (preorden)\n"
                                + "3. Recorrer el árbol (inorden)\n"
                                + "4. Recorrer el árbol (postorden)\n"
                                + "5. Buscar empleado por ID\n"
                                + "6. Eliminar empleado por ID\n"
                                + "7. Salir\n\n"
                                + "Elige una opción...",
                        "Árboles Binarios",
                        JOptionPane.QUESTION_MESSAGE
                );
                // Condición para salir del menú
                if (input == null) {
                    opcion = 7;
                } else {
                    opcion = Integer.parseInt(input);
                }

                switch (opcion) {
                    // Se agrega el Empleado pidiendo tanto ID como el nombre a asignar
                    case 1 -> {
                        int id = Integer.parseInt(
                                JOptionPane.showInputDialog(
                                        null, "Ingresa el ID (número)...",
                                        "Agregando Empleado", JOptionPane.QUESTION_MESSAGE
                                )
                        );
                        String nombre = JOptionPane.showInputDialog(
                                null, "Ingresa el nombre del empleado",
                                "Agregando Empleado", JOptionPane.QUESTION_MESSAGE
                        );
                        Empleado nuevo = new Empleado(id, nombre);
                        arbol.insertarElemento(nuevo);
                    }
                    // Se indica el orden de los empleados organizados en preorden
                    case 2 -> {
                        if (!arbol.isEmpty()) {
                            arbol.preorden();
                        } else {
                            JOptionPane.showMessageDialog(
                                    null, "El árbol está vacío",
                                    "Cuidado", JOptionPane.INFORMATION_MESSAGE
                            );
                        }
                    }
                    // Se indica el orden de los empleados organizados en inorden
                    case 3 -> {
                        if (!arbol.isEmpty()) {
                            arbol.inorden();
                        } else {
                            JOptionPane.showMessageDialog(
                                    null, "El árbol está vacío",
                                    "Cuidado", JOptionPane.INFORMATION_MESSAGE
                            );
                        }
                    }
                    // Se indica el orden de los empleados organizados en postorden
                    case 4 -> {
                        if (!arbol.isEmpty()) {
                            arbol.postorden();
                        } else {
                            JOptionPane.showMessageDialog(
                                    null, "El árbol está vacío",
                                    "Cuidado", JOptionPane.INFORMATION_MESSAGE
                            );
                        }
                    }
                    // Se busca el empleado basándose en el ID dado por el usuario y devolviendo su información
                    case 5 -> {
                        if (!arbol.isEmpty()) {
                            int id = Integer.parseInt(
                                    JOptionPane.showInputDialog(
                                            null, "Ingresa el ID a buscar(número)...",
                                            "Buscando Empleado", JOptionPane.QUESTION_MESSAGE
                                    )
                            );
                            Empleado resultado = arbol.buscarEmpleado(id);
                            if (resultado!= null) {
                                JOptionPane.showMessageDialog(null, "Se ha encontrado el Empleado: " + resultado, "Resultado de busqueda", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "No se encontró el Empleado con ID: " + id, "Resultado de busqueda", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(
                                    null, "El árbol está vacío",
                                    "Cuidado", JOptionPane.INFORMATION_MESSAGE
                            );
                        }
                    }
                    // Se elimina el empleado solamente con indicar su ID
                    case 6 -> {
                        if (!arbol.isEmpty()) {
                            int id = Integer.parseInt(
                                    JOptionPane.showInputDialog(
                                            null, "Ingresa el ID a eliminar(número)...",
                                            "Eliminando Empleado", JOptionPane.QUESTION_MESSAGE
                                    )
                            );
                            Empleado empPorEliminar = new Empleado(id);
                            Empleado datosEmpleado = arbol.buscarEmpleado(id);
                            boolean resultado = arbol.eliminarElemento(empPorEliminar);
                            if (resultado) {
                                JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente el Empleado: " + datosEmpleado, "Eliminación de Empleado", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "No se encontró el Empleado con ID: " + id, "Eliminación de Empleado", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(
                                    null, "El árbol está vacío",
                                    "Cuidado", JOptionPane.INFORMATION_MESSAGE
                            );
                        }
                    }
                    // Se finaliza la aplicación
                    case 7 -> JOptionPane.showMessageDialog(
                            null, "Aplicación finalizada",
                            "F I N", JOptionPane.INFORMATION_MESSAGE
                    );
                    default -> JOptionPane.showMessageDialog(
                            null, "Opción incorrecta",
                            "Alerta", JOptionPane.INFORMATION_MESSAGE
                    );
                }
            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null, "Error: Debe ingresar número");
            }
        } while (opcion != 7);
    }
}