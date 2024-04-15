package com.QRTY.application.api.controller;

import com.QRTY.application.persistence.ImageType;
import com.QRTY.application.persistence.entity.QRObject;
import com.QRTY.application.service.QRService;
import com.google.zxing.WriterException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/getQRCode")
public class QRObjectController
{

    @GetMapping()
    public ResponseEntity<byte[]> getQRObject(@RequestParam("imageType") String imageType,
                                              @RequestParam("url") String url)
            throws WriterException
    {
        try
        {
            QRObject qrObject = new QRObject(imageType);
            qrObject.setUrl(url);
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*"); //comment out in release version
            QRService.getInstance().generateQRCode(qrObject);

            if(qrObject.getImageType() == ImageType.SVG)
            {
                return ResponseEntity
                        .badRequest()
                        .headers(headers)
                        .body(null);
            }
            headers.add("Content-Type", "image/" + qrObject.getImageType().name().toLowerCase());
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            ImageIO.write(QRService.getInstance().generateImage(qrObject), qrObject.getImageType().name(), output);

            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .body(output.toByteArray());

        } catch(IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
