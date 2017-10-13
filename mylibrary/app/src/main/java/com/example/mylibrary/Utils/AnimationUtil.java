package com.example.mylibrary.Utils;


import android.content.Context;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;

import com.example.mylibrary.R;


public class AnimationUtil {

	public static AnimationSet getAdvertPushUpInAnimation(Context context) {
		Animation in_from_up = AnimationUtils.loadAnimation(context,
				R.anim.push_up_in);
		final AnimationSet set = new AnimationSet(false);
		AlphaAnimation aa = new AlphaAnimation(0.0f, 1.0f);
		aa.setDuration(500);
		set.addAnimation(aa);
		set.addAnimation(in_from_up);
		return set;
	}

	public static AnimationSet getAdvertPushDownInAnimation(Context context) {
		Animation in_to_down = AnimationUtils.loadAnimation(context,
				R.anim.push_down_in);
		final AnimationSet set = new AnimationSet(false);
		AlphaAnimation aa = new AlphaAnimation(0.0f, 1.0f);
		aa.setDuration(300);
		set.addAnimation(aa);
		set.addAnimation(in_to_down);
		return set;
	}

}
