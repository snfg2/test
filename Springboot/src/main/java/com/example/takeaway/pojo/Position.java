package com.example.takeaway.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

@ToString
@Data
@Service
@NoArgsConstructor
@AllArgsConstructor
public class Position {
        private Integer id;
        private String gs;
        private Integer gongzi;
    private Integer gang;
    private String xzy;
        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getGs() {
            return gs;
        }

        public void setGs(String gs) {
            this.gs = gs;
        }

    public int getGang() {
        return gang;
    }

    public void setGang(int gang) {
        this.gang = gang;
    }

    public int getGongzi() {
        return gongzi;
    }

    public void setGongzi(int gongzi) {
        this.gongzi = gongzi;
    }

      public String getXzy() {
        return xzy;
    }

      public void setXzy(String xzy) {
        this.xzy = xzy;
    }
}
