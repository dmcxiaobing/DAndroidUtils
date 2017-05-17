package com.david.dandroidutils.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.david.dandroidlibrary.utils.adapter.DCommonAdapter;
import com.david.dandroidlibrary.utils.common.DViewHolder;
import com.david.dandroidlibrary.utils.utils.DAutoRefreshListviewCompleteUtils;
import com.david.dandroidlibrary.utils.view.DAutoRefreshListView;
import com.david.dandroidutils.R;
import com.david.dandroidutils.app.MyApplication;
import com.david.dandroidutils.bean.TopListBean;
import com.david.dandroidutils.callback.OkHttpStopCallback;
import com.david.dandroidutils.utils.OkHttpUtils;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;
import okhttp3.Response;

/*
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */
public class DAutoRefreshListViewActivity extends Activity {
    private DAutoRefreshListView pull_listview;
    private OkHttpUtils okHttpUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dauto_refresh_listview);
        pull_listview = (DAutoRefreshListView) findViewById(R.id.pull_listview);
        initData();

        setOnclickListener();
    }

    //页数
    private int pageIndex = 1;
    private String url = "http://www.tngou.net/api/top/list" + "?id=1" + "&page=" + pageIndex + "&rows=" + "20";
    private List<TopListBean.TngouBean> mDataList = new ArrayList<>();
    private MyCommonAdapter adapter;

    protected void initData() {
        okHttpUtils = MyApplication.getApp().getOkHttpUtils();
        adapter = new MyCommonAdapter(DAutoRefreshListViewActivity.this, mDataList);
        pull_listview.setAdapter(adapter);
        pull_listview.performRefresh();
        getData();
    }

    protected void setOnclickListener() {
        /**
         * 下拉刷新
         */
        pull_listview.setOnRefreshListener(new DAutoRefreshListView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pageIndex = 1;
                getData();
            }
        });
        /**
         * 上拉加载更多
         */
        pull_listview.setOnGetMoreListener(new DAutoRefreshListView.OnGetMoreListener() {
            @Override
            public void onGetMore() {
                pageIndex++;
                getData();
            }
        });


    }

    private void getData() {
        okHttpUtils.get(url, null, new OkHttpStopCallback<TopListBean>() {

            @Override
            public void onSuccess(Response response, TopListBean topListBean) {
                if (topListBean != null) {
                    if (topListBean.getTngou() != null) {
                        if (pageIndex == 1) {
                            mDataList.clear();
                        }
                        mDataList.addAll(topListBean.getTngou());
                        adapter.notifyDataSetChanged();
                    }
                }
                DAutoRefreshListviewCompleteUtils.pullListviewComplete(pull_listview);


            }

            @Override
            public void onFailure(Request request, Exception e) {
                super.onFailure(request, e);
                DAutoRefreshListviewCompleteUtils.pullListviewComplete(pull_listview);

            }
        });

    }

    class MyCommonAdapter extends DCommonAdapter<TopListBean.TngouBean> {
        private List<TopListBean.TngouBean> lists = new ArrayList<>();

        public MyCommonAdapter(Context context, List<TopListBean.TngouBean> datas) {
            super(context, datas);
            this.lists.clear();
            this.lists.addAll(datas);

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            DViewHolder holder = DViewHolder.getHolder(mContext, convertView, parent,
                    R.layout.item_listview_introduce, position);
            TopListBean.TngouBean bean = mDatas.get(position);

            TextView tv_introduce_name;
            ImageView iv_introduce_img;

            tv_introduce_name = holder.getView(R.id.tv_introduce_name);
            iv_introduce_img = holder.getView(R.id.iv_introduce_img);


            tv_introduce_name.setText(bean.getTitle());
//        PicassoWithImageLoaderImageViewUtils.withImageView(mContext, bean.getImg(), iv_introduce_img);
//            PicassoWithImageLoaderImageViewUtils.displayImage(bean.getImg(), iv_introduce_img);
            return holder.getmConvertView();
        }

    }
}
