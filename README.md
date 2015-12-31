# Powell-Method-with-Grid-Search
A method for finding minima with Powell's method. This version uses grid search

This program finds minima for a surface that can be created by a function of x and y. (f(x,y) = whatever..)

The program can successfully find simple global minima of simple surfaces in the format:

f(x,y) = (x+a)^2 + (y+b)^2
where -a and -b are the actual minima, the program's arguments can be used get more and more precise values

NB: This version uses a grid search. This make it horribly inefficient especially when fiddling around with the arguments.
When trying a new function, always try bound of +&- 10 before trying anything else.
Also keep nIter below 100,000

The program requires four arguments to run. These can be set in the IDE or they can be entered via command line in the compiled application.

Argument 1 is the start point as a single integer. e.g. a value of 1 results in the start point (1,1). They starting x and y are always identical

Argument 2 is the tolerance, in form of a double. It should be set out as something like 0.001 for that tolerance.

Arguments 3 and 4 and the upper and lower bounds, they should be set out as '-10 10'; it would make sense to keep their absolute values the same. the first number is always the lower bound - therefore it should be the negative value.

Argument 5 is the nIter value for which the range of points along within the bounds around (x,y) are sliced. A value of 10 means there will be 10 slices etc.
