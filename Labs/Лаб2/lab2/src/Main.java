public class Main {
    public static void main(String[] args) {
        Student me = new Student("Ksenia Lysikova", "female", 19, "IT",
                "1BVT2203", "1BVT22137");
        Student secondStudent = new Student();
        secondStudent.setStudentFaculty("IT");
        System.out.println(secondStudent.getStudentFaculty());
    }
}
