### Programming Exercise: Build a simple RMI application 

#### Exercise Definition
In this exercise, you will create a simple remote method invocation application in Java.

#### Step-by-Step Instructions

1. **Set Up Your Environment**:
   - If you have not configures your environment to program in Java, you may need to install the Java Development Kit (JDK) and set up your environment variables (paths). 

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

3. **Install Flask**:
   - In the same directory, install Flask using pip. Remember that we are in a new virtual environment:
     ```bash
     pip install Flask
     ```

4. **Compile**:
   - Compile all .java files
     ```bash
     cd src/
     javac -d ../bin *.java
     ```

5. **Run the server**:
   - On a terminal, run the server
     ```bash
     cd src/
     java -cp ../bin RMIServer
     ```
   - You will see a message like "Library RMI Server is ready."

6. **Start the RMI registry**:
   - On another terminal, start the RMI registry
     ```bash
     rmiregistry
     ```

7. **Run the client**:
   - On another terminal, run the client.
     ```bash
     java -cp ../bin RMIClient     
     ```
   - You will see a list of commands that you can run as a client.

   - Start with getting the inventory
     ```bash
     java -cp ../bin RMIClient getInventory
     ```

   - Try borrowing and returning books. You can also start another terminal with for a second client.

