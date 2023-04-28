import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class TGS extends JFrame {
    JButton jbVolver;
    ProyectoIntegrador pi;

    public TGS (ProyectoIntegrador obj){
        super("Teoria general de sistemas");
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
        Tablero t = new Tablero();
        add(t);
                
        jbVolver = new JButton("Volver");
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


