package Model.BEAN.Analyst;

public class Statistic {
    String type;
    int revenue;

    public Statistic(String type, int revenue) {
        this.type = type;
        this.revenue = revenue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

}
