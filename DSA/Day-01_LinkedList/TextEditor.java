class TextState {
    String content;
    TextState prev, next;

    public TextState(String content) {
        this.content = content;
        this.prev = this.next = null;
    }
}

public class TextEditor {
    private TextState head = null;
    private TextState current = null;
    private int historySize = 0;
    private final int MAX_HISTORY = 10;

    public void addState(String content) {
        TextState newState = new TextState(content);

        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
        }

        if (head == null) {
            head = current = newState;
        } else {
            current.next = newState;
            newState.prev = current;
            current = newState;
        }
        historySize++;
        if (historySize > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            historySize--;
        }

        System.out.println("State added: \"" + content + "\"");
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo performed.");
        } else {
            System.out.println("No more undo available.");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo performed.");
        } else {
            System.out.println("No more redo available.");
        }
    }

    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text: \"" + current.content + "\"");
        } else {
            System.out.println("Editor is empty.");
        }
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.displayCurrentState(); 

        editor.undo();
        editor.displayCurrentState(); 

        editor.undo();
        editor.displayCurrentState(); 

        editor.redo();
        editor.displayCurrentState(); 

        editor.addState("Hello Universe");
        editor.displayCurrentState(); 

        editor.redo(); 
        for (int i = 1; i <= 12; i++) {
            editor.addState("Line " + i);
        }

        editor.displayCurrentState(); 
    }
}
