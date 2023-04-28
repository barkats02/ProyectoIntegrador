
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Tablero extends JPanel{
    
    public Tablero(){
        setBackground(Color.WHITE);
        setBorder(new LineBorder(Color.BLACK));
        setBounds(80, 80, 640, 254);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        g.setFont(new Font("Tahoma", Font.ITALIC, 20));
        g.drawString("Este area se encuentra en desarrollo,", 30, 50);
        g.drawString("volver en otro momento.", 30, 90);
        ImageIcon img = new ImageIcon(getClass().getResource("Imagenes/error.png"));
        
        g.drawImage(img.getImage(), 438, 2, 200, 250, this);
    }
    

}
