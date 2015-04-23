package com.example.charttest;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

public class MainActivity extends Activity {
	String[] yL={"һ��","����","����","����","����","����"}; 
	double[] xL={1,3,8,5,4,9};
//	double[] xL1={8,5,1,5,5,20};
	GraphicalView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lineView();  
        }
  //����ͼ
  	public void lineView(){
  		//ͬ������Ҫ����dataset����ͼ��Ⱦ��renderer
  		XYMultipleSeriesDataset mDataset = new XYMultipleSeriesDataset();
  		XYSeries series = new XYSeries("��һ����");    //����ÿ���ߵ����ƴ��� 
          for (int i = 0; i < 6; i++) 
          { 
              series.add(i, xL[i]);
          }
          mDataset.addSeries(series);
//      	XYSeries series1 = new XYSeries("�ڶ�����");    //����ÿ���ߵ����ƴ��� 
//        for (int i = 0; i < 6; i++) 
//        { 
//            series1.add(i, xL1[i]);
//        }
//          mDataset.addSeries(series1);
  		XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
  		//����ͼ���X��ĵ�ǰ����
  		mRenderer.setOrientation(XYMultipleSeriesRenderer.Orientation.HORIZONTAL);
  		mRenderer.setXTitle("����");//����ΪX��ı���
  		mRenderer.setYTitle("�۸�");//����y��ı���
  		mRenderer.setAxisTitleTextSize(20);//����������ı���С
  		mRenderer.setChartTitle("�۸�����ͼ");//����ͼ�����
  		mRenderer.setChartTitleTextSize(30);//����ͼ��������ֵĴ�С
  		mRenderer.setLabelsTextSize(18);//���ñ�ǩ�����ִ�С
  		mRenderer.setLegendTextSize(20);//����ͼ���ı���С
  		mRenderer.setPointSize(10f);//���õ�Ĵ�С
  		mRenderer.setYAxisMin(0);//����y����Сֵ��0
  		mRenderer.setYAxisMax(15);
  		mRenderer.setYLabels(20);//����Y��̶ȸ�����ò�Ʋ�̫׼ȷ��
  		mRenderer.setXAxisMax(10);
  		mRenderer.setShowGrid(true);//��ʾ����
  		//��x��ǩ��Ŀ��ʾ�磺1,2,3,4�滻Ϊ��ʾ1�£�2�£�3�£�4��
  		 for (int i = 0; i < 6; i++) 
         { 
//             XYSeries series2 = new XYSeries("");    //����ÿ���ߵ����ƴ��� 
             mRenderer.addXTextLabel(i, yL[i]);
         }
  		mRenderer.setXLabels(0);//����ֻ��ʾ��1�£�2�µ��滻��Ķ���������ʾ1,2,3��
  		mRenderer.setMargins(new int[] { 20, 30, 15, 20 });//������ͼλ��
        
  		XYSeriesRenderer r = new XYSeriesRenderer();//(������һ���߶���)
          r.setColor(Color.BLUE);//������ɫ
          r.setPointStyle(PointStyle.CIRCLE);//���õ����ʽ
          r.setFillPoints(true);//���㣨��ʾ�ĵ��ǿ��Ļ���ʵ�ģ�
          r.setDisplayChartValues(true);//�����ֵ��ʾ����
          r.setChartValuesSpacing(10);//��ʾ�ĵ��ֵ��ͼ�ľ���
          r.setChartValuesTextSize(25);//���ֵ�����ִ�С
        //  r.setFillBelowLine(true);//�Ƿ��������ͼ���·�
        //  r.setFillBelowLineColor(Color.GREEN);//������ɫ����������þ�Ĭ�����ߵ���ɫһ��
          r.setLineWidth(3);//�����߿�
          mRenderer.addSeriesRenderer(r);
//          XYSeriesRenderer rTwo = new XYSeriesRenderer();//(������һ���߶���)
//          rTwo.setColor(Color.GRAY);//������ɫ
//          rTwo.setPointStyle(PointStyle.CIRCLE);//���õ����ʽ
//          rTwo.setFillPoints(true);//���㣨��ʾ�ĵ��ǿ��Ļ���ʵ�ģ�
//          rTwo.setDisplayChartValues(true);//�����ֵ��ʾ����
//          rTwo.setChartValuesSpacing(10);//��ʾ�ĵ��ֵ��ͼ�ľ���
//          rTwo.setChartValuesTextSize(25);//���ֵ�����ִ�С
//        //  rTwo.setFillBelowLine(true);//�Ƿ��������ͼ���·�
//        //  rTwo.setFillBelowLineColor(Color.GREEN);//������ɫ����������þ�Ĭ�����ߵ���ɫһ��
//          rTwo.setLineWidth(3);//�����߿�
//          mRenderer.addSeriesRenderer(rTwo);
          view = ChartFactory.getLineChartView(this, mDataset, mRenderer);
          view.setBackgroundColor(Color.BLACK);
          setContentView(view);
  	}
}
