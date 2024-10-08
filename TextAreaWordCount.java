import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TextAreaWordCount extends JFrame {
    private JTextArea textArea;
    private JLabel wordCountLabel;
    private JLabel charCountLabel;

    public TextAreaWordCount() {
        setTitle("Word and Character Count");
        setLayout(new BorderLayout());

        textArea = new JTextArea(15, 30);
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        wordCountLabel = new JLabel("Words: 0");
        charCountLabel = new JLabel("Characters: 0");

        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                updateCounts();
            }
        });

        JPanel countPanel = new JPanel();
        countPanel.setLayout(new FlowLayout());
        countPanel.add(wordCountLabel);
        countPanel.add(charCountLabel);

        add(scrollPane, BorderLayout.CENTER);
        add(countPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateCounts() {
        String text = textArea.getText();
        int wordCount = text.isEmpty() ? 0 : text.trim().split("\\s+").length;
        int charCount = text.length();
        wordCountLabel.setText("Words: " + wordCount);
        charCountLabel.setText("Characters: " + charCount);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TextAreaWordCount::new);
    }
}
