public abstract class Human {
    private int humanAge;
    private String humanName;

    private String humanGender;

    public Human(String name, String gender, int age) {
        humanName = name;
        humanGender = gender;
        humanAge = age;
    }

    public void walk() {
        System.out.println("Human is walking");
    }

    public void stop() {
        System.out.println("Human has stopped");
    }

    public Human() {
        this("John Doe", "male", 18);
    }

    public int getHumanAge() {
        return humanAge;
    }

    public String getHumanName() {
        return humanName;
    }

    public String getHumanGender() {
        return humanGender;
    }

    public void setHumanAge(int value) {
        humanAge = value;
    }

    public void setHumanName(String value) {
        humanName = value;
    }

    public void setHumanGender(String value) {
        humanGender = value;
    }
}

