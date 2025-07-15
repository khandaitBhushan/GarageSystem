package Entity;

public class Invoice {
    int invId;
    int cusId;
    int serId;
    int vehId;

    public Invoice(int invId, int cusId, int serId, int vehId) {
        this.invId = invId;
        this.cusId = cusId;
        this.serId = serId;
        this.vehId = vehId;
    }

    public int getInvId() {
        return invId;
    }

    public int getCusId() {
        return cusId;
    }

    public int getSerId() {
        return serId;
    }

    public int getVehId() {
        return vehId;
    }

    public void setInvId(int invId) {
        this.invId = invId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public void setSerId(int serId) {
        this.serId = serId;
    }

    public void setVehId(int vehId) {
        this.vehId = vehId;
    }

    @Override
    public String toString() {
        return "[ " +
                "invId=" + invId +
                ", cusId=" + cusId +
                ", serId=" + serId +
                ", vehId=" + vehId +
                " ]";
    }
}
