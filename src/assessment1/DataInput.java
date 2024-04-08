package assessment1;

import java.util.Scanner;
/**
 * @author <Tran Kiem Phuc - s3927187>
 */
public class DataInput {
    private static DataInput input;
    private Scanner scanner;
    private DataInput(){scanner = new Scanner(System.in);}
    public static DataInput getDataInput() {
        if (input == null) {
            input = new DataInput();
        }
        return input;
    }

    public Scanner getScanner() {
        return scanner;
    }

}
