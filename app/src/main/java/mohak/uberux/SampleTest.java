package mohak.uberux;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SampleTest extends BaseActivity {

    @BindView(R.id.td)
    TextView td;
    @BindView(R.id.click)
    Button click;
    @BindView(R.id.mainframe)
    FrameLayout mainframe;
    @BindView(R.id.rootll)
    LinearLayout rootll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_test);
        ButterKnife.bind(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startRevealAnimation();
            }
        }, 100);
    }

    @Override
    protected void setUpPolyLine() {

    }


    @OnClick({R.id.td, R.id.click})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.td:
                break;
            case R.id.click:
                TransitionManager.beginDelayedTransition(mainframe);

                td.setVisibility(td.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                break;
        }
    }


    void startRevealAnimation() {

        int cx = mainframe.getMeasuredWidth() / 2;
        int cy = mainframe.getMeasuredHeight() / 2;
//        int cx = 540;
//        int cy = 942;

        Animator anim =
                ViewAnimationUtils.createCircularReveal(rootll, cx, cy, 50, mainframe.getWidth());

        anim.setDuration(500);
        anim.setInterpolator(new AccelerateInterpolator(2));
        anim.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

//                rlWhere.setVisibility(View.VISIBLE);
//                ivHome.setVisibility(View.VISIBLE);
            }
        });

        anim.start();
    }

}
