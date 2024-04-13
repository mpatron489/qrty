package com.QRTY.application.api.controller;

import com.QRTY.application.service.QRService;
import com.QRTY.application.service.SVGDrawingService;
import com.google.zxing.WriterException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/getQRCode")
public class QRObjectController
{

    @GetMapping()
    public ResponseEntity<byte[]> getQRObject (@RequestParam("imageType") String imageType,
                                               @RequestParam("url") String url)
    throws WriterException
    {
        try
        {
            QRService qrService = new QRService();
            SVGDrawingService SVGService = new SVGDrawingService();

            final String outputSVG = SVGService
                    .generateSVGFromBitMatrix(qrService
                            .generateQRCode(imageType, url)
                            .getMatrix())
                    .getSVGElement();

            HttpHeaders header = new HttpHeaders();
            header.add("Content-Type", "image/svg+xml");
            return ResponseEntity.ok()
                    .headers(header)
                    .body(outputSVG.getBytes());
        }
        catch(WriterException e){
            return ResponseEntity
                    .badRequest()
                    .body("Unable to Generate QR Code.".getBytes());
        }
    }
}

