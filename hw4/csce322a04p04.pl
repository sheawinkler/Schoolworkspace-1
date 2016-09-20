:- use_module(helpers).

makeBoard(Board):-
		%Checking if at least 5% of men are on board
	    flattenList(Board,Out),
		findall(X, (member(X, Out), ( X ==r ;X==w) ), Xs ),
		size(Xs,N),
		N>4.
	


size([],0).
size([_|T],N) :- 
		size(T,N1), N is N1+1.


flattenList([],[]).

flattenList([Head|InTail],Out) :-
	flatten(Head,FlatHead),
	flatten(InTail,OutTail),
	append(FlatHead,OutTail,Out).

flattenList([Head|Intail],[Head|OutTail]) :-
	Head \= [],
	Head \= [_|_],
	flatten(Intail,OutTail).
