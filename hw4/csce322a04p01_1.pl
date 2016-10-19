:- use_module(helpers).


test(File,Board):-
	readBoard(File,Board),
	percentMen(Board).
	


percentMen(Board) :-	
		flatten(Board,Out),
		findall(X, (member(X, Out), ( X =='r' ;X=='w') ), NewValues ),
		writeln(NewValues).

flatten([],[]).

flatten([Head|InTail],Out) :-
	flatten(Head,FlatHead),
	flatten(InTail,OutTail),
	append(FlatHead,OutTail,Out).
	
flatten([Head|Intail],[Head|OutTail]) :-
	Head \= [],
	Head\= [_|_],
	flatten(Intail,OutTail).
