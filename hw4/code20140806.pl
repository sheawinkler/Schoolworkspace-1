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
