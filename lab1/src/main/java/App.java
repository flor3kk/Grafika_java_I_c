import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class App {
    public static void main(String args[]) throws IOException {
        BufferedImage img = null;
        File f = null;
// wczytaj obraz
        try {
            f = new File("img\\fura.png");
            img = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println(e);
        }
// pobieramy szerokość i wysokość obrazów
        int width = img.getWidth();
        int height = img.getHeight();
        // pobieramy środkowy piksel
        int p = img.getRGB(width / 2, height / 2);
// Odczytujemy wartosci kanalow przesuwajac o odpowiednia liczbe bitow w prawo, tak aby
// kanal znalazł się na bitach 7-0, następnie zerujemy pozostałe bity używając bitowego AND z maską 0xFF.

        int a = (p >> 24) & 0xff;
        int r = (p >> 16) & 0xff;
        int g = (p >> 8) & 0xff;
        int b = p & 0xff;

// Ustawiamy wartosci poszczegolnych kanalow na przykładowe liczby


        a = 255;
        r = 100;
        g = 150;
        b = 200;

// TODO: ustaw ponownie wartości kanałów dla zmiennej p

        img.setRGB(width / 2, height / 2, p);

// zapis obrazu
        try {
            //allWhite(img);
            //imgNegative(img);
            //imgAllWhiteColor(img);
            //imgNegativeColor(img);
            f = new File("img\\negatywColor.png");
            ImageIO.write(img, "png", f);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void allWhite(BufferedImage img) {

        int width = img.getWidth();
        int height = img.getHeight();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                int a = 255;
                int r = 255;
                int g = 255;
                int b = 255;

                int newPixel = (a << 24) | (r << 16) | (g << 8) | b;
                img.setRGB(i, j, newPixel);
            }
        }

    }

    public static void imgNegative(BufferedImage img) {

        int width = img.getWidth();
        int height = img.getHeight();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int p = img.getRGB(j, i);

                int a = (p>>24) & 0xff;
                int r = (p>>16) & 0xff;
                int g = (p>>8) & 0xff;
                int b = p & 0xff;

                r = 255 - r;
                g = 255 - g;
                b = 255 - b;

                p = (a << 24) | (r << 16) | (g << 8) | b;
                img.setRGB(j, i, p);
            }
        }
    }

    public static void imgAllWhiteColor(BufferedImage img) {

        int width = img.getWidth();
        int height = img.getHeight();

        // Iteruj po każdym pikselu i ustaw go na biały
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                img.setRGB(x, y, Color.WHITE.getRGB());
            }
        }
    }

    public static void imgNegativeColor(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = image.getRGB(x, y);

                Color color = new Color(p);

                int red = 255 - color.getRed();
                int green = 255 - color.getGreen();
                int blue = 255 - color.getBlue();

                Color kolorek = new Color(red, green, blue);

                image.setRGB(x, y, kolorek.getRGB());
            }
        }
    }
}