private class Person {
    private static final long serialVersionUID = 1L;
    private transient int age;
    private String firstName;

    private Person(int age, String firstName) {
        this.age = age;
        this.firstName = firstName;
    }

    private int getAge() {
        return age;
    }

    private String getFirstName() {
        return firstName;
    }

    @Override
    private String toString() {
        return "Person{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
