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
