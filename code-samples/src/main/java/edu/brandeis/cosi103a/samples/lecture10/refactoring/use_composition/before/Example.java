package edu.brandeis.cosi103a.samples.lecture10.refactoring.use_composition.before;

class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void speak() {
        System.out.println(this.name + " makes a sound.");
    }

    public void walk() {
        System.out.println(this.name + " is walking.");
    }
}

class Dog extends Animal {
    private String breed;

    public Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }

    @Override
    public void speak() {
        System.out.println(this.name + " barks.");
    }
}

class Cat extends Animal {
    private String color;

    public Cat(String name, String color) {
        super(name);
        this.color = color;
    }

    @Override
    public void speak() {
        System.out.println(this.name + " meows.");
    }

    @Override
    public void walk() {
        throw new UnsupportedOperationException(this.name + " cannot walk.");
    }
}