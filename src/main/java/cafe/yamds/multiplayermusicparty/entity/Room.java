package cafe.yamds.multiplayermusicparty.entity;


public class Room {

  private long id;
  private String roomName;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;
  private String stats;
  private String placeholder1;
  private String placeholder2;
  private String placeholder3;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getRoomName() {
    return roomName;
  }

  public void setRoomName(String roomName) {
    this.roomName = roomName;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public java.sql.Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(java.sql.Timestamp updateTime) {
    this.updateTime = updateTime;
  }


  public String getStats() {
    return stats;
  }

  public void setStats(String stats) {
    this.stats = stats;
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
