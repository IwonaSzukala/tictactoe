import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TicTacToe extends Applet implements MouseListener
{
    Frame f;
    int flag=2, n, m, i=0;
    char ch[]=new char[9];


    public TicTacToe()
    {
        f=new Frame("Kółko i Krzyżyk");
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(600, 600);
        f.addMouseListener(this);
        for(i=0;i<9;i++)
            ch[i]='B';
    }
    public void mouseClicked(MouseEvent e) {
        Graphics g = f.getGraphics();
        g.drawLine(200, 0, 200, 600);
        g.drawLine(400, 0, 400, 600);
        g.drawLine(0, 200, 600, 200);
        g.drawLine(0, 400, 600, 400);
        flag--;
        int x = e.getX();
        int y = e.getY();
        if (flag == 1) {
            if (x < 200 && y < 200) {
                m = 0;
                n = 0;
                ch[0] = 'R';
            }
            if ((x > 200 && x < 400) && (y < 200)) {
                m = 200;
                n = 0;
                ch[1] = 'R';
            }
            if ((x > 400 && x < 600) && (y < 200)) {
                m = 400;
                n = 0;
                ch[2] = 'R';
            }
            if (x < 200 && (y < 200 && y < 400)) {
                m = 0;
                n = 200;
                ch[3] = 'R';
            }
            if ((x > 200 && x < 400) && (y > 200 && y < 400)) {
                m = 200;
                n = 200;
                ch[4] = 'R';
            }
            if ((x > 400 & x < 600) && (y > 200 & y < 400)) {
                m = 400;
                n = 200;
                ch[5] = 'R';
            }
            if (x < 200 & (y > 400 & y < 600)) {
                m = 0;
                n = 400;
                ch[6] = 'R';
            }
            if ((x > 200 & x < 400) && (y > 400 && y < 600)) {
                m = 200;
                n = 400;
                ch[7] = 'R';
            }
            if ((x > 400 && x < 600) && (y > 400 & y < 600)) {
                m = 400;
                n = 400;
                ch[8] = 'R';
            }

            g.setColor(Color.RED);
            g.drawLine(m, n, m + 199, n + 199);
            g.drawLine(m + 199, n, m, n + 199);
        }

        if (flag == 0)

        {
            if (x < 200 && y < 200) {
                m = 0;
                n = 20;
                ch[0] = 'P';
            }
            if ((x > 200 && x < 400) && (y < 200)) {
                m = 200;
                n = 20;
                ch[1] = 'P';
            }
            if ((x > 400 && x < 600) && (y < 200)) {
                m = 400;
                n = 20;
                ch[2] = 'P';
            }
            if (x < 200 && (y < 200 && y < 400)) {
                m = 0;
                n = 200;
                ch[3] = 'P';
            }
            if ((x > 200 && x < 400) && (y > 200 && y < 400)) {
                m = 200;
                n = 200;
                ch[4] = 'P';
            }
            if ((x > 400 & x < 600) && (y > 200 & y < 400)) {
                m = 400;
                n = 200;
                ch[5] = 'P';
            }
            if (x < 200 & (y > 400 & y < 600)) {
                m = 0;
                n = 400;
                ch[6] = 'P';
            }
            if ((x > 200 & x < 400) && (y > 400 && y < 600)) {
                m = 200;
                n = 400;
                ch[7] = 'P';
            }
            if ((x > 400 && x < 600) && (y > 400 & y < 600)) {
                m = 400;
                n = 400;
                ch[8] = 'P';
            }

            g.setColor(Color.GREEN);
            g.drawOval(m + 10, n + 10, 169, 169);
            flag = flag + 2;
        }

        for (i = 0;i<9;i++)
        {
            if (ch[i] != 'B') {
                if (i == 8)
                    draw();
            } else
                break;
        }

        for (i = 0; i < 3; i++) {

            if (ch[i] !='B')
            {
                if ((ch[i + 3] == ch[i]) && (ch[i + 6] == ch[i]))
                    win();
            }
        }
        for (i = 0; i < 7; i++) {
            if (ch[i] !='B')
            {
                if ((ch[i] == ch[i + 1]) && (ch[i] == ch[i + 2]))
                    win();
                i = i + 2;
            }
            else
            i = i + 2;
        }

        if(ch[4]!='B')
        {
            if(((ch[0]==ch[4]) && (ch[4]==ch[8])) || ((ch[2]==ch[4]) && (ch[4]==ch[6])))
                win();
        }


    }

    public Frame win()
    {

        Frame m=new Frame("Wynik");
        Label l=new Label("Wygrałeś!");
        m.setLayout(null);
        m.add(l);
        l.setBounds(20,20,60,60);
        m.setVisible(true);
        m.setSize(100, 100);
        return m;

    }

    public Frame draw()
    {
        Frame m=new Frame("Wyniki");
        Label l1=new Label("Stalemate");
        m.setLayout(null);
        m.add(l1);
        l1.setBounds(20,20,60,60);
        m.setVisible(true);
        m.setSize(100,100);
        return m;
    }

    public void mouseReleased(MouseEvent e)
    {
        System.out.print("");
    }


    public void mouseEntered(MouseEvent e)
    {
        System.out.print("");
    }

    public void mouseExited(MouseEvent e)
    {
        System.out.print("");
    }

    public void mousePressed(MouseEvent e)
    {
        System.out.print("");
    }

    public static void main(String args[])
    {
        new TicTacToe();
    }
}
