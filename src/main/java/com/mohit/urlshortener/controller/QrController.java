package com.mohit.urlshortener.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;

@RestController
public class QrController {

    @GetMapping(value = "/qr", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> generateQr(
            @RequestParam String url) throws Exception {

        QRCodeWriter qrCodeWriter =
                new QRCodeWriter();

        BitMatrix bitMatrix =
                qrCodeWriter.encode(
                        url,
                        BarcodeFormat.QR_CODE,
                        250,
                        250);

        BufferedImage image =
                new BufferedImage(
                        250,
                        250,
                        BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < 250; x++) {
            for (int y = 0; y < 250; y++) {

                image.setRGB(
                        x,
                        y,
                        bitMatrix.get(x, y)
                                ? 0x000000
                                : 0xFFFFFF);
            }
        }

        ByteArrayOutputStream baos =
                new ByteArrayOutputStream();

        ImageIO.write(image, "PNG", baos);

        return ResponseEntity.ok(
                baos.toByteArray());
    }
}