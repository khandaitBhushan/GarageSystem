package Entity;

public class Vehical {

    private int vehId;
    private int cusId;
    private String numberPlate;
    private String model;

    public int getVehId() {
        return vehId;
    }

    public int getCusId() {
        return cusId;
    }

    public void setVehId(int vehId) {
        this.vehId = vehId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public String getModel() {
        return model;
    }

    public Vehical(int vehId, int cusId, String numberPlate, String model) {
        this.vehId = vehId;
        this.cusId = cusId;
        this.numberPlate = numberPlate;
        this.model = model;
    }

    @Override
    public String toString() {
        return "[ " +
                "vehId=" + vehId +
                ", cusId=" + cusId +
                ", numberPlate='" + numberPlate + '\'' +
                ", model='" + model + '\'' +
                " ]";
    }
}
