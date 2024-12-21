package com.archunit_experiments;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstTest {

  @Test
  void myFirstTest() {
    System.out.println("hi");
  }

  @Test
  void importPackage() {
    JavaClasses javaClasses = new ClassFileImporter().importPackages("com.archunit_experiments");
    Assertions.assertNotNull(javaClasses);
  }

}
