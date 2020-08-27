import org.junit.Assert;
import org.junit.Test;
import com.gui.*;

public class GeometricFiguresPerimeterAndAreaTest {

    @Test
    public void squareTest(){
        GeometricPrimitive square = new Square(2.5);
        Assert.assertEquals(new Double(6.25), square.getArea());
        Assert.assertEquals(new Double(10), square.getPerimeter());
    }
    @Test
    public void rectangleTest(){
        GeometricPrimitive rectangle = new Rectangle(2.5, 5d);
        Assert.assertEquals(new Double(12.5), rectangle.getArea());
        Assert.assertEquals(new Double(15), rectangle.getPerimeter());
    }
    @Test
    public void parallelogramTest(){
        GeometricPrimitive parallelogram = new Parallelogram(2.5, 5d, 4d);
        Assert.assertEquals(new Double(10), parallelogram.getArea());
        Assert.assertEquals(new Double(15), parallelogram.getPerimeter());
    }
    @Test
    public void trapeziumTest(){
        GeometricPrimitive parallelogram = new Trapezium(2.5, 5d, 1d, 4d, 4d);
        Assert.assertEquals(new Double(15), parallelogram.getArea());
        Assert.assertEquals(new Double(12.5), parallelogram.getPerimeter());
    }
    @Test
    public void triangleTest(){
        GeometricPrimitive triangle = new Triangle(3d, 5d , 4d, 4d);
        Assert.assertEquals(new Double(6), triangle.getArea());
        Assert.assertEquals(new Double(12), triangle.getPerimeter());
    }
    @Test
    public void circleTest(){
        GeometricPrimitive circle = new Circle(5d);
        Assert.assertEquals(new Double(25*Math.PI), circle.getArea());
        Assert.assertEquals(new Double(10*Math.PI), circle.getPerimeter());
    }
    @Test
    public void diamondTest(){
        GeometricPrimitive circle = new Diamond(4d, 2d);
        Assert.assertEquals(new Double(8), circle.getArea());
        Assert.assertEquals(new Double(16), circle.getPerimeter());
    }
}
