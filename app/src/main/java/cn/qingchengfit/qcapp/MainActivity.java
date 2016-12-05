package cn.qingchengfit.qcapp;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import cn.qingchengfit.widgets.CheckableButton;
import com.tbruyelle.rxpermissions.RxPermissions;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CheckableButton btn1;
    private CheckableButton btn2;
    private Button guide_window;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RxPermissions.getInstance(this)
            .request(
            Manifest.permission.READ_EXTERNAL_STORAGE
            )
            .subscribe(new Action1<Boolean>() {
                @Override
                public void call(Boolean aBoolean) {
                    if (aBoolean) {
                    } else {
                    }
                }
            });


        btn1 = (CheckableButton) findViewById(R.id.btn1);
        btn2 = (CheckableButton) findViewById(R.id.btn2);
        guide_window = (Button) findViewById(R.id.guide_window);
        btn1.setClick(new View.OnClickListener() {
            @Override public void onClick(View v) {
                btn2.toggle();
            }
        });
        btn2.setClick(new View.OnClickListener() {
            @Override public void onClick(View v) {
                btn1.toggle();
            }
        });
        //        btn1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        //            @Override
        //            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        //                btn2.toggle();
        //            }
        //        });
        //        btn2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        //            @Override
        //            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        //                btn1.toggle();
        //            }
        //        });
        guide_window.setOnClickListener(this);
        findViewById(R.id.choose_image).setOnClickListener(this);
    }

    @Override public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                btn2.toggle();
                break;
            case R.id.btn2:
                btn1.toggle();
                break;
            case R.id.guide_window:
                Intent intent = new Intent();
                intent.setClass(this, GuideWindowActivity.class);
                startActivity(intent);
                break;
            case R.id.choose_image:
                startActivity(new Intent(this, FragActivity.class));
                break;
        }
    }


}
