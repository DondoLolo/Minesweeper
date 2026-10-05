# Program Notes

## The board as integers
- 0 - 8: The number of neighboring bombs (uncovered tiles)
  - Draw a blank tile
- -1: represents a hidden bomb
  - Draw a blank tile
- 10-18: uncovered states of 0-8 
  - Draw the actual tile value (draw value - 10)
- 9: clicked bomb
  - Game Over
- 19-28: a flagged tile
  - Draw a flagged tile
  - BUT... we know what is underneath the flag (value-20)

## User Input
- left-click: +10 to tile
  - They uncover a tile
- Right-click: +20/-20 to a tile
  - They flagged/unflagged a tile
