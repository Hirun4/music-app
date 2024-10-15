import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

public class MusicPlayer extends PlaybackListener{
private Song currentSong;

private AdvancedPlayer advancedPlayer;

private boolean isPaused;
private int currentFrame;

public MusicPlayer(){

}
public void loadSong(Song song){
    currentSong = song;

    if(currentSong != null){
        PlayCurrentSong();
    }
}

public void pauseSong(){
    if(advancedPlayer != null){
        isPaused = true;

        stopSong();
    }
}

public void stopSong(){
    if(advancedPlayer != null){
        advancedPlayer.stop();
        advancedPlayer.close();
        advancedPlayer= null;

    }
}
public void PlayCurrentSong(){
    if (currentSong == null) return;
        
    
    try{
        //read mp3 audio data
        FileInputStream fileInputStream = new FileInputStream(currentSong.getFilePath());
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        advancedPlayer = new AdvancedPlayer(bufferedInputStream);
        advancedPlayer.setPlayBackListener(this);
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
                if(isPaused){
                    advancedPlayer.play(currentFrame,Integer.MAX_VALUE);

                }else{
                    advancedPlayer.play();

                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }).start();
}

@Override
public void playbackStarted(PlaybackEvent evt) {
    System.out.println("playback started");
   
}
@Override
public void playbackFinished(PlaybackEvent evt) {
    System.out.println("playback finished");
    if(isPaused){
        currentFrame += (int) ((double) evt.getFrame() * currentSong.getFrameRatePerMilliseconds());
        
    }
    
}


}
