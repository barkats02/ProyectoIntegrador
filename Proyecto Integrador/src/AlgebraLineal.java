import java.awt.Color;
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

public class AlgebraLineal extends JFrame {
    private List<Vector> vectores;
    private VectorPanel vectorPanel;
    private JButton calcularButton;
    private Operacion operacionActual;
    private JLabel operacionLabel;

    public AlgebraLineal(ProyectoIntegrador aThis) {
        super("Algebra Lineal");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        vectores = new ArrayList<>();
        vectorPanel = new VectorPanel();
        vectorPanel.setBounds(20, 20, 760, 400);
        add(vectorPanel);

        calcularButton = new JButton("Calcular");
        calcularButton.setBounds(360, 500, 80, 30);
        calcularButton.setEnabled(false);
        calcularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularOperacion();
            }
        });
        add(calcularButton);

        operacionLabel = new JLabel("Seleccione una operación");
        operacionLabel.setBounds(20, 450, 200, 30);
        add(operacionLabel);

        operacionActual = null;

        vectorPanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (operacionActual != null) {
                    int x = e.getX();
                    int y = e.getY();
                    agregarVector(x, y);
                }
            }
        });

        vectorPanel.addMouseMotionListener(new MouseMotionAdapter() {
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
        vectorPanel.repaint();
        if (vectores.size() > 1) {
            calcularButton.setEnabled(true);
        }
    }

    private void actualizarVector(int x, int y) {
        if (!vectores.isEmpty()) {
            Vector vector = vectores.get(vectores.size() - 1);
            vector.setEndPoint(x, y);
            vectorPanel.repaint();
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
        //producto por un escalar
        return null;
    }

    private Vector productoVectorial() {
        // producto vectorial
        return null;
    }

    private Vector productoMixto() {
        // producto mixto
        return null;
    }

    private Vector descomposicionVector() {
        // descomposición de un vector
        return null;
    }

    private void mostrarResultado(Vector resultado) {
        vectorPanel.setResultado(resultado);
        vectorPanel.repaint();
    }

    private class VectorPanel extends JLabel {
        private Vector resultado;

        public VectorPanel() {
            setOpaque(true);
            setBackground(Color.WHITE);
        }

        public void setResultado(Vector resultado) {
            this.resultado = resultado;
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

        public void setEndPoint(int endX, int endY) {
            this.endX = endX;
            this.endY = endY;
        }

        public void sumar(Vector vector) {
            endX += vector.endX - vector.startX;
            endY += vector.endY - vector.startY;
        }

        public void dibujar(Graphics g) {
            g.drawLine(startX, startY, endX, endY);
        }
    }

    private enum Operacion {
        SUMA,
        PRODUCTO_ESCALAR,
        PRODUCTO_VECTORIAL,
        PRODUCTO_MIXTO,
        DESCOMPOSICION
    }
}

/*
    public void evento_jbVolver(){
        setVisible(false);
        dispose();
        pi.setVisible(true);
    }
    
}*/
