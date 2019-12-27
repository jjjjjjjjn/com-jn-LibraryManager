package com.jn.domain;

/**
 * @ClassName: Manager
 * @Package: com.jn.domain
 * @Description:
 * @author：jn
 * @date： 2019/11/28 15:58
 */
public class Manager {
    private long m_id;
    private String m_name;
    private String m_password;

    public String getM_password() {
        return m_password;
    }

    public void setM_password(String m_password) {
        this.m_password = m_password;
    }

    public Long getM_id() {
        return m_id;
    }

    public void setM_id(Long m_id) {
        this.m_id = m_id;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "m_id='" + m_id + '\'' +
                ", m_name='" + m_name + '\'' +
                ", m_password='" + m_password + '\'' +
                '}';
    }
}
