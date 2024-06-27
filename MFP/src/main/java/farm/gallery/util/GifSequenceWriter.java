package farm.gallery.util;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.IOException;

public class GifSequenceWriter {
    protected ImageWriter gifWriter;
    protected ImageWriteParam imageWriteParam;
    protected IIOMetadata imageMetaData;

    public GifSequenceWriter(ImageOutputStream outputStream, int imageType, int timeBetweenFramesMS, boolean loopContinuously) throws IOException {
        gifWriter = ImageIO.getImageWritersBySuffix("gif").next();
        imageWriteParam = gifWriter.getDefaultWriteParam();

        IIOMetadataNode root = new IIOMetadataNode("javax_imageio_gif_image_1.0");
        IIOMetadataNode graphicControlExtensionNode = new IIOMetadataNode("GraphicControlExtension");

        graphicControlExtensionNode.setAttribute("disposalMethod", "none");
        graphicControlExtensionNode.setAttribute("userInputFlag", "FALSE");
        graphicControlExtensionNode.setAttribute("transparentColorFlag", "FALSE");
        graphicControlExtensionNode.setAttribute("delayTime", Integer.toString(timeBetweenFramesMS / 10));
        graphicControlExtensionNode.setAttribute("transparentColorIndex", "0");

        IIOMetadataNode applicationExtensionsNode = new IIOMetadataNode("ApplicationExtensions");
        IIOMetadataNode applicationExtensionNode = new IIOMetadataNode("ApplicationExtension");

        applicationExtensionNode.setAttribute("applicationID", "NETSCAPE");
        applicationExtensionNode.setAttribute("authenticationCode", "2.0");

        byte[] loop = new byte[]{0x1, (byte) (loopContinuously ? 0 : 1)};
        applicationExtensionNode.setUserObject(loop);
        applicationExtensionsNode.appendChild(applicationExtensionNode);

        root.appendChild(graphicControlExtensionNode);
        root.appendChild(applicationExtensionsNode);

        imageMetaData = gifWriter.getDefaultImageMetadata(new javax.imageio.ImageTypeSpecifier(new BufferedImage(1, 1, imageType)), imageWriteParam);
        imageMetaData.mergeTree("javax_imageio_gif_image_1.0", root);

        gifWriter.setOutput(outputStream);
        gifWriter.prepareWriteSequence(null);
    }

    public void writeToSequence(RenderedImage img) throws IOException {
        gifWriter.writeToSequence(new IIOImage(img, null, imageMetaData), imageWriteParam);
    }

    public void close() throws IOException {
        gifWriter.endWriteSequence();
    }
}
