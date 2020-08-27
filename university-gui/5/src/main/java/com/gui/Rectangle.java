package com.gui;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rectangle extends GeometricPrimitive
{
    private Double a;
    private Double b;

    public Rectangle(Double a, Double b) throws IllegalArgumentException {
        if(a <= 0 || b <= 0) throw new IllegalArgumentException("All sides and height has to be positive");
        this.a = a;
        this.b = b;
    }

    public void serialize(OutputStream output) throws IOException {
        output.write(toString().getBytes());
        output.flush();
        output.close();
    }

    public static Rectangle deserialize(InputStream input) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        StringBuffer sb = new StringBuffer();
        String str;
        while((str = reader.readLine()) != null) {
            sb.append(str);
        }

        Pattern r = Pattern.compile("rectangle a=(\\d+.\\d+) b=(\\d+.\\d+)");
        Matcher m = r.matcher(sb.toString());

        if(m.find()) {
            try {
                String a = m.group(1);
                String b = m.group(2);
                return new Rectangle(Double.parseDouble(a), Double.parseDouble(b));
            }
            catch(Exception e) {
                throw new Exception("File contents does not match the format");
            }
        }
        else {
            throw new Exception("File contents does not match the format");
        }
    }

    @Override
    public String toString() {
        return "rectangle a="+a+" b="+b;
    }

    @Override
    public Double getPerimeter() {
        return (2*a) + (2*b);
    }

    @Override
    public Double getArea() {
        return a*b;
    }

    public Double getA() {
        return a;
    }

    public Double getB() {
        return b;
    }
}
