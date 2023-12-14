package smud.model.Environment;

import java.util.Collection;

public interface MapComponent {

    public Collection<MapComponent> getChildren();
    public void updateTime(boolean isDay);
    
}
