package kz.one.lab.lesson4.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Component
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor


public class DTO_all_arena_figther {
    private DTO_Arena dtoArena  ;
    private DTO_Fighter dtoFighter ;


}
