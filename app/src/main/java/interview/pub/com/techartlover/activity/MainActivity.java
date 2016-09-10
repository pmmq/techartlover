package interview.pub.com.techartlover.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.math.BigDecimal;
import java.math.RoundingMode;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import interview.pub.com.techartlover.ApplicationService;
import interview.pub.com.techartlover.R;
import interview.pub.com.techartlover.adapters.ViewPagerAdapter;
import interview.pub.com.techartlover.response.PageDetailResponse;
import interview.pub.com.techartlover.view.CircularWithImageProgress;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
{
    @BindView(R.id.progress_circular_heart)
    CircularWithImageProgress progress;

    @BindView(R.id.iv_profile)
    ImageView ivProfile;

    @BindView(R.id.tv_engagement)
    TextView tvEngagement;
    @BindView(R.id.tv_expertin)
    TextView tvExpertin;
    @BindView(R.id.tv_followers)
    TextView tvFollowers;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_ranks)
    TextView tvRank;
    @BindView(R.id.tv_compatibility_round)
    TextView tvCompativilityRound;
    @BindView(R.id.tv_compativility_decimal)
    TextView tvCompativilityDecimal;
    @BindView(R.id.tv_share)
    TextView tvShare;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.btn_follow)
    LinearLayout btnFollow;


    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;

    @BindView(R.id.pager)
    ViewPager mPager;

    PageDetailResponse mPageDetailResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fetchData();
    }

    private void fetchData(){

        Call<PageDetailResponse> call = ApplicationService.getService().service.getPageDetail();
        call.enqueue(new Callback<PageDetailResponse>() {
            @Override
            public void onResponse(Call<PageDetailResponse> call, Response<PageDetailResponse> response) {
                mPageDetailResponse = response.body();
                initUI();
                initViewPager();
                initTabLayout();
                initAnimation();
            }

            @Override
            public void onFailure(Call<PageDetailResponse> call, Throwable t) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Error")
                        .setMessage("Failed to get data")
                        .setPositiveButton("Rerty", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                fetchData();
                            }
                        })
                        .setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        }).show();
            }
        });
    }

    private void initUI(){
        animateTextView(0,mPageDetailResponse.getEngagement(),tvEngagement);;

        tvCompativilityRound.setText((""+(int)mPageDetailResponse.getCompatibility()));
        BigDecimal bd = new BigDecimal(( mPageDetailResponse.getCompatibility() - Math.floor( mPageDetailResponse.getCompatibility() )) * 100 );
        bd = bd.setScale(4, RoundingMode.HALF_DOWN);
        tvCompativilityDecimal.setText("."+bd.intValue());
        // animate value
        animateTextView(0,mPageDetailResponse.getExpert_in(),tvExpertin);
        animateTextView(0,mPageDetailResponse.getFollowers(),tvFollowers);
        animateTextView(0,mPageDetailResponse.getShared(),tvShare);
        progress.setCenterImage(BitmapFactory.decodeResource(this.getResources(),(R.drawable.ic_launcher)));
        // profile
        Picasso.with(this).load(mPageDetailResponse.getImage_url()).into(ivProfile);
        tvRank.setText(mPageDetailResponse.getTitle());
        tvName.setText(mPageDetailResponse.getName());
        tvTitle.setText(mPageDetailResponse.getName());
    }

    private void initAnimation(){
        ObjectAnimator.ofInt(progress,"Progress",0,60).setDuration(1000).start();
    }

    private void initViewPager(){
        mPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(),mPageDetailResponse));
    }

    private void initTabLayout(){
        mTabLayout.setupWithViewPager(mPager);
        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            mTabLayout.getTabAt(i).setIcon(R.drawable.ic_launcher);
        }
    }

    public void animateTextView(int initialValue, int finalValue, final TextView  textview) {

        ValueAnimator valueAnimator = ValueAnimator.ofInt(initialValue, finalValue);
        valueAnimator.setDuration(1500);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                textview.setText(valueAnimator.getAnimatedValue().toString());

            }
        });
        valueAnimator.start();

    }

}
