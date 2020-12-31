import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class interpretor {

    private static final String inputFilePath = "Interpreter/Java/file.txt";
    static Stack<Object> stack = new Stack<>();

    public static void main(String[] args) {
        // No error message available since "A"
        try {
            File file = new File(inputFilePath);
            Scanner sc = new Scanner(file);
            // Read the file and stop when the scanner goes to the end of the file
            while(sc.hasNext()){
                String line = sc.next();
                int aCount = 0;
                for (int i = 0; i < line.length(); i++){
                    if (line.charAt(i) != 'a' && line.charAt(i) != 'A'){
                        throw new Exception("A");
                    }
                    else {
                        aCount++;
                    }
                }
                // Execute the good instruction depending of the number of A
                // The instruction are written is the most easily readable format so they are not optimised!
                int a;
                int b;
                switch (aCount){
                    case 1:
                        stack.push("A");
                        break;
                    case 2:
                        a = Integer.parseInt(stack.pop().toString());
                        b = Integer.parseInt(stack.pop().toString());
                        stack.push(a + b);
                        break;
                    case 3:
                        a = Integer.parseInt(stack.pop().toString());
                        b = Integer.parseInt(stack.pop().toString());
                        stack.push(a - b);
                        break;
                    case 4:
                        a = Integer.parseInt(stack.pop().toString());
                        b = Integer.parseInt(stack.pop().toString());
                        stack.push(a * b);
                        break;
                    case 5:
                        a = Integer.parseInt(stack.pop().toString());
                        b = Integer.parseInt(stack.pop().toString());
                        stack.push(a == b);
                        break;
                    case 6:
                    case 7:
                        throw new Exception("A");
                        /*NOT IMPLEMENTED RIGHT NOW, WILL FINISH IT NEXT YEAR
                    case 8:
                        a = Integer.parseInt(stack.pop().toString());
                        if((boolean) stack.pop()){
                            for (int j = 0; j < a; j++){
                                sc.next();
                            }
                        }*/
                    default:
                        stack.push(aCount-10);
                        break;

                }
            }
            readStack();
        } catch (Exception e)
        {
            System.out.println("ERROR");
        }

    }
    public static void readStack(){
        while(!stack.isEmpty()){
            System.out.println(stack.pop().toString());
        }
    }
}