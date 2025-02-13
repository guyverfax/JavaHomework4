package controller.porder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

import service.PorderService;
import service.impl.PorderServiceImpl;
import model.Porder;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PorderSalesChartUI extends JFrame {
    private PorderService porderService=new PorderServiceImpl();

    public PorderSalesChartUI() {
        setTitle("銷售數據報表");
        setSize(400, 400);  
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        DefaultCategoryDataset dataset = createDataset();

        JFreeChart barChart = ChartFactory.createBarChart(
                "銷售報表",   
                "商品",        
                "數量",         
                dataset
        );

        
        barChart.setTitle(new TextTitle("銷售報表", new Font("Microsoft JhengHei", Font.BOLD, 12)));

        
        CategoryPlot plot = (CategoryPlot) barChart.getPlot();
        plot.getDomainAxis().setLabelFont(new Font("Microsoft JhengHei", Font.PLAIN, 12)); // X 軸
        plot.getRangeAxis().setLabelFont(new Font("Microsoft JhengHei", Font.PLAIN, 12)); // Y 軸

        
        plot.getDomainAxis().setTickLabelFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
        plot.getRangeAxis().setTickLabelFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));

    
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesItemLabelGenerator(0, new StandardCategoryItemLabelGenerator());
        renderer.setSeriesItemLabelsVisible(0, true);  
        renderer.setSeriesItemLabelFont(0, new Font("Microsoft JhengHei", Font.BOLD, 12));
        renderer.setSeriesPositiveItemLabelPosition(0, new ItemLabelPosition(
                ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER
        ));

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(400, 400));  
        setContentPane(chartPanel);
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        List<Porder> porderList = porderService.readAllPorder();

        int totalApple = 0;
        int totalBanana = 0;
        int totalLemon = 0;

        for (Porder porder : porderList) {
            totalApple += porder.getApple();
            totalBanana += porder.getBanana();
            totalLemon += porder.getLemon();
        }

        dataset.addValue(totalApple, "數量", "蘋果");
        dataset.addValue(totalBanana, "數量", "香蕉");
        dataset.addValue(totalLemon, "數量", "檸檬");

        return dataset;
    }

    public static void main(String[] args) {
    	SwingUtilities.invokeLater(() -> new PorderSalesChartUI().setVisible(true));
    }
}
