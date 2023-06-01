import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AlgebraLineal extends JFrame {
    private List<Vector> vectores;
    private VectorPanel VPanel;
    private JButton jbCalcular, jbVolver;
    private Operacion operacionActual;
    private JLabel operacionLabel;
    ProyectoIntegrador pi;

    public AlgebraLineal(ProyectoIntegrador obj) {
        super("Algebra Lineal");
        pi = obj;
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jbVolver = new JButton("Volver");
        jbVolver.setBounds(570, 470, 150, 30);
        jbVolver.setFocusable(false);
        jbVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                evento_jbVolver();
            }
        });
        add(jbVolver);

        vectores = new ArrayList<>();
        VPanel = new VectorPanel();
        VPanel.setBounds(20, 20, 760, 400);
        add(VPanel); // Agregar el panel VectorPanel al marco principal

        jbCalcular = new JButton("Calcular");
        jbCalcular.setBounds(360, 500, 120, 30);
        jbCalcular.setEnabled(false);
        jbCalcular.addActionListener((ActionEvent e) -> {
            calcularOperacion();
        });
        add(jbCalcular);

        operacionLabel = new JLabel("Seleccione una operación");
        operacionLabel.setBounds(20, 450, 200, 30);
        add(operacionLabel);

        operacionActual = null;

        VPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (operacionActual != null) {
                    int x = e.getX();
                    int y = e.getY();
                    agregarVector(x, y);
                }
            }
        });

        VPanel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (operacionActual != null) {
                    int x = e.getX();
                    int y = e.getY();
                    actualizarVector(x, y);
                }
            }
        });

        setVisible(true);
    }

    private void agregarVector(int x, int y) {
        vectores.add(new Vector(x, y));
        VPanel.repaint();
        if (vectores.size() > 1) {
            jbCalcular.setEnabled(true);
        }
    }

    private void actualizarVector(int x, int y) {
        if (!vectores.isEmpty()) {
            Vector vector = vectores.get(vectores.size() - 1);
            vector.setEndPoint(x, y);
            VPanel.repaint();
        }
    }

    private void calcularOperacion() {
        Vector resultado = null;

        if (operacionActual == Operacion.SUMA) {
            resultado = sumarVectores();
        } else if (operacionActual == Operacion.PRODUCTO_ESCALAR) {
            resultado = productoEscalar();
        } else if (operacionActual == Operacion.PRODUCTO_VECTORIAL) {
            resultado = productoVectorial();
        } else if (operacionActual == Operacion.PRODUCTO_MIXTO) {
            resultado = productoMixto();
        } else if (operacionActual == Operacion.DESCOMPOSICION) {
            resultado = descomposicionVector();
        }

        if (resultado != null) {
            mostrarResultado(resultado);
        }
    }

    private Vector sumarVectores() {
        Vector suma = new Vector(0, 0);

        for (Vector vector : vectores) {
            suma.sumar(vector);
        }

        return suma;
    }

    private Vector productoEscalar() {
        if (vectores.size() < 2) {
            return null;
        }

        Vector primerVector = vectores.get(0);
        double escalar = obtenerEscalar();

        Vector resultado = new Vector(primerVector.startX, primerVector.startY);
        resultado.setEndPoint((int) (primerVector.endX * escalar), (int) (primerVector.endY * escalar));

        return resultado;
    }

    private double obtenerEscalar() {
        String input = JOptionPane.showInputDialog(null, "Ingrese el valor escalar:", "Producto Escalar", JOptionPane.PLAIN_MESSAGE);
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Valor escalar inválido.", "Error", JOptionPane.ERROR_MESSAGE);
            return obtenerEscalar();
        }
    }

    private Vector productoVectorial() {
        if (vectores.size() != 2) {
            return null;
        }

        Vector primerVector = vectores.get(0);
        Vector segundoVector = vectores.get(1);

        int resultadoX = (primerVector.endY * 1) - (primerVector.endX * segundoVector.endY);
        int resultadoY = (primerVector.endX * segundoVector.endX) - (primerVector.endY * 1);

        Vector resultado = new Vector(primerVector.startX, primerVector.startY);
        resultado.setEndPoint(resultadoX, resultadoY);

        return resultado;
    }

    private Vector productoMixto() {
        if (vectores.size() != 3) {
            return null;
        }

        Vector primerVector = vectores.get(0);
        Vector segundoVector = vectores.get(1);
        Vector tercerVector = vectores.get(2);

        int resultado = (primerVector.endX * segundoVector.endY * 1)
                + (primerVector.endY * 1 * tercerVector.endX)
                + (1 * segundoVector.endX * tercerVector.endY)
                - (primerVector.endY * segundoVector.endX * 1)
                - (primerVector.endX * 1 * tercerVector.endY)
                - (1 * segundoVector.endY * tercerVector.endX);

        return new Vector(primerVector.startX, primerVector.startY, resultado);
    }

    private Vector descomposicionVector() {
        if (vectores.size() < 2) {
            return null;
        }

        Vector primerVector = vectores.get(0);
        Vector segundoVector = vectores.get(1);

        double productoEscalar = (primerVector.endX * segundoVector.endX) + (primerVector.endY * segundoVector.endY);
        double moduloSegundoVector = Math.sqrt(Math.pow(segundoVector.endX, 2) + Math.pow(segundoVector.endY, 2));

        double escalar = productoEscalar / Math.pow(moduloSegundoVector, 2);

        Vector resultado = new Vector(primerVector.startX, primerVector.startY);
        resultado.setEndPoint((int) (escalar * segundoVector.endX), (int) (escalar * segundoVector.endY));

        return resultado;
    }

    private void mostrarResultado(Vector resultado) {
        JOptionPane.showMessageDialog(null, "El resultado es: \n" + resultado.toString(), "Resultado", JOptionPane.INFORMATION_MESSAGE);
    }

    private void evento_jbVolver() {
        this.dispose();
        pi.setVisible(true);
    }

    private class VectorPanel extends JPanel {
        private Vector resultado;

        public VectorPanel() {
            setBackground(Color.WHITE);
            setOpaque(true);
        }

        public void setResultado(Vector resultado) {
            this.resultado = resultado;
            repaint();
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.BLACK);
            for (Vector vector : vectores) {
                vector.dibujar(g);
            }

            if (resultado != null) {
                resultado.dibujar(g);
            }
        }
    }

    private enum Operacion {
        SUMA,
        PRODUCTO_ESCALAR,
        PRODUCTO_VECTORIAL,
        PRODUCTO_MIXTO,
        DESCOMPOSICION
    }

    private class Vector {
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Vector(int startX, int startY) {
            this.startX = startX;
            this.startY = startY;
            this.endX = startX;
            this.endY = startY;
        }

        public Vector(int startX, int startY, int resultado) {
            this.startX = startX;
            this.startY = startY;
            this.endX = startX;
            this.endY = startY;
        }

        public void setEndPoint(int endX, int endY) {
            this.endX = endX;
            this.endY = endY;
        }

        public void sumar(Vector vector) {
            this.endX += vector.endX - vector.startX;
            this.endY += vector.endY - vector.startY;
        }

        @Override
        public String toString() {
            return "Vector{" +
                    "startX=" + startX +
                    ", startY=" + startY +
                    ", endX=" + endX +
                    ", endY=" + endY +
                    '}';
        }

        public void dibujar(Graphics g) {
            g.drawLine(startX, startY, endX, endY);
        }
    }
}
