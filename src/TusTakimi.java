import java.util.Scanner;

public class TusTakimi implements ITusTakimi {

    private static TusTakimi instance;

    private TusTakimi(){

    }
    public static synchronized TusTakimi getInstance(){
        if (instance==null){
            instance = new TusTakimi();
        }
        return instance;
    }

    public String  veriAl(){
        Scanner veri = new Scanner(System.in);
        return veri.nextLine();
    }

}
