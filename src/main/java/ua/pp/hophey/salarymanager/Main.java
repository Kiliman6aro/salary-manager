package ua.pp.hophey.salarymanager;

import ua.pp.hophey.greeting.UserGreeting;
import ua.pp.hophey.greeting.WorldGreeting;

public class Main {
    public static void main(String[] args) {
        WorldGreeting.greet();
        UserGreeting.greet("Pavel");
    }
}
