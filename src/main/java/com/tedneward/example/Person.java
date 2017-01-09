package com.tedneward.example;

import java.beans.*;
import java.util.*;

public class Person implements Comparable<Person>{
  private int age;
  private String name;
  private double salary;
  private String ssn;
  private boolean propertyChangeFired = false;

  //private static int count;
  
  public Person() {
    this("", 0, 0.0d);
  }
  
  public Person(String n, int a, double s) {
    //count++;
    name = n;
    age = a;
    salary = s;
  }

  /* 
    Setters
  */

  public void setAge(int age) {
    if (age < 0) {
      throw new IllegalArgumentException("Not a valid age: " + age);
    }
    this.age = age;
  }
  public void setName(String name) {
    if (name == null) {
      throw new IllegalArgumentException("name must not be null");
    }
    this.name = name;
  }

  public void setSalary(double value) {
    this.salary = value;
  }

  public void setSSN(String value) {
    String old = ssn;
    ssn = value;
    
    this.pcs.firePropertyChange("ssn", old, value);
    propertyChangeFired = true;
  }

  /*
    Getters
  */

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public double getSalary() {
    return salary;
  }

  public String getSSN() {
    return ssn;
  }

  public boolean getPropertyChangeFired() {
    return propertyChangeFired;
  }

  public static ArrayList<Person> getNewardFamily() {
    ArrayList<Person> newardFamily = new ArrayList<Person>();
    newardFamily.add(new Person("Ted", 41, 250000));
    newardFamily.add(new Person("Charlotte", 43, 150000));
    newardFamily.add(new Person("Michael", 22, 10000));
    newardFamily.add(new Person("Matthew", 15, 0));
    return newardFamily;
  }

  public int count() {
    return 1;
  }

  public boolean equals(Object other) {
    if (other instanceof Person) {
      Person newOther = (Person)other;
      return this.name.equals(newOther.name) && this.age == newOther.age;
    }
    return false;
    
  }

  public double calculateBonus() {
    return salary * 1.10;
  }
  
  public String becomeJudge() {
    return "The Honorable " + name;
  }
  
  public int timeWarp() {
    return age + 10;
  }
  
  public String toString() {
    return "[Person name:" + name + " age:" + age + 
      " salary:" + salary + "]";
  }

  public int compareTo(Person other) {
    if (other.salary - this.salary < 0){
      return -1;
    } else if (other.salary - this.salary > 0) {
      return 1;
    } else {
      return 0;
    }
  }


  public static class AgeComparator implements Comparator<Person> {

    public int compare(Person p1, Person p2) {
      return p1.getAge() - p2.getAge();
    }
  }





  // PropertyChangeListener support; you shouldn't need to change any of
  // these two methods or the field
  //
  private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
  public void addPropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.addPropertyChangeListener(listener);
  }
  public void removePropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.removePropertyChangeListener(listener);
  }
}
