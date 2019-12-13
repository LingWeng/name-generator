package nexiosit.com.name_generator.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class ImageGenerator {
    private final Random rnd;

    public String generateImage(String img) {
        byte[] decodedBytes = Base64.getDecoder().decode(img);
        ByteArrayInputStream bis = new ByteArrayInputStream(decodedBytes);

        BufferedImage image = null;
        try {
            image = ImageIO.read(bis);
            String path = "";
            switch (rnd.nextInt(6)) {
                case 0:
                    path = "classpath:img/blue_lightsaber.png";
                    break;
                case 1:
                    path = "classpath:img/green_lightsaber.png";
                    break;
                case 2:
                    path = "classpath:img/red_lightsaber.png";
                    break;
                case 3:
                    path = "classpath:img/purple_lightsaber.png";
                    break;
                case 4:
                    path = "classpath:img/yellow_lightsaber.png";
                    break;
                case 5:
                    path = "classpath:img/white_lightsaber.png";
                    break;
            }

            File file = ResourceUtils.getFile(path);
            BufferedImage overlay = ImageIO.read(file);

            int w = image.getWidth();
            int h = image.getHeight();
            BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

            Graphics g = combined.getGraphics();
            g.drawImage(image, 0, 0, null);
            g.drawImage(overlay, 0, 0, null);

            final ByteArrayOutputStream os = new ByteArrayOutputStream();

            ImageIO.write(combined, "PNG", os);
            return Base64.getEncoder().encodeToString(os.toByteArray());


        } catch (IOException e) {
            e.printStackTrace();
        }

        return img;
    }
}
