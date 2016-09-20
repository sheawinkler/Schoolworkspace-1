module Helpers
( printBoard
, readonemoveFile
, readresetFile
, readmakemovesFile
, readmovebothFile
, printResult
, getPos
, getPosRow
, setPos
, checkerAlive
, resetGame
, setPosRow
, onemoving
, kingAlive
, blackAttempt
, moveClosest
, moveRandom
) where

import Data.Char
import Prelude
import Test.QuickCheck
import System.Random



printBoard :: [[Char]] -> IO ()
printBoard [] 	       = print ""
printBoard (row:rows)  = do
	      	       	 print row
			 printBoard rows

readonemoveFile :: String -> IO (Int, [Char], [[Char]], (Int,Int))
readonemoveFile = readIO

readresetFile :: String -> IO (Int, [Char], [[Char]])
readresetFile = readIO

readmakemovesFile :: String -> IO (Int, [Char], [[Char]], [(Int,Int)])
readmakemovesFile = readIO

readmovebothFile :: String -> IO (Int, [Char], [[Char]],[(Int,Int)])
readmovebothFile = readIO

printResult :: (Int, [Char], [[Char]]) -> IO ()
printResult (time,captured,board) = do
	    			    print "Time Remaining"
				    print time
				    print "Captured Pieces"
				    print captured
				    print "Board"
				    printBoard board
				    
				    
				    

getPos :: Int -> [[Char]] -> Char
getPos p (row:rows)
       | (p <= spaces) && evenRow = getPosRow p row
       | (p <= spaces) && oddRow  = getPosRow p (tail row)
       | otherwise                = getPos (p - spaces) rows
       where evenRow 		  = (mod (length rows) 2) == 0
             oddRow  		  = (mod (length rows) 2) == 1
             spaces  		  = (div (length row) 2)

getPosRow :: Int -> [Char] -> Char
getPosRow 1 row = (head row)
getPosRow c row = (getPosRow (c-1) (tail (tail row) ) )

setPos :: Int -> [[Char]] -> Char -> [[Char]]
setPos p (row:rows) v
       | (p <= spaces) && evenRow = [(setPosRow p row v)] ++ rows
       | (p <= spaces) && oddRow  = [(head row):(setPosRow p (tail row) v)] ++ rows
       | otherwise                = [row] ++ (setPos (p - spaces) rows v)
       where evenRow = (mod (length rows) 2) == 0
             oddRow  = (mod (length rows) 2) == 1
             spaces  = (div (length row) 2)

setPosRow :: Int -> [Char] -> Char -> [Char]
setPosRow 1 str ch = ch:(tail str)
setPosRow p str ch = [next]++[second]++(setPosRow (p-1) (tail (tail str)) ch)
	  where next   = head str
          	second = head (tail str)

checkerAlive :: [[Char]] -> Bool
checkerAlive board 
			| elem 'r' $ concat board = True
			| elem 'i' $ concat board = True
			| otherwise = False
			
resetGame :: (Int, [Char], [[Char]]) -> (Int, [Char], [[Char]])
resetGame (a,b,c) = (3600,[],[
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
                          
kingAlive :: [[Char]] -> Bool
kingAlive board 
			| elem 'k' $ concat board = True
			| otherwise = False         
       
 

       
moveClosest :: (Int,[Char],[[Char]]) -> (Int,[Char],[[Char]])
moveClosest  (time,captures,board)  = (time,captures,board) 

moveRandom :: (Int,[Char],[[Char]]) -> (Int,[Char],[[Char]])
moveRandom  (time,captures,board) = (time,captures,board) 
	  
          
blackAttempt :: (Int,[Char],[[Char]]) -> (Int,[Char],[[Char]])

blackAttempt   (time,captures,board) 
	| kingAlive board == True = moveClosest ( time,captures,board)
	| otherwise = moveRandom (time,captures,board)


                		
			
onemoving :: (Int,[Char],[[Char]],(Int,Int)) -> (Int,[Char],[[Char]])
			
onemoving 	(time,captures,board,(fromPiece,toPiece)) 
	| toPiece <= 0 =(time-30,captures,board)
	| toPiece > 50 =(time-30,captures,board)
	| ( ( (posTo == 'r') || (posTo == 'i') ) && ( (posFrom == 'r') || (posFrom == 'i') ) ) =(time-20,captures,board)
	| ( ( (posTo == 'w') || (posTo == 'k') ) && ( (posFrom == 'w') || (posFrom == 'k') ) ) =(time-20,captures,board)
	| ( ( (posTo == 'r') || (posTo == 'i') ) && ( (posFrom == 'w') || (posFrom == 'k') ) ) =(time-10,captures,board)
	| ( ( (posTo == 'w') || (posTo == 'k') ) && ( (posFrom == 'r') || (posFrom == 'i') ) ) =(time-10,captures,board)
	
	| (posFrom == 'w') && (posTo == '-') && (toPiece < 6 ) && (leftOrRight == 9) && (oddLessThan <=5) = (time-5,captureNE,kingPromoNEJump)
	| (posFrom == 'w') && (posTo == '-') && (toPiece < 6 ) && (leftOrRight == 11) && (oddLessThan <=5) = (time-5,captureNW,kingPromoNWJump)
	| (posFrom == 'w') && (posTo == '-') && (toPiece < 6 ) = (time -1,captures,kingPromo)
	
	| (posFrom == 'r') && (posTo == '-') && (toPiece >45 ) && (leftOrRight == 9) && (oddLessThan >5) = (time-5,captureSW,kingPromoSWJump)
	| (posFrom == 'r') && (posTo == '-') && (toPiece >45 ) && (leftOrRight == 11) && (oddLessThan >5) = (time-5,captureSE,kingPromoSEJump)
	| (posFrom == 'r') && (posTo == '-') && (toPiece >45 ) = (time -1,captures,kingPromo2)
	
	
	| (posFrom == 'w') && (posTo == '-') && (leftOrRight == 9) && (oddLessThan <=5)  = (time-5,captureNE,removedneGuy) --if from is odd, this should work..
	| (posFrom == 'w') && (posTo == '-') && (leftOrRight == 9) && (oddLessThan >5)  = (time-5,captureNE2,removedne2Guy) --This will be for even..
	| (posFrom == 'w') && (posTo == '-') && (leftOrRight == 11)&& (oddLessThan <=5)  = (time-5,captureNW,removednwGuy) --if from is odd, this should work..
	| (posFrom == 'w') && (posTo == '-') && (leftOrRight == 11)&& (oddLessThan >5)  = (time-5,captureNW2,removednw2Guy) --This will be for even..
	| (posFrom == 'r') && (posTo == '-') && (leftOrRight == 9) && (oddLessThan >5)   = (time-5,captureSW,removedswGuy) --if from is even, this should work..
	| (posFrom == 'r') && (posTo == '-') && (leftOrRight == 9) && (oddLessThan <=5)   = (time-5,captureSW2,removedsw2Guy) --This will be for odd..
	| (posFrom == 'r') && (posTo == '-') && (leftOrRight == 11)&& (oddLessThan >5)  = (time-5,captureSE,removedseGuy) --if from is even, this should work..
	| (posFrom == 'r') && (posTo == '-') && (leftOrRight == 11)&& (oddLessThan <=5)  = (time-5,captureSE2,removedse2Guy) --This will be for odd..
	
	| ( (posFrom == 'k') || (posFrom == 'i') ) && (posTo == '-') && ( leftOrRight == 11) && (upOrDown > 0) && (oddLessThan <=5) = (time-5,captureNW,removednwGuy) -- > is up and 11 is left (odd row)
	| ( (posFrom == 'k') || (posFrom == 'i') ) && (posTo == '-') && ( leftOrRight == 9)  && (upOrDown > 0) && (oddLessThan <=5) = (time-5,captureNE,removedneGuy) -- > is up and 9 is right (odd row)
	| ( (posFrom == 'k') || (posFrom == 'i') ) && (posTo == '-') && ( leftOrRight == 11) && (upOrDown < 0) && (oddLessThan <=5) = (time-5,captureSE2,removedse2Guy) -- down is > and 11 is left (odd row)
	| ( (posFrom == 'k') || (posFrom == 'i') ) && (posTo == '-') && ( leftOrRight == 9)  && (upOrDown < 0) && (oddLessThan <=5) = (time-5,captureSW2,removedsw2Guy) -- down is > and 9 is right (odd row)

	| ( (posFrom == 'k') || (posFrom == 'i') ) && (posTo == '-') && ( leftOrRight == 11) && (upOrDown > 0) && (oddLessThan >5) = (time-5,captureNW2,removednw2Guy) -- > is up and 11 is left  (even row)
	| ( (posFrom == 'k') || (posFrom == 'i') ) && (posTo == '-') && ( leftOrRight == 9)  && (upOrDown > 0) && (oddLessThan >5) = (time-5,captureNE2,removedne2Guy) -- > is up and 9 is right (even row)
	| ( (posFrom == 'k') || (posFrom == 'i') ) && (posTo == '-') && ( leftOrRight == 11) && (upOrDown < 0) && (oddLessThan >5) = (time-5,captureSE,removedseGuy) -- down is > and 11 is left (even row)
	| ( (posFrom == 'k') || (posFrom == 'i') ) && (posTo == '-') && ( leftOrRight == 9)  && (upOrDown < 0) && (oddLessThan >5) = (time-5,captureSW,removedswGuy) -- down is > and 9 is right (even row)
	
	| (posTo == '-')= (time-1,captures,setFinalPosTo)
	| otherwise = (10000,captures,board)
	where posFrom = getPos fromPiece board
	      posTo =  getPos toPiece board
	      sPosFrom = setPos fromPiece board '-'
	      sPosTo = setPos toPiece sPosFrom posFrom
	      setFinalPosTo = setPos fromPiece sPosTo '-'
	      leftOrRight = abs (fromPiece-toPiece)
	      oddLessThan = fromPiece `mod` 10
	      upOrDown = fromPiece - toPiece    --pos it up negative is down
	      neGuy  = fromPiece-4 --if From is odd
	      nwGuy  = fromPiece-5 --if From is odd
	      seGuy  = fromPiece+5 --if From is even
	      swGuy  = fromPiece+4 --if From is even
	         
	      neGuy2 = fromPiece-5 --if From is even
	      nwGuy2 = fromPiece-6 --if From is even
	      seGuy2 = fromPiece+6 --if From is odd
	      swGuy2 = fromPiece+5 --if From is odd

		  --Converting position Values to Char for displaying
	      neGuyChar = getPos neGuy setFinalPosTo
	      nwGuyChar = getPos nwGuy setFinalPosTo
	      seGuyChar = getPos seGuy setFinalPosTo
	      swGuyChar = getPos swGuy setFinalPosTo
     
	      neGuy2Char = getPos neGuy2 setFinalPosTo
	      nwGuy2Char = getPos nwGuy2 setFinalPosTo
	      seGuy2Char = getPos seGuy2 setFinalPosTo
	      swGuy2Char = getPos swGuy2 setFinalPosTo
	      
	      --List of current captures
	      captureSE= captures ++ [seGuyChar]
	      captureSW= captures ++ [swGuyChar]
	      captureNE= captures ++ [neGuyChar]
	      captureNW= captures ++ [nwGuyChar]
	      
	      captureSE2= captures ++ [seGuy2Char]
	      captureSW2= captures ++ [swGuy2Char]
	      captureNE2= captures ++ [neGuy2Char]
	      captureNW2= captures ++ [nwGuy2Char]
	      
	      --removing Captured Victim
	      removedseGuy = setPos seGuy setFinalPosTo '-'
	      removedswGuy = setPos swGuy setFinalPosTo '-'
	      removednwGuy = setPos nwGuy setFinalPosTo '-'
	      removedneGuy = setPos neGuy setFinalPosTo '-'
	      
	      removedse2Guy = setPos seGuy2 setFinalPosTo '-'
	      removedsw2Guy = setPos swGuy2 setFinalPosTo '-'
	      removednw2Guy = setPos nwGuy2 setFinalPosTo '-'
	      removedne2Guy = setPos neGuy2 setFinalPosTo '-'
	      
	      
	      kingPromoNEJump = setPos toPiece removedneGuy 'k' 
	      kingPromoNWJump = setPos toPiece removednwGuy 'k' 
	      kingPromo = setPos toPiece setFinalPosTo 'k'
	      
	      kingPromoSEJump = setPos toPiece removedseGuy 'i'
	      kingPromoSWJump = setPos toPiece removedswGuy 'i'
	      kingPromo2 = setPos toPiece setFinalPosTo 'i'