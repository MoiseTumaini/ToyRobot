package za.co.wethinkcode.examples.toyrobot;

import java.awt.*;
import java.util.List;

public class Robot {
    private static final List<String> VALID_COMMANDS = List.of("off", "help", "forward");

    private final Position TOP_LEFT = new Position(-100,100);
    private final Position BOTTOM_RIGHT = new Position(100,-200);

    public static final Position CENTRE = new Position(0,0);


    private Position position;
    private String currentDirection;
    private String status;
    private String name;

    public Robot(String name) {
        this.name = name;
        this.status = "Ready";
        this.position = CENTRE;
        this.currentDirection = "NORTH";
    }

    public String getStatus() {
        return this.status;
    }

    public Position getPosition(){
        return this.position;
    }

    public String getCurrentDirection() {
        return this.currentDirection;
    }

    public void turnTo(Direction newdirection){
        this.currentDirection = String.valueOf(newdirection);
    }
    public boolean isValidCommand(String commandInput){
        String[] args = commandInput.strip().split(" ");
        String command = args[0].trim().toLowerCase();
        return VALID_COMMANDS.contains(command);
    }

    public boolean handleCommand(String commandInput){
        if (!isValidCommand(commandInput)) {
            status = "I am not programmed to: " + commandInput;
            return false;
        }

        String[] args = commandInput.strip().split(" ");
        String command = args[0].trim().toLowerCase();

        switch (command){
            case "off":
                status = "Shutting down";
                break;
            case "help":
                status = doHelp();
                break;
            case "forward":
                status = doForward(Integer.parseInt(args[1]));
                break;
            default:
                status = "I am not programmed for: " + command;
        }
        return true;
    }

    private String doHelp() {
        return "I can understand these commands:\n" +
                "OFF  - Shut down robot\n" +
                "HELP - provide information about commands\n" +
                "FORWARD - move forward by specified number of steps, e.g. 'FORWARD 10'";
    }

    private boolean updatePosition(int nrSteps){
        int newY = this.position.getY();
        int newX = this.position.getX();

        if ("NORTH".equals(currentDirection)) {
            newY = newY + nrSteps;
        }

        Position newPosition = new Position(newX,newY);

        if (newPosition.isIn(TOP_LEFT,BOTTOM_RIGHT)){
            this.position = newPosition;
            return true;
        }
        return false;
    }

    private String doForward(int nrSteps){
        if (updatePosition(nrSteps)){
            return "Moved forward by "+nrSteps+" steps.";
        } else {
            return "Sorry, I cannot go outside my safe zone.";
        }
    }

    @Override
    public String toString() {
        return "[" + this.position.getX() + "," + this.position.getY() + "] "
                + "{" + this.currentDirection + "} "
                + this.name + "> " + this.status;
    }
}
