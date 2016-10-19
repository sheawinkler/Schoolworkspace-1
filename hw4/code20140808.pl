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

ourPath(A,B,OurPath):-
    length(OurShortestPath,OurShortestPathLength),
    increasingPathStep(A,B,OurShortestPath),
    !,
    length(OurPath,OurShortestPathLength),
    increasingPathStep(A,B,OurPath).

increasingPath(A,B,IncreasingPath):-
    length(IncreasingPath,_),
    increasingPathStep(A,B,IncreasingPath).

increasingPathStep(A,A,[A]).
increasingPathStep(A,B,[A|Path]):-
    edge(A,C),
    increasingPath(C,B,Path).
