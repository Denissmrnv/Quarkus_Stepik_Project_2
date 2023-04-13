package edu.my.repository;

import edu.my.entity.Student;

import javax.enterprise.context.Dependent;
import java.util.ArrayList;
import java.util.List;

@Dependent
public class StudentRepositoryMemory {

    List<Student> students = new ArrayList<>();

    {
        Student student1 = new Student(1,
                "Denis",
                "Smirnov",
                "IPB",
                23,
                3);

        students.add(student1);
    }

    public List<Student> findAll() {
        return this.students;
    }

    public Student findById(Long id) {
        for (Student student: this.students) {
            if (student.getId() == id)
                return student;
        }
        return null;
    }

    public void persist(Student student) {
        this.students.add(student);
    }

    public void deleteById(Long id) {
        for (Student student: this.students) {
            if (student.getId() == id)
                this.students.remove(student);
        }
    }
}
