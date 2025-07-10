import java.util.*;

class User {
    int userId;
    String name;
    int age;
    ArrayList<Integer> friendIds;
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

public class SocialMedia {
    User head = null;

    
    public void addUser(int id, String name, int age) {
        User newUser = new User(id, name, age);
        newUser.next = head;
        head = newUser;
    }


    public User findUserById(int id) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void addFriendConnection(int userId1, int userId2) {
        if (userId1 == userId2) {
            System.out.println("Cannot add self as friend.");
            return;
        }

        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        if (!user1.friendIds.contains(userId2)) user1.friendIds.add(userId2);
        if (!user2.friendIds.contains(userId1)) user2.friendIds.add(userId1);

        System.out.println("Friend connection added between " + userId1 + " and " + userId2);
    }

    public void removeFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        user1.friendIds.remove(Integer.valueOf(userId2));
        user2.friendIds.remove(Integer.valueOf(userId1));

        System.out.println("Friend connection removed between " + userId1 + " and " + userId2);
    }

    public void displayFriends(int userId) {
        User user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Friends of " + user.name + ":");
        for (int fid : user.friendIds) {
            User f = findUserById(fid);
            if (f != null) {
                System.out.println("Friend ID: " + f.userId + ", Name: " + f.name);
            }
        }
    }

    public void searchUser(String keyword) {
        User temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(keyword) || String.valueOf(temp.userId).equals(keyword)) {
                System.out.println("User Found - ID: " + temp.userId + ", Name: " + temp.name + ", Age: " + temp.age);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("User not found.");
        }
    }

    public void findMutualFriends(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        Set<Integer> set = new HashSet<>(user1.friendIds);
        List<Integer> mutual = new ArrayList<>();

        for (int fid : user2.friendIds) {
            if (set.contains(fid)) mutual.add(fid);
        }

        System.out.println("Mutual Friends of " + user1.name + " and " + user2.name + ":");
        if (mutual.isEmpty()) {
            System.out.println("No mutual friends.");
        } else {
            for (int fid : mutual) {
                User f = findUserById(fid);
                if (f != null) {
                    System.out.println("Friend ID: " + f.userId + ", Name: " + f.name);
                }
            }
        }
    }

    public void countAllFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println("User " + temp.name + " has " + temp.friendIds.size() + " friend(s).");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();

        sm.addUser(1, "Alice", 25);
        sm.addUser(2, "Bob", 30);
        sm.addUser(3, "Charlie", 28);
        sm.addUser(4, "David", 27);

        sm.addFriendConnection(1, 2);
        sm.addFriendConnection(1, 3);
        sm.addFriendConnection(2, 3);
        sm.addFriendConnection(3, 4);

        sm.displayFriends(3);

        sm.findMutualFriends(1, 2);

        sm.searchUser("Bob");
        sm.searchUser("4");

        sm.countAllFriends();

        sm.removeFriendConnection(1, 2);
        sm.displayFriends(1);
    }
}
