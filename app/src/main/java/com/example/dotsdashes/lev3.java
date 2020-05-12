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

public class lev3 extends View {

    Context context;
    TextView p1,p2,p3;
    private Paint mcircle , mline , mline1 , mline2;
    public int stat=0,eng=0,player=1,sc1=0,sc2=0,sc3=0,pr=0, nop=1 , diff=1 , row, col;
    int  lc = 0;
    int[] lh = new int[90];
    int[] lv = new int[90];
    int[] l = new int[180];
    int[] lcount = new int[250];
    private int[] tim = new int[81];
    private Paint pa1;
    Vibrator vibrator;
    Random rand;
    public lev3(Context context) {
        super(context);
        init(null);
        this.context=context;
    }

    public lev3(Context context, @Nullable AttributeSet attrs ) {
        super(context, attrs);
        init(attrs);
        this.context=context;
    }

    public lev3(Context context, @Nullable AttributeSet attrs, int defStyleAttr ) {
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
        for(int i=0;i<90;i++){
            lh[i]=lv[i]=0;
        }
        for(int i=0;i<81;i++){
            tim[i]=0;
        }
        for(int i=0;i<180;i++){
            lcount[i]=0;
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
        float i,j;
        for(i = (float)(getWidth()/(col+1)) ; i<=(col)*(float)(getWidth()/(col+1)) ; i+=(float)(getWidth()/(col+1))){
            for (j = (float)(getHeight()/(row+1)) ; j<=(row)*(float)(getHeight()/(row+1)) ; j+=(float)(getHeight()/(row+1))){
                canvas.drawCircle(i,j,30, mcircle);
            }
        }
        final MediaPlayer box = MediaPlayer.create(getContext(),R.raw.applause3);
        for(int i1=0,j1=0,k1=0;k1<(col-1)*(row-1);i1++,j1++,k1++)
        {
            if(lh[i1]!=0 && lh[i1+col-1]!=0 && lv[j1]!=0 && lv[j1+1]!=0 && tim[k1]==0 && pr==0){
                if(nop==1&&player==0){
                    pa1.setColor(Color.RED);
                    sc1++;
                    tim[k1]=1;
                    pr=k1+1;
                    player=1;
                    box.start();
                    p1.setText("Player 1 : "+sc1);
                    p2.setText("Device : "+sc2);
                    p3.setText("Player 3 : "+sc3);
                }
            }
            if((i1+1)%(col-1)==0){
                j1++;
            }
        }
        for(int i1=0,j1=0,k1=0;k1<(col-1)*(row-1);i1++,j1++,k1++)
        {
            if(lh[i1]!=0 && lh[i1+col-1]!=0 && lv[j1]!=0 && lv[j1+1]!=0 && tim[k1]==0 && pr!=0 && pr!=k1+1){
                if(nop==1&&player==1){
                    pa1.setColor(Color.RED);
                    sc1++;
                    tim[k1]=1;
                    p1.setText("Player 1 : "+sc1);
                    p2.setText("Device : "+sc2);
                    p3.setText("Player 3 : "+sc3);
                }
            }
            if((i1+1)%(col-1)==0){
                j1++;
            }
        }

        boolean ugc=false;
        for(int i1=0 ; i1<(col-1)*(row-1);i1++){
            ugc=ugc||tim[i1]==0;
        }

        if(player==0 && nop==1 && ugc) {
        if(diff==1){

            int lk = 0, jk = 0, ik = 0;
            for (int o = 0; o < (col-1)*(row)+(row-1)*(col); o++) {
                l[o] = 0;
            }
            for (int o = 0; o <(col-1)*(row) ; o++) {
                if (lh[o] == 0) {
                    l[lk] = o + 1;
                    lk++;
                }
            }
            for (int o = 0; o <(col)*(row-1) ; o++) {
                if (lv[o] == 0) {
                    l[lk] = o + 1 +(col-1)*(row);
                    lk++;
                }
            }
            if (lk > 0) {
                jk = rand.nextInt(lk);
            }
            ik = l[jk];
            if (ik < (col-1)*(row)+1) {
                lh[ik - 1] = 4;
                player = 1;
                lcount[lc] = ik;
                lc++;
            } else {
                lv[ik - (1 +(col-1)*(row))] = 4;
                player = 1;
                lcount[lc] = ik;
                lc++;
            }
        }
        else if(diff==2){
            int ad=0,bd=0,cd=0;
            for(int i1=0,j1=0,k1=0;k1<(col-1)*(row-1);i1++,j1++,k1++){
                if(tim[k1]==0){
                    ad=0;
                    if(lh[i1]==0){
                        ad++;
                        bd=1;
                    }
                    if(lh[i1+col-1]==0){
                        ad++;
                        bd=2;
                    }
                    if(lv[j1]==0){
                        ad++;
                        bd=3;
                    }
                    if(lv[j1+1]==0){
                        ad++;
                        bd=4;
                    }
                    if(ad==1){
                        player=1;
                        if(bd==1){
                            lh[i1]=4;
                            lcount[lc]=i1+1;
                            lc++;
                            cd=1;
                        }else if(bd==2){
                            lh[i1+col-1]=4;
                            lcount[lc]=i1+col;
                            lc++;
                            cd=1;
                        }else if(bd==3){
                            lv[j1]=4;
                            lcount[lc]=j1+ 1 +(col-1)*(row);
                            lc++;
                            cd=1;
                        }else if(bd==4){
                            lv[j1+1]=4;
                            lcount[lc]=j1+2+(col-1)*(row);
                            lc++;
                            cd=1;
                        }
                    }
                }
                if((i1+1)%(col-1)==0){
                    j1++;
                }
            }

            if(cd==0){

                int lk = 0, jk = 0, ik = 0;
                for (int o = 0; o < (col-1)*(row)+(row-1)*(col); o++) {
                    l[o] = 0;
                }
                for (int o = 0; o <(col-1)*(row) ; o++) {
                    if (lh[o] == 0) {
                        l[lk] = o + 1;
                        lk++;
                    }
                }
                for (int o = 0; o <(col)*(row-1) ; o++) {
                    if (lv[o] == 0) {
                        l[lk] = o + 1 +(col-1)*(row);
                        lk++;
                    }
                }
                if (lk > 0) {
                    jk = rand.nextInt(lk);
                }
                ik = l[jk];
                if (ik < (col-1)*(row)+1) {
                    lh[ik - 1] = 4;
                    player = 1;
                    lcount[lc] = ik;
                    lc++;
                } else {
                    lv[ik - (1 +(col-1)*(row))] = 4;
                    player = 1;
                    lcount[lc] = ik;
                    lc++;
                }
            }

        }

        }


        int k;
        float cpc = (float)(getWidth()/(col+1));
        float cpl = (float)(getHeight()/(row+1));
        for(k=0;k<(col-1)*row;k++){
            if(lh[k]==1){
                canvas.drawLine(((k%(col-1))+1)*cpc , ((int)(k/(col-1))+1)*cpl , ((k%(col-1))+2)*cpc , ((int)(k/(col-1))+1)*cpl , mline);
            }
            else if(lh[k]==2||lh[k]==4){
                canvas.drawLine(((k%(col-1))+1)*cpc , ((int)(k/(col-1))+1)*cpl , ((k%(col-1))+2)*cpc , ((int)(k/(col-1))+1)*cpl , mline1);
            }
            else if(lh[k]==3){
                canvas.drawLine(((k%(col-1))+1)*cpc , ((int)(k/(col-1))+1)*cpl , ((k%(col-1))+2)*cpc , ((int)(k/(col-1))+1)*cpl , mline2);
            }
        }
        for(k=0;k<col*(row-1);k++) {
            if (lv[k] == 1 ) {
                canvas.drawLine(((k % col) + 1) * cpc, ((int)(k / col) + 1) * cpl, ((k % col) + 1) * cpc, ((int)(k / col) + 2) * cpl, mline);
            }
            else if (lv[k] == 2 || lv[k] == 4) {
                canvas.drawLine(((k % col) + 1) * cpc, ((int)(k / col) + 1) * cpl, ((k % col) + 1) * cpc, ((int)(k / col) + 2) * cpl, mline1);
            }
            else if (lv[k] == 3 ) {
                canvas.drawLine(((k % col) + 1) * cpc, ((int)(k / col) + 1) * cpl, ((k % col) + 1) * cpc, ((int)(k / col) + 2) * cpl, mline2);
            }
        }

        for(int i1=0,j1=0,k1=0;k1<(col-1)*(row-1);i1++,j1++,k1++)
        {
            if(lh[i1]!=0 && lh[i1+col-1]!=0 && lv[j1]!=0 && lv[j1+1]!=0 && tim[k1]==0 && pr==0){
                if(nop==1){
                    if(player==1){
                        pa1.setColor(Color.BLUE);
                        sc2++;
                        player=0;
                        tim[k1]=2;
                        pr=k1+1;
                    }
                }

                if(nop==2){
                    if(player==2){
                        pa1.setColor(Color.RED);
                        sc1++;
                        player=1;
                        tim[k1]=1;
                        pr=k1+1;
                        box.start();
                    }
                    else {
                        pa1.setColor(Color.BLUE);
                        sc2++;
                        player=2;
                        tim[k1]=2;
                        pr=k1+1;
                        box.start();
                    }
                }
                else if(nop==3){
                    if(player==2){
                        pa1.setColor(Color.RED);
                        sc1++;
                        player=1;
                        tim[k1]=1;
                        pr=k1+1;
                        box.start();
                    }
                    else if(player==3){
                        pa1.setColor(Color.BLUE);
                        sc2++;
                        player=2;
                        tim[k1]=2;
                        pr=k1+1;
                        box.start();
                    }
                    else if(player==1){
                        pa1.setColor(Color.GREEN);
                        sc3++;
                        player=3;
                        tim[k1]=3;
                        pr=k1+1;
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
            if((i1+1)%(col-1)==0){
                j1++;
            }
        }
        for(int i1=0,j1=0,k1=0;k1<(col-1)*(row-1);i1++,j1++,k1++)
        {
            if(lh[i1]!=0 && lh[i1+col-1]!=0 && lv[j1]!=0 && lv[j1+1]!=0 && tim[k1]==0 && pr!=0 && pr!=k1+1){
                if(nop==1){
                    if(player==0){
                        pa1.setColor(Color.BLUE);
                        sc2++;
                        tim[k1]=2;
                    }
                }

                if(nop==2){
                    if(player==1){
                        pa1.setColor(Color.RED);
                        sc1++;
                        tim[k1]=1;
                    }
                    else {
                        pa1.setColor(Color.BLUE);
                        sc2++;
                        tim[k1]=2;
                    }
                }
                else if(nop==3){
                    if(player==1){
                        pa1.setColor(Color.RED);
                        sc1++;
                        tim[k1]=1;
                    }
                    else if(player==2){
                        pa1.setColor(Color.BLUE);
                        sc2++;
                        tim[k1]=2;
                    }
                    else if(player==3){
                        pa1.setColor(Color.GREEN);
                        sc3++;
                        tim[k1]=3;
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
            if((i1+1)%(col-1)==0){
                j1++;
            }
        }

        for(int k1=0,h=1,v=1;k1<(row-1)*(col-1);k1++,h++) {
            if (tim[k1] == 1) {
                pa1.setColor(Color.RED);
                canvas.drawRect(h*cpc + 25, v * cpl + 25, (h+1) * cpc - 25, (v+1) * cpl - 25, pa1);
            } else if (tim[k1] == 2) {
                pa1.setColor(Color.BLUE);
                canvas.drawRect(h*cpc + 25, v * cpl + 25, (h+1) * cpc - 25, (v+1) * cpl - 25, pa1);
            } else if (tim[k1] == 3) {
                pa1.setColor(Color.GREEN);
                canvas.drawRect(h*cpc + 25, v * cpl + 25, (h+1) * cpc - 25, (v+1) * cpl - 25, pa1);
            }
            if(h==col-1){
                h=0;
                v++;
            }
        }

        int hrd=0;
        for(int i1=0;i1<(col-1)*(row-1);i1++){
            if(tim[i1]==0){
                hrd++;
            }
        }

        if(hrd==0){

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
        boolean value =  super.onTouchEvent(event);

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN: {

                return true;
            }
            case MotionEvent.ACTION_MOVE : {
                float x = event.getX();
                float y = event.getY();
                float cpc = (float)(getWidth()/(col+1));
                float cpl = (float)(getHeight()/(row+1));
                double[] dx = new double[100];
                double[] dy = new double[100];

                for(int i=0;i<row*col;i++){
                    dx[i] = Math.pow(x- cpc*((int)(i/row)+1),2);
                    dy[i] = Math.pow(y- cpl*(i%row+1),2);
                }
                for(int i=0;i<row*col;i++){
                    if(dx[i] +dy[i] < 1000 && stat==0){
                        eng=i+1;
                        return true;
                    }
                }

                if(eng==1 && stat==1){
                        if(dx[1]+dy[1]<1000 && lv[0]==0){
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
                            lcount[lc]=(col-1)*row+1;
                            lc++;
                            vibrator.vibrate(500);
                        }
                        else if(dx[row]+dy[row]<1000 && lh[0]==0){
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
                if(eng==row&&stat==1){
                    if(dx[row-2]+dy[row-2]<1000 && lv[col*(row-2)]==0){
                        if(player==1){
                            lv[col*(row-2)]=1;
                            if(nop==1){
                                player=0;
                            }
                        }
                        else if(nop==2 || nop==3){
                            lv[col*(row-2)]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lv[col*(row-2)]=3;
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
                        lcount[lc]=(col-1)*row+1+(row-2)*col;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[2*row-1]+dy[2*row-1]<1000 && lh[(row-1)*(col-1)]==0){
                        if(player==1){
                            lh[(row-1)*(col-1)]=1;
                            if(nop==1){
                                player=0;
                            }
                        }
                        else if(nop==2 || nop==3) {
                            lh[(row-1)*(col-1)]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lh[(row-1)*(col-1)]=3;
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
                        lcount[lc]=(row-1)*(col-1)+1;
                        lc++;
                        vibrator.vibrate(500);
                    }
                }
                if(eng==(col-1)*row+1 && stat==1){
                    if(dx[(col-1)*row+1]+dy[(col-1)*row+1]<1000 && lv[col-1]==0){
                        if(player==1){
                            lv[col-1]=1;
                            if(nop==1){
                                player=0;
                            }
                        }
                        else if(nop==2 || nop==3){
                            lv[col-1]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lv[col-1]=3;
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
                        lcount[lc]=(col-1)*row+col;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[(col-2)*row]+dy[(col-2)*row]<1000 && lh[col-2]==0){
                        if(player==1){
                            lh[col-2]=1;
                            if(nop==1){
                                player=0;
                            }
                        }
                        else if(nop==2 || nop==3) {
                            lh[col-2]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lh[col-2]=3;
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
                        lcount[lc]=col-1;
                        lc++;
                        vibrator.vibrate(500);
                    }
                }
                if(eng==col*row && stat==1){
                    if(dx[row*col-2]+dy[row*col-2]<1000 && lv[(row-1)*col-1]==0){
                        if(player==1){
                            lv[(row-1)*col-1]=1;
                            if(nop==1){
                                player=0;
                            }
                        }
                        else if(nop==2 || nop==3){
                            lv[(row-1)*col-1]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lv[(row-1)*col-1]=3;
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
                        lcount[lc]=(col-1)*row+(row-1)*col;
                        lc++;
                        vibrator.vibrate(500);
                    }
                    else if(dx[(col-1)*row-1]+dy[(col-1)*row-1]<1000 && lh[(row)*(col-1)-1]==0){
                        if(player==1){
                            lh[(row)*(col-1)-1]=1;
                            if(nop==1){
                                player=0;
                            }
                        }
                        else if(nop==2 || nop==3) {
                            lh[(row)*(col-1)-1]=2;
                        }
                        if (nop == 3) {
                            if(player==3){
                                lh[(row)*(col-1)-1]=3;
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
                        lcount[lc]=(row)*(col-1);
                        lc++;
                        vibrator.vibrate(500);
                    }
                }
                for(int i=row ;i<=(col-2)*row ;i+=row){
                    if(eng==i+1&&stat==1){
                        if(dx[i-row]+dy[i-row]<1000 && lh[i/row-1]==0){
                            if(player==1){
                                lh[i/row-1]=1;
                                if(nop==1){
                                    player=0;
                                }}
                            else  if(nop==2 || nop==3){
                                lh[i/row-1]=2;
                            }
                            if (nop == 3) {
                                if(player==3){
                                    lh[i/row-1]=3;
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
                            lcount[lc]=i/row;
                            lc++;
                            vibrator.vibrate(500);
                        }
                        else if(dx[i+row]+dy[i+row]<1000 && lh[i/row]==0){
                            if(player==1){
                                lh[i/row]=1;
                                if(nop==1){
                                    player=0;
                                }}
                            else  if(nop==2 || nop==3){
                                lh[i/row]=2;
                            }
                            if (nop == 3) {
                                if(player==3){
                                    lh[i/row]=3;
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
                            lcount[lc]=i/row+1;
                            lc++;
                            vibrator.vibrate(500);
                        }
                        else if(dx[i+1]+dy[i+1]<1000 && lv[i/row]==0){
                            if(player==1){
                                lv[i/row]=1;
                                if(nop==1){
                                    player=0;
                                }}
                            else if(nop==2 || nop==3) {
                                lv[i/row]=2;
                            }
                            if (nop == 3) {
                                if(player==3){
                                    lv[i/row]=3;
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
                            lcount[lc]=(col-1)*row+1+i/row;
                            lc++;
                            vibrator.vibrate(500);
                        }
                    }
                }
                for(int i=2*row-1;i<=((col-1)*row-1);i+=row){
                    if(eng==i+1&&stat==1){
                        if(dx[i-row]+dy[i-row]<1000 && lh[(col-1)*(row-1)+i/row-1]==0){
                            if(player==1){
                                lh[(col-1)*(row-1)+i/row-1]=1;
                                if(nop==1){
                                    player=0;
                                }}
                            else  if(nop==2 || nop==3){
                                lh[(col-1)*(row-1)+i/row-1]=2;
                            }
                            if (nop == 3) {
                                if(player==3){
                                    lh[(col-1)*(row-1)+i/row-1]=3;
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
                            lcount[lc]=(col-1)*(row-1)+i/row;
                            lc++;
                            vibrator.vibrate(500);
                        }
                        else if(dx[i+row]+dy[i+row]<1000 && lh[(col-1)*(row-1)+i/row]==0){
                            if(player==1){
                                lh[(col-1)*(row-1)+i/row]=1;
                                if(nop==1){
                                    player=0;
                                }}
                            else if(nop==2 || nop==3) {
                                lh[(col-1)*(row-1)+i/row]=2;
                            }

                            if (nop == 3) {
                                if(player==3){
                                    lh[(col-1)*(row-1)+i/row]=3;
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
                            lcount[lc]=(col-1)*(row-1)+i/row+1;
                            lc++;
                            vibrator.vibrate(500);
                        }
                        else if(dx[i-1]+dy[i-1]<1000 && lv[(row-2)*col+i/row]==0){
                            if(player==1){
                                lv[(row-2)*col+i/row]=1;
                                if(nop==1){
                                    player=0;
                                }}
                            else  if(nop==2 || nop==3){
                                lv[(row-2)*col+i/row]=2;
                            }
                            if (nop == 3) {
                                if(player==3){
                                    lv[(row-2)*col+i/row]=3;
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
                            lcount[lc]=(col-1)*row+(row-2)*col+i/row+1;
                            lc++;
                            vibrator.vibrate(500);
                        }
                    }
                }
                for(int i=1;i<=row-2;i++){
                    if(eng==i+1&&stat==1){
                        if(dx[i-1]+dy[i-1]<1000 && lv[(i-1)*col]==0){
                            if(player==1){
                                lv[(i-1)*col]=1;
                                if(nop==1){
                                    player=0;
                                }                        }
                            else if(nop==2 || nop==3) {
                                lv[(i-1)*col]=2;
                            }
                            if (nop == 3) {
                                if(player==3){
                                    lv[(i-1)*col]=3;
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
                            lcount[lc]=(col-1)*row+(i-1)*col+1;
                            lc++;
                            vibrator.vibrate(500);
                        }
                        else if(dx[i+1]+dy[i+1]<1000 && lv[i*col]==0){
                            if(player==1){
                                lv[i*col]=1;
                                if(nop==1){
                                    player=0;
                                }
                            }
                            else  if(nop==2 || nop==3){
                                lv[i*col]=2;
                            }
                            if (nop == 3) {
                                if(player==3){
                                    lv[i*col]=3;
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
                            lcount[lc]=(col-1)*row+(i)*col+1;
                            lc++;
                            vibrator.vibrate(500);
                        }
                        else if(dx[i+row]+dy[i+row]<1000 && lh[i*(col-1)]==0){
                            if(player==1){
                                lh[i*(col-1)]=1;
                                if(nop==1){
                                    player=0;
                                }
                            }
                            else if(nop==2 || nop==3) {
                                lh[i*(col-1)]=2;
                            }
                            if (nop == 3) {
                                if(player==3){
                                    lh[i*(col-1)]=3;
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
                            lcount[lc]=i*(col-1)+1;
                            lc++;
                            vibrator.vibrate(500);
                        }
                    }
                }

                for(int i=(col-1)*row+1;i<=(col-1)*row+row-2;i++){
                    if(eng==i+1&&stat==1){
                        if(dx[i-1]+dy[i-1]<1000 && lv[col-1+(i%row-1)*col]==0){
                            if(player==1){
                                lv[col-1+(i%row-1)*col]=1;
                                if(nop==1){
                                    player=0;
                                }}
                            else if(nop==2 || nop==3) {
                                lv[col-1+(i%row-1)*col]=2;
                            }

                            if (nop == 3) {
                                if(player==3){
                                    lv[col-1+(i%row-1)*col]=3;
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
                            lcount[lc]=(col-1)*row+col-1+(i%row-1)*col+1;
                            lc++;
                            vibrator.vibrate(500);
                        }
                        else if(dx[i+1]+dy[i+1]<1000 && lv[col-1+(i%row)*col]==0){
                            if(player==1){
                                lv[col-1+(i%row)*col]=1;
                                if(nop==1){
                                    player=0;
                                }}
                            else if(nop==2 || nop==3) {
                                lv[col-1+(i%row)*col]=2;
                            }
                            if (nop == 3) {
                                if(player==3){
                                    lv[col-1+(i%row)*col]=3;
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
                            lcount[lc]=(col-1)*row+col-1+(i%row)*col+1;
                            lc++;
                            vibrator.vibrate(500);
                        }
                        else if(dx[i-row]+dy[i-row]<1000 && lh[(i%row+1)*(col-1)-1]==0){
                            if(player==1){
                                lh[(i%row+1)*(col-1)-1]=1;
                                if(nop==1){
                                    player=0;
                                }}
                            else if(nop==2 || nop==3) {
                                lh[(i%row+1)*(col-1)-1]=2;
                            }

                            if (nop == 3) {
                                if(player==3){
                                    lh[(i%row+1)*(col-1)-1]=3;
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
                            lcount[lc]=(i%row+1)*(col-1);
                            lc++;
                            vibrator.vibrate(500);
                        }
                    }
                }
                for(int i=row+1;i<=(col-1)*row-2;i++){
                    if(eng==i+1&&stat==1){
                        if(dx[i-row]+dy[i-row]<1000 && lh[(col-1)*(i%row)+i/row-1]==0){
                            if(player==1){
                                lh[(col-1)*(i%row)+i/row-1]=1;
                                if(nop==1){
                                    player=0;
                                }}
                            else if(nop==2 || nop==3) {
                                lh[(col-1)*(i%row)+i/row-1]=2;
                            }
                            if (nop == 3) {
                                if(player==3){
                                    lh[(col-1)*(i%row)+i/row-1]=3;
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
                            lcount[lc]=(col-1)*(i%row)+i/row;
                            lc++;
                            vibrator.vibrate(500);
                        }
                        else if(dx[i-1]+dy[i-1]<1000 && lv[i/row+(i%row-1)*col]==0){
                            if(player==1){
                                lv[i/row+(i%row-1)*col]=1;
                                if(nop==1){
                                    player=0;
                                }}
                            else  if(nop==2 || nop==3){
                                lv[i/row+(i%row-1)*col]=2;
                            }

                            if (nop == 3) {
                                if(player==3){
                                    lv[i/row+(i%row-1)*col]=3;
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
                            lcount[lc]=(col-1)*row+i/row+(i%row-1)*col+1;
                            lc++;
                            vibrator.vibrate(500);
                        }
                        else if(dx[i+1]+dy[i+1]<1000 && lv[i/row+(i%row)*col]==0){
                            if(player==1){
                                lv[i/row+(i%row)*col]=1;
                                if(nop==1){
                                    player=0;
                                }}
                            else  if(nop==2 || nop==3){
                                lv[i/row+(i%row)*col]=2;
                            }
                            if (nop == 3) {
                                if(player==3){
                                    lv[i/row+(i%row)*col]=3;
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
                            lcount[lc]=(col-1)*row+i/row+(i%row)*col+1;
                            lc++;
                            vibrator.vibrate(500);
                        }
                        else if(dx[i+row]+dy[i+row]<1000 && lh[(col-1)*(i%row)+i/row]==0){
                            if(player==1){
                                lh[(col-1)*(i%row)+i/row]=1;
                                if(nop==1){
                                    player=0;
                                }}
                            else  if(nop==2 || nop==3){
                                lh[(col-1)*(i%row)+i/row]=2;
                            }

                            if (nop == 3) {
                                if(player==3){
                                    lh[(col-1)*(i%row)+i/row]=3;
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
                            lcount[lc]=(col-1)*(i%row)+i/row+1;
                            lc++;
                            vibrator.vibrate(500);
                        }

                    }
                    if((i+2)%row==0){
                        i+=2;
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
    public void undomove() {

        boolean ugc=false;
        for(int i1=0 ; i1<(col-1)*(row-1);i1++){
            ugc=ugc||tim[i1]==0;
        }
        if (lc != 0) {
            if (lcount[lc - 1] != 0 && nop == 1 && ugc) {
                int b=lcount[lc-1],c,a,d=0;
                if(b<=(col-1)*row){
                    b=lh[b-1];
                }
                else {
                    b=lv[b-(col-1)*row-1];
                }
                c=b;

                while(c==4) {
                    a = sc2;
                    if(d==0) {
                        for (int i = 0, j = 0; i < (col - 1) * row; i++, j++) {
                            if (lcount[lc - 1] == i + 1) {
                                lh[i] = 0;
                                if (tim[j] != 0) {
                                    a--;
                                }
                                if (i >= col - 1 && i < (row - 1) * (col - 1)) {
                                    if (tim[j - col + 1] != 0) {
                                        a--;
                                    }
                                    tim[j - col + 1] = 0;
                                }
                                lc--;
                                tim[j] = 0;
                                d++;
                                break;
                            }
                            if (j == (col - 1) * row - col) {
                                j = j - col + 1;
                            }
                        }
                    }
                    if(d==0) {
                        for (int i = 0, j = 0; i < col * (row - 1); i++, j++) {
                            if (lcount[lc - 1] == (col - 1) * row + 1 + i) {
                                lv[i] = 0;
                                if (tim[j] != 0) {
                                    a--;
                                }
                                if (i % col >= 1 && i % col <= col - 2) {
                                    if (tim[j - 1] != 0) {
                                        a--;
                                    }
                                    tim[j - 1] = 0;
                                }
                                tim[j] = 0;
                                lc--;
                                break;
                            }
                            if (i % col == col - 2) {
                                j--;
                            }
                        }
                    }
                    sc2=a;
                    c=lcount[lc-1];
                    if(c<=(col-1)*row){
                        c=lh[c-1];
                    }
                    else{
                        c=lv[c-(col-1)*row-1];
                    }

                }

                if(c==1){
                    a = sc1;
                    d=0;
                    if(d==0) {
                        for (int i = 0, j = 0; i < (col - 1) * row; i++, j++) {
                            if (lcount[lc - 1] == i + 1) {
                                lh[i] = 0;
                                if (tim[j] != 0) {
                                    a--;
                                }
                                if (i >= col - 1 && i < (row - 1) * (col - 1)) {
                                    if (tim[j - col + 1] != 0) {
                                        a--;
                                    }
                                    tim[j - col + 1] = 0;
                                }
                                lc--;
                                tim[j] = 0;
                                d++;
                                break;
                            }
                            if (j == (col - 1) * row - col) {
                                j = j - col + 1;
                            }
                        }
                    }
                    if(d==0) {
                        for (int i = 0, j = 0; i < col * (row - 1); i++, j++) {
                            if (lcount[lc - 1] == (col - 1) * row + 1 + i) {
                                lv[i] = 0;
                                if (tim[j] != 0) {
                                    a--;
                                }
                                if (i % col >= 1 && i % col <= col - 2) {
                                    if (tim[j - 1] != 0) {
                                        a--;
                                    }
                                    tim[j - 1] = 0;
                                }
                                tim[j] = 0;
                                lc--;
                                break;
                            }
                            if (i % col == col - 2) {
                                j--;
                            }
                        }
                    }
                    sc1=a;
                }
            }
        }
        if(lc!=0) {
            if (ugc && lcount[lc - 1] != 0&&nop!=1) {
                int a = 0, b = 0,d=0;
                if (player == 1) {
                    a = sc1;
                } else if (player == 2) {
                    a = sc2;
                } else if (player == 3) {
                    a = sc3;
                }
                if(d==0) {
                    for (int i = 0, j = 0; i < (col - 1) * row; i++, j++) {
                        if (lcount[lc - 1] == i + 1) {
                            lh[i] = 0;
                            if (tim[j] != 0) {
                                a--;
                                b = 1;
                            }
                            if (i >= col - 1 && i < (row - 1) * (col - 1)) {
                                if (tim[j - col + 1] != 0) {
                                    a--;
                                    b = 1;
                                }
                                tim[j - col + 1] = 0;
                            }
                            lc--;
                            tim[j] = 0;
                            d++;
                            break;
                        }
                        if (j == (col - 1) * row - col) {
                            j = j - col + 1;
                        }
                    }
                }
                if(d==0) {
                    for (int i = 0, j = 0; i < col * (row - 1); i++, j++) {
                        if (lcount[lc - 1] == (col - 1) * row + 1 + i) {
                            lv[i] = 0;
                            if (tim[j] != 0) {
                                a--;
                                b = 1;
                            }
                            if (i % col >= 1 && i % col <= col - 2) {
                                if (tim[j - 1] != 0) {
                                    a--;
                                    b = 1;
                                }
                                tim[j - 1] = 0;
                            }
                            tim[j] = 0;
                            lc--;
                            break;
                        }
                        if (i % col == col - 2) {
                            j--;
                        }
                    }
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
    public void setrc(int a , int b){
        row = a;
        col = b;
    }

}
