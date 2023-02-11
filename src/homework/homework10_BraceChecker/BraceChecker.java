package homework.homework10_BraceChecker;

public class BraceChecker {
    private String text;
    public BraceChecker(String text){
        this.text = text;
    }

    public void check(){
        boolean areErrors = false;
        Stack list = new Stack();
        char closed = '-';
        for (int i = 0; i < text.length(); i++) {
            switch ((text.charAt(i))) {
                case '(': closed = ')'; list.push(text.charAt(i)); break;
                case '[': closed = ']'; list.push(text.charAt(i)); break;
                case '{': closed = '}'; list.push(text.charAt(i)); break;

            }

            switch ((text.charAt(i))) {
                case ')':
                case ']':
                case '}':
                    if (list.getLastElement() == '-'){
                        System.err.print( "Error: " );
                        System.err.println( "at index " + i + " Closed " + text.charAt(i) + " but not opened" );
                        areErrors = true;
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
                        list.pop();
                        switch (list.getLastElement()) {
                            case '(': closed = ')'; break;
                            case '[': closed = ']'; break;
                            case '{': closed = '}'; break;
                        }
                        areErrors = true;
                    }
            }
        }
        if (list.getLastElement() != '-'){
            System.err.print( "Error: " );
            System.err.println("opened " + (char) list.getLastElement()  + " but not closed");
            areErrors = true;
        }else if(areErrors != true){
            System.out.println("No incorrect braces have been found");
        }
    }
}
