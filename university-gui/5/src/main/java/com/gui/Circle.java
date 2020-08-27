package com.gui;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Circle extends GeometricPrimitive {

    private Double r;

    public Circle(Double r) throws IllegalArgumentException {
        if(r <= 0) throw new IllegalArgumentException("radius has to be positive");
        this.r = r;
    }

    @Override
    public Double getPerimeter() {
        return 2*Math.PI*r;
    }

    @Override
    public Double getArea() {
        return Math.PI*r*r;
    }

    public Double getR() {
        return r;
    }

    public void serialize(OutputStream output) throws IOException {
        output.write(toString().getBytes());
        output.flush();
        output.close();
    }

    public static Circle deserialize(InputStream input) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        StringBuffer sb = new StringBuffer();
        String str;
        while((str = reader.readLine()) != null) {
            sb.append(str);
        }

        Pattern r = Pattern.compile("circle radius=(\\d+.\\d+)");
        Matcher m = r.matcher(sb.toString());

        if(m.find()) {
            try {
                String radius = m.group(1);
                return new Circle(Double.parseDouble(radius));
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
        return "circle radius="+r;
    }
}
