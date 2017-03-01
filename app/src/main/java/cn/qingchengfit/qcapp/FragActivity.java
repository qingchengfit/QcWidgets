package cn.qingchengfit.qcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import cn.qingchengfit.widgets.PicChooserFragment;

public class FragActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag);
        getSupportFragmentManager().beginTransaction()
            .replace(R.id.activity_frag,new PicChooserFragment())
            .commit();
    }
}
