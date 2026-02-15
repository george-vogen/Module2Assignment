package edu.wctc;

public class ExitRoom extends Room implements Exitable {
    private String exitMessage;

    public ExitRoom(String name, String exitMessage) {
        super(name);
        this.exitMessage = exitMessage;
    }

    @Override
    public String getDescription() {
        return "You see a sturdy door that looks like it leads out.\n" + exitMessage;
    }

    @Override
    public String exit(Player player) {
        return "You open the door and step outside. " + exitMessage;
    }
}
