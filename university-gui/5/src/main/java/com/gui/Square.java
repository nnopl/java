package com.gui;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Square extends GeometricPrimitive {

    private Double a;

    public Square(Double a) throws IllegalArgumentException {
        if(a <= 0 )throw new IllegalArgumentException("side has to be positive");
        this.a = a;
    }

    public void serialize(OutputStream output) throws IOException {
        output.write(toString().getBytes());
        output.flush();
        output.close();
    }

    public static Square deserialize(InputStream input) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        StringBuffer sb = new StringBuffer();
        String str;
        while((str = reader.readLine()) != null) {
            sb.append(str);
        }

        Pattern r = Pattern.compile("square a=(\\d+.\\d+)");
        Matcher m = r.matcher(sb.toString());

        if(m.find()) {
            try {
                String a = m.group(1);
                return new Square(Double.parseDouble(a));
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
        return "square a="+a;
    }

    @Override
    public Double getPerimeter() {
        return 4*a;
    }

    @Override
    public Double getArea() {
        return a*a;
    }

    public Double getA() {
        return a;
    }
}
