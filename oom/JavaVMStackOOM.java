/**
 * VM Args: -Xss10m 该参数代表为每个线程分配的栈内存大小 代码执行前保存当前工作，可能会造成系统假死
 */
public class JavaVMStackOOM {
    private void dontStop() {
        try {
            Thread.sleep(3600000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stackLeakByThread() {
        int i = 0;
        while (true) {
            System.out.println("Thread : " + i++);
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}