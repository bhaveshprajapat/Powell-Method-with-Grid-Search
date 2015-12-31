# Powell-Method-with-Grid-Search
A method for finding minima with Powell's method. This version uses grid search

This program finds minima for a surface that can be created by a function of x and y. (f(x,y) = whatever..)

The program can successfully find simple global minima of simple surfaces in the format:

f(x,y) = (x+a)^2 + (y+b)^2
where -a and -b are the actual minima, the program's arguments can be used get more and more precise values

NB: This version uses a grid search. This make it horribly inefficient especially when fiddling around with the arguments.
When trying a new function, always try bound of +&- 10 before trying anything else.
Also keep nIter below 100,000
