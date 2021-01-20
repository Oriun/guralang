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
                    if (    line.charAt(i) != 'a' &&
                            line.charAt(i) != 'A' &&
                            line.charAt(i) != 'â' &&
                            line.charAt(i) != 'Â' &&
                            line.charAt(i) != 'ä' &&
                            line.charAt(i) != 'Ä' &&
                            line.charAt(i) != 'à' &&
                            line.charAt(i) != 'À' &&
                            line.charAt(i) != 'á' &&
                            line.charAt(i) != '@' &&
                            line.charAt(i) != 'Á' &&
                            line.charAt(i) != 'å' &&
                            line.charAt(i) != 'Å' &&
                            line.charAt(i) != 'ã' &&
                            line.charAt(i) != 'Ã' &&
                            line.charAt(i) != 'æ' &&
                            line.charAt(i) != 'Æ'
                    ){
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
                    case 0:
                        break;
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
                    case 8:
                        a = Integer.parseInt(stack.pop().toString());
                        if((boolean) stack.pop()){
                            for (int j = 0; j < a; j++){
                                sc.next();
                            }
                        }
                        break;
                    case 9:
                        a = Integer.parseInt(stack.pop().toString());
                        stack.push((char)a);
                        break;
                    default:
                        stack.push(aCount-10);
                        break;

                }
            }
            readStack();
        } catch (Exception e)
        {
            System.out.println(e);
        }

    }
    public static void readStack(){
        while(!stack.isEmpty()){
            System.out.println(stack.pop().toString());
        }
    }
}