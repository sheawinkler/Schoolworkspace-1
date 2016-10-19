import Prelude
import System.Environment ( getArgs )
import Data.List
import Helpers

-- The main method that will be used for testing / command line access
main = do
  args <- getArgs
  filename <- readFile (head args)
  checkersState <- readmakemovesFile filename
  printResult  (makemoves checkersState)

-- YOUR CODE SHOULD COME AFTER THIS POINT
makemoves :: (Int,[Char],[[Char]],[(Int,Int)]) -> (Int,[Char],[[Char]])

makemoves (time, captures, board, [] ) = (time, captures, board)

makemoves (time, captures, board, (moveFrom, moveTo):moves ) 
    | checkerAlive board = makemoves (newTime,newCaptures,newBoard,moves) 
    | otherwise          = resetGame (time, captures, board)
	where move = (moveFrom,moveTo)
	      (newTime,newCaptures,newBoard) = onemoving (time, captures, board, move)
			
					
					
