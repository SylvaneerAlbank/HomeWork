package Animal;

public final class Tiger extends Animal {
    public Tiger(String name, int hungryStatus, int weight) {
        super(name, hungryStatus, weight);
    }

    public void walk() {
        if (this.hungryStatus == 0) {
            System.out.println("Tiger starving, please feed him, status: " + this.hungryStatus);
        } else {
            this.hungryStatus--;
            System.out.println("Tiger walking..., status: " + this.hungryStatus);
        }
    }

    public void eat() {
        if (this.hungryStatus == 10) {
            System.out.println("Tiger is well fed, status: " + this.hungryStatus);
        } else {
            this.hungryStatus++;
            System.out.println("Tiger eating..., status: " + this.hungryStatus);
        }
    }

    public void tigerRush() {
        System.out.println("Tiger rush!!!");
    }
}
