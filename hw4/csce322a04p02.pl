:- use_module(helpers).


test(File,Board):-
	readBoard(File,Board),
	pathOfKing(Board,_).

pathOfKing(Board,_):-

	find(Board,k,Where),
	Where == k,
	convertToCoordinate(Where,_,_).
	

nwSlide(X,Y):-
	NewX is X-1,
	NewY is Y+1,
	convertBackToNum(NewX,NewY,Out),
	isEmpty(Out).

swSlide(X,Y):-
	NewX is X-1,
	NewY is Y-1,
	convertBackToNum(NewX,NewY,Out),
	isEmpty(Out).

neSlide(X,Y):-
	NewX is X+1,
	NewY is Y-1,
	convertBackToNum(NewX,NewY,Out),
	isEmpty(Out).

seSlide(X,Y):-
	NewX is X+1,
	NewY is Y+1,
	convertBackToNum(NewX,NewY,Out),
	isEmpty(Out).
	
nwJump(X,Y):-
	NewX is X-2,
	NewY is Y+2,
	convertBackToNum(NewX,NewY,Out),
	isEmpty(Out).

swJump(X,Y):-
	NewX is X-2,
	NewY is Y-2,
	convertBackToNum(NewX,NewY,Out),
	isEmpty(Out).

neJump(X,Y):-
	NewX is X+2,
	NewY is Y-2,
	convertBackToNum(NewX,NewY,Out),
	isEmpty(Out).

seJump(X,Y):-
	NewX is X+2,
	NewY is Y+2,
	convertBackToNum(NewX,NewY,Out),
	isEmpty(Out).

%Even Row
convertToCoordinate(Num,X,Y):-
    not(Num is 5;Num is 10;Num is 15;Num is 20;Num is 25;Num is 30;Num is 35;Num is 40;Num is 45;Num is 50),
	X is mod(Num,5),
	Y is ceiling(((Num - X) / 5)+1).
	%even(Y),
	%writeln(Num),
	%writeln(X),
	%writeln(Y).
%Odd Row	
convertToCoordinate(Num,X,Y):-
    not(Num is 5;Num is 10;Num is 15;Num is 20;Num is 25;Num is 30;Num is 35;Num is 40;Num is 45;Num is 50),
	X is mod(Num,5),
	Y is ceiling(((Num - X) / 5)+1),

	X is X+1.
	%writeln(X),
	%writeln(Num),
	%writeln(Y).
	
%Odd Row
convertToCoordinate(Num,X,Y):-
	Num is 5;Num is 15;Num is 25;Num is 35;Num is 45,
	X is 5,
	%not(even(Y)),
	Y is ((Num - X) / 5)+1.
	%writeln(Num),
	%writeln(X),
	%writeln(Y).
%Even Row
convertToCoordinate(Num,X,Y):-
	Num is 10;Num is 20;Num is 30;Num is 40;Num is 50,
	X is 5,
	%even(Y),
	Y is ((Num - X) / 5)+1.
	%writeln(Num),
	%writeln(X),
	%writeln(Y).		

convertBackToNum(X,Y,Out):-
	Out is ((Y-1)*5)+X.
	