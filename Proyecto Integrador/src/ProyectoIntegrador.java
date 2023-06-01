import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


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
        
        /*bDiscretas = new JButton("Discretas");
        bDiscretas.setBounds(550, 150, 150, 50);
        bDiscretas.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                evento_Discretas();
            }
        });
        add(bDiscretas);*/
        
        bAcercaD = new JButton("Acerca de nosotros");
        bAcercaD.setBounds(690, 515, 80, 30);
        bAcercaD.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                evento_nosotros();
            }
        });
        add(bAcercaD);
        
        
        /*bAmbiente = new JButton("<html>Ingenieria del<br> medio ambiente</html>");
        bAmbiente.setBounds(550, 225, 150, 50);
        bAmbiente.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                evento_Ambiente();
            }
        });
        add(bAmbiente);*/
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
        acercaDe v9 = new acercaDe(this); 
        setVisible(false);
    }
    
    private void evento_jbSalir() {
        int res = JOptionPane.showConfirmDialog(this, 
                "¿Desea realmente salir de la aplicación?", 
                "Confirmación", 
                JOptionPane.YES_NO_OPTION);
        
        if(res == JOptionPane.YES_OPTION) System.exit(0);
    }
    
    public ProyectoIntegrador(){
        super("Proyecto Integrador");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we){
                evento_jbSalir();
            }
        });
        
        crearGUI();
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        
        
        String look = "";
        try {
            look = "com.jtattoo.plaf.hifi.HiFiLookAndFeel"; //esto se cambia para el estilo de la apk
            UIManager.setLookAndFeel(look);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al tratar de cargar el paquete '" + look + "'.\n\n"
                    + "Se tomara el LookAndFeel por defecto.", "Error de paquete", JOptionPane.WARNING_MESSAGE);

            JFrame.setDefaultLookAndFeelDecorated(false);
            look = "";
        }
        
            ProyectoIntegrador pi = new ProyectoIntegrador();
    }
    
}
