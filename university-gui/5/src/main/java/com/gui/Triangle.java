package com.gui;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Triangle extends GeometricPrimitive {

    private Double base, b, c;
    private Double height;

    public Triangle(Double base, Double b, Double c, Double height) throws IllegalArgumentException {
        if(base <= 0 || b <= 0 || c <= 0 || height <= 0) throw new IllegalArgumentException("All sides and height has to be positive");
        this.base = base;
        this.b = b;
        this.c = c;
        this.height = height;
    }

    public void serialize(OutputStream output) throws IOException {
        output.write(toString().getBytes());
        output.flush();
        output.close();
    }

    public static Triangle deserialize(InputStream input) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        StringBuffer sb = new StringBuffer();
        String str;
        while((str = reader.readLine()) != null) {
            sb.append(str);
        }

        Pattern r = Pattern.compile("triangle base=(\\d+.\\d+) b=(\\d+.\\d+) c=(\\d+.\\d+) height=(\\d+.\\d+)");
        Matcher m = r.matcher(sb.toString());

        if(m.find()) {
            try {
                String base = m.group(1);
                String b = m.group(2);
                String c = m.group(3);
                String height = m.group(4);
                return new Triangle(Double.parseDouble(base), Double.parseDouble(b), Double.parseDouble(c) ,Double.parseDouble(height));
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
        return "triangle base="+base+" b="+b+" c="+c+" height="+height;
    }

    @Override
    public Double getPerimeter() {
        return base+b+c;
    }

    @Override
    public Double getArea() {
        return base*height/2;
    }

    public Double getHeight() {
        return height;
    }

    public Double getBase() {
        return base;
    }

    public Double getB() {
        return b;
    }

    public Double getC() {
        return c;
    }
}
