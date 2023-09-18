import java.util.Arrays;

public class UserInput {
    private final String cmd;
    private final String input;
    public UserInput(String cmd, String input) {
        this.cmd = cmd;
        this.input = input;
    }

    public static UserInput parseInput(String in) {
        String[] splitter = in.split(" ");
        if (splitter.length == 1) {
            return new UserInput(splitter[0], null);
        } else return new UserInput(splitter[0],
                String.join(" ", Arrays.copyOfRange(splitter, 1, splitter.length)));
    }

    public String getCmd() {
        return cmd;
    }

    public String getInput() {
        return input;
    }
}
