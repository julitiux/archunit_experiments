package com.archunit_experiments;

import com.archunit_experiments.domain.User;
import com.tngtech.archunit.core.domain.JavaClass;
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

  @Test
  void importPAth() {
    JavaClasses javaClasses = new ClassFileImporter().importPath("build/classes/java/test/com/archunit_experiments/");
    Assertions.assertNotNull(javaClasses);
  }

  @Test
  void getClazz() {
    JavaClasses javaClasses = new ClassFileImporter().importPackages("com.archunit_experiments");
    JavaClass clazz = javaClasses.get(User.class);

    System.out.println(clazz.getSimpleName());
    System.out.println(clazz.getAccessesFromSelf());
    System.out.println(clazz.getAccessesToSelf());
    System.out.println(clazz.getAllAccessesFromSelf());
    System.out.println(clazz.getAllFields());
    System.out.println(clazz.getAllClassesSelfIsAssignableTo());
    System.out.println(clazz.getAllConstructors());
    System.out.println(clazz.getAllMembers());
    System.out.println(clazz.getAllRawInterfaces());
  }

}
