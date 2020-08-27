import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Main extends JFrame {

    public static void main(String[] args) {
        new Main();
    }

    Chart chart = new Chart();
    long[] values = new long[4];
    int firstIndex = 0;
    Color[] colors = {Color.orange, Color.green, Color.blue, Color.red};

    public Main(){
        JPanel mainPane = new JPanel();
        mainPane.setLayout(null);

        JTextField universityTextField = new JTextField("200");
        JTextField collegeTextField = new JTextField("300");
        JTextField tradeGraduatesTextField = new JTextField("100");
        JTextField primarySchoolGraduates = new JTextField("400");

        universityTextField.setBackground(colors[0]);
        collegeTextField.setBackground(colors[1]);
        tradeGraduatesTextField.setBackground(colors[2]);
        primarySchoolGraduates.setBackground(colors[3]);

        tradeGraduatesTextField.setForeground(Color.white);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(0,2, 10, 10));
        inputPanel.add(new JLabel("University degree"));
        inputPanel.add(universityTextField);

        inputPanel.add(new JLabel("College graduates"));
        inputPanel.add(collegeTextField);

        inputPanel.add(new JLabel("Trade school graduates"));
        inputPanel.add(tradeGraduatesTextField);

        inputPanel.add(new JLabel("Primary school graduates"));
        inputPanel.add(primarySchoolGraduates);
        inputPanel.add(new JLabel("Click on chart to apply"));

        inputPanel.setBounds(0, 0, 320, 150);
        inputPanel.setBorder(BorderFactory.createTitledBorder("Inputs"));
        mainPane.add(inputPanel);

        chart.setBounds(330, 0, 280, 250);
        mainPane.add(chart);

        chart.addActionListener((e)->{
            try {
                // parse values
                values[0] = Long.parseLong(universityTextField.getText());
                values[1] = Long.parseLong(collegeTextField.getText());
                values[2] = Long.parseLong(tradeGraduatesTextField.getText());
                values[3] = Long.parseLong(primarySchoolGraduates.getText());

                for(int i = 0; i < values.length; i++)
                {
                    if(values[i] < 0)
                        throw new Exception();
                }

                //create new slices
                Slice[] slices = new Slice[4];
                int index = firstIndex;
                System.out.println("index="+index);
                for(int i = 0; i < slices.length; i++)
                {
                    slices[i] = new Slice(values[index], colors[index]);
                    if(++index == values.length)
                        index = 0;
                }

                if(++firstIndex == values.length)
                    firstIndex = 0;

                chart.setSlices(slices);
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Invalid data in inputs", "error", JOptionPane.ERROR_MESSAGE);
            }
        });

        chart.doClick();

        add(mainPane);
        setPreferredSize(new Dimension(630,300));
        setMinimumSize(new Dimension(400,200));
        pack();
        setVisible(true);

        mainPane.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Dimension newDimensions = e.getComponent().getSize();

                chart.setBounds(330, 0, (int) (newDimensions.getWidth() - 340), (int) (newDimensions.getHeight()-10));
            }
        });
    }
}
