import java.util.*;

abstract class CourseType {}
class ExamCourse extends CourseType {}
class AssignmentCourse extends CourseType {}
class ResearchCourse extends CourseType {}

class Course<T extends CourseType> {
    private T type;
    public Course(T type) { this.type = type; }
}

class CourseDisplay {
    public static void show(List<? extends CourseType> courses) {
        for (CourseType c : courses)
            System.out.println(c.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        List<CourseType> list = List.of(new ExamCourse(), new ResearchCourse());
        show(list);
    }
}

