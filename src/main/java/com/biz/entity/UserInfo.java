package com.biz.entity;

import java.math.BigDecimal;

/**
 * @table user_info
 */
public class UserInfo {
    /** id：主键 */
    private Integer id;

    /** real_name：用户姓名 */
    private String realName;

    /** id_card：用户身份证号 */
    private String idCard;

    /** address：用户地址 */
    private String address;

    /** sex：1-男; 0-女 */
    private Integer sex;

    /** phone：用户电话 */
    private String phone;

    /** money：用户借款金额 */
    private BigDecimal money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}