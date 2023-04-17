
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ProyectoIntegrador extends JFrame {
    JButton bFisica, bIntegral, bDiscretas, bAmbiente;
    
    public void crearGUI(){
        JLabel Jtitulo = new JLabel("Bienvenido");
        Jtitulo.setBounds(0, 0, 600, 50);
        Jtitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
        Jtitulo.setHorizontalAlignment(JLabel.CENTER);
        add(Jtitulo);
        
        bFisica = new JButton("Fisica");
        bFisica.setBounds(400, 75, 150, 50);
        bFisica.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                evento_Fisica();
            }
        });
        add(bFisica);
        
        bIntegral = new JButton("Integral");
        bIntegral.setBounds(400, 150, 150, 50);
        bIntegral.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                evento_Integral();
            }
        });
        add(bIntegral);
        
        bDiscretas = new JButton("Discretas");
        bDiscretas.setBounds(400, 225, 150, 50);
        bDiscretas.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                evento_Discretas();
            }
        });
        add(bDiscretas);
        
        bAmbiente = new JButton("<html>Ingenieria del<br> medio ambiente</html>");
        bAmbiente.setBounds(400, 300, 150, 50);
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
    
    public void evento_Integral(){
        Integral v2 = new Integral(this);
        setVisible(false);
    }
    
    public void evento_Discretas(){
        Discretas v3 = new Discretas(this);
        setVisible(false);
    }
    
    public void evento_Ambiente(){
        Ambiente v4 = new Ambiente(this);
        setVisible(false);
    }
    
    public ProyectoIntegrador(){
        super("Proyecto Integrador");
        setSize(600, 500);
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
