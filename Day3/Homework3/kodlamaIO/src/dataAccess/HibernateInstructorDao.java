package dataAccess;

import entities.Instructor;

public class HibernateInstructorDao implements InstructorDao{
    @Override
    public void add(Instructor instructor) {
        System.out.println("Instructor added with Hibernate : " + instructor.getFirstName() + " " + instructor.getLastName());
    }

    @Override
    public void update(Instructor instructor) {
        System.out.println("Instructor updated with Hibernate : " + instructor.getFirstName() + " " + instructor.getLastName());
    }

    @Override
    public void delete(Instructor instructor) {
        System.out.println("Instructor deleted with Hibernate : " + instructor.getFirstName() + " " + instructor.getLastName());
    }
}
