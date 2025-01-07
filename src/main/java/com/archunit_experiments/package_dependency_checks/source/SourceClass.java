package com.archunit_experiments.package_dependency_checks.source;


import com.archunit_experiments.package_dependency_checks.foo.FooClass;

public class SourceClass {

  public void sayHi(){
    FooClass foo = new FooClass();
    foo.sayHi();
  }
}
