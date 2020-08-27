import org.junit.Assert;
import org.junit.Test;
import com.gui.*;

import java.io.*;

public class GeometricSerializationTest {

    @Test
    public void circleSerializationTest(){

        try {
            Circle circle = new Circle(4.2d);
            circle.serialize(new FileOutputStream("file"));

            Circle deserialized = Circle.deserialize(new FileInputStream("file"));
            Assert.assertEquals(circle.toString(), deserialized.toString());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void diamondSerializationTest(){

        try {
            Diamond diamond = new Diamond(4d, 5d);
            diamond.serialize(new FileOutputStream("file"));

            Diamond deserialized = Diamond.deserialize(new FileInputStream("file"));
            Assert.assertEquals(diamond.toString(), deserialized.toString());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void parallelogramSerializationTest(){

        try {
            Parallelogram parallelogram = new Parallelogram(2d, 3d, 2d);
            parallelogram.serialize(new FileOutputStream("file"));

            Parallelogram deserialized = Parallelogram.deserialize(new FileInputStream("file"));
            Assert.assertEquals(parallelogram.toString(), deserialized.toString());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void rectangleSerializationTest(){

        try {
            Rectangle rectangle = new Rectangle(5d, 3.3d);
            rectangle.serialize(new FileOutputStream("file"));

            Rectangle deserialized = Rectangle.deserialize(new FileInputStream("file"));
            Assert.assertEquals(rectangle.toString(), deserialized.toString());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void squareSerializationTest(){

        try {
            Square square = new Square(5.4d);
            square.serialize(new FileOutputStream("file"));

            Square deserialized = Square.deserialize(new FileInputStream("file"));
            Assert.assertEquals(square.toString(), deserialized.toString());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void trapeziumSerializationTest(){

        try {
            Trapezium trapezium = new Trapezium(6d, 5d, 4d, 4d, 3d);
            trapezium.serialize(new FileOutputStream("file"));

            Trapezium deserialized = Trapezium.deserialize(new FileInputStream("file"));
            Assert.assertEquals(trapezium.toString(), deserialized.toString());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void triangleSerializationTest(){

        try {
            Triangle triangle = new Triangle(3d, 4d, 5d, 4d);
            triangle.serialize(new FileOutputStream("file"));

            Triangle deserialized = Triangle.deserialize(new FileInputStream("file"));
            Assert.assertEquals(triangle.toString(), deserialized.toString());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    void createCorruptedFile(){
        //corrupted file
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("corrupted"));
            writer.write("circle radius=aa");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void circleSerializationCorruptedFileTest(){
        createCorruptedFile();

        try {
            Circle.deserialize(new FileInputStream("corrupted"));
            Assert.fail("Expected exception");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void diamondSerializationCorruptedFileTest(){
        createCorruptedFile();

        try {
            Diamond.deserialize(new FileInputStream("corrupted"));
            Assert.fail("Expected exception");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void parallelogramSerializationCorruptedFileTest(){
        createCorruptedFile();

        try {
            Parallelogram.deserialize(new FileInputStream("corrupted"));
            Assert.fail("Expected exception");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void rectangleSerializationCorruptedFileTest(){
        createCorruptedFile();

        try {
            Rectangle.deserialize(new FileInputStream("corrupted"));
            Assert.fail("Expected exception");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void squareSerializationCorruptedFileTest(){
        createCorruptedFile();

        try {
            Square.deserialize(new FileInputStream("corrupted"));
            Assert.fail("Expected exception");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void trapeziumSerializationCorruptedFileTest(){
        createCorruptedFile();

        try {
            Trapezium.deserialize(new FileInputStream("corrupted"));
            Assert.fail("Expected exception");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void triangleSerializationCorruptedFileTest(){
        createCorruptedFile();

        try {
            Triangle.deserialize(new FileInputStream("corrupted"));
            Assert.fail("Expected exception");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
