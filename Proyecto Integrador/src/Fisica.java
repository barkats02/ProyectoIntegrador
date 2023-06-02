
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.Timer;


public class Fisica extends JFrame {
    JTextField Tpeso, Tfuerza, Taltura, Tdistancia, Tang;
    JButton jbVolver, jbLaunch, jbCal;
    ProyectoIntegrador pi;
    TableroBall tb;
    JComboBox<String> opcion;
    double gravedad, time, acel, velI;
    int altura, peso, ang;
    
    public Fisica(ProyectoIntegrador obj){
        super("FISICA");
        gravedad = 9.8;
        ang = 0;
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
        tb.setX(92);
        tb.setY(102);
        base.add(tb, 2);
        
        TableroJuego tj = new TableroJuego();
        base.add(tj, 1);
        
      
        
        
        this.getContentPane().add(base);
        
        
        
        JLabel alt = new JLabel("Altura (m)");
        alt.setBounds(30, 420,100, 30);
        Taltura = new JTextField(10);
        Taltura.setBounds(90, 420,30, 30);
        JLabel pe = new JLabel("Peso Balon (Kg)");
        pe.setBounds(140, 420,100, 30);
        Tpeso = new JTextField(10);
        Tpeso.setBounds(235, 420,30, 30);
        JLabel dis = new JLabel("Distancia (m)");
        dis.setBounds(290, 420,100, 30);
        Tdistancia = new JTextField(10);
        Tdistancia.setBounds(370, 420,30, 30);
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
        add(dis);
        add(Tdistancia);
        add(fuer);
        add(Tfuerza);
        add(an);
        add(Tang);
        
        
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
            evento_guardarDatos();
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
        
        
    /*    jbCal = new JButton("Calculanding");
        jbCal.setBounds(250, 470,100, 30);
        jbCal.setFocusable(false);
        jbCal.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            //evento_jbCalcular();
            }
        });
        add(jbCal);*/
    }
    
    
    public void evento_jbVolver(){
        setVisible(false);
        dispose();
        pi.setVisible(true);
    }
    
    public void evento_jbLanzameinto() {
        int delay = 100; // Milisegundos de retardo entre cada iteración

        Timer timer = new Timer(delay, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                boolean end = false;
                time+=delay/1000;
                Calcular();
                
                if(tb.posX >= 362 || tb.posY >= 572){
                    end = true;
                }
                tb.repaint();

                if (end == true) {
                    ((Timer) e.getSource()).stop();
                }
            }
        });

        timer.start();
    }
    
    public void evento_guardarDatos(){
        altura = Integer.parseInt(Taltura.getText());
        peso = Integer.parseInt(Tpeso.getText());
        acel = Double.parseDouble(Tfuerza.getText());
        acel/=peso;
        ang = Integer.parseInt(Tang.getText());
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
    
    public void Calcular(){
        // Suma aceleracion
        double x = acel*Math.cos(ang/180)*time*time;
        double y = acel*Math.sin(ang/180)*time*time;
        
        
        //resta gravedad
        y+=gravedad*peso*time*time;
        
        tb.posX += (int) x;
        tb.posY += (int) y;
    }
}