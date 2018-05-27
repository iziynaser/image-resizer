package com.byk.services;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class ImageStorageImpl implements ImageStorage {

    private String RESOURCE_LOCATION_ROOT = "classpath:images/";

    public File get(String name) throws FileNotFoundException {
        File file = ResourceUtils.getFile(RESOURCE_LOCATION_ROOT + name);
        return file;
    }

    public File save(BufferedImage bufferedImage, String fileName) throws IOException {
        File outputFile = new File(ResourceUtils.getFile(RESOURCE_LOCATION_ROOT).getAbsolutePath() + "/" + fileName);
        ImageIO.write(bufferedImage, "jpg", outputFile);
        return outputFile;
    }

}
