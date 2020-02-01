package nl.mvdvalk.controller;

import nl.mvdvalk.entity.Student;
import nl.mvdvalk.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    // default endpoint /students/ returning all students
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // need to add the variable entry point, for ex. /students/1
    // the parameter needs to have an annotation as well
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getStudentByID(@PathVariable("id") int id) {
        return studentService.getStudentById(id);
    }

    // need to add the variable entry point, for ex. /students/1
    // the parameter needs to have an annotation as well
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeStudentByID(@PathVariable("id") int id) {
        studentService.removeStudentById(id);
    }

    // need to use the body to update the value
    // the parameter needs to have an annotation as well that the application is sending an JSON
    // formatted Student with the HTTP method PUT , when testing with Postman the type needs to be raw
    // and JSON
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
    }

    // need to use the body to update the value
    // the parameter needs to have an annotation as well that the application is sending an JSON
    // formatted Student with the HTTP method PUT , when testing with Postman the type needs to be raw
    // and JSON
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertStudent(@RequestBody Student student) {
        studentService.insertStudent(student);
    }
}
