package nl.mvdvalk.dao;

import nl.mvdvalk.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

// note if there is another implementation of StudentDao then
// the Qualifier annotation points to this implementation
// see also the service class StudentService which also has the same qualifier
// this way you can easily change the implementation
@Repository
@Qualifier("fakeData")
public class FakeStudentDaoImpl implements StudentDao {
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

    @Override
    public Collection<Student> getAllStudents() {
        return students.values();
    }

    @Override
    public Student getStudentById(int id) {
        return students.get(id);
    }

    @Override
    public void removeStudentById(int id) {
        students.remove(id);
    }

    @Override
    public void updateStudent(Student student) {
        Student s = students.get(student.getId());
        s.setCourse(student.getCourse());
        s.setName(student.getName());
        students.put(student.getId(), student);
    }

    @Override
    public void insertStudent(Student student) {
        students.put(student.getId(), student);
    }
}
