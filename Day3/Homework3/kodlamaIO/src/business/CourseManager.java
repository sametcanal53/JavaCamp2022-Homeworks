package business;

import core.logging.Logger;
import core.valid.CourseValidator;
import dataAccess.CourseDao;
import entities.Course;

import java.util.List;

public class CourseManager {
    private CourseDao courseDao;
    private Logger[] loggers;

    public CourseManager(CourseDao courseDao, Logger[] loggers) {
        this.courseDao = courseDao;
        this.loggers = loggers;
    }

    public void add(List<Course> courses,Course course) throws Exception {
        CourseValidator.isUniqueAndIsCoursePriceNegative(courses,course);
        this.courseDao.add(course);

        for(Logger logger : loggers){
            logger.log(course.getCourseName());
        }
    }

    public void update(Course course) throws Exception {
        CourseValidator.isCoursePriceNegative(course);
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
