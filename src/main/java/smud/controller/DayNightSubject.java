package smud.controller;

public interface DayNightSubject {
    public void register(DayNightObserver observer);
    public void deregitser(DayNightObserver observer);
    public void updateTime();
}
