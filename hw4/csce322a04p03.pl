:- use_module(helpers).


newTest(File,Board):-
	readBoard(File,Board),
	redWin(Board).
	

redWin(Board):-
	whitePieces(Board);
	legalMoves(Board).
	
legalMoves(Board):-
	%Need to recurse to check w until match has been found
	find(Board,w;k,MovingFrom),
	edge(MovingFrom, _).




%Determines if any white pieces are still on the board
whitePieces(Board):-
	    flattenLists(Board,Out),
		findall(X, (member(X, Out), ( X ==k ;X==w) ), Xs ),
		sizeOf(Xs,N),
		N<1.
		
sizeOf([],0).
sizeOf([_|T],N) :- 
		sizeOf(T,N1), N is N1+1.
	
flattenLists([],[]).

flattenLists([Head|InTail],Out) :-
	flatten(Head,FlatHead),
	flatten(InTail,OutTail),
	append(FlatHead,OutTail,Out).

flattenLists([Head|Intail],[Head|OutTail]) :-
	Head \= [],
	Head \= [_|_],
	flatten(Intail,OutTail).