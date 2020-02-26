package kz.one.lab.lesson4.entity;


import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_arenas")
public class Arena {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Setter
    @Column(name = "name")
    private String name;
    @Setter
    @OneToMany(fetch = FetchType.EAGER)
    List<Fighter> fighters;

}
