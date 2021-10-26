package com.lab2.lab5;

import static android.graphics.Color.BLUE;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

public class MainActivity extends AppCompatActivity {
    GraphView grafica;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grafica=findViewById(R.id.grafica);
        //Datos de las barras
        BarGraphSeries<DataPoint> series= new BarGraphSeries<>(new DataPoint[]{
                new DataPoint(1,71),
                new DataPoint(2,81),
                new DataPoint(3,90),
                new DataPoint(4,95),
                new DataPoint(5,107),

        });
        //Añadimos los datos
        grafica.setTitle("Altura(cm) por Edad");
        grafica.addSeries(series);
        //Le damos estilo
        series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX()*255/4, (int) data.getY()*255/6, 100);
            }
        });
        //espacio entre las barras
        series.setSpacing(5);
        //Dibujamos la grafica
        series.setDrawValuesOnTop(true);
        series.setValuesOnTopColor(BLUE);
    }
}