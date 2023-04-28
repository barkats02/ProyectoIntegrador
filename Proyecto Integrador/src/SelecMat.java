
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.border.LineBorder;


public class SelecMat extends JFrame {
    JButton jbMat2, jbMat3, jbVolver;
    ProyectoIntegrador pi;
    
    public SelecMat(ProyectoIntegrador obj){
        super("Matematicas 3.");
        
        JLabel jTitulo = new JLabel("Area de Matematicas");
        jTitulo.setBounds(0, 100, 800, 50);
        jTitulo.setOpaque(true);
        jTitulo.setFont(new Font("Comic Sans", Font.ITALIC, 30));
        jTitulo.setHorizontalAlignment(JLabel.CENTER);
        add(jTitulo);
        
        
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
        
        ImageIcon img = new ImageIcon(getClass().getResource("Imagenes/Integrales.png"));
        ImageIcon img2 = new ImageIcon(getClass().getResource("Imagenes/Sumatory.png"));
                
        jbMat2 = new JButton(img);
        jbMat2.setBounds(200, 200,128, 128);
        jbMat2.setFocusable(false);
        jbMat2.setToolTipText("Ir a Matematicas 2");
        jbMat2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            evento_Mat2();
            }
        });
        add(jbMat2);
        
        jbMat3 = new JButton(img2);
        jbMat3.setBounds(472, 200, 128, 128);
        jbMat3.setFocusable(false);
        jbMat3.setToolTipText("Ir a Matematicas 3");
        jbMat3.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            evento_Mat3();
            }
        });
        add(jbMat3);
        
        jbVolver = new JButton("Menu principal");
        jbVolver.setBounds(570, 470,150, 50);
        jbVolver.setFocusable(false);
        jbVolver.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            evento_jbVolver();
            }
        });
        add(jbVolver);
    }
    
    public void evento_Mat2(){
        Mate2 v1 = new Mate2(pi);
        setVisible(false);
    }
    
    public void evento_Mat3(){
        Integral v2 = new Integral(pi);
        setVisible(false);
    }
    
    public void evento_jbVolver(){
        setVisible(false);
        dispose();
        pi.setVisible(true);
    }
}