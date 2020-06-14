package com.example.myapp.intro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapp.MainActivity;
import com.example.myapp.R;

public class IntroActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private Button btnNext;
    private Button btnSkip;

    int page = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        btnNext = findViewById(R.id.btn_next);
        btnSkip = findViewById(R.id.btn_skip);


        setupViewPager();

        pageChange();

        nextPage();

        skipPages(btnSkip);

    }

    private void pageChange() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                page = position;
                switch (position){
                    case 0:
                        break;
                    case 1:
                        btnSkip.setVisibility(View.VISIBLE);
                        btnNext.setText("next");
                        nextPage();
                        break;
                    case 2:
                        btnSkip.setVisibility(View.GONE);
                        btnNext.setText("start");
                        skipPages(btnNext);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setupViewPager() {
        viewPager = findViewById(R.id.ViewPager);
        viewPager.setAdapter(new IntroFragmentAdapter(getSupportFragmentManager()));
    }

    public void nextPage(){
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
            }
        });
    }

    public void skipPages(Button btn){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


    public class IntroFragmentAdapter extends FragmentPagerAdapter {

        public IntroFragmentAdapter(@NonNull FragmentManager fm) {
            super(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            Bundle bundle = new Bundle();
            bundle.putInt("pos",position);
            IntroFragment introFragment = new IntroFragment();
            introFragment.setArguments(bundle);
            return introFragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
