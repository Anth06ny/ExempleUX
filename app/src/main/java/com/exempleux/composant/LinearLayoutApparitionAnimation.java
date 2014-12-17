package com.exempleux.composant;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.exempleux.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by amonteiro on 05/11/2014.
 */
public class LinearLayoutApparitionAnimation extends LinearLayout {

    private Animation slideUp, slidDown;

    //vue à mettre en avant à la fin de l'animation de fermeture.
    private List<View> viewBringToFrontAtEnd = null;

    public LinearLayoutApparitionAnimation(Context context) {
        super(context);
        initAnimation(context);
    }

    public LinearLayoutApparitionAnimation(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAnimation(context);
    }

    public LinearLayoutApparitionAnimation(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAnimation(context);
    }

    private void initAnimation(Context context) {
        slidDown = AnimationUtils.loadAnimation(context, R.anim.slide_down);
        slideUp = AnimationUtils.loadAnimation(context, R.anim.slide_up);
        slideUp.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //Suite à un bug graphique qui meme apres que l'extension ait disparu.
                //On pouvait toiujours cliqué dessus, empechant de cliquer sur la liste.
                if (viewBringToFrontAtEnd != null) {
                    for (View view : viewBringToFrontAtEnd) {
                        view.bringToFront();
                    }
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @Override
    public void setVisibility(int visibility) {
        if (getVisibility() != visibility) {
            if (visibility == VISIBLE) {
                if (slidDown != null) {
                    startAnimation(slidDown);
                }
            }
            else if ((visibility == INVISIBLE) || (visibility == GONE)) {
                if (slideUp != null) {
                    startAnimation(slideUp);
                }
            }
        }

        super.setVisibility(visibility);
    }

    public void setViewBringToFrontAtEnd(View... viewBringToFrontAtEnd) {
        this.viewBringToFrontAtEnd = Arrays.asList(viewBringToFrontAtEnd);
    }
}
