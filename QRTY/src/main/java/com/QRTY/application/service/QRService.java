package com.QRTY.application.service;

import com.QRTY.application.persistence.entity.QRObject;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.util.HashMap;
import java.util.Map;

public class QRService
{
    public QRService(){
    }
    public QRObject generateQRCode(String imageType, String url) throws WriterException
    {
        QRObject QRCode = new QRObject(imageType);
        QRCodeWriter qrCodeWriter= new QRCodeWriter();
        Map<EncodeHintType, ErrorCorrectionLevel> hints = new HashMap<>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        QRCode.setMatrix(qrCodeWriter.encode(url,
                BarcodeFormat.QR_CODE,
                500,
                500,
                hints));
        return QRCode;
    }
}
