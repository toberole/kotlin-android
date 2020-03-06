package com.zw.kotlin_android.lombok;

public class User1 {
    public String name;
    public int age;


    public static final class User1Builder {
        public int age;

        private User1Builder() {
        }

        public static User1Builder anUser1() {
            return new User1Builder();
        }

        public User1Builder withAge(int age) {
            this.age = age;
            return this;
        }

        public User1 build() {
            User1 user1 = new User1();
            user1.age = this.age;
            return user1;
        }
    }
}
