package cn.qingchengfit.qcapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem;
import eu.davidea.viewholders.FlexibleViewHolder;
import java.util.List;

public class SimpleTextItem extends AbstractFlexibleItem<SimpleTextItem.SimpleTextVH> {

    public String title;

    public SimpleTextItem(String title) {
        this.title = title;
    }

    @Override public int getLayoutRes() {
        return R.layout.item_text;
    }

    @Override public SimpleTextVH createViewHolder(FlexibleAdapter adapter, LayoutInflater inflater, ViewGroup parent) {
        return new SimpleTextVH(inflater.inflate(getLayoutRes(), parent, false), adapter);
    }

    @Override public void bindViewHolder(FlexibleAdapter adapter, SimpleTextVH holder, int position, List payloads) {
        holder.title.setText(title);
    }

    @Override public boolean equals(Object o) {
        return false;
    }

    public class SimpleTextVH extends FlexibleViewHolder {
        @BindView(R.id.title) TextView title;

        public SimpleTextVH(View view, FlexibleAdapter adapter) {
            super(view, adapter);
            ButterKnife.bind(this, view);
        }
    }
}