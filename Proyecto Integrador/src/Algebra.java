import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Algebra extends JFrame {
    JButton jbVolver;
    ProyectoIntegrador pi;

    public Algebra (ProyectoIntegrador obj){
        super("Algebra Lineal");
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
    
    //Operaciones entre vectores
    public int[] sumaV(int[] v1, int[] v2){
        int[] V = new int[2];
        V[0] = v1[0]+v2[0];//Suma posiciones en X
        V[1] = v1[1] + v2[1]; //Suma posiciones en Y
        return V;
    }
    
    public int[] prodporE(int[] v1, int n){
        int[] V = new int [2];
        V[0] = v1[0]*n; //Multiplica las posiciones por el escalar
        V[1] = v1[1]*n; //Si piden un numero entre 1 y 0 cambie el int por un double 
        return V;
    } 
    
    public int prodE(int[] v1, int[] v2){
       return (v1[0]*v2[0+v1[1]+v2[1]]); //Devuelve un entero, multiplica las posiciones y suma el resultado de ambas
    }
    
    //Los otros dos no se mano, vi algibra linial hace mucho
    //Pal ultimo como es una descomposicion solo grafica dos vectores 
    // Vector 1 ( X del vector, 0 )  |
    // Vector 2 ( 0, Y del vector )  |_ _
}
