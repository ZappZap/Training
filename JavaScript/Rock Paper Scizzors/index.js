let computerScore = 0;
  let humanScore = 0;
  let computerSelection = getComputerChoice();
  let humanSelection = getHumanChoice();

  
function playRound() {
  if (computerSelection == humanSelection) {
    console.log("It's tie");
    console.log("Human:", humanScore, "Computer:", computerScore)
  } else if (computerSelection == "rock" && humanSelection == "paper") {
    console.log("Player wins!")
    humanScore++
    console.log("Human:", humanScore, "Computer:", computerScore)
  } else if (computerSelection == "rock" && humanSelection == "scizzors") {
    console.log("Computer wins!")
    computerScore++
    console.log("Human:", humanScore, "Computer:", computerScore)
  } else if (computerSelection == "paper" && humanSelection == "rock") {
    console.log("Computer wins!")
    computerScore++
    console.log("Human:", humanScore, "Computer:", computerScore)
  } else if (computerSelection == "paper" && humanSelection == "scizzors") {
    console.log("Player wins!")
    playerScore++
    console.log("Human:", humanScore, "Computer:", computerScore)
  } else if (computerSelection == "scizzors" && humanSelection == "paper") {
    console.log("Computer wins!")
    computerScore++
    console.log("Human:", humanScore, "Computer:", computerScore)
  } else if (computerSelection == "scizzors" && humanSelection == "rock") {
    console.log("Player wins!")
    humanScore++
    console.log("Human:", humanScore, "Computer:", computerScore)
  }
}

function getComputerChoice() {
  const choices = ['rock', 'paper', 'scissors'];
  const randomIndex = Math.floor(Math.random() * choices.length);
  return choices[randomIndex];
}

function getHumanChoice() {
  let humanChoice = prompt("Enter your choice");
  //let humanChoice = "rock"
  return humanChoice.toLowerCase();
}

function playGame() {
  for (let round = 0; round <5; round++) {
    playRound(computerSelection,humanSelection)
  }
}

playGame()