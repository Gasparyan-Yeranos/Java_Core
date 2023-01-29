package homework.homework10_BraceChecker;

public class BraceChecker {
    private String text;
    public BraceChecker(String text){
        this.text = text;
    }

    public void check(){
        Stack list = new Stack();
        char closed = '-';
        for (int i = 0; i < text.length(); i++) {
            switch (text.charAt(i)){
                case '(': {
                    list.push('(');
                    closed = ')';
                    break;
                }
                case '{': {
                    list.push('{');
                    closed = '}';
                    break;
                }
                case '[': {
                    list.push('[');
                    closed = ']';
                    break;
                }
            }
            if ( text.charAt(i) == ')' || text.charAt(i) == ']' || text.charAt(i) == '}' ){
                if (list.getLastElement() == '-'){
                    System.err.print( "Error: " );
                    System.err.println( "at index " + i + " Closed " + text.charAt(i) + " but not opened" );
                    return;
                }
                if(closed == text.charAt(i)){
                    list.pop();
                    switch (list.getLastElement()) {
                        case '(': closed = ')'; break;
                        case '[': closed = ']'; break;
                        case '{': closed = '}'; break;
                    }
                }else{
                    System.err.print( "Error: " );
                    System.err.println( "opened " + (char) list.getLastElement() + " but closed " + text.charAt(i) + " at index " + i );
                    return;
                }
            }
        }
        if (list.getLastElement() != '-'){
            System.err.print( "Error: " );
            System.err.println("opened " + (char) list.getLastElement()  + " but not closed");
        }else{
            System.out.println("No incorrect braces have been found");
        }
    }
}
