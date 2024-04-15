package com.QRTY.application.service;

import com.google.zxing.common.BitMatrix;

import java.awt.image.BufferedImage;
import java.io.IOException;

public interface Drawable
{
    BufferedImage generate(BitMatrix matrix) throws IOException;
}
