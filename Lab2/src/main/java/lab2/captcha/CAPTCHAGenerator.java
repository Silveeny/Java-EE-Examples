package lab2.captcha;

import lab2.captcha.beans.CAPTCHA;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class CAPTCHAGenerator {

    private static final String DEFAULT_CAPTCHA_LOCATION

                = "D:\\11 - Syncthing\\Java Tehnologies\\Lab2\\src\\main\\resources\\captchas";
    private static final String DEFAULT_CAPTCHA_FORMAT = ".png";
    private static final int CAPTCHA_LENGTH = 10;
    private static final char[] SYMBOL_TABLE = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'p', 'q', 'r', 's', 'u', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'P', 'Q', 'R', 'S', 'U', 'W', 'X', 'Y', 'Z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
    };

    public static CAPTCHA generateCAPTCHA() throws IOException {
        String captchaText = generateRandomCAPTCHAString();
        BufferedImage captchaBI = createImageWithText(captchaText);
        String path = writeCAPTCHAOnDisk(captchaBI, captchaText);
        path = "images/captchas/" + captchaText + ".png";
        CAPTCHA captcha = new CAPTCHA(path, captchaText);

        return captcha;
    }

    private static String writeCAPTCHAOnDisk(BufferedImage captchaBI, String captchaText) throws IOException {
        String path = DEFAULT_CAPTCHA_LOCATION + "/" + captchaText + DEFAULT_CAPTCHA_FORMAT;
        File captchaOnDisk = new File(path);
        ImageIO.write(captchaBI, "png", captchaOnDisk);
        return path;
    }

    private static BufferedImage createImageWithText(String text) {
        BufferedImage bufferedImage = new BufferedImage(100, 30, BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.getGraphics();
        g.drawString(text, 20, 20);
        return bufferedImage;
    }

    private static String generateRandomCAPTCHAString() {
        Random rand = new Random();
        String captchaText = "";
        for (int i = 0; i < CAPTCHA_LENGTH; ++i) {
            int symbolIndex = rand.nextInt(SYMBOL_TABLE.length) + 0;
            captchaText += SYMBOL_TABLE[symbolIndex];
        }

        return captchaText;
    }

}