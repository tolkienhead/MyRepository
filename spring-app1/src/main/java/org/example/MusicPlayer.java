package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;
    private Music music;

    @Autowired
    public MusicPlayer(@Qualifier("classicalMusic") Music music) {
        this.music = music;
    }

    public void playMusic(){
        System.out.println("Playing " + music.getSong());
    }

    public void setMusic(ClassicalMusic classicalMusic) {
        this.music = classicalMusic;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }
}
