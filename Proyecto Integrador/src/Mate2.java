import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

public class Mate2 extends JFrame {
    JButton jbVolver, jbGuardar;
    JRadioButton jrRad1, jrRad2, jrRad3;
    JComboBox<String> jcCombo;
    JLabel jlImg;
    ProyectoIntegrador pi;

    public Mate2 (ProyectoIntegrador obj){
        super("Matematicas 2");
        pi = obj;
        setSize(1100, 625);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        crearGUI();
        
        setVisible(true);
    }

    public void crearGUI(){
        
        jrRad1 = new JRadioButton("<html>Ver el<br> concepto del limite</html>");
        jrRad1.setBounds(40, 50, 120, 60);
        jrRad1.setBackground(Color.LIGHT_GRAY);
        jrRad1.setForeground(Color.black);
        jrRad1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_radio(1);
            }
        });
        add(jrRad1);

        jrRad2 = new JRadioButton("<html>Ver el <br> concepto de la derivada</html>");
        jrRad2.setBounds(40, 120, 120, 60);
        jrRad2.setBackground(Color.LIGHT_GRAY);
        jrRad2.setForeground(Color.black);
        jrRad2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_radio(2);
            }
        });
        add(jrRad2);

        jrRad3 = new JRadioButton("<html>Ver la <br> grafica de la derivada</html>");
        jrRad3.setBounds(40, 190, 120, 60);
        jrRad3.setBackground(Color.LIGHT_GRAY);
        jrRad3.setForeground(Color.black);
        jrRad3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_radio(3);
            }
        });
        add(jrRad3);

        jlImg = new JLabel();
        jlImg.setBounds(200, 50, 800, 400);
        jlImg.setBorder(new LineBorder(Color.BLACK));
        add(jlImg);

        ButtonGroup bg = new ButtonGroup();
        bg.add(jrRad1);
        bg.add(jrRad2);
        bg.add(jrRad3);

        /*jcCombo = new JComboBox<>();
        jcCombo.addItem("<html>Ver el<br> concepto del limite</html>");
        jcCombo.addItem("<html>Ver el <br> concepto de la derivada</html>");
        jcCombo.addItem("<html>Ver la <br> grafica de la derivada</html>");
        jcCombo.setBounds(40, 340, 150, 50);
        jcCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jcCombo();
            }
        });
        add(jcCombo);*/



                
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

    public void evento_radio(int opcion){
        ImageIcon img = null;
        switch(opcion){
            case 1: 
                img = new ImageIcon(getClass().getResource( "Imagenes/Limite.png"));
                jlImg.setIcon(img);
            break;
            case 2: 
                img = new ImageIcon(getClass().getResource("Imagenes/Derivada.png"));
                jlImg.setIcon(img);
            break;
            case 3: 
                img = new ImageIcon(getClass().getResource("Imagenes/Derivada2.png"));
                jlImg.setIcon(img);
            break;
        }
    }

    public void evento_jbVolver(){
        setVisible(false);
        dispose();
        pi.setVisible(true);
    }

    public void evento_jcCombo(){
        String item = (String) jcCombo.getSelectedItem();
        System.out.println(item);
        switch(item){
            case "<html>Ver el<br> concepto del limite</html>": evento_radio(1);
            break;
            case "<html>Ver el <br> concepto de la derivada</html>": evento_radio(2);
            break;
            case "<html>Ver la <br> grafica de la derivada</html>": evento_radio(3);
            break;
        }
    }
    
}















