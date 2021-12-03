package tw.tcnr03.m0700;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class M0700 extends AppCompatActivity {
    private String TAG="tcnr03";

    //TAG="tcnr03=>";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0700);
        Log.d(TAG,"執行onCreate");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.m0700, menu);
        setupViewComponet();
        return true;
    }

    private void setupViewComponet() {
        int a=999+123;
        Log.d(TAG, "setupViewCompoent"+a);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"執行onStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"執行onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"執行onResume()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"執行onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"執行onDestroy()");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (item.getItemId()){
            case R.id.m_about:
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
}