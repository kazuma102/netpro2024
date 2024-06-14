//FacesAWTMain.java
//FacesAWTMain 目標 インナークラスのFaceObjクラスを作ってみよう。描画処理を移譲してください。
//3x3　の顔を描画してください。色などもぬってオリジナルな楽しい顔にしてください。
package guibasic;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FacesAWTHorieKazuma {

    public static void main(String[] args) {
        new FacesAWTHorieKazuma();
    }

    FacesAWTHorieKazuma() {
        FaceFrame f = new FaceFrame();
        f.setSize(800, 800);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setVisible(true);
    }

    // インナークラスを定義
    class FaceFrame extends Frame {

        FaceObj[] fobjs;

        FaceFrame() {
            int line = 3;
            int column = 3;
            fobjs = new FaceObj[line * column];
            int x0 = 50;
            int y0 = 50;
            int spacing = 250;

            //set_face_option
            for (int i = 0; i < line; i++) {
                for (int j = 0; j < column; j++) {
                    fobjs[i * column + j] = new FaceObj();
                    fobjs[i * column + j].setPosition(x0 + j * spacing, y0 + i * spacing);
                    fobjs[i * column + j].setExpression(5 + j * 20);
                    fobjs[i * column + j].setMouthSize(5 + i * 20);
                }
            }
        }

        //draw_face
        public void paint(Graphics g) {
            for (int i = 0; i < 9; i++) {
                Color color = new Color(255 - i * 30, i * 25, i * 15);
                g.setColor(color);
                fobjs[i].drawFace(g);
            }
        }
    }//FaceFrame end

    //Faceクラスを作ってみよう。
    private class FaceObj {

        private int w = 200;
        private int h = 200;
        private int xStart;
        private int yStart;
        private int r;
        private boolean isSuprised = false;
        private boolean isStunned = false;
        private int baseEyeSize = 25;
        private int rMouth;

        public void setPosition(int xStart, int yStart) {
            this.xStart = xStart;
            this.yStart = yStart;
        }

        public void setExpression(int r) {
            this.r = r;
            if (r < baseEyeSize) {
                this.isStunned = true;
            }
            if (r > baseEyeSize) {
                this.isSuprised = true;
            }
        }

        public void setMouthSize(int rm) {
            this.rMouth = rm;
        }

        public void drawFace(Graphics g) {
            drawRim(g);
            drawBrow(g, 30);
            drawEye(g, r);
            drawNose(g, 40);
            drawMouth(g, 100);
        }

        public void drawRim(Graphics g) {  // wが横幅、hが縦幅
            g.drawLine(xStart, yStart, xStart + w, yStart);
            g.drawLine(xStart, yStart, xStart, yStart + h);
            g.drawLine(xStart, yStart + h, xStart + w, yStart + h);
            g.drawLine(xStart + w, yStart, xStart + w, yStart + h);
        }

        public void drawBrow(Graphics g, int bx) { // xは目の幅 呼ばれる方(=定義する方)
            int wx1 = xStart + w * 2 / 8;
            int wx2 = xStart + w * 5 / 8;
            int wy = yStart + h / 5;
            if (isSuprised) {
                wy -= 50;
                g.drawLine(wx1, wy, wx1 + w * 1 / 8, wy);
                g.drawLine(wx2, wy, wx2 + w * 1 / 8, wy);
            } else if (isStunned) {
                g.drawLine(wx1, wy, wx1 + w * 1 / 8, wy - 30);
                g.drawLine(wx2, wy - 30, wx2 + w * 1 / 8, wy);
            } else {
                g.drawLine(wx1, wy, wx1 + w * 1 / 8, wy);
                g.drawLine(wx2, wy, wx2 + w * 1 / 8, wy);
            }
        }

        public void drawNose(Graphics g, int nx) { // xは鼻の長さ
            int xMiddle = xStart + w / 2;
            int yMiddle = yStart + h / 2;
            g.drawLine(xMiddle, yMiddle - nx / 2, xMiddle - nx / 2, yMiddle + nx);
            g.drawLine(xMiddle - nx / 2, yMiddle + nx, xMiddle, yMiddle + nx);
        }

        public void drawEye(Graphics g, int r) { // rは目の半径
            g.drawOval(xStart + 45, yStart + 65, r, r);
            g.drawOval(xStart + 120, yStart + 65, r, r);
        }

        public void drawMouth(Graphics g, int mx) { // xは口の幅
            int xMiddle = xStart + w / 2;
            int yMiddle = yStart + h - 30;

            g.drawOval(xMiddle - mx / 2, yMiddle - mx / 5, rMouth * 3, rMouth);

        }
    }
}//Faces class end

