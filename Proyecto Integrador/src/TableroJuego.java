import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class TableroJuego extends JPanel{
    
    public TableroJuego(){
        setBackground(Color.LIGHT_GRAY);
        setBorder(new LineBorder(Color.BLACK));
        setBounds(80, 80, 640, 310);
    }
    
    public void paint(Graphics g){
        super.paint(g);
         
        ImageIcon img1 = new ImageIcon(getClass().getResource("Imagenes/Balon.png"));
        ImageIcon img2 = new ImageIcon(getClass().getResource("Imagenes/Persona.png"));
        
        g.drawString("Area de lanzamiento", 20, 20);
        setForeground(Color.BLACK);
        
        g.drawImage(img2.getImage(), 20, 78, 72, 72, this);
        g.drawImage(img1.getImage(), 92, 102, 48, 48, this);
        
        cuadrao(g);
    }
    
    public void cuadrao(Graphics g){
        g.setColor(Color.MAGENTA);
        g.fillRect(1, 150, 150, 159);
    }
}
