package info;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.seoullo_one.R;


/**
 * Created by S on 2017-10-18.
 */

public class InfoFaqViewholder extends RecyclerView.ViewHolder {
    protected TextView faq_title;
    protected TextView faq_content;
    protected LinearLayout faq_contentlayout;

    public InfoFaqViewholder (View view){
        super(view);

        faq_title = (TextView) view.findViewById(R.id.faq_title);
        faq_content = (TextView) view.findViewById(R.id.faq_content);
        faq_contentlayout = (LinearLayout) view.findViewById(R.id.faq_contentlayout);

        faq_title.setSelected(false);
    }
}
