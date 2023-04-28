import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;


public class Integral extends JFrame {
    JButton jbVolver, jbSiguiente;
    ProyectoIntegrador pi;
    
    public Integral(ProyectoIntegrador obj){
        super("Matematicas 3.");
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
        TableroIntegral t = new TableroIntegral();
        add(t);
                
        jbVolver = new JButton("Menu principal");
        jbVolver.setBounds(570, 470,150, 50);
        jbVolver.setFocusable(false);
        jbVolver.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            evento_jbVolver();
            }
        });
        add(jbVolver);
        
        jbSiguiente = new JButton("<html>Este boton<br> Va a hacer algo </html>");
        jbSiguiente.setBounds(80, 470, 150, 50);
        jbSiguiente.setFocusable(false);
        jbSiguiente.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbSiguiente.setToolTipText("PROXIMAMENTE");
        add(jbSiguiente);
    }
    
    public void evento_jbVolver(){
        setVisible(false);
        dispose();
        pi.setVisible(true);
    }
    
}