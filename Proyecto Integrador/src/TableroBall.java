
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class TableroBall extends JPanel {
    int posX;
    int posY;
    
    public TableroBall(){
        setBounds(20, 0, 620, 310);
        setOpaque(false);
        posX = 0;
        posY = 0;
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        ImageIcon img1 = new ImageIcon(getClass().getResource("Imagenes/Balon.png"));
        g.drawImage(img1.getImage(), posX, posY, 48, 48, this);
    }

    public void setX(int posX) {
        this.posX = posX;
    }

    public void setY(int posY) {
        this.posY = posY;
    }
    
}
