package com.luv2code.test;

import com.luv2code.component.MvcTestingExampleApplication;
import com.luv2code.component.models.CollegeStudent;
import com.luv2code.component.models.StudentGrades;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = MvcTestingExampleApplication.class)
public class ApplicationExampleTest {

    private static int count = 0;
    //@Value 是 Spring 提供的注解，用来将外部配置的值注入到 Spring Bean 中的字段。application.properties
    @Value("${info.app.name}")
    private String appInfo;
    @Value("${info.app.description}")
    private String appDescription;
    @Value("${info.app.version}")
    private String appVersion;
    @Value("${info.school.name}")
    private String schoolName;

    @Autowired
    CollegeStudent student;

    @Autowired
    StudentGrades studentGrades;

    //ApplicationContext 会自动注入到类中，你可以通过 context.getBean() 方法来访问 Spring 容器中的 Bean。
    @Autowired
    ApplicationContext context;

    @BeforeEach
    public void beforeEach() {
        count = count + 1;
        System.out.println("Testing:" + appInfo + " which is " + appDescription +
                " Version: " + appVersion + " Execution of test method: " + count);

      student.setFirstname("steven");
        student.setLastname("Roby");
        student.setEmailAddress("123@qq.com");
        studentGrades.setMathGradeResults(new ArrayList<>(Arrays.asList(100.0, 85.0, 76.50, 91.75)));
        student.setStudentGrades(studentGrades);



    }

    @DisplayName("Add greade results for student grades")
    @Test
    public void addGradeResultsForStrudentGrades () {
        assertEquals(353.25,studentGrades.addGradeResultsForSingleClass(
                student.getStudentGrades().getMathGradeResults()
        ));
    }

    @DisplayName("Add greade results for student grades not equal")
    @Test
    public void addGradeResultsForStrudentGradesNotEqual () {
        assertNotEquals(0,studentGrades.addGradeResultsForSingleClass(
                student.getStudentGrades().getMathGradeResults()
        ));
    }

    @DisplayName("Is grade greater")
    @Test
    public void isGradeGreaterStudentGrades () {
        assertTrue(studentGrades.isGradeGreater(90,75),
        "failure-should be ture");
    }
    @DisplayName("Is not grade greater")
    @Test
    public void isGradeGreaterStudentGradesFalse() {
        assertFalse(studentGrades.isGradeGreater(89,92),
                "failure -should be false");

    }

    @DisplayName("Check Null for student grades")
    @Test
    public void checkNullForStudentGrades () {
        assertNotNull(studentGrades.checkNull(student.getStudentGrades().getMathGradeResults()),
                "object should not be null");
    }

  @DisplayName("Create student wihtout grade init")
  @Test
    public void createStudentWihtoutGrade () {
        CollegeStudent studentTwo = context.getBean(CollegeStudent.class);
        studentTwo.setFirstname("2");
        studentTwo.setLastname("Roby22");
        studentTwo.setEmailAddress("233@22.com");
        assertNotNull(studentTwo.getFirstname(), "firstname should not be null");
        assertNotNull(studentTwo.getLastname(), "lastname should not be null");
        assertNotNull(studentTwo.getEmailAddress(), "email address should not be null");
        assertNull(studentGrades.checkNull(studentTwo.getStudentGrades()), "math grades should not be null");


  }

  @DisplayName("verify sutdents are prototypes")
  @Test
 public void verifySutdentsArePrototypes () {
      CollegeStudent studentTwo = context.getBean(CollegeStudent.class);
      assertNotSame(student,studentTwo);

  }

    @DisplayName("Find Grade Point Average ")
    @Test
    public void findGradePointAverage () {
        assertAll("testing all asserEquals",
                ()->assertEquals(353.25,studentGrades.addGradeResultsForSingleClass(
                        student.getStudentGrades().getMathGradeResults())),
                        ()->assertEquals(88.31,studentGrades.findGradePointAverage(
                                        student.getStudentGrades().getMathGradeResults()))
                );

    }





}