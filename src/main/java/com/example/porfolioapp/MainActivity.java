package com.example.porfolioapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.porfolioapp.cv.CVFragment;
import com.example.porfolioapp.home.HomeFragment;
import com.example.porfolioapp.portfolio.PortfolioFragment;
import com.example.porfolioapp.sidemenu.Callback;
import com.example.porfolioapp.sidemenu.MenuAdapter;
import com.example.porfolioapp.sidemenu.MenuItem;
import com.example.porfolioapp.sidemenu.MenuUtil;
import com.example.porfolioapp.team.TeamFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Callback {

    RecyclerView menuRv;
    List<MenuItem> menuItems;
    MenuAdapter adapter;
    int selectMenuPos = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        //set up side menu

        setupSideMenu();

        setHomeFragement();


        setPortfolioFragment();

        findViewById(R.id.imageButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linkdle_btn("http://google.com/");
            }
        });

        findViewById(R.id.imageButton1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                github_btn("http://google.com/");
            }
        });

        findViewById(R.id.imageButton2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gmail_btn("http://google.com/");
            }
        });
        //setTeamFragment();
        //setCVFragment();
        //setHomeFragement();
    }

    public void linkdle_btn(String url)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    public void github_btn(String url)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    public void gmail_btn(String url)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }


    private void setupSideMenu() {

        menuRv = findViewById(R.id.rv_side_menu);


        menuItems = MenuUtil.getMenuList();
        adapter = new MenuAdapter(menuItems, this);
        menuRv.setLayoutManager(new LinearLayoutManager(this));
        menuRv.setAdapter(adapter);

        //get menu list itemwill get data from static data class

    }


    void setPortfolioFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new PortfolioFragment()).commit();
    }


    void setTeamFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new TeamFragment()).commit();
    }

    void setCVFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new CVFragment()).commit();
    }

    void setHomeFragement() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
    }


    @Override
    public void onSideMenuItemClick(int i) {

        switch (menuItems.get(i).getCode()) {

            case MenuUtil.HOME_FRAGMENT_CODE:
                setHomeFragement();
                break;
            case MenuUtil.CV_FRAGMENT_CODE:
                setCVFragment();
                break;
            case MenuUtil.TEAM_FRAGMENT_CODE:
                setTeamFragment();
                break;
            case MenuUtil.PORTFOLIO_FRAGMENT_CODE:
                setPortfolioFragment();
                break;
            default:
                setHomeFragement();
        }

        menuItems.get(selectMenuPos).setSelected(false);
        menuItems.get(i).setSelected(true);
        selectMenuPos = i;
        adapter.notifyDataSetChanged();

    }

}