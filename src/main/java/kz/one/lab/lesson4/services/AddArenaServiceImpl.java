package kz.one.lab.lesson4.services;

import kz.one.lab.lesson4.entity.Arena;

import kz.one.lab.lesson4.repositories.ArenaRepository;
import kz.one.lab.lesson4.repositories.FighterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Service
public class AddArenaServiceImpl implements AddArenaService {

    @Autowired
    ArenaRepository arenaRepository ;

    @Autowired
    FighterRepository fighterRepository;

    @Autowired
    Arena arena;

    @Override
    public List<Arena> addArena(Long id, String name) {
        Arena  arena_add = new Arena( null , name , null) ;
        arenaRepository.save(arena_add) ;
        List<Arena> arenaALl = arenaRepository.findAll();
        return arenaALl ;
    }

    @Override
    public List<Arena> deleteArena(Long id, String name) {
        arenaRepository.deleteById(id);
        List<Arena> arenaALl = arenaRepository.findAll();
        return arenaALl ;
    }
}
