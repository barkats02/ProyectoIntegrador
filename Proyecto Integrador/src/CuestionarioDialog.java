import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class CuestionarioDialog extends JDialog {
    private JLabel preguntaLabel;
    private JRadioButton[] opcionesRadio;
    private JButton siguienteButton;
    private JButton anteriorButton;
    private JButton calificarButton;
    private ButtonGroup grupoOpciones;

    public CuestionarioDialog(String pregunta, String[] opciones) {
        setTitle("Cuestionario");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        crearGUI(pregunta, opciones);

        setVisible(true);
    }

    private void crearGUI(String pregunta, String[] opciones) {
        preguntaLabel = new JLabel(pregunta);
        preguntaLabel.setBounds(20, 20, 360, 30);
        add(preguntaLabel);

        opcionesRadio = new JRadioButton[opciones.length];
        grupoOpciones = new ButtonGroup();

        int posY = 60;
        for (int i = 0; i < opciones.length; i++) {
            opcionesRadio[i] = new JRadioButton(opciones[i]);
            opcionesRadio[i].setBounds(20, posY, 360, 20);
            grupoOpciones.add(opcionesRadio[i]);
            add(opcionesRadio[i]);
            posY += 30;
        }

        siguienteButton = new JButton("Siguiente");
        siguienteButton.setBounds(240, 200, 100, 30);
        add(siguienteButton);

        anteriorButton = new JButton("Anterior");
        anteriorButton.setBounds(120, 200, 100, 30);
        add(anteriorButton);

        calificarButton = new JButton("Calificar");
        calificarButton.setBounds(160, 240, 100, 30);
        add(calificarButton);
    }
}

