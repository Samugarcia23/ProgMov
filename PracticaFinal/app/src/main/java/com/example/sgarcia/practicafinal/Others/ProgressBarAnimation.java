package com.example.sgarcia.practicafinal.Others;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;

/*
 *
 * Clase que extiende de Animation. Se usa para la animacion de los progressbar de la pantalla principal
 *
 */

public class ProgressBarAnimation extends Animation {
    private ProgressBar progressBar;
    private float from;
    private float  to;

    public ProgressBarAnimation(ProgressBar progressBar, float from, float to) {
        super();
        this.progressBar = progressBar;
        this.from = from;
        this.to = to;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        float value = from + (to - from) * interpolatedTime;
        progressBar.setProgress((int) value);
    }

}