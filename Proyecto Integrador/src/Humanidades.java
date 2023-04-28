import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

public class Humanidades extends JFrame {
    JButton jbVolver;
    ProyectoIntegrador pi;
    private JLabel label;
    private JTextArea textArea;
    private JScrollPane scrollPane;

    public Humanidades (ProyectoIntegrador obj){
        super("Humanidades");
        pi = obj;
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        crearGUI();
        
        setVisible(true);
    }
   

    public void crearGUI(){
        

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
       


        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        label.setBounds(50, 35, 300, 40);
        scrollPane.setBounds(50, 80, 400, 430);
        add(label);
        add(scrollPane);
                
        jbVolver = new JButton("Volver ");
        jbVolver.setBounds(570, 470,150, 30);
        jbVolver.setFocusable(false);
        jbVolver.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            evento_jbVolver();
            }
        });
        add(jbVolver);
    }

    public void evento_jbVolver(){
        setVisible(false);
        dispose();
        pi.setVisible(true);
    }
    
}
