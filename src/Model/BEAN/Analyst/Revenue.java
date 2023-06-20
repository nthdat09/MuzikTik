package Model.BEAN.Analyst;

public class Revenue {
    String day;
    String month;
    String year;
    String event;
    String statisticType;

    public Revenue(String day, String month, String year, String event, String statisticType) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.event = event;
        this.statisticType = statisticType;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getStatisticType() {
        return statisticType;
    }

    public void setStatisticType(String statisticType) {
        this.statisticType = statisticType;
    }

public String toString() {
        return "Revenue{" +
                "day='" + day + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                ", event='" + event + '\'' +
                ", statisticType='" + statisticType + '\'' +
                '}';
    }
}
