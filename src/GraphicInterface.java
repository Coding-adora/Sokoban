import javax.swing.*;
import java.awt.*;

public class GraphicInterface implements Runnable{
    Game game;
    boolean fullScreen;
    JFrame frame;
    GraphicLevel gl;

    public GraphicInterface(Game g){
        game = g;
    }

    public static void start(Game g){
        SwingUtilities.invokeLater(new GraphicInterface(g));
    }

    public void run(){
        frame = new JFrame("Sokoban by Coding-adora");
        gl = new GraphicLevel(game);
        frame.add(gl);
        gl.addMouseListener(new MouseEvents(gl,game));
        frame.addKeyListener(new KeyboardEvents(this, game));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void toggleFullScreen(){
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = env.getDefaultScreenDevice();
        if(fullScreen){
            device.setFullScreenWindow(null);
            fullScreen = false;
        }else{
            device.setFullScreenWindow(frame);
            fullScreen = true;
        }
    }

    public void repaint(){
        gl.repaint();
    }
}
