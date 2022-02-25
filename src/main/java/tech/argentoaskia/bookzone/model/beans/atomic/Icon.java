package tech.argentoaskia.bookzone.model.beans.atomic;

import org.springframework.util.ClassUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Icon implements Type<Image>, Serializable {


    private static final long serialVersionUID = 3669359192670864363L;

    private transient Image image;
    private File file;

    public String getImageURL() {
        return file.getPath();
    }

    public void setImage(String url) throws IOException {
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        System.out.println(path);
        final String staticFile = "static/";
        final String default_url = "img/icon/default.png";
        try {
            file = new File(path + staticFile + url);
            FileInputStream fileInputStream = new FileInputStream(file);
            image = ImageIO.read(fileInputStream);
        } catch (FileNotFoundException e) {
            // todo use default icon
            file = new File(path + staticFile +default_url);
            image = ImageIO.read(file);
        }
    }

    @Override
    public Image get() {
        return image;
    }
}
