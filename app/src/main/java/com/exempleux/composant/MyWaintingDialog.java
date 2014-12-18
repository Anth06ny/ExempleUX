package com.exempleux.composant;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.exempleux.R;

/**
 * Created by amonteiro on 01/10/2014.
 */
public class MyWaintingDialog extends DialogFragment {//} BlurDialogFragment {

    private TextView wd_tv;
    //private FrameImageAnimator wd_iv;

    //Image de l'animation
    private final static int[] mImageToAnimate = new int[] { R.drawable.wait_frame1, R.drawable.wait_frame2, R.drawable.wait_frame3,
            R.drawable.wait_frame1, R.drawable.wait_frame2, R.drawable.wait_frame3 };

    //Pour gerer l'animation
    //AnimatorControl animatorControl;

    public MyWaintingDialog() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View dialogView = inflater.inflate(R.layout.dialog_progress, container);

        //On retire le titre
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        //text par defaut
        wd_tv = (TextView) dialogView.findViewById(R.id.wd_tv);
        //wd_iv = (FrameImageAnimator) dialogView.findViewById(R.id.wd_iv);

        //        animatorControl = new AnimatorControl();
        //        animatorControl.mApplyFrames(mImageToAnimate, getActivity(), wd_iv, AnimationSpeed.MEDIUM);
        //
        //        wd_iv.setFrameImageAnimatorColorFilter(Utils.getColorFromTheme(getActivity(), R.attr.color_composant_main));

        return dialogView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //getDialog().getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
    }

    @Override
    public void onResume() {
        super.onResume();
        //animatorControl.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        //animatorControl.stop();
    }

}
