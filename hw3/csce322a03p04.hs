import Prelude
import System.Environment ( getArgs )
import Data.List
import Helpers

-- The main method that will be used for testing / command line access
main = do
  args <- getArgs
  filename <- readFile (head args)
  checkersState <- readmovebothFile filename
  printResult  (moveboth checkersState)

-- YOUR CODE SHOULD COME AFTER THIS POINT
moveboth :: (Int,[Char],[[Char]],[(Int,Int)]) -> (Int,[Char],[[Char]])
	
moveboth (time, captures, board, [] ) = (time, captures, board)

moveboth (time, captures, board, (moveFrom, moveTo):moves ) 
    | checkerAlive board = moveboth (newTime,newCaptures,newBoard,moves) 
    | otherwise          = resetGame (time, captures, board)
	where	move = (moveFrom,moveTo)
		(newTime,newCaptures,newBoard) = onemoving (time, captures, board, move)
		(bTime,bCaptures,bBoard) = blackAttempt (time, captures, board)