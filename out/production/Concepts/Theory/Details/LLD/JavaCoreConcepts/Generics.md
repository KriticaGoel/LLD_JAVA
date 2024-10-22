## Agenda

* [Generics](#Generics)
* [Generic Method](#generic-method)
* [Generic Static Method](#generic-static-method)
* [Extends keyword in Generics](#extends-keyword-in-generics)
* [Function Interface](#function-interface)

**Before Generics**:
If we are storing any value a variable and using it in multiple ways, then at compile time compiler will not validate
it.
For example:

```java
class Pair {
    Object first;
    Object second;
}
```

Here the object first and object second can store any type of datatype.

```java
int a = (int) Pair.first;
```

**Problems**:

1. Compiler is not validating it at compile time and got run time errors.
2. We need to typecast the variable every time before using it

### Generics

> Generics were added to Java to provide compile-time type checking
> removing the risk of ClassCastException that was common while working with collection classes

Before generics, we can store any type of objects in the collection, i.e., non-generic. Now generics force the java
programmer to store a specific type of objects.

Allow us to define a class with parameterized data type

```java
class Pair<F, S> {
    F first;
    S second;

    Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public void getFirst() {
        return this.first;
    }
}

```

F and S is a datatype here rest is normal things

```java
//this is supported by java to support backward competitive 
// and is user is not specifying the data type Jva take is as Object only 
// and user needs to typecast it before use.

Pair p = new Pair(1.0, 2.0);

Pair<Double, Double> pDouble = new Pair(1.0, 2.0);
Double first = pDouble.first;
```

Here we are casting at compile time, so compile time valiation will work.

### Generic Method

```java
public class Pair<K, V> {
    private K key;
    private V value;

    public void setKey(K key) {
        this.key = key;
    }

    public K getKey() {
        return key;
    }

}
```

### Generic Static Method

```java
public static <K, V, Z> Z doSomething(K key, V value) {
    System.out.println("key: " + key + " value: " + value);
    return (Z) BigInteger.ONE;
}
```

### Extends keyword in Generics

```java
public class Instructor extends Users {

    double avgRating;

    public Instructor(String FirstName, String LastName, int Age, double avgRating) {
        super(FirstName, LastName, Age);
        this.avgRating = avgRating;
    }

    public void scheduleSession() {
        System.out.println("Session scheduled");
    }
}
```

```java
public class Users {

    String FirstName;
    String LastName;
    int Age;

    public Users(String FirstName, String LastName, int Age) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Age = Age;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void login() {
        System.out.println("Login");
    }

}
```

Without generics got error while calling printUser method having argument of parent class with child class argument
instructors)

```java
public class App {

    public void initilaize() {
        List<Instructor> instructors = new ArrayList<Instructor>();
        instructors.add(new Instructor("Kritica", "Goel", 27, 5));
        instructors.add(new Instructor("Sachin", "Goel", 30, 4.7));

        //instroctor is a child class of Users
        printUser(instructors);
    }

    public void printUser(List<Users> users) {
        for (Users user : users) {
            System.out.println(user.getFirstName());
            user.login();
        }
    }
}
```

![withoutGeneric.png](..%2F..%2F..%2Fresources%2FwithoutGeneric.png)

Solution:
Add generic and use extends Child class to access all methods of parent and child

```java
public <E extends Instructor> void printUser(List<E> users) {
    for (E user : users) {
        System.out.println(user.getFirstName());
        user.login();
        user.scheduleSession();
    }
}
```

```java
public class App {

    public void initilaize() {
        List<Instructor> instructors = new ArrayList<Instructor>();
        instructors.add(new Instructor("Kritica", "Goel", 27, 5));
        instructors.add(new Instructor("Sachin", "Goel", 30, 4.7));

        //instroctor is a child class of Users
        printUser(instructors);
    }

    public <E extends Instructor> void printUser(List<E> users) {
        for (E user : users) {
            System.out.println(user.getFirstName());
            user.login();
            user.scheduleSession();
        }
    }
}
```

* Arguments: Accept class and its child class
* Method Calling: Child class method can't be called. same as inheritance

```java
public class App {

    public void initialize() {
        List<TemporaryInstructor> temporaryInstructors = new ArrayList<TemporaryInstructor>();
        temporaryInstructors.add(new TemporaryInstructor("Kritica", "Goel", 27, 5, true));
        temporaryInstructors.add(new TemporaryInstructor("Sachin", "Goel", 30, 4.7, false));

        List<Users> users = new ArrayList<Users>();
        users.add(new Users("Kritica", "Goel", 27));
        users.add(new Users("Sachin", "Goel", 30));


        List<Instructor> instructors = new ArrayList<Instructor>();
        instructors.add(new Instructor("Kritica", "Goel", 27, 5));
        instructors.add(new Instructor("Sachin", "Goel", 30, 4.7));

        //Users is a paerent class of Instructor
        //printUser(users);-- not allow

        // Instructor is a clas defined in printUser argument
        printUser(instructors);
        //TemporaryInstructor is a child class of Instructor
        printUser(temporaryInstructors);// child class can be pass as argument temporaryInstructors is a child class of Instructor
    }

    public <E extends Instructor> void printUser(List<E> users) {
        for (E user : users) {
            System.out.println(user.getFirstName());
            user.login(); // Define in parent class of Instructor
            user.scheduleSession(); // Define in Instructor class
            //user.isTemp(); Define in child class of Instructor. Child class method can't be called
        }
    }
}
```

### Function Interface

```java
Function<Integer, String> function = new Function<Integer, String>() {
    @Override
    public String apply(Integer integer) {
        return integer.toString();
    }
};
```

### Optional

