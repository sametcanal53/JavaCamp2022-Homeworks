package core.valid;

import entities.Course;

import java.util.List;

public class CourseValidator{
    public static void isCoursePriceNegative(Course course) throws Exception{
        if(course.getPrice()<0){
            throw new Exception("The course price cannot be a negative value");
        }
    }
    public static void isUniqueAndIsCoursePriceNegative(List<Course> courses, Course course) throws Exception{
        if(course.getPrice()<0){
            throw new Exception("The course price cannot be a negative value");
        }
        for (Course c : courses) {
            if (c.getCourseName().equals(course.getCourseName())) {
                throw new Exception("This course name is already registered in the system. Cannot be re-registered");
            }
        }
    }
}
