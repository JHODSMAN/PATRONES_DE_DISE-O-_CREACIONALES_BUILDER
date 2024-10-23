import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfiguradorComputadoraUI extends JFrame {
    private JComboBox<String> procesadorCombo;
    private JComboBox<Integer> ramCombo;
    private JComboBox<Integer> almacenamientoCombo;
    private JCheckBox tarjetaGraficaCheck;
    private JCheckBox wifiCheck;
    private JTextArea resultadoArea;

    public ConfiguradorComputadoraUI() {
        setTitle("Configurador de Computadoras");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2));

        procesadorCombo = new JComboBox<>(new String[]{"Intel i5", "Intel i7", "AMD Ryzen 5", "AMD Ryzen 7"});
        ramCombo = new JComboBox<>(new Integer[]{8, 16, 32});
        almacenamientoCombo = new JComboBox<>(new Integer[]{256, 512, 1000});
        tarjetaGraficaCheck = new JCheckBox("Tarjeta Gráfica");
        wifiCheck = new JCheckBox("WiFi");

        JButton construirButton = new JButton("Construir Computadora");
        resultadoArea = new JTextArea(5, 30);
        resultadoArea.setEditable(false);

        add(new JLabel("Procesador:"));
        add(procesadorCombo);
        add(new JLabel("RAM (GB):"));
        add(ramCombo);
        add(new JLabel("Almacenamiento (GB):"));
        add(almacenamientoCombo);
        add(tarjetaGraficaCheck);
        add(wifiCheck);
        add(construirButton);
        add(new JScrollPane(resultadoArea));

        construirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                construirComputadora();
            }
        });
    }

    private void construirComputadora() {
        String procesador = (String) procesadorCombo.getSelectedItem();
        int ram = (int) ramCombo.getSelectedItem();
        int almacenamiento = (int) almacenamientoCombo.getSelectedItem();
        boolean tarjetaGrafica = tarjetaGraficaCheck.isSelected();
        boolean wifi = wifiCheck.isSelected();

        Computadora computadora = new Computadora.ComputadoraBuilder(procesador, ram)
                .setAlmacenamiento(almacenamiento)
                .setTarjetaGrafica(tarjetaGrafica)
                .setWifi(wifi)
                .build();

        resultadoArea.setText(computadora.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ConfiguradorComputadoraUI().setVisible(true);
        });
    }
}
