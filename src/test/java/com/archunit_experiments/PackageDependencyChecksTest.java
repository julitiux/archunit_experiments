package com.archunit_experiments;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class PackageDependencyChecksTest {

  @Test
  void testPackageDependencyChecks() {

    JavaClasses javaClasses = new ClassFileImporter().importPackages("com.archunit_experiments.package_dependency_checks");

    ArchRule rule = noClasses().that().resideInAPackage("..source..")
      .should().dependOnClassesThat().resideInAPackage("..foo..");

    rule.check(javaClasses);
  }
}
