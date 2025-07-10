class Item {
    String name;
    int id;
    int quantity;
    double price;
    Item next;

    public Item(String name, int id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

public class InventoryList {
    Item head = null;

    // Add at beginning
    public void addAtBeginning(String name, int id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // Add at end
    public void addAtEnd(String name, int id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        if (head == null) {
            head = newItem;
        } else {
            Item temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newItem;
        }
    }

    // Add at position
    public void addAtPosition(int position, String name, int id, int quantity, double price) {
        if (position <= 1) {
            addAtBeginning(name, id, quantity, price);
            return;
        }
        Item newItem = new Item(name, id, quantity, price);
        Item temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) return;
        newItem.next = temp.next;
        temp.next = newItem;
    }

    // Remove by ID
    public void removeById(int id) {
        if (head == null) return;
        if (head.id == id) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.id != id) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // Update quantity by ID
    public void updateQuantity(int id, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
    }

    // Search by ID or Name
    public void searchItem(String keyword) {
        Item temp = head;
        boolean found = false;
        while (temp != null) {
            if (String.valueOf(temp.id).equals(keyword) || temp.name.equalsIgnoreCase(keyword)) {
                System.out.println("Item: " + temp.name + ", ID: " + temp.id + ", Qty: " + temp.quantity + ", Price: " + temp.price);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("Item not found.");
    }

    // Calculate total value
    public void totalValue() {
        Item temp = head;
        double total = 0;
        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: ₹" + total);
    }

    // Sort by name or price using bubble sort (for simplicity)
    public void sortInventory(String field, boolean ascending) {
        if (head == null || head.next == null) return;

        boolean swapped;
        do {
            swapped = false;
            Item curr = head;
            while (curr.next != null) {
                boolean shouldSwap = false;
                if (field.equalsIgnoreCase("name")) {
                    shouldSwap = ascending ? curr.name.compareTo(curr.next.name) > 0 : curr.name.compareTo(curr.next.name) < 0;
                } else if (field.equalsIgnoreCase("price")) {
                    shouldSwap = ascending ? curr.price > curr.next.price : curr.price < curr.next.price;
                }

                if (shouldSwap) {
                    // Swap data only
                    String tempName = curr.name;
                    int tempId = curr.id;
                    int tempQty = curr.quantity;
                    double tempPrice = curr.price;

                    curr.name = curr.next.name;
                    curr.id = curr.next.id;
                    curr.quantity = curr.next.quantity;
                    curr.price = curr.next.price;

                    curr.next.name = tempName;
                    curr.next.id = tempId;
                    curr.next.quantity = tempQty;
                    curr.next.price = tempPrice;

                    swapped = true;
                }
                curr = curr.next;
            }
        } while (swapped);
    }

    public void displayAll() {
        Item temp = head;
        while (temp != null) {
            System.out.println("Item: " + temp.name + ", ID: " + temp.id + ", Qty: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        InventoryList inventory = new InventoryList();
        inventory.addAtEnd("Keyboard", 101, 20, 499.0);
        inventory.addAtBeginning("Mouse", 102, 50, 299.0);
        inventory.addAtPosition(2, "Monitor", 103, 10, 6999.0);

        inventory.displayAll();
        inventory.totalValue();

        inventory.sortInventory("price", true);
        System.out.println("Sorted by Price:");
        inventory.displayAll();
    }
}
