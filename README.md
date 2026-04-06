### Programming Exercise: Build a simple RMI application 

#### Exercise Definition
In this exercise, you will create a simple remote method invocation application in Java.

#### Step-by-Step Instructions

1. **Set Up Your Environment**:
   - If you have not configured your environment to program in Java, you may need to install the Java Development Kit (JDK) and set up your environment variables (paths). 

2. **Clone the repository**:
   - On the terminal, create a new directory (e.g. exercise_rmi) for your project and navigate into it:
     ```bash
     mkdir exercise_rmi
     cd exercise_rmi
     ```
   - Get the files:
     ```bash
     git clone https://github.com/YOUR-USERNAME/YOUR-REPOSITORY  
     ```

3. **Compile**:
   - Compile all .java files
     ```bash
     javac -d ../bin *.java
     ```

4. **Run the server**:
   - On a terminal, run the server
     ```bash
     java -cp ../bin RMIServer
     ```
   - You will see a message like "Library RMI Server is ready."

5. **Start the RMI registry**:
   - On another terminal, start the RMI registry
     ```bash
     rmiregistry
     ```

6. **Run the client**:
   - On another terminal, run the client.
     ```bash
     java -cp ../bin RMIClient     
     ```
   - You will see a list of commands that you can run as a client.

   - Start with getting the inventory
     ```bash
     java -cp ../bin RMIClient getInventory
     ```

   - Try borrowing and returning books. You can also start another terminal for a second client.


#### Conclusion
You have successfully implemented an RMI application. This exercise should have reinforced your understanding of object oriented design, inheritance, overloading, and interfaces.

