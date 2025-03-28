// WITHOUT FLYWEIGHT PATTERN
class Character {
    private char symbol;
    private String font;
    private int size;
    private String color;
    
    public Character(char symbol, String font, int size, String color) {
        this.symbol = symbol;
        this.font = font;
        this.size = size;
        this.color = color;
    }
    
    public void print() {
        System.out.println("Character " + symbol + 
                         " with font " + font + 
                         ", size " + size + 
                         ", color " + color);
    }
}

class TextEditor {
    public static void main(String[] args) {
        List<Character> document = new ArrayList<>();
        
        document.add(new Character('H', "Roboto", 12, "black"));
        document.add(new Character('e', "Roboto", 12, "black"));
        document.add(new Character('l', "Roboto", 12, "black"));
        document.add(new Character('l', "Roboto", 12, "black"));
        document.add(new Character('o', "Roboto", 12, "black"));
        
        for (Character character : document) {
            character.print();
        }
    }
}
