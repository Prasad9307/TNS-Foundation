// Function to simulate rolling the dice
function rollDice() {
    // Roll two dice for Player 1 and Player 2
    const roll1 = Math.floor(Math.random() * 6) + 1;
    const roll2 = Math.floor(Math.random() * 6) + 1;

    // Update the dice images
    document.getElementById("dice1").src = `images/dice${roll1}.png`;
    document.getElementById("dice2").src = `images/dice${roll2}.png`;

    // Determine the result
    let resultText;
    if (roll1 > roll2) {
        resultText = "🎉 Player 1 Wins!";
    } else if (roll2 > roll1) {
        resultText = "🎉 Player 2 Wins!";
    } else {
        resultText = "🤝 Draw!";
    }

    // Update the title with the result
    document.getElementById("title").textContent = resultText;
}
