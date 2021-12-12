import java.util.*;
public class yoda 
{
    public static void main(String [] args)
    {
        // driver for code
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a math equation: ");
        String equation = scan.nextLine();
        Yoda(equation);
        
        
    }// end main

    static int precidence(char c)
    {
        switch(c){
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;
        }
        return 0;
    } // end prec
    
    public static void Yoda(String input)
    {
        ArrayList<String> output = new ArrayList<String>();
        Stack<Character> stack = new Stack<Character>();
        input.replaceAll(" ","");
        
        for(int i = 0; i < input.length(); i++)  // interate through input equation
        { 
            char c = input.charAt(i); // set c to the char at i
            
            String num = "";

            if(c >= '0' && c <= '9') // check if c is a number 
            { 
                 num = c+""; // create full number 

                while(Character.isDigit(c)) // loops until a non digit occurs
                { 
                    num += input.charAt(i); // builds full number
                }

                i--; // avoid skipping operator
                output.add(num); // add num to output AL
                
            }
            else if(c == '('){
                stack.push(c);
            }
            else if(c == ')'){
                while(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else { // operators + - * /
                while(!stack.isEmpty() && stack.peek() != '(' && stack.peek() != ')' && precidence(c) <= precidence(stack.peek())) {
                    output.add(stack.pop() + "");
                }
                stack.push(c);
            }

        }// end for loop
    } // end Yoda method

} // end class
