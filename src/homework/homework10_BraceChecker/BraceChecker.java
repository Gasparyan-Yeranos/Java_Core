package homework.homework10_BraceChecker;

public class BraceChecker {
    private String text;
    public BraceChecker(String text){
        this.text = text;
    }

    public void check(){
        Stack list = new Stack();
        for (int i = 0; i < text.length(); i++) {
            if ( text.charAt(i) == '(' ) {
                list.push(')');
            } else if ( text.charAt(i) == '[' ) {
                list.push(']');
            } else if ( text.charAt(i) == '{' ) {
                list.push('}');
            }
            if ( text.charAt(i) == ')' || text.charAt(i) == ']' || text.charAt(i) == '}' ){
                if (list.getLastElement() == '-'){
                    System.err.print( "Error: " );
                    System.err.println( "Brace \"" + text.charAt(i) + "\" closed without being opened at " + i );
                    return;
                }
                if(list.getLastElement() == text.charAt(i)){
                    list.pop();
                }else{
                    System.err.print( "Error: " );
                    System.err.println( "Closed " + text.charAt(i) + " instead of " + (char) list.getLastElement() + " at " + i );
                    return;
                }
            }
        }
        if (list.getLastElement() != '-'){
            System.err.print( "Error: " );
            System.err.println("Missing " + (char) list.getLastElement());
        }else{
            System.out.println("No incorrect braces have been found");
        }
    }
}
