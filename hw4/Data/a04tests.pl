printPaths([]).
printPaths([Path|Paths]):-
    writeln(Path),
    printPaths(Paths).

loadHelpers:-
    ['HELPERS'],
    ['PART'].

part01:-
    readBoard('BOARD',Board),
    printBoard(Board),
    percentMen(Board).

part02:-
    readBoard('BOARD',Board),
    printBoard(Board),
    setof(Path,pathOfKing(Board,Path),Paths),
    printPaths(Paths).

part03:-
    readBoard('BOARD',Board),
    printBoard(Board),
    redWin(Board).

part04:-
    readBoard('BOARD',Board),
    printBoard(Board),
    makeBoard(Board).
