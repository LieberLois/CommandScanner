public class ScanException extends RuntimeException{
    ScanException(String message){
        super(message);
    }

    ScanException(){
        super();
    }

    @Override
    public String toString() {
        return super.getMessage();
    }
}
