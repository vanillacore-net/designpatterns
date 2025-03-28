class TextEditor {
    private String content;
    private String lastContent; 
    
    public TextEditor() {
        this.content = "";
        this.lastContent = "";
    }
    
    public void write(String text) {
        lastContent = content;
        content += text;
    }
    
    public void undo() {
        content = lastContent; 
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
        
        // Try to undo again - won't work as expected
        editor.undo(); // ???
        System.out.println("After second undo: " + editor.getContent());
    }
}