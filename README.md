# 15 Puzzle Game - Java Swing

This application is a implementation of the popular **15 Puzzle** game. This version of the game was developed with Java Swing. See a video overview of the game here: https://jumpshare.com/v/IJElwsVOsdKAHFapzB0n

## Gameplay instruction

1. Run the program.
2. Click "Game" button to go to main game page.
3. Click "Shuffle" button to shuffle the dices.
4. Try solving the puzzle by clicking the dices to move them.
5. If you succeed, you will be shown a completion messege.
6. Click "Reset" if you got stuck.
7. Click "Shuffle" button to take the challenge again.
8. Finally, click "back" or "X" button to stop the game.


## Dependencies

1. Java - JDK 8 or later (the game was originally developed with JDK 6) - https://www.oracle.com/java/technologies/downloads/
2. Netbeans IDE - https://netbeans.apache.org/front/main/index.html


## Deploying using Docker

1. Install `socat` in your machine - `brew install socat`

2. In a separate terminal run the following command: `socat TCP-LISTEN:6000,reuseaddr,fork UNIX-CLIENT:\"$DISPLAY\"`

3. Build the image using: `docker build -t 15-puzzle`

4. Run the docker container using: `docker run -v /tmp/.X11-unix:/tmp/.X11-unix -e DISPLAY=$(ipconfig getifaddr en0):0 15-puzzle`

## References
1. 15 puzzle game - https://en.wikipedia.org/wiki/15_puzzle
