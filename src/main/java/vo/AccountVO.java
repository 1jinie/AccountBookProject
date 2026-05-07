package vo;

import java.util.Calendar;
import java.util.Objects;

public class AccountVO {
    private int id;
    private String type;
    private int amount;
    private String description;
    private String category;
    private Calendar date;

    public AccountVO(int id, String type, int amount, String description, String category, Calendar date) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return id + "," + type + "," + amount + "," + description + "," + category + "," + date;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AccountVO accountVO = (AccountVO) o;
        return id == accountVO.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
