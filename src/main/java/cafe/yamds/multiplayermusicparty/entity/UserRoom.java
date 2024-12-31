package cafe.yamds.multiplayermusicparty.entity;


public class UserRoom {

  private long userId;
  private long roomId;
  private java.sql.Timestamp joinTime;
  private String placeholder1;
  private String placeholder2;
  private String placeholder3;


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public long getRoomId() {
    return roomId;
  }

  public void setRoomId(long roomId) {
    this.roomId = roomId;
  }


  public java.sql.Timestamp getJoinTime() {
    return joinTime;
  }

  public void setJoinTime(java.sql.Timestamp joinTime) {
    this.joinTime = joinTime;
  }


  public String getPlaceholder1() {
    return placeholder1;
  }

  public void setPlaceholder1(String placeholder1) {
    this.placeholder1 = placeholder1;
  }


  public String getPlaceholder2() {
    return placeholder2;
  }

  public void setPlaceholder2(String placeholder2) {
    this.placeholder2 = placeholder2;
  }


  public String getPlaceholder3() {
    return placeholder3;
  }

  public void setPlaceholder3(String placeholder3) {
    this.placeholder3 = placeholder3;
  }

}
