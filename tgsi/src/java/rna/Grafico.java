package rna;

import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.JPanel;

/**
 *
 * @author joao
 */
public class Grafico {

    JPanel jP_Grafico;
    ArrayList<Double> ErroTotal;

    public Grafico(JPanel jP_Grafico, ArrayList<Double> ErroTotal) {
        this.jP_Grafico = jP_Grafico;
        this.ErroTotal = ErroTotal;
    }

    //Dados a serem plotados
    private XYDataset createDatasetLinha() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries data = new XYSeries("Erro Total");
        
        for (int i = 0; i < this.ErroTotal.size(); i++) {
            data.add(i, this.ErroTotal.get(i));
        }

        dataset.addSeries(data);
        return dataset;
    }

    public void criaGraficoLinha() {

        XYDataset dataset = createDatasetLinha();

        String titulo = "Treinamento RNA";
        String eixoY = "Erro Total";
        String eixoX = "Passos executados";
        String txt_legenda = "Legenda:";
        boolean legenda = true;
        boolean tooltips = true;
        boolean urls = true;

        final JFreeChart chart = ChartFactory.createScatterPlot(
                titulo, // chart title  
                eixoX, // x axis label  
                eixoY, // y axis label  
                dataset, // data  
                PlotOrientation.VERTICAL,
                true, // include legend  
                true, // tooltips  
                false // urls  
        );

        XYPlot plot = (XYPlot) chart.getXYPlot();//getPlot();  
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();  //XYLineAndShapeRenderer
        renderer.setSeriesLinesVisible(0, true);
        plot.setRenderer(renderer);  //adiciona ao plot o objeto render                                 

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setSize(jP_Grafico.getWidth(), jP_Grafico.getHeight());

        chartPanel.setVisible(true);//seta propriedade visivel do chartPanel
        jP_Grafico.removeAll(); //configura o jP_Grafico do formulario
        jP_Grafico.add(chartPanel);
        jP_Grafico.revalidate();
        jP_Grafico.repaint();

    }

}
