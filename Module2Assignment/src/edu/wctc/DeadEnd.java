package edu.wctc;

public class DeadEnd extends Room {

    public DeadEnd(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return "You have reached a dead end. There is no way forward from here. You can only go back.";
    }
}
