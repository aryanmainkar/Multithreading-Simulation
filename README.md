# Multithreading-Simulation

# MIT License

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

<h2 style = "font-size : 18px";>Program Overview </h2><ul><li> This program simulates a Trick or Treating event in which a group of Trick or Treaters visit a number of houses and collect candy. There are different types of houses, each of which gives a different type of candy. Some houses may even give a toothbrush instead of candy!</li>
<li>The program has been implemented in Java and includes several classes.</li>

<li>The main class is the TrickOrTreater class, which represents a Trick or Treater. It has a name, a path which records the route that the Trick or Treater takes, and a bucket which records the types and amount of candy collected. The TrickOrTreater class implements the Runnable interface, which allows it to be executed as a thread.</li>

<li>The House class is an abstract class that represents a house that the Trick or Treaters visit. It has a name and a HashMap that contains the different types and amount of candy available. The ringDoorbell method is an abstract method that is implemented differently by each type of house.</li>

<li>The CandyHouse class extends the House class and gives out random types of candy from its candy list.
The ChocolateHouse class extends the House class and gives out chocolate candy.
The ToothbrushHouse class extends the House class and gives out toothbrushes.
The Halloween class is the main class that initializes the Trick or Treaters and the Houses, and executes the threads using ExecutorService.</li>

<li>The program uses multithreading to simulate the Trick or Treating event. Each Trick or Treater is executed as a thread, and the Houses are accessed concurrently.
The program outputs the path taken by each Trick or Treater and the types and amount of candy collected in a file named "trick_or_treat.txt".</li>
</ul>

<h2 style = "font-size : 18px";>How do threads move?</h2><ul><li>The TrickOrTreater class implements the Runnable interface, which means that it can be run in a separate thread. In the main method of the HalloweenSimulation class, multiple instances of TrickOrTreater are created and added to an ArrayList. Then, a fixed thread pool with a maximum of 5 threads is created using the ExecutorService interface. The TrickOrTreater instances are submitted to the thread pool using the execute() method, which starts a new thread for each instance.</li>

<li>Each TrickOrTreater instance walks to each house in the ListOfHouses, which is an ArrayList of House objects. The TrickOrTreater walks to each house by calling the Walk() method, which uses a for loop to add periods to the path string and sleep for a random amount of time between 0 and 1500 milliseconds. After the TrickOrTreater reaches a house, it calls the ringDoorbell() method of the House object, passing itself as an argument. The ringDoorbell() method of each House object is implemented differently depending on the type of the house.</li>

<li>The ToothbrushHouse class is one type of House object. When a TrickOrTreater reaches a ToothbrushHouse, it calls the ringDoorbell() method, which sleeps for 3 seconds and then returns the string "ToothBrush". The synchronized keyword is used to ensure that the TrickOrTreater instances take turns accessing the ringDoorbell() method of the ToothbrushHouse object.</li>

<li>After visiting all the houses, each TrickOrTreater instance increments the static variable ImDone by 1 in a synchronized block. The main thread waits for all the TrickOrTreater threads to finish by checking the value of ImDone and sleeping for 1 second until all the threads have finished.</li>

<li>Overall, the threads move asynchronously, with each TrickOrTreater instance running in its own thread and visiting each house in the ListOfHouses independently. The use of a thread pool ensures that the number of threads running simultaneously is limited, preventing resource exhaustion and ensuring that the program runs efficiently.</li></ul>

<h2 style = "font-size : 18px";>Tools Used : </h2><ul><li>Java programming language.</li><li>VSCode IDE for development.</li><li>GitHub for version control and collaboration</li>
</ul>

<h2 style = "font-size : 18px";>Code Explanation</h2><ul><li>The provided code is a simulation of trick-or-treating, where a group of TrickOrTreater objects visit houses to get candy. The houses are represented by the abstract class House, which has a method ringDoorbell that returns a String representing the candy type given by the house. The TrickOrTreater class represents the children visiting the houses, and has a method run that simulates the walking and visiting of houses, as well as keeping track of the candy they receive in a HashMap.</li>

<li>The code also includes two concrete House classes, CandyHouse and ToothbrushHouse, which both extend the House class and override the ringDoorbell method to return specific candy types.</li>

<li>The main function creates a list of houses, creates a thread for each TrickOrTreater object, and executes them using a thread pool. After all threads have finished executing, the program prints out the candy received by each TrickOrTreater.</li></ul>

<h2 style = "font-size : 18px";>Analysis</h2><ul><li>The code is well-structured and follows good object-oriented programming principles. The use of abstract and concrete classes allows for easy extension and modification of the House classes, and the use of threads allows for concurrent execution of TrickOrTreater objects. The use of a HashMap to keep track of candy is a good choice, as it allows for efficient lookup and modification of candy counts.</li>
</ul>

<h2 style = "font-size : 18px";>Conclusion</h2><ul>Overall, the code provides a good simulation of trick-or-treating and demonstrates good programming principles. However, it could benefit from better error handling and clearer explanations of certain choices made in the code.<ul>
