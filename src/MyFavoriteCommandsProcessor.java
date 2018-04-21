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
            Object[] params = command.getParams();

            switch(commandType){
                case EXIT:
                    System.exit(0);
                case HELP:
                    System.out.println(help());
                    break;
                case ADDI:
                    int totalInt = 0;
                    try {
                        for(int i = 0; i < command.getParams().length; i++) {
                            totalInt += Integer.parseInt((String) params[i]);
                        }
                        System.out.println(totalInt);
                    } catch (NumberFormatException e) {
                        outputStream.println(e);
                    }

                    break;
                case ADDF:
                    float totalFloat = 0.f;
                    try {
                        for(int i = 0; i < params.length; i++) {
                            totalFloat += Float.parseFloat((String) params[i]);
                        }
                        System.out.println(totalFloat);
                    } catch (NumberFormatException e) {
                        outputStream.println(e);
                    }
                    break;
                case ECHO:
                    for(int i = 0; i < Integer.parseInt((String) params[params.length - 1]); i++) {
                        for(int j = 0; j < params.length - 1; j++) {
                            System.out.print(params[j] + " ");
                        }
                        System.out.println("");
                    }
                    break;
                default:
                    break;

            }
        }

    }

    public static String help(){
        StringBuilder s = new StringBuilder("List of Commands: \n");

        for(CommandTypeInfo e : MyFavoriteCommandTypes.values()){
            s.append(e.toString());
        }
        return s.toString();
    }

    public static void main(String[] args) {
        process();
    }


}
