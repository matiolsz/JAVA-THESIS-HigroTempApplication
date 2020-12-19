package pl.olszanka.HigroTempApplication.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    @ManyToOne
    private Room room;

    @JsonIgnore
    @OneToMany(mappedBy = "sensor")
    private List<Measurement> measurements;

    private String IP;

    public String getIP() {
        return IP;
    }

    public Sensor(Long id, String type, Room room, List<Measurement> measurements, String IP) {
        this.id = id;
        this.type = type;
        this.room = room;
        this.measurements = measurements;
        this.IP = IP;
    }

}