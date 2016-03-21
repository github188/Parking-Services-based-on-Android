package com.example.horacechan.parking;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements OnClickListener {

    private LinearLayout mTabDaohang;
    private LinearLayout mTabBook;
    private LinearLayout mTabTansuo;
    private LinearLayout mTabMe;

    private ImageButton mImgDaohang;
    private ImageButton mImgBook;
    private ImageButton mImgTansuo;
    private ImageButton mImgMe;

    private TextView mFontDaohang;
    private TextView mFontBook;
    private TextView mFontTansuo;
    private TextView mFontMe;

    private Fragment mTabFragDaohang;
    private Fragment mTabFragBook;
    private Fragment mTabFragTansuo;
    private Fragment mTabFragMe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
        setSelect(0);
    }


    private void initEvent() {
        mTabDaohang.setOnClickListener(this);
        mTabBook.setOnClickListener(this);
        mTabTansuo.setOnClickListener(this);
        mTabMe.setOnClickListener(this);
    }

    private void initView() {
        mTabDaohang = (LinearLayout) findViewById(R.id.Tab_Daohang);
        mTabBook = (LinearLayout) findViewById(R.id.Tab_Book);
        mTabTansuo = (LinearLayout) findViewById(R.id.Tab_Tansuo);
        mTabMe = (LinearLayout) findViewById(R.id.Tab_Me);

        mImgDaohang = (ImageButton) findViewById(R.id.Img_Daohang);
        mImgBook = (ImageButton) findViewById(R.id.Img_Book);
        mImgTansuo = (ImageButton) findViewById(R.id.Img_Tansuo);
        mImgMe = (ImageButton) findViewById(R.id.Img_Me);

        mFontDaohang = (TextView) findViewById(R.id.Font_Daohang);
        mFontBook = (TextView) findViewById(R.id.Font_Book);
        mFontTansuo = (TextView) findViewById(R.id.Font_Tansuo);
        mFontMe = (TextView) findViewById(R.id.Font_Me);
    }

    private void setSelect(int i) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);
        switch (i) {
            case 0:
                if (mTabFragDaohang == null) {
                    mTabFragDaohang = new ParkingFrgment();
                    transaction.add(R.id.id_content, mTabFragDaohang);
                } else {
                    transaction.show(mTabFragDaohang);
                }
                mFontDaohang.setTextColor(0xff11CD6E);
                mImgDaohang.setImageResource(R.mipmap.daohang_press);
                break;
            case 1:
                if (mTabFragBook == null) {
                    mTabFragBook = new BookFrgment();
                    transaction.add(R.id.id_content, mTabFragBook);
                } else {
                    transaction.show(mTabFragBook);
                }
                mFontBook.setTextColor(0xff11CD6E);
                mImgBook.setImageResource(R.mipmap.book_press);
                break;
            case 2:
                if (mTabFragTansuo == null) {
                    mTabFragTansuo = new TansuoFrgment();
                    transaction.add(R.id.id_content, mTabFragTansuo);
                } else {
                    transaction.show(mTabFragTansuo);
                }
                mFontTansuo.setTextColor(0xff11CD6E);
                mImgTansuo.setImageResource(R.mipmap.tansuo_press);
                break;
            case 3:
                if (mTabFragMe == null) {
                    mTabFragMe = new MeFrgment();
                    transaction.add(R.id.id_content, mTabFragMe);
                } else {
                    transaction.show(mTabFragMe);
                }
                mFontMe.setTextColor(0xff11CD6E);
                mImgMe.setImageResource(R.mipmap.me_press);
                break;

            default:
                break;
        }

        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (mTabFragDaohang != null) {
            transaction.hide(mTabFragDaohang);
        }
        if (mTabFragBook != null) {
            transaction.hide(mTabFragBook);
        }
        if (mTabFragTansuo != null) {
            transaction.hide(mTabFragTansuo);
        }
        if (mTabFragMe != null) {
            transaction.hide(mTabFragMe);
        }
    }

    @Override
    public void onClick(View v) {
        resetImgs();
        resetFonts();
        switch (v.getId())
        {
            case R.id.Tab_Daohang:
                setSelect(0);
                break;
            case R.id.Tab_Book:
                setSelect(1);
                break;
            case R.id.Tab_Tansuo:
                setSelect(2);
                break;
            case R.id.Tab_Me:
                setSelect(3);
                break;

            default:
                break;
        }
    }

    private void resetFonts() {
        mFontDaohang.setTextColor(0xff272636);
        mFontBook.setTextColor(0xff272636);
        mFontTansuo.setTextColor(0xff272636);
        mFontMe.setTextColor(0xff272636);
    }

    private void resetImgs() {
        mImgDaohang.setImageResource(R.mipmap.daohang);
        mImgBook.setImageResource(R.mipmap.book);
        mImgTansuo.setImageResource(R.mipmap.tansuo);
        mImgMe.setImageResource(R.mipmap.me);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}