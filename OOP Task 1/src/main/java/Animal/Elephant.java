package Animal;

public final class Elephant extends Animal {
    public Elephant(String name, int hungryStatus, int weight) {
        super(name, hungryStatus, weight);
    }

    public void walk() {
        if (this.hungryStatus == 0) {
            System.out.println("Elephant starving, please feed him, status: " + this.hungryStatus);
        } else {
            this.hungryStatus--;
            System.out.println("Elephant walking..., status: " + this.hungryStatus);
        }
    }

    public void eat() {
        if (this.hungryStatus == 10) {
            System.out.println("Elephant is well fed, status: " + this.hungryStatus);
        } else {
            this.hungryStatus++;
            System.out.println("Elephant eating..., status: " + this.hungryStatus);
        }
    }

    public void tootViaTrunk() {
        System.out.println("Elephant toot!!!");
    }
}
