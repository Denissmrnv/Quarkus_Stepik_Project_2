package edu.my.service;

import edu.my.entity.Student;
import edu.my.repository.StudentRepositoryMemory;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
public class GreetingResource {

    @Inject
    StudentRepositoryMemory studentRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/students")
    public List<Student> getAllStudents()  {
        return studentRepository.findAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/students/{id}")
    public Student getStudentByID(@PathParam("id") long id)  {
        return studentRepository.findById(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/students")
    @Transactional
    public String addStudent(Student student) {
        studentRepository.persist(student);
        return student.getName() + " " + student.getSurname() + " is added " +
                "to " + student.getGroup();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/students/{id}")
    @Transactional
    public void deleteStudent(@PathParam("id") long id) {
        System.out.println();
        studentRepository.deleteById(id);
    }
}