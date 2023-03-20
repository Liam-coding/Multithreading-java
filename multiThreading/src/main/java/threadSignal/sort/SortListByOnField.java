package threadSignal.sort;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: Liam
 * @Date: 3/17/2023 10:55 AM
 */
public class SortListByOnField {
    public static void main(String[] args) {
        List<User> user = new ArrayList<>();
        User user1 = new User("A", "C1");
        User user2 = new User("A", "A1");
        User user3 = new User("A", "B1");
        User user4 = new User("A", "D1");
        User user5 = new User("A", "A2");
        Collections.addAll(user, user1, user2, user3, user4, user5);
        user.sort(Comparator.comparing(User::getAddress));
        System.out.println(user);
    }
}

@Data
@AllArgsConstructor
class User {
    private String name;
    private String address;
}
