package com.QRTY.application.service;

import com.QRTY.application.persistence.entity.QRObject;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@Service
public class QRService
{
    private static QRService qrServiceInstance = null;

    private QRService(){

    }

    public static QRService getInstance(){
        if(qrServiceInstance == null){
            qrServiceInstance = new QRService();
        }
        return qrServiceInstance;
    }
    public void generateQRCode(QRObject qrObject) throws WriterException
    {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        Map<EncodeHintType, ErrorCorrectionLevel> hints = new HashMap<>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        qrObject.setMatrix(qrCodeWriter.encode(qrObject.getUrl(),
                BarcodeFormat.QR_CODE,
                500,
                500,
                hints));
    }

    public BufferedImage generateImage(QRObject qrObject) throws IOException
    {
        try
        {
            return ImageDrawer.getInstance().generate(qrObject.getMatrix());
        }
        catch(IOException e){
            throw new IOException("Cannot Generate QR Object");
        }
    }
}
