import business.CategoryManager;
import business.CourseManager;
import business.InstructorManager;
import core.logging.DatabaseLogger;
import core.logging.FileLogger;
import core.logging.Logger;
import core.logging.MailLogger;
import dataAccess.HibernateCategoryDao;
import dataAccess.HibernateCourseDao;
import dataAccess.JdbcInstructorDao;
import entities.Category;
import entities.Course;
import entities.Instructor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Logger[] loggers = {new DatabaseLogger(),new FileLogger(),new MailLogger()};

        Instructor instructor = new Instructor("Ahmet","Demirog");
        InstructorManager instructorManager = new InstructorManager(new JdbcInstructorDao(),loggers);
        instructorManager.add(instructor);
        instructor.setFirstName("Engin");
        instructorManager.update(instructor);
        System.out.println();

        Category category = new Category("Category 1");
        List<Category> categories = new ArrayList<>();
        CategoryManager categoryManager = new CategoryManager(new HibernateCategoryDao(),loggers);
        categoryManager.add(categories,category);
        //categoryManager.add(categories,category);
        category.setCategoryName("Category 2");
        categoryManager.delete(category);
        System.out.println();

        Course course1 = new Course("(2022) Yazilim Gelistirici Yetistirme Kampi - Java",5,category,instructor);
        Course course2 = new Course("Programlamaya Giris icin Temel Kurs",5,category,instructor);
        List<Course> courses = new ArrayList<>();
        CourseManager courseManager = new CourseManager(new HibernateCourseDao(),loggers);
        courseManager.add(courses,course1);
        courseManager.add(courses,course2);
        //courseManager.add(courses,course1);
        course1.setCourseName("Senior Yazilim Gelistirici Yetistirme Kampi (.NET)");
        //course1.setPrice(-5);
        courseManager.update(course1);

    }
}