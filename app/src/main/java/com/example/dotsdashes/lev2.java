package com.example.dotsdashes;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Random;

public class lev2 extends View {
    Context context;
    TextView p1,p2,p3;
    private Paint mcircle, mline, mline1, mline2;
    public int stat = 0, eng = 0, player = 1, sc1 = 0, sc2 = 0, sc3 = 0, pr = 0, nop = 1,diff=1;
    int  lc = 0;
    float l1x, l1y, l2x, l2y;
    int[] lh = new int[12];
    int[] lv = new int[12];
    int[] l = new int[24];
    int[] lcount = new int[40];
    private int[] tim = new int[9];
    private Paint pa1;
    Vibrator vibrator;
    Random rand;

    public lev2(Context context) {
        super(context);
        init(null);
        this.context=context;
    }

    public lev2(Context context, @Nullable AttributeSet attrs ) {
        super(context, attrs);
        init(attrs);
        this.context=context;
    }

    public lev2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
        this.context=context;
    }

    private void init(@Nullable AttributeSet set) {
        mcircle = new Paint();
        mcircle.setAntiAlias(true);
        mcircle.setColor(Color.BLACK);
        mline = new Paint();
        mline.setAntiAlias(true);
        mline.setColor(Color.RED);
        mline.setStrokeWidth(13);
        mline1 = new Paint();
        mline1.setAntiAlias(true);
        mline1.setColor(Color.BLUE);
        mline1.setStrokeWidth(13);
        mline2 = new Paint();
        mline2.setAntiAlias(true);
        mline2.setColor(Color.GREEN);
        mline2.setStrokeWidth(13);
        for (int i = 0; i < 12; i++) {
            lh[i] = lv[i] = 0;
        }
        for (int i = 0; i < 9; i++) {
            tim[i] = 0;
        }
        for (int i = 0; i < 24; i++) {
            lcount[i] = 0;
        }
        pa1 = new Paint();
        pa1.setAntiAlias(true);
        vibrator = (Vibrator) getContext().getSystemService(Context.VIBRATOR_SERVICE);
        rand = new Random();
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        p1 = (TextView)((Activity)context).findViewById(R.id.textView5);
        p2 = (TextView)((Activity)context).findViewById(R.id.textView4);
        p3 = (TextView)((Activity)context).findViewById(R.id.textView);
        p1.setText("Player 1 : "+sc1);
        p2.setText("Player 2 : "+sc2);
        p3.setText("Player 3 : "+sc3);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.YELLOW);


        final MediaPlayer box = MediaPlayer.create(getContext(),R.raw.applause3);
        float i,j;
        for(i = (float)(getWidth()/5) ; i<=0.8*getWidth() ; i+=(float)(getWidth()/5)){
            for (j = (float)(getWidth()/5) ; j<=0.8*getWidth() ; j+=(float)(getWidth()/5)){
                canvas.drawCircle(i,j,40, mcircle);
            }
        }
        if(lh[0]!=0 && lh[3]!=0 && lv[0]!=0 && lv[1]!=0 && tim[0]==0 && pr==0){
            if(nop==1&&player==0){
                pa1.setColor(Color.RED);
                sc1++;
                tim[0]=1;
                pr=1;
                player=1;
                box.start();
                p1.setText("Player 1 : "+sc1);
                p2.setText("Device : "+sc2);
                p3.setText("Player 3 : "+sc3);
            }
        }
        if(lh[1]!=0 && lh[4]!=0 && lv[1]!=0 && lv[2]!=0 && tim[1]==0 && pr==0) {
            if (nop == 1 && player == 0) {
                pa1.setColor(Color.RED);
                sc1++;
                tim[1] = 1;
                pr = 2;
                player=1;
                box.start();
                p1.setText("Player 1 : "+sc1);
                p2.setText("Device : "+sc2);
                p3.setText("Player 3 : "+sc3);
            }
        }
        if(lh[2]!=0 && lh[5]!=0 && lv[2]!=0 && lv[3]!=0 && tim[2]==0 && pr==0) {
            if (nop == 1 && player == 0) {
                pa1.setColor(Color.RED);
                sc1++;
                tim[2] = 1;
                pr = 3;
                player=1;
                box.start();
                p1.setText("Player 1 : "+sc1);
                p2.setText("Device : "+sc2);
                p3.setText("Player 3 : "+sc3);
            }
        }
        if(lh[3]!=0 && lh[6]!=0 && lv[5]!=0 && lv[4]!=0 && tim[3]==0 && pr==0) {
            if (nop == 1 && player == 0) {
                pa1.setColor(Color.RED);
                sc1++;
                tim[3] = 1;
                pr = 4;
                player=1;
                box.start();
                p1.setText("Player 1 : "+sc1);
                p2.setText("Device : "+sc2);
                p3.setText("Player 3 : "+sc3);
            }
        }
        if(lh[4]!=0 && lh[7]!=0 && lv[5]!=0 && lv[6]!=0 && tim[4]==0 && pr==0) {
            if (nop == 1 && player == 0) {
                pa1.setColor(Color.RED);
                sc1++;
                tim[4] = 1;
                pr = 5;
                player=1;
                box.start();
                p1.setText("Player 1 : "+sc1);
                p2.setText("Device : "+sc2);
                p3.setText("Player 3 : "+sc3);
            }
        }
        if(lh[5]!=0 && lh[8]!=0 && lv[6]!=0 && lv[7]!=0 && tim[5]==0 && pr==0) {
            if (nop == 1 && player == 0) {
                pa1.setColor(Color.RED);
                sc1++;
                tim[5] = 1;
                pr = 6;
                player=1;
                box.start();
                p1.setText("Player 1 : "+sc1);
                p2.setText("Device : "+sc2);
                p3.setText("Player 3 : "+sc3);
            }
        }
        if(lh[6]!=0 && lh[9]!=0 && lv[8]!=0 && lv[9]!=0 && tim[6]==0 && pr==0) {
            if (nop == 1 && player == 0) {
                pa1.setColor(Color.RED);
                sc1++;
                tim[6] = 1;
                pr = 7;
                player=1;
                box.start();
                p1.setText("Player 1 : "+sc1);
                p2.setText("Device : "+sc2);
                p3.setText("Player 3 : "+sc3);
            }
        }
        if(lh[7]!=0 && lh[10]!=0 && lv[9]!=0 && lv[10]!=0 && tim[7]==0 && pr==0) {
            if (nop == 1 && player == 0) {
                pa1.setColor(Color.RED);
                sc1++;
                tim[7] = 1;
                pr = 8;
                player=1;
                box.start();
                p1.setText("Player 1 : "+sc1);
                p2.setText("Device : "+sc2);
                p3.setText("Player 3 : "+sc3);
            }
        }
        if(lh[8]!=0 && lh[11]!=0 && lv[10]!=0 && lv[11]!=0 && tim[8]==0 && pr==0) {
            if (nop == 1 && player == 0) {
                pa1.setColor(Color.RED);
                sc1++;
                tim[8] = 1;
                pr = 9;
                player=1;
                box.start();
                p1.setText("Player 1 : "+sc1);
                p2.setText("Device : "+sc2);
                p3.setText("Player 3 : "+sc3);
            }
        }



        if(lh[0]!=0 && lh[2]!=0 && lv[0]!=0 && lv[1]!=0 && tim[0]==0 && pr!=0 &&pr!=1) {
            if (nop == 1 && player == 1) {
                pa1.setColor(Color.RED);
                sc1++;
                tim[0] = 1;
                p1.setText("Player 1 : "+sc1);
                p2.setText("Device : "+sc2);
                p3.setText("Player 3 : "+sc3);
            }
        }
        if(lh[1]!=0 && lh[4]!=0 && lv[1]!=0 && lv[2]!=0 && tim[1]==0 && pr!=0 && pr!=2) {
            if (nop == 1 && player == 1) {
                pa1.setColor(Color.RED);
                sc1++;
                tim[1] = 1;
                p1.setText("Player 1 : "+sc1);
                p2.setText("Device : "+sc2);
                p3.setText("Player 3 : "+sc3);
            }
        }
        if(lh[2]!=0 && lh[5]!=0 && lv[2]!=0 && lv[3]!=0 && tim[2]==0 && pr!=0 && pr!=3) {
            if (nop == 1 && player == 1) {
                pa1.setColor(Color.RED);
                sc1++;
                tim[2] = 1;
                p1.setText("Player 1 : "+sc1);
                p2.setText("Device : "+sc2);
                p3.setText("Player 3 : "+sc3);
            }
        }
        if(lh[3]!=0 && lh[6]!=0 && lv[5]!=0 && lv[4]!=0 && tim[3]==0 && pr!=0 && pr!=4) {
            if (nop == 1 && player == 1) {
                pa1.setColor(Color.RED);
                sc1++;
                tim[3] = 1;
                p1.setText("Player 1 : "+sc1);
                p2.setText("Device : "+sc2);
                p3.setText("Player 3 : "+sc3);
                }
        }
        if(lh[4]!=0 && lh[7]!=0 && lv[5]!=0 && lv[6]!=0 && tim[4]==0 && pr!=0 && pr!=5) {
            if (nop == 1 && player == 1) {
                pa1.setColor(Color.RED);
                sc1++;
                tim[4] = 1;
                p1.setText("Player 1 : "+sc1);
                p2.setText("Device : "+sc2);
                p3.setText("Player 3 : "+sc3);
            }
        }
        if(lh[5]!=0 && lh[8]!=0 && lv[6]!=0 && lv[7]!=0 && tim[5]==0 && pr!=0 && pr!=6) {
            if (nop == 1 && player == 1) {
                pa1.setColor(Color.RED);
                sc1++;
                tim[5] = 1;
                p1.setText("Player 1 : "+sc1);
                p2.setText("Device : "+sc2);
                p3.setText("Player 3 : "+sc3);
            }
        }
        if(lh[6]!=0 && lh[9]!=0 && lv[8]!=0 && lv[9]!=0 && tim[6]==0 && pr!=0 && pr!=7) {
            if (nop == 1 && player == 1) {
                pa1.setColor(Color.RED);
                sc1++;
                tim[6] = 1;
                p1.setText("Player 1 : "+sc1);
                p2.setText("Device : "+sc2);
                p3.setText("Player 3 : "+sc3);
            }
        }
        if(lh[7]!=0 && lh[10]!=0 && lv[9]!=0 && lv[10]!=0 && tim[7]==0 && pr!=0 && pr!=8) {
            if (nop == 1 && player == 1) {
                pa1.setColor(Color.RED);
                sc1++;
                tim[7] = 1;
                p1.setText("Player 1 : "+sc1);
                p2.setText("Device : "+sc2);
                p3.setText("Player 3 : "+sc3);
            }
        }
        if(lh[8]!=0 && lh[11]!=0 && lv[10]!=0 && lv[11]!=0 && tim[8]==0 && pr!=0 && pr!=9) {
            if (nop == 1 && player == 1) {
                pa1.setColor(Color.RED);
                sc1++;
                tim[8] = 1;
                p1.setText("Player 1 : "+sc1);
                p2.setText("Device : "+sc2);
                p3.setText("Player 3 : "+sc3);
            }
        }

        if(player==0 && nop==1 && (tim[0] == 0 || tim[1] == 0 || tim[2] == 0 || tim[3] == 0 || tim[4] == 0 || tim[5] == 0 || tim[6] == 0 || tim[7] == 0 || tim[8]==0)) {
            if(diff==1) {
                int lk = 0, jk = 0, ik = 0;

                for (int o = 0; o < 24; o++) {
                    l[o] = 0;
                }
                for (int o = 0; o < 12; o++) {
                    if (lh[o] == 0) {
                        l[lk] = o + 1;
                        lk++;
                    }
                    if (lv[o] == 0) {
                        l[lk] = o + 13;
                        lk++;
                    }
                }
                if (lk > 0) {
                    jk = rand.nextInt(lk);
                }
                ik = l[jk];
                if (ik < 13) {
                    lh[ik - 1] = 4;
                    player = 1;
                    lcount[lc] = ik;
                    lc++;
                } else {
                    lv[ik - 13] = 4;
                    player = 1;
                    lcount[lc] = ik;
                    lc++;
                }
            }
            else if(diff==2){
                int ad=0,bd=0,cd=0;
                if(tim[0]==0){
                    if(lh[0]==0){
                        ad++;
                        bd=1;
                    }
                    if(lh[3]==0){
                        ad++;
                        bd=2;
                    }
                    if(lv[0]==0){
                        ad++;
                        bd=3;
                    }
                    if(lv[1]==0){
                        ad++;
                        bd=4;
                    }
                    if(ad==1){
                        player=1;
                        if(bd==1){
                            lh[0]=4;
                            lcount[lc]=1;
                            lc++;
                            cd=1;
                        }else if(bd==2){
                            lh[3]=4;
                            lcount[lc]=4;
                            lc++;
                            cd=1;
                        }else if(bd==3){
                            lv[0]=4;
                            lcount[lc]=13;
                            lc++;
                            cd=1;
                        }else if(bd==4){
                            lv[1]=4;
                            lcount[lc]=14;
                            lc++;
                            cd=1;
                        }
                    }
                }
                if(tim[1]==0){
                    ad=0;
                    if(lh[1]==0){
                        ad++;
                        bd=1;
                    }
                    if(lh[4]==0){
                        ad++;
                        bd=2;
                    }
                    if(lv[1]==0){
                        ad++;
                        bd=3;
                    }
                    if(lv[2]==0){
                        ad++;
                        bd=4;
                    }
                    if(ad==1){
                        player=1;
                        if(bd==1){
                            lh[1]=4;
                            lcount[lc]=2;
                            lc++;
                            cd=1;
                        }else if(bd==2){
                            lh[4]=4;
                            lcount[lc]=5;
                            lc++;
                            cd=1;
                        }else if(bd==3){
                            lv[1]=4;
                            lcount[lc]=14;
                            lc++;
                            cd=1;
                        }else if(bd==4){
                            lv[2]=4;
                            lcount[lc]=15;
                            lc++;
                            cd=1;
                        }
                    }
                }
                if(tim[2]==0){
                    ad=0;
                    if(lh[2]==0){
                        ad++;
                        bd=1;
                    }
                    if(lh[5]==0){
                        ad++;
                        bd=2;
                    }
                    if(lv[2]==0){
                        ad++;
                        bd=3;
                    }
                    if(lv[3]==0){
                        ad++;
                        bd=4;
                    }
                    if(ad==1){
                        player=1;
                        if(bd==1){
                            lh[2]=4;
                            lcount[lc]=3;
                            lc++;
                            cd=1;
                        }else if(bd==2){
                            lh[5]=4;
                            lcount[lc]=6;
                            lc++;
                            cd=1;
                        }else if(bd==3){
                            lv[2]=4;
                            lcount[lc]=15;
                            lc++;
                            cd=1;
                        }else if(bd==4){
                            lv[3]=4;
                            lcount[lc]=16;
                            lc++;
                            cd=1;
                        }
                    }
                }
                if(tim[3]==0){
                    ad=0;
                    if(lh[3]==0){
                        ad++;
                        bd=1;
                    }
                    if(lh[6]==0){
                        ad++;
                        bd=2;
                    }
                    if(lv[4]==0){
                        ad++;
                        bd=3;
                    }
                    if(lv[5]==0){
                        ad++;
                        bd=4;
                    }
                    if(ad==1){
                        player=1;
                        if(bd==1){
                            lh[3]=4;
                            lcount[lc]=4;
                            lc++;
                            cd=1;
                        }else if(bd==2){
                            lh[6]=4;
                            lcount[lc]=7;
                            lc++;
                            cd=1;
                        }else if(bd==3){
                            lv[4]=4;
                            lcount[lc]=17;
                            lc++;
                            cd=1;
                        }else if(bd==4){
                            lv[5]=4;
                            lcount[lc]=18;
                            lc++;
                            cd=1;
                        }
                    }
                }
                if(tim[4]==0){
                    ad=0;
                    if(lh[4]==0){
                        ad++;
                        bd=1;
                    }
                    if(lh[7]==0){
                        ad++;
                        bd=2;
                    }
                    if(lv[5]==0){
                        ad++;
                        bd=3;
                    }
                    if(lv[6]==0){
                        ad++;
                        bd=4;
                    }
                    if(ad==1){
                        player=1;
                        if(bd==1){
                            lh[4]=4;
                            lcount[lc]=5;
                            lc++;
                            cd=1;
                        }else if(bd==2){
                            lh[7]=4;
                            lcount[lc]=8;
                            lc++;
                            cd=1;
                        }else if(bd==3){
                            lv[5]=4;
                            lcount[lc]=18;
                            lc++;
                            cd=1;
                        }else if(bd==4){
                            lv[6]=4;
                            lcount[lc]=19;
                            lc++;
                            cd=1;
                        }
                    }
                }
                if(tim[5]==0){
                    ad=0;
                    if(lh[5]==0){
                        ad++;
                        bd=1;
                    }
                    if(lh[8]==0){
                        ad++;
                        bd=2;
                    }
                    if(lv[6]==0){
                        ad++;
                        bd=3;
                    }
                    if(lv[7]==0){
                        ad++;
                        bd=4;
                    }
                    if(ad==1){
                        player=1;
                        if(bd==1){
                            lh[5]=4;
                            lcount[lc]=6;
                            lc++;
                            cd=1;
                        }else if(bd==2){
                            lh[8]=4;
                            lcount[lc]=9;
                            lc++;
                            cd=1;
                        }else if(bd==3){
                            lv[6]=4;
                            lcount[lc]=19;
                            lc++;
                            cd=1;
                        }else if(bd==4){
                            lv[7]=4;
                            lcount[lc]=20;
                            lc++;
                            cd=1;
                        }
                    }
                }
                if(tim[6]==0){
                    ad=0;;
                    if(lh[6]==0){
                        ad++;
                        bd=1;
                    }
                    if(lh[9]==0){
                        ad++;
                        bd=2;
                    }
                    if(lv[8]==0){
                        ad++;
                        bd=3;
                    }
                    if(lv[9]==0){
                        ad++;
                        bd=4;
                    }
                    if(ad==1){
                        player=1;
                        if(bd==1){
                            lh[6]=4;
                            lcount[lc]=7;
                            lc++;
                            cd=1;
                        }else if(bd==2){
                            lh[9]=4;
                            lcount[lc]=10;
                            lc++;
                            cd=1;
                        }else if(bd==3){
                            lv[8]=4;
                            lcount[lc]=21;
                            lc++;
                            cd=1;
                        }else if(bd==4){
                            lv[9]=4;
                            lcount[lc]=22;
                            lc++;
                            cd=1;
                        }
                    }
                }
                if(tim[7]==0){
                    ad=0;
                    if(lh[7]==0){
                        ad++;
                        bd=1;
                    }
                    if(lh[10]==0){
                        ad++;
                        bd=2;
                    }
                    if(lv[9]==0){
                        ad++;
                        bd=3;
                    }
                    if(lv[10]==0){
                        ad++;
                        bd=4;
                    }
                    if(ad==1){
                        player=1;
                        if(bd==1){
                            lh[7]=4;
                            lcount[lc]=8;
                            lc++;
                            cd=1;
                        }else if(bd==2){
                            lh[10]=4;
                            lcount[lc]=11;
                            lc++;
                            cd=1;
                        }else if(bd==3){
                            lv[9]=4;
                            lcount[lc]=22;
                            lc++;
                            cd=1;
                        }else if(bd==4){
                            lv[10]=4;
                            lcount[lc]=23;
                            lc++;
                            cd=1;
                        }
                    }
                }
                if(tim[8]==0){
                    ad=0;
                    if(lh[8]==0){
                        ad++;
                        bd=1;
                    }
                    if(lh[11]==0){
                        ad++;
                        bd=2;
                    }
                    if(lv[10]==0){
                        ad++;
                        bd=3;
                    }
                    if(lv[11]==0){
                        ad++;
                        bd=4;
                    }
                    if(ad==1){
                        player=1;
                        if(bd==1){
                            lh[8]=4;
                            lcount[lc]=9;
                            lc++;
                            cd=1;
                        }else if(bd==2){
                            lh[11]=4;
                            lcount[lc]=12;
                            lc++;
                            cd=1;
                        }else if(bd==3){
                            lv[10]=4;
                            lcount[lc]=23;
                            lc++;
                            cd=1;
                        }else if(bd==4){
                            lv[11]=4;
                            lcount[lc]=24;
                            lc++;
                            cd=1;
                        }
                    }
                }

                if(cd==0){
                    int lk = 0, jk = 0, ik = 0;

                    for (int o = 0; o < 24; o++) {
                        l[o] = 0;
                    }
                    for (int o = 0; o < 12; o++) {
                        if (lh[o] == 0) {
                            l[lk] = o + 1;
                            lk++;
                        }
                        if (lv[o] == 0) {
                            l[lk] = o + 13;
                            lk++;
                        }
                    }
                    if (lk > 0) {
                        jk = rand.nextInt(lk);
                    }
                    ik = l[jk];
                    if (ik < 13) {
                        lh[ik - 1] = 4;
                        player = 1;
                        lcount[lc] = ik;
                        lc++;
                    } else {
                        lv[ik - 13] = 4;
                        player = 1;
                        lcount[lc] = ik;
                        lc++;
                    }
                }

            }
        }

        int k;
        float cp = (float)(getWidth()/5);
        for(k=0;k<12;k++){
            if(lh[k]==1){
                canvas.drawLine(((k%3)+1)*cp , ((int)(k/3)+1)*cp , ((k%3)+2)*cp , ((int)(k/3)+1)*cp , mline);
            }
            else if(lh[k]==2||lh[k]==4){
                canvas.drawLine(((k%3)+1)*cp , ((int)(k/3)+1)*cp , ((k%3)+2)*cp , ((int)(k/3)+1)*cp , mline1);
            }
            else if(lh[k]==3){
                canvas.drawLine(((k%3)+1)*cp , ((int)(k/3)+1)*cp , ((k%3)+2)*cp , ((int)(k/3)+1)*cp , mline2);
            }
        }
        for(k=0;k<12;k++) {
            if (lv[k] == 1 ) {
                canvas.drawLine(((k % 4) + 1) * cp, ((int)(k / 4) + 1) * cp, ((k % 4) + 1) * cp, ((int)(k / 4) + 2) * cp, mline);
            }
            else if (lv[k] == 2 || lv[k] == 4) {
                canvas.drawLine(((k % 4) + 1) * cp, ((int)(k / 4) + 1) * cp, ((k % 4) + 1) * cp, ((int)(k / 4) + 2) * cp, mline1);
            }
            else if (lv[k] == 3 ) {
                canvas.drawLine(((k % 4) + 1) * cp, ((int)(k / 4) + 1) * cp, ((k % 4) + 1) * cp, ((int)(k / 4) + 2) * cp, mline2);
            }
        }

        if(lh[0]!=0 && lh[3]!=0 && lv[0]!=0 && lv[1]!=0 && tim[0]==0 && pr==0){
            if(nop==1){
                if(player==1){
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    player=0;
                    tim[0]=2;
                    pr=1;
                }
            }

            if(nop==2){
                if(player==2){
                    pa1.setColor(Color.RED);
                    sc1++;
                    player=1;
                    tim[0]=1;
                    pr=1;
                    box.start();
                }
                else {
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    player=2;
                    tim[0]=2;
                    pr=1;
                    box.start();
                }
            }
            else if(nop==3){
                if(player==2){
                    pa1.setColor(Color.RED);
                    sc1++;
                    player=1;
                    tim[0]=1;
                    pr=1;
                    box.start();
                }
                else if(player==3){
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    player=2;
                    tim[0]=2;
                    pr=1;
                    box.start();
                }
                else if(player==1){
                    pa1.setColor(Color.GREEN);
                    sc3++;
                    player=3;
                    tim[0]=3;
                    pr=1;
                    box.start();
                }
            }

            if(nop!=1) {
                p1.setText("Player 1 : " + sc1);
                p2.setText("Player 2 : " + sc2);
                p3.setText("Player 3 : " + sc3);
            }else{
                p1.setText("Player 1 : " + sc1);
                p2.setText("Device : " + sc2);
                p3.setText("Player 3 : " + sc3);
            }
        }
        if(lh[1]!=0 && lh[4]!=0 && lv[1]!=0 && lv[2]!=0 && tim[1]==0 && pr==0){
            if(nop==1){
                if(player==1){
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    player=0;
                    tim[1]=2;
                    pr=2;
                }
            }

            if(nop==2){
                if(player==2){
                    pa1.setColor(Color.RED);
                    sc1++;
                    player=1;
                    tim[1]=1;
                    pr=2;
                    box.start();
                }
                else {
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    player=2;
                    tim[1]=2;
                    pr=2;
                    box.start();
                }
            }
            else if(nop==3){
                if(player==2){
                    pa1.setColor(Color.RED);
                    sc1++;
                    player=1;
                    tim[1]=1;
                    pr=2;
                    box.start();
                }
                else if(player==3){
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    player=2;
                    tim[1]=2;
                    pr=2;
                    box.start();
                }
                else if(player==1){
                    pa1.setColor(Color.GREEN);
                    sc3++;
                    player=3;
                    tim[1]=3;
                    pr=2;
                    box.start();
                }
            }
            if(nop!=1) {
                p1.setText("Player 1 : " + sc1);
                p2.setText("Player 2 : " + sc2);
                p3.setText("Player 3 : " + sc3);
            }else{
                p1.setText("Player 1 : " + sc1);
                p2.setText("Device : " + sc2);
                p3.setText("Player 3 : " + sc3);
            }
        }
        if(lh[2]!=0 && lh[5]!=0 && lv[2]!=0 && lv[3]!=0 && tim[2]==0 && pr==0){
            if(nop==1){
                if(player==1){
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    player=0;
                    tim[2]=2;
                    pr=3;
                }
            }

            if(nop==2){
                if(player==2){
                    pa1.setColor(Color.RED);
                    sc1++;
                    player=1;
                    tim[2]=1;
                    pr=3;
                    box.start();
                }
                else {
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    player=2;
                    tim[2]=2;
                    pr=3;
                    box.start();
                }
            }
            else if(nop==3){
                if(player==2){
                    pa1.setColor(Color.RED);
                    sc1++;
                    player=1;
                    tim[2]=1;
                    pr=3;
                    box.start();
                }
                else if(player==3){
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    player=2;
                    tim[2]=2;
                    pr=3;
                    box.start();
                }
                else if(player==1){
                    pa1.setColor(Color.GREEN);
                    sc3++;
                    player=3;
                    tim[2]=3;
                    pr=3;
                    box.start();
                }
            }
            if(nop!=1) {
                p1.setText("Player 1 : " + sc1);
                p2.setText("Player 2 : " + sc2);
                p3.setText("Player 3 : " + sc3);
            }else{
                p1.setText("Player 1 : " + sc1);
                p2.setText("Device : " + sc2);
                p3.setText("Player 3 : " + sc3);
            }
        }
        if(lh[3]!=0 && lh[6]!=0 && lv[5]!=0 && lv[4]!=0 && tim[3]==0 && pr==0){
            if(nop==1){
                if(player==1){
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    player=0;
                    tim[3]=2;
                    pr=4;
                }
            }

            if(nop==2){
                if(player==2){
                    pa1.setColor(Color.RED);
                    sc1++;
                    player=1;
                    tim[3]=1;
                    pr=4;
                    box.start();
                }
                else {
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    player=2;
                    tim[3]=2;
                    pr=4;
                    box.start();
                }
            }
            else if(nop==3){
                if(player==2){
                    pa1.setColor(Color.RED);
                    sc1++;
                    player=1;
                    tim[3]=1;
                    pr=4;
                    box.start();
                }
                else if(player==3){
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    player=2;
                    tim[3]=2;
                    pr=4;
                    box.start();
                }
                else if(player==1){
                    pa1.setColor(Color.GREEN);
                    sc3++;
                    player=3;
                    tim[3]=3;
                    pr=4;
                    box.start();
                }
            }
            if(nop!=1) {
                p1.setText("Player 1 : " + sc1);
                p2.setText("Player 2 : " + sc2);
                p3.setText("Player 3 : " + sc3);
            }else{
                p1.setText("Player 1 : " + sc1);
                p2.setText("Device : " + sc2);
                p3.setText("Player 3 : " + sc3);
            }
        }
        if(lh[4]!=0 && lh[7]!=0 && lv[5]!=0 && lv[6]!=0 && tim[4]==0 && pr==0){
            if(nop==1){
                if(player==1){
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    player=0;
                    tim[4]=2;
                    pr=5;
                }
            }

            if(nop==2){
                if(player==2){
                    pa1.setColor(Color.RED);
                    sc1++;
                    player=1;
                    tim[4]=1;
                    pr=5;
                    box.start();
                }
                else {
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    player=2;
                    tim[4]=2;
                    pr=5;
                    box.start();
                }
            }
            else if(nop==3){
                if(player==2){
                    pa1.setColor(Color.RED);
                    sc1++;
                    player=1;
                    tim[4]=1;
                    pr=5;
                    box.start();
                }
                else if(player==3){
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    player=2;
                    tim[4]=2;
                    pr=5;
                    box.start();
                }
                else if(player==1){
                    pa1.setColor(Color.GREEN);
                    sc3++;
                    player=3;
                    tim[4]=3;
                    pr=5;
                    box.start();
                }
            }
            if(nop!=1) {
                p1.setText("Player 1 : " + sc1);
                p2.setText("Player 2 : " + sc2);
                p3.setText("Player 3 : " + sc3);
            }else{
                p1.setText("Player 1 : " + sc1);
                p2.setText("Device : " + sc2);
                p3.setText("Player 3 : " + sc3);
            }
        }

        if(lh[5]!=0 && lh[8]!=0 && lv[6]!=0 && lv[7]!=0 && tim[5]==0 && pr==0){
            if(nop==1){
                if(player==1){
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    player=0;
                    tim[5]=2;
                    pr=6;
                }
            }

            if(nop==2){
                if(player==2){
                    pa1.setColor(Color.RED);
                    sc1++;
                    player=1;
                    tim[5]=1;
                    pr=6;
                    box.start();
                }
                else {
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    player=2;
                    tim[5]=2;
                    pr=6;
                    box.start();
                }
            }
            else if(nop==3){
                if(player==2){
                    pa1.setColor(Color.RED);
                    sc1++;
                    player=1;
                    tim[5]=1;
                    pr=6;
                    box.start();
                }
                else if(player==3){
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    player=2;
                    tim[5]=2;
                    pr=6;
                    box.start();
                }
                else if(player==1){
                    pa1.setColor(Color.GREEN);
                    sc3++;
                    player=3;
                    tim[5]=3;
                    pr=6;
                    box.start();
                }
            }
            if(nop!=1) {
                p1.setText("Player 1 : " + sc1);
                p2.setText("Player 2 : " + sc2);
                p3.setText("Player 3 : " + sc3);
            }else{
                p1.setText("Player 1 : " + sc1);
                p2.setText("Device : " + sc2);
                p3.setText("Player 3 : " + sc3);
            }
        }

        if(lh[6]!=0 && lh[9]!=0 && lv[8]!=0 && lv[9]!=0 && tim[6]==0 && pr==0){
            if(nop==1){
                if(player==1){
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    player=0;
                    tim[6]=2;
                    pr=7;
                }
            }

            if(nop==2){
                if(player==2){
                    pa1.setColor(Color.RED);
                    sc1++;
                    player=1;
                    tim[6]=1;
                    pr=7;
                    box.start();
                }
                else {
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    player=2;
                    tim[6]=2;
                    pr=7;
                    box.start();
                }
            }
            else if(nop==3){
                if(player==2){
                    pa1.setColor(Color.RED);
                    sc1++;
                    player=1;
                    tim[6]=1;
                    pr=7;
                    box.start();
                }
                else if(player==3){
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    player=2;
                    tim[6]=2;
                    pr=7;
                    box.start();
                }
                else if(player==1){
                    pa1.setColor(Color.GREEN);
                    sc3++;
                    player=3;
                    tim[6]=3;
                    pr=7;
                    box.start();
                }
            }
            if(nop!=1) {
                p1.setText("Player 1 : " + sc1);
                p2.setText("Player 2 : " + sc2);
                p3.setText("Player 3 : " + sc3);
            }else{
                p1.setText("Player 1 : " + sc1);
                p2.setText("Device : " + sc2);
                p3.setText("Player 3 : " + sc3);
            }
        }

        if(lh[7]!=0 && lh[10]!=0 && lv[9]!=0 && lv[10]!=0 && tim[7]==0 && pr==0){
            if(nop==1){
                if(player==1){
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    player=0;
                    tim[7]=2;
                    pr=8;
                }
            }

            if(nop==2){
                if(player==2){
                    pa1.setColor(Color.RED);
                    sc1++;
                    player=1;
                    tim[7]=1;
                    pr=8;
                    box.start();
                }
                else {
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    player=2;
                    tim[7]=2;
                    pr=8;
                    box.start();
                }
            }
            else if(nop==3){
                if(player==2){
                    pa1.setColor(Color.RED);
                    sc1++;
                    player=1;
                    tim[7]=1;
                    pr=8;
                    box.start();
                }
                else if(player==3){
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    player=2;
                    tim[7]=2;
                    pr=8;
                    box.start();
                }
                else if(player==1){
                    pa1.setColor(Color.GREEN);
                    sc3++;
                    player=3;
                    tim[7]=3;
                    pr=8;
                    box.start();
                }
            }
            if(nop!=1) {
                p1.setText("Player 1 : " + sc1);
                p2.setText("Player 2 : " + sc2);
                p3.setText("Player 3 : " + sc3);
            }else{
                p1.setText("Player 1 : " + sc1);
                p2.setText("Device : " + sc2);
                p3.setText("Player 3 : " + sc3);
            }
        }

        if(lh[8]!=0 && lh[11]!=0 && lv[10]!=0 && lv[11]!=0 && tim[8]==0 && pr==0){
            if(nop==1){
                if(player==1){
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    player=0;
                    tim[8]=2;
                    pr=9;
                }
            }

            if(nop==2){
                if(player==2){
                    pa1.setColor(Color.RED);
                    sc1++;
                    player=1;
                    tim[8]=1;
                    pr=9;
                    box.start();
                }
                else {
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    player=2;
                    tim[8]=2;
                    pr=9;
                    box.start();
                }
            }
            else if(nop==3){
                if(player==2){
                    pa1.setColor(Color.RED);
                    sc1++;
                    player=1;
                    tim[8]=1;
                    pr=9;
                    box.start();
                }
                else if(player==3){
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    player=2;
                    tim[8]=2;
                    pr=9;
                    box.start();
                }
                else if(player==1){
                    pa1.setColor(Color.GREEN);
                    sc3++;
                    player=3;
                    tim[8]=3;
                    pr=9;
                    box.start();
                }
            }
            if(nop!=1) {
                p1.setText("Player 1 : " + sc1);
                p2.setText("Player 2 : " + sc2);
                p3.setText("Player 3 : " + sc3);
            }else{
                p1.setText("Player 1 : " + sc1);
                p2.setText("Device : " + sc2);
                p3.setText("Player 3 : " + sc3);
            }
        }


        if(lh[0]!=0 && lh[2]!=0 && lv[0]!=0 && lv[1]!=0 && tim[0]==0 && pr!=0 &&pr!=1){
            if(nop==1){
                if(player==0) {
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    tim[0] = 2;
                }
            }
            if(nop==2){
                if(player==1){
                    pa1.setColor(Color.RED);
                    sc1++;
                    tim[0]=1;
                }
                else {
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    tim[0]=2;
                }
            }
            else if(nop==3){
                if(player==1){
                    pa1.setColor(Color.RED);
                    sc1++;
                    tim[0]=1;
                }
                else if(player==2){
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    tim[0]=2;
                }
                else {
                    pa1.setColor(Color.GREEN);
                    sc3++;
                    tim[0]=3;
                }
            }
            if(nop!=1) {
                p1.setText("Player 1 : " + sc1);
                p2.setText("Player 2 : " + sc2);
                p3.setText("Player 3 : " + sc3);
            }else{
                p1.setText("Player 1 : " + sc1);
                p2.setText("Device : " + sc2);
                p3.setText("Player 3 : " + sc3);
            }
        }

        if(lh[1]!=0 && lh[4]!=0 && lv[1]!=0 && lv[2]!=0 && tim[1]==0 && pr!=0 && pr!=2){
            if(nop==1){
                if(player==0) {
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    tim[1] = 2;
                }
            }
            if(nop==2){
                if(player==1){
                    pa1.setColor(Color.RED);
                    sc1++;
                    tim[1]=1;
                }
                else {
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    tim[1]=2;
                }
            }
            else if(nop==3){
                if(player==1){
                    pa1.setColor(Color.RED);
                    sc1++;
                    tim[1]=1;
                }
                else if(player==2){
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    tim[1]=2;
                }
                else {
                    pa1.setColor(Color.GREEN);
                    sc3++;
                    tim[1]=3;
                }
            }
            if(nop!=1) {
                p1.setText("Player 1 : " + sc1);
                p2.setText("Player 2 : " + sc2);
                p3.setText("Player 3 : " + sc3);
            }else{
                p1.setText("Player 1 : " + sc1);
                p2.setText("Device : " + sc2);
                p3.setText("Player 3 : " + sc3);
            }
        }

        if(lh[2]!=0 && lh[5]!=0 && lv[2]!=0 && lv[3]!=0 && tim[2]==0 && pr!=0 && pr!=3){
            if(nop==1){
                if(player==0) {
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    tim[2] = 2;
                }
            }
            if(nop==2){
                if(player==1){
                    pa1.setColor(Color.RED);
                    sc1++;
                    tim[2]=1;
                }
                else {
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    tim[2]=2;
                }
            }
            else if(nop==3){
                if(player==1){
                    pa1.setColor(Color.RED);
                    sc1++;
                    tim[2]=1;
                }
                else if(player==2){
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    tim[2]=2;
                }
                else {
                    pa1.setColor(Color.GREEN);
                    sc3++;
                    tim[2]=3;
                }
            }
            if(nop!=1) {
                p1.setText("Player 1 : " + sc1);
                p2.setText("Player 2 : " + sc2);
                p3.setText("Player 3 : " + sc3);
            }else{
                p1.setText("Player 1 : " + sc1);
                p2.setText("Device : " + sc2);
                p3.setText("Player 3 : " + sc3);
            }
        }
        if(lh[3]!=0 && lh[6]!=0 && lv[5]!=0 && lv[4]!=0 && tim[3]==0 && pr!=0 && pr!=4){
            if(nop==1){
                if(player==0) {
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    tim[3] = 2;
                }
            }
            if(nop==2){
                if(player==1){
                    pa1.setColor(Color.RED);
                    sc1++;
                    tim[3]=1;
                }
                else {
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    tim[3]=2;
                }
            }
            else if(nop==3){
                if(player==1){
                    pa1.setColor(Color.RED);
                    sc1++;
                    tim[3]=1;
                }
                else if(player==2){
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    tim[3]=2;
                }
                else {
                    pa1.setColor(Color.GREEN);
                    sc3++;
                    tim[3]=3;
                }
            }
            if(nop!=1) {
                p1.setText("Player 1 : " + sc1);
                p2.setText("Player 2 : " + sc2);
                p3.setText("Player 3 : " + sc3);
            }else{
                p1.setText("Player 1 : " + sc1);
                p2.setText("Device : " + sc2);
                p3.setText("Player 3 : " + sc3);
            }
        }

        if(lh[4]!=0 && lh[7]!=0 && lv[5]!=0 && lv[6]!=0 && tim[4]==0 && pr!=0 && pr!=5){
            if(nop==1){
                if(player==0) {
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    tim[4] = 2;
                }
            }
            if(nop==2){
                if(player==1){
                    pa1.setColor(Color.RED);
                    sc1++;
                    tim[4]=1;
                }
                else {
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    tim[4]=2;
                }
            }
            else if(nop==3){
                if(player==1){
                    pa1.setColor(Color.RED);
                    sc1++;
                    tim[4]=1;
                }
                else if(player==2){
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    tim[4]=2;
                }
                else {
                    pa1.setColor(Color.GREEN);
                    sc3++;
                    tim[4]=3;
                }
            }
            if(nop!=1) {
                p1.setText("Player 1 : " + sc1);
                p2.setText("Player 2 : " + sc2);
                p3.setText("Player 3 : " + sc3);
            }else{
                p1.setText("Player 1 : " + sc1);
                p2.setText("Device : " + sc2);
                p3.setText("Player 3 : " + sc3);
            }
        }

        if(lh[5]!=0 && lh[8]!=0 && lv[6]!=0 && lv[7]!=0 && tim[5]==0 && pr!=0 && pr!=6){
            if(nop==1){
                if(player==0) {
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    tim[5] = 2;
                }
            }
            if(nop==2){
                if(player==1){
                    pa1.setColor(Color.RED);
                    sc1++;
                    tim[5]=1;
                }
                else {
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    tim[5]=2;
                }
            }
            else if(nop==3){
                if(player==1){
                    pa1.setColor(Color.RED);
                    sc1++;
                    tim[5]=1;
                }
                else if(player==2){
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    tim[5]=2;
                }
                else {
                    pa1.setColor(Color.GREEN);
                    sc3++;
                    tim[5]=3;
                }
            }
            if(nop!=1) {
                p1.setText("Player 1 : " + sc1);
                p2.setText("Player 2 : " + sc2);
                p3.setText("Player 3 : " + sc3);
            }else{
                p1.setText("Player 1 : " + sc1);
                p2.setText("Device : " + sc2);
                p3.setText("Player 3 : " + sc3);
            }
        }

        if(lh[6]!=0 && lh[9]!=0 && lv[8]!=0 && lv[9]!=0 && tim[6]==0 && pr!=0 && pr!=7){
            if(nop==1){
                if(player==0) {
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    tim[6] = 2;
                }
            }
            if(nop==2){
                if(player==1){
                    pa1.setColor(Color.RED);
                    sc1++;
                    tim[6]=1;
                }
                else {
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    tim[6]=2;
                }
            }
            else if(nop==3){
                if(player==1){
                    pa1.setColor(Color.RED);
                    sc1++;
                    tim[6]=1;
                }
                else if(player==2){
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    tim[6]=2;
                }
                else {
                    pa1.setColor(Color.GREEN);
                    sc3++;
                    tim[6]=3;
                }
            }
            if(nop!=1) {
                p1.setText("Player 1 : " + sc1);
                p2.setText("Player 2 : " + sc2);
                p3.setText("Player 3 : " + sc3);
            }else{
                p1.setText("Player 1 : " + sc1);
                p2.setText("Device : " + sc2);
                p3.setText("Player 3 : " + sc3);
            }
        }

        if(lh[7]!=0 && lh[10]!=0 && lv[9]!=0 && lv[10]!=0 && tim[7]==0 && pr!=0 && pr!=8){
            if(nop==1){
                if(player==0) {
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    tim[7] = 2;
                }
            }
            if(nop==2){
                if(player==1){
                    pa1.setColor(Color.RED);
                    sc1++;
                    tim[7]=1;
                }
                else {
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    tim[7]=2;
                }
            }
            else if(nop==3){
                if(player==1){
                    pa1.setColor(Color.RED);
                    sc1++;
                    tim[7]=1;
                }
                else if(player==2){
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    tim[7]=2;
                }
                else {
                    pa1.setColor(Color.GREEN);
                    sc3++;
                    tim[7]=3;
                }
            }
            if(nop!=1) {
                p1.setText("Player 1 : " + sc1);
                p2.setText("Player 2 : " + sc2);
                p3.setText("Player 3 : " + sc3);
            }else{
                p1.setText("Player 1 : " + sc1);
                p2.setText("Device : " + sc2);
                p3.setText("Player 3 : " + sc3);
            }
        }

        if(lh[8]!=0 && lh[11]!=0 && lv[10]!=0 && lv[11]!=0 && tim[8]==0 && pr!=0 && pr!=9){
            if(nop==1){
                if(player==0) {
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    tim[8] = 2;
                }
            }
            if(nop==2){
                if(player==1){
                    pa1.setColor(Color.RED);
                    sc1++;
                    tim[8]=1;
                }
                else {
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    tim[8]=2;
                }
            }
            else if(nop==3){
                if(player==1){
                    pa1.setColor(Color.RED);
                    sc1++;
                    tim[8]=1;
                }
                else if(player==2){
                    pa1.setColor(Color.BLUE);
                    sc2++;
                    tim[8]=2;
                }
                else {
                    pa1.setColor(Color.GREEN);
                    sc3++;
                    tim[8]=3;
                }
            }
            if(nop!=1) {
                p1.setText("Player 1 : " + sc1);
                p2.setText("Player 2 : " + sc2);
                p3.setText("Player 3 : " + sc3);
            }else{
                p1.setText("Player 1 : " + sc1);
                p2.setText("Device : " + sc2);
                p3.setText("Player 3 : " + sc3);
            }
        }

        if(tim[0]==1){
            pa1.setColor(Color.RED);
            canvas.drawRect(cp+25 , cp+25 , 2*cp-25 , 2*cp-25 , pa1);
        }
        else if(tim[0]==2){
            pa1.setColor(Color.BLUE);
            canvas.drawRect(cp+25 , cp+25 , 2*cp-25 , 2*cp-25 , pa1);
        }
        else if(tim[0]==3){
            pa1.setColor(Color.GREEN);
            canvas.drawRect(cp+25 , cp+25 , 2*cp-25 , 2*cp-25 , pa1);
        }

        if(tim[1]==1){
            pa1.setColor(Color.RED);
            canvas.drawRect(2*cp+25 , cp+25 , 3*cp-25 , 2*cp-25 , pa1);
        }
        else if(tim[1]==2){
            pa1.setColor(Color.BLUE);
            canvas.drawRect(2*cp+25 , cp+25 , 3*cp-25 , 2*cp-25 , pa1);
        }
        else if(tim[1]==3){
            pa1.setColor(Color.GREEN);
            canvas.drawRect(2*cp+25 , cp+25 , 3*cp-25 , 2*cp-25 , pa1);
        }

        if(tim[2]==1){
            pa1.setColor(Color.RED);
            canvas.drawRect(3*cp+25 , cp+25 , 4*cp-25 , 2*cp-25 ,pa1);
        }
        else if(tim[2]==2){
            pa1.setColor(Color.BLUE);
            canvas.drawRect(3*cp+25 , cp+25 , 4*cp-25 , 2*cp-25 ,pa1);
        }
        else if(tim[2]==3){
            pa1.setColor(Color.GREEN);
            canvas.drawRect(3*cp+25 , cp+25 , 4*cp-25 , 2*cp-25 ,pa1);
        }

        if(tim[3]==1){
            pa1.setColor(Color.RED);
            canvas.drawRect(cp+25 , 2*cp+25 , 2*cp-25 ,3*cp-25 ,pa1);
        }
        else if(tim[3]==2){
            pa1.setColor(Color.BLUE);
            canvas.drawRect(cp+25 , 2*cp+25 , 2*cp-25 ,3*cp-25 ,pa1);
        }
        else if(tim[3]==3){
            pa1.setColor(Color.GREEN);
            canvas.drawRect(cp+25 , 2*cp+25 , 2*cp-25 ,3*cp-25 ,pa1);
        }

        if(tim[4]==1){
            pa1.setColor(Color.RED);
            canvas.drawRect(2*cp+25 , 2*cp+25 , 3*cp-25 ,3*cp-25 ,pa1);
        }
        else if(tim[4]==2){
            pa1.setColor(Color.BLUE);
            canvas.drawRect(2*cp+25 , 2*cp+25 , 3*cp-25 ,3*cp-25 ,pa1);
        }
        else if(tim[4]==3){
            pa1.setColor(Color.GREEN);
            canvas.drawRect(2*cp+25 , 2*cp+25 , 3*cp-25 ,3*cp-25 ,pa1);
        }

        if(tim[5]==1){
            pa1.setColor(Color.RED);
            canvas.drawRect(3*cp+25 , 2*cp+25 , 4*cp-25 ,3*cp-25 ,pa1);
        }
        else if(tim[5]==2){
            pa1.setColor(Color.BLUE);
            canvas.drawRect(3*cp+25 , 2*cp+25 , 4*cp-25 ,3*cp-25 ,pa1);
        }
        else if(tim[5]==3){
            pa1.setColor(Color.GREEN);
            canvas.drawRect(3*cp+25 , 2*cp+25 , 4*cp-25 ,3*cp-25 ,pa1);
        }

        if(tim[6]==1){
            pa1.setColor(Color.RED);
            canvas.drawRect(cp+25 , 3*cp+25 , 2*cp-25 ,4*cp-25 ,pa1);
        }
        else if(tim[6]==2){
            pa1.setColor(Color.BLUE);
            canvas.drawRect(cp+25 , 3*cp+25 , 2*cp-25 ,4*cp-25 ,pa1);
        }
        else if(tim[6]==3){
            pa1.setColor(Color.GREEN);
            canvas.drawRect(cp+25 , 3*cp+25 , 2*cp-25 ,4*cp-25 ,pa1);
        }

        if(tim[7]==1){
            pa1.setColor(Color.RED);
            canvas.drawRect(2*cp+25 , 3*cp+25 , 3*cp-25 ,4*cp-25 ,pa1);
        }
        else if(tim[7]==2){
            pa1.setColor(Color.BLUE);
            canvas.drawRect(2*cp+25 , 3*cp+25 , 3*cp-25 ,4*cp-25 ,pa1);
        }
        else if(tim[7]==3){
            pa1.setColor(Color.GREEN);
            canvas.drawRect(2*cp+25 , 3*cp+25 , 3*cp-25 ,4*cp-25 ,pa1);
        }

        if(tim[8]==1){
            pa1.setColor(Color.RED);
            canvas.drawRect(3*cp+25 , 3*cp+25 , 4*cp-25 ,4*cp-25 ,pa1);
        }
        else if(tim[8]==2){
            pa1.setColor(Color.BLUE);
            canvas.drawRect(3*cp+25 , 3*cp+25 , 4*cp-25 ,4*cp-25 ,pa1);
        }
        else if(tim[8]==3){
            pa1.setColor(Color.GREEN);
            canvas.drawRect(3*cp+25 , 3*cp+25 , 4*cp-25 ,4*cp-25 ,pa1);
        }

        if(tim[0] != 0 && tim[1] != 0 && tim[2] != 0 && tim[3] != 0 && tim[4] != 0 && tim[5] != 0 && tim[6] != 0 && tim[7] != 0 && tim[8] != 0){

            if(nop==2||nop==1){
                if(sc1 > sc2&&nop==2){
                    Toast t = Toast.makeText(getContext() , "Player 1 Wins!!" , Toast.LENGTH_LONG);
                    t.setGravity(Gravity.CENTER | Gravity.BOTTOM , 0 , 0);
                    t.show();
                }
                else if(sc1 > sc2){
                    Toast t = Toast.makeText(getContext() , "You Win!!" , Toast.LENGTH_LONG);
                    t.setGravity(Gravity.CENTER | Gravity.BOTTOM , 0 , 0);
                    t.show();
                }
                else if (sc2 > sc1&&nop==2){
                    Toast t = Toast.makeText(getContext() , "Player 2 Wins!!" , Toast.LENGTH_LONG);
                    t.setGravity(Gravity.CENTER | Gravity.BOTTOM , 0 , 0);
                    t.show();
                }
                else if (sc2 > sc1){
                    Toast t = Toast.makeText(getContext() , "Device Wins!!" , Toast.LENGTH_LONG);
                    t.setGravity(Gravity.CENTER | Gravity.BOTTOM , 0 , 0);
                    t.show();
                }
                else
                {
                    Toast t = Toast.makeText(getContext() , "It's a Draw!!!" , Toast.LENGTH_LONG);
                    t.setGravity(Gravity.CENTER | Gravity.BOTTOM , 0 , 0);
                    t.show();
                }
            }
            else if(nop==3){
                if(sc1 > sc2 && sc1>sc3){
                    Toast t = Toast.makeText(getContext() , "Player 1 Wins!!" , Toast.LENGTH_LONG);
                    t.setGravity(Gravity.CENTER | Gravity.BOTTOM , 0 , 0);
                    t.show();
                }
                else if (sc2 > sc1 && sc2>sc3){
                    Toast t = Toast.makeText(getContext() , "Player 2 Wins!!" , Toast.LENGTH_LONG);
                    t.setGravity(Gravity.CENTER | Gravity.BOTTOM , 0 , 0);
                    t.show();
                }
                else if(sc3>sc1 && sc3>sc2)
                {
                    Toast t = Toast.makeText(getContext() , "Player 3 Wins!!" , Toast.LENGTH_LONG);
                    t.setGravity(Gravity.CENTER | Gravity.BOTTOM , 0 , 0);
                    t.show();
                }
                else
                {
                    Toast t = Toast.makeText(getContext() , "There's a Draw!!!" , Toast.LENGTH_LONG);
                    t.setGravity(Gravity.CENTER | Gravity.BOTTOM , 0 , 0);
                    t.show();
                }
            }
        }

        pr=0;

    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Boolean value = super.onTouchEvent(event);

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN: {

                return true;
            }

            case MotionEvent.ACTION_MOVE : {

                float x = event.getX();
                float y = event.getY();
                double cp = getWidth() * 0.20;
                double[] dx = new double[16];
                double[] dy = new double[16];
                l2x = x;
                l2y = y;

                for(int i=0;i<16;i++){
                    dx[i] = Math.pow(x- cp*((int)(i/4)+1),2);
                    dy[i] = Math.pow(y- cp*(i%4+1),2);
                }

                if(dx[0] +dy[0] < 1600 && stat==0){
                    eng=1;
                    return true;
                }
                else if(dx[1] +dy[1] < 1600 && stat==0){
                    eng=2;
                    return true;
                }
                else if(dx[2] +dy[2] < 1600 && stat==0){
                    eng=3;
                    return true;
                }
                else if(dx[3] +dy[3] < 1600 && stat==0){
                    eng=4;
                    return true;
                }
                else if(dx[4] +dy[4] < 1600 && stat==0){
                    eng=5;
                    return true;
                }
                else if(dx[5] +dy[5] < 1600 && stat==0){
                    eng=6;
                    return true;
                }
                else if(dx[6] +dy[6] < 1600 && stat==0){
                    eng=7;
                    return true;
                }
                else if(dx[7] +dy[7] < 1600 && stat==0){
                    eng=8;
                    return true;
                }
                else if(dx[8] +dy[8] < 1600 && stat==0){
                    eng=9;
                    return true;
                }
                else if(dx[9] +dy[9] < 1600 && stat==0){
                    eng=10;
                    return true;
                }
                else if(dx[10] +dy[10] < 1600 && stat==0){
                    eng=11;
                    return true;
                }
                else if(dx[11] +dy[11] < 1600 && stat==0){
                    eng=12;
                    return true;
                }
                else if(dx[12] +dy[12] < 1600 && stat==0){
                    eng=13;
                    return true;
                }
                else if(dx[13] +dy[13] < 1600 && stat==0){
                    eng=14;
                    return true;
                }
                else if(dx[14] +dy[14] < 1600 && stat==0){
                    eng=15;
                    return true;
                }
                else if(dx[15] +dy[15] < 1600 && stat==0){
                    eng=16;
                    return true;
                }

                l1x = x;
                l1y = y;

                if(eng==1 && stat==1){
                    if(dx[1]+dy[1]<1600 && lv[0]==0){
                        if(player==1){
                            lv[0]=1;
                            if(nop==1){
                                player=0;
                            }
                        }
                        else if(nop==2 || nop==3){
                            lv[0]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lv[0]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else if(nop==2){
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }
                        eng=0;
                        lcount[lc]=13;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[4]+dy[4]<1600 && lh[0]==0){
                        if(player==1){
                            lh[0]=1;
                            if(nop==1){
                                player=0;
                            }
                        }
                        else if(nop==2 || nop==3) {
                            lh[0]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lh[0]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else if(nop==2) {
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }
                        eng=0;
                        lcount[lc]=1;
                        lc++;
                        vibrator.vibrate(500);
                    }
                }
                else if(eng==2 && stat==1){
                    if(dx[0]+dy[0]<1600 && lv[0]==0){
                        if(player==1){
                            lv[0]=1;
                            if(nop==1){
                                player=0;
                            }                        }
                        else if(nop==2 || nop==3) {
                            lv[0]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lv[0]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else if(nop==2) {
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }

                        eng=0;
                        lcount[lc]=13;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[2]+dy[2]<1600 && lv[4]==0){
                        if(player==1){
                            lv[4]=1;
                            if(nop==1){
                                player=0;
                            }
                        }
                        else  if(nop==2 || nop==3){
                            lv[4]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lv[4]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else  if(nop==2){
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }

                        eng=0;
                        lcount[lc]=17;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[5]+dy[5]<1600 && lh[3]==0){
                        if(player==1){
                            lh[3]=1;
                            if(nop==1){
                                player=0;
                            }
                        }
                        else if(nop==2 || nop==3) {
                            lh[3]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lh[3]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else{
                                player=1;
                            }
                        }
                        else if(nop==2) {
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }

                        eng=0;
                        lcount[lc]=4;
                        lc++;
                        vibrator.vibrate(500);
                    }
                }
                else if(eng==3 && stat==1){
                    if(dx[1]+dy[1]<1600 && lv[4]==0){
                        if(player==1){
                            lv[4]=1;
                            if(nop==1){
                                player=0;
                            }
                        }
                        else if(nop==2 || nop==3) {
                            lv[4]=2;
                        }

                        if (nop == 3) {
                            if(player==3){
                                lv[4]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else if(nop==2) {
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }
                        eng=0;
                        lcount[lc]=17;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[6]+dy[6]<1600 && lh[6]==0){
                        if(player==1){
                            lh[6]=1;
                            if(nop==1){
                                player=0;
                            }              }
                        else if(nop==2 || nop==3) {
                            lh[6]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lh[6]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else  if(nop==2){
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }
                        eng=0;
                        lcount[lc]=7;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[3]+dy[3]<1600 && lv[8]==0){
                        if(player==1){
                            lv[8]=1;
                            if(nop==1){
                                player=0;
                            }              }
                        else if(nop==2 || nop==3) {
                            lv[8]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lv[8]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else  if(nop==2){
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }
                        eng=0;
                        lcount[lc]=21;
                        lc++;
                        vibrator.vibrate(500);
                    }
                }
                else if(eng==4 && stat==1){
                    if(dx[2]+dy[2]<1600 && lv[8]==0){
                        if(player==1){
                            lv[8]=1;
                            if(nop==1){
                                player=0;
                            }
                        }
                        else if(nop==2 || nop==3) {
                            lv[8]=2;
                        }

                        if (nop == 3) {
                            if(player==3){
                                lv[8]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else if(nop==2) {
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }
                        eng=0;
                        lcount[lc]=21;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[7]+dy[7]<1600 && lh[9]==0){
                        if(player==1){
                            lh[9]=1;
                            if(nop==1){
                                player=0;
                            }              }
                        else if(nop==2 || nop==3) {
                            lh[9]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lh[9]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else  if(nop==2){
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }
                        eng=0;
                        lcount[lc]=10;
                        lc++;
                        vibrator.vibrate(500);
                    }
                }
                else if(eng==5 && stat==1){
                    if(dx[0]+dy[0]<1600 && lh[0]==0){
                        if(player==1){
                            lh[0]=1;
                            if(nop==1){
                                player=0;
                            }}
                        else  if(nop==2 || nop==3){
                            lh[0]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lh[0]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else if(nop==2) {
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }
                        eng=0;
                        lcount[lc]=1;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[8]+dy[8]<1600 && lh[1]==0){
                        if(player==1){
                            lh[1]=1;
                            if(nop==1){
                                player=0;
                            }}
                        else  if(nop==2 || nop==3){
                            lh[1]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lh[1]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else if(nop==2) {
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }

                        eng=0;
                        lcount[lc]=2;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[5]+dy[5]<1600 && lv[1]==0){
                        if(player==1){
                            lv[1]=1;
                            if(nop==1){
                                player=0;
                            }}
                        else if(nop==2 || nop==3) {
                            lv[1]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lv[1]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else  if(nop==2){
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }

                        eng=0;
                        lcount[lc]=14;
                        lc++;
                        vibrator.vibrate(500);
                    }
                }
                else if(eng==6 && stat==1){
                    if(dx[1]+dy[1]<1600 && lh[3]==0){
                        if(player==1){
                            lh[3]=1;
                            if(nop==1){
                                player=0;
                            }}
                        else if(nop==2 || nop==3) {
                            lh[3]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lh[3]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else if(nop==2) {
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }
                        eng=0;
                        lcount[lc]=4;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[4]+dy[4]<1600 && lv[1]==0){
                        if(player==1){
                            lv[1]=1;
                            if(nop==1){
                                player=0;
                            }}
                        else  if(nop==2 || nop==3){
                            lv[1]=2;
                        }

                        if (nop == 3) {
                            if(player==3){
                                lv[1]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else if(nop==2) {
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }
                        eng=0;
                        lcount[lc]=14;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[6]+dy[6]<1600 && lv[5]==0){
                        if(player==1){
                            lv[5]=1;
                            if(nop==1){
                                player=0;
                            }}
                        else  if(nop==2 || nop==3){
                            lv[5]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lv[5]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else if(nop==2) {
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }

                        eng=0;
                        lcount[lc]=18;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[9]+dy[9]<1600 && lh[4]==0){
                        if(player==1){
                            lh[4]=1;
                            if(nop==1){
                                player=0;
                            }}
                        else  if(nop==2 || nop==3){
                            lh[4]=2;
                        }

                        if (nop == 3) {
                            if(player==3){
                                lh[4]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else if(nop==2) {
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }
                        eng=0;
                        lcount[lc]=5;
                        lc++;
                        vibrator.vibrate(500);
                    }
                }
                else if(eng==7 && stat==1){
                    if(dx[10]+dy[10]<1600 && lh[7]==0){
                        if(player==1){
                            lh[7]=1;
                            if(nop==1){
                                player=0;
                            }}
                        else  if(nop==2 || nop==3){
                            lh[7]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lh[7]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else if(nop==2) {
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }

                        eng=0;
                        lcount[lc]=8;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[2]+dy[2]<1600 && lh[6]==0){
                        if(player==1){
                            lh[6]=1;
                            if(nop==1){
                                player=0;
                            }}
                        else if(nop==2 || nop==3) {
                            lh[6]=2;
                        }

                        if (nop == 3) {
                            if(player==3){
                                lh[6]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else if(nop==2) {
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }
                        eng=0;
                        lcount[lc]=7;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[5]+dy[5]<1600 && lv[5]==0){
                        if(player==1){
                            lv[5]=1;
                            if(nop==1){
                                player=0;
                            }}
                        else  if(nop==2 || nop==3){
                            lv[5]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lv[5]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else if(nop==2) {
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }

                        eng=0;
                        lcount[lc]=18;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[7]+dy[7]<1600 && lv[9]==0){
                        if(player==1){
                            lv[9]=1;
                            if(nop==1){
                                player=0;
                            }}
                        else  if(nop==2 || nop==3){
                            lv[9]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lv[9]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else if(nop==2) {
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }

                        eng=0;
                        lcount[lc]=22;
                        lc++;
                        vibrator.vibrate(500);
                    }
                }
                else if(eng==8 && stat==1){
                    if(dx[3]+dy[3]<1600 && lh[9]==0){
                        if(player==1){
                            lh[9]=1;
                            if(nop==1){
                                player=0;
                            }}
                        else  if(nop==2 || nop==3){
                            lh[9]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lh[9]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else if(nop==2) {
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }

                        eng=0;
                        lcount[lc]=10;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[11]+dy[11]<1600 && lh[10]==0){
                        if(player==1){
                            lh[10]=1;
                            if(nop==1){
                                player=0;
                            }}
                        else if(nop==2 || nop==3) {
                            lh[10]=2;
                        }

                        if (nop == 3) {
                            if(player==3){
                                lh[10]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else if(nop==2) {
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }
                        eng=0;
                        lcount[lc]=11;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[6]+dy[6]<1600 && lv[9]==0){
                        if(player==1){
                            lv[9]=1;
                            if(nop==1){
                                player=0;
                            }}
                        else  if(nop==2 || nop==3){
                            lv[9]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lv[9]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else if(nop==2) {
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }

                        eng=0;
                        lcount[lc]=22;
                        lc++;
                        vibrator.vibrate(500);
                    }
                }

                else if(eng==9 && stat==1){
                    if(dx[4]+dy[4]<1600 && lh[1]==0){
                        if(player==1){
                            lh[1]=1;
                            if(nop==1){
                                player=0;
                            }}
                        else  if(nop==2 || nop==3){
                            lh[1]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lh[1]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else if(nop==2) {
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }
                        eng=0;
                        lcount[lc]=2;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[12]+dy[12]<1600 && lh[2]==0){
                        if(player==1){
                            lh[2]=1;
                            if(nop==1){
                                player=0;
                            }}
                        else  if(nop==2 || nop==3){
                            lh[2]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lh[2]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else if(nop==2) {
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }

                        eng=0;
                        lcount[lc]=3;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[9]+dy[9]<1600 && lv[2]==0){
                        if(player==1){
                            lv[2]=1;
                            if(nop==1){
                                player=0;
                            }}
                        else if(nop==2 || nop==3) {
                            lv[2]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lv[2]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else  if(nop==2){
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }

                        eng=0;
                        lcount[lc]=15;
                        lc++;
                        vibrator.vibrate(500);
                    }
                }
                else if(eng==10 && stat==1){
                    if(dx[5]+dy[5]<1600 && lh[4]==0){
                        if(player==1){
                            lh[4]=1;
                            if(nop==1){
                                player=0;
                            }}
                        else if(nop==2 || nop==3) {
                            lh[4]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lh[4]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else if(nop==2) {
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }
                        eng=0;
                        lcount[lc]=5;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[8]+dy[8]<1600 && lv[2]==0){
                        if(player==1){
                            lv[2]=1;
                            if(nop==1){
                                player=0;
                            }}
                        else  if(nop==2 || nop==3){
                            lv[2]=2;
                        }

                        if (nop == 3) {
                            if(player==3){
                                lv[2]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else if(nop==2) {
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }
                        eng=0;
                        lcount[lc]=15;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[10]+dy[10]<1600 && lv[6]==0){
                        if(player==1){
                            lv[6]=1;
                            if(nop==1){
                                player=0;
                            }}
                        else  if(nop==2 || nop==3){
                            lv[6]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lv[6]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else if(nop==2) {
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }

                        eng=0;
                        lcount[lc]=19;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[13]+dy[13]<1600 && lh[5]==0){
                        if(player==1){
                            lh[5]=1;
                            if(nop==1){
                                player=0;
                            }}
                        else  if(nop==2 || nop==3){
                            lh[5]=2;
                        }

                        if (nop == 3) {
                            if(player==3){
                                lh[5]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else if(nop==2) {
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }
                        eng=0;
                        lcount[lc]=6;
                        lc++;
                        vibrator.vibrate(500);
                    }
                }
                else if(eng==11 && stat==1){
                    if(dx[14]+dy[14]<1600 && lh[8]==0){
                        if(player==1){
                            lh[8]=1;
                            if(nop==1){
                                player=0;
                            }}
                        else  if(nop==2 || nop==3){
                            lh[8]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lh[8]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else if(nop==2) {
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }

                        eng=0;
                        lcount[lc]=9;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[6]+dy[6]<1600 && lh[7]==0){
                        if(player==1){
                            lh[7]=1;
                            if(nop==1){
                                player=0;
                            }}
                        else if(nop==2 || nop==3) {
                            lh[7]=2;
                        }

                        if (nop == 3) {
                            if(player==3){
                                lh[7]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else if(nop==2) {
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }
                        eng=0;
                        lcount[lc]=8;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[9]+dy[9]<1600 && lv[6]==0){
                        if(player==1){
                            lv[6]=1;
                            if(nop==1){
                                player=0;
                            }}
                        else  if(nop==2 || nop==3){
                            lv[6]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lv[6]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else if(nop==2) {
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }

                        eng=0;
                        lcount[lc]=19;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[11]+dy[11]<1600 && lv[10]==0){
                        if(player==1){
                            lv[10]=1;
                            if(nop==1){
                                player=0;
                            }}
                        else  if(nop==2 || nop==3){
                            lv[10]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lv[10]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else if(nop==2) {
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }

                        eng=0;
                        lcount[lc]=23;
                        lc++;
                        vibrator.vibrate(500);
                    }
                }
                else if(eng==12 && stat==1){
                    if(dx[7]+dy[7]<1600 && lh[10]==0){
                        if(player==1){
                            lh[10]=1;
                            if(nop==1){
                                player=0;
                            }}
                        else  if(nop==2 || nop==3){
                            lh[10]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lh[10]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else if(nop==2) {
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }

                        eng=0;
                        lcount[lc]=11;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[15]+dy[15]<1600 && lh[11]==0){
                        if(player==1){
                            lh[11]=1;
                            if(nop==1){
                                player=0;
                            }}
                        else if(nop==2 || nop==3) {
                            lh[11]=2;
                        }

                        if (nop == 3) {
                            if(player==3){
                                lh[11]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else if(nop==2) {
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }
                        eng=0;
                        lcount[lc]=12;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[10]+dy[10]<1600 && lv[10]==0){
                        if(player==1){
                            lv[10]=1;
                            if(nop==1){
                                player=0;
                            }}
                        else  if(nop==2 || nop==3){
                            lv[10]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lv[10]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else if(nop==2) {
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }

                        eng=0;
                        lcount[lc]=23;
                        lc++;
                        vibrator.vibrate(500);
                    }
                }
                else if(eng==13 && stat==1){
                    if(dx[13]+dy[13]<1600 && lv[3]==0){
                        if(player==1){
                            lv[3]=1;
                            if(nop==1){
                                player=0;
                            }
                        }
                        else if(nop==2 || nop==3){
                            lv[3]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lv[3]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else if(nop==2){
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }
                        eng=0;
                        lcount[lc]=16;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[8]+dy[8]<1600 && lh[2]==0){
                        if(player==1){
                            lh[2]=1;
                            if(nop==1){
                                player=0;
                            }
                        }
                        else if(nop==2 || nop==3) {
                            lh[2]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lh[2]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else if(nop==2) {
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }
                        eng=0;
                        lcount[lc]=3;
                        lc++;
                        vibrator.vibrate(500);
                    }
                }
                else if(eng==14 && stat==1){
                    if(dx[12]+dy[12]<1600 && lv[3]==0){
                        if(player==1){
                            lv[3]=1;
                            if(nop==1){
                                player=0;
                            }                        }
                        else if(nop==2 || nop==3) {
                            lv[3]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lv[3]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else if(nop==2) {
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }

                        eng=0;
                        lcount[lc]=16;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[14]+dy[14]<1600 && lv[7]==0){
                        if(player==1){
                            lv[7]=1;
                            if(nop==1){
                                player=0;
                            }
                        }
                        else  if(nop==2 || nop==3){
                            lv[7]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lv[7]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else  if(nop==2){
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }

                        eng=0;
                        lcount[lc]=20;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[9]+dy[9]<1600 && lh[5]==0){
                        if(player==1){
                            lh[5]=1;
                            if(nop==1){
                                player=0;
                            }
                        }
                        else if(nop==2 || nop==3) {
                            lh[5]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lh[5]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else{
                                player=1;
                            }
                        }
                        else if(nop==2) {
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }

                        eng=0;
                        lcount[lc]=6;
                        lc++;
                        vibrator.vibrate(500);
                    }
                }
                else if(eng==15 && stat==1){
                    if(dx[13]+dy[13]<1600 && lv[7]==0){
                        if(player==1){
                            lv[7]=1;
                            if(nop==1){
                                player=0;
                            }
                        }
                        else if(nop==2 || nop==3) {
                            lv[7]=2;
                        }

                        if (nop == 3) {
                            if(player==3){
                                lv[7]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else if(nop==2) {
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }
                        eng=0;
                        lcount[lc]=20;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[10]+dy[10]<1600 && lh[8]==0){
                        if(player==1){
                            lh[8]=1;
                            if(nop==1){
                                player=0;
                            }              }
                        else if(nop==2 || nop==3) {
                            lh[8]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lh[8]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else  if(nop==2){
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }
                        eng=0;
                        lcount[lc]=9;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[15]+dy[15]<1600 && lv[11]==0){
                        if(player==1){
                            lv[11]=1;
                            if(nop==1){
                                player=0;
                            }              }
                        else if(nop==2 || nop==3) {
                            lv[11]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lv[11]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else  if(nop==2){
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }
                        eng=0;
                        lcount[lc]=24;
                        lc++;
                        vibrator.vibrate(500);
                    }
                }
                else if(eng==16 && stat==1){
                    if(dx[14]+dy[14]<1600 && lv[11]==0){
                        if(player==1){
                            lv[11]=1;
                            if(nop==1){
                                player=0;
                            }
                        }
                        else if(nop==2 || nop==3) {
                            lv[11]=2;
                        }

                        if (nop == 3) {
                            if(player==3){
                                lv[11]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else if(nop==2) {
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }
                        eng=0;
                        lcount[lc]=24;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[11]+dy[11]<1600 && lh[11]==0){
                        if(player==1){
                            lh[11]=1;
                            if(nop==1){
                                player=0;
                            }              }
                        else if(nop==2 || nop==3) {
                            lh[11]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lh[11]=3;
                            }
                            if(player==1){
                                player=2;
                            }
                            else if(player==2) {
                                player=3;
                            }
                            else {
                                player=1;
                            }
                        }
                        else  if(nop==2){
                            if (player == 1) {
                                player = 2;
                            } else {
                                player = 1;
                            }
                        }
                        eng=0;
                        lcount[lc]=12;
                        lc++;
                        vibrator.vibrate(500);
                    }
                }
                stat = 1;
                postInvalidate();
                return value;
        }
        case MotionEvent.ACTION_UP : {
            postInvalidate();
            stat = 0;
            return value;
        }
    }

        return value;
}

    @SuppressLint("SetTextI18n")
    public void undomove(){
        if(lc!=0) {
            if ((tim[0] == 0 || tim[1] == 0 || tim[2] == 0 || tim[3] == 0 || tim[4] == 0 || tim[5] == 0 || tim[6] == 0 || tim[7] == 0 || tim[8] == 0) && lcount[lc - 1] != 0&&nop==1) {
                int b=lcount[lc-1],c,a;
                if(b<13){
                    b=lh[b-1];
                }
                else {
                    b=lv[b-13];
                }
                c=b;

                while(c==4){
                    a=sc2;
                    if (lcount[lc - 1] == 1) {
                        lh[0] = 0;
                        if (tim[0] != 0) {
                            a--;
                        }
                        lc--;
                        tim[0] = 0;
                    } else if (lcount[lc - 1] == 2) {
                        lh[1] = 0;
                        if (tim[1] != 0) {
                            a--;
                        }
                        tim[1] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 3) {
                        lh[2] = 0;
                        if (tim[2] != 0) {
                            a--;
                        }
                        tim[2] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 4) {
                        lh[3] = 0;
                        if (tim[0] != 0) {
                            a--;
                        }
                        if (tim[3] != 0) {
                            a--;
                        }
                        tim[0] = 0;
                        tim[3] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 5) {
                        lh[4] = 0;
                        if (tim[1] != 0) {
                            a--;
                        }
                        if (tim[4] != 0) {
                            a--;
                        }
                        tim[1] = 0;
                        tim[4] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 6) {
                        lh[5] = 0;
                        if (tim[2] != 0) {
                            a--;
                        }
                        if (tim[5] != 0) {
                            a--;
                        }
                        tim[2] = 0;
                        tim[5] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 7) {
                        lh[6] = 0;
                        if (tim[3] != 0) {
                            a--;
                        }
                        if (tim[6] != 0) {
                            a--;
                        }
                        tim[3] = 0;
                        tim[6] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 8) {
                        lh[7] = 0;
                        if (tim[4] != 0) {
                            a--;
                        }
                        if (tim[7] != 0) {
                            a--;
                        }
                        tim[4] = 0;
                        tim[7] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 9) {
                        lh[8] = 0;
                        if (tim[5] != 0) {
                            a--;
                        }
                        if (tim[8] != 0) {
                            a--;
                        }
                        tim[5] = 0;
                        tim[8] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 10) {
                        lh[9] = 0;
                        if (tim[6] != 0) {
                            a--;
                        }
                        tim[6] = 0;
                    } else if (lcount[lc - 1] == 11) {
                        lh[10] = 0;
                        if (tim[7] != 0) {
                            a--;
                        }
                        tim[7] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 12) {
                        lh[11] = 0;
                        if (tim[8] != 0) {
                            a--;
                        }
                        tim[8] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 13) {
                        lv[0] = 0;
                        if (tim[0] != 0) {
                            a--;
                        }
                        tim[0] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 14) {
                        lv[1] = 0;
                        if (tim[0] != 0) {
                            a--;
                        }
                        if (tim[1] != 0) {
                            a--;
                        }
                        tim[0] = 0;
                        tim[1] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 15) {
                        lv[2] = 0;
                        if (tim[1] != 0) {
                            a--;
                        }
                        if (tim[2] != 0) {
                            a--;
                        }
                        tim[1] = 0;
                        tim[2] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 16) {
                        lv[3] = 0;
                        if (tim[2] != 0) {
                            a--;
                        }
                        tim[2] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 17) {
                        lv[4] = 0;
                        if (tim[3] != 0) {
                            a--;
                        }
                        tim[3] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 18) {
                        lv[5] = 0;
                        if (tim[3] != 0) {
                            a--;
                        }
                        if (tim[4] != 0) {
                            a--;
                        }
                        tim[3] = 0;
                        tim[4] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 19) {
                        lv[6] = 0;
                        if (tim[4] != 0) {
                            a--;
                        }
                        if (tim[5] != 0) {
                            a--;
                        }
                        tim[4] = 0;
                        tim[5] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 20) {
                        lv[7] = 0;
                        if (tim[5] != 0) {
                            a--;
                        }
                        tim[5] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 21) {
                        lv[8] = 0;
                        if (tim[6] != 0) {
                            a--;
                        }
                        tim[6] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 22) {
                        lv[9] = 0;
                        if (tim[6] != 0) {
                            a--;
                        }
                        if (tim[7] != 0) {
                            a--;
                        }
                        tim[7] = 0;
                        tim[6] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 23) {
                        lv[10] = 0;
                        if (tim[7] != 0) {
                            a--;
                        }
                        if (tim[8] != 0) {
                            a--;
                        }
                        tim[8] = 0;
                        tim[7] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 24) {
                        lv[11] = 0;
                        if (tim[8] != 0) {
                            a--;
                        }
                        tim[8] = 0;
                        lc--;
                    }

                    sc2=a;

                    c=lcount[lc-1];
                    if(c<13){
                        c=lh[c-1];
                    }
                    else{
                        c=lv[c-13];
                    }

                }

                if(c==1) {
                    a = sc1;
                    if (lcount[lc - 1] == 1) {
                        lh[0] = 0;
                        if (tim[0] != 0) {
                            a--;
                        }
                        lc--;
                        tim[0] = 0;
                    } else if (lcount[lc - 1] == 2) {
                        lh[1] = 0;
                        if (tim[1] != 0) {
                            a--;
                        }
                        tim[1] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 3) {
                        lh[2] = 0;
                        if (tim[2] != 0) {
                            a--;
                        }
                        tim[2] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 4) {
                        lh[3] = 0;
                        if (tim[0] != 0) {
                            a--;
                        }
                        if (tim[3] != 0) {
                            a--;
                        }
                        tim[0] = 0;
                        tim[3] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 5) {
                        lh[4] = 0;
                        if (tim[1] != 0) {
                            a--;
                        }
                        if (tim[4] != 0) {
                            a--;
                        }
                        tim[1] = 0;
                        tim[4] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 6) {
                        lh[5] = 0;
                        if (tim[2] != 0) {
                            a--;
                        }
                        if (tim[5] != 0) {
                            a--;
                        }
                        tim[2] = 0;
                        tim[5] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 7) {
                        lh[6] = 0;
                        if (tim[3] != 0) {
                            a--;
                        }
                        if (tim[6] != 0) {
                            a--;
                        }
                        tim[3] = 0;
                        tim[6] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 8) {
                        lh[7] = 0;
                        if (tim[4] != 0) {
                            a--;
                        }
                        if (tim[7] != 0) {
                            a--;
                        }
                        tim[4] = 0;
                        tim[7] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 9) {
                        lh[8] = 0;
                        if (tim[5] != 0) {
                            a--;
                        }
                        if (tim[8] != 0) {
                            a--;
                        }
                        tim[5] = 0;
                        tim[8] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 10) {
                        lh[9] = 0;
                        if (tim[6] != 0) {
                            a--;
                        }
                        tim[6] = 0;
                    } else if (lcount[lc - 1] == 11) {
                        lh[10] = 0;
                        if (tim[7] != 0) {
                            a--;
                        }
                        tim[7] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 12) {
                        lh[11] = 0;
                        if (tim[8] != 0) {
                            a--;
                        }
                        tim[8] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 13) {
                        lv[0] = 0;
                        if (tim[0] != 0) {
                            a--;
                        }
                        tim[0] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 14) {
                        lv[1] = 0;
                        if (tim[0] != 0) {
                            a--;
                        }
                        if (tim[1] != 0) {
                            a--;
                        }
                        tim[0] = 0;
                        tim[1] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 15) {
                        lv[2] = 0;
                        if (tim[1] != 0) {
                            a--;
                        }
                        if (tim[2] != 0) {
                            a--;
                        }
                        tim[1] = 0;
                        tim[2] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 16) {
                        lv[3] = 0;
                        if (tim[2] != 0) {
                            a--;
                        }
                        tim[2] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 17) {
                        lv[4] = 0;
                        if (tim[3] != 0) {
                            a--;
                        }
                        tim[3] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 18) {
                        lv[5] = 0;
                        if (tim[3] != 0) {
                            a--;
                        }
                        if (tim[4] != 0) {
                            a--;
                        }
                        tim[3] = 0;
                        tim[4] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 19) {
                        lv[6] = 0;
                        if (tim[4] != 0) {
                            a--;
                        }
                        if (tim[5] != 0) {
                            a--;
                        }
                        tim[4] = 0;
                        tim[5] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 20) {
                        lv[7] = 0;
                        if (tim[5] != 0) {
                            a--;
                        }
                        tim[5] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 21) {
                        lv[8] = 0;
                        if (tim[6] != 0) {
                            a--;
                        }
                        tim[6] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 22) {
                        lv[9] = 0;
                        if (tim[6] != 0) {
                            a--;
                        }
                        if (tim[7] != 0) {
                            a--;
                        }
                        tim[7] = 0;
                        tim[6] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 23) {
                        lv[10] = 0;
                        if (tim[7] != 0) {
                            a--;
                        }
                        if (tim[8] != 0) {
                            a--;
                        }
                        tim[8] = 0;
                        tim[7] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 24) {
                        lv[11] = 0;
                        if (tim[8] != 0) {
                            a--;
                        }
                        tim[8] = 0;
                        lc--;
                    }
                    sc1 = a;
                }
            }
        }
        if(lc!=0) {
            if ((tim[0] == 0 || tim[1] == 0 || tim[2] == 0 || tim[3] == 0 || tim[4] == 0 || tim[5] == 0 || tim[6] == 0 || tim[7] == 0 || tim[8] == 0) && lcount[lc - 1] != 0&&nop!=1) {
                int a = 0, b = 0;
                if (player == 1) {
                    a = sc1;
                } else if (player == 2) {
                    a = sc2;
                } else if (player == 3) {
                    a = sc3;
                }
                if (lcount[lc - 1] == 1) {
                    lh[0] = 0;
                    if (tim[0] != 0) {
                        a--;
                        b = 1;
                    }
                    lc--;
                    tim[0] = 0;
                } else if (lcount[lc - 1] == 2) {
                    lh[1] = 0;
                    if (tim[1] != 0) {
                        a--;
                        b = 1;
                    }
                    tim[1] = 0;
                    lc--;
                } else if (lcount[lc - 1] == 3) {
                    lh[2] = 0;
                    if (tim[2] != 0) {
                        a--;
                        b = 1;
                    }
                    tim[2] = 0;
                    lc--;
                } else if (lcount[lc - 1] == 4) {
                    lh[3] = 0;
                    if (tim[0] != 0) {
                        a--;
                        b = 1;
                    }
                    if (tim[3] != 0) {
                        a--;
                        b = 1;
                    }
                    tim[0] = 0;
                    tim[3] = 0;
                    lc--;
                } else if (lcount[lc - 1] == 5) {
                    lh[4] = 0;
                    if (tim[1] != 0) {
                        a--;
                        b = 1;
                    }
                    if (tim[4] != 0) {
                        a--;
                        b = 1;
                    }
                    tim[1] = 0;
                    tim[4] = 0;
                    lc--;
                } else if (lcount[lc - 1] == 6) {
                    lh[5] = 0;
                    if (tim[2] != 0) {
                        a--;
                        b = 1;
                    }
                    if (tim[5] != 0) {
                        a--;
                        b = 1;
                    }
                    tim[2] = 0;
                    tim[5] = 0;
                    lc--;
                } else if (lcount[lc - 1] == 7) {
                    lh[6] = 0;
                    if (tim[3] != 0) {
                        a--;
                        b = 1;
                    }
                    if (tim[6] != 0) {
                        a--;
                        b = 1;
                    }
                    tim[3] = 0;
                    tim[6] = 0;
                    lc--;
                } else if (lcount[lc - 1] == 8) {
                    lh[7] = 0;
                    if (tim[4] != 0) {
                        a--;
                        b = 1;
                    }
                    if (tim[7] != 0) {
                        a--;
                        b = 1;
                    }
                    tim[4] = 0;
                    tim[7] = 0;
                    lc--;
                } else if (lcount[lc - 1] == 9) {
                    lh[8] = 0;
                    if (tim[5] != 0) {
                        a--;
                        b = 1;
                    }
                    if (tim[8] != 0) {
                        a--;
                        b = 1;
                    }
                    tim[5] = 0;
                    tim[8] = 0;
                    lc--;
                } else if (lcount[lc - 1] == 10) {
                    lh[9] = 0;
                    if (tim[6] != 0) {
                        a--;
                        b = 1;
                    }
                    tim[6] = 0;
                } else if (lcount[lc - 1] == 11) {
                    lh[10] = 0;
                    if (tim[7] != 0) {
                        a--;
                        b = 1;
                    }
                    tim[7] = 0;
                    lc--;
                } else if (lcount[lc - 1] == 12) {
                    lh[11] = 0;
                    if (tim[8] != 0) {
                        a--;
                        b = 1;
                    }
                    tim[8] = 0;
                    lc--;
                } else if (lcount[lc - 1] == 13) {
                    lv[0] = 0;
                    if (tim[0] != 0) {
                        a--;
                        b = 1;
                    }
                    tim[0] = 0;
                    lc--;
                } else if (lcount[lc - 1] == 14) {
                    lv[1] = 0;
                    if (tim[0] != 0) {
                        a--;
                        b = 1;
                    }
                    if (tim[1] != 0) {
                        a--;
                        b = 1;
                    }
                    tim[0] = 0;
                    tim[1] = 0;
                    lc--;
                } else if (lcount[lc - 1] == 15) {
                    lv[2] = 0;
                    if (tim[1] != 0) {
                        a--;
                        b = 1;
                    }
                    if (tim[2] != 0) {
                        a--;
                        b = 1;
                    }
                    tim[1] = 0;
                    tim[2] = 0;
                    lc--;
                } else if (lcount[lc - 1] == 16) {
                    lv[3] = 0;
                    if (tim[2] != 0) {
                        a--;
                        b = 1;
                    }
                    tim[2] = 0;
                    lc--;
                } else if (lcount[lc - 1] == 17) {
                    lv[4] = 0;
                    if (tim[3] != 0) {
                        a--;
                        b = 1;
                    }
                    tim[3] = 0;
                    lc--;
                } else if (lcount[lc - 1] == 18) {
                    lv[5] = 0;
                    if (tim[3] != 0) {
                        a--;
                        b = 1;
                    }
                    if (tim[4] != 0) {
                        a--;
                        b = 1;
                    }
                    tim[3] = 0;
                    tim[4] = 0;
                    lc--;
                } else if (lcount[lc - 1] == 19) {
                    lv[6] = 0;
                    if (tim[4] != 0) {
                        a--;
                        b = 1;
                    }
                    if (tim[5] != 0) {
                        a--;
                        b = 1;
                    }
                    tim[4] = 0;
                    tim[5] = 0;
                    lc--;
                } else if (lcount[lc - 1] == 20) {
                    lv[7] = 0;
                    if (tim[5] != 0) {
                        a--;
                        b = 1;
                    }
                    tim[5] = 0;
                    lc--;
                } else if (lcount[lc - 1] == 21) {
                    lv[8] = 0;
                    if (tim[6] != 0) {
                        a--;
                        b = 1;
                    }
                    tim[6] = 0;
                    lc--;
                } else if (lcount[lc - 1] == 22) {
                    lv[9] = 0;
                    if (tim[6] != 0) {
                        a--;
                        b = 1;
                    }
                    if (tim[7] != 0) {
                        a--;
                        b = 1;
                    }
                    tim[7] = 0;
                    tim[6] = 0;
                    lc--;
                } else if (lcount[lc - 1] == 23) {
                    lv[10] = 0;
                    if (tim[7] != 0) {
                        a--;
                        b = 1;
                    }
                    if (tim[8] != 0) {
                        a--;
                        b = 1;
                    }
                    tim[8] = 0;
                    tim[7] = 0;
                    lc--;
                } else if (lcount[lc - 1] == 24) {
                    lv[11] = 0;
                    if (tim[8] != 0) {
                        a--;
                        b = 1;
                    }
                    tim[8] = 0;
                    lc--;
                }
                if (b == 1) {
                    if (nop == 2) {
                        if (player == 1) {
                            sc1 = a;
                        } else {
                            sc2 = a;
                        }
                    } else {
                        if (player == 1) {
                            sc1 = a;
                        } else if (player == 2) {
                            sc2 = a;
                        } else if (player == 3) {
                            sc3 = a;
                        }
                    }
                } else {
                    if (nop == 2) {
                        if (player == 1) {
                            player = 2;
                        } else {
                            player = 1;
                        }
                    } else {
                        if (player == 2) {
                            player = 1;
                        } else if (player == 3) {
                            player = 2;
                        } else if (player == 1) {
                            player = 3;
                        }
                    }
                }
            }
        }
        if(nop!=1) {
            p1.setText("Player 1 : " + sc1);
            p2.setText("Player 2 : " + sc2);
            p3.setText("Player 3 : " + sc3);
        }else{
            p1.setText("Player 1 : " + sc1);
            p2.setText("Device : " + sc2);
            p3.setText("Player 3 : " + sc3);
        }
    }

    public void setnop(int a){
        if (a==3){
            nop=3;
        }
        else if(a==2){
            nop=2;
        }
        postInvalidate();
    }


    public void setDiff(int a){
        diff=a;
        postInvalidate();
    }


}