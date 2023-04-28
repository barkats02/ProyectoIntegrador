import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.border.LineBorder;

public class acercaDE extends JFrame {
    JButton jbVolver;
    JLabel jlImg;
    ProyectoIntegrador pi;
     ImageIcon img1 = new ImageIcon(getClass().getResource("Imagenes/cris.jpg"));
        
     ImageIcon img2 = new ImageIcon(getClass().getResource("Imagenes/pipe.jpg"));

    public acercaDE (ProyectoIntegrador obj){
        super("Acerca de los programadores");
        pi = obj;
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        crearGUI();
        
        setVisible(true);
    }

    public void crearGUI(){
       
       
        jlImg = new JLabel();
        jlImg.setBackground(Color.WHITE);
        jlImg.setBounds(200, 50, 800, 400);
        add(jlImg);
        
        
        
        
        
        
        
        
        
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
    
    public void paint (Graphics g){
        
        super.paint(g);
        g.setFont(new Font("Tahoma", Font.ITALIC, 20));
        g.drawString("Programador 1                           Programador 2", 400, 70);
        g.drawString("Cristopher Arias 230222032", 350, 450);
        g.drawString("Felipe Gutierrez 230222001", 650, 460);

        

        g.drawImage(img1.getImage(), 350, 80, this);
        g.drawImage(img2.getImage(), 650, 80, this);

        


    
    
    
    
    }

    public void evento_jbVolver(){
        setVisible(false);
        dispose();
        pi.setVisible(true);
    }
    
}
