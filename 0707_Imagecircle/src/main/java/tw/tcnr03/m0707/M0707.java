package tw.tcnr03.m0707;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class M0707 extends AppCompatActivity implements View.OnClickListener {

    private TextView t001;
    private CircleImgView cimgview;
    private CircleImgbutton cimgbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0707);
        setupViewComponent();
    }

    private void setupViewComponent() {
        t001=(TextView)findViewById(R.id.m0707_t001);
        cimgview=(CircleImgView)findViewById(R.id.m0707_circleImgview);
        cimgbtn=(CircleImgbutton)findViewById(R.id.m0707_circleimagebutton);
        cimgview.setOnClickListener(this);
        cimgbtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.m0707_circleImgview:
                t001.setText(getString(R.string.m0707_t001)+getString(R.string.m0707_imgview));
                break;
            case R.id.m0707_circleimagebutton:
                t001.setText(getString(R.string.m0707_t001)+getString(R.string.m0707_imgbutton));
        }
    }
}