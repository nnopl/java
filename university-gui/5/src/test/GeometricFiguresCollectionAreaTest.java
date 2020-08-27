import com.gui.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GeometricFiguresCollectionAreaTest {

    @Test
    public void collectionAreaTest(){

        List<GeometricPrimitive> figures = new ArrayList<>();
        figures.add(new Diamond(4d, 5d));
        figures.add(new Parallelogram(2d, 3d, 2d));
        figures.add(new Rectangle(5d, 2d));
        figures.add(new Square(3d));
        figures.add(new Trapezium(6d, 5d, 4d, 4d, 3d));
        figures.add(new Triangle( 3d, 4d, 5d, 4d));
        figures.add(new Circle(4d));

        Double totalArea = 0d;
        Double totalPerimeters = 0d;

        for (int i = 0; i < figures.size(); i++) {
            GeometricPrimitive figure = figures.get(i);
            totalArea += figure.getArea();
            totalPerimeters += figure.getPerimeter();
        }

        Assert.assertEquals(new Double(65.5 + (16*Math.PI)), totalArea);
        Assert.assertEquals(new Double(83 + (8 * Math.PI)), totalPerimeters);
    }
}
