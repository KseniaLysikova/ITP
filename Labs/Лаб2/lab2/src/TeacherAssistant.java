public class TeacherAssistant extends Human {
    private String assistantTeacher;
    private String subjectTaught;
    private int experience;

    public void startTeaching() {
        System.out.println("Teacher has started teaching");
    }

    public void stopTeaching() {
        System.out.println("Teacher has stopped teaching");
    }

    public TeacherAssistant(String name, String gender, int age, String teacher, String subject, int exp) {
        super(name, gender, age);
        assistantTeacher = teacher;
        subjectTaught = subject;
        experience = exp;
    }

    public TeacherAssistant() {
        this("John Doe", "male", 20, " ", " ", 2);
    }

    public String getAssistantTeacher() {
        return assistantTeacher;
    }

    public String getSubjectTaught() {
        return subjectTaught;
    }

    public int getExperience() {
        return experience;
    }

    public void setAssistantTeacher(String value) {
        assistantTeacher = value;
    }

    public void setSubjectTaught(String value) {
        subjectTaught = value;
    }

    public void setExperience(int value) {
        experience = value;
    }
}
