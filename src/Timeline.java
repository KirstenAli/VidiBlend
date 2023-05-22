import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Timeline {
    private final List<Clip> timeline;
    private final Map<Integer, Frame> frameMap = new HashMap<>();

    public Timeline(List<Clip> timeline) {
        this.timeline = timeline;
        buildFrameMap();
    }

    public void split(int frameId, int index, int framePos){

        var clip = getClip(frameId);
        clip = clip.split(framePos);

        if(index >= timeline.size())
            timeline.add(index, clip);

        else
            timeline.add(index+1, clip);
    }

    public void moveClip(int frameId, int indexTo, int indexFrom){
        var clip = getClip(frameId);

        timeline.remove(indexFrom);
        timeline.add(indexTo, clip);
    }

    public void transition(Clip clip1,
                           Clip clip2,
                           int duration,
                           TransitionOption option){

    }

    public void playFromFrame(int frameId, int framePos, int index){
        var clip = getClip(frameId);

        clip.playFrom(framePos);

        index++;
        for(int i = index; i<timeline.size(); i++){
            clip = timeline.get(i);
            clip.play();
        }
    }

    public void playFromStart(){
        for(Clip clip: timeline)
            clip.play();
    }
    
    public void pause(){
        // TODO
    }

    public void resume(){
        // TODO
    }

    public Clip getClip(int frameId){
        var frame = frameMap.get(frameId);
        return frame.getClip();
    }

    private void buildFrameMap(){
        for(Clip clip: timeline){

            var frames = clip.getFrames();

            for (Frame frame: frames){
                frameMap.put(frame.getId(), frame);
            }
        }

    }

}
