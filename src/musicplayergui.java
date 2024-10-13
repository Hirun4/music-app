import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

public class musicplayergui extends JFrame {
    public static final Color FRAME_COLOR = Color.black;
    public static final Color TEXT_COLOR = Color.white;

    public musicplayergui() {
        // Call the JFrame constructor and set the window title
        super("Music Player");

        // Set the size of the window
        setSize(400, 600);

        // Specify the operation when the window is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Center the window on the screen
        setLocationRelativeTo(null);

        // Prevent the window from being resized
        setResizable(false);

        // Set the layout to null to allow absolute positioning
        setLayout(null);

        addGuiComponents();

        getContentPane().setBackground(FRAME_COLOR);
    }

    private void addGuiComponents() {
        addToolbar();



    }

    private ImageIcon loadImage(String imagePath){
        try{
            BufferedImage image =  ImageIO.read(new File(imagePath));
            return new ImageIcon(image);
        }catch(Exeption e){
            e.printStackTrace();

        }
    }


    private void addToolbar() {
        JToolBar toolBar = new JToolBar();
        toolBar.setBounds(0, 0, getWidth(), 20);
        toolBar.setFloatable(false);

        JMenuBar menuBar = new JMenuBar();
        toolBar.add(menuBar);
        JMenu songMenu = new JMenu("Song");
        menuBar.add(songMenu);

        JMenuItem loadsong = new JMenuItem("Load Song");
        songMenu.add(loadsong);

        JMenu playlistMenu = new JMenu("Playlist");
        menuBar.add(playlistMenu);

        JMenuItem createPlaylist = new JMenuItem("create playlist");
        playlistMenu.add(createPlaylist);

        JMenuItem loadPlaylist = new JMenuItem("Load Playlist");
        playlistMenu.add(loadPlaylist);
        add(toolBar);
    }
}
