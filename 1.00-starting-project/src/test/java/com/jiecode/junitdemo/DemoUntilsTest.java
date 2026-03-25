package com.jiecode.junitdemo;


import com.luv2code.junitdemo.DemoUtils;
import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class DemoUntilsTest {
/*
    DemoUtils demoUtils;
//每个测试开始都会执行
    @BeforeEach
    void setupBefore() {
        demoUtils = new DemoUtils();
        System.out.println("@BeforeEach execurtes before the execution of eache test method");
    }

  @AfterEach
  void tearDownAfter() {
        System.out.println("@AfterEach execurtes after the execution of eache test method");

  }


  @BeforeAll
  static void setup() {
        System.out.println("@BeforeAll execurtes before all the test method");

  }
  @AfterAll
  static void thearDownAfterAll(){
        System.out.println("@AfterAll execurtes after all the test method");
  }
*/

     @Test

     @DisplayName("Equlas or not Equals")
    void testEqualsAndNotEquals() {

         DemoUtils demoUtils = new DemoUtils();

         assertEquals(6,demoUtils.add(2,4),"2+4 must be 6");
         assertNotEquals( 6, demoUtils.add(1,9),"1+9 must be 10");
    }


    @Test

    @DisplayName("NullAndNotEquals")
    void testNullAndNotEquals() {

        DemoUtils demoUtils = new DemoUtils();

        String str1 = null;
        String str2 = null;

        assertNull(demoUtils.checkNull(str1),"object should be null");
        assertNull(demoUtils.checkNull(str2),"object should not be null");
    }

    @Test
    @DisplayName("Same And Not Same")
    void testSameAndNotSame() {


        String str1 = "luv2code";
        DemoUtils demoUtils = new DemoUtils();
        assertSame(demoUtils.getAcademy(),demoUtils.getAcademyDuplicate(),"Object should refer to asme object");
        assertNotSame(str1,demoUtils.getAcademy(),"Object should not refer to asme object");
    }

    @Test
    @DisplayName("Ture And False")
    void testTureAndFalse() {
         DemoUtils demoUtils = new DemoUtils();
         int gradeOne=10;
         int gradeTwo=5;

         assertTrue(demoUtils.isGreater(gradeOne,gradeTwo),"This should return true");
         assertFalse(demoUtils.isGreater(gradeTwo,gradeOne),"This should return false");
    }

    @Test
    @DisplayName("Array Equals")
    void testArrayEquals() {
         DemoUtils demoUtils = new DemoUtils();
         String[] stringArray ={"A","B","C"};

         assertArrayEquals(stringArray,demoUtils.getFirstThreeLettersOfAlphabet(),"Array should be equals");
    }
   @Test
    @DisplayName("Iterable Equals")
    void testIterableEquals() {
         DemoUtils demoUtils = new DemoUtils();
         List<String> theList = Arrays.asList("luv","2","code");
         assertIterableEquals(theList,demoUtils.getAcademyInList(),"Expected list should be same as actual list");
   }

   @Test
    @DisplayName("Line Mathch")
   void testLineMathch() {
       DemoUtils demoUtils = new DemoUtils();
       List<String> theList = Arrays.asList("luv","2","code");
       assertLinesMatch(theList,demoUtils.getAcademyInList(),"Expected list should be same as actual list");
   }

   @Test
    @DisplayName("Throws and Does Not throw")
    void testThrowsAndDoesNotThrow() {
         DemoUtils demoUtils = new DemoUtils();
         assertThrows(Exception.class, () -> {
             demoUtils.throwException(-1);},"should throw exceptions");
       assertDoesNotThrow( () -> {
           demoUtils.throwException(5);},"should notthrow exceptions");
   }
@Test
    @DisplayName("Timeout")
    void testTimeout() {
         DemoUtils demoUtils = new DemoUtils();
         assertTimeout(Duration.ofSeconds(3),()->{
             demoUtils.checkTimeout();},"Method should execute in 3 seconds");

}


}
