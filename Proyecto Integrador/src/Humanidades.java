
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
/*import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;*/

public class Humanidades extends JFrame {

    JButton jbVolver, jbsiguiente, jbanterior;
    ProyectoIntegrador pi;
    JLabel jlImg;
    JComboBox<String> jcCapitulos;
    
    CuestionarioDialog ce;
    private JLabel label;
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private List<String> usuarios;
    private List<Double> puntajes;
    private int intentos;

    public Humanidades(ProyectoIntegrador obj) {
        super("Humanidades");
        pi = obj;
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        crearGUI();

        usuarios = new ArrayList<>();
        puntajes = new ArrayList<>();
        intentos = 0;

        setVisible(true);
    }

    private void crearGUI() {

        label = new JLabel("<html>Objetivos de desarrollo sostenible <br> establecidos por la ONU</html>");
        textArea = new JTextArea(10, 30);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setText("Objetivo 1: Poner fin a la pobreza en todas sus formas en todo el mundo"
                + "\n\nObjetivo 2: Poner fin al hambre"
                + "\n\nObjetivo 3: Garantizar una vida sana y promover el bienestar para todos en todas las edades"
                + "\n\nObjetivo 4: Garantizar una educación inclusiva, equitativa y de calidad y promover "
                + "\n\noportunidades de aprendizaje durante toda la vida para todos"
                + "\n\nObjetivo 5: Lograr la igualdad entre los géneros y empoderar a todas las mujeres y las niñas"
                + "\n\nObjetivo 6: Garantizar la disponibilidad de agua y su gestión sostenible y el saneamiento para todos"
                + "\n\nObjetivo 7: Garantizar el acceso a una energía asequible, segura, sostenible y moderna"
                + "\n\nObjetivo 8: Promover el crecimiento económico inclusivo y sostenible, el empleo y el trabajo decente para todos"
                + "\n\nObjetivo 9: Construir infraestructuras resilientes, promover la industrialización sostenible y fomentar la innovación"
                + "\n\nObjetivo 10: Reducir la desigualdad en y entre los países");

        textArea.setEnabled(false);

        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        label.setBounds(50, 35, 300, 40);
        scrollPane.setBounds(50, 80, 400, 430);
        add(label);
        add(scrollPane);

        ImageIcon img = null;

        jlImg = new JLabel();
        jlImg.setBounds(470, 100, 250, 195);
        jlImg.setBorder(new LineBorder(Color.BLACK));
        img = new ImageIcon(getClass().getResource(
                "imagenes/proyecto.jpg"));
        jlImg.setIcon(img);
        add(jlImg);

        getContentPane().add(jlImg, BorderLayout.CENTER);

        jbVolver = new JButton("Volver");
        jbVolver.setBounds(50, 530, 150, 30);
        jbVolver.setFocusable(false);
        jbVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                evento_jbVolver();
            }
        });
        add(jbVolver);

        JButton cuestionarioButton = new JButton("Realizar cuestionario");
        cuestionarioButton.setBounds(470, 450, 200, 30);
        cuestionarioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                llamarCuestionario();
            }
        });
        add(cuestionarioButton);

        JButton materialButton = new JButton("Material complementario");
        materialButton.setBounds(470, 500, 200, 30);
        materialButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirMaterialComplementario();
            }
        });
        add(materialButton);

        JLabel jlCapitulo = new JLabel("CAPITULOS");
        jlCapitulo.setBounds(470, 50, 120, 25);
        add(jlCapitulo);
        jcCapitulos = new JComboBox<>();
        jcCapitulos.setBounds(570, 50, 100, 25);
        jcCapitulos.addItem("CAPITULO 1");
        jcCapitulos.addItem("CAPITULO 2");
        jcCapitulos.addItem("CAPITULO 3");
        jcCapitulos.addItem("CAPITULO 4");
        jcCapitulos.addItem("CAPITULO 5");
        jcCapitulos.addItem("CAPITULO 6");
        jcCapitulos.addItem("CAPITULO 7");
        jcCapitulos.addItem("CAPITULO 8");
        jcCapitulos.addItem("CAPITULO 9");
        jcCapitulos.addItem("CAPITULO 10");
        jcCapitulos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Capitulos();
            }
        });
        add(jcCapitulos);

    }

    public void Capitulos() {

        String Capitulo = (String) jcCapitulos.getSelectedItem();
        switch (Capitulo) {
            case "CAPITULO 1":
                evento_cap(1);
                break;
            case "CAPITULO 2":
                evento_cap(2);
                break;
            case "CAPITULO 3":
                evento_cap(3);
                break;
            case "CAPITULO 4":
                evento_cap(4);
                break;
            case "CAPITULO 5":
                evento_cap(5);
                break;
            case "CAPITULO 6":
                evento_cap(6);
                break;
            case "CAPITULO 7":
                evento_cap(7);
                break;
            case "CAPITULO 8":
                evento_cap(8);
                break;
            case "CAPITULO 9":
                evento_cap(9);
                break;
            case "CAPITULO 10":
                evento_cap(10);
                break;
            default:
                throw new AssertionError();
        }

    }

    public void evento_cap(int opcion) {

        switch (opcion) {
            case 1:

                setVisible(false);
                dispose();

                JDialog dialog1 = new JDialog(this, "Ventana de Capitulo", true);
                dialog1.setSize(800, 600);
                dialog1.setLocationRelativeTo(this);
                dialog1.setLayout(null);

                JLabel objetivoLabel1 = new JLabel("Capitulo 1 ");
                objetivoLabel1.setBounds(50, 30, 300, 30);
                dialog1.add(objetivoLabel1);

                textArea = new JTextArea(10, 30);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setText("""

                                 La educación permite la movilidad socioeconómica ascendente y es clave para salir de la pobreza. Durante la última década, se consiguieron grandes avances a la hora de ampliar el acceso a la educación y las tasas de matriculación en las escuelas en todos los niveles, especialmente para las niñas. 
                                  A nivel mundial, el número de personas que viven en situación de extrema pobreza disminuyó desde un 36 % en 1990 hasta un 10 % en 2015. No obstante, el ritmo al que se produce este cambio está disminuyendo, y la crisis de la COVID-19 pone en riesgo décadas de progreso en la lucha contra la pobreza. Una nueva investigación publicada por el Instituto Mundial de Investigaciones de Economía del Desarrollo de la Universidad de las Naciones Unidas advierte de que las consecuencias económicas de la pandemia mundial podrían incrementar la pobreza en todo el mundo hasta llegar a afectar a 500 millones de personas más, o lo que es lo mismo, a un 8 % más de la población total mundial. Esta sería la primera vez que la pobreza aumente en todo el mundo en 30 años, desde 1990.""");

                textArea.setEnabled(false);

                JScrollPane objetivoScrollPane = new JScrollPane(textArea);
                objetivoScrollPane.setBounds(50, 70, 580, 380);

                dialog1.add(objetivoScrollPane);

                JLabel enlaceLabel = new JLabel("<html><a href=\"https://www.un.org/sustainabledevelopment/es/wp-content/uploads/sites/3/2016/10/1_Spanish_Why_it_Matters.pdf\">Link Pdf</a></html>"
                                               );
                enlaceLabel.setBounds(50, 500, 150, 30);
                enlaceLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                enlaceLabel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            Desktop desktop = Desktop.getDesktop();
                            URI uri = new URI("https://www.un.org/sustainabledevelopment/es/wp-content/uploads/sites/3/2016/10/1_Spanish_Why_it_Matters.pdf");
                            desktop.browse(uri);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                dialog1.add(enlaceLabel);

                jbVolver = new JButton("Volver");
                jbVolver.setBounds(50, 530, 150, 30);
                jbVolver.setFocusable(false);
                jbVolver.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        evento_jbVolver1();
                    }
                });
                dialog1.add(jbVolver);

                jbsiguiente = new JButton("Siguiente");
                jbsiguiente.setBounds(570, 530, 150, 30);
                jbsiguiente.setFocusable(false);
                jbsiguiente.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Siguiente1();
                    }
                });
                dialog1.add(jbsiguiente);

                dialog1.setVisible(true);

                break;
            case 2:

                setVisible(false);
                dispose();

                JDialog dialog2 = new JDialog(this, "Ventana de Capitulo", true);
                dialog2.setSize(800, 600);
                dialog2.setLocationRelativeTo(this);
                dialog2.setLayout(null);

                JLabel objetivoLabel2 = new JLabel("Capitulo 2 ");
                objetivoLabel2.setBounds(50, 30, 300, 30);
                dialog2.add(objetivoLabel2);

                textArea = new JTextArea(10, 30);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setText("""
                                 Tras décadas de una disminución constante, el número de personas que padecen hambre (medido por la prevalencia de desnutrición) comenzó a aumentar lentamente de nuevo en 2015. Las estimaciones actuales indican que cerca de 690 millones de personas en el mundo padecen hambre, es decir, el 8,9 por ciento de la población mundial, lo que supone un aumento de unos 10 millones de personas en un año y de unos 60 millones en cinco años. 
                                 
                                 El mundo no está bien encaminado para alcanzar el objetivo de hambre cero para 2030. Si continúan las tendencias recientes, el número de personas afectadas por el hambre superará los 840 millones de personas para 2030.
                                 
                                 Según el Programa Mundial de Alimentos, alrededor de 135 millones de personas padecen hambre severa Disponible en inglés, debido principalmente a los conflictos causados por los seres humanos, el cambio climático y las recesiones económicas. La pandemia de COVID-19 podría duplicar ahora esa cifra y sumar unos 130 millones de personas más que estarían en riesgo de padecer hambre severa a finales de 2020.
                                 
                                 Con más de 250 millones de personas que podrían encontrarse al borde de la hambruna Disponible en inglés, es necesario actuar rápidamente para proporcionar alimentos y ayuda humanitaria a las regiones que corren más riesgos.
                                 
                                 Al mismo tiempo, es necesario llevar a cabo un cambio profundo en el sistema agroalimentario mundial si queremos alimentar a más de 820 millones de personas que padecen hambre y a los 2000 millones de personas más que vivirán en el mundo en 2050. El aumento de la productividad agrícola y la producción alimentaria sostenible son cruciales para ayudar a aliviar los riesgos del hambre.
                                                                  """);
                textArea.setEnabled(false);

                JScrollPane objetivoScrollPane2 = new JScrollPane(textArea);
                objetivoScrollPane2.setBounds(50, 70, 580, 380);
                dialog2.add(objetivoScrollPane2);
                
                JLabel enlaceLabel2 = new JLabel("<html><a href=\"https://www.un.org/sustainabledevelopment/es/wp-content/uploads/sites/3/2016/10/1_Spanish_Why_it_Matters.pdf\">Link Pdf</a></html>");
                enlaceLabel2.setBounds(50, 500, 150, 30);
                enlaceLabel2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                enlaceLabel2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            Desktop desktop = Desktop.getDesktop();
                            URI uri = new URI("https://www.un.org/sustainabledevelopment/es/wp-content/uploads/sites/3/2016/10/1_Spanish_Why_it_Matters.pdf");
                            desktop.browse(uri);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                dialog2.add(enlaceLabel2);

                jbVolver = new JButton("Volver");
                jbVolver.setBounds(50, 530, 150, 30);
                jbVolver.setFocusable(false);
                jbVolver.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        evento_jbVolver2();
                    }
                });
                dialog2.add(jbVolver);

                jbsiguiente = new JButton("Siguiente");
                jbsiguiente.setBounds(570, 530, 150, 30);
                jbsiguiente.setFocusable(false);
                jbsiguiente.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Siguiente2();
                    }
                });
                dialog2.add(jbsiguiente);

                dialog2.setVisible(true);
                break;

            case 3:
                setVisible(false);
                dispose();

                JDialog dialog3 = new JDialog(this, "Ventana de Capitulo", true);
                dialog3.setSize(800, 600);
                dialog3.setLocationRelativeTo(this);
                dialog3.setLayout(null);

                JLabel objetivoLabel3 = new JLabel("Capitulo 3 ");
                objetivoLabel3.setBounds(50, 30, 300, 30);
                dialog3.add(objetivoLabel3);

                textArea = new JTextArea(10, 30);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setText("""
                                 Garantizar una vida sana y promover el bienestar en todas las edades es esencial para el desarrollo sostenible.
                                 
                                 Actualmente, el mundo se enfrenta a una crisis sanitaria mundial sin precedentes; la COVID-19 está propagando el sufrimiento humano, desestabilizando la economía mundial y cambiando drásticamente las vidas de miles de millones de personas en todo el mundo.
                                 
                                 Antes de la pandemia, se consiguieron grandes avances en la mejora de la salud de millones de personas. En concreto, estos grandes avances se alcanzaron al aumentar la esperanza de vida y reducir algunas de las causas de muerte comunes asociadas con la mortalidad infantil y materna. Sin embargo, se necesitan más esfuerzos para erradicar por completo una gran variedad de enfermedades y abordar un gran número de problemas de salud, tanto constantes como emergentes. A través de una financiación más eficiente de los sistemas sanitarios, un mayor saneamiento e higiene, y un mayor acceso al personal médico, se podrán conseguir avances significativos a la hora de ayudar a salvar las vidas de millones de personas.
                                 
                                 Las emergencias sanitarias, como la derivada de la COVID-19, suponen un riesgo mundial y han demostrado que la preparación es vital. El Programa de las Naciones Unidas para el Desarrollo señaló las grandes diferencias relativas a las capacidades de los países para lidiar con la crisis de la COVID-19 y recuperarse de ella. La pandemia constituye un punto de inflexión en lo referente a la preparación para las emergencias sanitarias y la inversión en servicios públicos vitales del siglo XXI.""");
                textArea.setEnabled(false);

                JScrollPane objetivoScrollPane3 = new JScrollPane(textArea);
                objetivoScrollPane3.setBounds(50, 70, 580, 380);
                dialog3.add(objetivoScrollPane3);
                
                JLabel enlaceLabel3 = new JLabel("<html><a href=\"http://www.un.org/sustainabledevelopment/es/wp-content/uploads/sites/3/2016/10/3_Spanish_Why_it_Matters.pdf\">Link Pdf</a></html>");
                enlaceLabel3.setBounds(50, 500, 150, 30);
                enlaceLabel3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                enlaceLabel3.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            Desktop desktop = Desktop.getDesktop();
                            URI uri = new URI("http://www.un.org/sustainabledevelopment/es/wp-content/uploads/sites/3/2016/10/3_Spanish_Why_it_Matters.pdf");
                            desktop.browse(uri);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                dialog3.add(enlaceLabel3);

                jbVolver = new JButton("Volver");
                jbVolver.setBounds(50, 530, 150, 30);
                jbVolver.setFocusable(false);
                jbVolver.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        evento_jbVolver3();
                    }
                });
                dialog3.add(jbVolver);

                jbsiguiente = new JButton("Siguiente");
                jbsiguiente.setBounds(570, 530, 150, 30);
                jbsiguiente.setFocusable(false);
                jbsiguiente.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Siguiente3();
                    }
                });
                dialog3.add(jbsiguiente);

                dialog3.setVisible(true);
                break;


            case 4:
                setVisible(false);
                dispose();

                JDialog dialog4 = new JDialog(this, "Ventana de Capitulo", true);
                dialog4.setSize(800, 600);
                dialog4.setLocationRelativeTo(this);
                dialog4.setLayout(null);

                JLabel objetivoLabel4 = new JLabel("Capitulo 4 ");
                objetivoLabel4.setBounds(50, 30, 300, 30);
                dialog4.add(objetivoLabel4);

                textArea = new JTextArea(10, 30);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setText("""
                                 La educación permite la movilidad socioeconómica ascendente y es clave para salir de la pobreza. Durante la última década, se consiguieron grandes avances a la hora de ampliar el acceso a la educación y las tasas de matriculación en las escuelas en todos los niveles, especialmente para las niñas. No obstante, alrededor de 260 millones de niños aún estaban fuera de la escuela en 2018; cerca de una quinta parte de la población mundial de ese grupo de edad. Además, más de la mitad de todos los niños y adolescentes de todo el mundo no están alcanzando los estándares mínimos de competencia en lectura y matemáticas.
                                 
                                 En 2020, a medida que la pandemia de la COVID-19 se propagaba por todo el planeta, la mayor parte de los países anunciaron el cierre temporal de las escuelas, lo que afectó a más del 91 % de los estudiantes en todo el mundo. En abril de 2020, cerca de 1600 millones de niños y jóvenes estaban fuera de la escuela. Igualmente, cerca de 369 millones de niños que dependen de los comedores escolares tuvieron que buscar otras fuentes de nutrición diaria.
                                 
                                 Nunca antes habían estado tantos niños fuera de la escuela al mismo tiempo, lo que altera su aprendizaje y cambia drásticamente sus vidas, especialmente las de los niños más vulnerables y marginados. La pandemia mundial tiene graves consecuencias que pueden poner en peligro los avances que tanto costaron conseguir a la hora de mejorar la educación a nivel mundial.""");
                textArea.setEnabled(false);

                JScrollPane objetivoScrollPane4 = new JScrollPane(textArea);
                objetivoScrollPane4.setBounds(50, 70, 580, 380);
                dialog4.add(objetivoScrollPane4);
                
                JLabel enlaceLabel4 = new JLabel("<html><a href=\"http://www.un.org/sustainabledevelopment/es/wp-content/uploads/sites/3/2016/10/4_Spanish_Why_it_Matters.pdf\">Link Pdf</a></html>");
                enlaceLabel4.setBounds(50, 500, 150, 30);
                enlaceLabel4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                enlaceLabel4.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            Desktop desktop = Desktop.getDesktop();
                            URI uri = new URI("http://www.un.org/sustainabledevelopment/es/wp-content/uploads/sites/3/2016/10/4_Spanish_Why_it_Matters.pdf");
                            desktop.browse(uri);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                dialog4.add(enlaceLabel4);

                jbVolver = new JButton("Volver");
                jbVolver.setBounds(50, 530, 150, 30);
                jbVolver.setFocusable(false);
                jbVolver.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        evento_jbVolver4();
                    }
                });
                dialog4.add(jbVolver);

                jbsiguiente = new JButton("Siguiente");
                jbsiguiente.setBounds(570, 530, 150, 30);
                jbsiguiente.setFocusable(false);
                jbsiguiente.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Siguiente4();
                    }
                });
                dialog4.add(jbsiguiente);

                dialog4.setVisible(true);
                break;


            case 5:
                setVisible(false);
                dispose();

                JDialog dialog5 = new JDialog(this, "Ventana de Capitulo", true);
                dialog5.setSize(800, 600);
                dialog5.setLocationRelativeTo(this);
                dialog5.setLayout(null);

                JLabel objetivoLabel5 = new JLabel("Capitulo 5 ");
                objetivoLabel5.setBounds(50, 30, 300, 30);
                dialog5.add(objetivoLabel5);

                textArea = new JTextArea(10, 30);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setText("""
                                 Las mujeres desempeñan un papel desproporcionado en la respuesta al virus, incluso como trabajadoras sanitarias en primera línea y como cuidadoras en el hogar. El trabajo de cuidados no remunerado de las mujeres ha aumentado de manera significativa como consecuencia del cierre de las escuelas y el aumento de las necesidades de los ancianos. Las mujeres también se ven más afectadas por los efectos económicos de la COVID-19, ya que trabajan, de manera desproporcionada, en mercados laborales inseguros. Cerca del 60 % de las mujeres trabaja en la economía informal, lo que las expone aún más a caer en la pobreza.
                                 
                                 La pandemia también ha conducido a un fuerte aumento de la violencia contra las mujeres y las niñas. Con las medidas de confinamiento en vigor, muchas mujeres se encuentran atrapadas en casa con sus abusadores, con dificultades para acceder a servicios que están padeciendo recortes y restricciones. Los nuevos datos muestran que, desde el brote de la pandemia, la violencia contra las mujeres y las niñas (y, especialmente, la violencia doméstica) se ha intensificado.""");
                textArea.setEnabled(false);

                JScrollPane objetivoScrollPane5 = new JScrollPane(textArea);
                objetivoScrollPane5.setBounds(50, 70, 580, 380);
                dialog5.add(objetivoScrollPane5);
                
                JLabel enlaceLabel5 = new JLabel("<html><a href=\"http://www.un.org/sustainabledevelopment/es/wp-content/uploads/sites/3/2016/10/5_Spanish_Why_it_Matters.pdf\">Link Pdf</a></html>");
                enlaceLabel5.setBounds(50, 500, 150, 30);
                enlaceLabel5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                enlaceLabel5.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            Desktop desktop = Desktop.getDesktop();
                            URI uri = new URI("http://www.un.org/sustainabledevelopment/es/wp-content/uploads/sites/3/2016/10/5_Spanish_Why_it_Matters.pdf");
                            desktop.browse(uri);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                dialog5.add(enlaceLabel5);

                jbVolver = new JButton("Volver");
                jbVolver.setBounds(50, 530, 150, 30);
                jbVolver.setFocusable(false);
                jbVolver.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        evento_jbVolver5();
                    }
                });
                dialog5.add(jbVolver);

                jbsiguiente = new JButton("Siguiente");
                jbsiguiente.setBounds(570, 530, 150, 30);
                jbsiguiente.setFocusable(false);
                jbsiguiente.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Siguiente5();
                    }
                });
                dialog5.add(jbsiguiente);

                dialog5.setVisible(true);
                break;


            case 6:
                setVisible(false);
                dispose();

                JDialog dialog6 = new JDialog(this, "Ventana de Capitulo", true);
                dialog6.setSize(800, 600);
                dialog6.setLocationRelativeTo(this);
                dialog6.setLayout(null);

                JLabel objetivoLabel6 = new JLabel("Capitulo 6 ");
                objetivoLabel6.setBounds(50, 30, 300, 30);
                dialog6.add(objetivoLabel6);

                textArea = new JTextArea(10, 30);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setText("""
                                 Si bien se ha conseguido progresar de manera sustancial a la hora de ampliar el acceso a agua potable y saneamiento, existen miles de millones de personas (principalmente en áreas rurales) que aún carecen de estos servicios básicos. En todo el mundo, una de cada tres personas no tiene acceso a agua potable salubre, dos de cada cinco personas no disponen de una instalación básica destinada a lavarse las manos con agua y jabón, y más de 673 millones de personas aún defecan al aire libre.
                                 
                                 La pandemia de la COVID-19 ha puesto de manifiesto la importancia vital del saneamiento, la higiene y un acceso adecuado a agua limpia para prevenir y contener las enfermedades. La higiene de manos salva vidas. De acuerdo con la Organización Mundial de la Salud, el lavado de manos es una de las acciones más efectivas que se pueden llevar a cabo para reducir la propagación de patógenos y prevenir infecciones, incluido el virus de la COVID-19. Aun así, hay miles de millones de personas que carecen de acceso a agua salubre y saneamiento, y los fondos son insuficientes.""");
                textArea.setEnabled(false);

                JScrollPane objetivoScrollPane6 = new JScrollPane(textArea);
                objetivoScrollPane6.setBounds(50, 70, 580, 380);
                dialog6.add(objetivoScrollPane6);
                
                JLabel enlaceLabel6 = new JLabel("<html><a href=\"http://www.un.org/sustainabledevelopment/es/wp-content/uploads/sites/3/2016/10/6_Spanish_Why_it_Matters.pdf\">Link Pdf</a></html>");
                enlaceLabel6.setBounds(50, 500, 150, 30);
                enlaceLabel6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                enlaceLabel6.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            Desktop desktop = Desktop.getDesktop();
                            URI uri = new URI("http://www.un.org/sustainabledevelopment/es/wp-content/uploads/sites/3/2016/10/6_Spanish_Why_it_Matters.pdf");
                            desktop.browse(uri);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                dialog6.add(enlaceLabel6);

                jbVolver = new JButton("Volver");
                jbVolver.setBounds(50, 530, 150, 30);
                jbVolver.setFocusable(false);
                jbVolver.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        evento_jbVolver6();
                    }
                });
                dialog6.add(jbVolver);

                jbsiguiente = new JButton("Siguiente");
                jbsiguiente.setBounds(570, 530, 150, 30);
                jbsiguiente.setFocusable(false);
                jbsiguiente.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Siguiente6();
                    }
                });
                dialog6.add(jbsiguiente);

                dialog6.setVisible(true);
                break;


            case 7:
                setVisible(false);
                dispose();

                JDialog dialog7 = new JDialog(this, "Ventana de Capitulo", true);
                dialog7.setSize(800, 600);
                dialog7.setLocationRelativeTo(this);
                dialog7.setLayout(null);

                JLabel objetivoLabel7 = new JLabel("Capitulo 7 ");
                objetivoLabel7.setBounds(50, 30, 300, 30);
                dialog7.add(objetivoLabel7);

                textArea = new JTextArea(10, 30);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setText("""
                                 El mundo está avanzando hacia la consecución del Objetivo 7 con indicios alentadores de que la energía se está volviendo más sostenible y ampliamente disponible. El acceso a la electricidad en los países más pobres ha comenzado a acelerarse, la eficiencia energética continúa mejorando y la energía renovable está logrando resultados excelentes en el sector eléctrico.
                                 
                                 A pesar de ello, es necesario prestar una mayor atención a las mejoras para el acceso a combustibles de cocina limpios y seguros, y a tecnologías para 3000 millones de personas, para expandir el uso de la energía renovable más allá del sector eléctrico e incrementar la electrificación en el África subsahariana.
                                 
                                 El informe de progreso en materia de energía proporciona un registro mundial del progreso relativo al acceso a la energía, la eficiencia energética y la energía renovable. Evalúa el progreso conseguido por cada país en estos tres pilares y ofrece una panorámica del camino que nos queda por recorrer para conseguir las metas de los Objetivos de Desarrollo Sostenible 2030.""");
                textArea.setEnabled(false);

                JScrollPane objetivoScrollPane7 = new JScrollPane(textArea);
                objetivoScrollPane7.setBounds(50, 70, 580, 380);
                dialog7.add(objetivoScrollPane7);
                
                JLabel enlaceLabel7 = new JLabel("<html><a href=\"http://www.un.org/sustainabledevelopment/es/wp-content/uploads/sites/3/2016/10/7_Spanish_Why_it_Matters.pdf\">Link Pdf</a></html>");
                enlaceLabel7.setBounds(50, 500, 150, 30);
                enlaceLabel7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                enlaceLabel7.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            Desktop desktop = Desktop.getDesktop();
                            URI uri = new URI("http://www.un.org/sustainabledevelopment/es/wp-content/uploads/sites/3/2016/10/7_Spanish_Why_it_Matters.pdf");
                            desktop.browse(uri);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                dialog7.add(enlaceLabel7);

                jbVolver = new JButton("Volver");
                jbVolver.setBounds(50, 530, 150, 30);
                jbVolver.setFocusable(false);
                jbVolver.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        evento_jbVolver7();
                    }
                });
                dialog7.add(jbVolver);

                jbsiguiente = new JButton("Siguiente");
                jbsiguiente.setBounds(570, 530, 150, 30);
                jbsiguiente.setFocusable(false);
                jbsiguiente.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Siguiente7();
                    }
                });
                dialog7.add(jbsiguiente);

                dialog7.setVisible(true);
                break;


            case 8:
                setVisible(false);
                dispose();

                JDialog dialog8 = new JDialog(this, "Ventana de Capitulo", true);
                dialog8.setSize(800, 600);
                dialog8.setLocationRelativeTo(this);
                dialog8.setLayout(null);

                JLabel objetivoLabel8 = new JLabel("Capitulo 8 ");
                objetivoLabel8.setBounds(50, 30, 300, 30);
                dialog8.add(objetivoLabel8);

                textArea = new JTextArea(10, 30);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setText("""
                                 Un crecimiento económico inclusivo y sostenido puede impulsar el progreso, crear empleos decentes para todos y mejorar los estándares de vida.
                                 
                                 La COVID-19 ha alterado miles de millones de vidas y ha puesto en peligro la economía mundial. El Fondo Monetario Internacional (FMI) prevé una recesión mundial tan mala o peor que la de 2009. A medida que se intensifica la pérdida de empleo, la Organización Internacional del Trabajo estima que cerca de la mitad de todos los trabajadores a nivel mundial se encuentra en riesgo de perder sus medios de subsistencia.
                                 
                                 Incluso antes del brote de la COVID-19, era probable que uno de cada cinco países (en donde habitan miles de millones de personas que viven en situación de pobreza) vieran sus ingresos per cápita estancarse o reducirse en 2020. A día de hoy, las perturbaciones económicas y financieras derivadas de la COVID-19 (como las alteraciones en la producción industrial, la caída de los precios de los productos básicos, la volatilidad del mercado financiero y el aumento de la inseguridad) están desbaratando el ya de por sí tibio crecimiento económico y empeorando los riesgos acentuados de otros factores.""");
                textArea.setEnabled(false);

                JScrollPane objetivoScrollPane8 = new JScrollPane(textArea);
                objetivoScrollPane8.setBounds(50, 70, 580, 380);
                dialog8.add(objetivoScrollPane8);
                
                JLabel enlaceLabel8 = new JLabel("<html><a href=\"http://www.un.org/sustainabledevelopment/es/wp-content/uploads/sites/3/2016/10/8_Spanish_Why_it_Matters.pdf\">Link Pdf</a></html>");
                enlaceLabel8.setBounds(50, 500, 150, 30);
                enlaceLabel8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                enlaceLabel8.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            Desktop desktop = Desktop.getDesktop();
                            URI uri = new URI("http://www.un.org/sustainabledevelopment/es/wp-content/uploads/sites/3/2016/10/8_Spanish_Why_it_Matters.pdf");
                            desktop.browse(uri);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                dialog8.add(enlaceLabel8);

                jbVolver = new JButton("Volver");
                jbVolver.setBounds(50, 530, 150, 30);
                jbVolver.setFocusable(false);
                jbVolver.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        evento_jbVolver8();
                    }
                });
                dialog8.add(jbVolver);

                jbsiguiente = new JButton("Siguiente");
                jbsiguiente.setBounds(570, 530, 150, 30);
                jbsiguiente.setFocusable(false);
                jbsiguiente.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Siguiente8();
                    }
                });
                dialog8.add(jbsiguiente);

                dialog8.setVisible(true);
                break;


            case 9:
                setVisible(false);
                dispose();

                JDialog dialog9 = new JDialog(this, "Ventana de Capitulo", true);
                dialog9.setSize(800, 600);
                dialog9.setLocationRelativeTo(this);
                dialog9.setLayout(null);

                JLabel objetivoLabel9 = new JLabel("Capitulo 9 ");
                objetivoLabel9.setBounds(50, 30, 300, 30);
                dialog9.add(objetivoLabel9);

                textArea = new JTextArea(10, 30);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setText("""
                                 El crecimiento del sector manufacturero a nivel mundial ha ido disminuyendo constantemente, incluso antes del brote de la pandemia de la COVID-19. La pandemia está afectando gravemente a las industrias manufactureras y está provocando alteraciones en las cadenas de valor mundiales y en el suministro de productos.
                                 
                                 La innovación y el progreso tecnológico son claves para descubrir soluciones duraderas para los desafíos económicos y medioambientales, como el aumento de la eficiencia energética y de recursos. A nivel mundial, la inversión en investigación y desarrollo (I+D), como porcentaje del PIB, aumentó de un 1,5 % en el 2000 a un 1,7 % en el 2015, y continuó casi en el mismo nivel en el 2017. Sin embargo, en las regiones en desarrollo fue inferior al 1 %.
                                 
                                 En términos de infraestructura de comunicaciones, más de la mitad de la población mundial está ahora conectada y casi toda la población global vive en un área con cobertura de red móvil. Se estima que, en 2019, el 96,5 % de la población tenía cobertura de red, como mínimo, 2G.""");
                textArea.setEnabled(false);

                JScrollPane objetivoScrollPane9 = new JScrollPane(textArea);
                objetivoScrollPane9.setBounds(50, 70, 580, 380);
                dialog9.add(objetivoScrollPane9);
                
                JLabel enlaceLabel9 = new JLabel("<html><a href=\"http://www.un.org/sustainabledevelopment/es/wp-content/uploads/sites/3/2016/10/9_Spanish_Why_it_Matters.pdf\">Link Pdf</a></html>");
                enlaceLabel9.setBounds(50, 500, 150, 30);
                enlaceLabel9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                enlaceLabel9.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            Desktop desktop = Desktop.getDesktop();
                            URI uri = new URI("http://www.un.org/sustainabledevelopment/es/wp-content/uploads/sites/3/2016/10/9_Spanish_Why_it_Matters.pdf");
                            desktop.browse(uri);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                dialog9.add(enlaceLabel9);

                jbVolver = new JButton("Volver");
                jbVolver.setBounds(50, 530, 150, 30);
                jbVolver.setFocusable(false);
                jbVolver.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        evento_jbVolver9();
                    }
                });
                dialog9.add(jbVolver);

                jbsiguiente = new JButton("Siguiente");
                jbsiguiente.setBounds(570, 530, 150, 30);
                jbsiguiente.setFocusable(false);
                jbsiguiente.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Siguiente9();
                    }
                });
                dialog9.add(jbsiguiente);

                dialog9.setVisible(true);
                break;


            case 10:
                setVisible(false);
                dispose();

                JDialog dialog10 = new JDialog(this, "Ventana de Capitulo", true);
                dialog10.setSize(800, 600);
                dialog10.setLocationRelativeTo(this);
                dialog10.setLayout(null);

                JLabel objetivoLabel10 = new JLabel("Capitulo 10 ");
                objetivoLabel10.setBounds(50, 30, 300, 30);
                dialog10.add(objetivoLabel10);

                textArea = new JTextArea(10, 30);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setText("""
                                 Reducir las desigualdades y garantizar que nadie se queda atrás forma parte integral de la consecución de los Objetivos de Desarrollo Sostenible.
                                 
                                 La desigualdad dentro de los países y entre estos es un continuo motivo de preocupación. A pesar de la existencia de algunos indicios positivos hacia la reducción de la desigualdad en algunas dimensiones, como la reducción de la desigualdad de ingresos en algunos países y el estatus comercial preferente que beneficia a los países de bajos ingresos, la desigualdad aún continúa.
                                 
                                 La COVID-19 ha intensificado las desigualdades existentes y ha afectado más que nadie a los pobres y las comunidades más vulnerables. Ha sacado a la luz las desigualdades económicas y las frágiles redes de seguridad social que hacen que las comunidades vulnerables tengan que sufrir las consecuencias de la crisis.  Al mismo tiempo, las desigualdades sociales, políticas y económicas han amplificado los efectos de la pandemia.
                                 
                                 En el frente económico, la pandemia de la COVID-19 ha aumentado significativamente el desempleo mundial y ha recortado drásticamente los ingresos de los trabajadores.""");
                textArea.setEnabled(false);

                JScrollPane objetivoScrollPane10 = new JScrollPane(textArea);
                objetivoScrollPane10.setBounds(50, 70, 580, 380);
                dialog10.add(objetivoScrollPane10);
                
                JLabel enlaceLabel10 = new JLabel("<html><a href=\"http://www.un.org/sustainabledevelopment/es/wp-content/uploads/sites/3/2016/10/10_Spanish_Why_it_Matters.pdf\">Link Pdf</a></html>");
                enlaceLabel10.setBounds(50, 500, 150, 30);
                enlaceLabel10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                enlaceLabel10.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            Desktop desktop = Desktop.getDesktop();
                            URI uri = new URI("http://www.un.org/sustainabledevelopment/es/wp-content/uploads/sites/3/2016/10/10_Spanish_Why_it_Matters.pdf");
                            desktop.browse(uri);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                dialog10.add(enlaceLabel10);

                jbVolver = new JButton("Volver");
                jbVolver.setBounds(50, 530, 150, 30);
                jbVolver.setFocusable(false);
                jbVolver.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        evento_jbVolver10();
                    }
                });
                dialog10.add(jbVolver);

                jbsiguiente = new JButton("Cerrar");
                jbsiguiente.setBounds(570, 530, 150, 30);
                jbsiguiente.setFocusable(false);
                jbsiguiente.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        evento_jbVolver1();
                    }
                });
                dialog10.add(jbsiguiente);

                dialog10.setVisible(true);
                break;


        }

    }

    public void evento_jbVolver() {
        pi = new ProyectoIntegrador();
        setVisible(false);
        dispose();
        pi.setVisible(true);
    }

    public void evento_jbVolver1() {
        setVisible(false);
        dispose();
        Humanidades hm = new Humanidades(pi);
        hm.setVisible(true);
    }

    public void evento_jbVolver2() {
        setVisible(false);
        dispose();
        evento_cap(1);
    }

    public void evento_jbVolver3() {
        setVisible(false);
        dispose();
        evento_cap(2);
    }

    public void evento_jbVolver4() {
        setVisible(false);
        dispose();
        evento_cap(3);
    }

    public void evento_jbVolver5() {
        setVisible(false);
        dispose();
        evento_cap(4);
    }

    public void evento_jbVolver6() {
        setVisible(false);
        dispose();
        evento_cap(5);
    }

    public void evento_jbVolver7() {
        setVisible(false);
        dispose();
        evento_cap(6);
    }

    public void evento_jbVolver8() {
        setVisible(false);
        dispose();
        evento_cap(7);
    }

    public void evento_jbVolver9() {
        setVisible(false);
        dispose();
        evento_cap(8);
    }

    public void evento_jbVolver10() {
        setVisible(false);
        dispose();
        evento_cap(9);
    }

    public void Siguiente1() {
        setVisible(false);
        dispose();
        evento_cap(2);
    }

    public void Siguiente2() {
        setVisible(false);
        dispose();
        evento_cap(3);
    }

    public void Siguiente3() {
        setVisible(false);
        dispose();
        evento_cap(4);
    }

    public void Siguiente4() {
        setVisible(false);
        dispose();
        evento_cap(5);
    }

    public void Siguiente5() {
        setVisible(false);
        dispose();
        evento_cap(6);
    }

    public void Siguiente6() {
        setVisible(false);
        dispose();
        evento_cap(7);
    }

    public void Siguiente7() {
        setVisible(false);
        dispose();
        evento_cap(8);
    }

    public void Siguiente8() {
        setVisible(false);
        dispose();
        evento_cap(9);
    }

    public void Siguiente9() {
        setVisible(false);
        dispose();
        evento_cap(10);
    }

    /*private void abrirVentanaDialog(int objetivoIndex) {
        JDialog dialog = new JDialog(this, "Ventana de Capitulo", true);
        dialog.setSize(800, 600);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(null);

        JLabel objetivoLabel = new JLabel("Capitulo " + (objetivoIndex + 1));
        objetivoLabel.setBounds(50, 30, 300, 30);
        dialog.add(objetivoLabel);

        JTextArea objetivo1TextArea = new JTextArea();
        objetivo1TextArea.setText(textArea.getText().split("\n\n")[objetivoIndex]);

        objetivo1TextArea.setEnabled(false);
        objetivo1TextArea.setEditable(false);

        JScrollPane objetivoScrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        objetivoScrollPane.setBounds(50, 70, 580, 380);
        dialog.add(objetivoScrollPane);

        
        dialog.setVisible(true);
    }*/
    private void abrirMaterialComplementario() {
        

    }

    private void realizarCuestionario () {
       
        
        if (intentos >= 2) {
           
            return;
        }

        JDialog cuestionarioDialog = new JDialog(this, "Cuestionario", true);
        cuestionarioDialog.setSize(800, 600);
        cuestionarioDialog.setLocationRelativeTo(this);
        cuestionarioDialog.setLayout(null);
        

        // avanzar, retroceder y calificar
        JButton cerrarButton = new JButton("Cerrar");
        cerrarButton.setBounds(150, 230, 100, 30);
        cerrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cuestionarioDialog.dispose();
            }
        });
        cuestionarioDialog.add(cerrarButton);

        cuestionarioDialog.setVisible(true);

        // Actualizar los datos del usuario y enviar correo al docente
        usuarios.add("Nombre del usuario");
        puntajes.add(90.0); // Puntaje obtenido en el cuestionario

        intentos++;

        if (intentos == 2) {
            //enviarCorreoDocente();
        }
    }
    public void llamarCuestionario(){
        dispose();
        setVisible(false);
        CuestionarioDialog ce = new CuestionarioDialog();
        
        
    }

    /*private void enviarCorreoDocente() {
        final String username = "cristopher.02.010ca@gmail.com";
        final String password = "2Octubre2004gmail";
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("destinatario@gmail.com"));
            message.setSubject("Asunto del correo");
            message.setText("Cuerpo del correo");

            Transport.send(message);

            System.out.println("Correo enviado exitosamente.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }*/
}
    

    

