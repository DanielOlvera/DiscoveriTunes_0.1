package com.example.daniel.discoveritunes_01.view.search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.daniel.discoveritunes_01.R;
import com.example.daniel.discoveritunes_01.model.Result;
import com.example.daniel.discoveritunes_01.presenter.SearchPresenter;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends AppCompatActivity implements SearchListContract.View{

    @BindView(R.id.m_recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.m_searchBar)
    EditText editText;
    @BindView(R.id.m_searchBtn)
    Button searchBtn;
    @BindView(R.id.m_startBtn)
    Button startSearchBtn;
    @BindView(R.id.m_recyclerLayout)
    RelativeLayout relativeLayout;
    @BindView(R.id.m_spinnerTbr)
    Spinner entitySpinner;

    @Inject
    SearchPresenter searchPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

    }

    @Override
    public void updateList(@NotNull List<? extends Result> items) {

    }

    @Override
    public void updateSearchResults(@NotNull List<? extends Result> items) {

    }

    @Override
    public void showError(@NotNull String error) {

    }

    @OnClick(R.id.m_startBtn)
    public void onDismiss1(){
        startSearchBtn.setVisibility(View.GONE);
        relativeLayout.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.m_searchBtn)
    public void onSearch(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.entities_array, android.R.layout.simple_spinner_dropdown_item);
        Toast.makeText(this, "Search from butterknife" + editText.getText().toString() , Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.m_spinnerTbr){

        }
        return super.onOptionsItemSelected(item);
    }

    private void setupRecycler(){

    }
}
