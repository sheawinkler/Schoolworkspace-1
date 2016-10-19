:- use_module(helpers).


test(File,Board):-
	readBoard(File,Board),
	percentMen(Board).



percentMen(Board) :-
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
