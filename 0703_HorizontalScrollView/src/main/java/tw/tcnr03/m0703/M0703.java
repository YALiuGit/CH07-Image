package tw.tcnr03.m0703;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import androidx.appcompat.app.AppCompatActivity;


//implements增加介面ViewFactory及OnItemClickListener
public class M0703 extends AppCompatActivity implements
        ViewSwitcher.ViewFactory,
        AdapterView.OnItemClickListener {
    // 圖庫的圖片索引
    private Integer[] imgArr = {
            R.drawable.img01, R.drawable.img02,
            R.drawable.img03, R.drawable.img04,
            R.drawable.img05, R.drawable.img06,
            R.drawable.img07, R.drawable.img08,
            R.drawable.img09, R.drawable.img10,
            R.drawable.img11, R.drawable.img12,
            R.drawable.img13, R.drawable.img14,
            R.drawable.img15, R.drawable.img16,
    };
//圖庫的縮圖索引
    private Integer[] thumbImgArr = {
            R.drawable.img01th, R.drawable.img02th,
            R.drawable.img03th, R.drawable.img04th,
            R.drawable.img05th, R.drawable.img06th,
            R.drawable.img07th, R.drawable.img08th,
            R.drawable.img09th, R.drawable.img10th,
            R.drawable.img11th, R.drawable.img12th,
            R.drawable.img13th, R.drawable.img14th,
            R.drawable.img15th, R.drawable.img16th,
    };
    private GridView gridview;
    private ImageSwitcher imgSwi;
    private int ss=1;

    //TAG="tcnr03=>";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0703);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.m0703, menu);
        setupViewComponet();
        return true;
    }

    private void setupViewComponet() {
        // 取得GridView元件
        gridview = (GridView) findViewById(R.id.m0703_g001);
        //將縮圖填入 GridView
        setGridView(); //自定義方法alt+[Enter]生成後，可按F4移動過去
        //-----------------------------
        // 從資源類別R中取得介面元件
        imgSwi = (ImageSwitcher) findViewById(R.id.m0703_im01);
        imgSwi.setFactory((ViewSwitcher.ViewFactory) this); // 必須implements ViewSwitcher.ViewFactory
        // GridView元件的事件處理
        gridview.setOnItemClickListener((AdapterView.OnItemClickListener) this);

    }

    private void setGridView() {
        int size = thumbImgArr.length; //找出需放幾張圖，此為縮圖的長度(是動態的)
        int length = 120; //縮圖的寬度
        //----------------------
        DisplayMetrics dm = new DisplayMetrics(); //找出使用者手機的寬高
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        float density = dm.density;
        float w=dm.widthPixels;
        float h=dm.heightPixels;
        int gridviewWidth = (int) (size * (length + 4) * density*0.9); //4為間格,整行代表整個水平選單的寬度
        int itemWidth = (int) (length * density*0.9); //每個縮圖佔的寬度
//String aa="等一下";
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                gridviewWidth, LinearLayout.LayoutParams.WRAP_CONTENT);
        gridview.setLayoutParams(params);
        gridview.setColumnWidth(itemWidth);
        gridview.setHorizontalSpacing(10); // 間距
//        int a=0;
        gridview.setStretchMode(GridView.NO_STRETCH); //
        gridview.setNumColumns(size); //
        gridview.setAdapter(new GridAdapter(this, thumbImgArr));
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (item.getItemId()) {
//            case R.id.m_about:
//                intent.putExtra("class_title",getString(R.string.));
//                intent.setClass(Menu01.this,Menu02.class);
//                break;
            case R.id.item01:
                ss=1;
                break;
            case R.id.item02:
                ss=2;
                break;
            case R.id.item03:
                ss=3;
                break;
            case R.id.item04:
                ss=4;
                break;
            case R.id.item05:
                ss=5;
                break;
            case R.id.action_settings:
                this.finish();
                break;
        }

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            this.finish();
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public View makeView() {
        ImageView v = new ImageView(this);
        v.setBackgroundColor(0x00000000);
        v.setLayoutParams(new ImageSwitcher.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        imgSwi.destroyDrawingCache();
        imgSwi.setAnimation(null);
        imgSwi.setOutAnimation(null);
        imgSwi.setInAnimation(null);
        imgSwi.clearAnimation();

        switch (ss){
            case 1: //  透明
            imgSwi.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_alpha_out ));
            imgSwi.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_alpha_in));
            Toast.makeText(getApplicationContext(), R.string.m0703_alpha, Toast.LENGTH_SHORT).show();
            break;
            case 2: //  位移
                imgSwi.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_trans_out ));
                imgSwi.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_trans_in));
                Toast.makeText(getApplicationContext(), R.string.m0703_trans, Toast.LENGTH_SHORT).show();
                break;
            case 3: //  旋轉
                imgSwi.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_scale_rotate_out ));
                imgSwi.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_scale_rotate_in));
                Toast.makeText(getApplicationContext(), R.string.m0703_rotate, Toast.LENGTH_SHORT).show();
                break;
            case 4:// 彈跳
                Animation anim = AnimationUtils.loadAnimation(this, R.anim.anim_trans_bounce);
                anim.setInterpolator(new BounceInterpolator());
                imgSwi.setAnimation(anim);
                Toast.makeText(getApplicationContext(), getString(R.string.m0703_bounce), Toast.LENGTH_SHORT).show();
                break;
            case 5:// 自定義效果
                imgSwi.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_user_out ));
                imgSwi.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_user_in));
                Toast.makeText(getApplicationContext(), R.string.m0703_user, Toast.LENGTH_SHORT).show();
                break;
        }
//        ========================================================
        imgSwi.setImageResource(imgArr[position]);
    }
}