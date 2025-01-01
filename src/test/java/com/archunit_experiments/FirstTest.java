package com.archunit_experiments;

import com.archunit_experiments.domain.User;
import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@Slf4j
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

    log.info("{}", clazz.getSimpleName());
    log.info("{}", clazz.getAccessesFromSelf());
    log.info("{}", clazz.getAccessesToSelf());
    log.info("{}", clazz.getAllAccessesFromSelf());
    log.info("{}", clazz.getAllFields());
    log.info("{}", clazz.getAllClassesSelfIsAssignableTo());
    log.info("{}", clazz.getAllConstructors());
    log.info("{}", clazz.getAllMembers());
    log.info("{}", clazz.getAllRawInterfaces());
  }

  /**
   * Asserting (Architectural) Constraints
   */

  @Test
  void testServicesShouldOnlyBeAcessedByControllers() {

    JavaClasses javaClasses = new ClassFileImporter().importPackages("com.archunit_experiments");

    ArchRule myRule = classes()
      .that().resideInAnyPackage("..service..")
      .should().onlyBeAccessed().byAnyPackage("..controller..", "service..");

    myRule.check(javaClasses);

  }

}
