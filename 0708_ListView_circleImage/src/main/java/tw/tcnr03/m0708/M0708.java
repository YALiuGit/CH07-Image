package tw.tcnr03.m0708;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class M0708 extends ListActivity {

    private TextView mTxtResult01;
    private TextView mTxtResult02;
    private String[] listFromResource;
    private ArrayList<Map<String, Object>> mList;
    private String[] listFromResource02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0708);
        setupViewcomponent();
    }

    private void setupViewcomponent() {
        mTxtResult01 = (TextView) findViewById(R.id.m0708_t001);
        mTxtResult02 = (TextView) findViewById(R.id.m0708_t002);
        listFromResource = getResources().getStringArray(R.array.teacher01);
        listFromResource02 = getResources().getStringArray(R.array.teacher02);
        mList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < listFromResource.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            String idName="t"+String.format("%03d",i+1);
            int  resID=getResources().getIdentifier(idName,"drawable",getPackageName());
            item.put("imgView", resID);
//            item.put("imgView", R.drawable.img01th);
            item.put("txtView", listFromResource[i]);
            mList.add(item);
            SimpleAdapter adapter = new SimpleAdapter(
                    this,
                    mList,
                    R.layout.list_item,
                    new String[]{"imgView", "txtView"},
                    new int[]{R.id.circleImgView, R.id.txtView});
            //----------------------------------------------------------------
            setListAdapter(adapter);
            ListView listview = getListView();
            listview.setTextFilterEnabled(true);
            listview.setOnItemClickListener(listviewOnItemClkLis);
        }

    }

    AdapterView.OnItemClickListener listviewOnItemClkLis = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View view,
                                int position, long id) {
            mTxtResult01.setText("講師:"+listFromResource[position]);
            mTxtResult02.setText("說明:"+listFromResource02[position]);
        }
    };
}
//package tw.tcnr03.m0704;
//
//
//import android.app.ListActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ListAdapter;
//import android.widget.ListView;
//import android.widget.SimpleAdapter;
//import android.widget.TextView;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//public class M0704 extends ListActivity {
//
//    private TextView mTxtResult;
//    private String[] listFromResource;
//    private ArrayList<Map<String,Object>> mList;
//    private ListAdapter adapter;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.m0704);
//        setupViewComponent();
//    }
//    private void setupViewComponent(){
//        mTxtResult = (TextView) findViewById(R.id.m0708_t001);
//        listFromResource = getResources().getStringArray(R.array.weekday);
////---------------------------------------------------------------
//        mList=new ArrayList<Map<String,Object>>();
//        for(int i=0;i<listFromResource.length; i++){
//            Map<String, Object> item = new HashMap<>();
//            item.put("imgView",R.drawable.img01th);
//            item.put("txtView",listFromResource);
//            mList.add(item);
//            //
//            SimpleAdapter adaper = new SimpleAdapter(
//                    this,
//                    mList,
//                    R.layout.list_item,
//                    new String[]{"imgView", "txtView"},
//                    new int[]{R.id.imageView, R.id.txtView});
//// -----------------------------------------------------------
//            //----------------------------------------------------------------
//            setListAdapter(adapter);
//            ListView listview = getListView();
//            listview.setTextFilterEnabled(true);
//            listview.setOnItemClickListener(listviewOnItemClkLis);
//
//    }
//    }
//    AdapterView.OnItemClickListener listviewOnItemClkLis= new AdapterView.OnItemClickListener() {
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            mTxtResult.setText(listFromResource[position]);
//        }
//    };
//}