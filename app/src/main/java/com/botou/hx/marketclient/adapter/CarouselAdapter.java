package com.botou.hx.marketclient.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.botou.hx.marketclient.R;

/**
 * Created by Amethyst on 16/4/15/09/09.
 */
public class CarouselAdapter extends PagerAdapter {
    private Context context;
    private int [] images = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};

    public CarouselAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images != null && images.length > 0 ? Integer.MAX_VALUE : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView image = new ImageView(context);
        image.setImageResource(images[position % images.length]);
        container.addView(image);
        return image;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
