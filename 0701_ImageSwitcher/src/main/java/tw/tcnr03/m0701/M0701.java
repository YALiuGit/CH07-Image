package tw.tcnr03.m0701;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

//implements增加介面ViewFactory及OnItemClickListener
public class M0701 extends AppCompatActivity implements
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

    //TAG="tcnr03=>";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0701);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.m0701, menu);
        setupViewComponet();
        return true;
    }

    private void setupViewComponet() {
        // 取得GridView元件
        gridview = (GridView) findViewById(R.id.m0701_g001);
        // 從資源類別R中取得介面元件
        imgSwi = (ImageSwitcher) findViewById(R.id.m0701_im01);
        imgSwi.setFactory((ViewSwitcher.ViewFactory) this); // 必須implements ViewSwitcher.ViewFactory
        //將縮圖填入 GridView
//        gridview.setAdapter(new GridAdapter(this, thumbImgArr));
        gridview.setAdapter(new GridAdapter(this, thumbImgArr));

        // GridView元件的事件處理
        gridview.setOnItemClickListener((AdapterView.OnItemClickListener) this);
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
        v.setBackgroundColor(0xFF000000);
        v.setLayoutParams(new ImageSwitcher.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        imgSwi.setImageResource(imgArr[position]);
    }
}