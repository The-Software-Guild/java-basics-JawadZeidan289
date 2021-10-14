package com.sg.classroster.service;

import com.sg.classroster.dao.ClassRosterAuditDao;
import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.dto.Student;

import java.util.List;

public class ClassRosterServiceLayerImpl implements ClassRosterServiceLayer {

    private final ClassRosterDao dao;
    private ClassRosterAuditDao auditDao;

    public ClassRosterServiceLayerImpl(ClassRosterDao dao, ClassRosterAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public void createStudent(Student student) throws ClassRosterDuplicateIdException,
            ClassRosterDataValidationException,
            ClassRosterPersistenceException {

        // check if student id already exists
        if (dao.getStudent(student.getStudentId()) != null) {
            throw new ClassRosterDuplicateIdException(
                    "ERROR: Could not create student.  Student Id "
                            + student.getStudentId()
                            + " already exists");
        }

        // check if all fields are non-empty
        validateStudentData(student);

        // all good, add the student to the database
        dao.addStudent(student.getStudentId(), student);

        // write to audit log
        auditDao.writeAuditEntry("Student " + student.getStudentId() + " CREATED.");
    }

    private void validateStudentData(Student student) throws
            ClassRosterDataValidationException {

        if (student.getFirstName() == null
                || student.getFirstName().trim().length() == 0
                || student.getLastName() == null
                || student.getLastName().trim().length() == 0
                || student.getCohort() == null
                || student.getCohort().trim().length() == 0) {

            throw new ClassRosterDataValidationException(
                    "ERROR: All fields [First Name, Last Name, Cohort] are required.");
        }
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        return dao.getAllStudents();
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException {
        Student returnedStudent = dao.getStudent(studentId);
        if(returnedStudent == null) {
            throw new ClassRosterPersistenceException("No such Student with specified ID");
        } else {
            return returnedStudent;
        }
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
        Student returnedStudent = dao.removeStudent(studentId);
        if(returnedStudent == null) {
            throw new ClassRosterPersistenceException("No such Student with specified ID");
        } else {
            // Write to audit log
            auditDao.writeAuditEntry("Student " + studentId + " REMOVED.");
            return returnedStudent;
        }
    }
}
