package Animal;

public abstract class Animal {
    private String name;
    protected int hungryStatus;
    private int weight;

    public Animal(String _name, int _hungryStatus, int _weight) {
        this.name = _name;
        this.hungryStatus = _hungryStatus;
        this.weight = _weight;
    }

    public abstract void walk();

    public abstract void eat();

    @Override
    public String toString() {
        return "{class:" + this.getClass().getName() + ", name=" + name +
                ", hungryStatus='" + hungryStatus + '\'' +
                ", weight=" + weight +
                '}';
    }

    public int getWeight() {
        return this.weight;
    }

    public int getHungryStatus() {
        return this.hungryStatus;
    }

    public String getName() {
        return this.name;
    }

}
