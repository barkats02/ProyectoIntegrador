import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class ProyectoIntegrador extends JFrame {
    JButton bFisica, bIntegral, bDiscretas, bAmbiente, bMate2, bHumanides, bAlgebra, bTGS, bAcercaD;
    private AlgebraLineal algebraLineal;
   
    public void crearGUI() {
        JLabel Jtitulo = new JLabel("Bienvenido");
        Jtitulo.setBounds(100, 0, 600, 50);
        Jtitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
        Jtitulo.setHorizontalAlignment(JLabel.CENTER);
        add(Jtitulo);

        bMate2 = new JButton("Matematicas");
        bMate2.setBounds(100, 75, 150, 50);
        bMate2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                evento_Mate();
            }
        });
        add(bMate2);

        bTGS = new JButton("<html>Teoria general<br> de sistemas</html>");
        bTGS.setBounds(325, 250, 150, 50);
        bTGS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                evento_TGS();
            }
        });
        add(bTGS);

        bAlgebra = new JButton("Algebra Lineal ");
        bAlgebra.setBounds(100, 150, 150, 50);
        bAlgebra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                evento_Algebra();
            }
        });
        add(bAlgebra);
        
        bFisica = new JButton("Fisica");
        bFisica.setBounds(550, 75, 150, 50);
        bFisica.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                evento_Fisica();
            }
        });
        add(bFisica);

        bHumanides = new JButton("Humanidades");
        bHumanides.setBounds(550, 150, 150, 50);
        bHumanides.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                evento_Humanidades();
            }
        });
        add(bHumanides);
        
        bAcercaD = new JButton("Acerca de nosotros");
        bAcercaD.setBounds(600, 300, 110, 30);
        bAcercaD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                evento_nosotros();
            }
        });
        add(bAcercaD);
    }
    
    public void evento_Fisica() {
        Fisica v1 = new Fisica(this);
        setVisible(false);
    }
    
    public void evento_Discretas() {
        Discretas v3 = new Discretas(this);
        setVisible(false);
    }
    
    public void evento_Ambiente() {
        Ambiente v4 = new Ambiente(this);
        setVisible(false);
    }

    public void evento_Mate() {
        SelecMat v2 = new SelecMat(this);
        setVisible(false);
    }
    
    public void evento_Algebra() {
        algebraLineal = new AlgebraLineal(this);
        setVisible(false);
    }
    
    public void evento_Humanidades() {
        Humanidades v7 = new Humanidades(this); 
        setVisible(false);
    }
    
    public void evento_TGS() {
        TGS v8 = new TGS(this); 
        setVisible(false);
    }
    
    public void evento_nosotros() {
        acercaDe v9 = new acercaDe(this); 
        setVisible(false);
    }
    
    public void evento_jbVolver() {
        setVisible(true);
        if (algebraLineal != null) {
            algebraLineal.dispose();
            algebraLineal = null;
        }
    }
    
    public ProyectoIntegrador() {
        super("Proyecto Integrador");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
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

