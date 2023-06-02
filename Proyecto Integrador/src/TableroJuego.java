import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
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
         
        ImageIcon img1 = new ImageIcon(getClass().getResource("Imagenes/Campo.png"));
        ImageIcon im1Scal = new ImageIcon(img1.getImage().getScaledInstance(640, 310, Image.SCALE_DEFAULT));
        ImageIcon img2 = new ImageIcon(getClass().getResource("Imagenes/Persona.png"));
        ImageIcon img3 = new ImageIcon(getClass().getResource("Imagenes/Stone-Wall-icon.png"));
        g.drawString("Area de lanzamiento", 20, 20);
        setForeground(Color.BLACK);
        g.drawImage(im1Scal.getImage(), 0, 0, this);
        g.drawImage(img3.getImage(), -50, 90, this);
        g.drawImage(img2.getImage(), 10, 78, 72, 72, this);
        
        
        
        //cuadrao(g);
    }
    
    public void cuadrao(Graphics g){
        g.setColor(Color.MAGENTA);
        g.fillRect(1, 150, 150, 159);
    }
}
