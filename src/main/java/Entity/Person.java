package Entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: shushkov
 * Date: 02.12.14
 * Time: 9:53
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="TelefonView")
public class Person {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID")
    private String ID;
    @Column(name="ТелефонКод")
    private String telefonNum;
    @Column(name="ФИО")
    private String FIO;
    @Column(name="Номер_кабинета")
    private String room;
    @Column(name="Должность")
    private String profsession;
    @Column(name="Отдел")
    private String otdel;
    @ManyToOne
    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getOtdel() {
        return otdel;
    }

    public void setOtdel(String otdel) {
        this.otdel = otdel;
    }

    public String getProfsession() {
        return profsession;
    }

    public void setProfsession(String profsession) {
        this.profsession = profsession;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getTelefonNum() {
        return telefonNum;
    }

    public void setTelefonNum(String telefonNum) {
        this.telefonNum = telefonNum;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        String result = (new StringBuilder())
                .append(this.getTelefonNum())
                .append(this.getFIO())
                .append(this.getRoom())
                .append("\n")
                .toString();
        return result;
    }

}
