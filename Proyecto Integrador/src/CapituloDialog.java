import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CapituloDialog extends JDialog {
    private JTextArea materialTextArea;
    private JScrollPane materialScrollPane;
    private String[] paginasWeb;
    private String videoURL;

    public CapituloDialog(String titulo, String material, String[] paginasWeb, String videoURL) {
        setTitle(titulo);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        this.paginasWeb = paginasWeb;
        this.videoURL = videoURL;

        crearGUI(material);

        setVisible(true);
    }

    private void crearGUI(String material) {
        JLabel materialLabel = new JLabel("Material Complementario:");
        materialLabel.setBounds(20, 20, 200, 30);
        add(materialLabel);

        materialTextArea = new JTextArea();
        materialTextArea.setText(material);
        materialTextArea.setEditable(false);

        materialScrollPane = new JScrollPane(materialTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        materialScrollPane.setBounds(20, 60, 560, 200);
        add(materialScrollPane);

        JLabel paginasWebLabel = new JLabel("Páginas Web:");
        paginasWebLabel.setBounds(20, 280, 200, 30);
        add(paginasWebLabel);

        int posY = 320;
        for (int i = 0; i < paginasWeb.length; i++) {
            JLabel paginaWebLabel = new JLabel(paginasWeb[i]);
            paginaWebLabel.setBounds(20, posY, 400, 20);
            add(paginaWebLabel);
            posY += 30;
        }

        JLabel videoLabel = new JLabel("Video:");
        videoLabel.setBounds(20, posY, 200, 30);
        add(videoLabel);

        JLabel videoURLLabel = new JLabel(videoURL);
        videoURLLabel.setBounds(20, posY + 40, 400, 20);
        add(videoURLLabel);
    }
}
