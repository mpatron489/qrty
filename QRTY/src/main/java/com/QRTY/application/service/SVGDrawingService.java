package com.QRTY.application.service;

import com.google.zxing.common.BitMatrix;
import org.jfree.svg.SVGGraphics2D;

import java.awt.*;

public class SVGDrawingService
{
    public SVGGraphics2D generateSVGFromBitMatrix(BitMatrix bitMatrix)
    {
        double bitMatrixWidth = bitMatrix.getWidth();
        double bitMatrixHeight = bitMatrix.getHeight();

        SVGGraphics2D output = new SVGGraphics2D(bitMatrixWidth, bitMatrixHeight);
        output.setColor(Color.BLACK);

        for(int yIndex = 0; yIndex < bitMatrixHeight; yIndex = yIndex + bitMatrix.getRowSize())

        {
            for(int xIndex = 0; xIndex < bitMatrixWidth; xIndex = xIndex + bitMatrix.getRowSize())
            {
                if(bitMatrix.get(xIndex, yIndex))
                {
                    output.fillRect(xIndex, yIndex, bitMatrix.getRowSize(), bitMatrix.getRowSize());
                }
            }
        }
        return output;
    }
}
