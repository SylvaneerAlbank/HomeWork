package Animal;

public final class Wolf extends Animal {
    public Wolf(String name, int hungryStatus, int weight) {
        super(name, hungryStatus, weight);
    }

    public void walk() {
        if (this.hungryStatus == 0) {
            System.out.println("Wolf starving, please feed him, status: " + this.hungryStatus);
        } else {
            this.hungryStatus--;
            System.out.println("Wolf walking..., status: " + this.hungryStatus);
        }
    }

    public void eat() {
        if (this.hungryStatus == 10) {
            System.out.println("Wolf is well fed, status: " + this.hungryStatus);
        } else {
            this.hungryStatus++;
            System.out.println("Wolf eating..., status: " + this.hungryStatus);
        }
    }

    public void wolfBite() {
        System.out.println("Wolf bite!!!");
    }
}
