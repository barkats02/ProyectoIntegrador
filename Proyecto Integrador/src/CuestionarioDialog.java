import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class CuestionarioDialog extends JDialog {
    private JLabel preguntaLabel;
    private JRadioButton[] opcionesRadio;
    private JButton siguienteButton;
    private JButton anteriorButton;
    private JButton calificarButton;
    private ButtonGroup grupoOpciones;
    JPanel panel;
    JRadioButton opcion1, opcion2, opcion3, opcion4;
    Humanidades hm;
    ProyectoIntegrador obj;
  
    

    public CuestionarioDialog() {
        setTitle("Cuestionario");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        crearGUI();

        setVisible(true);
    }

  

    private void crearGUI() {
        panel = new JPanel();
        panel.setSize(500, 500);      
        add(panel);
        

        grupoOpciones = new ButtonGroup();
        
        JButton cerrarButton = new JButton("Cerrar");
        cerrarButton.setBounds(150, 300, 100, 30);
        cerrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cerrar();
            }
        });
        panel.add(cerrarButton);

           
            
        preguntaLabel = new JLabel("¿Cuál es la capital de Francia?");

        // Crear los botones de opción
        opcion1 = new JRadioButton("Londres");
        opcion2 = new JRadioButton("París");
        opcion3 = new JRadioButton("Roma");
        opcion4 = new JRadioButton("Berlín");

        // Agrupar los botones de opción para que solo se pueda seleccionar uno
        ButtonGroup grupoOpciones = new ButtonGroup();
        grupoOpciones.add(opcion1);
        grupoOpciones.add(opcion2);
        grupoOpciones.add(opcion3);
        grupoOpciones.add(opcion4);

        // Agregar los componentes al panel
        panel.add(preguntaLabel);
        panel.add(opcion1);
        panel.add(opcion2);
        panel.add(opcion3);
        panel.add(opcion4);
        

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
    public void cerrar () {
        
        setVisible(false);
        dispose();
        hm = new Humanidades(obj);
        hm.setVisible(true);
    }
}

