package kz.one.lab.lesson4.entity;


import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "t_fighters")
public class Fighter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    String name = "Незванный Гость";

    @Column(name = "strength")
    int strength;

    @Column(name = "agility")
    int agility;

    @Column(name = "skill")
    int skill;

    public int getPowerLevel(){
        return strength+agility+skill;
    }

    @Override
    public String toString() {
        return "name_fighter " + name ;
    }
}


