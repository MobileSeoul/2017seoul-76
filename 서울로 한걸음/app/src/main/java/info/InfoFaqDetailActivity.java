package info;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.widget.TextView;

import com.seoullo_one.R;

import activity.BaseActivity;


/**
 * Created by S on 2017-10-18.
 */

public class InfoFaqDetailActivity extends BaseActivity {

    private TextView faqdetail_title;
    private TextView faqdetail_content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infofaq_detail);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getWindow().setLayout((int)(width*8),(int)(height*8));

        faqdetail_title = (TextView) findViewById(R.id.faqdetail_title);
        faqdetail_content = (TextView)findViewById(R.id.faqdetail_content);

        Intent intent = getIntent();
        String faq_title = intent.getStringExtra("faqtitle");
        String faq_content = intent.getStringExtra("faqcontent");

        faqdetail_title.setText(faq_title);
        faqdetail_content.setText(faq_content);
    }
}
