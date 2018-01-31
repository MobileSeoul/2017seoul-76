package info;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.seoullo_one.R;
import com.seoullo_one.Util;


/**
 * Created by S on 2017-10-18.
 */

public class InfoFaqAdapter extends RecyclerView.Adapter<InfoFaqViewholder> {
    Context context;
    String[] faq_title;
    String[] faq_content;

    public InfoFaqAdapter(Context context, String[] faq_title, String[] faq_content){
        this.context = context;
        this.faq_title = faq_title;
        this.faq_content = faq_content;
    }

    @Override
    public InfoFaqViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.infofaq_item, null);
        Util.setGlobalFont(context, view);
        InfoFaqViewholder faqViewholder = new InfoFaqViewholder(view);
        return faqViewholder;
    }

    @Override
    public void onBindViewHolder(final InfoFaqViewholder holder, final int position) {
        holder.faq_title.setText(faq_title[position]);
        holder.faq_content.setText(faq_content[position]);

        holder.faq_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!holder.faq_title.isSelected()){
                    holder.faq_contentlayout.setVisibility(View.VISIBLE);
                    holder.faq_title.setSelected(true);
                    Log.d(getClass().getName(), "selected="+holder.faq_title.isSelected());
                }
                else {
                    holder.faq_contentlayout.setVisibility(View.GONE);
                    holder.faq_title.setSelected(false);
                    Log.d(getClass().getName(), "selected="+holder.faq_title.isSelected());
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return faq_title.length;
    }
}
