# TicTacToe Game

A Java Swing desktop application that recreates the classic Tic Tac Toe game with score tracking, sound effects, and a polished graphical interface.

## 📌 Description

This project offers a fun 2-player Tic Tac Toe experience in a local environment.  
The game includes score tracking, turn-based logic, visual highlights for wins, and sound effects to enhance the player experience.

It uses the MVC (Model-View-Controller) architecture to separate concerns and improve maintainability.

## 🧠 Features

- Interactive 3x3 game board with click-to-play buttons
- 2-player local mode (X vs. O)
- Real-time win and draw detection
- Visual highlighting of winning combinations
- Score tracking for both players
- Reset and sound toggle buttons
- Sound feedback for moves, errors, and victories
- Modular structure (Model, View, Controller, SoundManager)

## 🔧 Technologies Used

- Java 17
- Swing (GUI)
- OOP – Object-Oriented Programming
- MVC architectural pattern
- Custom audio integration (`javax.sound.sampled`)

## 🏗️ Project Structure

- `model` – game logic and data handling (`TicTacToeModel`)
- `view` – GUI elements and layout (`TicTacToeView`)
- `controller` – user interactions and game flow (`TicTacToeController`)
- `utils` – sound manager for feedback effects (`SoundManager`)

## 🖥️ User Interface

The application includes the following GUI components:

- **Title bar** with current player's turn and sound icon
- **3x3 game board** grid with styled buttons
- **Score panel** showing X and O scores
- **Reset button** to restart the game
- **Sound toggle button** to enable/disable sound effects

## 📈 Future Improvements

- Add single-player mode with basic AI opponent
- Include animations or smoother transitions
- Store high scores between sessions
- Option to choose player names
- Improve UI responsiveness on various screen sizes
