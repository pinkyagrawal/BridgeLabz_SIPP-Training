class Process {
    int pid;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime = 0;
    int turnaroundTime = 0;
    Process next;

    public Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
    }
}

public class RoundRobinScheduler {
    Process head = null;
    Process tail = null;
    int totalProcesses = 0;

    // Add a process at the end
    public void addProcess(int pid, int burstTime, int priority) {
        Process newProcess = new Process(pid, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            newProcess.next = head;
        } else {
            tail.next = newProcess;
            newProcess.next = head;
            tail = newProcess;
        }
        totalProcesses++;
    }

    // Remove a process by PID
    public void removeProcess(int pid) {
        if (head == null) return;

        Process current = head;
        Process prev = tail;

        do {
            if (current.pid == pid) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = current.next;
                }
                totalProcesses--;
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    // Display the current processes
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }
        System.out.println("Current Process Queue:");
        Process temp = head;
        do {
            System.out.println("PID: " + temp.pid + ", BT: " + temp.burstTime + ", RT: " + temp.remainingTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }

    // Simulate Round Robin Scheduling
    public void simulate(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to simulate.");
            return;
        }

        int timeElapsed = 0;
        Process current = head;

        System.out.println("\n--- Round Robin Scheduling Simulation ---");

        while (totalProcesses > 0) {
            if (current.remainingTime > 0) {
                int executionTime = Math.min(timeQuantum, current.remainingTime);
                System.out.println("Executing PID: " + current.pid + " for " + executionTime + " units.");

                timeElapsed += executionTime;
                current.remainingTime -= executionTime;

                if (current.remainingTime == 0) {
                    current.turnaroundTime = timeElapsed;
                    current.waitingTime = current.turnaroundTime - current.burstTime;
                    System.out.println("Process PID " + current.pid + " completed.");
                    removeProcess(current.pid);
                    if (totalProcesses == 0) break;
                    current = current.next;
                    displayProcesses();
                    continue;
                }
            }

            current = current.next;
        }

        calculateAverageTimes(timeElapsed);
    }

    // Calculate and display average times
    public void calculateAverageTimes(int totalTime) {
        double totalWT = 0, totalTAT = 0;
        int count = 0;

        Process temp = head;
        if (temp == null) {
            System.out.println("\n--- All processes completed ---");
            System.out.println("Total time: " + totalTime);
            return;
        }

        do {
            totalWT += temp.waitingTime;
            totalTAT += temp.turnaroundTime;
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("\nAverage Waiting Time: " + (totalWT / count));
        System.out.println("Average Turnaround Time: " + (totalTAT / count));
    }

    // Main Method to Test
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);
        scheduler.addProcess(4, 4, 3);

        scheduler.displayProcesses();

        int timeQuantum = 3;
        scheduler.simulate(timeQuantum);
    }
}
