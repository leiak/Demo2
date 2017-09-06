package cn.hello.demo2;

import android.os.AsyncTask;
import android.widget.ArrayAdapter;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;

import java.util.LinkedList;

/**
 * Created by Administrator on 2017/9/6.
 */

public class GetDataTask extends AsyncTask<Void, Void, Void> {


    private PullToRefreshListView mPullRefreshListView;
    private ArrayAdapter<String> mAdapter;
    private LinkedList<String> mListItems;

    public GetDataTask(PullToRefreshListView listView,
                       ArrayAdapter<String> adapter,LinkedList<String> listItems) {
        // TODO 自动生成的构造函数存根
        mPullRefreshListView = listView;
        mAdapter = adapter;
        mListItems = listItems;
    }

    @Override
    protected Void doInBackground(Void... params) {
        //模拟请求
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        // TODO 自动生成的方法存根
        super.onPostExecute(result);
        //得到当前的模式
        Mode mode = mPullRefreshListView.getCurrentMode();
        if(mode == Mode.PULL_FROM_START) {
            mListItems.addFirst("这是从上刷新出来的数据");
        }
        else {
            mListItems.addLast("这是从下刷新出来的数据");
        }
        // 通知数据改变了
        mAdapter.notifyDataSetChanged();
        // 加载完成后停止刷新
        mPullRefreshListView.onRefreshComplete();

    }
}
