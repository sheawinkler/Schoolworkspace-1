:- module( helpers,
	 [ readBoard/2
	 , printBoard/1
	 , findRow/3
	 , find/3
	 , edge/2
	 , even/1
	 , path/3
	 , increasingPath/3
	 , increasingPathStep/3
	 , ourPath/3
	 ]
    ).

readBoard(File,Board):-
    open(File,read,Input),
    readRows(Input,Board),
    close(Input).

readRows(Input,[]):-
    at_end_of_stream(Input),
    !.
readRows(Input,[Row|Rows]):-
    \+ at_end_of_stream(Input),
    read(Input,Row),
    readRows(Input,Rows).

printBoard([]).
printBoard([Row|Rows]):-
    writeln(Row),
    printBoard(Rows).

findRow([What,-|_],What,1).
findRow([-,What|_],What,1).
findRow([_,_|T],What,Where):-
    findRow(T,What,TWhere),
    Where is TWhere + 1.

find([Row|_],What,Where):-
    findRow(Row,What,Where).
find([Row|Rows],What,Where):-
    find(Rows,What,RWhere),
    length(Row,RowLength),
    Where is RWhere + RowLength/2.




	

edge(A,B):-
	slide(A,B);
	jump(A,B).

slide(A,B):-
	slideFromEven(A,B);
	slideFromOdd(A,B);
	isEmpty(B).
	
slideFromEven(A,B):-
	even(A),
	isEmpty(B).
	
slideFromOdd(A,B):-
	not(even(A)),
	isEmpty(B).
	
jump(A,B):-
	jumpFromEven(A,B);
	jumpFromOdd(A,B).
	
	
% Since Even, Check if Empty
jumpFromEven(A,B):- 
	even(A),
	evenManJumping(A),
	B is A-9; B is A-11,
	isEmpty(B).

jumpFromOdd(A,B):- 
	not(even(A)),
	oddManJumping(A),
	B= A-9;A-11,
	isEmpty(B).
%Finds if there is a man between B and A	
oddManJumping(A):-
	find( Board,r;i,A-4 );
	find( Board,r;i,A-5 ).
evenManJumping(A):-	
	find( Board,r;i,A-5 );
	find( Board,r:i,A-6 ).



isEmpty(B):-
	find(_,What,B),
	What = '-' . 

even(N) :-
     (between(0, inf, N); integer(N) ),
     0 is N mod 2.

ourPath(A,B,OurPath):-
    length(OurShortestPath,OurShortestPathLength),
    increasingPathStep(A,B,OurShortestPath),
    !,
    length(OurPath,OurShortestPathLength),
    increasingPathStep(A,B,OurPath).
    
    
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

	
