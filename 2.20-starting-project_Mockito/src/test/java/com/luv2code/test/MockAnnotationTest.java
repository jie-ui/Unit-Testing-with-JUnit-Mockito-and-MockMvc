package com.luv2code.test;


import com.luv2code.component.MvcTestingExampleApplication;
import com.luv2code.component.dao.ApplicationDao;
import com.luv2code.component.models.CollegeStudent;
import com.luv2code.component.models.Student;
import com.luv2code.component.models.StudentGrades;
import com.luv2code.component.service.ApplicationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes= MvcTestingExampleApplication.class)
public class MockAnnotationTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    CollegeStudent studentone;

    @Autowired
    StudentGrades studentGrades;

    //@Mock
    @MockitoBean
    private ApplicationDao applicationDao;

    //@InjectMocks
    @Autowired
    private ApplicationService applicationService;


    @BeforeEach
    public void beforeEach() {
        studentone.setFirstname("Eric");
        studentone.setLastname("Daniel");
        studentone.setEmailAddress("eric.roby@lub.com");
        studentone.setStudentGrades(studentGrades);
    }
    @DisplayName("when & Verify")
    @Test
    public void assertEqualsTestAddGrades() {
       //set expectation wiht mock  resposes
        when(applicationDao.addGradeResultsForSingleClass(
                                            studentGrades.getMathGradeResults())).thenReturn(100.00);

        //executre call the methons what you want to testapplicationService.addGradeResultsForSingleClass(
        //        studentone.getStudentGrades().getMathGradeResults())
        //Assert check expected and actucally

        assertEquals(100,applicationService.addGradeResultsForSingleClass(
                                            studentone.getStudentGrades().getMathGradeResults()));

        //verfiy mock was called , how many times
        verify(applicationDao).addGradeResultsForSingleClass(studentGrades.getMathGradeResults());

        verify(applicationDao,times(1)).addGradeResultsForSingleClass(studentGrades.getMathGradeResults());

    }

    @DisplayName("find Gpa")
    @Test
    public void findGpaTest(){
        when(applicationDao.findGradePointAverage(studentone.getStudentGrades().getMathGradeResults())).thenReturn(88.31);

        assertEquals (88.31, applicationService.findGradePointAverage(studentone.getStudentGrades().getMathGradeResults()));



    }

    @DisplayName("Not null")
    @Test
    public void notNullTest(){
        when(applicationDao.checkNull(studentGrades.getMathGradeResults())).thenReturn(true);

        assertNotNull ( applicationService.checkNull(studentone.getStudentGrades().getMathGradeResults()),"object should not be null");



    }

    @DisplayName("Thorw runtime error")
    @Test

    public void thorwRuntimeExceptionTest(){
        CollegeStudent nullstudent = (CollegeStudent) context.getBean("collegeStudent");
        doThrow(new RuntimeException()).when(applicationDao).checkNull(nullstudent);
        assertThrows(RuntimeException.class,()->{
            applicationService.checkNull(nullstudent);
        });

        verify(applicationDao,times(1)).checkNull(nullstudent);



    }

    @DisplayName("Multiple stubbing")
    @Test
    public void multipleStubbingTest() {
        CollegeStudent collegeStudent = (CollegeStudent) context.getBean("collegeStudent");

        // Stub the method to throw exception first, then return true
        when(applicationDao.checkNull(collegeStudent))
                .thenThrow(new RuntimeException())
                .thenReturn("true");

        // First call - should throw exception
        assertThrows(RuntimeException.class, () -> {
            applicationService.checkNull(collegeStudent);
        });

        // Second call - should return true (no exception)
        assertEquals("true",applicationService.checkNull(collegeStudent));

        verify(applicationDao, times(2)).checkNull(collegeStudent);
    }




}
