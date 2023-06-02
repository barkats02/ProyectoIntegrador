
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.Timer;


public class Fisica extends JFrame implements ActionListener {
    JButton jbVolver, jbLaunch, jbCal;
    ProyectoIntegrador pi;
    TableroBall tb;
    JComboBox<String> opcion;
    double gravedad;
    double time = 0;
    double acel = 0;
    int ang = 0;
    double velI = 0;
    int altura = 0;
    
    boolean fin = true;
    int  TAMANO_BALON = 48, delay = 300;
    double pesBal = 0.1;
    double alBall, vel_vien = 0.5, velX, velY;

     Timer temp;

    JTextField Taltura, Tpeso, Tfuerza, Tang;
    
    public Fisica(ProyectoIntegrador obj){
        super("FISICA");
        gravedad = 9.8;
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
        JLayeredPane base = new JLayeredPane();
        base.setBounds(80, 80, 640, 310);
        
        tb = new TableroBall();
        base.add(tb, 1);
        
        TableroJuego tj = new TableroJuego();
        base.add(tj, 2);
        
        
        
        this.getContentPane().add(base);
        
        
        JLabel alt = new JLabel("Altura (m)");
        alt.setBounds(30, 420,100, 30);
        Taltura = new JTextField(10);
        Taltura.setBounds(90, 420,30, 30);
        JLabel pe = new JLabel("Peso Balon (Kg)");
        pe.setBounds(140, 420,100, 30);
        Tpeso = new JTextField(10);
        Tpeso.setBounds(235, 420,30, 30);
        JLabel fuer = new JLabel("Fuerza (N*Kg)");
        fuer.setBounds(420, 420,100, 30);
        Tfuerza = new JTextField(10);
        Tfuerza.setBounds(500, 420,30, 30);
        JLabel an = new JLabel("Angulo");
        an.setBounds(560, 420,100, 30);
        Tang = new JTextField(10);
        Tang.setBounds(605, 420,30, 30);
        add(alt);
        add(Taltura);
        add(pe);
        add(Tpeso);


        

        
        jbVolver = new JButton("Volver teaver");
        jbVolver.setBounds(600, 470,150, 30);
        jbVolver.setFocusable(false);
        jbVolver.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            evento_jbVolver();
            }
        });
        add(jbVolver);
        
        jbLaunch = new JButton("Lanzanding");
        jbLaunch.setBounds(30, 470,100, 30);
        jbLaunch.setFocusable(false);
        jbLaunch.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            evento_jbLanzameinto();
            }
        });
        add(jbLaunch);
        
        opcion = new JComboBox<>();
        opcion.addItem("Tierra");
        opcion.addItem("Mercurio");
        opcion.addItem("Venus");
        opcion.addItem("Marte");
        opcion.addItem("Jupiter");
        opcion.addItem("Saturno");
        opcion.addItem("Urano");
        opcion.addItem("Neptuno");
        opcion.setBounds(140, 470, 100, 30);
        opcion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                evento_jcCombo();
            }
            });
        add(opcion);
        
        tb.posX = 48;
        tb.posY = 100;
        velX = 10;
        velY = 0;

        temp = new Timer(delay, this);
        
    }
    
     public void actionPerformed(ActionEvent e) {
        velX += vel_vien;
        velY += gravedad * pesBal;
        tb.posX += velX;
        tb.posY += velY;
        tb.repaint();

        if (tb.posY >= 300 -48) {
            temp.stop();
        }
    }
    
    
    public void evento_jbVolver(){
        setVisible(false);
        dispose();
        pi.setVisible(true);
    }
    
    public void evento_jbLanzameinto() {
        tb.posY = 100;
        temp.start();
        double alturaBal = Double.parseDouble(Taltura.getText());
        double pesoBal = Double.parseDouble(Tpeso.getText());

        alBall = alturaBal;
        pesBal = pesoBal;

        tb.posX = TAMANO_BALON;
        tb.posY = 300- alBall;
        velX = 10;
        velY = 0;

        temp.restart();
        
    }
    
    public void evento_jcCombo(){
        String item =(String) opcion.getSelectedItem();
        switch(item){
            case "Tierra": gravedad=9.8; break;
            case "Mercurio": gravedad=2.78; break;
            case "Venus": gravedad=8.87; break;
            case "Marte": gravedad=3.72; break;
            case "Jupiter": gravedad=22.88; break;
            case "Saturno": gravedad=9.05; break;
            case "Urano": gravedad=7.77; break;
            case "Neptuno": gravedad=11; break;
        }
    }
    
    
}