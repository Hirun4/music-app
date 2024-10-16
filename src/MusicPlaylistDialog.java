import javax.swing.JDialog;

public class MusicPlaylistDialog extends JDialog{
    private MusicPlayerGUI musicPlayerGUI;

    public MusicPlaylistDialog(MusicPlayerGUI musicPlayerGUI){
        this.musicPlayerGUI = musicPlayerGUI;
        
        setTitle("Create Playlist");
        setSize(400,400);
        setResizable(false);
        getContentPane().setBackground(MusicPlayerGUI.FRAME_COLOR);
        setLayout(null);
        setModal(true);
        setLocationRelativeTo(musicPlayerGUI);
    }

}
