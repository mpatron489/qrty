package com.QRTY.application.service;

import com.google.zxing.common.BitMatrix;
import org.jfree.svg.SVGGraphics2D;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SVGConverter
{
    public SVGGraphics2D generate(BitMatrix imageToConvert) throws IOException
    {

        SVGGraphics2D output = new SVGGraphics2D(imageToConvert.getWidth(), imageToConvert.getHeight());

        for(int w = 0; w < output.getWidth(); w++){
            for(int h = 0; h < output.getHeight(); h++){
                if(imageToConvert.get(w, h)){
                    output.setPaint(Color.BLACK);
                    output.fill(new Rectangle(w, h, 1,1));
                }
                else{
                    output.setPaint(Color.WHITE);
                    output.fill(new Rectangle(w, h, 1,1));
                }
            }
        }
        File test = new File("image.svg");
        test.createNewFile();
        FileWriter testWriter = new FileWriter(test);
        testWriter.write(String.valueOf(output));
        return output;
    }
}
