import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GenerateJPG {

    public static void generateJPG(
    		BingoPanel bp,
            String name,
            String path
    ) throws IOException {

        bp.doLayout();
        bp.validate();
        BufferedImage image = new BufferedImage(
                bp.getWidth(),
                bp.getHeight(),
                BufferedImage.TYPE_INT_RGB
        );
        Graphics2D g2d = image.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON );
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        bp.printAll(g2d);

        //System.out.println(IC);
        //System.out.println(image);
        //System.out.println(g2d);

        File file = new File(path + "\\" + name + ".jpg");

        JPEGImageWriteParam jpegParams = new JPEGImageWriteParam(null);
        jpegParams.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        jpegParams.setCompressionQuality(1f);

        final ImageWriter writer = ImageIO.getImageWritersByFormatName("jpg").next();
        writer.setOutput(new FileImageOutputStream(
                new File(path + "/" + name + ".jpg")));

        writer.write(null, new IIOImage(image, null, null), jpegParams);

    }

}