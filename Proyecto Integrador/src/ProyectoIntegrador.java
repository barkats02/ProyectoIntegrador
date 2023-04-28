import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ProyectoIntegrador extends JFrame {
    JButton bFisica, bIntegral, bDiscretas, bAmbiente, bMate2, bHumanides, bAlgebra, bTGS, bAcercaD;
   

    
    public void crearGUI(){
        JLabel Jtitulo = new JLabel("Bienvenido");
        Jtitulo.setBounds(100, 0, 600, 50);
        Jtitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
        Jtitulo.setHorizontalAlignment(JLabel.CENTER);
        add(Jtitulo);

        bMate2 = new JButton("Matematicas");
        bMate2.setBounds(100, 75, 150, 50);
        bMate2.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e){
            evento_Mate();

            }
            
        });
        add(bMate2);

        bTGS = new JButton("<html>Teoria general<br> de sistemas</html>");
        bTGS.setBounds(100, 300, 150, 50);
        bTGS.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e){
            evento_TGS ();

            }
            
        });
        add(bTGS);

        bAlgebra = new JButton("Algebra Lineal ");
        bAlgebra.setBounds(100, 150, 150, 50);
        bAlgebra.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e){
            evento_Algebra ();

            }
            
        });
        add(bAlgebra);
        
        bFisica = new JButton("Fisica");
        bFisica.setBounds(550, 75, 150, 50);
        bFisica.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                evento_Fisica();
            }
        });
        add(bFisica);

        bHumanides = new JButton("Humanidades");
        bHumanides.setBounds(100, 225, 150, 50);
        bHumanides.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                evento_Humanidades();
            }
        });
        add(bHumanides);
        
        /*bIntegral = new JButton("Integral");
        bIntegral.setBounds(550, 150, 150, 50);
        bIntegral.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                evento_Integral();
            }
        });
        add(bIntegral);*/
        
        bDiscretas = new JButton("Discretas");
        bDiscretas.setBounds(550, 150, 150, 50);
        bDiscretas.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                evento_Discretas();
            }
        });
        add(bDiscretas);
        
         bAcercaD = new JButton("Acerca de nosotros");
        bAcercaD.setBounds(550, 300, 150, 50);
        bAcercaD.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                evento_nosotros();
            }
        });
        add(bAcercaD);
        
        
        bAmbiente = new JButton("<html>Ingenieria del<br> medio ambiente</html>");
        bAmbiente.setBounds(550, 225, 150, 50);
        bAmbiente.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                evento_Ambiente();
            }
        });
        add(bAmbiente);
    }
    
    public void evento_Fisica(){
        Fisica v1 = new Fisica(this);
        setVisible(false);
    }
    
   
/*    public void evento_Integral(){
        Integral v2 = new Integral(this);
        setVisible(false);
    }*/
    
    public void evento_Discretas(){
        Discretas v3 = new Discretas(this);
        setVisible(false);
    }
    
    public void evento_Ambiente(){
        Ambiente v4 = new Ambiente(this);
        setVisible(false);
    }

    public void evento_Mate(){
        SelecMat v2 = new SelecMat(this);
        setVisible(false);
    }
    public void evento_Algebra (){
        Algebra v6 = new Algebra (this);
        setVisible(false);
    }
    public void evento_Humanidades (){
        Humanidades v7 = new Humanidades(this); 
        setVisible(false);
    }
    public void evento_TGS (){
        TGS v8 = new TGS (this); 
        setVisible(false);
    }
    public void evento_nosotros (){
        acercaDE v9 = new acercaDE(this); 
        setVisible(false);
    }
    
    public ProyectoIntegrador(){
        super("Proyecto Integrador");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        crearGUI();
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
            ProyectoIntegrador pi = new ProyectoIntegrador();
    }
    
}
