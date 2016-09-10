package interview.pub.com.techartlover.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import interview.pub.com.techartlover.fragments.TabDetailFragment;
import interview.pub.com.techartlover.response.PageDetailResponse;

/**
 * Created by Pub on 10/9/2559.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    int count = 2;
    String[] tabNames = {"Movie","Comments"};
    PageDetailResponse pageDetailResponse;

    public ViewPagerAdapter(FragmentManager fm , PageDetailResponse data) {
        super(fm);
        pageDetailResponse = data;
    }

    @Override
    public Fragment getItem(int position) {
        return TabDetailFragment.create(pageDetailResponse);
    }

    @Override
    public int getCount() {
        return count;
    }
}
