package models;

import java.sql.Date;

public class Reservation {
    private int pnr;
    private int userId;
    private String trainNumber;
    private String trainName;
    private String classType;
    private Date dateOfJourney;
    private String fromPlace;
    private String toPlace;

    public Reservation() {}

    public int getPnr() { return pnr; }
    public void setPnr(int pnr) { this.pnr = pnr; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getTrainNumber() { return trainNumber; }
    public void setTrainNumber(String trainNumber) { this.trainNumber = trainNumber; }

    public String getTrainName() { return trainName; }
    public void setTrainName(String trainName) { this.trainName = trainName; }

    public String getClassType() { return classType; }
    public void setClassType(String classType) { this.classType = classType; }

    public Date getDateOfJourney() { return dateOfJourney; }
    public void setDateOfJourney(Date dateOfJourney) { this.dateOfJourney = dateOfJourney; }

    public String getFromPlace() { return fromPlace; }
    public void setFromPlace(String fromPlace) { this.fromPlace = fromPlace; }

    public String getToPlace() { return toPlace; }
    public void setToPlace(String toPlace) { this.toPlace = toPlace; }
}
