package tw.tcnr03.m0705;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import androidx.appcompat.app.AppCompatActivity;

public class M0705 extends AppCompatActivity implements
        ViewSwitcher.ViewFactory,
        View.OnClickListener{


    private TextView s001;
    private TextView f000;
    private String u_select;
    private String ans;
    private ImageButton b001;
    private ImageButton b002;
    private ImageButton b003;
    private ImageSwitcher c001;
    private MediaPlayer startmusic;
    private MediaPlayer win;
    private MediaPlayer lose;
    private MediaPlayer draw;
    private MediaPlayer endmusic;
    private ImageSwitcher imgSwi_comp;
    private RelativeLayout r_layout;

    private View.OnClickListener b001ON = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int iComp = (int) (Math.random() * 3 + 1);
// 1 - scissors, 2 - stone, 3 - net.
            switch (v.getId()) {
                case R.id.m0705_b001:
                    u_select = getString(R.string.m0705_s001) + getString(R.string.m0705_b001);
                    u_setalpha();
                    b001.getBackground().setAlpha(255);
                    switch (iComp) {
                        case 1:
                            c001.setImageResource(R.drawable.scissors);
//                        ans=getString(R.string.m0705_f000)+getString(R.string.m0705_f003);
//                        f000.setTextColor(Color.YELLOW);
                            music(2);
                            break;
                        case 2:
                            c001.setImageResource(R.drawable.stone);
//                        ans=getString(R.string.m0705_f000)+getString(R.string.m0705_f002);
//                        f000.setTextColor(Color.RED);
                            music(3);
                            break;
                        case 3:
                            c001.setImageResource(R.drawable.net);
//                        ans=getString(R.string.m0705_f000)+getString(R.string.m0705_f001);
//                        f000.setTextColor(Color.GREEN);
                            music(1);
                            break;
                    }
                    break;

//-------------------------------------------------------
                case R.id.m0705_b002:
                    u_select = getString(R.string.m0705_s001) + getString(R.string.m0705_b002);
                    u_setalpha();
                    b002.getBackground().setAlpha(255);
                    switch (iComp) {
                        case 1:
                            c001.setImageResource(R.drawable.stone);
//                        ans=getString(R.string.m0705_f000)+getString(R.string.m0705_f003);
//                        f000.setTextColor(Color.YELLOW);
                            music(2);
                            break;
                        case 2:
                            c001.setImageResource(R.drawable.net);
//                        ans=getString(R.string.m0705_f000)+getString(R.string.m0705_f002);
//                        f000.setTextColor(Color.RED);
                            music(3);
                            break;
                        case 3:
                            c001.setImageResource(R.drawable.scissors);
//                        ans=getString(R.string.m0705_f000)+getString(R.string.m0705_f001);
//                        f000.setTextColor(Color.GREEN);
                            music(1);
                            break;
                    }
                    break;

//-------------------------------------------------------
                case R.id.m0705_b003:
                    u_select = getString(R.string.m0705_s001) + getString(R.string.m0705_b003);
                    u_setalpha();
                    b003.getBackground().setAlpha(255);
                    switch (iComp) {
                        case 1:
                            c001.setImageResource(R.drawable.net);
//                        ans=getString(R.string.m0705_f000)+getString(R.string.m0705_f003);
//                        f000.setTextColor(Color.YELLOW);
                            music(2);
                            break;
                        case 2:
                            c001.setImageResource(R.drawable.scissors);
//                        ans=getString(R.string.m0705_f000)+getString(R.string.m0705_f002);
//                        f000.setTextColor(Color.RED);
                            music(3);
                            break;
                        case 3:
                            c001.setImageResource(R.drawable.stone);
//                        ans=getString(R.string.m0705_f000)+getString(R.string.m0705_f001);
//                        f000.setTextColor(Color.GREEN);
                            music(1);
                            break;
                    }
                    break;
            }
//           -------------電腦出拳增加動畫---------------
            imgSwi_comp.clearAnimation();
            Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_trans_in);//down
            anim.setInterpolator(new BounceInterpolator());//jump
            imgSwi_comp.setAnimation(anim);
//            -----------------------------------------------

            s001.setText(u_select);
            f000.setText(ans);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0705);
        setupViewComponent();
    }

    private void setupViewComponent() {
        b001 = (ImageButton) findViewById(R.id.m0705_b001);
//    startmusic = MediaPlayer.create(getApplication(), R.raw.guess);
//    startmusic.start();
        b002 = (ImageButton) findViewById(R.id.m0705_b002);
        b003 = (ImageButton) findViewById(R.id.m0705_b003);
        //--設定imageutton初始值為全透明B
        u_setalpha();
        c001 = (ImageSwitcher) findViewById(R.id.m0705_c001);
        s001 = (TextView) findViewById(R.id.m0705_s001);
        f000 = (TextView) findViewById(R.id.m0705_f000);
        //---電腦出拳---
        imgSwi_comp = (ImageSwitcher) findViewById(R.id.m0705_c001);
        imgSwi_comp.setFactory(this);
        // ---開機動畫---
        r_layout = (RelativeLayout) findViewById(R.id.m0705_r001);
        r_layout.setBackgroundResource(R.drawable.back01);
        r_layout.setAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_scale_rotate_out));
        r_layout.setAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_scale_rotate_in));
        r_layout.setBackgroundResource(R.drawable.back01);

        startmusic = MediaPlayer.create(getApplication(), R.raw.guess);
        startmusic.start();
        endmusic = MediaPlayer.create(getApplication(), R.raw.goodnight);
        win = MediaPlayer.create(getApplication(), R.raw.vctory);
        draw = MediaPlayer.create(getApplication(), R.raw.haha);
        lose = MediaPlayer.create(getApplication(), R.raw.lose);
        b001.setOnClickListener(b001ON);
        b002.setOnClickListener(b001ON);
        b003.setOnClickListener(b001ON);
    }

    private void u_setalpha() {
//        imageButton 背景為灰色且為全透明
//        setBackgroundColor(Color.XXX)為新方法，講義為舊方法。
        b001.setBackgroundResource(R.drawable.circle_shape);
        b001.getBackground().setAlpha(0); //0-255
        b002.setBackgroundResource(R.drawable.circle_shape);
        b002.getBackground().setAlpha(0);
        b003.setBackgroundResource(R.drawable.circle_shape);
        b003.getBackground().setAlpha(0);
    }


    private void music(int i) { //自定義方法
        if (startmusic.isPlaying()) startmusic.stop();
        if (win.isPlaying()) win.pause();
        if (draw.isPlaying()) draw.pause();
        if (lose.isPlaying()) lose.pause();

        switch (i) {
            case 1:
                win.start();
                ans = getString(R.string.m0705_f000) + getString(R.string.m0705_f001);
                f000.setTextColor(Color.GREEN);
                Toast.makeText(getApplicationContext(), R.string.m0705_f001,
                        Toast.LENGTH_LONG).show(); // 贏
                break;
            case 2:
                draw.start();
                ans = getString(R.string.m0705_f000) + getString(R.string.m0705_f003);
                f000.setTextColor(Color.YELLOW);
                Toast.makeText(getApplicationContext(), R.string.m0705_f003,
                        Toast.LENGTH_LONG).show(); // 平手
                break;
            case 3:
                lose.start();
                ans = getString(R.string.m0705_f000) + getString(R.string.m0705_f002);
                f000.setTextColor(Color.RED);
                Toast.makeText(getApplicationContext(), R.string.m0705_f002,
                        Toast.LENGTH_LONG).show(); // 贏
                break;
            case 4:
                endmusic.start();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        this.finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        music(4);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public View makeView() {
        ImageView v = new ImageView(this);
        // v.setBackgroundColor(0xFF000000);
        v.setScaleType(ImageView.ScaleType.FIT_CENTER);
        v.setLayoutParams(new
                ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        return v;
    }
}