package tw.tcnr03.m0704;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class M0704 extends ListActivity {

    private TextView mTxtResult;
    private String[] listFromResource;
    private ArrayList<Map<String, Object>> mList;
    private String[] listFromResource02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0704);
        setupViewcomponent();
    }

    private void setupViewcomponent() {
        mTxtResult = (TextView) findViewById(R.id.m0704_t001);
        listFromResource = getResources().getStringArray(R.array.weekday);
        listFromResource02 = getResources().getStringArray(R.array.weekday02);
        mList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < listFromResource.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            String idName="img"+String.format("%02d"+"th",i+1);
            int  resID=getResources().getIdentifier(idName,"drawable",getPackageName());
            item.put("imgView", resID);
//            item.put("imgView", R.drawable.img01th);
            item.put("txtView", listFromResource[i]);
            item.put("txtView02", listFromResource02[i]);
            mList.add(item);
            SimpleAdapter adapter = new SimpleAdapter(
                    this,
                    mList,
                    R.layout.list_item,
                    new String[]{"imgView", "txtView","txtView02"},
                    new int[]{R.id.imageView, R.id.txtView,R.id.txtView2});
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
            mTxtResult.setText("你選擇的是:"+listFromResource[position]);
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
//        mTxtResult = (TextView) findViewById(R.id.m0704_t001);
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