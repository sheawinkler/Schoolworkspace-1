import Prelude
import System.Environment ( getArgs )
import Data.List
import Helpers

-- The main method that will be used for testing / command line access
main = do
  args <- getArgs
  filename <- readFile (head args)
  checkersState <- readresetFile filename
  printResult  (reset checkersState)

-- YOUR CODE SHOULD COME AFTER THIS POINT
reset :: (Int, [Char], [[Char]]) -> (Int, [Char], [[Char]])


reset (a,b,c) = (3600,[],[
						  "-r-r-r-r-r",
						  "r-r-r-r-r-",
						  "-r-r-r-r-r",
						  "r-r-r-r-r-",
						  "----------",
					      "----------",
                          "-w-w-w-w-w",
                          "w-w-w-w-w-",
                          "-w-w-w-w-w",
                          "w-w-w-w-w-"
                          ])