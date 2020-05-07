package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

import java.lang.IllegalArgumentException;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes type) throws IllegalArgumentException {

        if (type==ImageTypes.BMP){
            return new BmpReader();
        }
        if (type==ImageTypes.PNG){
            return new PngReader();
        }
        if (type==ImageTypes.JPG){
            return new JpgReader();
        }
        throw new IllegalArgumentException("Неизвестный тип картинки");

    }
}
