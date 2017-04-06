package cn.qingchengfit.qcapp;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.CompoundButton;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.qingchengfit.widgets.CommonFlexAdapter;
import cn.qingchengfit.utils.LogUtil;
import com.tbruyelle.rxpermissions.RxPermissions;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.common.DividerItemDecoration;
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements FlexibleAdapter.OnItemClickListener {

    @BindView(R.id.recycleview) RecyclerView recycleview;
    private List<AbstractFlexibleItem> mData = new ArrayList<>();
    private CommonFlexAdapter mFlexAdapter;
    private CompoundButton compoundButton;
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
                LogUtil.e("1curId:"+Thread.currentThread().getId());
                Observable.just(1)
                    .observeOn(Schedulers.computation())
                    .flatMap(new Func1<Integer, Observable<Integer>>() {
                        @Override public Observable<Integer> call(Integer integer) {
                            LogUtil.e("2curId:"+Thread.currentThread().getId());
                            return Observable.just(2).observeOn(AndroidSchedulers.mainThread());
                        }
                    })
                    .subscribe(new Action1<Integer>() {
                        @Override public void call(Integer integer) {
                            LogUtil.e("3curId:"+Thread.currentThread().getId());
                        }
                    });
                break;
            case 1:
                break;
        }
        return true;
    }
}
