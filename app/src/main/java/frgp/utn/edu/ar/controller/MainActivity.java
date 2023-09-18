package frgp.utn.edu.ar.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import frgp.utn.edu.ar.Negocio.CategoriaNegocio;
import frgp.utn.edu.ar.NegocioImpl.CategoriaNegocioImpl;

public class MainActivity extends AppCompatActivity {

    CategoriaNegocio CatNeg = new CategoriaNegocioImpl();
    TabLayout tablayout;
    ViewPager viewpager;
    TabItem alta, modificar, listar;
    PagerAdapter pagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tablayout = findViewById(R.id.tab_layout);
        viewpager = findViewById(R.id.view_pager);
        alta = findViewById(R.id.tab_alta);
        modificar = findViewById(R.id.tab_modificar);
        listar = findViewById(R.id.tab_listar);
        CatNeg.listarCategorias(this);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(),tablayout.getTabCount());
        viewpager.setAdapter(pagerAdapter);
        tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0){
                    pagerAdapter.notifyDataSetChanged();
                }
                if(tab.getPosition()==1){
                    pagerAdapter.notifyDataSetChanged();
                }
                if(tab.getPosition()==2){
                    pagerAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
    }
}