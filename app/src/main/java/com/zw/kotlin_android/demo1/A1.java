package com.zw.kotlin_android.demo1;

public class A1 extends A {
    public String age1;

    public A1(String name, String age) {
        super(name, age);
    }


    public static final class A1Builder {
        public String name;
        public String age1;
        protected String age;

        private A1Builder() {
        }

        public static A1Builder anA1() {
            return new A1Builder();
        }

        public A1Builder withName(String name) {
            this.name = name;
            return this;
        }

        public A1Builder withAge1(String age1) {
            this.age1 = age1;
            return this;
        }

        public A1Builder withAge(String age) {
            this.age = age;
            return this;
        }

        public A1 build() {
            A1 a1 = new A1(name, age);
            a1.age1 = this.age1;
            return a1;
        }
    }
}
