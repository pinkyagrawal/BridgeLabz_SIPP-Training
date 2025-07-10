
interface Worker {
    void performDuties();
}

class Person {
    String name;
    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void showInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}
class Chef extends Person implements Worker {
    Chef(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println(name + " is cooking food.");
    }
}

class Waiter extends Person implements Worker {
    Waiter(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println(name + " is serving food.");
    }
}

public class RestaurantSystem {
    public static void main(String[] args) {
        Chef chef = new Chef("Ramesh", 101);
        Waiter waiter = new Waiter("Suresh", 102);

        chef.showInfo();
        chef.performDuties();

        System.out.println();

        waiter.showInfo();
        waiter.performDuties();
    }
}
