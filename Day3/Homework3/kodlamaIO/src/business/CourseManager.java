package business;

import core.logging.Logger;
import core.valid.CourseValidator;
import dataAccess.CourseDao;
import entities.Course;

import java.util.List;

public class CourseManager {
    private List<Course> courses;
    private CourseDao courseDao;
    private Logger[] loggers;

    public CourseManager(List<Course> courses,CourseDao courseDao, Logger[] loggers) {
        this.courses = courses;
        this.courseDao = courseDao;
        this.loggers = loggers;
    }

    public void add(Course course) throws Exception {
        CourseValidator.isUniqueAndIsCoursePriceNegative(courses,course);
        this.courses.add(course);
        this.courseDao.add(course);

        for(Logger logger : loggers){
            logger.log(course.getCourseName());
        }
    }

    public void update(Course course) throws Exception {
        CourseValidator.isCoursePriceNegative(course);
        this.courses.add(course);
        this.courseDao.update(course);

        for(Logger logger : loggers){
            logger.log(course.getCourseName());
        }
    }

    public void delete(Course course) {
        this.courseDao.delete(course);

        for(Logger logger : loggers){
            logger.log(course.getCourseName());
        }
    }
}
