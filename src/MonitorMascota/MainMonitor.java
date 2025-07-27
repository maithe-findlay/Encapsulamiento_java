package MonitorMascota;

import javax.swing.*;

public class MainMonitor {
    public static void main(String[] args) {
        Monitor monitor1 = new Monitor("Maithe Mejia","101","Visita a colegio San Luis Rey");
        Monitor monitor2 = new Monitor("Carlos Rivera","102","Atención al cliente");
        Monitor monitor3 = new Monitor("Sofia Ruiz","103","Fotos con estudiantes Humboldt");
        Monitor monitor4 = new Monitor("Karen Loaiza","104","Feria universitria - Unicentro");
        Monitor monitor5 = new Monitor("Miguel Fajardo","105","Conferencia Stem");

        boolean salir = false;

        while (!salir) {
            String opcion = JOptionPane.showInputDialog(
                    " GESTIÓN DE MONITORES \n" +
                            "1. Registrar Horas de un Monitor \n" +
                            "2. Ver Estado de Todos los Monitores \n" +
                            "3. Salir del Sistema \n\n" +
                            "Seleccione una opción:");

            if (opcion == null) continue; // Cancelar

            switch (opcion) {
                case "1":
                    String seleccion = JOptionPane.showInputDialog(
                            "Seleccione el monitor:\n" +
                                    "1. Maithe Mejia\n" +
                                    "2. Carlos Rivera\n" +
                                    "3. Sofia Ruiz\n" +
                                    "4. Karen loaiza\n" +
                                    "5. Miguel Fajardo");

                    if (seleccion == null) continue;

                    Monitor monitorSeleccionado = null;

                    switch (seleccion) {
                        case "1": monitorSeleccionado = monitor1; break;
                        case "2": monitorSeleccionado = monitor2; break;
                        case "3": monitorSeleccionado = monitor3; break;
                        case "4": monitorSeleccionado = monitor4; break;
                        case "5": monitorSeleccionado = monitor5; break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opción inválida.");
                            continue;
                    }

                    String inputHoras = JOptionPane.showInputDialog(
                            "Ingrese cuántas horas desea registrar para " + monitorSeleccionado.getNombre());

                    if (inputHoras == null) continue;

                    try {
                        double horas = Double.parseDouble(inputHoras);
                        if (horas <= 0) {
                            JOptionPane.showMessageDialog(null, "Debe ingresar un número mayor a 0.");
                        } else {
                            monitorSeleccionado.registrarHoras(horas);
                            JOptionPane.showMessageDialog(null,
                                    "Horas registradas con éxito.\n" +
                                            monitorSeleccionado.getNombre() + " ahora tiene " +
                                            monitorSeleccionado.getHorasAcumuladas() + " horas acumuladas.");
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Entrada inválida. Debe ingresar un número.");
                    }
                    break;

                case "2":
                    JTextArea areaTexto = new JTextArea();
                    areaTexto.setText(
                            "=== ESTADO DE MONITORES ===\n\n" +
                                    monitor1.toString() + "\n" +
                                    monitor2.toString() + "\n" +
                                    monitor3.toString() + "\n" +
                                    monitor4.toString() + "\n" +
                                    monitor5.toString());
                    areaTexto.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(areaTexto);
                    JOptionPane.showMessageDialog(null, scrollPane, "Resumen", JOptionPane.INFORMATION_MESSAGE);
                    break;

                case "3":
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema. ¡Hasta pronto!");
                    salir = true;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Por favor, seleccione una opción válida.");
            }
        }
    }
}


