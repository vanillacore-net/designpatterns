public class Snapshot {

    public void save(TextEditor editor) {
        this.state = editor.content;
    }

    public void restore(TextEditor editor) {
        editor.content = state;
    }

    public String state;

}

class TextEditor {
    private String content;
    private ArrayList<Snapshot> lastContent = 
        new ArrayList<Snapshot>(); // Stores many previous states
    
    public TextEditor() {
        this.content = "";
    }
    
    public void write(String text) {
        var snapshot = new Snapshot();
        snapshot.save(this);
        lastContent.add(snapshot); // Save current state before changing

        content += text;
    }
    
    public void undo() {
        var item = lastContent.get(lastContent.size() - 1);
        if(lastContent.size() > 1)
            lastContent.remove(lastContent.size() - 1)

        item.restore(this); // Can only undo once
    }
    
    public String getContent() {
        return content;
    }
}

class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        
        // Writing some text
        editor.write("Hello ");
        System.out.println("Current text: " + editor.getContent()); // Hello 
        
        editor.write("World!");
        System.out.println("Current text: " + editor.getContent()); // Hello World!
        
        // Try to undo
        editor.undo();
        System.out.println("After undo: " + editor.getContent()); // Hello
        
        // Try to undo again
        editor.undo(); // 
        System.out.println("After second undo: " + editor.getContent());
    }
}