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
    private BitMatrix matrix;

    public QRObject(String imageType){
        if(imageType.toUpperCase().equals("SVG")){
            this.imageType = ImageType.SVG;
        }
    }
}
