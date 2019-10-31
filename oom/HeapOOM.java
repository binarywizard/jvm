import java.util.ArrayList;
import java.util.List;

/**
 *  VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *  将堆的最小值与最大值设置为一样即可避免堆自动扩展
 */

 public class HeapOOM {
     static class OOMObject {}
     
     public static void main(String[] args) {
         List<OOMObject> list = new ArrayList<>();

         while(true) {
             list.add(new OOMObject());
         }
     }
 }