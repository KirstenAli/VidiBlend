import java.util.List;

public class Clip {
    private final List<Frame> frames;

    public Clip(List<Frame> clip) {
        this.frames = clip;
    }

    public Clip split(int framePos){
        var newClip = frames.subList(framePos, frames.size());
        frames.removeAll(newClip);

        return new Clip(newClip);
    }

    public void play(){
        //TODO
    }

    public void playFrom(int framePos){

    }

    public List<Frame> getFrames() {
        return frames;
    }
}
