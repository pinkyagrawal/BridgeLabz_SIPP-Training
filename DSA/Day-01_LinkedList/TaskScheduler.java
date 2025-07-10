class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

public class TaskScheduler {
    Task head = null;
    Task tail = null;
    Task current = null; // Used for viewing current task and cycling

    // 1. Add task at beginning
    public void addAtBeginning(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            newTask.next = head;
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head;
        }
    }

    // 2. Add task at end
    public void addAtEnd(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            newTask.next = head;
        } else {
            tail.next = newTask;
            newTask.next = head;
            tail = newTask;
        }
    }

    // 3. Add at specific position (1-based index)
    public void addAtPosition(int position, int id, String name, int priority, String dueDate) {
        if (position <= 1) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }

        Task newTask = new Task(id, name, priority, dueDate);
        Task temp = head;

        for (int i = 1; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        newTask.next = temp.next;
        temp.next = newTask;

        if (temp == tail) {
            tail = newTask;
        }
    }

    // 4. Remove by Task ID
    public void removeById(int id) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        // Single node case
        if (head == tail && head.taskId == id) {
            head = tail = null;
            System.out.println("Task with ID " + id + " removed.");
            return;
        }

        Task temp = head, prev = tail;
        do {
            if (temp.taskId == id) {
                if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } else if (temp == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = temp.next;
                }
                System.out.println("Task with ID " + id + " removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Task ID not found.");
    }

    // 5. View current task and move to next
    public void viewCurrentAndMoveNext() {
        if (current == null) {
            current = head;
        }

        if (current != null) {
            System.out.println("Current Task: ID=" + current.taskId + ", Name=" + current.taskName +
                    ", Priority=" + current.priority + ", Due=" + current.dueDate);
            current = current.next;
        } else {
            System.out.println("No tasks scheduled.");
        }
    }

    // 6. Display all tasks from head
    public void displayAll() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        Task temp = head;
        System.out.println("Scheduled Tasks:");
        do {
            System.out.println("ID: " + temp.taskId + ", Name: " + temp.taskName +
                    ", Priority: " + temp.priority + ", Due: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // 7. Search tasks by priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Found Task: ID=" + temp.taskId + ", Name=" + temp.taskName +
                        ", Due=" + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority " + priority);
        }
    }

    // Main method to test
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addAtEnd(1, "Write Report", 2, "2025-07-15");
        scheduler.addAtBeginning(2, "Attend Meeting", 1, "2025-07-12");
        scheduler.addAtPosition(2, 3, "Prepare Slides", 3, "2025-07-13");

        scheduler.displayAll();
        System.out.println();

        scheduler.viewCurrentAndMoveNext();
        scheduler.viewCurrentAndMoveNext();
        scheduler.viewCurrentAndMoveNext();
        scheduler.viewCurrentAndMoveNext();  // Loops again
        System.out.println();

        scheduler.searchByPriority(2);
        System.out.println();

        scheduler.removeById(3);
        scheduler.displayAll();
    }
}
