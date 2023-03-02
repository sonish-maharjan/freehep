package v1;

import java.awt.Dimension;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.freehep.graphics2d.VectorGraphics;
import org.freehep.graphicsio.emf.EMFInputStream;
import org.freehep.graphicsio.emf.EMFPanel;
import org.freehep.graphicsio.emf.EMFRenderer;
import org.freehep.graphicsio.svg.SVGGraphics2D;
import org.w3c.dom.Document;

public class Main {
    public static void main(String[] args) throws IOException {


        // Path emfPath = Paths.get("v1/EMF.emf");


        // byte[] emfBytes =  Files.readAllBytes(emfPath);

        // String path =  "v1/" + "generated-emf5-picture.emf";

        String path =  "v1/" + "b_39.emf";


        Path emfFilePath = Path.of(path);
byte[] emfBytes = Files.readAllBytes(emfFilePath);  


        EMFRenderer emfRenderer = new EMFRenderer( new EMFInputStream(
            new ByteArrayInputStream(emfBytes)));
    
        EMFPanel emfPanel = new EMFPanel();
        emfPanel.setRenderer(emfRenderer);
    
        // prepare Graphics2D
        FileOutputStream svg = new FileOutputStream("svg.svg");
        SVGGraphics2D graphics2D = new SVGGraphics2D (svg, emfPanel);
    
        // export to SVG
        graphics2D.startExport();
        emfPanel.print(graphics2D);
        graphics2D.endExport();
        svg.flush();
        svg.close();
        


    

        //  // Load EMF file
        //  File inputFile = new File("input.emf");
        //  InputStream is = new FileInputStream(inputFile);
        //  EMFInputStream emfStream = new EMFInputStream(is, EMFInputStream.DEFAULT_VERSION);
         
        //  // Create vector graphics
        //  BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        //  VectorGraphics graphics = VectorGraphics.create(image.createGraphics());
         
        //  // Set image bounds
        //  Rectangle2D bounds = emfStream.readHeader().getBounds();
        //  graphics.setClip(new Rectangle2D.Double(0, 0, bounds.getWidth(), bounds.getHeight()));
        //  graphics.setTransform(((Object) graphics).getTranslateInstance(-bounds.getX(), -bounds.getY()));
         
        //  // Draw EMF image
        //  ((Object) graphics).readEMF(emfStream);
        //  graphics.dispose();
         
        //  // Write image as SVG
        //  File outputFile = new File("output.svg");
        //  FileOutputStream os = new FileOutputStream(outputFile);
        //  SVGGraphics2D svgGraphics = new SVGGraphics2D(os, new Dimension(image.getWidth(), image.getHeight()));
        //  ((Object) svgGraphics).setSVGCanvasSize(new Dimension(image.getWidth(), image.getHeight()));
        //  svgGraphics.setClip(new Rectangle2D.Double(0, 0, bounds.getWidth(), bounds.getHeight()));
        //  svgGraphics.drawImage(image, null, null);
        //  ((Object) svgGraphics).stream(new StreamResult(os), true);
        //  os.close();


//         // read the EMF file
// EMFRenderer emfRenderer = new EMFRenderer(
//     new EMFInputStream(
//     emf,
//     new ExtendedEMFTagSet(EMFInputStream.DEFAULT_VERSION)));
    
//     EMFPanel emfPanel = new EMFPanel();
//     emfPanel.setRenderer(emfRenderer);
    
//     // create SVG properties
//     Properties p = new Properties();
//     p.put(SVGGraphics2D.EMBED_FONTS, Boolean.toString(false));
//     p.put(SVGGraphics2D.CLIP, Boolean.toString(false));
//     p.put(SVGGraphics2D.COMPRESS, Boolean.toString(false));
//     p.put(SVGGraphics2D.TEXT_AS_SHAPES, Boolean.toString(false));
//     p.put(SVGGraphics2D.STYLABLE, Boolean.toString(false));
    
//     // prepare Graphics2D
//     SVGGraphics2D graphics2D = new PatchedSVGGraphics2D(svg, emfPanel);
//     graphics2D.setCreator(getClass().getSimpleName());
//     graphics2D.setProperties(p);
//     graphics2D.setDeviceIndependent(true);
    
//     // export to SVG
//     graphics2D.startExport();
//     emfPanel.print(graphics2D);
//     graphics2D.endExport();
//     svg.flush();


     }




}