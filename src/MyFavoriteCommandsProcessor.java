import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class MyFavoriteCommandsProcessor {
    static PrintStream outputStream = System.out;
    static BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

    public static void process(){
        CommandScanner commandScanner = new CommandScanner(MyFavoriteCommandTypes.values(), inputReader);
        Command command;

        while (true) {

            try {
                command = commandScanner.next();
            } catch (ScanException e) {
                outputStream.println(e);
                continue;
            }


            MyFavoriteCommandTypes commandType = (MyFavoriteCommandTypes) command.getCommandType();

            switch(commandType){
                case HELP:
                    outputStream.println("Help");
                    break;
                case EXIT:
                    outputStream.println("Exit");
                    break;
                case ADDF:
                    outputStream.println("Addf");
                    break;
                case ADDI:
                    outputStream.println("Addi");
                    break;
                case ECHO:
                    outputStream.println("Echo");
                    break;
                default: break;
            }
        }

    }

    public static void main(String[] args) {
        process();
    }


}
