import java.util.ArrayList;

class Pizza {
    private String dough;
    private String sauce;
    private ArrayList<String> topping = new ArrayList<>();

    private Pizza() {}

    public String toString() {
        return "Pizza with " + dough + " dough, " + sauce + " sauce, " +
                (topping != null && !topping.isEmpty() ? " and " + topping : " no topping");
    }

    private void validate() {
        // Validation logic if needed
    }

    public static class Builder {
        private Pizza pizza;

        public Builder() {
            pizza = new Pizza();
            pizza.dough = "thin";
            pizza.sauce = "Tomato";
        }

        public Builder dough(String dough) {
            pizza.dough = dough;
            return this;
        }

        public Builder sauce(String sauce) {
            if (sauce != null)
                pizza.sauce = sauce;
            return this;
        }

        public Builder topping(String topping) {
            pizza.topping.add(topping);
            return this;
        }

        public Pizza build() {
            if (pizza.topping.isEmpty()) {
                pizza.topping.add("Tomato");
            }
            pizza.validate();
            return pizza;
        }
    }
}

class Client {
    public static void main(String[] args) {
        Pizza pizza1 = new Pizza.Builder()
                .topping("pepperoni")
                .topping("tomato")
                .topping("cheese")
                .dough("thin")
                .sauce("pepperoni")
                .build();

        Pizza pizza2 = new Pizza.Builder()
                .dough("thick")
                .sauce("bbq")
                .build();

        System.out.println(pizza1);
        System.out.println(pizza2);
    }
}