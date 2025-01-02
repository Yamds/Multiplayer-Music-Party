package cafe.yamds.multiplayermusicparty.entity;


public class User {

  private long id;
  private String username;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;
  private long status;
  private String placeholder1;
  private String placeholder2;
  private String placeholder3;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
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


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
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
