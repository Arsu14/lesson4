package kz.one.lab.lesson4.services;

import kz.one.lab.lesson4.entity.Arena;
import kz.one.lab.lesson4.entity.DTO_all_arena_figther;
import kz.one.lab.lesson4.entity.Fighter;
import kz.one.lab.lesson4.repositories.ArenaRepository;
import kz.one.lab.lesson4.repositories.FighterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FighterServiceImpl implements FigtherService {


    @Autowired
    ArenaRepository arenaRepository ;

    @Autowired
    FighterRepository fighterRepository;

    @Autowired
    Arena arena;

    @Override
    public List<Arena> FighterToArena(DTO_all_arena_figther DTO_obj) {
        Arena arena1 = arenaRepository.findById(DTO_obj.getDtoArena().getArena().getId()).get();
        Fighter fighter1 = fighterRepository.findById(DTO_obj.getDtoFighter().getFighter().getId()).get() ;

        List<Fighter> fighters =arena1.getFighters();
        // arena1.setFighters(fighters);
        fighters.add(fighter1);
        arena1.setFighters(fighters);
        arenaRepository.save(arena1) ;
        List<Arena> arenaALl = arenaRepository.findAll();
        return arenaALl ;
    }

    @Override
    public List<Fighter> Add_To_fighter(Fighter fighter) {
        fighterRepository.save(fighter);
        List<Fighter> fighters = fighterRepository.findAll();
        return fighters;
    }

}
