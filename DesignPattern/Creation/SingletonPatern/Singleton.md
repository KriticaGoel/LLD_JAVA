1. **Default constructor**
    All user to create multi objects
2. **Private constructor**
cons: user able to create multiple objects
3. **Working for non-threaded environment**    

public static Singletonv2 getInstance() {
      if (instance == null) { // it will allow to creat only one object Failed in thread
      instance=new Singletonv2();
      }
      return instance;
      }

pons: Good if application is not using thread

cons: Bad for threaded application since in race condition multiple threads will be created

4.**Eager Initialization, worked for threaded environemnt too. but unable to pass parameter**

public static final Singletonv2 instance = new Singletonv2();

pons: if object is light and needed in everytime

cons: object created at time of clss load and consumed memory while appliation is running

5. use syncrhronised with method
pons : Thread safe
cons : Application is slow since every request is getting lock
6. Double check
pons: Thread safe and fast solution
