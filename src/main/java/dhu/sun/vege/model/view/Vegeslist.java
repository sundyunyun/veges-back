package dhu.sun.vege.model.view;

import dhu.sun.vege.entity.Type;
import dhu.sun.vege.entity.Veges;

/**
 * Created by think on 2018/4/23.
 */
public class Vegeslist {
    private Veges veges;
    private Type type;

    public Veges getVeges() {
        return veges;
    }

    public void setVeges(Veges veges) {
        this.veges = veges;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
