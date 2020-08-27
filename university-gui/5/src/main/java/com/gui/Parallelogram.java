package com.gui;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parallelogram extends GeometricPrimitive {

    private Double base;
    private Double b;
    private Double height;

    public Parallelogram(Double base, Double b, Double height) throws IllegalArgumentException {
        if(base <= 0 || b <= 0 || height <= 0) throw new IllegalArgumentException("All sides and height has to be positive");
        this.base = base;
        this.b = b;
        this.height = height;
    }

    public void serialize(OutputStream output) throws IOException {
        output.write(toString().getBytes());
        output.flush();
        output.close();
    }

    public static Parallelogram deserialize(InputStream input) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        StringBuffer sb = new StringBuffer();
        String str;
        while((str = reader.readLine()) != null) {
            sb.append(str);
        }

        Pattern r = Pattern.compile("parallelogram base=(\\d+.\\d+) b=(\\d+.\\d+) height=(\\d+.\\d+)");
        Matcher m = r.matcher(sb.toString());

        if(m.find()) {
            try {
                String base = m.group(1);
                String b = m.group(2);
                String height = m.group(3);
                return new Parallelogram(Double.parseDouble(base), Double.parseDouble(b), Double.parseDouble(height));
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
        return "parallelogram base="+base+" b="+b+" height="+height;
    }

    @Override
    public Double getPerimeter() {
        return (2* base) + (2*b);
    }

    @Override
    public Double getArea() {
        return base *height;
    }

    public Double getBase() {
        return base;
    }

    public Double getB() {
        return b;
    }

    public Double getHeight() {
        return height;
    }
}
