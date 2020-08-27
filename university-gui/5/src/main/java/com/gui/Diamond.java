package com.gui;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Diamond extends GeometricPrimitive {

    private Double a;
    private Double height;

    public Diamond(Double a, Double height) throws IllegalArgumentException {
        if(a <= 0 || height <= 0) throw new IllegalArgumentException("All sides and height has to be positive");
        this.a = a;
        this.height = height;
    }

    public void serialize(OutputStream output) throws IOException {
        output.write(toString().getBytes());
        output.flush();
        output.close();
    }

    public static Diamond deserialize(InputStream input) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        StringBuffer sb = new StringBuffer();
        String str;
        while((str = reader.readLine()) != null) {
            sb.append(str);
        }

        Pattern r = Pattern.compile("diamond a=(\\d+.\\d+) height=(\\d+.\\d+)");
        Matcher m = r.matcher(sb.toString());

        if(m.find()) {
            try {
                String a = m.group(1);
                String height = m.group(2);
                return new Diamond(Double.parseDouble(a), Double.parseDouble(height));
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
        return "diamond a="+a+" height="+height;
    }

    @Override
    public Double getPerimeter() {
        return 4*a;
    }

    @Override
    public Double getArea() {
        return a*height;
    }

    public Double getA() {
        return a;
    }

    public Double getHeight() {
        return height;
    }
}
