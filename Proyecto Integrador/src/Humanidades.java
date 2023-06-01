import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Humanidades extends JFrame {
    JButton jbVolver;
    ProyectoIntegrador pi;
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

        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        label.setBounds(50, 35, 300, 40);
        scrollPane.setBounds(50, 80, 400, 430);
        add(label);
        add(scrollPane);

        jbVolver = new JButton("Volver");
        jbVolver.setBounds(570, 470, 150, 30);
        jbVolver.setFocusable(false);
        jbVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                evento_jbVolver();
            }
        });
        add(jbVolver);

        String[] objetivos = textArea.getText().split("\n\n");
        for (int i = 0; i < objetivos.length; i++) {
            int objetivoIndex = i;
            JLabel objetivoLabel = new JLabel("Objetivo " + (i + 1));
            objetivoLabel.setBounds(500, 80 + i * 50, 200, 30);
            objetivoLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    abrirVentanaDialog(objetivoIndex);
                }
            });
            add(objetivoLabel);
        }
    }

    public void evento_jbVolver() {
        setVisible(false);
        dispose();
        pi.setVisible(true);
    }

    private void abrirVentanaDialog(int objetivoIndex) {
        JDialog dialog = new JDialog(this, "Ventana de Objetivo", true);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(null);

        JLabel objetivoLabel = new JLabel("Objetivo " + (objetivoIndex + 1));
        objetivoLabel.setBounds(50, 30, 300, 30);
        dialog.add(objetivoLabel);

        JTextArea objetivoTextArea = new JTextArea();
        objetivoTextArea.setText(textArea.getText().split("\n\n")[objetivoIndex]);
        objetivoTextArea.setEditable(false);

        JScrollPane objetivoScrollPane = new JScrollPane(objetivoTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        objetivoScrollPane.setBounds(50, 70, 300, 150);
        dialog.add(objetivoScrollPane);

        JButton materialButton = new JButton("Material complementario");
        materialButton.setBounds(100, 230, 200, 30);
        materialButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirMaterialComplementario();
            }
        });
        dialog.add(materialButton);

        JButton cuestionarioButton = new JButton("Realizar cuestionario");
        cuestionarioButton.setBounds(100, 270, 200, 30);
        cuestionarioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarCuestionario();
            }
        });
        dialog.add(cuestionarioButton);

        dialog.setVisible(true);
    }

    private void abrirMaterialComplementario() {
        // Lógica para abrir el material complementario en el programa por defecto del PC
        // Utiliza navegadores web y reproductores de video instalados en el PC
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
