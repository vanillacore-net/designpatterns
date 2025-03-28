<?php

class Pizza {
    private $dough;
    private $sauce;
    private $topping = [];

    private function __construct() {}

    public function __toString(): string {
        return "Pizza with {$this->dough} dough, {$this->sauce} sauce" .
               (!empty($this->topping) ? " and " . implode(", ", $this->topping) : " no topping");
    }

    private function validate(): void {
        // Add validation logic if needed
    }

    public static function builder(): PizzaBuilder {
        return new PizzaBuilder();
    }
}

class PizzaBuilder {
    private $pizza;

    public function __construct() {
        $this->pizza = new Pizza();
        $this->pizza->dough = 'thin';
        $this->pizza->sauce = 'Tomato';
    }

    public function dough(string $dough): self {
        $this->pizza->dough = $dough;
        return $this;
    }

    public function sauce(?string $sauce): self {
        if ($sauce !== null)
            $this->pizza->sauce = $sauce;
        return $this;
    }

    public function topping(string $topping): self {
        $this->pizza->topping[] = $topping;
        return $this;
    }

    public function build(): Pizza {
        if (empty($this->pizza->topping)) {
            $this->pizza->topping[] = "Tomato";
        }
        $this->pizza->validate();
        return $this->pizza;
    }
}

// Client usage
$pizza1 = Pizza::builder()
    ->topping("pepperoni")
    ->topping("tomato")
    ->topping("cheese")
    ->dough("thin")
    ->sauce("pepperoni")
    ->build();

$pizza2 = Pizza::builder()
    ->dough("thick")
    ->sauce("bbq")
    ->build();

echo $pizza1 . PHP_EOL;
echo $pizza2 . PHP_EOL;
