import java.awt.*;
import javax.swing.*;

class Slice {
    long value;
    Color color;

    public Slice(long value, Color color) {
        this.value = value;
        this.color = color;
    }
}

class Chart extends JButton {

    private Slice[] slices = new Slice[0];
    double total;

    Chart() {
        setContentAreaFilled(false);
        setBorder(BorderFactory.createTitledBorder("Button and chart"));
    }

    public void setSlices(Slice[] slices)
    {
        this.slices = slices;

        total = 0;
        for (int i = 0; i < slices.length; i++) {
            total += slices[i].value;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        double curValue = 0;
        int startAngle = 0;

        for (int i = 0; i < slices.length; i++) {
            startAngle = (int) (curValue * 360 / total);
            int arcAngle = (int)Math.ceil((slices[i].value * 360 / total));

            g.setColor(slices[i].color);
            g.fillArc(20, 20, (int)((getWidth()-20)*(2d/3d)), (int)((getHeight()-20)*(2d/3d)), startAngle+90, -arcAngle);

            curValue -= slices[i].value;
        }
    }
}

