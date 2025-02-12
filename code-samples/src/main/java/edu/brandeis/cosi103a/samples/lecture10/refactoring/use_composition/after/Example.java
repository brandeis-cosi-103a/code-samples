package edu.brandeis.cosi103a.samples.lecture10.refactoring.use_composition.after;

// We've replaced inheritance with composition, by using a separate class for each behavior.
// This makes the behavior of each class more clear, and the overall Animal class more flexible.
// Inheritance is usually NOT a good way to re-use code!

interface SoundBehavior {
    void speak(String name);
}

class NormalSound implements SoundBehavior {
    private String sound;

    public NormalSound(String sound) {
        this.sound = sound;
    }

    public void speak(String name) {
        System.out.println(name + " " + sound + ".");
    }
}

interface WalkBehavior {
    void walk(String name);
}

class NormalWalker implements WalkBehavior{
    public void walk(String name) {
        System.out.println(name + " is walking.");
    }
}

class CantWalk implements WalkBehavior {
    public void walk(String name) {
        throw new UnsupportedOperationException(name + " cannot walk.");
    }
}

class Animal {
    private String name;
    private SoundBehavior soundBehavior;
    private WalkBehavior walkBehavior;

    public Animal(String name, SoundBehavior soundBehavior, WalkBehavior walkBehavior) {
        this.name = name;
        this.soundBehavior = soundBehavior;
        this.walkBehavior = walkBehavior;
    }

    public void speak() {
        soundBehavior.speak(name);
    }

    public void walk() {
        walkBehavior.walk(name);
    }
}

public class Example {
    public static Animal makeDog(String name) {
        return new Animal(name, new NormalSound("barks"), new NormalWalker());
    }

    public static Animal makeCat(String name) {
        return new Animal(name, new NormalSound("meows"), new CantWalk());
    }

    public static void main(String[] args) {
        Animal dog = makeDog("Dog");
        dog.speak();
        dog.walk();

        Animal cat = makeCat("Cat");
        cat.speak();
        try {
            cat.walk();
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }
}