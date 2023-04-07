package PostFixPD;

public class PostfixTest {

	

	public static void main(String[] args) {
		LinkedStack<String> stack = new LinkedStack<>();
		String op="1 1 1 1 + - +";
		String [] operation=op.split("\\s");      
		System.out.print(evaluatePostfix(operation));
		}
	
		
		
	
	static int evaluatePostfix(String[] op)
    {
     LinkedStack<String> stack=new LinkedStack<String>();
        for(int i=0;i<op.length;i++)
        {
            String c=op[i];
            if(Character.isDigit(c.charAt(0)))
            stack.push(String.valueOf(c));
            else
            {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                switch(c) {
                 case "+":
                    stack.push(String.valueOf(b+a));
                    break;
                    case "-":
                    	 stack.push(String.valueOf(b-a));
                    break;
                    case "/":
                    	 stack.push(String.valueOf(b/a));
                    break;
                    case "*":
                    	 stack.push(String.valueOf(b*a));
                    break;}
            }
        }
        return Integer.valueOf(stack.pop());   
    }
		}
	

