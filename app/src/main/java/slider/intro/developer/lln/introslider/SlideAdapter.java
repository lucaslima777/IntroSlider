package slider.intro.developer.lln.introslider;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SlideAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SlideAdapter(Context context) {
        this.context = context;
    }

    public int[] slide_images = {
            R.drawable.rocket,
            R.drawable.food_icon,
            R.drawable.structure,
            R.drawable.animal_icon,
            R.drawable.user_icon,
            R.drawable.analytics
    };

    public String[] slide_heading = {
            "ROCKET",
            "FOOD",
            "STRUCTURE",
            "ANIMAL",
            "USER",
            "ANALYTICS"
    };

    public String[] slide_description = {
            "tristique magna sit amet purus gravida quis blandit turpis cursus in hac habitasse platea",
            "mauris nunc congue nisi vitae suscipit tellus mauris a diam maecenas sed enim ut",
            "posuere urna nec tincidunt praesent semper feugiat nibh sed pulvinar proin gravida hendrerit lectus",
            "tortor vitae purus faucibus ornare suspendisse sed nisi lacus sed viverra tellus in hac",
            "amet mauris commodo quis imperdiet massa tincidunt nunc pulvinar sapien et ligula ullamcorper malesuada",
            "mattis pellentesque id nibh tortor id aliquet lectus proin nibh nisl condimentum id venenatis"

    };

    @Override
    public int getCount() {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_description);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_heading[position]);
        slideDescription.setText(slide_description[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
