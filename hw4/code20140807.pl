% facts about the graph in Problem 3.4, Page 107 of Algorithms by Dasgupta, Papadimitriou, and Vazirani
edge(a,c).
edge(a,h).
edge(b,a).
edge(b,g).
edge(c,d).
edge(d,f).
edge(e,a).
edge(e,i).
edge(f,j).
edge(g,i).
edge(h,g).
edge(i,h).
edge(j,c).

% simple, depth-first path finding that might get caught in cycles
path(A,A,[A]).
path(A,B,[A|Path]):-
    edge(A,C),
    path(C,B,Path).

% breadth-first path finding that should avoid simple cycles
increasingPath(A,B,IncreasingPath):-
    length(IncreasingPath,_),
    increasingPathStep(A,B,IncreasingPath).

increasingPathStep(A,A,[A]).
increasingPathStep(A,B,[A|Path]):-
    edge(A,C),
    increasingPath(C,B,Path).
