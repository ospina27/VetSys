package project.vetsys.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.Map.entry;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import project.vetsys.dao.CitaDAO;
import project.vetsys.model.Cita;

public class BarGraph {
    
    private int idClinic;
    
    
    public static ChartPanel getChartPanel(int idClinic) {
        //Obtener datos y crear dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        CitaDAO citaDAO = new CitaDAO();
        List<Cita> citas = citaDAO.buscarCitasPorEstado(idClinic, "programada");
        
        Map<String, Integer> conteo = new HashMap<>();
        for (Cita c : citas) {
            conteo.merge(c.getNombreVeterinario(), 1, Integer::sum);
        }
        conteo.forEach((vet, num) -> dataset.addValue(num, "Citas Pendientes", vet));

        //Crear el gráfico
        JFreeChart bar = ChartFactory.createBarChart(
            "Citas por Veterinario", "Veterinario", "Cantidad", 
            dataset, PlotOrientation.VERTICAL, true, true, false
        );
        customizeBar(bar);  ///personalizar el grafico de barras 
        return new ChartPanel(bar);
    }
    
    
    ///dataset con la información de las citas
    private CategoryDataset dataset(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        CitaDAO citaDAO = new CitaDAO();
        
        List<Cita> appointment = citaDAO.buscarCitasPorEstado(this.idClinic, "programada");
        
        ///agrupar las citas por veterinario
        Map <String, Integer> count = new HashMap();
        for(Cita c : appointment){
            count.merge(c.getNombreVeterinario(),1,Integer::sum);
        }
        
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            dataset.addValue(entry.getValue(), "Citas Pendientes", entry.getKey());
        }
        return dataset;
    }    
    
    ///crear los reportes dependiente el caso
    public static ChartPanel createReport(int type, int idClinic) {
        CitaDAO dao = new CitaDAO();
        JFreeChart chart = null;
        String lecture = "";

        switch (type) {
            case 1: ///Reporte de Estado de las citas 
                DefaultPieDataset datasetStates = new DefaultPieDataset();
                dao.getGraphStatus(idClinic).forEach(datasetStates::setValue);
                chart = ChartFactory.createPieChart("Estado de Citas", datasetStates, true, true, false);
                customizePastel(chart); ///perzonalizar grafico de pastel
                lecture = "ANALISIS: Mide el Ausentismo. Un alto número de citas Canceladas sugiere\n" +
                          "problemas en la confirmación de citas. Busque maximizar las Realizadas";
                break;

            case 2: ///Reporte de Horarios mas frecuentes
                DefaultCategoryDataset datasetHours = new DefaultCategoryDataset();
                dao.getGraphHour(idClinic).forEach((hora, cant) -> 
                    datasetHours.addValue(cant, "Citas", hora)
                );
                chart = ChartFactory.createBarChart("Horarios más frecuentes", "Hora", "Citas", 
                        datasetHours, PlotOrientation.VERTICAL, true, true, false);
                customizeBar(chart); ///personalizar grafico de barras
                lecture = "ESTRATEGIA: Identifica las horas pico. Refuerce el personal en estas horas\n" +
                          "para evitar retrasos y mejorar la atención.";
                break;

            case 3: ///Reporte de Fidelidad de clientes
                DefaultPieDataset datasetRetention = new DefaultPieDataset();
                dao.getGraphFidelity(idClinic).forEach(datasetRetention::setValue);
                chart = ChartFactory.createPieChart("Retención de Pacientes", datasetRetention, true, true, false);
                customizePastel(chart);
                lecture = "CLAVE DE RENTABILIDAD: Los clientes Recurrentes (>1 cita) son 60% más fáciles\n" +
                          "de vender que los Nuevos. Si la recurrencia es baja, mejore el seguimiento post-consulta.";                      
                break;   
            case 4:  ///Reporte de cantidad de mascotas por especie 
                DefaultPieDataset datasetEsp = new DefaultPieDataset();
                dao.getStatsSpecies(idClinic).forEach(datasetEsp::setValue);
                chart = ChartFactory.createPieChart("Distribución por Especies", datasetEsp, true, true, false);
                customizePastel(chart);
                lecture = "INVENTARIO: Ajuste su stock de medicamentos y alimentos según\nla especie predominante.";
                break;
            case 5: ///Reporte de los tipos de membresías 
                DefaultCategoryDataset datasetMem = new DefaultCategoryDataset();
                dao.getStatsMembership(idClinic).forEach((mem, cant) -> datasetMem.addValue(cant, "Socios", mem));
                chart = ChartFactory.createBarChart("Tipos de Membresía", "Plan", "Clientes", datasetMem, PlotOrientation.VERTICAL, true, true, false);
                customizeBar(chart);
                lecture = "INGRESOS: Si la mayoría tiene plan 'Básico', lance una campaña\nde 'Renovación' mostrando los beneficios del plan Premium.";
                break;
            case 6: ///Reporte de evolución de citas, para ver como se han asignado en el año
                DefaultCategoryDataset datasetTend = new DefaultCategoryDataset();
                dao.getStatsTendency(idClinic).forEach((mes, cant) -> datasetTend.addValue(cant, "Citas", mes));
                chart = ChartFactory.createLineChart("Evolución de Citas (Año Actual)", "Mes", "Cantidad", datasetTend, PlotOrientation.VERTICAL, true, true, false);
                // Personalización básica para líneas
                chart.setBackgroundPaint(Color.WHITE);
                chart.getCategoryPlot().setBackgroundPaint(Color.WHITE);
                chart.getCategoryPlot().setRangeGridlinePaint(Color.LIGHT_GRAY);
                lecture = "CRECIMIENTO: Monitoree la caída en meses específicos para\npreparar promociones anticipadas.";
                break;
            case 7:  ///Reporte de fidelización adicional de clientes a los que mas se les agendan citas
                DefaultCategoryDataset datasetTop = new DefaultCategoryDataset();
                dao.getStatsTopClients(idClinic).forEach((cli, cant) -> datasetTop.addValue(cant, "Visitas", cli));
                chart = ChartFactory.createBarChart("Top 5 Clientes VIP", "Cliente", "Visitas", datasetTop, PlotOrientation.HORIZONTAL, true, true, false);
                customizeBar(chart);
                lecture = "FIDELIZACIÓN: Estos son sus clientes más valiosos.\nConsidere darles un trato preferencial o descuentos exclusivos.";
                
                break;
            default:
                return null;
        }
        
        ///mostrar explicacion en el grafico, de cada reporte
        if (chart != null && !lecture.isEmpty()) {
            TextTitle leyenda = new TextTitle(lecture);
            leyenda.setFont(new Font("Arial", Font.ITALIC, 12));
            leyenda.setPaint(Color.DARK_GRAY);
            leyenda.setPosition(org.jfree.chart.ui.RectangleEdge.BOTTOM); // Ubicar en una posicion al lado del grafico
            leyenda.setTextAlignment(org.jfree.chart.ui.HorizontalAlignment.CENTER);
            chart.addSubtitle(leyenda);
        }
        return new ChartPanel(chart);
    }
    
    private static void customizeBar(JFreeChart chart) {
        // Fondo blanco
        chart.setBackgroundPaint(Color.WHITE);
        
        CategoryPlot plot = chart.getCategoryPlot();
        org.jfree.chart.axis.NumberAxis rangeAxis = (org.jfree.chart.axis.NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(org.jfree.chart.axis.NumberAxis.createIntegerTickUnits());
        rangeAxis.setTickUnit(new org.jfree.chart.axis.NumberTickUnit(1)); //eje y de 1 en 1 
        plot.setBackgroundPaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.LIGHT_GRAY); // Líneas de guía suaves
        
        // Personalizar las barras
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(0, 153, 153)); ///escoger color
        renderer.setDrawBarOutline(false);
        
        // Mostrar numeros sobre las barras
        renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setDefaultItemLabelsVisible(true);
        renderer.setDefaultItemLabelFont(new Font("SansSerif", Font.BOLD, 12));
    }

    // Estilo para gráficos de Pastel
    private static void customizePastel(JFreeChart chart) {
        chart.setBackgroundPaint(Color.WHITE);
        
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setOutlineVisible(false); // Quitar borde feo del círculo
        
        ///Etiquetas
        ///Nombre y valor (Porcentaje)
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator(
            "{0} = {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%")
        ));
        
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 11));
        plot.setLabelBackgroundPaint(new Color(240, 240, 240)); // Fondo suave en la etiqueta
    }
}
