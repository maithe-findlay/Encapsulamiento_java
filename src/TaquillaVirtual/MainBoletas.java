package TaquillaVirtual;

import javax.swing.*;

public class MainBoletas {
    public static void main(String[] args) {
        Partido partido = new Partido("Deportes Quindio","América de Cali","Sábado 2 de Agosto, 2025");

        // varible de estado
        int disponiblesNorte = 100;
        int disponiblesSur = 100;
        int disponiblesVIP = 20;

        int precioNorte = 50000;
        int precioSur = 50000;
        int precioVIP = 200000;

        double totalRecaudado= 0;

        boolean salir = false;

        while (!salir) {
            String opcion = JOptionPane.showInputDialog(
                    "TAQUILLA VIRTUAL - BOLETAS\n\n" +
                            "Partido: " + partido.getEquipoLocal() + " vs " + partido.getEquipoVisitante() + "\n" +
                            "Fecha: " + partido.getFecha() + "\n\n" +
                            "1. Comprar boletas\n" +
                            "2. Ver disponibilidad\n" +
                            "3. Ver total recaudado\n" +
                            "4. Salir\n\n" +
                            "Seleccione una opción:"
            );

            if (opcion == null) {
                break;
            }

            switch (opcion) {
                case "1":
                    // Mostrar las zonas disponibles
                    String zona = JOptionPane.showInputDialog(
                            "¿Qué zona desea?\n" +
                                    "1. Norte ($" + precioNorte + ")\n" +
                                    "2. Sur ($" + precioSur + ")\n" +
                                    "3. VIP ($" + precioVIP + ")\n" +
                                    "Ingrese el número de la zona:"
                    );

// Verifica si el usuario canceló
                    if (zona == null) {
                        break;
                    }

                    int disponibles = 0;
                    int precio = 0;
                    String nombreZona = "";

// Determinamos la  zona seleccionada
                    switch (zona) {
                        case "1":
                            disponibles = disponiblesNorte;
                            precio = precioNorte;
                            nombreZona = "Norte";
                            break;
                        case "2":
                            disponibles = disponiblesSur;
                            precio = precioSur;
                            nombreZona = "Sur";
                            break;
                        case "3":
                            disponibles = disponiblesVIP;
                            precio = precioVIP;
                            nombreZona = "VIP";
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Zona inválida. Intente nuevamente.");
                            continue;
                    }

// Preguntar cuántas boletas desea comprar
                    String cantidadStr = JOptionPane.showInputDialog("¿Cuántas boletas desea comprar en zona " + nombreZona + "?");

                    if (cantidadStr == null) {
                        break;
                    }

                    int cantidad;
                    try {
                        cantidad = Integer.parseInt(cantidadStr);
                        if (cantidad <= 0) {
                            JOptionPane.showMessageDialog(null, "Cantidad inválida.");
                            continue;
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Entrada inválida.");
                        continue;
                    }

// Verificar disponibilidad
                    if (cantidad > disponibles) {
                        JOptionPane.showMessageDialog(null, "No hay suficientes boletas disponibles en zona " + nombreZona + ".");
                        continue;
                    }

// Confirmar compra
                    int confirmar = JOptionPane.showConfirmDialog(null,
                            "Resumen de compra:\n" +
                                    "Zona: " + nombreZona + "\n" +
                                    "Cantidad: " + cantidad + "\n" +
                                    "Precio por unidad: $" + precio + "\n" +
                                    "Total: $" + (cantidad * precio) + "\n\n" +
                                    "¿Desea confirmar la compra?", "Confirmar", JOptionPane.YES_NO_OPTION);

                    if (confirmar == JOptionPane.YES_OPTION) {
                        // Actualizar variables
                        switch (nombreZona) {
                            case "Norte":
                                disponiblesNorte -= cantidad;
                                break;
                            case "Sur":
                                disponiblesSur -= cantidad;
                                break;
                            case "VIP":
                                disponiblesVIP -= cantidad;
                                break;
                        }

                        totalRecaudado += cantidad * precio;

                        JOptionPane.showMessageDialog(null, "¡Compra realizada con éxito!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Compra cancelada.");
                    }

                    break;
                case "2":
                    String mensaje = "DISPONIBILIDAD DE BOLETAS\n\n" +
                            "Norte: " + disponiblesNorte + " disponibles\n" +
                            "Sur: " + disponiblesSur + " disponibles\n" +
                            "VIP: " + disponiblesVIP + " disponibles";
                    JOptionPane.showMessageDialog(null, mensaje);
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "Total recaudado: $" + totalRecaudado);
                    break;
                case "4":
                    salir = true;
                    JOptionPane.showMessageDialog(null, "Gracias por usar la taquilla virtual. ¡Hasta pronto!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
            }
        }


    }
}