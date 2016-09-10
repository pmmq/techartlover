package interview.pub.com.techartlover.activity;

import android.animation.ObjectAnimator;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import interview.pub.com.techartlover.R;
import interview.pub.com.techartlover.view.HeartCircularProgress;

public class MainActivity extends AppCompatActivity
{
    @BindView(R.id.progress_circular_heart)
    HeartCircularProgress progress;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        progress.setCenterImage(BitmapFactory.decodeResource(this.getResources(),(R.drawable.heart)));
        initAnimation();
    }

    private void initAnimation(){
        ObjectAnimator.ofInt(progress,"Progress",0,100).setDuration(1500).start();
    }

}
