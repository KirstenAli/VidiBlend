import java.util.List;

public class Clip {
    private final List<Frame> frames;

    public Clip(List<Frame> frames) {
        this.frames = frames;
    }

    public Clip split(int framePos){
        var frameSubList = frames.subList(framePos, frames.size());
        frames.removeAll(frameSubList);

        var clip = new Clip(frameSubList);
        
        return reassignClips(clip);
    }

    private Clip reassignClips(Clip clip){
        clip.getFrames().forEach(frame -> frame.setClip(clip));
        return clip;
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
