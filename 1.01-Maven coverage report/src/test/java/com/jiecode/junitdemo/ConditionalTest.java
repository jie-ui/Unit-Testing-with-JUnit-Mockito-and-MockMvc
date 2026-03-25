package com.jiecode.junitdemo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class ConditionalTest {

    @Test
    @Disabled("don't run null JIRA#123 os resolved")
    void basicTest(){
       //execute method and perform asserts

    }



    @Test
    @EnabledOnOs(OS.MAC)
    void testForMacOnliy(){
        //execute method and perform asserts

    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testForWindowsOnliy(){
        //execute method and perform asserts

    }

}
