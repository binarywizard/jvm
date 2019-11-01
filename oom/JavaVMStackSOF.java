import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * VM Args: -Xss180k
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF sof = new JavaVMStackSOF();
        try {
            sof.stackLeak();
        } catch (Throwable t) {
            System.out.println("stack length:" + sof.stackLength + " " + t.getClass());
            throw t;
        }
    }
}