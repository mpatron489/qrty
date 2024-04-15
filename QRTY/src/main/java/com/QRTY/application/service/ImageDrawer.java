package com.QRTY.application.service;

import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageDrawer implements Drawable
{
    private static ImageDrawer imageDrawerInstance = null;
    private ImageDrawer(){
        super();
    }

    static ImageDrawer getInstance(){
        if(imageDrawerInstance == null){
            imageDrawerInstance = new ImageDrawer();
        }
        return imageDrawerInstance;
    }
    @Override
    public BufferedImage generate(BitMatrix matrix) throws IOException
    {
        BufferedImage output = new BufferedImage(matrix.getWidth(), matrix.getHeight(), BufferedImage.TYPE_INT_RGB);
        for(int w = 0; w < matrix.getWidth(); w++){
            for(int h = 0; h < matrix.getHeight(); h++){
                if(matrix.get(w, h)){
                    output.setRGB(w, h, 0xFF000000);
                }
                else{
                    output.setRGB(w, h, 0xFFFFFFFF);
                }
            }
        }
        return output;
    }


}
