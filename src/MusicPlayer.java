import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.advanced.AdvancedPlayer;

public class MusicPlayer {
private Song currentSong;

private AdvancedPlayer advancedPlayer;

public MusicPlayer(){

}
public void loadSong(Song song){
    currentSong = song;

    if(currentSong != null){
        PlayCurrentSong();
    }
}
public void PlayCurrentSong(){
    try{
        //read mp3 audio data
        FileInputStream fileInputStream = new FileInputStream(currentSong.getFilePath());
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        advancedPlayer = new AdvancedPlayer(bufferedInputStream);
        startMusicThread();

    }catch(Exception e){
        e.printStackTrace();
    }
    
}
private void startMusicThread(){
    new Thread(new Runnable(){
        @Override
        public void run(){
            try{
                advancedPlayer.play();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }).start();
}
}
