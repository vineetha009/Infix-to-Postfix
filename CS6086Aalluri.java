import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Stack;


public class CS6086Aalluri {

	public static void main(String []args)throws FileNotFoundException
	{
		CS6086Aalluri ob=new CS6086Aalluri();
	System.out.println("Name:vineetha Alluri");
	System.out.println("course id:CS608");
	System.out.println(java.time.LocalDate.now());
	
	
	try {
	for(int p=0;p<5;p++)
	{
	String line = Files.readAllLines(Paths.get("infixData6A.txt")).get(p);
    System.out.println("Given infix expression:\n"+line);
    String rline=ob.Evaluate(line);
    System.out.println("Converted postfix expression:\n"+rline.trim());
    System.out.println("\t");
    System.out.println("\t");
	}
	}
    catch(Exception e)
    {
    	System.out.println("throws exp");
    }
	}
    
    String Evaluate(String line)
    {
    Stack<Character> s=new Stack<Character>();
    String Resultline= " ";
    for(int i=0;i<line.length();++i)
    {
    	char c=line.charAt(i);
    	
    	if(Character.isLetterOrDigit(c))
    	{
    		Resultline+=c;
    		
    	}
    	
    	else 
    		{
    		while(s.empty()==false && priority(c)>=priority(s.peek()))
    		{
    			Resultline +=s.pop();
    			}
    		s.push(c);
    		}
	
	} 	

while(s.empty()==false)
{
	Resultline+=s.pop();
}
return Resultline;

}

	
	
	
int priority(char ch)
{
	
	switch(ch) 
	{
	case '^':
		return 1;
	case '*':
	case '/':	
		return 2;
	case '+':
	case '-':
		return 3;
	}
	return 0;
}
}
	