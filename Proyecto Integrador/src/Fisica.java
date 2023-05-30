
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.Timer;


public class Fisica extends JFrame {
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
        
        //TableroJuego tj = new TableroJuego();
        //base.add(tj, 1);
        
        tb = new TableroBall();
        tb.setX(92);
        tb.setY(102);
        base.add(tb, 2);
        
        this.getContentPane().add(base);
        
        
        
        

        
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
        
        jbCal = new JButton("Calculanding");
        jbCal.setBounds(250, 470,100, 30);
        jbCal.setFocusable(false);
        jbCal.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            //evento_jbCalcular();
            }
        });
        add(jbCal);
    }
    
    
    public void evento_jbVolver(){
        setVisible(false);
        dispose();
        pi.setVisible(true);
    }
    
    public void evento_jbLanzameinto() {
        int iterations = 10;
        int delay = 200; // Milisegundos de retardo entre cada iteración

        Timer timer = new Timer(delay, new ActionListener() {
            int count = 0;

            public void actionPerformed(ActionEvent e) {
                time+=delay/1000;
                Calcular();
                
                if(tb.posX >= 362 || tb.posY >= 572){
                    count = iterations;
                }
                tb.repaint();

                count++;
                if (count == iterations) {
                    ((Timer) e.getSource()).stop();
                }
            }
        });

        timer.start();
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
        
        //suma velocidad inicial y posicion
        x+= velI*Math.cos(ang/180)*time;
        y+= velI*Math.sin(ang/180)*time+altura;
        
        //resta gravedad
        y-=gravedad*time*time;
        
        tb.posX = (int) -x;
        tb.posY = (int) -y;
    }
}