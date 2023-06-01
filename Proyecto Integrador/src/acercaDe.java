import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.LineBorder;



public class acercaDe extends JFrame {
        JButton jbVolver;
        JComboBox<String> jcCombo;
        JLabel jlImg;
        
        public acercaDe (ProyectoIntegrador obj) {
        super("Información de los programadores");
        setSize(600, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        crearGUI();
        
        setVisible(true);
    }
        public void crearGUI() {
            
        jlImg = new JLabel();
        jlImg.setBounds(200, 60, 250, 333);
        jlImg.setBorder(new LineBorder(Color.BLACK));
        add(jlImg);
        
        jbVolver = new JButton("Volver");
        jbVolver.setBounds(10, 380, 130, 30);
        jbVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbVolver();
            }
        });
        add(jbVolver);
    
        
        jcCombo = new JComboBox<>();
        jcCombo.addItem("Programador 1: Kevin Casilimas 230221039");
        jcCombo.addItem("Programador 2: Cristopher Arias 230222032");
        jcCombo.addItem("Programador 3: Felipe Gutierrez 230222001");
        jcCombo.setBounds(15, 15, 300, 30);
        jcCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jcCombo();
            }
        });
        add(jcCombo);
        
        }
        
        public void evento_jcCombo(){
        String item = (String) jcCombo.getSelectedItem();
        System.out.println(item);
        switch(item){
            case "Programador 1: Kevin Casilimas 230221039": evento_radio(1);
            break;
            case "Programador 2: Cristopher Arias 230222032": evento_radio(2);
            break;
            case "Programador 3: Felipe Gutierrez 230222001": evento_radio(3);
            break;
        }
    }
        private void evento_jbVolver() {
        setVisible(false);
        dispose();
        ProyectoIntegrador mp = new ProyectoIntegrador();
        mp.setVisible(true);
        
    }
        
        public void evento_radio(int opcion){
        ImageIcon img = null;
        switch(opcion){
            case 1: 
                img = new ImageIcon(getClass().getResource(
                        "imagenes/kevin.jpg"));
                jlImg.setIcon(img);
            break;
            case 2: 
                img = new ImageIcon(getClass().getResource(
                        "imagenes/cris.jpg"));
                jlImg.setIcon(img);
            break;
            case 3: 
                img = new ImageIcon(getClass().getResource(
                        "imagenes/pipe.jpg"));
                jlImg.setIcon(img);
            break;
        }
    }
        



}
  
    

