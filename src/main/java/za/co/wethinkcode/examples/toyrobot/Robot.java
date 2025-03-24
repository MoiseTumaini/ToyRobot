package za.co.wethinkcode.examples.toyrobot;

import java.util.List;

public class Robot {
    private static final List<String> VALID_COMMANDS = List.of("off", "help", "forward");

    private static int MIN_Y = -200, MAX_Y = 200;
    private static int MIN_X = -100, MAX_X = 100;

    private static final Position CENTRE = new Position(0,0)

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

    public int getPositionX() {
        return this.position.getX();
    }

    public int getPositionY() {
        return this.position.getY();
    }

    public String getCurrentDirection() {
        return this.currentDirection;
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


    private boolean isPositionAllowed(int newX, int newY){
        return MIN_X <= newX && newX <= MAX_X
                && MIN_Y <= newY && newY <= MAX_Y;
    }

    private boolean updatePosition(int nrSteps){
        int newY = this.position.getY();
        int newX = this.position.getX();

        if ("NORTH".equals(currentDirection)) {
            newY = newY + nrSteps;
        }

        if (isPositionAllowed(newX, newY)){
            this.position = new Position(newX, newY);
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
