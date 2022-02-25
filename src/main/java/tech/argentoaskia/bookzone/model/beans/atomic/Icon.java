package tech.argentoaskia.bookzone.model.beans.atomic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ClassUtils;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.*;

public class Icon implements Type<RenderedImage>, Serializable {


    private static final long serialVersionUID = 3669359192670864363L;
    private static final Logger logger = LoggerFactory.getLogger(Icon.class);

    public final String root = ClassUtils.getDefaultClassLoader().getResource("").getPath();
    public final String staticFolder = "static/";
    public final String default_url = "img/icon/随机用户.jpg";
    // 注意，这个对象无法序列化，因此无法存储在Session中
    private transient RenderedImage image;
    private File file;

    public String getImageURL() {
        System.out.println("root: " + root);
        return root + staticFolder + file.getPath();
    }

    public void setImage(String url) throws IOException {
        if (url == null || url.equals("")) {
            file = new File(default_url);
            return;
        }
        file = new File(url);
    }

    @Override
    public RenderedImage get() {
        File realFile = new File(root + staticFolder + file);
        try {
            image = ImageIO.read(realFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
