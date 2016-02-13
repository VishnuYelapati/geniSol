package android.com.delta;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.achartengine.ChartFactory;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

import java.security.KeyStore;
import java.util.ArrayList;


/**
 * Created by srinu on 2/9/2016.
 */
public class Graph extends Activity {

    Button btn_view_graph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_graph);

        btn_view_graph = (Button) findViewById(R.id.btn_viewgraph);
        btn_view_graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChart();
            }
        });
    }

    private void openChart() {

        // Pie Chart Section Names
        String[] code = new String[]{"REDUCED PATCH SIES", "DELTA+", "NORMAL UPDATE"};

        // Pie Chart Section Value
        double[] distribution = {42, 15, 19};

        // Color of each Pie Chart Sections
        int[] colors = {Color.RED, Color.YELLOW, Color.GREEN};

        // Instantiating CategorySeries to plot Pie Chart
        CategorySeries distributionSeries = new CategorySeries("Cellular Traffic Reduction");
        for (int i = 0; i < distribution.length; i++) {

            // Adding a slice with its values and name to the Pie Chart
            distributionSeries.add(code[i], distribution[i]);
        }

        // Instantiating a renderer for the Pie Chart
        DefaultRenderer defaultRenderer = new DefaultRenderer();
        for (int i = 0; i < distribution.length; i++) {

            SimpleSeriesRenderer seriesRenderer = new SimpleSeriesRenderer();
            seriesRenderer.setColor(colors[i]);
             //seriesRenderer.setDisplayChartValues(true);
            // Adding a renderer for a slice
            defaultRenderer.addSeriesRenderer(seriesRenderer);
        }


        defaultRenderer.setChartTitle("Cellular Traffic Reduction");
        defaultRenderer.setChartTitleTextSize(30);
        defaultRenderer.setZoomButtonsVisible(true);
        defaultRenderer.setDisplayValues(true);
        defaultRenderer.setApplyBackgroundColor(true);
        defaultRenderer.setBackgroundColor(Color.BLUE);

        // Creating an intent to plot bar chart using dataset and multipleRenderer
        Intent intent = ChartFactory.getPieChartIntent(getBaseContext(), distributionSeries, defaultRenderer, "AChartEnginePieChartDemo");

        // Start Activity
        startActivity(intent);

    }


}