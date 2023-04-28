
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class TableroIntegral extends JPanel {
    public TableroIntegral(){
        setBackground(Color.WHITE);
        setBorder(new LineBorder(Color.BLACK));
        setBounds(80, 80, 640, 254);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        g.setFont(new Font("Tahoma", Font.ITALIC, 20));
        g.drawString("Componente Matematicas 3:", 30, 50);
        g.drawString("Convergencia o divergencia de series.", 30, 70);
        g.setFont(new Font("Tahoma", Font.PLAIN, 14));
        g.drawString("Temas a trabajar:", 30, 90);
        g.drawString("- Concepto de serie.", 30, 104);
        g.drawString("- Tipos de series(Aritmetica, Geometrica, Armonica, etc).", 30, 118);
        g.drawString("- Criterios de convergencia.", 30, 132);
        g.drawString("- Tipos de series(Aritmetica, Geometrica, Armonica, etc)", 30, 146);
        ImageIcon img = new ImageIcon(getClass().getResource("Imagenes/EjemploSerie.png"));
        g.drawImage(img.getImage(), 420, 50, 192, 121, this);
    }
}
