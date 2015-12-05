package businesslogic;

import businesslogic.statistic.ChartOutput;
import org.junit.Test;
import vo.BusinessStateChartVO;

/**
 * Created by kylin on 15/12/3.
 */
public class ChartOutPut_Test {

    @Test
    public void testOutPut(){
        ChartOutput chartOutput = new ChartOutput();
        BusinessStateChartVO vo = new BusinessStateChartVO("2015-12-20","2015-12-30");
        chartOutput.exportChart(vo,"/Users/kylin/Documents/");
    }
}
