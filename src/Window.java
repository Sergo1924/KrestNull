import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by sergo on 23.01.17.
 */
public class Window extends JFrame {
    Random random = new Random();
    public static String a;
    public static String b;
    JPanel jPanel = new JPanel();   //позволяет хранить в себе множ-во элементов, панель вкладывается во фрейм
    JButton[][] jButtons = new JButton[3][3];


    public JButton[][] image() {
        setTitle("X-0");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        jPanel.setLayout(new GridLayout(3, 3));

        final JFrame qwqw = this;
        for (int i = 0; i < jButtons.length; i++) {
            // JButton[] buttonLine = jButtons[i];
            for (int j = 0; j < jButtons[i].length; j++) {
                JButton jb = new JButton();
                jb.setText("*");
                int finalI = i;
                int finalJ = j;
                String z = "X";
                String x = "0";
                jb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //   String buttonText = e.getActionCommand();  //возвращает зн-е кнопки
                        //String buttonText = jb.getText();
                        if ((z.equals(jButtons[finalI][finalJ].getText())) || x.equals(jButtons[finalI][finalJ].getText())){
                            JOptionPane.showMessageDialog(qwqw, "Ячейка занята");
                        }
                        jb.setText("X");

                        computer(jButtons, "0");
                        repaint();
                        int s = 0;
                        if (checkk(jButtons))
                            JOptionPane.showMessageDialog(qwqw, "Победа");
                        if (!(checkk(jButtons))) s++;
                        if (s == 9) {JOptionPane.showMessageDialog(qwqw, "Ничья");}


                    }
                });

                jButtons[i][j] = jb;
                jPanel.add(jb);

            }
        }
        final JFrame thisJframe = this;
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("Игра");
        bar.add(menu);
        JMenuItem item = new JMenuItem("Выберете X");
        JMenuItem item1 = new JMenuItem("Выберете 0");
        JMenuItem item2 = new JMenuItem("Выход");
        menu.add(item);
        menu.add(item1);
        menu.add(item2);

        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a = "X";

                playIgrok(jButtons, a);

            }
        });

        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b = "0";

            }
        });


        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(thisJframe, "Покеда");
                System.exit(0);
            }
        });

        setJMenuBar(bar);

        add(jPanel);
        setVisible(true);

        return jButtons;
    }

    public void playIgrok(JButton[][] jButtons, String a) {
    }

    public void computer(JButton[][] jButtons, String a) {
        ArrayList<JButton> arrayList = new ArrayList<>();
        final JFrame qwqw = this;


        for (int i = 0; i < jButtons.length; i++) {
            for (int j = 0; j < jButtons[i].length; j++) {
                if (((jButtons[i][j].getText()).equals("*"))) {
                    arrayList.add(jButtons[i][j]);
                }

            }
        }
        int e = random.nextInt(arrayList.size());
        arrayList.get(e).setText(a);
    }
    public void shoot(int x, int y) {
    }

    public boolean checkk(JButton [][] mas1) {
        final JFrame qwqw = this;
        for (int i = 0; i <mas1.length ; i++) {
            if (("X".equals(jButtons[i][0].getText()))  && ("X".equals(jButtons[i][1].getText())) && ("X".equals(jButtons[i][2].getText())) ||
                    (("X".equals(jButtons[0][i].getText()))  && ("X".equals(jButtons[1][i].getText())) && ("X".equals(jButtons[2][i].getText())))) {
                JOptionPane.showMessageDialog(qwqw, "Вы выиграли");
                return true;
            }
        }
        if (("X".equals(jButtons[0][0].getText())) && ("X".equals(jButtons[1][1].getText())) && ("X".equals(jButtons[2][2].getText()))) {
            JOptionPane.showMessageDialog(qwqw, "Вы выиграли"); return true;
        }
        if (("X".equals(jButtons[2][0].getText())) && ("X".equals(jButtons[1][1].getText())) && ("X".equals(jButtons[0][2].getText()))) {
            JOptionPane.showMessageDialog(qwqw, "Вы выиграли"); return true;
        }

        for (int i = 0; i <mas1.length ; i++) {
            if (("0".equals(jButtons[i][0].getText()))  && ("0".equals(jButtons[i][1].getText())) && ("0".equals(jButtons[i][2].getText())) ||
                    (("0".equals(jButtons[0][i].getText()))  && ("0".equals(jButtons[1][i].getText())) && ("0".equals(jButtons[2][i].getText())))) {
                JOptionPane.showMessageDialog(qwqw, "Вы проиграли");
                return true;
            }
        }


        if (("0".equals(jButtons[0][0].getText())) && ("0".equals(jButtons[1][1].getText())) && ("0".equals(jButtons[2][2].getText()))) {
            JOptionPane.showMessageDialog(qwqw, "Вы проиграли"); return true;
        }
        if (("0".equals(jButtons[2][0].getText())) && ("0".equals(jButtons[1][1].getText())) && ("0".equals(jButtons[0][2].getText()))) {
            JOptionPane.showMessageDialog(qwqw, "Вы проиграли"); return true;
        }

        else return false;
    }
    public boolean checkk2(String[][] mas1) {
        for (int i = 0; i < mas1.length; i++) {
            if (("X".equals(jButtons[i][0].getText())) && ("X".equals(jButtons[i][1].getText())) && ("X".equals(jButtons[i][2].getText())) ||
                    (("X".equals(jButtons[0][i].getText())) && ("X".equals(jButtons[1][i].getText())) && ("X".equals(jButtons[2][i].getText())))) {
                System.out.println("Вы проиграли");
                return true;
            }
        }
        if (("X".equals(jButtons[0][0].getText())) && ("X".equals(jButtons[1][1].getText())) && ("X".equals(jButtons[2][2].getText()))) {
            System.out.println("Вы проиграли");
            return true;
        }
        if (("X".equals(jButtons[2][0].getText())) && ("X".equals(jButtons[1][1].getText())) && ("X".equals(jButtons[0][2].getText()))) {
            System.out.println("Вы проиграли");
            return true;
        }

        for (int i = 0; i < mas1.length; i++) {
            if (("0".equals(jButtons[i][0].getText())) && ("0".equals(jButtons[i][1].getText())) && ("0".equals(jButtons[i][2].getText())) ||
                    (("0".equals(jButtons[0][i].getText())) && ("0".equals(jButtons[1][i].getText())) && ("0".equals(jButtons[2][i].getText())))) {
                System.out.println("Вы выиграли");
                return true;
            }
        }


        if (("0".equals(jButtons[0][0].getText())) && ("0".equals(jButtons[1][1].getText())) && ("0".equals(jButtons[2][2].getText()))) {
            System.out.println("Вы выиграли");
            return true;
        }
        if (("0".equals(jButtons[2][0].getText())) && ("0".equals(jButtons[1][1].getText())) && ("0".equals(jButtons[0][2].getText()))) {
            System.out.println("Вы выиграли");
            return true;
        } else return false;
    }
}
