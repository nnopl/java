package com.gui;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Trapezium extends GeometricPrimitive {

    private Double a,b,c,d;
    private Double height;

    public Trapezium(Double a, Double b, Double c, Double d, Double height) throws IllegalArgumentException {
        if(a <= 0 || b <= 0 || c <= 0 || d <= 0 || height <= 0) throw new IllegalArgumentException("All sides and height has to be positive");
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.height = height;
    }

    public void serialize(OutputStream output) throws IOException {
        output.write(toString().getBytes());
        output.flush();
        output.close();
    }

    public static Trapezium deserialize(InputStream input) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        StringBuffer sb = new StringBuffer();
        String str;
        while((str = reader.readLine()) != null) {
            sb.append(str);
        }

        Pattern r = Pattern.compile("trapezium a=(\\d+.\\d+) b=(\\d+.\\d+) c=(\\d+.\\d+) d=(\\d+.\\d+) height=(\\d+.\\d+)");
        Matcher m = r.matcher(sb.toString());

        if(m.find()) {
            try {
                String a = m.group(1);
                String b = m.group(2);
                String c = m.group(3);
                String d = m.group(4);
                String height = m.group(5);
                return new Trapezium(Double.parseDouble(a), Double.parseDouble(b), Double.parseDouble(c) ,Double.parseDouble(d) ,Double.parseDouble(height));
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
        return "trapezium a="+a+" b="+b+" c="+c+" d="+d+" height="+height;
    }

    @Override
    public Double getPerimeter() {
        return a+b+c+d;
    }

    @Override
    public Double getArea() {
        return (a+b)*height/2;
    }

    public Double getA() {
        return a;
    }

    public Double getB() {
        return b;
    }

    public Double getC() {
        return c;
    }

    public Double getD() {
        return d;
    }

    public Double getHeight() {
        return height;
    }
}
