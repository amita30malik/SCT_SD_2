import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class GuessTheNumber {
    private int GuessingNumber;
    private int attempts;

    public GuessTheNumber() {
        Random random = new Random();
        GuessingNumber = random.nextInt(100) + 1;
        attempts = 0;

        JFrame frame = new JFrame("🌟Guess the Number🌟");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField guessField = new JTextField(10);
        JLabel instrLabel = new JLabel("Guess a number between 1 and 100:");
        JButton guessButton = new JButton("Guess 😉");
        JLabel resultLabel = new JLabel("");

        JPanel panel = new JPanel();
        panel.add(instrLabel);
        panel.add(guessField);
        panel.add(guessButton);
        panel.add(resultLabel);
        frame.add(panel);

        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int guess = Integer.parseInt(guessField.getText());
                    attempts++;
                    if (guess < GuessingNumber) {
                        resultLabel.setText("Too low! Try again.😀");
                    } else if (guess > GuessingNumber) {
                        resultLabel.setText("Too high! Try again.😀");
                    } else {
                        resultLabel.setText("CONGRATULATIONS🙌! Attempts: " + attempts);
                        guessButton.setEnabled(false);
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter a valid number.");
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GuessTheNumber();
    }
}
