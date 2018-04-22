package CommandHandler;

import java.io.BufferedReader;
import java.io.IOException;

public class CommandScanner {

    private CommandTypeInfo[] commandTypeInfos;
    BufferedReader inputReader;

    public CommandScanner(CommandTypeInfo[] commandTypeInfos, BufferedReader inputReader) {
        this.commandTypeInfos = commandTypeInfos;
        this.inputReader = inputReader;
    }

    public Command next() throws ScanException {
        System.out.println("Enter a CommandHandler.Command!");
        String command = readLine();

        if (command == null)
            return null;

        String[] splitCommand = command.split(" ");
        String commandName = splitCommand[0].toLowerCase();

        for (CommandTypeInfo info : commandTypeInfos) {
            if(info.getName().toLowerCase().equals(commandName.toLowerCase())){
                if (splitCommand.length == 1) {
                    return new Command(info, null);
                } else {
                    Object[] args = new Object[splitCommand.length-1];
                    for(int i = 1; i < splitCommand.length; i++){
                        args[i-1] = splitCommand[i];
                    }

                    return new Command(info, args);
                }
            }

        }

        throw new ScanException("CommandHandler.Command not found!");
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
