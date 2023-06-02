import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AlgebraLineal extends JFrame implements ActionListener {
    private JButton jbCalcular, jbVolver;
    private JComboBox<String> operacionesComboBox;
    private JTextField vector1TextField;
    private JTextField vector2TextField;
    private JPanel panel;

    private Point vector1;
    private Point vector2;
    ProyectoIntegrador pi;

    public AlgebraLineal(ProyectoIntegrador obj) {
        super("Algebra Lineal");
        pi = obj;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 720);
        setVisible(true);

        jbCalcular = new JButton("Calcular");
        jbCalcular.addActionListener(this);

        operacionesComboBox = new JComboBox<>();
        operacionesComboBox.addItem("Suma de vectores");
        operacionesComboBox.addItem("Producto vectorial");
        operacionesComboBox.addItem("Producto cruz");
        operacionesComboBox.addItem("Producto mixto");

        vector1TextField = new JTextField(10);
        vector2TextField = new JTextField(10);
        
        
        jbVolver = new JButton("Volver ");
        jbVolver.setBounds(800, 600,150, 30);
        jbVolver.setFocusable(false);
        jbVolver.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            evento_jbVolver();
            }
        });
        add(jbVolver);
        

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int centerX = getWidth() / 2;
                int centerY = getHeight() / 2;

                // Dibujar ejes X e Y
                g.drawLine(0, centerY, getWidth(), centerY);
                g.drawLine(centerX, 0, centerX, getHeight());

                // Dibujar vectores
                if (vector1 != null && vector2 != null) {
                    g.setColor(Color.RED);
                    g.drawLine(centerX, centerY, vector1.x, vector1.y);
                    g.setColor(Color.BLUE);
                    g.drawLine(centerX, centerY, vector2.x, vector2.y);

                    // Dibujar vector resultante
                    int resultadoX = vector1.x + vector2.x;
                    int resultadoY = vector1.y + vector2.y;
                    g.setColor(Color.GREEN);
                    g.drawLine(centerX, centerY, resultadoX, resultadoY);

                    // Dibujar figura
                    g.setColor(Color.BLACK);
                    g.drawLine(vector1.x, vector1.y, vector2.x, vector2.y);
                    g.drawLine(vector2.x, vector2.y, resultadoX, resultadoY);
                    g.drawLine(resultadoX, resultadoY, vector1.x, vector1.y);
                }
            }
        };

        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (vector1 == null) {
                    vector1 = evt.getPoint();
                } else if (vector2 == null) {
                    vector2 = evt.getPoint();
                }
                panel.repaint();
            }
        });

        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("Vector 1 (x, y):"));
        controlPanel.add(vector1TextField);
        controlPanel.add(new JLabel("Vector 2 (x, y):"));
        controlPanel.add(vector2TextField);
        controlPanel.add(operacionesComboBox);
        controlPanel.add(jbCalcular);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
        
        
    }
     public void evento_jbVolver(){
        setVisible(false);
        dispose();
        pi.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbCalcular) {
            // Obtener la operación seleccionada
            String operacionSeleccionada = (String) operacionesComboBox.getSelectedItem();

            // Obtener las coordenadas de los vectores ingresados por el usuario
            String vector1Text = vector1TextField.getText();
            String vector2Text = vector2TextField.getText();

            // Validar que se hayan ingresado coordenadas válidas
            if (!vector1Text.isEmpty() && !vector2Text.isEmpty()) {
                // Obtener las coordenadas x e y de cada vector
                String[] vector1Coords = vector1Text.split(",");
                String[] vector2Coords = vector2Text.split(",");

                if (vector1Coords.length == 2 && vector2Coords.length == 2) {
                    try {
                        int vector1X = Integer.parseInt(vector1Coords[0].trim());
                        int vector1Y = Integer.parseInt(vector1Coords[1].trim());

                        int vector2X = Integer.parseInt(vector2Coords[0].trim());
                        int vector2Y = Integer.parseInt(vector2Coords[1].trim());

                        // Realizar la operación y mostrar el resultado
                        if (operacionSeleccionada.equals("Suma de vectores")) {
                            int resultadoX = vector1X + vector2X;
                            int resultadoY = vector1Y + vector2Y;
                            JOptionPane.showMessageDialog(this, "Vector resultante: (" + resultadoX + ", " + resultadoY + ")");
                        } else if (operacionSeleccionada.equals("Producto vectorial")) {
                            int producto = vector1X * vector2Y - vector1Y * vector2X;
                            JOptionPane.showMessageDialog(this, "Producto vectorial: " + producto);
                        } else if (operacionSeleccionada.equals("Producto cruz")) {
                            int cruz = (vector1X * vector2Y - vector2X * vector1Y);
                            JOptionPane.showMessageDialog(this, "Producto cruz: " + cruz);
                        } else if (operacionSeleccionada.equals("Producto mixto")) {
                            int mixto = vector1X * vector2Y;
                            JOptionPane.showMessageDialog(this, "Producto mixto: " + mixto);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "Error: Las coordenadas deben ser números enteros.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Error: Ingresa las coordenadas en el formato correcto (x, y).");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error: Ingresa las coordenadas de ambos vectores.");
            }
        }
    }
}