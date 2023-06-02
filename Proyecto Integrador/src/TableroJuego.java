import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class TableroJuego extends JPanel{
    
    public TableroJuego(){
        setBorder(new LineBorder(Color.BLACK));
        setBounds(0, 0, 640, 310);
    }
    
    public void paint(Graphics g){
        super.paint(g);
         
        
        ImageIcon img2 = new ImageIcon(getClass().getResource("Imagenes/Persona.png"));
        g.drawString("Area de lanzamiento", 20, 20);
        setForeground(Color.BLACK);
        g.drawImage(img2.getImage(), 20, 78, 72, 72, this);
        
        
        cuadrao(g);
    }
    
    public void cuadrao(Graphics g){
        g.setColor(Color.MAGENTA);
        g.fillRect(1, 150, 150, 159);
    }
}
