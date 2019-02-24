package lesson4.Homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//1. Создать окно для клиентской части чата: большое текстовое поле для отображения переписки в центре окна.
// Однострочное текстовое поле для ввода сообщений и кнопка для отсылки сообщений на нижней панели.
// Сообщение должно отсылаться либо по нажатию кнопки на форме, либо по нажатию кнопки Enter.
// При «отсылке» сообщение перекидывается из нижнего поля в центральное.


public class Main extends JFrame {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        // Параметры окна
        super("ЧерЧат");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(300,300,300,300);
        setLayout(new BorderLayout());
        setResizable(false);


        // Параметры компонентов
        JPanel mainPanel = new JPanel();
        JPanel downPanel = new JPanel();
        downPanel.setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
        add(downPanel, BorderLayout.SOUTH);
        JButton sendButton = new JButton("Отправить сообщение");
        JTextField textMess = new JTextField();
        JTextArea chat = new JTextArea(13,25);
        chat.setLineWrap(true); // перенос строки
        chat.setEditable(false);
        mainPanel.add(chat);
        downPanel.add(textMess, BorderLayout.NORTH);
        downPanel.add(sendButton, BorderLayout.SOUTH);

        // Обработчики событий
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textMess.getText().equalsIgnoreCase("")) {
                   chat.setText(chat.getText() + textMess.getText() + "\n");
                    textMess.setText("");
                }
            }
        });

        textMess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textMess.getText().equalsIgnoreCase("")) {
                    chat.setText(chat.getText() + textMess.getText() + "\n");
                    textMess.setText("");
                }
            }
        });


        setVisible(true);
    }
}
