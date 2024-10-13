import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

public class musicplayergui extends JFrame {
    public musicplayergui() {
        // Call the JFrame constructor and set the window title
        super("Music Player");

        // Set the size of the window
        setSize(600, 600);

        // Specify the operation when the window is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Center the window on the screen
        setLocationRelativeTo(null);

        // Prevent the window from being resized
        setResizable(false);

        // Set the layout to null to allow absolute positioning
        setLayout(null);

        addGuiComponents();
    }

    private void addGuiComponents() {
        addToolbar();

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
