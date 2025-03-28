// Flyweight class - stores shared properties
class CharacterFormat {
    private String font;
    private int size;
    private String color;
    
    public CharacterFormat(String font, int size, String color) {
        this.font = font;
        this.size = size;
        this.color = color;
    }
    
    public String getFont() { return font; }
    public int getSize() { return size; }
    public String getColor() { return color; }
}

// Flyweight factory
class CharacterFormatFactory {
    private static Map<String, CharacterFormat> formats = new HashMap<>();
    
    public static CharacterFormat getFormat(String font, int size, String color) {
        String key = font + size + color;
        if (!formats.containsKey(key)) {
            formats.put(key, new CharacterFormat(font, size, color));
        }
        return formats.get(key);
    }
    
    public static int getFormatCount() {
        return formats.size();
    }
}

// Character using flyweight
class Character {
    private char symbol;
    private CharacterFormat format;  // Reference to shared flyweight
    
    public Character(char symbol, CharacterFormat format) {
        this.symbol = symbol;
        this.format = format;
    }
    
    public void print() {
        System.out.println("Character " + symbol + 
                         " with font " + format.getFont() + 
                         ", size " + format.getSize() + 
                         ", color " + format.getColor());
    }
}

// Client code WITH pattern
class TextEditorWithFlyweight {
    public static void main(String[] args) {
        List<Character> document = new ArrayList<>();
        
        // Creating same document with shared formatting
        CharacterFormat format = 
            CharacterFormatFactory
                .getFormat("Roboto", 12, "black");
        
        document.add(new Character('H', format));
        document.add(new Character('e', format));
        document.add(new Character('l', format));
        document.add(new Character('l', format));
        document.add(new Character('o', format));
        
        // Print characters
        for (Character character : document) {
            character.print();
        }
        
        System.out.println("Number of format objects created: " + 
                         CharacterFormatFactory.getFormatCount());  // Only 1!
    }
}