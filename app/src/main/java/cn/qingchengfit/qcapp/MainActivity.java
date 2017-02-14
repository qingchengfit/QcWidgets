package cn.qingchengfit.qcapp;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.qingchengfit.widgets.CommonFlexAdapter;
import com.tbruyelle.rxpermissions.RxPermissions;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.common.DividerItemDecoration;
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem;
import java.util.ArrayList;
import java.util.List;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity implements FlexibleAdapter.OnItemClickListener {

    @BindView(R.id.recycleview) RecyclerView recycleview;
    @BindView(R.id.activity_main) LinearLayout activityMain;
    private List<AbstractFlexibleItem> mData = new ArrayList<>();
    private CommonFlexAdapter mFlexAdapter;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        RxPermissions.getInstance(this).request(Manifest.permission.READ_EXTERNAL_STORAGE).subscribe(new Action1<Boolean>() {
            @Override public void call(Boolean aBoolean) {
                if (aBoolean) {
                } else {
                }
            }
        });



        mData.add(new SimpleTextItem("字号"));
        mData.add(new SimpleTextItem("图片"));
        mData.add(new SimpleTextItem("图片"));
        mData.add(new SimpleTextItem("图片"));









        mFlexAdapter = new CommonFlexAdapter(mData, this);
        recycleview.setLayoutManager(new LinearLayoutManager(this));
        recycleview.addItemDecoration(new DividerItemDecoration(this,R.drawable.divier_linear));
        recycleview.setAdapter(mFlexAdapter);
    }

    @Override public boolean onItemClick(int position) {
        switch (position) {
            case 0:
                break;
            case 1:
                break;
        }
        return true;
    }
}
