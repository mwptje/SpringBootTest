package nl.mvdvalk.dao;

import nl.mvdvalk.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentDao {
    private static Map<Integer, Student> students;

    // add some data to test using a class constructor
    static {
        students = new HashMap<Integer, Student>() {
            {
                put(1, new Student(1, "Said", "Coumputer Science"));
                put(2, new Student(2, "Alex", "Finance"));
                put(3, new Student(3, "Anna", "Math"));
            }
        };
    }

    public Collection<Student> getAllStudents() {
        return students.values();
    }

    public Student getStudentById(int id) {
        return students.get(id);
    }

    public void removeStudentById(int id) {
        students.remove(id);
    }

    public void updateStudent(Student student) {
        Student s = students.get(student.getId());
        s.setCourse(student.getCourse());
        s.setName(student.getName());
        students.put(student.getId(), student);
    }

    public void insertStudent(Student student) {
        students.put(student.getId(), student);
    }
}
