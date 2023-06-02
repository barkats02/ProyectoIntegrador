
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Humanidades extends JFrame {

    JButton jbVolver, jbsiguiente, jbanterior;
    ProyectoIntegrador pi;
    JComboBox<String> jcCapitulos;
    private JLabel label;
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private List<String> usuarios;
    private List<Double> puntajes;
    private int intentos;

    public Humanidades(ProyectoIntegrador obj) {
        super("Humanidades");
        pi = obj;
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        crearGUI();

        usuarios = new ArrayList<>();
        puntajes = new ArrayList<>();
        intentos = 0;

        setVisible(true);
    }

    private void crearGUI() {
        label = new JLabel("<html>Objetivos de desarrollo sostenible <br> establecidos por la ONU</html>");
        textArea = new JTextArea(10, 30);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setText("Objetivo 1: Poner fin a la pobreza en todas sus formas en todo el mundo"
                + "\n\nObjetivo 2: Poner fin al hambre"
                + "\n\nObjetivo 3: Garantizar una vida sana y promover el bienestar para todos en todas las edades"
                + "\n\nObjetivo 4: Garantizar una educación inclusiva, equitativa y de calidad y promover "
                + "\n\noportunidades de aprendizaje durante toda la vida para todos"
                + "\n\nObjetivo 5: Lograr la igualdad entre los géneros y empoderar a todas las mujeres y las niñas"
                + "\n\nObjetivo 6: Garantizar la disponibilidad de agua y su gestión sostenible y el saneamiento para todos"
                + "\n\nObjetivo 7: Garantizar el acceso a una energía asequible, segura, sostenible y moderna"
                + "\n\nObjetivo 8: Promover el crecimiento económico inclusivo y sostenible, el empleo y el trabajo decente para todos"
                + "\n\nObjetivo 9: Construir infraestructuras resilientes, promover la industrialización sostenible y fomentar la innovación"
                + "\n\nObjetivo 10: Reducir la desigualdad en y entre los países");

        textArea.setEnabled(false);

        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        label.setBounds(50, 35, 300, 40);
        scrollPane.setBounds(50, 80, 400, 430);
        add(label);
        add(scrollPane);

        jbVolver = new JButton("Volver");
        jbVolver.setBounds(50, 530, 150, 30);
        jbVolver.setFocusable(false);
        jbVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                evento_jbVolver();
            }
        });
        add(jbVolver);
        
        JButton cuestionarioButton = new JButton("Realizar cuestionario");
        cuestionarioButton.setBounds(470, 300, 200, 30);
        cuestionarioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarCuestionario();
            }
        });
        add(cuestionarioButton);
        
        JButton materialButton = new JButton("Material complementario");
        materialButton.setBounds(470, 350, 200, 30);
        materialButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirMaterialComplementario();
            }
        });
        add(materialButton);

        JLabel jlCapitulo = new JLabel("CAPITULOS");
        jlCapitulo.setBounds(470, 50, 120, 25);
        add(jlCapitulo);
        jcCapitulos = new JComboBox<>();
        jcCapitulos.setBounds(570, 50, 100, 25);
        jcCapitulos.addItem("CAPITULO 1");
        jcCapitulos.addItem("CAPITULO 2");
        jcCapitulos.addItem("CAPITULO 3");
        jcCapitulos.addItem("CAPITULO 4");
        jcCapitulos.addItem("CAPITULO 5");
        jcCapitulos.addItem("CAPITULO 6");
        jcCapitulos.addItem("CAPITULO 7");
        jcCapitulos.addItem("CAPITULO 8");
        jcCapitulos.addItem("CAPITULO 9");
        jcCapitulos.addItem("CAPITULO 10");
        jcCapitulos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Capitulos();
            }
        });
        add(jcCapitulos);

    }

    public void Capitulos() {

        String Capitulo = (String) jcCapitulos.getSelectedItem();
        switch (Capitulo) {
            case "CAPITULO 1":
                evento_cap(1);
                break;
            case "CAPITULO 2":
                evento_cap(2);
                break;
            case "CAPITULO 3":
                break;
            case "CAPITULO 4":
                break;
            case "CAPITULO 5":
                break;
            case "CAPITULO 6":
                break;
            case "CAPITULO 7":
                break;
            case "CAPITULO 8":
                break;
            case "CAPITULO 9":
                break;
            case "CAPITULO 10":
                break;
            default:
                throw new AssertionError();
        }

    }

    public void evento_cap(int opcion) {

        switch (opcion) {
            case 1:

                setVisible(false);
                dispose();

                JDialog dialog1 = new JDialog(this, "Ventana de Capitulo", true);
                dialog1.setSize(800, 600);
                dialog1.setLocationRelativeTo(this);
                dialog1.setLayout(null);

                JLabel objetivoLabel1 = new JLabel("Capitulo 1 ");
                objetivoLabel1.setBounds(50, 30, 300, 30);
                dialog1.add(objetivoLabel1);

                textArea = new JTextArea(10, 30);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setText("""
                                 Hola""");
                textArea.setEnabled(false);
                

                JScrollPane objetivoScrollPane = new JScrollPane(textArea);
                objetivoScrollPane.setBounds(50, 70, 580, 380);

                dialog1.add(objetivoScrollPane);

                jbVolver = new JButton("Volver");
                jbVolver.setBounds(50, 530, 150, 30);
                jbVolver.setFocusable(false);
                jbVolver.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        evento_jbVolver1();
                    }
                });
                dialog1.add(jbVolver);

                jbsiguiente = new JButton("Siguiente");
                jbsiguiente.setBounds(570, 530, 150, 30);
                jbsiguiente.setFocusable(false);
                jbsiguiente.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Siguiente1();
                    }
                });
                dialog1.add(jbsiguiente);

                dialog1.setVisible(true);

                break;
            case 2:

                setVisible(false);
                dispose();

                JDialog dialog2 = new JDialog(this, "Ventana de Capitulo", true);
                dialog2.setSize(800, 600);
                dialog2.setLocationRelativeTo(this);
                dialog2.setLayout(null);

                JLabel objetivoLabel2 = new JLabel("Capitulo 2 ");
                objetivoLabel2.setBounds(50, 30, 300, 30);
                dialog2.add(objetivoLabel2);
                
                textArea = new JTextArea(10, 30);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setText("""
                                 Hola""");
                textArea.setEnabled(false);

                JScrollPane objetivoScrollPane2 = new JScrollPane(textArea);
                objetivoScrollPane2.setBounds(50, 70, 580, 380);
                dialog2.add(objetivoScrollPane2);

                jbVolver = new JButton("Volver");
                jbVolver.setBounds(50, 530, 150, 30);
                jbVolver.setFocusable(false);
                jbVolver.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        evento_jbVolver2();
                    }
                });
                dialog2.add(jbVolver);

                jbsiguiente = new JButton("Siguiente");
                jbsiguiente.setBounds(570, 530, 150, 30);
                jbsiguiente.setFocusable(false);
                jbsiguiente.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Siguiente2();
                    }
                });
                dialog2.add(jbsiguiente);

                dialog2.setVisible(true);
                break;
            case 3:
                setVisible(false);
                dispose();

                JDialog dialog3 = new JDialog(this, "Ventana de Capitulo", true);
                dialog3.setSize(800, 600);
                dialog3.setLocationRelativeTo(this);
                dialog3.setLayout(null);

                JLabel objetivoLabel3 = new JLabel("Capitulo 3 ");
                objetivoLabel3.setBounds(50, 30, 300, 30);
                dialog3.add(objetivoLabel3);
                
                textArea = new JTextArea(10, 30);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setText("""
                                 Hola""");
                textArea.setEnabled(false);

                JScrollPane objetivoScrollPane3 = new JScrollPane(textArea);
                objetivoScrollPane3.setBounds(50, 70, 580, 380);
                dialog3.add(objetivoScrollPane3);

                jbVolver = new JButton("Volver");
                jbVolver.setBounds(50, 530, 150, 30);
                jbVolver.setFocusable(false);
                jbVolver.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        evento_jbVolver3();
                    }
                });
                dialog3.add(jbVolver);

                jbsiguiente = new JButton("Siguiente");
                jbsiguiente.setBounds(570, 530, 150, 30);
                jbsiguiente.setFocusable(false);
                jbsiguiente.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Siguiente3();
                    }
                });
                dialog3.add(jbsiguiente);

                dialog3.setVisible(true);
                break;

            case 4:
                setVisible(false);
                dispose();

                JDialog dialog4 = new JDialog(this, "Ventana de Capitulo", true);
                dialog4.setSize(800, 600);
                dialog4.setLocationRelativeTo(this);
                dialog4.setLayout(null);

                JLabel objetivoLabel4 = new JLabel("Capitulo 4 ");
                objetivoLabel4.setBounds(50, 30, 300, 30);
                dialog4.add(objetivoLabel4);
                
                textArea = new JTextArea(10, 30);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setText("""
                                 Hola""");
                textArea.setEnabled(false);

                JScrollPane objetivoScrollPane4 = new JScrollPane(textArea);
                objetivoScrollPane4.setBounds(50, 70, 580, 380);
                dialog4.add(objetivoScrollPane4);

                jbVolver = new JButton("Volver");
                jbVolver.setBounds(50, 530, 150, 30);
                jbVolver.setFocusable(false);
                jbVolver.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        evento_jbVolver4();
                    }
                });
                dialog4.add(jbVolver);

                jbsiguiente = new JButton("Siguiente");
                jbsiguiente.setBounds(570, 530, 150, 30);
                jbsiguiente.setFocusable(false);
                jbsiguiente.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Siguiente4();
                    }
                });
                dialog4.add(jbsiguiente);

                dialog4.setVisible(true);
                break;

            case 5:
                setVisible(false);
                dispose();

                JDialog dialog5 = new JDialog(this, "Ventana de Capitulo", true);
                dialog5.setSize(800, 600);
                dialog5.setLocationRelativeTo(this);
                dialog5.setLayout(null);

                JLabel objetivoLabel5 = new JLabel("Capitulo 5 ");
                objetivoLabel5.setBounds(50, 30, 300, 30);
                dialog5.add(objetivoLabel5);
                
                textArea = new JTextArea(10, 30);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setText("""
                                 Hola""");
                textArea.setEnabled(false);

                JScrollPane objetivoScrollPane5 = new JScrollPane(textArea);
                objetivoScrollPane5.setBounds(50, 70, 580, 380);
                dialog5.add(objetivoScrollPane5);

                jbVolver = new JButton("Volver");
                jbVolver.setBounds(50, 530, 150, 30);
                jbVolver.setFocusable(false);
                jbVolver.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        evento_jbVolver5();
                    }
                });
                dialog5.add(jbVolver);

                jbsiguiente = new JButton("Siguiente");
                jbsiguiente.setBounds(570, 530, 150, 30);
                jbsiguiente.setFocusable(false);
                jbsiguiente.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Siguiente5();
                    }
                });
                dialog5.add(jbsiguiente);

                dialog5.setVisible(true);
                break;

            case 6:
                setVisible(false);
                dispose();

                JDialog dialog6 = new JDialog(this, "Ventana de Capitulo", true);
                dialog6.setSize(800, 600);
                dialog6.setLocationRelativeTo(this);
                dialog6.setLayout(null);

                JLabel objetivoLabel6 = new JLabel("Capitulo 6 ");
                objetivoLabel6.setBounds(50, 30, 300, 30);
                dialog6.add(objetivoLabel6);
                
                textArea = new JTextArea(10, 30);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setText("""
                                 Hola""");
                textArea.setEnabled(false);

                JScrollPane objetivoScrollPane6 = new JScrollPane(textArea);
                objetivoScrollPane6.setBounds(50, 70, 580, 380);
                dialog6.add(objetivoScrollPane6);

                jbVolver = new JButton("Volver");
                jbVolver.setBounds(50, 530, 150, 30);
                jbVolver.setFocusable(false);
                jbVolver.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        evento_jbVolver6();
                    }
                });
                dialog6.add(jbVolver);

                jbsiguiente = new JButton("Siguiente");
                jbsiguiente.setBounds(570, 530, 150, 30);
                jbsiguiente.setFocusable(false);
                jbsiguiente.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Siguiente6();
                    }
                });
                dialog6.add(jbsiguiente);

                dialog6.setVisible(true);
                break;

            case 7:
                setVisible(false);
                dispose();

                JDialog dialog7 = new JDialog(this, "Ventana de Capitulo", true);
                dialog7.setSize(800, 600);
                dialog7.setLocationRelativeTo(this);
                dialog7.setLayout(null);

                JLabel objetivoLabel7 = new JLabel("Capitulo 7 ");
                objetivoLabel7.setBounds(50, 30, 300, 30);
                dialog7.add(objetivoLabel7);
                
                textArea = new JTextArea(10, 30);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setText("""
                                 Hola""");
                textArea.setEnabled(false);

                JScrollPane objetivoScrollPane7 = new JScrollPane(textArea);
                objetivoScrollPane7.setBounds(50, 70, 580, 380);
                dialog7.add(objetivoScrollPane7);

                jbVolver = new JButton("Volver");
                jbVolver.setBounds(50, 530, 150, 30);
                jbVolver.setFocusable(false);
                jbVolver.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        evento_jbVolver7();
                    }
                });
                dialog7.add(jbVolver);

                jbsiguiente = new JButton("Siguiente");
                jbsiguiente.setBounds(570, 530, 150, 30);
                jbsiguiente.setFocusable(false);
                jbsiguiente.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Siguiente7();
                    }
                });
                dialog7.add(jbsiguiente);

                dialog7.setVisible(true);
                break;

            case 8:
                setVisible(false);
                dispose();

                JDialog dialog8 = new JDialog(this, "Ventana de Capitulo", true);
                dialog8.setSize(800, 600);
                dialog8.setLocationRelativeTo(this);
                dialog8.setLayout(null);

                JLabel objetivoLabel8 = new JLabel("Capitulo 8 ");
                objetivoLabel8.setBounds(50, 30, 300, 30);
                dialog8.add(objetivoLabel8);
                
                textArea = new JTextArea(10, 30);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setText("""
                                 Hola""");
                textArea.setEnabled(false);

                JScrollPane objetivoScrollPane8 = new JScrollPane(textArea);
                objetivoScrollPane8.setBounds(50, 70, 580, 380);
                dialog8.add(objetivoScrollPane8);

                jbVolver = new JButton("Volver");
                jbVolver.setBounds(50, 530, 150, 30);
                jbVolver.setFocusable(false);
                jbVolver.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        evento_jbVolver8();
                    }
                });
                dialog8.add(jbVolver);

                jbsiguiente = new JButton("Siguiente");
                jbsiguiente.setBounds(570, 530, 150, 30);
                jbsiguiente.setFocusable(false);
                jbsiguiente.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Siguiente8();
                    }
                });
                dialog8.add(jbsiguiente);

                dialog8.setVisible(true);
                break;

            case 9:
                setVisible(false);
                dispose();

                JDialog dialog9 = new JDialog(this, "Ventana de Capitulo", true);
                dialog9.setSize(800, 600);
                dialog9.setLocationRelativeTo(this);
                dialog9.setLayout(null);

                JLabel objetivoLabel9 = new JLabel("Capitulo 9 ");
                objetivoLabel9.setBounds(50, 30, 300, 30);
                dialog9.add(objetivoLabel9);
                
                textArea = new JTextArea(10, 30);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setText("""
                                 Hola""");
                textArea.setEnabled(false);

                JScrollPane objetivoScrollPane9 = new JScrollPane(textArea);
                objetivoScrollPane9.setBounds(50, 70, 580, 380);
                dialog9.add(objetivoScrollPane9);

                jbVolver = new JButton("Volver");
                jbVolver.setBounds(50, 530, 150, 30);
                jbVolver.setFocusable(false);
                jbVolver.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        evento_jbVolver9();
                    }
                });
                dialog9.add(jbVolver);

                jbsiguiente = new JButton("Siguiente");
                jbsiguiente.setBounds(570, 530, 150, 30);
                jbsiguiente.setFocusable(false);
                jbsiguiente.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Siguiente9();
                    }
                });
                dialog9.add(jbsiguiente);

                dialog9.setVisible(true);
                break;

            case 10:
                setVisible(false);
                dispose();

                JDialog dialog10 = new JDialog(this, "Ventana de Capitulo", true);
                dialog10.setSize(800, 600);
                dialog10.setLocationRelativeTo(this);
                dialog10.setLayout(null);

                JLabel objetivoLabel10 = new JLabel("Capitulo 10 ");
                objetivoLabel10.setBounds(50, 30, 300, 30);
                dialog10.add(objetivoLabel10);
                
                textArea = new JTextArea(10, 30);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setText("""
                                 Hola""");
                textArea.setEnabled(false);

                JScrollPane objetivoScrollPane10 = new JScrollPane(textArea);
                objetivoScrollPane10.setBounds(50, 70, 580, 380);
                dialog10.add(objetivoScrollPane10);

                jbVolver = new JButton("Volver");
                jbVolver.setBounds(50, 530, 150, 30);
                jbVolver.setFocusable(false);
                jbVolver.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        evento_jbVolver10();
                    }
                });
                dialog10.add(jbVolver);

                jbsiguiente = new JButton("Cerrar");
                jbsiguiente.setBounds(570, 530, 150, 30);
                jbsiguiente.setFocusable(false);
                jbsiguiente.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        evento_jbVolver1();
                    }
                });
                dialog10.add(jbsiguiente);

                dialog10.setVisible(true);
                break;

        }

    }

    public void evento_jbVolver() {
        setVisible(false);
        dispose();
        pi.setVisible(true);
    }

    public void evento_jbVolver1() {
        setVisible(false);
        dispose();
        Humanidades hm = new Humanidades(pi);
        hm.setVisible(true);
    }

    public void evento_jbVolver2() {
        setVisible(false);
        dispose();
        evento_cap(1);
    }

    public void evento_jbVolver3() {
        setVisible(false);
        dispose();
        evento_cap(2);
    }

    public void evento_jbVolver4() {
        setVisible(false);
        dispose();
        evento_cap(3);
    }

    public void evento_jbVolver5() {
        setVisible(false);
        dispose();
        evento_cap(4);
    }

    public void evento_jbVolver6() {
        setVisible(false);
        dispose();
        evento_cap(5);
    }

    public void evento_jbVolver7() {
        setVisible(false);
        dispose();
        evento_cap(6);
    }

    public void evento_jbVolver8() {
        setVisible(false);
        dispose();
        evento_cap(7);
    }

    public void evento_jbVolver9() {
        setVisible(false);
        dispose();
        evento_cap(8);
    }

    public void evento_jbVolver10() {
        setVisible(false);
        dispose();
        evento_cap(9);
    }

    public void Siguiente1() {
        setVisible(false);
        dispose();
        evento_cap(2);
    }

    public void Siguiente2() {
        setVisible(false);
        dispose();
        evento_cap(3);
    }

    public void Siguiente3() {
        setVisible(false);
        dispose();
        evento_cap(4);
    }

    public void Siguiente4() {
        setVisible(false);
        dispose();
        evento_cap(5);
    }

    public void Siguiente5() {
        setVisible(false);
        dispose();
        evento_cap(6);
    }

    public void Siguiente6() {
        setVisible(false);
        dispose();
        evento_cap(7);
    }

    public void Siguiente7() {
        setVisible(false);
        dispose();
        evento_cap(8);
    }

    public void Siguiente8() {
        setVisible(false);
        dispose();
        evento_cap(9);
    }

    public void Siguiente9() {
        setVisible(false);
        dispose();
        evento_cap(10);
    }

    /*private void abrirVentanaDialog(int objetivoIndex) {
        JDialog dialog = new JDialog(this, "Ventana de Capitulo", true);
        dialog.setSize(800, 600);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(null);

        JLabel objetivoLabel = new JLabel("Capitulo " + (objetivoIndex + 1));
        objetivoLabel.setBounds(50, 30, 300, 30);
        dialog.add(objetivoLabel);

        JTextArea objetivo1TextArea = new JTextArea();
        objetivo1TextArea.setText(textArea.getText().split("\n\n")[objetivoIndex]);

        objetivo1TextArea.setEnabled(false);
        objetivo1TextArea.setEditable(false);

        JScrollPane objetivoScrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        objetivoScrollPane.setBounds(50, 70, 580, 380);
        dialog.add(objetivoScrollPane);

        
        dialog.setVisible(true);
    }*/

    private void abrirMaterialComplementario() {

    }

    private void realizarCuestionario() {
        if (intentos >= 2) {
            // El usuario ya ha alcanzado el límite de intentos
            return;
        }

        JDialog cuestionarioDialog = new JDialog(this, "Cuestionario", true);
        cuestionarioDialog.setSize(400, 300);
        cuestionarioDialog.setLocationRelativeTo(this);
        cuestionarioDialog.setLayout(null);

        // avanzar, retroceder y calificar
        JButton cerrarButton = new JButton("Cerrar");
        cerrarButton.setBounds(150, 230, 100, 30);
        cerrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cuestionarioDialog.dispose();
            }
        });
        cuestionarioDialog.add(cerrarButton);

        cuestionarioDialog.setVisible(true);

        // Actualizar los datos del usuario y enviar correo al docente
        usuarios.add("Nombre del usuario");
        puntajes.add(90.0); // Puntaje obtenido en el cuestionario

        intentos++;

        if (intentos == 2) {
            enviarCorreoDocente();
        }
    }

    private void enviarCorreoDocente() {

    }
}
