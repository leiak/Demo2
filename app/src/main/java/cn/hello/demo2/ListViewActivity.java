package cn.hello.demo2;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivity extends BaseActivity {

    private String[] data = {"apple","banana","orange","apple2","banana2","orange2","apple3","banana3","orange3","apple4","banana4","orange4","apple5","banana5","orange5","apple6","banana6","orange6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                ListViewActivity.this,android.R.layout.simple_list_item_1,data);
        ListView listView = (ListView) findViewById(R.id.listview1);
        listView.setAdapter(adapter);
    }
}
