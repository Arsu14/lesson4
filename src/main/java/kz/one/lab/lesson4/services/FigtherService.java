package kz.one.lab.lesson4.services;

import kz.one.lab.lesson4.entity.Arena;
import kz.one.lab.lesson4.entity.DTO_all_arena_figther;
import kz.one.lab.lesson4.entity.Fighter;

import java.util.List;

public interface FigtherService  {
    public List<Arena> FighterToArena(DTO_all_arena_figther DTO_obj);
    public List<Fighter> Add_To_fighter(Fighter fighter) ;

}
