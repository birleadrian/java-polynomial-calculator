import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;


public class View extends JFrame{

    final Image img_background = ImageIO.read(new File("src/main/java/back.png")).getScaledInstance(1200, 700, Image.SCALE_SMOOTH);
    //Componente
    private JTextField m_userInputP1 = new JTextField();
    private JTextField m_userInputP2 = new JTextField();
    private JTextField m_userInputP3 = new JTextField();
    private JButton m_multiplyBtn = new JButton("Multiply");
    private JButton m_divideBtn = new JButton("Divide");
    private JButton m_addBtn = new JButton("Add");
    private JButton m_subBtn = new JButton("Subtract");
    private JButton m_derivativeBtn = new JButton("Derivative");
    private JButton m_integrativeBtn = new JButton("Integrative");
    private JLabel p1_label = new JLabel("First Polynomial 1");
    private JLabel p2_label = new JLabel("Second Polynomial 2");
    private JLabel p3_label = new JLabel("Third Polynomial 3");
    private JLabel result_label = new JLabel("Result");
    private JPanel contentPane;
    private JTextField resultText;

    private Model m_model;

    View(Model model) throws IOException {
        m_model = model;
        m_model.setValue(Model.initial);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        m_userInputP1.setBounds(139, 62, 892, 39);
        m_userInputP1.setHorizontalAlignment(SwingConstants.CENTER);
        m_userInputP1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        contentPane.add(m_userInputP1);
        m_userInputP1.setColumns(10);

        m_userInputP2.setHorizontalAlignment(SwingConstants.CENTER);
        m_userInputP2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        m_userInputP2.setColumns(10);
        m_userInputP2.setBounds(139, 157, 892, 39);
        contentPane.add(m_userInputP2);

        p1_label.setBounds(456, 15, 278, 53);
        p1_label.setFont(new Font("DialogInput", Font.BOLD, 16));
        p1_label.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(p1_label);

        p2_label.setBounds(482, 124, 230, 22);
        p2_label.setHorizontalAlignment(SwingConstants.CENTER);
        p2_label.setFont(new Font("DialogInput", Font.BOLD, 16));
        contentPane.add(p2_label);

        m_addBtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(238, 232, 170)));
        m_addBtn.setBackground(new Color(238, 232, 170));
        m_addBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
        m_addBtn.setBounds(243, 207, 164, 53);
        contentPane.add(m_addBtn);

        m_subBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
        m_subBtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(238, 232, 170)));
        m_subBtn.setBackground(new Color(238, 232, 170));
        m_subBtn.setBounds(437, 207, 164, 53);
        contentPane.add(m_subBtn);

        m_multiplyBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
        m_multiplyBtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(238, 232, 170)));
        m_multiplyBtn.setBackground(new Color(238, 232, 170));
        m_multiplyBtn.setBounds(629, 207, 164, 53);
        contentPane.add(m_multiplyBtn);

        m_divideBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
        m_divideBtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(238, 232, 170)));
        m_divideBtn.setBackground(new Color(238, 232, 170));
        m_divideBtn.setBounds(832, 207, 164, 53);
        contentPane.add(m_divideBtn);

        result_label.setBounds(482, 280, 230, 30);
        result_label.setHorizontalAlignment(SwingConstants.CENTER);
        result_label.setFont(new Font("DialogInput", Font.BOLD, 20));
        contentPane.add(result_label);

        resultText = new JTextField();
        resultText.setEditable(false);
        resultText.setHorizontalAlignment(SwingConstants.CENTER);
        resultText.setFont(new Font("Tahoma", Font.PLAIN, 18));
        resultText.setColumns(10);
        resultText.setBounds(139, 310, 892, 40);
        contentPane.add(resultText);


        p3_label.setBounds(482, 380, 230, 30);
        p3_label.setHorizontalAlignment(SwingConstants.CENTER);
        p3_label.setFont(new Font("DialogInput", Font.BOLD, 16));
        contentPane.add(p3_label);

        m_userInputP3.setBounds(139, 420, 892, 40);
        m_userInputP3.setColumns(10);
        m_userInputP3.setHorizontalAlignment(SwingConstants.CENTER);
        m_userInputP3.setFont(new Font("DialogInput", Font.BOLD, 16));
        contentPane.add(m_userInputP3);

        m_derivativeBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
        m_derivativeBtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(238, 232, 170)));
        m_derivativeBtn.setBackground(new Color(238, 232, 170));
        m_derivativeBtn.setBounds(437, 480, 164, 53);
        contentPane.add(m_derivativeBtn);

        m_integrativeBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
        m_integrativeBtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(238, 232, 170)));
        m_integrativeBtn.setBackground(new Color(238, 232, 170));
        m_integrativeBtn.setBounds(629, 480, 164, 53);
        contentPane.add(m_integrativeBtn);


        JLabel lblBackground = new JLabel("");
        lblBackground.setBounds(5, 5, 1200, 700);
        lblBackground.setIcon(new ImageIcon(img_background));
        contentPane.add(lblBackground);

        this.setResizable(false);
        this.setTitle("Polynomial Calculator");
    }
    void reset() {
        resultText.setText(Model.initial);
    }
    String getUserInputP1() {
        return m_userInputP1.getText();
    }
    String getUserInputP2() {
        return m_userInputP2.getText();
    }
    String getUserInputP3() {
        return m_userInputP3.getText();
    }
    void setResult(String newResult) {
        resultText.setText(newResult);
    }
    void addMultiplyListener(ActionListener mal) {
        m_multiplyBtn.addActionListener(mal);
    }
    void addSumListener(ActionListener sal) {
        m_addBtn.addActionListener(sal);
    }
    void addDivideListener(ActionListener dal) {
        m_divideBtn.addActionListener(dal);
    }
    void addSubtractListener(ActionListener subal) {
        m_subBtn.addActionListener(subal);
    }
    void addDerivativeListener(ActionListener deral) {
        m_derivativeBtn.addActionListener(deral);
    }
    void addIntegrativeListener(ActionListener ial) {
        m_integrativeBtn.addActionListener(ial);
    }
}
