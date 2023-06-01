package Model.BEAN;

public class StageInformation {
    private String stageName;
    private String stageSeatingChart;
    public StageInformation(String stageName, String stageSeatingChart) {
        this.stageName = stageName;
        this.stageSeatingChart = stageSeatingChart;
    }
    public String getStageName() {
        return stageName;
    }
    public String getStageSeatingChart() {
        return stageSeatingChart;
    }
}
