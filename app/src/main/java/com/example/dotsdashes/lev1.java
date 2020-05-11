package com.example.dotsdashes;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Parcelable;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Random;

import static android.content.Context.VIBRATOR_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

public class lev1 extends View {
    Context context;
    TextView p1,p2,p3;
    private Paint mcircle , mline , mline1 , mline2;
    public int stat=0,eng=0,player=1,sc1=0,sc2=0,sc3=0,pr=0, nop=1 , diff=1;
    float l1x , l1y , l2x , l2y;
    static int  lc = 0;
    int[] lh = new int[6];
    int[] lv = new int[6];
    int[] l = new int[12];
    int[] lcount = new int[12];
    private int[] tim = new int[4];
    private Paint pa1;
    Vibrator vibrator;
    Random rand;
    public lev1(Context context) {
        super(context);
        init(null);
        this.context=context;
    }

    public lev1(Context context, @Nullable AttributeSet attrs ) {
        super(context, attrs);
        init(attrs);
        this.context=context;
    }

    public lev1(Context context, @Nullable AttributeSet attrs, int defStyleAttr ) {
        super(context, attrs, defStyleAttr);
        init(attrs);
        this.context=context;
    }

    private void init(@Nullable AttributeSet set){
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
        for(int i=0;i<6;i++){
            lh[i]=lv[i]=0;
        }
        for(int i=0;i<4;i++){
            tim[i]=0;
        }
        pa1= new Paint();
        pa1.setAntiAlias(true);
        vibrator = (Vibrator)getContext().getSystemService(Context.VIBRATOR_SERVICE);
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
        for(i = (float)(getWidth()/4) ; i<=0.75*getWidth() ; i+=(float)(getWidth()/4)){
            for (j = (float)(getWidth()/4) ; j<=0.75*getWidth() ; j+=(float)(getWidth()/4)){
                canvas.drawCircle(i,j,40, mcircle);
            }
        }
        if(lh[0]!=0 && lh[2]!=0 && lv[0]!=0 && lv[1]!=0 && tim[0]==0 && pr==0){
            if(nop==1&&player==0){
                    pa1.setColor(Color.RED);
                    sc1++;
                    tim[0]=1;
                    pr=1;
                    player=1;
                    box.start();
                p1.setText("Player 1 : "+sc1);
                p2.setText("Player 2 : "+sc2);
                p3.setText("Player 3 : "+sc3);
            }
        }
        if(lh[1]!=0 && lh[3]!=0 && lv[1]!=0 && lv[2]!=0 && tim[1]==0 && pr==0) {
            if (nop == 1 && player == 0) {
                pa1.setColor(Color.RED);
                sc1++;
                tim[1] = 1;
                pr = 2;
                player=1;
                box.start();
                p1.setText("Player 1 : "+sc1);
                p2.setText("Player 2 : "+sc2);
                p3.setText("Player 3 : "+sc3);
            }
        }
        if(lh[2]!=0 && lh[4]!=0 && lv[3]!=0 && lv[4]!=0 && tim[2]==0 && pr==0) {
            if (nop == 1 && player == 0) {
                pa1.setColor(Color.RED);
                sc1++;
                tim[2] = 1;
                pr = 3;
                player=1;
                box.start();
                p1.setText("Player 1 : "+sc1);
                p2.setText("Player 2 : "+sc2);
                p3.setText("Player 3 : "+sc3);
            }
        }
        if(lh[3]!=0 && lh[5]!=0 && lv[5]!=0 && lv[4]!=0 && tim[3]==0 && pr==0) {
            if (nop == 1 && player == 0) {
                pa1.setColor(Color.RED);
                sc1++;
                tim[3] = 1;
                pr = 4;
                player=1;
                box.start();
                p1.setText("Player 1 : "+sc1);
                p2.setText("Player 2 : "+sc2);
                p3.setText("Player 3 : "+sc3);
            }
        }


        if(lh[0]!=0 && lh[2]!=0 && lv[0]!=0 && lv[1]!=0 && tim[0]==0 && pr!=0 &&pr!=1) {
            if (nop == 1 && player == 1) {
                pa1.setColor(Color.RED);
                sc1++;
                tim[0] = 1;
                p1.setText("Player 1 : "+sc1);
                p2.setText("Player 2 : "+sc2);
                p3.setText("Player 3 : "+sc3);
            }
        }
        if(lh[1]!=0 && lh[3]!=0 && lv[1]!=0 && lv[2]!=0 && tim[1]==0 && pr!=0 &&pr!=2) {
            if (nop == 1 && player == 1) {
                pa1.setColor(Color.RED);
                sc1++;
                tim[1] = 1;
                p1.setText("Player 1 : "+sc1);
                p2.setText("Player 2 : "+sc2);
                p3.setText("Player 3 : "+sc3);
            }
        }
        if(lh[2]!=0 && lh[4]!=0 && lv[3]!=0 && lv[4]!=0 && tim[2]==0 && pr!=0 &&pr!=3) {
            if (nop == 1 && player == 1) {
                pa1.setColor(Color.RED);
                sc1++;
                tim[2] = 1;
                p1.setText("Player 1 : "+sc1);
                p2.setText("Player 2 : "+sc2);
                p3.setText("Player 3 : "+sc3);
            }
        }
        if(lh[3]!=0 && lh[5]!=0 && lv[5]!=0 && lv[4]!=0 && tim[3]==0 && pr!=0 &&pr!=4) {
            if (nop == 1 && player == 1) {
                pa1.setColor(Color.RED);
                sc1++;
                tim[3] = 1;
                p1.setText("Player 1 : "+sc1);
                p2.setText("Player 2 : "+sc2);
                p3.setText("Player 3 : "+sc3);
            }
        }

        if(player==0 && nop==1 && (tim[0] == 0 || tim[1] == 0 || tim[2] == 0 || tim[3] == 0)) {
                    if(diff==1) {
                        int lk = 0, jk = 0, ik = 0;
                        for (int o = 0; o < 12; o++) {
                            l[o] = 0;
                        }
                        for (int o = 0; o < 6; o++) {
                            if (lh[o] == 0) {
                                l[lk] = o + 1;
                                lk++;
                            }
                            if (lv[o] == 0) {
                                l[lk] = o + 7;
                                lk++;
                            }
                        }
                        if (lk > 0) {
                            jk = rand.nextInt(lk);
                        }
                        ik = l[jk];
                        if (ik < 7) {
                            lh[ik - 1] = 4;
                            player = 1;
                            lcount[lc] = ik;
                            lc++;
                        } else {
                            lv[ik - 7] = 4;
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
                                if(lh[2]==0){
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
                                        lh[2]=4;
                                        lcount[lc]=3;
                                        lc++;
                                        cd=1;
                                    }else if(bd==3){
                                        lv[0]=4;
                                        lcount[lc]=7;
                                        lc++;
                                        cd=1;
                                    }else if(bd==4){
                                        lv[1]=4;
                                        lcount[lc]=8;
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
                                if(lh[3]==0){
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
                                        lh[3]=4;
                                        lcount[lc]=4;
                                        lc++;
                                        cd=1;
                                    }else if(bd==3){
                                        lv[1]=4;
                                        lcount[lc]=8;
                                        lc++;
                                        cd=1;
                                    }else if(bd==4){
                                        lv[2]=4;
                                        lcount[lc]=9;
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
                                if(lh[4]==0){
                                    ad++;
                                    bd=2;
                                }
                                if(lv[3]==0){
                                    ad++;
                                    bd=3;
                                }
                                if(lv[4]==0){
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
                                        lh[4]=4;
                                        lcount[lc]=5;
                                        lc++;
                                        cd=1;
                                    }else if(bd==3){
                                        lv[3]=4;
                                        lcount[lc]=10;
                                        lc++;
                                        cd=1;
                                    }else if(bd==4){
                                        lv[4]=4;
                                        lcount[lc]=11;
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
                                if(lh[5]==0){
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
                                        lh[5]=4;
                                        lcount[lc]=6;
                                        lc++;
                                        cd=1;
                                    }else if(bd==3){
                                        lv[4]=4;
                                        lcount[lc]=11;
                                        lc++;
                                        cd=1;
                                    }else if(bd==4){
                                        lv[5]=4;
                                        lcount[lc]=12;
                                        lc++;
                                        cd=1;
                                    }
                                }
                            }

                        if(cd==0){
                            int lk = 0, jk = 0, ik = 0;
                            for (int o = 0; o < 12; o++) {
                                l[o] = 0;
                            }
                            for (int o = 0; o < 6; o++) {
                                if (lh[o] == 0) {
                                    l[lk] = o + 1;
                                    lk++;
                                }
                                if (lv[o] == 0) {
                                    l[lk] = o + 7;
                                    lk++;
                                }
                            }
                            if (lk > 0) {
                                jk = rand.nextInt(lk);
                            }
                            ik = l[jk];
                            if (ik < 7) {
                                lh[ik - 1] = 4;
                                player = 1;
                                lcount[lc] = ik;
                                lc++;
                            } else {
                                lv[ik - 7] = 4;
                                player = 1;
                                lcount [lc]= ik;
                                lc++;
                            }
                        }
                    }
        }


        int k;
        float cp = (float)(getWidth()/4);
        for(k=0;k<6;k++){
            if(lh[k]==1){
                canvas.drawLine(((k%2)+1)*cp , ((int)(k/2)+1)*cp , ((k%2)+2)*cp , ((int)(k/2)+1)*cp , mline);
            }
            else if(lh[k]==2||lh[k]==4){
                canvas.drawLine(((k%2)+1)*cp , ((int)(k/2)+1)*cp , ((k%2)+2)*cp , ((int)(k/2)+1)*cp , mline1);
            }
            else if(lh[k]==3){
                canvas.drawLine(((k%2)+1)*cp , ((int)(k/2)+1)*cp , ((k%2)+2)*cp , ((int)(k/2)+1)*cp , mline2);
            }
        }
        for(k=0;k<6;k++){
            if(lv[k]==1&&k!=1&&k!=4){
                canvas.drawLine(((k%3)+1)*cp , ((k%2)+1)*cp , ((k%3)+1)*cp , ((k%2)+2)*cp , mline);
            }
            else if((lv[k]==2||lv[k]==4)&&k!=1&&k!=4){
                canvas.drawLine(((k%3)+1)*cp , ((k%2)+1)*cp , ((k%3)+1)*cp , ((k%2)+2)*cp , mline1);
            }
            else if(lv[k]==3&&k!=1&&k!=4){
                canvas.drawLine(((k%3)+1)*cp , ((k%2)+1)*cp , ((k%3)+1)*cp , ((k%2)+2)*cp , mline2);
            }
            if(lv[k]==1&&(k==1||k==4)){
                canvas.drawLine(((k%3)+1)*cp , ((int)(k/3)+1)*cp , ((k%3)+1)*cp , ((int)(k/3)+2)*cp , mline);
            }
            else if((lv[k]==2||lv[k]==4)&&(k==1||k==4)){
                canvas.drawLine(((k%3)+1)*cp , ((int)(k/3)+1)*cp , ((k%3)+1)*cp , ((int)(k/3)+2)*cp , mline1);
            }
            else if(lv[k]==3&&(k==1||k==4)){
                canvas.drawLine(((k%3)+1)*cp , ((int)(k/3)+1)*cp , ((k%3)+1)*cp , ((int)(k/3)+2)*cp , mline2);
            }
        }

        if(lh[0]!=0 && lh[2]!=0 && lv[0]!=0 && lv[1]!=0 && tim[0]==0 && pr==0){
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
            canvas.drawRect(cp+25 , cp+25 , 2*cp-25 , 2*cp-25 , pa1);

            p1.setText("Player 1 : "+sc1);
            p2.setText("Player 2 : "+sc2);
            p3.setText("Player 3 : "+sc3);
        }

        if(lh[1]!=0 && lh[3]!=0 && lv[1]!=0 && lv[2]!=0 && tim[1]==0 && pr==0){
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
            canvas.drawRect(2*cp+25 , cp+25 , 3*cp-25 , 2*cp-25 , pa1);
            p1.setText("Player 1 : "+sc1);
            p2.setText("Player 2 : "+sc2);
            p3.setText("Player 3 : "+sc3);
        }
        if(lh[2]!=0 && lh[4]!=0 && lv[3]!=0 && lv[4]!=0 && tim[2]==0 && pr==0){
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
            canvas.drawRect(cp+25 , 2*cp+25 , 2*cp-25 , 3*cp-25 ,pa1);
            p1.setText("Player 1 : "+sc1);
            p2.setText("Player 2 : "+sc2);
            p3.setText("Player 3 : "+sc3);
        }
        if(lh[3]!=0 && lh[5]!=0 && lv[5]!=0 && lv[4]!=0 && tim[3]==0 && pr==0){
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
            canvas.drawRect(2*cp+25 , 2*cp+25 , 3*cp-25 ,3*cp-25 ,pa1);
            p1.setText("Player 1 : "+sc1);
            p2.setText("Player 2 : "+sc2);
            p3.setText("Player 3 : "+sc3);
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
            canvas.drawRect(cp+25 , cp+25 , 2*cp-25 , 2*cp-25 , pa1);
            p1.setText("Player 1 : "+sc1);
            p2.setText("Player 2 : "+sc2);
            p3.setText("Player 3 : "+sc3);

        }

        if(lh[1]!=0 && lh[3]!=0 && lv[1]!=0 && lv[2]!=0 && tim[1]==0 && pr!=0 &&pr!=2){
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
            canvas.drawRect(2*cp+25 , cp+25 , 3*cp-25 , 2*cp-25 , pa1);
            p1.setText("Player 1 : "+sc1);
            p2.setText("Player 2 : "+sc2);
            p3.setText("Player 3 : "+sc3);
        }
        if(lh[2]!=0 && lh[4]!=0 && lv[3]!=0 && lv[4]!=0 && tim[2]==0 && pr!=0 &&pr!=3){
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
            canvas.drawRect(cp+25 , 2*cp+25 , 2*cp-25 , 3*cp-25 ,pa1);
            p1.setText("Player 1 : "+sc1);
            p2.setText("Player 2 : "+sc2);
            p3.setText("Player 3 : "+sc3);
        }
        if(lh[3]!=0 && lh[5]!=0 && lv[5]!=0 && lv[4]!=0 && tim[3]==0 && pr!=0 &&pr!=4){
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
            canvas.drawRect(2*cp+25 , 2*cp+25 , 3*cp-25 ,3*cp-25 ,pa1);
            p1.setText("Player 1 : "+sc1);
            p2.setText("Player 2 : "+sc2);
            p3.setText("Player 3 : "+sc3);
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
            canvas.drawRect(cp+25 , 2*cp+25 , 2*cp-25 , 3*cp-25 ,pa1);
        }
        else if(tim[2]==2){
            pa1.setColor(Color.BLUE);
            canvas.drawRect(cp+25 , 2*cp+25 , 2*cp-25 , 3*cp-25 ,pa1);
        }
        else if(tim[2]==3){
            pa1.setColor(Color.GREEN);
            canvas.drawRect(cp+25 , 2*cp+25 , 2*cp-25 , 3*cp-25 ,pa1);
        }
        if(tim[3]==1){
            pa1.setColor(Color.RED);
            canvas.drawRect(2*cp+25 , 2*cp+25 , 3*cp-25 ,3*cp-25 ,pa1);
        }
        else if(tim[3]==2){
            pa1.setColor(Color.BLUE);
            canvas.drawRect(2*cp+25 , 2*cp+25 , 3*cp-25 ,3*cp-25 ,pa1);
        }
        else if(tim[3]==3){
            pa1.setColor(Color.GREEN);
            canvas.drawRect(2*cp+25 , 2*cp+25 , 3*cp-25 ,3*cp-25 ,pa1);
        }
        if(tim[0] != 0 && tim[1] != 0 && tim[2] != 0 && tim[3] != 0){

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
                double cp = getWidth() * 0.25;
                double[] dx = new double[9];
                double[] dy = new double[9];
                l2x = x;
                l2y = y;

                for(int i=0;i<9;i++){
                    dx[i] = Math.pow(x- cp*((int)(i/3)+1),2);
                    dy[i] = Math.pow(y- cp*(i%3+1),2);
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
                        lcount[lc]=7;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[3]+dy[3]<1600 && lh[0]==0){
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
                        lcount[lc]=7;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[2]+dy[2]<1600 && lv[3]==0){
                        if(player==1){
                            lv[3]=1;
                            if(nop==1){
                                player=0;
                            }
                        }
                        else  if(nop==2 || nop==3){
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
                    else if(dx[4]+dy[4]<1600 && lh[2]==0){
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
                        lcount[lc]=3;
                        lc++;
                        vibrator.vibrate(500);
                    }
                }
                else if(eng==3 && stat==1){
                    if(dx[1]+dy[1]<1600 && lv[3]==0){
                        if(player==1){
                            lv[3]=1;
                            if(nop==1){
                                player=0;
                            }
                        }
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
                        lcount[lc]=10;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[5]+dy[5]<1600 && lh[4]==0){
                        if(player==1){
                            lh[4]=1;
                            if(nop==1){
                                player=0;
                            }              }
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
                        else  if(nop==2){
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
                else if(eng==4 && stat==1){
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
                    else if(dx[6]+dy[6]<1600 && lh[1]==0){
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
                    else if(dx[4]+dy[4]<1600 && lv[1]==0){
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
                        lcount[lc]=8;
                        lc++;
                        vibrator.vibrate(500);
                    }
                }
                else if(eng==5 && stat==1){
                    if(dx[1]+dy[1]<1600 && lh[2]==0){
                        if(player==1){
                            lh[2]=1;
                            if(nop==1){
                                player=0;
                            }}
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
                    else if(dx[3]+dy[3]<1600 && lv[1]==0){
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
                        lcount[lc]=8;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[5]+dy[5]<1600 && lv[4]==0){
                        if(player==1){
                            lv[4]=1;
                            if(nop==1){
                                player=0;
                            }}
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
                    else if(dx[7]+dy[7]<1600 && lh[3]==0){
                        if(player==1){
                            lh[3]=1;
                            if(nop==1){
                                player=0;
                            }}
                        else  if(nop==2 || nop==3){
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
                }
                else if(eng==6 && stat==1){
                    if(dx[8]+dy[8]<1600 && lh[5]==0){
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
                    else if(dx[2]+dy[2]<1600 && lh[4]==0){
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
                    else if(dx[4]+dy[4]<1600 && lv[4]==0){
                        if(player==1){
                            lv[4]=1;
                            if(nop==1){
                                player=0;
                            }}
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
                }
                else if(eng==7 && stat==1){
                    if(dx[7]+dy[7]<1600 && lv[2]==0){
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
                        lcount[lc]=9;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[3]+dy[3]<1600 && lh[1]==0){
                        if(player==1){
                            lh[1]=1;
                            if(nop==1){
                                player=0;
                            }}
                        else if(nop==2 || nop==3) {
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
                        else  if(nop==2){
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
                }
                else if(eng==8 && stat==1){
                    if(dx[8]+dy[8]<1600 && lv[5]==0){
                        if(player==1){
                            lv[5]=1;
                            if(nop==1){
                                player=0;
                            }}
                        else if(nop==2 || nop==3) {
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
                        lcount[lc]=12;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[6]+dy[6]<1600 && lv[2]==0){
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
                    else if(dx[4]+dy[4]<1600 && lh[3]==0){
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
                }
                else if(eng==9 && stat==1){
                    if(dx[7]+dy[7]<1600 && lv[5]==0){
                        if(player==1){
                            lv[5]=1;
                            if(nop==1){
                                player=0;
                            }}
                        else if(nop==2 || nop==3) {
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
                        lcount[lc]=12;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[5]+dy[5]<1600 && lh[5]==0){
                        if(player==1){
                            lh[5]=1;
                            if(nop==1){
                                player=0;
                            }}
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
            if ((tim[0] == 0 || tim[1] == 0 || tim[2] == 0 || tim[3] == 0) && lcount[lc - 1] != 0&&nop==1) {
                int b=lcount[lc-1],c,a;
                if(b<7){
                    b=lh[b-1];
                }
                else {
                    b=lv[b-7];
                }
                c=b;

                while(c==4) {
                    a = sc2;
                    if (lcount[lc - 1] == 1) {
                        lh[0] = 0;
                        if (tim[0] != 0) {
                            a--;
                        }
                        tim[0] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 2) {
                        lh[1] = 0;
                        if (tim[1] != 0) {
                            a--;
                        }
                        tim[1] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 3) {
                        lh[2] = 0;
                        if (tim[0] != 0) {
                            a--;
                        }
                        if (tim[2] != 0) {
                            a--;
                        }
                        tim[0] = 0;
                        tim[2] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 4) {
                        lh[3] = 0;
                        if (tim[1] != 0) {
                            a--;
                        }
                        if (tim[3] != 0) {
                            a--;
                        }
                        tim[1] = 0;
                        tim[3] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 5) {
                        lh[4] = 0;
                        if (tim[2] != 0) {
                            a--;
                        }
                        tim[2] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 6) {
                        lh[5] = 0;
                        if (tim[3] != 0) {
                            a--;
                        }
                        tim[3] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 7) {
                        lv[0] = 0;
                        if (tim[0] != 0) {
                            a--;
                        }
                        tim[0] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 8) {
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
                    } else if (lcount[lc - 1] == 9) {
                        lv[2] = 0;
                        if (tim[1] != 0) {
                            a--;
                        }
                        tim[1] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 10) {
                        lv[3] = 0;
                        if (tim[2] != 0) {
                            a--;
                        }
                        tim[2] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 11) {
                        lv[4] = 0;
                        if (tim[2] != 0) {
                            a--;
                        }
                        if (tim[3] != 0) {
                            a--;
                        }
                        tim[2] = 0;
                        tim[3] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 12) {
                        lv[5] = 0;
                        if (tim[3] != 0) {
                            a--;
                        }
                        tim[3] = 0;
                        lc--;
                    }

                    sc2 = a;
                    c=lcount[lc-1];
                    if(c<7){
                        c=lh[c-1];
                    }
                    else{
                        c=lv[c-7];
                    }
                }
                if(c==1){
                    a = sc1;
                    if (lcount[lc - 1] == 1) {
                        lh[0] = 0;
                        if (tim[0] != 0) {
                            a--;
                        }
                        tim[0] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 2) {
                        lh[1] = 0;
                        if (tim[1] != 0) {
                            a--;
                        }
                        tim[1] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 3) {
                        lh[2] = 0;
                        if (tim[0] != 0) {
                            a--;
                        }
                        if (tim[2] != 0) {
                            a--;
                        }
                        tim[0] = 0;
                        tim[2] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 4) {
                        lh[3] = 0;
                        if (tim[1] != 0) {
                            a--;
                        }
                        if (tim[3] != 0) {
                            a--;
                        }
                        tim[1] = 0;
                        tim[3] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 5) {
                        lh[4] = 0;
                        if (tim[2] != 0) {
                            a--;
                        }
                        tim[2] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 6) {
                        lh[5] = 0;
                        if (tim[3] != 0) {
                            a--;
                        }
                        tim[3] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 7) {
                        lv[0] = 0;
                        if (tim[0] != 0) {
                            a--;
                        }
                        tim[0] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 8) {
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
                    } else if (lcount[lc - 1] == 9) {
                        lv[2] = 0;
                        if (tim[1] != 0) {
                            a--;
                        }
                        tim[1] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 10) {
                        lv[3] = 0;
                        if (tim[2] != 0) {
                            a--;
                        }
                        tim[2] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 11) {
                        lv[4] = 0;
                        if (tim[2] != 0) {
                            a--;
                        }
                        if (tim[3] != 0) {
                            a--;
                        }
                        tim[2] = 0;
                        tim[3] = 0;
                        lc--;
                    } else if (lcount[lc - 1] == 12) {
                        lv[5] = 0;
                        if (tim[3] != 0) {
                            a--;
                        }
                        tim[3] = 0;
                        lc--;
                    }
                    sc1=a;
                }
                }
        }
        if(lc!=0) {
            if ((tim[0] == 0 || tim[1] == 0 || tim[2] == 0 || tim[3] == 0) && lcount[lc - 1] != 0&&nop!=1) {
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
                    tim[0] = 0;
                    lc--;
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
                    if (tim[0] != 0) {
                        a--;
                        b = 1;
                    }
                    if (tim[2] != 0) {
                        a--;
                        b = 1;
                    }
                    tim[0] = 0;
                    tim[2] = 0;
                    lc--;
                } else if (lcount[lc - 1] == 4) {
                    lh[3] = 0;
                    if (tim[1] != 0) {
                        a--;
                        b = 1;
                    }
                    if (tim[3] != 0) {
                        a--;
                        b = 1;
                    }
                    tim[1] = 0;
                    tim[3] = 0;
                    lc--;
                } else if (lcount[lc - 1] == 5) {
                    lh[4] = 0;
                    if (tim[2] != 0) {
                        a--;
                        b = 1;
                    }
                    tim[2] = 0;
                    lc--;
                } else if (lcount[lc - 1] == 6) {
                    lh[5] = 0;
                    if (tim[3] != 0) {
                        a--;
                        b = 1;
                    }
                    tim[3] = 0;
                    lc--;
                } else if (lcount[lc - 1] == 7) {
                    lv[0] = 0;
                    if (tim[0] != 0) {
                        a--;
                        b = 1;
                    }
                    tim[0] = 0;
                    lc--;
                } else if (lcount[lc - 1] == 8) {
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
                } else if (lcount[lc - 1] == 9) {
                    lv[2] = 0;
                    if (tim[1] != 0) {
                        a--;
                        b = 1;
                    }
                    tim[1] = 0;
                    lc--;
                } else if (lcount[lc - 1] == 10) {
                    lv[3] = 0;
                    if (tim[2] != 0) {
                        a--;
                        b = 1;
                    }
                    tim[2] = 0;
                    lc--;
                } else if (lcount[lc - 1] == 11) {
                    lv[4] = 0;
                    if (tim[2] != 0) {
                        a--;
                        b = 1;
                    }
                    if (tim[3] != 0) {
                        a--;
                        b = 1;
                    }
                    tim[2] = 0;
                    tim[3] = 0;
                    lc--;
                } else if (lcount[lc - 1] == 12) {
                    lv[5] = 0;
                    if (tim[3] != 0) {
                        a--;
                        b = 1;
                    }
                    tim[3] = 0;
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
        p1.setText("Player 1 : "+sc1);
        p2.setText("Player 2 : "+sc2);
        p3.setText("Player 3 : "+sc3);
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
