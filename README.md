This program requests a username, and takes two inputs, returning the answer as to whether or not they are anagrams. The program allows the user to continue to enter words to check until they opt to end the program. When checking words from the second run onwards, the program firstly checks if they are stored in a HashMap, and only runs the processing again if they are not. Results are stored in the 'ValuesAndResults' text file, and are appended on each run. This file already contains some examples from prior runs, but if deleted will regenerate as empty upon re-running. Unit Tests have been set up to ensure the program continues to function as expected if any changes are made in future.




Assumptions Made:\
Inputs are not case-sensitive\
Username is not unique