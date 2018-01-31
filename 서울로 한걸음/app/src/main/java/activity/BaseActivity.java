package activity;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.seoullo_one.R;
import com.tsengvn.typekit.TypekitContextWrapper;


public class BaseActivity extends AppCompatActivity {

    private ActionBar toolbar;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void initToolbar() {
        if (getSupportActionBar() == null) {
            setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        }

        toolbar = getSupportActionBar();
        if (toolbar != null) {
            toolbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE);
        }
    }

    public void displayBackButton(boolean display) {
        if (toolbar != null) {
            toolbar.setDisplayHomeAsUpEnabled(display);
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }
}