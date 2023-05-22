import java.util.List;

public class Clip {
    private final List<Frame> frames;

    public Clip(List<Frame> frames) {
        this.frames = frames;
        assignClipToFrames();
    }

    public Clip split(int framePos){
        var frameSubList = frames.subList(framePos, frames.size());
        frames.removeAll(frameSubList);

        return new Clip(frameSubList);
    }

    private void assignClipToFrames(){
        frames.forEach(frame -> frame.setClip(this));
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
