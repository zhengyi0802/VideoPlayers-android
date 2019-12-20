package com.example.wbvideo2;

import android.os.Bundle;

import com.eftimoff.viewpagertransformers.AccordionTransformer;
import com.eftimoff.viewpagertransformers.BackgroundToForegroundTransformer;
import com.eftimoff.viewpagertransformers.BookFlipPageTransformer;
import com.eftimoff.viewpagertransformers.CardFlipPageTransformer;
import com.eftimoff.viewpagertransformers.CubeInTransformer;
import com.eftimoff.viewpagertransformers.CubeOutTransformer;
import com.eftimoff.viewpagertransformers.DefaultTransformer;
import com.eftimoff.viewpagertransformers.DepthPageTransformer;
import com.eftimoff.viewpagertransformers.DrawFromBackTransformer;
import com.eftimoff.viewpagertransformers.FlipHorizontalTransformer;
import com.eftimoff.viewpagertransformers.FlipVerticalTransformer;
import com.eftimoff.viewpagertransformers.ForegroundToBackgroundTransformer;
import com.eftimoff.viewpagertransformers.ParallaxPageTransformer;
import com.eftimoff.viewpagertransformers.RotateDownTransformer;
import com.eftimoff.viewpagertransformers.RotateUpTransformer;
import com.eftimoff.viewpagertransformers.StackTransformer;
import com.eftimoff.viewpagertransformers.TabletTransformer;
import com.eftimoff.viewpagertransformers.ZoomInTransformer;
import com.eftimoff.viewpagertransformers.ZoomOutSlideTransformer;
import com.eftimoff.viewpagertransformers.ZoomOutTranformer;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;

import com.example.wbvideo2.ui.main.SectionsPagerAdapter;

import java.util.ArrayList;

import static com.example.wbvideo2.Constant.FLIPPAGE_ACCORDION;
import static com.example.wbvideo2.Constant.FLIPPAGE_BGNTOFGN;
import static com.example.wbvideo2.Constant.FLIPPAGE_BOOK;
import static com.example.wbvideo2.Constant.FLIPPAGE_CARD;
import static com.example.wbvideo2.Constant.FLIPPAGE_CUBEIN;
import static com.example.wbvideo2.Constant.FLIPPAGE_CUBEOUT;
import static com.example.wbvideo2.Constant.FLIPPAGE_DEFAULT;
import static com.example.wbvideo2.Constant.FLIPPAGE_DEPTHPAGE;
import static com.example.wbvideo2.Constant.FLIPPAGE_DRAW;
import static com.example.wbvideo2.Constant.FLIPPAGE_FGNTOBGN;
import static com.example.wbvideo2.Constant.FLIPPAGE_FLIPHORIZONTAL;
import static com.example.wbvideo2.Constant.FLIPPAGE_FLIPVERTICAL;
import static com.example.wbvideo2.Constant.FLIPPAGE_PARRALLAX;
import static com.example.wbvideo2.Constant.FLIPPAGE_ROTATEDOWN;
import static com.example.wbvideo2.Constant.FLIPPAGE_ROTATEUP;
import static com.example.wbvideo2.Constant.FLIPPAGE_STACK;
import static com.example.wbvideo2.Constant.FLIPPAGE_TABLET;
import static com.example.wbvideo2.Constant.FLIPPAGE_ZOOMIN;
import static com.example.wbvideo2.Constant.FLIPPAGE_ZOOMOUT;
import static com.example.wbvideo2.Constant.FLIPPAGE_ZOOMOUTSLIDE;

public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter sectionsPagerAdapter;
    private ArrayList<String> urllist;
    private ViewPager viewPager;
    private int flippage = FLIPPAGE_BOOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewPager();
        sectionsPagerAdapter = new SectionsPagerAdapter(this,
                getSupportFragmentManager(), urllist);
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        setAnimation();
        return;
    }

    private void initViewPager() {
        urllist = new ArrayList<String>();
        String[] mList = getResources().getStringArray(R.array.array_urls);
        for (int i = 0 ; i < mList.length; i++) {
            String str = getString(R.string.default_web) + mList[i] + "_HD.mp4";
            urllist.add(str);
        }
        return;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id) {
            case R.id.style_bookflip :
                flippage = FLIPPAGE_BOOK;
                break;
            case R.id.style_cardflip :
                flippage = FLIPPAGE_CARD;
                break;
            case R.id.style_default :
                flippage = FLIPPAGE_DEFAULT;
                break;
            case R.id.style_accordion :
                flippage = FLIPPAGE_ACCORDION;
                break;
            case R.id.style_bgntofgn :
                flippage = FLIPPAGE_BGNTOFGN;
                break;
            case R.id.style_cubein :
                flippage = FLIPPAGE_CUBEIN;
                break;
            case R.id.style_cubeout :
                flippage = FLIPPAGE_CUBEOUT;
                break;
            case R.id.style_depthpage :
                flippage = FLIPPAGE_DEPTHPAGE;
                break;
            case R.id.style_fliphorizontal :
                flippage = FLIPPAGE_FLIPHORIZONTAL;
                break;
            case R.id.style_flipvertical :
                flippage = FLIPPAGE_FLIPVERTICAL;
                break;
            case R.id.style_fgntobgn :
                flippage = FLIPPAGE_FGNTOBGN;
                break;
            case R.id.style_rotatedown :
                flippage = FLIPPAGE_ROTATEDOWN;
                break;
            case R.id.style_rotateup :
                flippage = FLIPPAGE_ROTATEUP;
                break;
            case R.id.style_stack :
                flippage = FLIPPAGE_STACK;
                break;
            case R.id.style_tablet :
                flippage = FLIPPAGE_TABLET;
                break;
            case R.id.style_zoomin :
                flippage = FLIPPAGE_ZOOMIN;
                break;
            case R.id.style_zoomoutslide :
                flippage = FLIPPAGE_ZOOMOUTSLIDE;
                break;
            case R.id.style_zoomout :
                flippage = FLIPPAGE_ZOOMOUT;
                break;
            case R.id.style_draw :
                flippage = FLIPPAGE_DRAW;
                break;
            case R.id.style_parallax :
                flippage = FLIPPAGE_PARRALLAX;
                break;
        }
        setAnimation();
        return super.onOptionsItemSelected(item);
    }

    private void setAnimation() {
        switch(flippage) {
            case FLIPPAGE_BOOK :
                BookFlipPageTransformer bookFlipPageTransformer = new BookFlipPageTransformer();
                bookFlipPageTransformer.setEnableScale(true);
                bookFlipPageTransformer.setScaleAmountPercent(10f);
                viewPager.setClipToPadding(false);
                viewPager.setPageTransformer(true, bookFlipPageTransformer);
                break;
            case FLIPPAGE_CARD :
                CardFlipPageTransformer cardFlipPageTransformer = new CardFlipPageTransformer();
                cardFlipPageTransformer.setScalable(true);
                cardFlipPageTransformer.setFlipOrientation(CardFlipPageTransformer.VERTICAL);
                viewPager.setClipToPadding(false);
                viewPager.setPageTransformer(true, cardFlipPageTransformer);
                break;
            case FLIPPAGE_DEFAULT :
                DefaultTransformer defaultTransformer = new DefaultTransformer();
                viewPager.setClipToPadding(false);
                viewPager.setPageTransformer(true, defaultTransformer);
                break;
            case FLIPPAGE_ACCORDION :
                AccordionTransformer accordionTransformer = new AccordionTransformer();
                viewPager.setClipToPadding(false);
                viewPager.setPageTransformer(true, accordionTransformer);
                break;
            case FLIPPAGE_BGNTOFGN :
                BackgroundToForegroundTransformer backgroundToForegroundTransformer =
                        new BackgroundToForegroundTransformer();
                viewPager.setClipToPadding(false);
                viewPager.setPageTransformer(true,
                        backgroundToForegroundTransformer);
                break;
            case FLIPPAGE_CUBEIN :
                CubeInTransformer cubeInTransformer = new CubeInTransformer();
                viewPager.setClipToPadding(false);
                viewPager.setPageTransformer(true, cubeInTransformer);
                break;
            case FLIPPAGE_CUBEOUT :
                CubeOutTransformer cubeOutTransformer = new CubeOutTransformer();
                viewPager.setClipToPadding(false);
                viewPager.setPageTransformer(true, cubeOutTransformer);
                break;
            case FLIPPAGE_DEPTHPAGE :
                DepthPageTransformer depthPageTransformer = new DepthPageTransformer();
                viewPager.setClipToPadding(false);
                viewPager.setPageTransformer(true, depthPageTransformer);
                break;
            case FLIPPAGE_FLIPHORIZONTAL :
                FlipHorizontalTransformer flipHorizontalTransformer =
                        new FlipHorizontalTransformer();
                viewPager.setClipToPadding(false);
                viewPager.setPageTransformer(true,
                        flipHorizontalTransformer);
                break;
            case FLIPPAGE_FLIPVERTICAL :
                FlipVerticalTransformer flipVerticalTransformer = new FlipVerticalTransformer();
                viewPager.setClipToPadding(false);
                viewPager.setPageTransformer(true, flipVerticalTransformer);
                break;
            case FLIPPAGE_FGNTOBGN :
                ForegroundToBackgroundTransformer foregroundToBackgroundTransformer =
                        new ForegroundToBackgroundTransformer();
                viewPager.setClipToPadding(false);
                viewPager.setPageTransformer(true,
                        foregroundToBackgroundTransformer);
                break;
            case FLIPPAGE_ROTATEDOWN :
                RotateDownTransformer rotateDownTransformer = new RotateDownTransformer();
                viewPager.setClipToPadding(false);
                viewPager.setPageTransformer(true, rotateDownTransformer);
                break;
            case FLIPPAGE_ROTATEUP :
                RotateUpTransformer rotateUpTransformer = new RotateUpTransformer();
                viewPager.setClipToPadding(false);
                viewPager.setPageTransformer(true, rotateUpTransformer);
                break;
            case FLIPPAGE_STACK :
                StackTransformer stackTransformer = new StackTransformer();
                viewPager.setClipToPadding(false);
                viewPager.setPageTransformer(true, stackTransformer);
                break;
            case FLIPPAGE_TABLET :
                TabletTransformer tabletTransformer = new TabletTransformer();
                viewPager.setClipToPadding(false);
                viewPager.setPageTransformer(true, tabletTransformer);
                break;
            case FLIPPAGE_ZOOMIN :
                ZoomInTransformer zoomInTransformer = new ZoomInTransformer();
                viewPager.setClipToPadding(false);
                viewPager.setPageTransformer(true, zoomInTransformer);
                break;
            case FLIPPAGE_ZOOMOUTSLIDE :
                ZoomOutSlideTransformer zoomOutSlideTransformer = new ZoomOutSlideTransformer();
                viewPager.setClipToPadding(false);
                viewPager.setPageTransformer(true, zoomOutSlideTransformer);
                break;
            case FLIPPAGE_ZOOMOUT :
                ZoomOutTranformer zoomOutTranformer = new ZoomOutTranformer();
                viewPager.setClipToPadding(false);
                viewPager.setPageTransformer(true, zoomOutTranformer);
                break;
            case FLIPPAGE_DRAW :
                DrawFromBackTransformer drawFromBackTransformer = new DrawFromBackTransformer();
                viewPager.setClipToPadding(false);
                viewPager.setPageTransformer(true, drawFromBackTransformer);
                break;
            case FLIPPAGE_PARRALLAX:
                ParallaxPageTransformer parallaxPageTransformer = new ParallaxPageTransformer(1);
                viewPager.setClipToPadding(false);
                viewPager.setPageTransformer(true, parallaxPageTransformer);
                break;
        }
        return;
    }

}