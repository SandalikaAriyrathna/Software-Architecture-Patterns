public class SingletonExample {

    // Basic Singleton class
    public static class Singleton {
        private static Singleton uniqueInstance;
        private Singleton() {}
        public static Singleton getInstance() {
            if (uniqueInstance == null) {
                uniqueInstance = new Singleton();
            }
            return uniqueInstance;
        }
        public void singletonOperation() {
            System.out.println("Singleton operation");
        }
        public String getSingletonData() {
            return "Singleton Data";
        }
    }

    // Thread-safe Singleton class
    public static class ThreadSafeSingleton {
        private static volatile ThreadSafeSingleton uniqueInstance;
        private ThreadSafeSingleton() {}
        public static ThreadSafeSingleton getInstance() {
            if (uniqueInstance == null) {
                synchronized (ThreadSafeSingleton.class) {
                    if (uniqueInstance == null) {
                        uniqueInstance = new ThreadSafeSingleton();
                    }
                }
            }
            return uniqueInstance;
        }
        public void singletonOperation() {
            System.out.println("Thread-safe Singleton operation");
        }
        public String getSingletonData() {
            return "Thread-safe Singleton Data";
        }
    }

    // Test class for Singleton pattern
    public static class TestSingleton {
        public static void main(String[] args) {
            Singleton instance1 = Singleton.getInstance();
            Singleton instance2 = Singleton.getInstance();

            instance1.singletonOperation();
            System.out.println(instance1.getSingletonData());

            if (instance1 == instance2) {
                System.out.println("Both instances are the same");
            } else {
                System.out.println("Instances are different");
            }

            Thread thread1 = new Thread(new TestThreadSafeSingleton());
            Thread thread2 = new Thread(new TestThreadSafeSingleton());

            thread1.start();
            thread2.start();
        }
    }

    // Runnable class for testing thread-safe Singleton
    public static class TestThreadSafeSingleton implements Runnable {
        @Override
        public void run() {
            ThreadSafeSingleton instance = ThreadSafeSingleton.getInstance();
            instance.singletonOperation();
            System.out.println(instance.getSingletonData());
        }
    }
}


// SingletonExample Class
// This is the outer class that contains all the other classes.

// Basic Singleton Class
// This class ensures that only one instance of the class can be created.

// uniqueInstance: A private static variable that holds the single instance of the class.
// Singleton(): A private constructor to prevent other classes from instantiating the Singleton class directly.
// getInstance(): A public static method that returns the single instance of the class. If the instance doesn't exist, it creates one.
// singletonOperation(): A sample method to demonstrate functionality.
// getSingletonData(): Another sample method to demonstrate functionality.

// Thread-Safe Singleton Class
// This class ensures that only one instance is created, even in a multi-threaded environment.

// uniqueInstance: A private static volatile variable to hold the single instance of the class.
// ThreadSafeSingleton(): A private constructor to prevent other classes from instantiating the ThreadSafeSingleton class directly.
// getInstance(): A public static method that returns the single instance of the class, using double-checked locking to ensure thread safety.
// singletonOperation(): A sample method to demonstrate functionality.
// getSingletonData(): Another sample method to demonstrate functionality.

// TestSingleton Class
// This class contains the main method to test the Singleton implementations.

// main(String[] args): The main method tests both the basic and thread-safe Singleton implementations.
// Singleton instance1 and instance2: Tests if both references point to the same instance.
// Thread thread1 and thread2: Creates and starts threads to test the thread-safe Singleton implementation.

// TestThreadSafeSingleton Class
// This class implements the Runnable interface to test the thread-safe Singleton.

// run(): The run method gets the thread-safe Singleton instance and calls its methods to demonstrate thread safety.