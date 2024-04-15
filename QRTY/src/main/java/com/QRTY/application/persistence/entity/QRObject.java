package com.QRTY.application.persistence.entity;

import com.QRTY.application.persistence.ImageType;
import com.google.zxing.common.BitMatrix;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class QRObject
{
    private ImageType imageType;
    private String    url;
    private BitMatrix matrix;

    public QRObject(String imageType){
        if(imageType.equalsIgnoreCase("SVG")){
            this.imageType = ImageType.SVG;
        }

        else if(imageType.equalsIgnoreCase("PNG"))
        {
            this.imageType = ImageType.PNG;
        }

        else if(imageType.equalsIgnoreCase("JPEG")){
            this.imageType = ImageType.JPEG;
        }
    }
}
