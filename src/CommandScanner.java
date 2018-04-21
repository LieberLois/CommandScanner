import java.io.BufferedReader;
import java.io.IOException;

public class CommandScanner {

    private CommandTypeInfo[] commandTypeInfos;
    BufferedReader inputReader;

    public CommandScanner(CommandTypeInfo[] commandTypeInfos, BufferedReader inputReader) {
        this.commandTypeInfos = commandTypeInfos;
        this.inputReader = inputReader;
    }

    public Command next() throws ScanException{
        System.out.println("Enter a Command!");
        String command = readLine();

        if(command == null)
            return null;

        String[] splitCommand = command.split(" ");
        String commandName = splitCommand[0].toLowerCase();


        switch(commandName){
            case "help":
                return new Command(MyFavoriteCommandTypes.HELP, null);
            case "exit":
                return new Command(MyFavoriteCommandTypes.EXIT, null);
            case "addi":
                try {
                    int intValue1 = Integer.parseInt(splitCommand[1]);
                    int intValue2 = Integer.parseInt(splitCommand[2]);
                    return new Command(MyFavoriteCommandTypes.ADDI, new Object[]{intValue1, intValue2});
                } catch (NumberFormatException e) {
                    throw new ScanException("Wrong input, not an Integer value!");
                }

            case "addf":
                try {
                    float floatValue1 = Float.parseFloat(splitCommand[1]);
                    float floatValue2 = Float.parseFloat(splitCommand[2]);
                    return new Command(MyFavoriteCommandTypes.ADDF, new Object[]{floatValue1, floatValue2});
                } catch (NumberFormatException e) {
                    throw new ScanException("Wrong input, not a numeric value!");
                }

            case "echo":
                return new Command(MyFavoriteCommandTypes.ECHO, null);
            default:
                throw new ScanException("Unknown Command!");
        }
    }

    private String readLine(){
        try {
            return inputReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
