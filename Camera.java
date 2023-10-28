import net.sourceforge.tess4j.TesseractException;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;
import net.sourceforge.tess4j.Tesseract;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class Camera extends JFrame{

    private JLabel camera_screen;
    private JButton camera_button;
    private VideoCapture capture;
    private Mat image;
    private Mat captured_image;
    private boolean clicked = false;
    private File image_file;
    Tesseract ts;
    private String text = "";
    private String textCallback = null;

    public Camera(){
        setLayout(null);
        camera_screen = new JLabel();
        camera_screen.setBounds(0,0,600,500);
        add(camera_screen);

        camera_button = new JButton("Leer");
        camera_button.setBounds(250, 520, 80, 30);
        add(camera_button);

        camera_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicked = true;
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                capture.release();
                image.release();
                System.exit(0);
            }
        });

        setSize(new Dimension(600,600));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public Mat get_captured_image(){
        return captured_image;
    }
    public void camera_start(){
        capture = new VideoCapture(0);
        image = new Mat();
        byte[] image_data;
        ImageIcon icon;

        while(true){
            capture.read(image);
            final MatOfByte buf = new MatOfByte();
            Imgcodecs.imencode(".jpg", image, buf);
            image_data = buf.toArray();
            icon = new ImageIcon(image_data);
            camera_screen.setIcon(icon);

            if(clicked){
                clicked = false;

                image_file = new File("temp_image.jpg");
                Imgcodecs.imwrite(image_file.getAbsolutePath(),image);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        processOCR();
                    }
                }).start();

            }

        }

    }

    public void processOCR(){
        ts = new Tesseract();
        ts.setDatapath("C:\\Users\\chris\\Desktop\\Tess4J\\tessdata");
        try{
            text = ts.doOCR(image_file);
            System.out.println(text);


            textCallback = text;
        } catch (TesseractException e){
            e.printStackTrace();
        }
    }

    public String getText(){
        return textCallback;
    }
    public static void main(String[] args){
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run(){
                Camera camera = new Camera();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        camera.camera_start();
                    }
                }).start();
            }
        });
    }

}