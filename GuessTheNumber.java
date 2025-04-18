import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GuessTheNumber {
    private int GuessingNumber;
    private int attempts;

    public GuessTheNumber() {
        Random random = new Random();
        GuessingNumber = random.nextInt(100) + 1;
        attempts = 0;

        JFrame frame = new JFrame("🌟 Guess the Number 🌟");
        frame.setSize(700, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); 

   
        JTextField guessField = new JTextField(10);
        guessField.setFont(new Font("Times New Romen", Font.PLAIN, 24));

        JLabel instrLabel = new JLabel("Guess a number between 1 and 100:");
        instrLabel.setFont(new Font("Times New Romen", Font.BOLD, 24));

        JButton guessButton = new JButton("Guess 😉");
        guessButton.setFont(new Font("Times New Romen", Font.BOLD, 22));

        JLabel resultLabel = new JLabel(" ");
        resultLabel.setFont(new Font("Times New Romen", Font.PLAIN, 22));
        resultLabel.setForeground(Color.BLUE);

      
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        
        instrLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        guessField.setMaximumSize(new Dimension(200, 40));
        guessField.setAlignmentX(Component.CENTER_ALIGNMENT);
        guessButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        
        panel.add(instrLabel);
        panel.add(Box.createVerticalStrut(20));
        panel.add(guessField);
        panel.add(Box.createVerticalStrut(20));
        panel.add(guessButton);
        panel.add(Box.createVerticalStrut(20));
        panel.add(resultLabel);

        frame.add(panel);
        frame.setVisible(true);

       
        guessButton.addActionListener(e -> {
            try {
                int guess = Integer.parseInt(guessField.getText().trim());
                attempts++;
                if (guess < GuessingNumber) {
                    resultLabel.setText("Too low! Try again. 😀");
                } else if (guess > GuessingNumber) {
                    resultLabel.setText("Too high! Try again. 😀");
                } else {
                    resultLabel.setText("🎉 CONGRATULATIONS! You guessed it in " + attempts + " attempts.");
                    guessButton.setEnabled(false);
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("oops! Please enter a valid number.");
            }
        });
    }

    public static void main(String[] args) {
        new GuessTheNumber();
    }
}
